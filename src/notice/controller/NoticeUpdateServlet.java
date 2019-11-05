package notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.NoticeFiles;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/no.up")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지 수정 처리용 서블릿
		
		
		
		//1.인코팅 처리
		request.setCharacterEncoding("utf-8");
		RequestDispatcher view = null;
		//2.멀티파트 방식으로 왔는지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form 태그에 enctype 속성 사용이 안됨. 멀티파트 전송방식이 아닙니다!");
			view.forward(request, response);
		}
		
		
		//3. 업로드할 용량 설정
		
		int maxSize = 1024*1024*50;
		//4. 저장할 경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles");
		//5. request 를 multipartrequest로 바꿈
		MultipartRequest mrequest = 
				new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		//--전달 받은 현재 페이지
		int currentPage = Integer.parseInt(mrequest.getParameter("page"));
	
		//6. 전송온 값이 많으니 객체에 저장하기
		Notice notice = new Notice();
		notice.setNoticeTitle(mrequest.getParameter("title"));
		notice.setNoticeDate(Date.valueOf(mrequest.getParameter("date")));
		notice.setNoticeContents(mrequest.getParameter("doccontent"));
		int nNo = Integer.parseInt(mrequest.getParameter("no"));
		notice.setNoticeNo(nNo);
		notice.setNoticeWriter(mrequest.getParameter("writer"));
		
		NoticeService nservice = new NoticeService();
		int noticeInsertResult = nservice.updateNotice(notice);
		
		ArrayList<String> oldlist = new ArrayList<String>();
		for(int i = 1; i < 6 ;i++) {
			String hiddenfile = mrequest.getParameter("hiddenfile"+i);
			if(hiddenfile != null && !hiddenfile.equals("첨부파일 없음")) {
				System.out.println("hiddenfile != null && !hiddenfile.equals(첨부파일 없음)는 true!!!");
				oldlist.add(hiddenfile);			
			}
		}
		ArrayList<NoticeFiles> nflist = nservice.selectFile(nNo);
		if(oldlist.size() > 0 && nflist.size() > 0) {
			for(String hiddenfile : oldlist) {
				for(int i = 0; i < nflist.size(); i++) {
					//히든 태그에서 온 기존의 파일과 디비에 있던 원래 이름이 같다면
					if(hiddenfile.equals(nflist.get(i).getNoticeOriginalFileName())) {
						nflist.remove(i);//제거해라
					}
				}//히든의 값이랑 디비의 값이랑 같은거 빼서 이제 수정한 파일만 남은
			}
		}
		for(NoticeFiles nf:nflist) {
			String renameFileName = nf.getNoticeRnameFileName();
			if(renameFileName != null) {
				String savePath2 = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles");
				File renameFile = new File(savePath2+"\\"+renameFileName);
				renameFile.delete();
				nservice.deleteFile(renameFileName);
			}
		}
		//파일 업데이트
		NoticeFiles pnfile = new NoticeFiles();
		
		Enumeration noticeFile = mrequest.getFileNames();
		
		while(noticeFile.hasMoreElements()) {
			String File = (String)noticeFile.nextElement();
			String originalFileName = mrequest.getFilesystemName(File);
			
			if(originalFileName != null) {
				File files = mrequest.getFile(File);
				double fileFullSize = (Math.round((double) files.length() / 1024 / 1024 * 1000) / 1000.0);
				String fileSize = String.valueOf(fileFullSize)+"MB";
				
				pnfile.setNoticeFileSize(fileSize);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String renameFileName=sdf.format(new java.sql.Date(System.currentTimeMillis()))// (밀리세컨드 롱형 정수로 리턴하는 메소드)
				+"."+ originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				
				
				File originFile = new File(savePath +"\\"+originalFileName);
				File renameFile = new File(savePath +"\\"+renameFileName);
				
				if(!originFile.renameTo(renameFile)) {
					int read = -1;
					byte[] buf = new byte[1024];
					
					FileInputStream fin = new FileInputStream(originFile);
					FileOutputStream fout = new FileOutputStream(renameFile);
					
					while((read = fin.read(buf, 0, buf.length)) != -1) {
						fout.write(buf, 0, read);
					}
					fin.close();
					fout.close();
					originFile.delete();
				}
				pnfile.setNoticeOriginalFileName(originalFileName);
				pnfile.setNoticeRnameFileName(renameFileName);
				
				nservice.insertNoticeFile(nNo, pnfile);
			}
			
		}
		
		
		
/*		if(originalFileName != null) {
			notice.setNoticeOriginalFileName(originalFileName);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String renameFileName=sdf.format(new java.sql.Date(System.currentTimeMillis()))// (밀리세컨드 롱형 정수로 리턴하는 메소드)
			+"."+ originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		
			//파일명을 바꾸려면 File 객체의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath +"\\"+renameFileName);
			
			if(!originFile.renameTo(renameFile)) {//실패한경우
				//파일 입출력 스트림 생성하고, 원본을 읽어서 바꿀이름 파일에 기록함
				int read = -1;
				//한번에 1kbyte읽겟당
				byte[] buf = new byte[1024];//한번에 읽어서 저장할 바이트 배열
				FileInputStream fin = new FileInputStream(originFile);//doget메소드는 시그니쳐 보면 IOException throws처리 되어 있음~
				FileOutputStream fout = new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1) {//언제까지 읽을지 모르니께
					fout.write(buf, 0 ,read);//read사이즈만큼 읽어서 buf에 기록해라
					
				}
				fin.close();
				fout.close();
				originFile.delete();//원본 파일 삭제함.
				
				//이렇게 해서 파일이름이 중복이 되는 작업을 막기 위해서 시분초 작업을 할수 있겠당
			}//renameTo()
			notice.setNoticeRenameFileName(renameFileName);//이름바꾸기가 성공 했을 때 
			//수정해서 새로운 첨부파일이 업로드 되었다면, 이전 파일을 찾아서 삭제함.//새로운 파일이 있다면****
			new File(savePath+"\\"+mrequest.getParameter("rfile")).delete();
			
		}else {//첨부파일 변경이 없을 때는 기존의 파일명을 notice에 기록해야함
			notice.setNoticeOriginalFileName(mrequest.getParameter("ofile"));
			notice.setNoticeRenameFileName(mrequest.getParameter("rfile"));
			
		}
		
		//6. 모델 서비스로 전달하고, 결과 받기
		int result = new NoticeService().updateNotice(notice);
		//7. 받은 결과로 성공 실패 페이지 내보내기
		 * 
		 * 
		 * */
		if(noticeInsertResult > 0) {//성공하면 목록으로 이동되고 최신 글이 상단에 올라온다
			response.sendRedirect("/hiapt/no.view?uporview=admin&nno="+nNo+"&page="+currentPage);
			
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message",nNo+"번 공지글 수정 실패!");
			view.forward(request, response);
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

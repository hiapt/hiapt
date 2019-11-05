package notice.controller;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/no.in")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공지사항 등록 서블릿
		
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form 태그에 enctype 속성 사용이 안됨. 멀티파트 전송방식이 아닙니다!");
			view.forward(request, response);
		}
		int maxSize = 1024*1024*10*5;
		String savePath = request.getSession().getServletContext().getRealPath("/resources/notice_upfiles");
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Notice notice = new Notice();
		notice.setNoticeTitle(mrequest.getParameter("title"));
		notice.setNoticeWriter(mrequest.getParameter("writer"));
		notice.setNoticeDate(Date.valueOf(mrequest.getParameter("date")));
		notice.setNoticeContents(mrequest.getParameter("doccontent"));
		
		NoticeService nservice =  new NoticeService();
		int insertNoticeResult = nservice.insertNotice(notice);
		int nNo = nservice.selectLastNoticeNo();
		
		NoticeFiles noticeFile = new NoticeFiles();
		
		Enumeration e = mrequest.getFileNames();
	
		while(e.hasMoreElements()) {
			String File = (String)e.nextElement(); //name속성이름
			String originalFileName = mrequest.getFilesystemName(File);				
						
			if(originalFileName !=null) {
				
				File files = mrequest.getFile(File); //이메소드는 객체를 뽑아내기때문에 이름이 바뀐뒤하면안된다 리네임전에실행						
				double fileS = (Math.round((double)files.length() / 1024/1024*1000)/1000.0);
				String fileSize = String.valueOf(fileS)+"MB";					
				noticeFile.setNoticeFileSize(fileSize); //파일 사이즈 저장
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); // 밀리초단위까지
				String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()))
						+"."+ originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				
				//파일명 바꾸기 : File 객체의 renameTo()사용
				File originFile = new File(savePath+"\\"+originalFileName);
				File renameFile = new File(savePath+"\\"+renameFileName);
				
				//파일 이름바꾸기 실행함 >> 실패한 경우에는 직접 바꾸기함
				if(!originFile.renameTo(renameFile)) {
					//파일 입출력 스트림 생성하고, 원본을 읽어서 바꿀이름 파일에 기록함
					int read =-1;
					byte[] buf=new byte[1024]; //한 번에 읽어서 저장할 바이트 배열
					
					FileInputStream fin = new FileInputStream(originFile);
					FileOutputStream fout = new FileOutputStream(renameFile);
					
					while((read =fin.read(buf,0,buf.length)) !=-1) {
						fout.write(buf, 0, read);
					}
					fin.close();
					fout.close();
					originFile.delete(); //원본파일 삭제
				}//renameTo() 완료
				noticeFile.setNoticeOriginalFileName(originalFileName);
				noticeFile.setNoticeRnameFileName(renameFileName);
								
				nservice.insertNoticeFile(nNo,noticeFile);
				
			}//original이 null이아닐경우
		}//파일이 있을경우 while문 종료
		if(insertNoticeResult > 0) {
			response.sendRedirect("/hiapt/no.list");
		}else {
			view = request.getRequestDispatcher("views/common/user404.jsp");
			request.setAttribute("message", "게시판 등록 실패!");
			view.forward(request, response);
		}
		
		
		
		//업로드된 첨부파일명 추출해서 해당 필드에 기록
/*		String originalFileName = mrequest.getFilesystemName("file[]");
		notice.setNoticeOriginalFileName(originalFileName);
		
		if(originalFileName != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()))
						+"."+originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			
			File originFile = new File(savePath+"\\"+originalFileName);
			File renameFile = new File(savePath+"\\"+renameFileName);
			
			if(!originFile.renameTo(renameFile)) {
				int read = -1;
				byte[] buf = new byte[1024];
				FileInputStream fin = new FileInputStream(originFile);//읽을거야
				FileOutputStream fout = new FileOutputStream(renameFile);//기록할거야
				
				
				while((read = fin.read(buf, 0, buf.length))!= -1) {
					fout.write(buf, 0, read);//버퍼에서0번 인덱스서부터 read가 받은 바이트 갯수 만큼을 꺼내서 기록함
				}
				fin.close();
				fout.close();
				originFile.delete();
			}
			notice.setNoticeOriginalFileName(originalFileName);
			notice.setNoticeRenameFileName(renameFileName);
			
		}
		int result = new NoticeService().insertNotice(notice);
		if(result > 0) {
			response.sendRedirect("/hiapt/no.list");
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "새 게시글 등록 실패");
			view.forward(request, response);
		}
		
		
		
*/		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

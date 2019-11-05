package complain.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

import board.model.vo.BoardFiles;
import complain.model.service.ComplainService;
import complain.model.vo.Complain;
import complain.model.vo.ComplainImgs;

/**
 * Servlet implementation class ComplainUpdateServlet
 */
@WebServlet("/co.update")
public class ComplainUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. multipart 방식으로 전송왔는지 확인함 : 아니면 에러 페이지 내보냄
				RequestDispatcher view = null;
				if(!ServletFileUpload.isMultipartContent(request)) {
					view = request.getRequestDispatcher("views/common/user404.jsp");
					request.setAttribute("message", "form enctype 속성이 multipart여야 합니다.");
					view.forward(request, response);
				}
				
				//2 업로드할 파일의 용량 제한 설정 : 다중파일일경우 각자가 아니라 한번에 포함시킨다. ex) 3+8 =11 => 11이상
				int maxSize= 1024 * 1024 *100; // 각각 20메가씩 100메가
				
				//3. 업로드한 파일이 저장도리 폴더 지정
				//"c:\\work\\savefiles" 해도됨
				//현재 서버 엔진(웹컨테이너)에서 실행되고 있는 에플리 케이션의 루트
				String savePath = request.getSession().getServletContext().getRealPath("/resources/complainImgs");
				
				//4. 파일업로드 실행함
				//cos.jar 는 MultipartRequest 클래스를 사용해서 request를 MultipartRequest로 바꿈
				MultipartRequest mrequest = new MultipartRequest(request, savePath,
						maxSize, "UTF-8", new DefaultFileRenamePolicy());
				//객체 생성과 동시에 파일 업로드 됨.
				//5. 전송온 값 꺼내서 객체에 저장하기
				Complain comp = new Complain();
				
				comp.setCompTitle(mrequest.getParameter("ctitle"));
				comp.setCompSecret(mrequest.getParameter("csecret"));
				comp.setCompContents(mrequest.getParameter("ccontent"));
				int cNo = Integer.parseInt(mrequest.getParameter("cno"));
				comp.setCompNo(cNo);
				
				ComplainService cservice = new ComplainService();
				int compResult = cservice.updateComplain(comp); //민원 게시판만 업데이트
				//////////////////////////////////////////////////////////////////////
				ArrayList<String> oldlist = new ArrayList<String>();
				for (int i = 1; i < 6; i++) {
					String hfile = mrequest.getParameter("hfile" + i);
					if (hfile != null && !hfile.equals("첨부이미지 없음"))
						oldlist.add(hfile);
				}

				ArrayList<ComplainImgs> cilist = cservice.selectImgs(cNo);
				if (oldlist.size() > 0 && cilist.size() > 0) {
					for (String hfile : oldlist) {
						for (int i=0; i<cilist.size(); i++) {
							if (hfile.equals(cilist.get(i).getCompOriginalImgname())) {
								cilist.remove(i);
							}//view에서 온 바뀌지않은파일 (hfile)과 기존의bf오리지날이름이 같지않을경우
						} // 중복되는 파일 arraylist에서 제거함 남은 것들은
					}
				}
				
				for(ComplainImgs ci : cilist) {//남은거 전부 제거한다(남은것들은 겹쳐서 2개씩생긴거거나 ..?)
				String renameFileName = ci.getCompRenameImgname();
				if (renameFileName != null) {
					String savePath2 = request.getSession().getServletContext()
							.getRealPath("/resources/complainImgs");
					File renameFile = new File(savePath2 + "\\" + renameFileName);
					renameFile.delete();
					cservice.deleteFile(renameFileName);
				}
				}
				
				/////////////////////////////////////////////////////////////////
				ComplainImgs cImg = new ComplainImgs();
				
				Enumeration compImgs= mrequest.getFileNames();
				
				while(compImgs.hasMoreElements()) {
					String File = (String)compImgs.nextElement(); //name속성이름
					String originalFileName = mrequest.getFilesystemName(File);				
								
					if(originalFileName !=null) {
						
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
						cImg.setCompOriginalImgname(originalFileName);
						cImg.setCompRenameImgname(renameFileName);
										
						cservice.insertComplainImg(cNo,cImg);
						
					}//original이 null이아닐경우
				}//파일이 있을경우 while문 종료
				if(compResult > 0) {
					response.sendRedirect("/hiapt/co.list");
				}else {
					view = request.getRequestDispatcher("views/common/user404.jsp");
					request.setAttribute("message", "민원 등록 실패!");
					view.forward(request, response);
				}
			}//메소드종료


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

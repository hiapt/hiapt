package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.BoardFiles;
import notice.model.service.NoticeService;
/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/bo.write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
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
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "form enctype 속성이 multipart여야 합니다.");
					view.forward(request, response);
				}
				
				//2 업로드할 파일의 용량 제한 설정 : 다중파일일경우 각자가 아니라 한번에 포함시킨다. ex) 3+8 =11 => 11이상
				int maxSize= 1024 * 1024 *150; // 각각 30메가씩 150메가
				
				//3. 업로드한 파일이 저장도리 폴더 지정
				//"c:\\work\\savefiles" 해도됨
				//현재 서버 엔진(웹컨테이너)에서 실행되고 있는 에플리 케이션의 루트
				String savePath = request.getSession().getServletContext().getRealPath("/resources/boardFiles");
				
				//4. 파일업로드 실행함
				//cos.jar 는 MultipartRequest 클래스를 사용해서 request를 MultipartRequest로 바꿈
				MultipartRequest mrequest = new MultipartRequest(request, savePath,
						maxSize, "UTF-8", new DefaultFileRenamePolicy());
				//객체 생성과 동시에 파일 업로드 됨.
				//5. 전송온 값 꺼내서 객체에 저장하기
				Board board = new Board();
				
				board.setBoardTitle(mrequest.getParameter("btitle"));
				board.setUserId(mrequest.getParameter("buserid"));
				board.setBoardContents(mrequest.getParameter("bcontent"));
				
				BoardService bservice = new BoardService();
				int boardResult = bservice.insertBoard(board); //보더 db에저장
				int bno = bservice.selectLastBno();//jdbc에선 curr을쓰면 conn에서 커넥션이끈겨
				//오라클 세션이끊긴다 그래서 bno조회하고나서 그번호로 파일인서트함.
				BoardFiles bFiles = new BoardFiles();
				
				Enumeration boardFile= mrequest.getFileNames();
				
				while(boardFile.hasMoreElements()) {
					String File = (String)boardFile.nextElement(); //name속성이름
					String originalFileName = mrequest.getFilesystemName(File);				
								
					if(originalFileName !=null) {
						
						File files = mrequest.getFile(File); //이메소드는 객체를 뽑아내기때문에 이름이 바뀐뒤하면안된다 리네임전에실행						
						double fileS = (Math.round((double)files.length() / 1024/1024*1000)/1000.0);
						String fileSize = String.valueOf(fileS)+"MB";					
						bFiles.setBoardFileSize(fileSize); //파일 사이즈 저장
						
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
						bFiles.setBoardOriginalFileName(originalFileName);
						bFiles.setBoardRnameFileName(renameFileName);
										
						bservice.insertBoardFile(bno,bFiles);
						
					}//original이 null이아닐경우
				}//파일이 있을경우 while문 종료
				if(boardResult > 0) {
					response.sendRedirect("/hiapt/bo.list");
				}else {
					view = request.getRequestDispatcher("views/common/user404.jsp");
					request.setAttribute("message", "게시판 등록 실패!");
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

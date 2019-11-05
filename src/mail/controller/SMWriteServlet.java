package mail.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mail.model.service.MailService;
import mail.model.vo.MailFileBox;
import mail.model.vo.Mailm;

/**
 * Servlet implementation class SMWriteServlet
 */
@WebServlet("/smwrite")
public class SMWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SMWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form 태그에 enctype 속성 사용 안 되었음.");
			view.forward(request, response);
		}

		// 업로드할 첨부파일의 용량 지정 : 10Mbyte 로 제한한다면
		int maxSize = 1024 * 1024 * 300;

		// 해당 웹 컨테이너의 구동 중인 웹 어플리케이션 안의 파일 저장 폴더 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/mail_upfiles");
		
		// 전송 온 request 를 MultipartRequest 로 바꿈 : 객체 생성
		// MultipartRequest 객체 생성이 성공하면, 자동 파일이 업로드됨
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		
		MailFileBox mfb = new MailFileBox();
		
		// 업로드된 첨부파일명 추출해서 해당 필드에 기록
		String originalFileName = mrequest.getFilesystemName("file");
		String renameFileName = null;
		// 첨부된 파일이 있다면, 파일명 바꾸기 처리
		// "yyyyMMddhhmmss.확장자" 형식으로 바꿈
		if (originalFileName != null) {
			// 바꿀 파일명에 대한 포맷 설정함
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			// 바꿀 파일명 만들기 : 확장자는 원본과 동일하게 함.
			renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
					+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			// 현재 지정된 폴더에 저장된 원본파일의 파일명을 바꾸기하기 위해서
			// File 객체를 생성함.
			File originFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath + "\\" + renameFileName);
		
			// 파일명 바꾸기 실행함 >> 실패할 경우에는 직접 바꾸기함.
			if (!originFile.renameTo(renameFile)) {
				// 저장 폴더 안에 새 파일을 만들고
				// >> 원본 파일을 읽어서 새 파일에 복사 기록함
				// >> 복사가 끝나면 원본 파일을 삭제함.
				int read = -1;
				byte[] buf = new byte[1024]; // 한 번에 읽을 배열 크기 지정

				// 대상 파일과 읽기 또는 쓰기용 스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				FileOutputStream fout = new FileOutputStream(renameFile);

				// 읽어서 복사 기록하기
				while ((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
					// buf 에서 0 번 인덱스부터 read 가 받은 바이트 갯수만큼 꺼내서
					// 기록함.
				} // 복사 완료됨

				// 스트림 반납
				fin.close();
				fout.close();
				// 저장 폴더에 있는 원본 파일 삭제함
				originFile.delete();
							
			} // renameTo() 실패시 처리 완료
		}
		Mailm mailm = new Mailm();
		mailm.setEmpEmail(mrequest.getParameter("email"));
		mailm.setMailTitle(mrequest.getParameter("title"));
		mailm.setMailContents(mrequest.getParameter("doccontent"));
		if (originalFileName != null) {
			mailm.setFileYN("Y");
		}
		
		MailService mservice = new MailService();
		int result = mservice.selfWriteMail(mailm);
		if (originalFileName != null) {
		int mailno = mservice.selectMailNo();
		int result1 = mservice.addFile(mailno, originalFileName, renameFileName);		
		}
		
		if(result > 0) {
			view = request.getRequestDispatcher("views/emp/mail/selfWriteSuccess.jsp");
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "메일쓰기 실패");
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

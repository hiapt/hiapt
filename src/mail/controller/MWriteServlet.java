package mail.controller;

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

import mail.model.service.MailService;
import mail.model.vo.MailFileBox;
import mail.model.vo.Mailm;

/**
 * Servlet implementation class MWriteServlet
 */
@WebServlet("/mwrite")
public class MWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form 태그에 enctype 속성 사용 안 되었음.");
			view.forward(request, response);
		}

		int maxSize = 1024 * 1024 * 300;

		String savePath = request.getSession().getServletContext().getRealPath("/resources/mail_upfiles");

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		
		MailFileBox mfb = new MailFileBox();

		String originalFileName = mrequest.getFilesystemName("file");
		String renameFileName = null;
		
		if (originalFileName != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
					+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

			File originFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath + "\\" + renameFileName);

			if (!originFile.renameTo(renameFile)) {

				int read = -1;
				byte[] buf = new byte[1024];

				FileInputStream fin = new FileInputStream(originFile);
				FileOutputStream fout = new FileOutputStream(renameFile);

				while ((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}

				fin.close();
				fout.close();

				originFile.delete();
			}
		}
		MailService mservice = new MailService();
		int result = 0; 
		int mailno = 0;
		
		Mailm mailm = new Mailm();
		if (originalFileName != null) {
			mailm.setFileYN("Y");
		}
		mailm.setEmpEmail(mrequest.getParameter("email"));
		
		mailm.setMailTitle(mrequest.getParameter("title"));
		mailm.setMailContents(mrequest.getParameter("doccontent"));
		String a = mrequest.getParameter("recipient");
		String[] b = a.split(",");
		for(int i = 0; i<b.length; i++) {
			mailm.setRecipient(b[i].trim());
			result = mservice.writeMail(mailm);
			if (originalFileName != null) {
				mailno = mservice.selectMailNo();
				result = mservice.addFile(mailno, originalFileName, renameFileName);
				}
				
				result = mservice.writeMailC(mailm);
				
				if (originalFileName != null) {
				mailno = mservice.selectMailNo();
				result = mservice.addFile(mailno, originalFileName, renameFileName);
				}
		}

		if (result > 0) {
			view = request.getRequestDispatcher("views/emp/mail/writeSuccess.jsp");
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "메일쓰기 실패");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package mail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.model.service.MailService;

/**
 * Servlet implementation class MoveMailBoxServlet
 */
@WebServlet("/mmbox")
public class MoveMailBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveMailBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MailService mservice = new MailService();
		int result = 0;
		
		String currentPage = request.getParameter("page");
		int code = Integer.parseInt(request.getParameter("code"));
		int mcode = Integer.parseInt(request.getParameter("mcode"));
		String email = request.getParameter("empemail");
		String a = request.getParameter("mailno");
		System.out.println(currentPage + "," + a + "," + code + "," + mcode + "," + email);
		String[] b = a.split(",");
		for(int i = 0; i < b.length; i++) {
		int mailno = Integer.parseInt(b[i]);	
		result = mservice.moveMailBox(mailno, mcode);
		}
		
		int i = 0;
		while(mcode != i) {
			i++;
		}
		response.sendRedirect("/hiapt/mlist?empemail="+email+"&page="+currentPage+"&mcode="+code);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

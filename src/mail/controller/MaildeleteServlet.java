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
 * Servlet implementation class MaildeleteServlet
 */
@WebServlet("/mdel")
public class MaildeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaildeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mailno = Integer.parseInt(request.getParameter("mailno"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		String code = request.getParameter("code");
		String email = request.getParameter("empemail");
		
		int result = new MailService().deleteMail(mailno);
		
		RequestDispatcher view = null;
		if(result > 0) {
			response.sendRedirect("/hiapt/wmlist?empemail=" + email + "&page=" + currentPage);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", mailno + "번 공지글 삭제 실패!");
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

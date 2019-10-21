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
 * Servlet implementation class MoveWaste
 */
@WebServlet("/movew")
public class MoveWasteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveWasteServlet() {
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
		
		int result = new MailService().moveWaste(mailno);
		
		if(result > 0) {
			if(code.equals("all"))
			response.sendRedirect("/hiapt/blist?page=" + currentPage + "&empemail=" + email);
			if(code.equals("receive"))
				response.sendRedirect("/hiapt/rlist?page=" + currentPage + "&empemail=" + email);
			if(code.equals("send"))
				response.sendRedirect("/hiapt/smlist?page=" + currentPage + "&empemail=" + email);
			if(code.equals("self"))
				response.sendRedirect("/hiapt/selfmlist?page=" + currentPage + "&empemail=" + email);
			//서블릿에서 서블릿 sendredirect
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", mailno + "번 글 수정 실패");
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

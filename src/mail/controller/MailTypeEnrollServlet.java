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
 * Servlet implementation class MailTypeEnrollServlet
 */
@WebServlet("/mtenroll")
public class MailTypeEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailTypeEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mbox = request.getParameter("mbox");
		String email = request.getParameter("empemail");
		
		int result = new MailService().enrollMailBox(mbox, email);
		
		if(result > 0) {
			response.sendRedirect("/hiapt/index.jsp");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/hiapt/views/error.jsp");
			request.setAttribute("message", " 페이지 목록 조회 실패!");
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

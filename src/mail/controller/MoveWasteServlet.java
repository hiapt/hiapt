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
		request.setCharacterEncoding("utf-8");
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		/*int mcode = Integer.parseInt(request.getParameter("mcode"));*/
		int code = Integer.parseInt(request.getParameter("code"));
		String email = request.getParameter("empemail");
		int result = 0;
		String[] array = request.getParameterValues("mailno");
		for(int i = 0; i < array.length; i++) {
			int mailno = Integer.parseInt(array[i]);
		result = new MailService().moveWaste(mailno);
		}
		if(result > 0) {
			response.sendRedirect("/hiapt/mlist?page=" + currentPage + "&empemail=" + email + "&mcode=" + code);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "글 수정 실패");
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

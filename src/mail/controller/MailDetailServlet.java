package mail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.model.service.MailService;
import mail.model.vo.MailFileBox;
import mail.model.vo.Mailm;

/**
 * Servlet implementation class MailDetailServlet
 */
@WebServlet("/mdetail")
public class MailDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailDetailServlet() {
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
		String allmail = request.getParameter("allmail");
		
		//3.
		MailService mservice = new MailService();
		Mailm mailm = mservice.selectOne(mailno);
		MailFileBox mbf = mservice.selectFileOne(mailno); 

		
		
		//4.
		RequestDispatcher view = null;
		if(mailm != null) {
				view = request.getRequestDispatcher("views/emp/mail/maildetail.jsp");
				request.setAttribute("mailm", mailm);
				request.setAttribute("mbf", mbf);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("code", code);
				request.setAttribute("allmail", allmail);
				view.forward(request, response);			
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", mailno + "번 게시글 상세조회 실패");
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

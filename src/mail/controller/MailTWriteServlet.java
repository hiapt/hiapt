package mail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.model.service.MailService;
import mail.model.vo.Mailm;

/**
 * Servlet implementation class MailTWriteServlet
 */
@WebServlet("/mtwrite")
public class MailTWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailTWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String code = request.getParameter("code");
		
		Mailm mailm = new Mailm();
		if(code.equals("write")) {
		
		
		mailm.setEmpEmail(request.getParameter("email"));
		mailm.setRecipient(request.getParameter("recipient"));
		mailm.setMailTitle(request.getParameter("title"));
		mailm.setMailContents(request.getParameter("doccontent"));
		}else if(code.equals("selfwrite")) {
			
		mailm.setEmpEmail(request.getParameter("email"));
		mailm.setRecipient(request.getParameter("email"));
		mailm.setMailTitle(request.getParameter("title"));
		mailm.setMailContents(request.getParameter("doccontent"));	
		}
		int result = new MailService().writeMailT(mailm);
		
		RequestDispatcher view = null;
		if(result > 0) {
			view = request.getRequestDispatcher("views/emp/mail/writeTSuccess.jsp");
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

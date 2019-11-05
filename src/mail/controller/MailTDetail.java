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
 * Servlet implementation class MailTDetail
 */
@WebServlet("/mtdetail")
public class MailTDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailTDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mailno = Integer.parseInt(request.getParameter("mailno"));
		
		Mailm mailm = new Mailm();
		MailService mservice = new MailService();
		mailm = mservice.selectOne(mailno);
		MailFileBox mbf = mservice.selectFileOne(mailno);
		
		RequestDispatcher view = null;
		if(mailm != null) {
			view = request.getRequestDispatcher("views/emp/mail/writemailT.jsp");
			request.setAttribute("mailm", mailm);
			request.setAttribute("mbf", mbf);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "메일쓰기 화면 실패!");
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

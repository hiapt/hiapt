package mail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.model.service.MailService;
import mail.model.vo.Mailm;

/**
 * Servlet implementation class MailListServlet
 */
@WebServlet("/mlist")
public class MailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("empemail");
		int mcode = Integer.parseInt(request.getParameter("mcode"));
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10;	
		MailService mservice = new MailService();
		
		int listCount = mservice.getListCount(email, mcode);
		
		int maxPage = listCount / limit;
		if(listCount % limit > 0)
			maxPage++;
		
		int beginPage = (currentPage / limit) * limit + 1;
		int endPage = beginPage + limit - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		int startRow = (currentPage * limit) - 9 ;
		int endRow = currentPage * limit;
		ArrayList<Mailm> list = mservice.selectList(email, mcode, startRow, endRow);

		RequestDispatcher view = null;
		if(list.size() >= 0) {
			if(mcode == 0) {
				view = request.getRequestDispatcher("views/emp/mail/allmail.jsp");
			}else if(mcode == 1) {
				view = request.getRequestDispatcher("views/emp/mail/receivemail.jsp");
			}else if(mcode == 2) {
				view = request.getRequestDispatcher("views/emp/mail/sendmail.jsp");
			}else if(mcode == 3) {
				view = request.getRequestDispatcher("views/emp/mail/temporarymail.jsp");
			}else if(mcode == 4) {
				view = request.getRequestDispatcher("views/emp/mail/selfmail.jsp");
			}else if(mcode == 5) {
				view = request.getRequestDispatcher("views/emp/mail/wastebasket.jsp");
			}
			request.setAttribute("list", list);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("mcode", mcode);
			view.forward(request, response);								
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", currentPage + " 페이지 목록 조회 실패!");
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

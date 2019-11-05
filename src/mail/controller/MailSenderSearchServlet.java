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
import mail.model.vo.MailBoxType;
import mail.model.vo.Mailm;

/**
 * Servlet implementation class MailSenderSearchServlet
 */
@WebServlet("/msenders")
public class MailSenderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSenderSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("empemail");
		String sender = request.getParameter("sender");
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10;	
		MailService mservice = new MailService();
		
		int listCount = mservice.getListCountSearchS(email, sender);

		int maxPage = listCount / limit;
		if(listCount % limit > 0)
			maxPage++;

		int beginPage = (currentPage / limit) * limit + 1;
		int endPage = beginPage + limit - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		int startRow = (currentPage * limit) - 9 ;
		int endRow = currentPage * limit;
		
		ArrayList<Mailm> list = mservice.selectListSearchS(email, sender, startRow, endRow);
		/*ArrayList<MailBoxType> list2 = mservice.selectMailBoxListAll(email);*/
		
		RequestDispatcher view = null;
		if(list.size() >= 0) {
			view = request.getRequestDispatcher("views/emp/mail/senderSearch.jsp");
			request.setAttribute("listCount", listCount);
			request.setAttribute("sender", sender);
			request.setAttribute("list", list);
			/*request.setAttribute("list2", list2);*/
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
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

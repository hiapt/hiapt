package vote.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.model.vo.Employee;
import vote.model.service.VoteService;
import vote.model.vo.Vote;
import vote.model.vo.VoteResult;

/**
 * Servlet implementation class VoteAdminViewServlet
 */
@WebServlet("/vo.ad.view")
public class VoteAdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteAdminViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int vNo = Integer.parseInt(request.getParameter("vno"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");
		
		VoteService vservice = new VoteService();
		vservice.updateReadCount(vNo);
		Vote vote = vservice.selectView(vNo);
		VoteResult voteResult = vservice.selectVoteResult(vNo);
		
		RequestDispatcher view = null;
		if(employee != null) { //직원이라면
		if(vote != null) {
			view = request.getRequestDispatcher("views/master/vote/voteAdminDetailView.jsp");
			request.setAttribute("vote", vote);
			request.setAttribute("voteresult", voteResult);
			request.setAttribute("currentPage", currentPage);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "상세조회 실패!");
		}
		view.forward(request, response);
		
		}else {//세대주라면..
			if(vote != null) {
				view = request.getRequestDispatcher("views/user/vote/voteDetailView.jsp");
				request.setAttribute("vote", vote);
				request.setAttribute("voteresult", voteResult);
				request.setAttribute("currentPage", currentPage);
			}else {
				view = request.getRequestDispatcher("views/common/user404.jsp");
				request.setAttribute("message", "상세조회 실패!");
			}
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

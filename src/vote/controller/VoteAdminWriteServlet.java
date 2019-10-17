package vote.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vote.model.service.VoteService;
import vote.model.vo.Vote;
import vote.model.vo.VoteResult;

/**
 * Servlet implementation class VoteAdminWriteServlet
 */
@WebServlet("/vo.ad.write")
public class VoteAdminWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteAdminWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Vote vote = new Vote();
		
		String vtitle = request.getParameter("vtitle");
		vote.setVoteTitle(vtitle);
		vote.setVoteWrite(request.getParameter("vwrite"));
		vote.setVoteFinalDate(java.sql.Date.valueOf(request.getParameter("vfinaldate")));
		vote.setVoteSecret(request.getParameter("vsecret"));
		vote.setVoteContents(request.getParameter("vcontent"));
		vote.setVoteOne(request.getParameter("vote1"));
		vote.setVoteTwo(request.getParameter("vote2"));
		vote.setVoteThree(request.getParameter("vote3"));
		vote.setVoteFour(request.getParameter("vote4"));
		vote.setVoteFive(request.getParameter("vote5"));
		
		int result =  new VoteService().insertVote(vote);
		
		if(result>0) {
			response.sendRedirect("/hiapt/vo.list");
		}else {
			RequestDispatcher view=request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "작성하기 저장실패");
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

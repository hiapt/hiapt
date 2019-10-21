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

/**
 * Servlet implementation class VoteAdminUpdateServlet
 */
@WebServlet("/vo.ad.update")
public class VoteAdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteAdminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Vote vote = new Vote();
		
		int voteNo = Integer.parseInt(request.getParameter("vrvoteno"));
		String voteTitle = request.getParameter("vrtitle");
		if(voteTitle.contains("(수정됨)")==false)
			voteTitle +="(수정됨)";

		String voteFinalDate = request.getParameter("vrfdate");
		String voteContent = request.getParameter("vrcontent");
		
		vote.setVoteNo(voteNo);
		vote.setVoteTitle(voteTitle);
		vote.setVoteFinalDate(java.sql.Date.valueOf(voteFinalDate));
		vote.setVoteContents(voteContent);
		
		int result =  new VoteService().updateVote(vote);
		
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

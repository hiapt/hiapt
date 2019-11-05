package vote.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vote.model.service.VoteService;
import vote.model.vo.VoteCheck;

/**
 * Servlet implementation class VoteResultPersonCheckServlet
 */
@WebServlet("/vo.vrpcheck")
public class VoteResultPersonCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteResultPersonCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int voteNo = Integer.parseInt(request.getParameter("voteno"));
		String voteSecret = request.getParameter("votesecret");
		ArrayList<VoteCheck> vclist = new VoteService().selectVoteCheck(voteNo);
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("views/master/vote/voteAdminResultPersonCheck.jsp");
		request.setAttribute("vclist", vclist);
		request.setAttribute("votesecret", voteSecret);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

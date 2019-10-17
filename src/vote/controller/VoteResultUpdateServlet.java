package vote.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import vote.model.service.VoteService;
import vote.model.vo.VoteResult;

/**
 * Servlet implementation class VoteResultUpdateServlet
 */
@WebServlet("/vo.vrUpdate")
public class VoteResultUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteResultUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int voteResultNo = Integer.parseInt(request.getParameter("voteresult"));
		int voteNo = Integer.parseInt(request.getParameter("voteno"));
		int voteCount = Integer.parseInt(request.getParameter("votecount"));
		VoteService vservice= new VoteService();
		vservice.updateVoteResult(voteNo,voteResultNo);

		VoteResult voteResult = vservice.selectVoteResult(voteNo);
		JSONObject job = new JSONObject();
		int vote1 = voteResult.getVoteOneResult();
		int vote2 = voteResult.getVoteTwoResult();
		int vote3 = voteResult.getVoteThreeResult();
		int vote4 = voteResult.getVoteFourResult();
		int vote5 = voteResult.getVoteFiveResult();

		job.put("vre1", voteResult.getVoteOneResult());
		job.put("vre2", voteResult.getVoteTwoResult());
		job.put("vre3", voteResult.getVoteThreeResult());
		job.put("vre4", voteResult.getVoteFourResult());
		job.put("vre5", voteResult.getVoteFiveResult());
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(job.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

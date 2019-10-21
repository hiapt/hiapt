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
		request.setCharacterEncoding("utf-8");
		int voteResultNo = Integer.parseInt(request.getParameter("voteresult"));
		int voteNo = Integer.parseInt(request.getParameter("voteno"));
		String userId = request.getParameter("userid");
		String vSecret = request.getParameter("vsecret");//유기명무기명 체크를하기위한 변수 dao에서판단.

		
		VoteService vservice= new VoteService();
		int doubleCheck = vservice.selectDoubleCheck(voteNo,userId);
		VoteResult voteResult=null;
		
		if(doubleCheck!=1) {//중복체크결과가 없을경우(이미투표했으면 1)

		vservice.insertDouBleCheck(voteNo,userId,voteResultNo,vSecret); //중복체크 인서트
		vservice.updateVoteResult(voteNo,voteResultNo);//투표결과 업데이트
		}
		voteResult = vservice.selectVoteResult(voteNo);//투표결과조회
		
		JSONObject job = new JSONObject();

		job.put("vre1", voteResult.getVoteOneResult());
		job.put("vre2", voteResult.getVoteTwoResult());
		job.put("vre3", voteResult.getVoteThreeResult());
		job.put("vre4", voteResult.getVoteFourResult());
		job.put("vre5", voteResult.getVoteFiveResult());
		job.put("dcheck", doubleCheck);
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

package maintenance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import maintenance.model.service.UserBillService;
import maintenance.model.vo.UserBill;

/**
 * Servlet implementation class userBillTop1Servelt
 */
@WebServlet("/ubtop1")
public class userBillTop1Servelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userBillTop1Servelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//고지서조회 최근1 조회 처리용 컨트롤러 : ajax 요청 처리
		ArrayList<UserBill> ulist = new UserBillService().selectTop1();
		System.out.println(" top 1 ulist : " + ulist);
		
		// 전송용 json 객체 생성
		JSONObject sendJson = new JSONObject();
		// list에 옮겨 저장할 json 배열 객체 생성
		JSONArray jarr = new JSONArray();
		
		// list을 jarr로 옮기기
		for(UserBill u : ulist) {
			// u를 저정할 Json 객체 생성
			JSONObject job = new JSONObject();
			job.put("merchantUid", u.getMerchantUid()); // view에서 받는 값이 key 값이다.
			// json에서 한글 깨짐 막으려면, java.net.URLEncoder.encode() 메소드로 인코딩 처리
			job.put("userId", URLEncoder.encode(u.getUserId(), "utf-8"));
			job.put("userName", URLEncoder.encode(u.getUserName(), "utf-8"));
			job.put("billYearMonth", u.getBillYearMonth().toString());
			job.put("cutoffDate", u.getCutoffDate().toString());
			job.put("amount", u.getAmount());			
			job.put("arrears", u.getArrears());
			job.put("arrearsFine", u.getArrearsFine());
			job.put("beforeAmount", u.getBeforeAmount());
			job.put("afterAmount", u.getAfterAmount());
			
			jarr.add(job);
		}
		
		// json 배열을 전송용 json 객체에 저장함
		sendJson.put("ulist", jarr);
		
		// 요청한 뷰로 응답처리함
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(sendJson.toJSONString());
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

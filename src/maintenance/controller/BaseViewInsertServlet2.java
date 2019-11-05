package maintenance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import maintenance.model.service.BaseViewService;
import maintenance.model.vo.BaseView;

/**
 * Servlet implementation class BaseViewInsertServlet
 */
@WebServlet("/bviin2")
public class BaseViewInsertServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseViewInsertServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// ajax 로 전송온 값 꺼내고, 문자열 보내기 컨트롤러 기초부과 컨트롤러
		String imposeStatus = request.getParameter("imposeStatus");	
		java.sql.Date billYearMonth = java.sql.Date.valueOf(request.getParameter("billYearMonth"));
		java.sql.Date calculateStartDay = java.sql.Date.valueOf(request.getParameter("calculateStartDay"));
		java.sql.Date calculateEndDay = java.sql.Date.valueOf(request.getParameter("calculateEndDay"));
		java.sql.Date imposeEndDate = java.sql.Date.valueOf(request.getParameter("imposeEndDate"));
		java.sql.Date cutoffDate = java.sql.Date.valueOf(request.getParameter("cutoffDate"));
		java.sql.Date acceptDate = java.sql.Date.valueOf(request.getParameter("acceptDate"));
		int imposeCount = Integer.parseInt(request.getParameter("imposeCount"));
		
		BaseView bview = new BaseView();
		bview.setImposeStatus(imposeStatus);
		bview.setBillYearMonth(billYearMonth);
		bview.setCalculateStartDay(calculateStartDay);
		bview.setCalculateEndDay(calculateEndDay);
		bview.setImposeEndDate(imposeEndDate);
		bview.setCutoffDate(cutoffDate);
		bview.setAcceptDate(acceptDate);
		bview.setImposeCount(imposeCount);
		System.out.println("bview: " + bview);

		int result = new BaseViewService().insertBaseView(bview);
		
		// 받은 결과 성공 실패 여부 확인 후 뷰를 선택해 내보내기
		if (result > 0) {
			//response.sendRedirect("/hiapt/bvis");
			ArrayList<BaseView> list = new BaseViewService().selectTop10();
			System.out.println("list sevlet: " + list);
			
			JSONObject sendJson = new JSONObject();
			JSONArray jarr = new JSONArray();
			
			for(BaseView b : list) {
				JSONObject job = new JSONObject();
				job.put("merchantUid", b.getMerchantUid());
				job.put("imposeStatus", URLEncoder.encode(b.getImposeStatus(), "utf-8"));
				job.put("billYearMonth", b.getBillYearMonth().toString());
				job.put("calculateStartDay", b.getCalculateStartDay().toString());
				job.put("calculateEndDay", b.getCalculateEndDay().toString());
				job.put("imposeEndDate", b.getImposeEndDate().toString());
				job.put("cutoffDate", b.getCutoffDate().toString());
				job.put("acceptDate", b.getAcceptDate().toString());
				job.put("imposeCount", b.getImposeCount());			
				
				jarr.add(job);					
			}
			sendJson.put("list", jarr);
			
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(sendJson.toJSONString());
			out.flush();
			out.close();			
			
		} else {
					RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "부과기초 등록 실패!");
					view.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

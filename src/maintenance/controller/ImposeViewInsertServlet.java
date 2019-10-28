package maintenance.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.ImposeViewService;
import maintenance.model.vo.ImposeView;

/**
 * Servlet implementation class ImposeViewInsertServlet
 */
@WebServlet("/imin")
public class ImposeViewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImposeViewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리비등록 처리 컨트롤러
		// 1. 전송온 값이 한글 있다면 인코딩 처리
		request.setCharacterEncoding("utf-8");
		/*if(cost.contains(",")){
	     cost = cost.replaceAll("\\,", "");
	     System.out.println("File"+cost);
	  	}*/
		//impose.setGeneralCost(Integer.parseInt(cost));
		
		// 2. 전송온 값 꺼내서 변수에 담기(갯수가 많으니, 객체로 받음)
		ImposeView impose = new ImposeView();
		
		impose.setUserId(request.getParameter("userid"));
		impose.setUserName(request.getParameter("username"));
		impose.setBillYearMonth(java.sql.Date.valueOf(request.getParameter("bill_year_month")));
		impose.setGeneralCost(Integer.parseInt(request.getParameter("general_cost").replaceAll("\\,", "")));
		impose.setGuardCost(Integer.parseInt(request.getParameter("guard_cost").replaceAll("\\,", "")));
		impose.setCleanCost(Integer.parseInt(request.getParameter("clean_cost").replaceAll("\\,", "")));
		impose.setDisinfectCost(Integer.parseInt(request.getParameter("disinfect_cost").replaceAll("\\,", "")));
		impose.setElevatorCost(Integer.parseInt(request.getParameter("elevator_cost").replaceAll("\\,", "")));
		impose.setRepairCost(Integer.parseInt(request.getParameter("repair_cost").replaceAll("\\,", "")));
		impose.setCommission(Integer.parseInt(request.getParameter("commission").replaceAll("\\,", "")));
		impose.setFireInsuranceCost(Integer.parseInt(request.getParameter("fireinsurance_cost").replaceAll("\\,", "")));
		impose.setElectricCost(Integer.parseInt(request.getParameter("electric_cost").replaceAll("\\,", "")));
		impose.setTvCost(Integer.parseInt(request.getParameter("tv_cost").replaceAll("\\,", "")));
		impose.setWaterCost(Integer.parseInt(request.getParameter("water_cost").replaceAll("\\,", "")));
		impose.setHeatingCost(Integer.parseInt(request.getParameter("heating_cost").replaceAll("\\,", "")));
		impose.setHwaterCost(Integer.parseInt(request.getParameter("hwater_cost").replaceAll("\\,", "")));
		impose.setAllElectricCost(Integer.parseInt(request.getParameter("allelectric_cost").replaceAll("\\,", "")));
		impose.setAllWaterCost(Integer.parseInt(request.getParameter("allwater_cost").replaceAll("\\,", "")));
		impose.setElectricUsage(Integer.parseInt(request.getParameter("electric_usage").replaceAll("\\,", "")));
		impose.setWaterUsage(Integer.parseInt(request.getParameter("water_usage").replaceAll("\\,", "")));
		impose.setHeatingUsage(Double.parseDouble(request.getParameter("heating_usage").replaceAll("\\,", "")));
		impose.setHwaterUsage(Double.parseDouble(request.getParameter("hwater_usage").replaceAll("\\,", "")));
		impose.setAmount(Integer.parseInt(request.getParameter("amount").replaceAll("\\,", "")));
		
		System.out.println("impose : " + impose);
		
		// 모델 서비스로 전달, 결과 받기
		int result = new ImposeViewService().insertImposeView(impose);
		
		
		// 받은 결과 성공 실패 여부 확인 후 뷰를 선택해 내보내기
		if(result > 0) {
			response.sendRedirect("/hiapt/bvis");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "관리비 금액 등록 실패!");
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

package maintenance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.BillService;
import maintenance.model.vo.Bill;

/**
 * Servlet implementation class BillUpdateServlet
 */
@WebServlet("/biup")
public class BillUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 고지서 수정용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		
		Bill bill = new Bill();
		
		bill.setMerchantUid(Long.parseLong(request.getParameter("merchant_uid")));
		bill.setUserId(request.getParameter("userid"));
		bill.setUserName(request.getParameter("username"));
		bill.setBillYearMonth(java.sql.Date.valueOf(request.getParameter("bill_year_month")));
		bill.setImposeStatus(request.getParameter("impose_status"));
		bill.setCalculateStartDay(java.sql.Date.valueOf(request.getParameter("calculate_start_day")));
		bill.setCalculateEndDay(java.sql.Date.valueOf(request.getParameter("calculate_end_day")));
		bill.setImposeEndDay(java.sql.Date.valueOf(request.getParameter("impose_end_date")));
		bill.setCutoffDate(java.sql.Date.valueOf(request.getParameter("cutoff_date")));
		bill.setAcceptDate(java.sql.Date.valueOf(request.getParameter("accept_date")));
		bill.setImposeCount(Integer.parseInt(request.getParameter("impose_count")));
		bill.setGeneralCost(Integer.parseInt(request.getParameter("general_cost").replaceAll("\\,", "")));
		bill.setGuardCost(Integer.parseInt(request.getParameter("guard_cost").replaceAll("\\,", "")));
		bill.setCleanCost(Integer.parseInt(request.getParameter("clean_cost").replaceAll("\\,", "")));
		bill.setDisinfectCost(Integer.parseInt(request.getParameter("disinfect_cost").replaceAll("\\,", "")));
		bill.setElevatorCost(Integer.parseInt(request.getParameter("elevator_cost").replaceAll("\\,", "")));
		bill.setRepairCost(Integer.parseInt(request.getParameter("repair_cost").replaceAll("\\,", "")));
		bill.setCommission(Integer.parseInt(request.getParameter("commission").replaceAll("\\,", "")));
		bill.setFireInsuranceCost(Integer.parseInt(request.getParameter("fireinsurance_cost").replaceAll("\\,", "")));
		bill.setElectricCost(Integer.parseInt(request.getParameter("electric_cost").replaceAll("\\,", "")));
		bill.setTvCost(Integer.parseInt(request.getParameter("tv_cost").replaceAll("\\,", "")));
		bill.setWaterCost(Integer.parseInt(request.getParameter("water_cost").replaceAll("\\,", "")));
		bill.setHeatingCost(Integer.parseInt(request.getParameter("heating_cost").replaceAll("\\,", "")));
		bill.setHwaterCost(Integer.parseInt(request.getParameter("hwater_cost").replaceAll("\\,", "")));
		bill.setAllElectricCost(Integer.parseInt(request.getParameter("allelectric_cost").replaceAll("\\,", "")));
		bill.setAllWaterCost(Integer.parseInt(request.getParameter("allwater_cost").replaceAll("\\,", "")));
		bill.setElectricUsage(Integer.parseInt(request.getParameter("electric_usage").replaceAll("\\,", "")));
		bill.setWaterUsage(Integer.parseInt(request.getParameter("water_usage").replaceAll("\\,", "")));
		bill.setHeatingUsage(Double.parseDouble(request.getParameter("heating_usage").replaceAll("\\,", "")));
		bill.setHwaterUsage(Double.parseDouble(request.getParameter("hwater_usage").replaceAll("\\,", "")));
		bill.setAmount(Integer.parseInt(request.getParameter("amount").replaceAll("\\,", "")));
		
		System.out.println("impose : " + bill);
		
		BillService bservice = new BillService();
		
		int result = bservice.updateBill(bill);
		
		RequestDispatcher view = null;
		if(result > 0) {
			response.sendRedirect("/hiapt/bvis");
	
		} else {
		view = request.getRequestDispatcher("views/common/error.jsp");
		request.setAttribute("message", "실패");
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

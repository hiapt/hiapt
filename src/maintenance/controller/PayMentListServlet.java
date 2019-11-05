package maintenance.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.UserBillService;
import maintenance.model.vo.UserBill;

/**
 * Servlet implementation class PayMentListServlet
 */
@WebServlet("/paylist")
public class PayMentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayMentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 결제를 위한 컨트롤러
		Long merchantUid = Long.parseLong(request.getParameter("merchantUid"));
		UserBill bill = new UserBillService().selectMerchant(merchantUid);
		
		RequestDispatcher view = null;
		if(bill != null) { // 성공하면 view로 보내고
			view = request.getRequestDispatcher("views/user/bill/kakaoapi.jsp");
			request.setAttribute("bill", bill);			
		} else { // 실패하면 error 페이지로 보내고
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "목록 조회 실패");				
		}
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

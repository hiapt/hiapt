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
 * Servlet implementation class BillListDetailViewServlet
 */
@WebServlet("/bidv")
public class BillListDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillListDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 고지서 상세보기
				long merchantUid = Long.parseLong(request.getParameter("merchantUid")); // 고지서 번호
				//int imposeCount = Integer.parseInt(request.getParameter("imposeCount")); // 마감횟수
				
				BillService billservice = new BillService();
				Bill bill = billservice.selectOne(merchantUid);
				billservice.updateImposeCount(merchantUid);
								
				RequestDispatcher view = null;
				if(bill != null) {
					view = request.getRequestDispatcher("views/emp/maintenance/BillListDetailView.jsp");
					request.setAttribute("bill", bill);
				} else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", merchantUid + "번 공지 상세보기 실패");
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

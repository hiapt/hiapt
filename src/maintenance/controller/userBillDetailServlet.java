package maintenance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.UserBillService;
import maintenance.model.vo.UserBill;

/**
 * Servlet implementation class userBillDetailServlet
 */
@WebServlet("/ubdt")
public class userBillDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userBillDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 고지서 출력용 컨트롤러
		long merchantUid = Long.parseLong(request.getParameter("merchantUid")); // 고지서 번호
		
		UserBill ubill = new UserBillService().selectOne(merchantUid);
		
		RequestDispatcher view = null;
		if(ubill != null) {
			view = request.getRequestDispatcher("views/user/bill/userBillDetailView.jsp");
			request.setAttribute("ubill", ubill);
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

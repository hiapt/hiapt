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
 * Servlet implementation class userBillListServlet
 */
@WebServlet("/ublist")
public class userBillListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userBillListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세대주 고지서 정보 조회 서블릿
		// 1. 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// 2. 변수 옮기기, 부과년월로 검색
		String months = request.getParameter("months");
		System.out.println("months : " + months);
		
		UserBillService ubservice = new UserBillService();
		ArrayList<UserBill> list = null;
		
		if (months != null) { // 부과년월 입력시
			System.out.println("months");
			
			int currentPage = 1; // 현재 보여지는 페이지
			if(request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			
			int limit = 10; // 한페이지에 출력할 목록 갯수
			ubservice = new UserBillService();
			
			int listCount = ubservice.getListCount(months);
			// 총 페이지수 계산
			int maxPage = listCount / limit;
			if(listCount % limit > 0) {
				maxPage++;
			}
			
			int beginPage = (currentPage / limit) * limit + 1;
			int endPage = beginPage + 9;
			if(endPage > maxPage)
				endPage = maxPage;
			
			int startRow = (currentPage * limit) -9; // 시작페이지
			int endRow = currentPage * limit;
			
			list = ubservice.selectList(months, startRow, endRow);
			
			RequestDispatcher view = null;
			if(list.size() > 0 ) {
				view = request.getRequestDispatcher("views/user/bill/userBillList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("months", months);
				view.forward(request, response);
				System.out.println("list " + list);
				
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", currentPage + "페이지 목록 조회 실패");
				view.forward(request, response);
				
			}
				
		} else {
			
		int currentPage = 1; // 현재 보여지는 페이지
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10; // 한페이지에 출력할 목록 갯수
		ubservice = new UserBillService();
		
		int listCount = ubservice.getListCount();
		// 총 페이지수 계산
		int maxPage = listCount / limit;
		if(listCount % limit > 0) {
			maxPage++;
		}
		
		int beginPage = (currentPage / limit) * limit + 1;
		int endPage = beginPage + 9;
		if(endPage > maxPage)
			endPage = maxPage;
		
		int startRow = (currentPage * limit) -9; // 시작페이지
		int endRow = currentPage * limit;
		
		list = ubservice.selectList(startRow, endRow);
		
		RequestDispatcher view = null;
		if(list.size() > 0 ) {
			view = request.getRequestDispatcher("views/user/bill/userBillList.jsp");
			request.setAttribute("list", list);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			view.forward(request, response);
			System.out.println("list " + list);
			
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", currentPage + "페이지 목록 조회 실패");
			view.forward(request, response);
			
		}
		
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

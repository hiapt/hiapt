package maintenance.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.BaseViewService;
import maintenance.model.vo.BaseView;
import maintenance.model.vo.Bill;

/**
 * Servlet implementation class baseViewSearchServlet
 */
@WebServlet("/bvis")
public class baseViewSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public baseViewSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// 2. 변수 옮기기, 부과년월로 검색
		String months = request.getParameter("months");
		System.out.println("months : " + months);
		// 공통사용
		BaseViewService baservice = new BaseViewService();
		ArrayList<BaseView> list = null;

		if (months != null) { // 부과년월 입력시
			System.out.println("months");

			int currentPage = 1; // 현재페이지
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}

			int limit = 10;// 한 페이지에 출력할 목록 갯수

			int listCount = baservice.getListCount(months); // 전체 목록 갯수 조회
			int maxPage = listCount / limit;
			if (listCount % limit > 0) {
				maxPage++;
			}

			int beginPage = (currentPage / limit) * limit + 1;
			int endPage = beginPage + 9;
			if (endPage > maxPage) {
				endPage = maxPage;
			}

			int startRow = (currentPage * limit) - 9;
			int endRow = currentPage * limit;

			// ArrayList<BaseView> list = baservice.selectList(startRow, endRow);
			// 3. 한개 일 수도 있고, 없을 수도 있고, 여러개 있을 수 있음
			list = baservice.selectMonthSearch(months, startRow, endRow);
			System.out.println("not null listservlet :" + list);

			// 4. view 로 전달 - 에러와성공
			RequestDispatcher view = null;
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/emp/maintenance/baseViewList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("months", months);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", months + "검색조회 실패!");
			}
			view.forward(request, response);

		} else {// null 또는 전체목록
			int listCount = baservice.getListCount();
			System.out.println("전체목록 갯수 : " + listCount);

			int limit = 10;
			int currentPage = 1;
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			System.out.println(currentPage);

			int maxPage = listCount / limit;
			if (listCount % limit > 0) {
				maxPage++;
			}

			int beginPage = (currentPage / limit) * limit + 1;
			int endPage = beginPage + 9;
			if (endPage > maxPage) {
				endPage = maxPage;
			}

			int startRow = (currentPage * limit) - 9;
			int endRow = currentPage * limit;
			// ArrayList<BaseView> list = baservice.selectList(startRow, endRow);
			// 3. 한개 일 수도 있고, 없을 수도 있고, 여러개 있을 수 있음
			list = new BaseViewService().selectList(startRow, endRow);

			// 4. view 로 전달 - 에러와성공
			RequestDispatcher view = null;
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/emp/maintenance/baseViewList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("months", months);
				view.forward(request, response);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", months + "검색조회 실패!");
				view.forward(request, response);
			}
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

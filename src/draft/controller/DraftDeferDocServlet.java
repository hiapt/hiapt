package draft.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import draft.model.service.DraftService;
import draft.model.vo.Draft;

/**
 * Servlet implementation class DraftDeferDocServlet
 */
@WebServlet("/ddefer")
public class DraftDeferDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DraftDeferDocServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 보류문서 목록

		String empno = request.getParameter("empno");

		String progress = "3";

		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		int limit = 10; // 한 페이지에 출력할 목록 갯수
		DraftService dservice = new DraftService();

		int listCount = dservice.getListCountProgress(empno, progress);
		// 총 페이지 수 계산
		int maxPage = listCount / limit;
		if (listCount % limit > 0)
			maxPage++;

		// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
		// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
		int beginPage = (currentPage / limit) * limit + 1;
		int endPage = beginPage + 9;
		if (endPage > maxPage)
			endPage = maxPage;

		// currentPage 에 출력할 목록의 조회할 행 번호 계산
		int startRow = (currentPage * limit) - 9;
		int endRow = currentPage * limit;

		ArrayList<Draft> list = new DraftService().selectProgress(startRow, endRow, empno, progress);
		RequestDispatcher view = null;

		view = request.getRequestDispatcher("views/emp/approval/deferDoc.jsp");

		request.setAttribute("list", list);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("count", listCount);
		request.setAttribute("empno", empno);
		view.forward(request, response);
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

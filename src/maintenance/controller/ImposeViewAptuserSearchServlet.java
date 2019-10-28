package maintenance.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.ImposeViewAptuserService;
import maintenance.model.vo.ImposeViewAptuser;

/**
 * Servlet implementation class ImposeViewAptuserSearchServlet
 */
@WebServlet("/imvas")
public class ImposeViewAptuserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImposeViewAptuserSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리비금액 등록시 세대주 동호 및 이름을 위한 전체 세대주 서치용 컨트롤러
		//1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// 변수 옮기기, 동호로 검색
		String userId = request.getParameter("userid");
		System.out.println("userid : " + userId);
		
		// 공통사용
		ImposeViewAptuserService imservice = new ImposeViewAptuserService();
		ArrayList<ImposeViewAptuser> alist = null;
		
		if(userId != null) {
			int currentPage = 1;
			if(request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			
			int limit = 10;// 한페이지 출력 목록 갯수
			
			
			int listCount = imservice.getListCount(userId);
			int maxPage = listCount / limit;
			if(listCount % limit > 0) {
				maxPage++;
			}
			
			int beginPage = (currentPage / limit) * limit + 1;
			int endPage = beginPage + 9;
			if (endPage > maxPage) {
				endPage = maxPage;
			}

			int startRow = (currentPage * limit) - 9;
			int endRow = currentPage * limit;
			
			// 3. 한개 일 수도 있고, 없을 수도 있고, 여러개 있을 수 있음			
			alist = imservice.selectUserId(userId, startRow, endRow);
			System.out.println("alist servlet : " + alist);
			
			// 4. view 로 전달 - 에러와성공
			RequestDispatcher view = null;
			if (alist.size() > 0) {
				view = request.getRequestDispatcher("views/emp/maintenance/imposeViewAptuserSearch.jsp");
				request.setAttribute("alist", alist);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("userid", userId);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", userId + "검색조회 실패!");
			}
			view.forward(request, response);
			
		} else { // null 또는 시작시
			int listCount = imservice.getListCount();
			System.out.println("servlet listcount : " + listCount);
			
			int limit = 10;
			int currentPage = 1;
			if(request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			System.out.println(currentPage);
			
			int maxPage = listCount / limit ;
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
			
			alist = imservice.selectUserId(startRow, endRow);
			System.out.println("alist servlet : " + alist);
			
			RequestDispatcher view = null;
			if (alist.size() > 0) {
				view = request.getRequestDispatcher("views/emp/maintenance/imposeViewAptuserSearch.jsp");
				request.setAttribute("alist", alist);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("userid", userId);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "세대주 전체 검색조회 실패!");
			}
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

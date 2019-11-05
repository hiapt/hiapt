package aptuser.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aptuser.model.service.UloginService;
import aptuser.model.vo.Aptuser;

/**
 * Servlet implementation class AptSearchServlet
 */
@WebServlet("/aptsearch")
public class AptSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AptSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String search = request.getParameter("search");
		
		RequestDispatcher view = null;
		ArrayList<Aptuser> list = null;
		UloginService aptservice = new UloginService();
		
		int currentPage = 1;

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10; // 한 페이지에 출력할 목록 갯수
		
		// currentPage 에 출력할 목록의 조회할 행 번호 계산
		int startRow = (currentPage * limit) - 9;
		int endRow = currentPage * limit;
		
		switch(search) { 
		case "dongho":
			String dong = request.getParameter("dong");
			String ho = request.getParameter("ho");
			
			int listCount = aptservice.getListCountDongho(dong, ho); // 테이블의 전체 목록 갯수 조회
			// 총 페이지 수 계산
			int maxPage = listCount / limit;
			//if(listCount % limit > 0)
				maxPage++;

			// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
			// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
			int beginPage = (currentPage / limit) * limit + 1;
			
			if(currentPage % limit == 0) {
				beginPage -= limit;
			}
			
			int endPage = beginPage + 9;
			if (endPage > maxPage)
				endPage = maxPage;

			list = aptservice.selectDonghoSearch(dong, ho, startRow, endRow);


			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/user/apt/aptList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("count", listCount);

			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "해당 문서가 존재하지 않습니다.");
			}
			view.forward(request, response);	 break;
			
			
			
			
		case "name": 
			String userName = request.getParameter("keyword");
			
			int listCount2 = aptservice.getListCountName(userName);  //테이블의 전체 목록 갯수 조회
			//총 페이지 수 계산
			int maxPage2 = listCount2 / limit;
				maxPage2++;

				int beginPage2 = (currentPage / limit) * limit + 1;
				
				if(currentPage % limit == 0) {
					beginPage2 -= limit;
				}
				
				int endPage2 = beginPage2 + 9;
				if (endPage2 > maxPage2)
					endPage2 = maxPage2;
			
			list = aptservice.selectNameSearch(userName, startRow, endRow);
			
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/user/apt/aptList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage2);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage2);
				request.setAttribute("endPage", endPage2);
				request.setAttribute("count", listCount2);

			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "해당 이름이 존재하지 않습니다.");
			}

			view.forward(request, response);	 break;
			
		case "date": 
			String beginDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			
			int listCount3 = aptservice.getListCountDate(Date.valueOf(beginDate), Date.valueOf(toDate)); // 테이블의 전체 목록 갯수 조회
			// 총 페이지 수 계산
			int maxPage3 = listCount3 / limit;
				maxPage3++;

			// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
			// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
			int beginPage3 = (currentPage / limit) * limit + 1;
			
			if(currentPage % limit == 0) {
				beginPage3 -= limit;
			}
			
			int endPage3 = beginPage3 + 9;
			if (endPage3 > maxPage3)
				endPage3 = maxPage3;

			list = aptservice.selectDateSearch(Date.valueOf(beginDate), Date.valueOf(toDate), startRow, endRow);


			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/user/apt/aptList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage3);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage3);
				request.setAttribute("endPage", endPage3);
				request.setAttribute("count", listCount3);

			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "해당 세대주가 존재하지 않습니다.");
			}
			view.forward(request, response);	 break;
			
		}
		System.out.println(list);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

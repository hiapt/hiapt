
package draft.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import draft.model.service.DraftService;
import draft.model.vo.Draft;
import mybox.model.service.MyboxService;
import mybox.model.vo.Mybox;

/**
 * Servlet implementation class DraftSearchServlet
 */
@WebServlet("/dsearch")
public class DraftSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DraftSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String search = request.getParameter("search");
		String empno = request.getParameter("empno");
		String keyword = null;

		RequestDispatcher view = null;
		ArrayList<Draft> list = null;
		DraftService dservice = new DraftService();
		MyboxService mservice = new MyboxService();
		ArrayList<Mybox> mlist = mservice.selectAll(empno);
		int currentPage = 1;

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10; // 한 페이지에 출력할 목록 갯수
		int listCount = 0;
		int maxPage = 0;
		int beginPage = 0;
		int endPage = 0;
		String beginDate = null;
		String toDate = null;
		
		int startRow = (currentPage * limit) - 9;
		int endRow = currentPage * limit;

		switch (search) {
		case "title":
			keyword = request.getParameter("keyword");

			listCount = dservice.getSearchCountT(keyword, empno); // 테이블의 전체 목록 갯수 조회
			
			list = dservice.draftTitleSearch(keyword, empno, startRow, endRow);
			break;
			
		case "writer":
			keyword = request.getParameter("keyword");
			
			listCount = dservice.getSearchCountW(keyword, empno); 

			list = dservice.draftWriterSearch(keyword, empno, startRow, endRow);
			break;
			
		case "date":
			beginDate = request.getParameter("from");
			toDate = request.getParameter("to");
			
			listCount = dservice.getSearchCountD(Date.valueOf(beginDate), Date.valueOf(toDate), empno); 

			list = dservice.draftDateSearch(Date.valueOf(beginDate), Date.valueOf(toDate), empno, startRow, endRow);
			break;
			
			
		case "formtype":
			keyword = request.getParameter("keyword");
			list = dservice.draftFormtypeSearch(keyword, empno, startRow, endRow);
			listCount = dservice.getSearchCountF(keyword, empno); 
		
			list = dservice.draftFormtypeSearch(keyword, empno, startRow, endRow);

			 break;
			
		}
		
		maxPage = listCount / limit;
		maxPage++;

		beginPage = (currentPage / limit) * limit + 1;
		if(currentPage % limit == 0) {
        beginPage -= limit;
		}
		endPage = beginPage + 9;
		if (endPage > maxPage)
		endPage = maxPage;
		
		
		if (list.size() > 0) {
			view = request.getRequestDispatcher("views/emp/approval/docList.jsp");
			request.setAttribute("list", list);
			request.setAttribute("mlist", mlist);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("count", listCount);
			request.setAttribute("search", search);
			request.setAttribute("keyword", keyword);
			
			if(beginDate != null && toDate != null) {
				request.setAttribute("begin", beginDate.toString());
				request.setAttribute("to", toDate.toString());
			}
			
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "검색어에 해당하는 문서가 존재하지 않습니다.");
		}
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

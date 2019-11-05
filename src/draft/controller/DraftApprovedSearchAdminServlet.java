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
 * Servlet implementation class DraftApprovedSearchAdminServlet
 */
@WebServlet("/dsearchapp.ad")
public class DraftApprovedSearchAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftApprovedSearchAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String search = request.getParameter("search");
		String docstatus = "2";
		String keyword = null;
		RequestDispatcher view = null;
		ArrayList<Draft> list = null;
		DraftService dservice = new DraftService();
		MyboxService mservice = new MyboxService();
		ArrayList<Mybox> mlist = mservice.selectAll("admin");
		
		int currentPage = 1;

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10;
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
			
			listCount = dservice.getdocstatusSearchCountTAd(keyword, docstatus); // 테이블의 전체 목록 갯수 조회

			list = dservice.draftdocstatusTitleSearchAd(keyword, startRow, endRow, docstatus);
			break;
			
		case "writer":
			keyword = request.getParameter("keyword");
			
			listCount = dservice.getdocstatusSearchCountWAd(keyword, docstatus); // 테이블의 전체 목록 갯수 조회

			list = dservice.draftdocstatusWriterSearchAd(keyword, startRow, endRow, docstatus);

			break;
			
		case "date":
			beginDate = request.getParameter("from");
			toDate = request.getParameter("to");
			
			listCount = dservice.getdocstatusSearchCountDAd(Date.valueOf(beginDate), Date.valueOf(toDate), docstatus); // 테이블의 전체 목록 갯수 조회

			list = dservice.draftdocstatusDateSearchAd(Date.valueOf(beginDate), Date.valueOf(toDate), startRow, endRow, docstatus);

			break;
			
		case "formtype":
			String draftFormname = request.getParameter("keyword");
			listCount = dservice.getdocstatusSearchCountFAd(draftFormname, docstatus); 
			
			list = dservice.draftdocstatusFormtypeSearchAd(draftFormname, startRow, endRow, docstatus);

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
			view = request.getRequestDispatcher("views/master/approval/approvedDocAdmin.jsp");

			request.setAttribute("list", list);
			request.setAttribute("mlist", mlist);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("count", listCount);
			request.setAttribute("keyword", keyword);
			request.setAttribute("search", search);
			
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

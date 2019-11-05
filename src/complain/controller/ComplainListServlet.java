package complain.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.service.BoardService;
import complain.model.service.ComplainService;
import complain.model.vo.Complain;
import employee.model.vo.Employee;

/**
 * Servlet implementation class ComplainListServlet
 */
@WebServlet("/co.list")
public class ComplainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ComplainService cservice = new ComplainService();
		String searchText = request.getParameter("searchtext");
		String selectOption = request.getParameter("selectoption");
		int listCount = 0;
		if(selectOption != null) { //검색입력시.
			if(selectOption.equals("title"))
				listCount = cservice.getSearchTitleListCount(searchText);
			else
				listCount = cservice.getSearchUserNameListCount(searchText);
		}else { //입력 안했을시.
			listCount = cservice.getListCount();
		}
		int listSize = 10; 
		int pageSize = 10; 
		int currentPage = 1; 
		if (request.getParameter("page") != null)
			currentPage = Integer.parseInt(request.getParameter("page"));

		int maxPage = listCount / listSize; 
		if (listCount % listSize > 0)
			maxPage++;
		int beginPage = (currentPage / pageSize) * pageSize + 1;
		if (currentPage % pageSize == 0)
			beginPage -= pageSize;

		int endPage = beginPage + (pageSize - 1); 
		if (endPage > maxPage)
			endPage = maxPage;

		int startlist = (currentPage * listSize) - (listSize - 1); // 시작목록 1 4
		int endlist = currentPage * listSize; // 마지막목록 3 6	
		

		ArrayList<Complain> clist = null;		
		if(selectOption != null) { //검색입력시.
			if(selectOption.equals("title"))
				clist = cservice.searchTitle(startlist, endlist, searchText);	
			else
				clist = cservice.searchUserName(startlist, endlist, searchText);
		}else { //입력 안했을시.
			clist = cservice.selectList(startlist, endlist);
		}
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		RequestDispatcher view = null;
		
		request.setAttribute("clist", clist);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("selectoption", selectOption);
		request.setAttribute("searchtext", searchText);
		
		if(employee != null) {//직원접속
			if (clist.size() > 0) {
				view = request.getRequestDispatcher("views/master/complain/complainAdminListView.jsp");

			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "민원관리 리스트 조회 실패");
			}
		}else {//세대주접속
			if (clist.size() > 0) {
				view = request.getRequestDispatcher("views/user/complain/complainListView.jsp");

			} else {
				view = request.getRequestDispatcher("views/common/user404.jsp");
				request.setAttribute("message", "민원관리 리스트 조회 실패");
			}	
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

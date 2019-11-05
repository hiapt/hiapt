package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.model.vo.Employee;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/no.list")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자, 세대주 공지사항 리스트 서블릿
		request.setCharacterEncoding("utf-8");
		//System.out.println("여기는 공지 목록 조회하는 서블릿입니다.");
		String titleName = request.getParameter("titlename");
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("employee");

		if (titleName != null) { // 제목입력 했을시.////////////////////////////////

			int listCount = new NoticeService().getSearchListCount(titleName);
			System.out.println("검색 후 목록 갯수 : "+listCount);
			int listSize = 10; // 
			int pageSize = 10; // 
			int currentPage ;// 
			// 인덱스에서 처음 들어올땐 기본값1 나머지는 if문으로 체크
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}else {
				currentPage = 1;
			}
			//System.out.println("currentPage : "+currentPage);
			int maxPage = listCount / listSize; // 마지막페이지완전끝
			if (listCount % listSize > 0)
				maxPage++;
			
			int beginPage = (currentPage / pageSize) * pageSize + 1;
			if (currentPage % pageSize == 0) {
				beginPage -= pageSize;
			}
			int endPage = beginPage + (pageSize - 1); 
			if (endPage > maxPage)
				endPage = maxPage;

			int startlist = (currentPage * listSize) - (listSize - 1); 
			int endlist = currentPage * listSize; 

			ArrayList<Notice> nlist = new NoticeService().searchTitle(titleName, startlist, endlist);
			System.out.println(nlist+", "+maxPage+", "+currentPage+", "
			+beginPage+", "+endPage+", "+pageSize+", "+titleName+", "+listCount);
			RequestDispatcher view = null;
			if (employee != null) {//직원이 접속한경우..
				if (nlist.size() > 0) {
					view = request.getRequestDispatcher("views/master/notice/noticeAdminListView.jsp");
					request.setAttribute("nlist", nlist);
					request.setAttribute("maxPage", maxPage);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("beginPage", beginPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("pageSize", pageSize);
					request.setAttribute("titlename", titleName);
					request.setAttribute("listCount", listCount);
					
				} else { //에러페이지
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", titleName+"으로 검색한 공지 리스트가 없습니다.");
				}
				view.forward(request, response);
			} else {// 세대주가 접속한경우..
				if (nlist.size() > 0) {
					view = request.getRequestDispatcher("views/user/notice/noticeListView.jsp");
					request.setAttribute("nlist", nlist);
					request.setAttribute("maxPage", maxPage);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("beginPage", beginPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("pageSize", pageSize);
					request.setAttribute("titlename", titleName);
					request.setAttribute("listCount", listCount);
				} else {
					view = request.getRequestDispatcher("views/common/user404.jsp");
					request.setAttribute("message", titleName+"으로 검색한 공지 리스트가 없습니다.");
				}
				view.forward(request, response);
			}

		} else {// 제목이 null(시작)일경우
			
			
			NoticeService nservice = new NoticeService();			
			int listCount = nservice.getListCount();//테이블의 전체 목록 갯수 조회
			System.out.println("listCount : "+listCount);
			int listSize = 10; // 페이지당 목록수 3개
			int pageSize = 10; // 페이징바당 페이지개수 3개
			int currentPage ; // 현재페이지 1~3목록이보여야함
			// 인덱스에서 처음 들어올땐 기본값1 나머지는 if문으로 체크
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}else {
				currentPage= 1;
			}
			
			int maxPage = listCount / listSize; // 마지막페이지완전끝
			if (listCount % listSize > 0)
				maxPage++;
			// 1 4 7 ... 1 / 3
			int beginPage = (currentPage / pageSize) * pageSize + 1;
			if (currentPage % pageSize == 0) {
				beginPage -= pageSize;
			}
			int endPage = beginPage + (pageSize - 1); // 목록에서의 끝페이지 1~3에서 3
			if (endPage > maxPage)
				endPage = maxPage;

			int startlist = (currentPage * listSize) - (listSize - 1); // 시작목록 1 4
			int endlist = currentPage * listSize; // 마지막목록 3 6

			//System.out.println("startlist : "+startlist+", endlist : "+endlist);
			ArrayList<Notice> nlist = new NoticeService().selectList(startlist, endlist);

			RequestDispatcher view = null;
			if(employee != null) {//직원이 접속한경우 
			if (nlist.size() > 0) {
				view = request.getRequestDispatcher("views/master/notice/noticeAdminListView.jsp");
				request.setAttribute("nlist", nlist);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("pageSize", pageSize);
				//request.setAttribute("titlename", titleName);
				request.setAttribute("listCount", listCount);
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "공지 사항 리스트 조회 실패");
			}
			view.forward(request, response);
			}else {//세대주가 접속한경우
				if (nlist.size() > 0) {
					view = request.getRequestDispatcher("views/user/notice/noticeListView.jsp");
					request.setAttribute("nlist", nlist);
					request.setAttribute("maxPage", maxPage);
					request.setAttribute("currentPage", currentPage);
					request.setAttribute("beginPage", beginPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("pageSize", pageSize);
					//request.setAttribute("titlename", titleName);
					request.setAttribute("listCount", listCount);
				} else {
					view = request.getRequestDispatcher("views/common/user404.jsp");
					request.setAttribute("message", "주민 공지사항 리스트 조회 실패");
				}
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

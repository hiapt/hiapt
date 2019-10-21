package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;


/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/bo.list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount = new BoardService().getListCount();

		int listSize = 10; // 페이지당 목록수 3개
		int pageSize = 10; // 페이징바당 페이지개수 3개
		int currentPage = 1; // 현재페이지 1~3목록이보여야함
		// 인덱스에서 처음 들어올땐 기본값1 나머지는 if문으로 체크
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 1페이지에는 1~3 목록
		// 2 4~6
		// 3 7~9
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

		ArrayList<Board> blist = new BoardService().selectList(startlist, endlist);

		RequestDispatcher view = null;

		if (blist.size() > 0) {
			view = request.getRequestDispatcher("views/user/board/boardListView.jsp");
			request.setAttribute("blist", blist);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageSize", pageSize);

		} else {
			view = request.getRequestDispatcher("views/common/user404.jsp");
			request.setAttribute("message", "주민투표 리스트 조회 실패");
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

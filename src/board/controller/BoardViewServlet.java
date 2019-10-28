package board.controller;

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
import board.model.vo.Board;
import board.model.vo.BoardFiles;


/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/bo.view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bNo = Integer.parseInt(request.getParameter("bno"));
		int currentPage = 1;
		String upORview = request.getParameter("uporview");
		BoardService bservice = new BoardService();
		if(upORview.equals("view")) {//상세보기일경우
			currentPage = Integer.parseInt(request.getParameter("page"));
			bservice.updateReadCount(bNo);//조회수
		}//업데이트일경우 조회수랑 페이지 생성x
		Board board = bservice.selectView(bNo);//게시판
		ArrayList<BoardFiles> bfiles = bservice.selectFile(bNo);//파일목록
		RequestDispatcher view = null;
			if(board != null) {
				if(upORview.equals("view"))//상세보기일겨우
				view = request.getRequestDispatcher("views/user/board/boardDetailView.jsp");
				else//업데이트일경우
				view = request.getRequestDispatcher("views/user/board/boardUpdate.jsp");
				
				request.setAttribute("board", board);
				request.setAttribute("bfiles", bfiles);
				request.setAttribute("currentPage", currentPage);
			}else {
				view = request.getRequestDispatcher("views/common/user404.jsp");
				request.setAttribute("message", "상세조회 실패!");
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

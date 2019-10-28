package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.BoardFiles;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/bo.delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.
		request.setCharacterEncoding("utf-8");
		BoardService bservice = new BoardService();
		// 2.
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		ArrayList<BoardFiles> bfiles = bservice.selectFile(boardNo);

		// 3.
		int result = bservice.deleteBoard(boardNo);
		// 4.
		if (result > 0) {
			if (bfiles.size() > 0) {
				for (BoardFiles bf : bfiles) {
					String renameFileName = bf.getBoardRnameFileName();
					if (renameFileName != null) {
						String savePath = request.getSession().getServletContext()
								.getRealPath("/resources/boardFiles");
						File renameFile = new File(savePath + "\\" + renameFileName);
						renameFile.delete();
					} // rename 삭제 이프
				} // bf포문
			} // bfiles size if문
			response.sendRedirect("/hiapt/bo.list");

		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/user404.jsp");
			request.setAttribute("message", "자유게시판 삭제 실패!");
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

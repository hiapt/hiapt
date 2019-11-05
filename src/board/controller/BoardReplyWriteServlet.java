package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aptuser.model.vo.Aptuser;
import board.model.service.BoardService;

/**
 * Servlet implementation class BoardReplyWriteServlet
 */
@WebServlet("/bo.replyWrite")
public class BoardReplyWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReplyWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bNo = Integer.parseInt(request.getParameter("bno"));
		int currentPage = Integer.parseInt(request.getParameter("currentpage"));
		String brContent = request.getParameter("brcontent");
		Aptuser aptuser = (Aptuser)request.getSession().getAttribute("aptuser");
		String userid = aptuser.getUserId();
		
		BoardService bservice = new BoardService();

		int result = bservice.insertBoardReply(bNo,brContent,userid);
		
		RequestDispatcher view = null;
		if(result>0) {
			response.sendRedirect("/hiapt/bo.view?page="+currentPage+"&uporview=view&bno="+bNo);
		}else {
			view = request.getRequestDispatcher("views/commom/user404.jsp");
			request.setAttribute("message", "댓글 등록 실패");
			view.forward(request, response);
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

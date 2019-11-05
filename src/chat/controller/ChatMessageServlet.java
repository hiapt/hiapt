package chat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chat.model.service.ChatService;
import chat.model.vo.ChatMessage;

/**
 * Servlet implementation class ChatMessageServlet
 */
@WebServlet("/ch.message")
public class ChatMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String empno = request.getParameter("empno"); 

		int chatno=Integer.parseInt(request.getParameter("chatno"));
		ChatService cservice = new ChatService();
		ArrayList<ChatMessage> cmlist = cservice.selectMessageOne(chatno);
		String ctitle = cservice.selectTitle(chatno, empno);
		
		RequestDispatcher view=request.getRequestDispatcher("views/emp/chat/chatMessage.jsp");
		request.setAttribute("empno", empno);
		request.setAttribute("cmlist", cmlist); //대화내용저장
		request.setAttribute("chatno", chatno);//방번호저장
		request.setAttribute("ctitle", ctitle); //방제목저장
		
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

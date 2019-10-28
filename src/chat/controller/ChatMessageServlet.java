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
		
		String newold = request.getParameter("newold");
		String empno = request.getParameter("empno");
		String empno2="";
		int chatno=0;
		ChatService cservice = new ChatService();
		
		RequestDispatcher view=request.getRequestDispatcher("views/emp/chat/chatMessage.jsp");
		request.setAttribute("empno", empno);
		
		if(newold.equals("new")) {
			empno2 = request.getParameter("empno2");
			chatno = cservice.selectRoom(empno,empno2);//방번호가 0이면 새로운방 방번호가있으면 그번호로..
			System.out.println(chatno);
		}else{
			chatno = Integer.parseInt(request.getParameter("chatno"));
		}
		

		if(chatno==0) {
			cservice.insertNewChatRoom(empno);
			chatno = cservice.selectNewChatRoom(empno);
			cservice.insertNewChatRoom2(chatno, empno2);
		}
		ArrayList<ChatMessage> cmlist = cservice.selectMessageOne(chatno);
		request.setAttribute("cmlist", cmlist); //대화내용저장
		request.setAttribute("chatno", chatno);//방번호저장
		System.out.println(chatno);
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

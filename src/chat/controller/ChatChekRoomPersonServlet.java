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
import chat.model.vo.ChatPerson;

/**
 * Servlet implementation class ChatChekRoomPersonServlet
 */
@WebServlet("/ch.checkPerson")
public class ChatChekRoomPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatChekRoomPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int chatNo = Integer.parseInt(request.getParameter("chatno"));
		
		ArrayList<ChatPerson> chatPerson = new ChatService().selectChatPName(chatNo);
		
		
		RequestDispatcher view = request.getRequestDispatcher("views/emp/chat/chatRoomPersonList.jsp");
		request.setAttribute("chatperson", chatPerson);
		
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

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
 * Servlet implementation class ChatInvitePersonServlet
 */
@WebServlet("/ch.inviteP")
public class ChatInvitePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatInvitePersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int chatNo = Integer.parseInt(request.getParameter("chatno"));
		
		ArrayList<ChatPerson> chatPerson = new ChatService().selectInvitePerson(chatNo);
		
		RequestDispatcher view = request.getRequestDispatcher("views/emp/chat/chatInvite.jsp");
		request.setAttribute("chatperson", chatPerson);
		request.setAttribute("chatno", chatNo);
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

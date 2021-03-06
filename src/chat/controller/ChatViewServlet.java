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
import chat.model.vo.ChatPerson;
import chat.model.vo.ChatRoomPerson;

/**
 * Servlet implementation class ChatViewServlet
 */
@WebServlet("/ch.view")
public class ChatViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empNo= request.getParameter("empno");
		ChatService cservice = new ChatService();
		
		ArrayList<ChatPerson> clist = cservice.selectAll(empNo);//채팅목록 인원가져오기.
		ArrayList<ChatRoomPerson> crplist = cservice.selectCRPList(empNo);///보관된 방목록가져오기.
		ArrayList<ChatMessage> cmlist = cservice.selectCMList(empNo); //채팅내용가져오기 순서대로..
		ArrayList<int[]> crpCountlist = cservice.selectCount(empNo);//채팅방인원수 가져오기
		
		RequestDispatcher view = null;
		if(clist!=null /*&& crplist!=null && crpCountlist!=null && cmlist !=null*/) {
			view=request.getRequestDispatcher("views/emp/chat/chatManager.jsp");
			request.setAttribute("clist", clist);
			request.setAttribute("crplist", crplist);
			request.setAttribute("cmlist", cmlist);
			request.setAttribute("crpCountlist", crpCountlist);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "채팅 조회 실패");
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

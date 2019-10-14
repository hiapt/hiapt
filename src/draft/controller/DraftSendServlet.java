package draft.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import draft.model.service.DraftService;
import draft.model.vo.Draft;

/**
 * Servlet implementation class DraftSendServlet
 */
@WebServlet("/dsend")
public class DraftSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기안 전송
		request.setCharacterEncoding("UTF-8");
		Draft draft = new Draft();
		draft.setEmpno(request.getParameter("drafter"));
		draft.setDisplay(request.getParameter("display"));
		draft.setDoctitle(request.getParameter("drafttitle"));
		draft.setDoccontent(request.getParameter("doccontent"));
		draft.setFormcode(Integer.parseInt(request.getParameter("formcode")));
		draft.setProgress(request.getParameter("progress"));
		
		System.out.println("draft : " + draft );

		int result = new DraftService().insert(draft);
		
		if(result > 0) {
			response.sendRedirect("/hiapt/index.jsp?#/hiapt/dlist");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "기안작성실패");
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

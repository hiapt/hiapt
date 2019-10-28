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
 * Servlet implementation class DraftSignServlet
 */
@WebServlet("/dsign")
public class DraftSignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftSignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Draft draft =new Draft();
		int docno = Integer.parseInt(request.getParameter("docno"));
		draft.setDocno(docno);
		String progress = request.getParameter("progress");
		draft.setProgress(progress);
		draft.setAppempno(request.getParameter("appempno"));
		draft.setFeedback(request.getParameter("feedback"));
		draft.setDisplay(request.getParameter("display"));
		
		int result = new DraftService().signDraft(draft, progress);
		System.out.println("draft : " + draft );
		if(result > 0) {
			response.sendRedirect("/hiapt/dview?docno=" + docno );
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "결재 실패");
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

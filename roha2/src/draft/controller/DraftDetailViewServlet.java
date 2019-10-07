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
 * Servlet implementation class DraftDetailViewServlet
 */
@WebServlet("/dview")
public class DraftDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int docno = Integer.parseInt(request.getParameter("docno"));
		
		Draft draft = new DraftService().selectOne(docno);
		RequestDispatcher view = null; 
		if(draft != null) {
			view = request.getRequestDispatcher("views/employee/approval/draftDetailView.jsp");
			request.setAttribute("draft", draft);
			
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", docno + "번 기안서 상세보기 실패");
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

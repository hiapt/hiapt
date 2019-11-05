package draft.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import draft.model.service.DraftService;
import draft.model.vo.Draft;
import draft.model.vo.DraftProcess;

/**
 * Servlet implementation class DraftSignViewServlet
 */
@WebServlet("/dsview")
public class DraftSignViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftSignViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int docno = Integer.parseInt(request.getParameter("docno"));
	String empno = request.getParameter("empno");
	DraftService dservice = new DraftService();
	DraftProcess dp = dservice.selectOne(docno);
	ArrayList<DraftProcess> dplist = dservice.SignResult(docno);
	System.out.println("dp : " + dp);
	RequestDispatcher view = null; 
	if(dp != null) {
		view = request.getRequestDispatcher("views/master/approval/draftSignView.jsp");
		request.setAttribute("dp", dp);
		request.setAttribute("dplist", dplist);
		request.setAttribute("empno", empno);
		
		
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

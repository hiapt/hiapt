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

/**
 * Servlet implementation class DraftApprovedDocServlet
 */
@WebServlet("/dapproved")
public class DraftApprovedDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftApprovedDocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 승인문서 리스트용 서블렛
				ArrayList<Draft> list = new DraftService().selectApprovedDoc();
				RequestDispatcher view = null; 
			
					view = request.getRequestDispatcher("views/employee/approval/approvedDoc.jsp");

					request.setAttribute("list", list);
					
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

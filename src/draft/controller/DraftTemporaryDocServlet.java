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
 * Servlet implementation class DraftTemporaryDocServlet
 */
@WebServlet("/dtemp")
public class DraftTemporaryDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftTemporaryDocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 임시보관함 서블렛
				ArrayList<Draft> list = new DraftService().selectTempDoc();
				RequestDispatcher view = null; 

					
					view = request.getRequestDispatcher("views/emp/approval/temporaryDoc.jsp");

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

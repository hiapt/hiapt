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
 * Servlet implementation class DraftDeferDocServlet
 */
@WebServlet("/ddefer")
public class DraftDeferDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftDeferDocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 보류문서 목록
				ArrayList<Draft> list = new DraftService().selectDeferDoc();
				RequestDispatcher view = null; //아래 if else 둘 다에서 사용함 --> 미리 만들어놓음
			
			
					
					view = request.getRequestDispatcher("views/employee/approval/deferDoc.jsp");

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

package mybox.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybox.model.service.MyboxService;
import mybox.model.vo.Mybox;

/**
 * Servlet implementation class MyboxListEmp
 */
@WebServlet("/mlist.emp")
public class MyboxListEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyboxListEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		
		MyboxService mservice = new MyboxService();
		
		ArrayList<Mybox> list = mservice.selectAll(empno);
		RequestDispatcher view = null; 

			view = request.getRequestDispatcher("views/emp/approval/empMyboxList.jsp");

			request.setAttribute("list", list);
			request.setAttribute("empno", empno);
				
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

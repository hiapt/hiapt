package draft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import formbox.model.service.FormboxService;
import formbox.model.vo.Formbox;

/**
 * Servlet implementation class DraftWriteServlet
 */
@WebServlet("/dwrite")
public class DraftWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService eservice = new EmployeeService();
		FormboxService fservice = new FormboxService();
		ArrayList<Formbox> list = fservice.selectList();
		int startRow = 1;
		int endRow = 1000000;
		ArrayList<Employee> elist = eservice.selectList(startRow, endRow);

		RequestDispatcher view = null; //아래 if else 둘 다에서 사용함 --> 미리 만들어놓음
		
			view = request.getRequestDispatcher("views/emp/approval/draftWrite.jsp");
			
			request.setAttribute("list", list);
			request.setAttribute("list2", elist);

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


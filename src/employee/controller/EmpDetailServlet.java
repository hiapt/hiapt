package employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet(name = "Empdetail", urlPatterns = { "/empdetail" })
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empNo = request.getParameter("empno");
		
		Employee employee2 = new EmployeeService().selectEmployee(empNo);
		
		RequestDispatcher view = null;
		if(employee2 != null) {
			view = request.getRequestDispatcher("views/emp/employee/empDetail.jsp");
			request.setAttribute("employee2", employee2);
			view.forward(request, response);
			
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "직원상세정보 보기 요청 처리 실패함.");
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

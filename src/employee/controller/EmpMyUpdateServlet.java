package employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class EmpMyUpdateServlet
 */
@WebServlet("/myupd")
public class EmpMyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpMyUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		Employee employee = new Employee();
		
		String empNo = request.getParameter("empno");
		
		EmployeeService empservice = new EmployeeService();
		Employee emp = new EmployeeService().selectEmployee(empNo);
		
		RequestDispatcher view = null;
		if(emp != null) {
			view = request.getRequestDispatcher("views/emp/employee/empMyUpdate.jsp");
			request.setAttribute("emp", emp);
			
			//response.sendRedirect("/hiapt/empdetail?empno=" + empNo);
		
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", " 직원 정보 수정 실패");
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

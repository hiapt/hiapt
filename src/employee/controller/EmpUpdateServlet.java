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
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/empupdate")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateServlet() {
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
		/*employee.setEmpNo(empNo);
		employee.setEmpId(request.getParameter("empid"));
		employee.setEmpPhone(request.getParameter("empphone"));
		employee.setEmpAddress(request.getParameter("empaddress"));
		employee.setEmpEmail(request.getParameter("empemail"));
		employee.setEmpFamily(Integer.parseInt("empfamily"));
		employee.setSalary(Integer.parseInt(request.getParameter("salary")));
		employee.setPension(Double.parseDouble(request.getParameter("pension")));
		employee.setInsurance(Double.parseDouble(request.getParameter("insurance")));
		employee.setHireIns(Double.parseDouble(request.getParameter("hireins")));
		employee.setLongIns(Double.parseDouble(request.getParameter("longins")));
		employee.setIncomeTax(Double.parseDouble(request.getParameter("incometax")));
		employee.setLocalTax(Double.parseDouble(request.getParameter("localtax")));
		employee.setEmpEtc(request.getParameter("empetc"));*/
		
		EmployeeService empservice = new EmployeeService();
		Employee emp = new EmployeeService().selectEmployee(empNo);
		
		RequestDispatcher view = null;
		if(emp != null) {
			view = request.getRequestDispatcher("views/emp/employee/empUpdate.jsp");
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

package employee.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class empEnrollServlet
 */
@WebServlet("/empenroll")
public class EmpEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("utf-8");
				
				Employee employee = new Employee();
				
				employee.setEmpName(request.getParameter("empname"));
				employee.setEmpId(request.getParameter("empid"));
				employee.setEmpHireDate(Date.valueOf(request.getParameter("emphiredate")));
				employee.setEmpPhone(request.getParameter("empphone"));
				employee.setEmpSSN(request.getParameter("empssn"));
				employee.setEmpAddress(request.getParameter("empaddress1"));
				employee.setEmpEmail(request.getParameter("empemail"));
				employee.setEmpFamily(Integer.parseInt(request.getParameter("empfamily")));
				employee.setSalary(Integer.parseInt(request.getParameter("salary")));
				employee.setPension(Double.parseDouble(request.getParameter("pension")));
				employee.setInsurance(Double.parseDouble(request.getParameter("insurance")));
				employee.setHireIns(Double.parseDouble(request.getParameter("hireins")));
				employee.setLongIns(Double.parseDouble(request.getParameter("longins")));
				employee.setIncomeTax(Double.parseDouble(request.getParameter("incometax")));
				employee.setLocalTax(Double.parseDouble(request.getParameter("localtax")));
				employee.setEmpEtc(request.getParameter("empetc"));
				
				System.out.println("employee : " + employee);
				
				int result = new EmployeeService().insertEmployee(employee);
				
				if(result > 0) {
					response.sendRedirect("/hiapt/index.jsp");
				}else {
					RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "회원 가입 실패!");
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

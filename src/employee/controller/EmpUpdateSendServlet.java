package employee.controller;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class EmpUpdateSendServlet
 */
@WebServlet("/updsend")
public class EmpUpdateSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateSendServlet() {
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
		employee.setEmpNo(empNo);
		
		employee.setEmpName(request.getParameter("empname"));
		employee.setEmpId(request.getParameter("empid"));
		employee.setEmpPhone(request.getParameter("empphone"));
		employee.setEmpZipcode(Integer.parseInt(request.getParameter("zipcode")));
				
		employee.setEmpAddress(String.join(",", request.getParameterValues("empaddress")));
		
		employee.setEmpEmail(request.getParameter("empemail"));
		employee.setEmpFamily(Integer.parseInt(request.getParameter("empfamily")));
		employee.setSalary(Integer.parseInt(request.getParameter("salary")));
		employee.setPension(Integer.parseInt(request.getParameter("pension")));
		employee.setInsurance(Integer.parseInt(request.getParameter("insurance")));
		employee.setHireIns(Integer.parseInt(request.getParameter("hireins")));
		employee.setLongIns(Integer.parseInt(request.getParameter("longins")));
		employee.setIncomeTax(Integer.parseInt(request.getParameter("incometax")));
		employee.setLocalTax(Integer.parseInt(request.getParameter("localtax")));
		employee.setSalaryTot(Integer.parseInt(request.getParameter("salarytot")));
		employee.setMinusTot(Integer.parseInt(request.getParameter("minustot")));
		employee.setRealSalary(Integer.parseInt(request.getParameter("realsalary")));
		employee.setEmpEtc(request.getParameter("empetc"));;
		
		
		System.out.println("employee : " + employee);
		//3.
		EmployeeService empservice = new EmployeeService();
		
		
		int result = new EmployeeService().updateEmployee(employee);
		
		System.out.println("result : "+result);
		//4. 수정이 성공했을 때
		if(result > 0) {
			/*HttpSession session = request.getSession(false);
			
			Employee loginMember = empservice.selectEmployee(empNo);
			session.setAttribute("loginMember", loginMember);*/
			
			response.sendRedirect("/hiapt/emplist");
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", " 정보 수정 실패");
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

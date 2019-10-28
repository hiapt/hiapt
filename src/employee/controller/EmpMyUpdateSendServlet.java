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
@WebServlet("/myupdsend")
public class EmpMyUpdateSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpMyUpdateSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//2.
		Employee emp = new Employee();

		String empNo = request.getParameter("empno");
		emp.setEmpNo(empNo);

		emp.setEmpName(request.getParameter("empname"));
		emp.setEmpId(request.getParameter("empid"));
		emp.setEmpPhone(request.getParameter("empphone"));
		emp.setEmpZipcode(Integer.parseInt(request.getParameter("zipcode")));

		emp.setEmpAddress(String.join(",", request.getParameterValues("empaddress")));

		emp.setEmpEmail(request.getParameter("empemail"));
		
		
		//3.
		EmployeeService empservice = new EmployeeService();
		int result = new EmployeeService().updateEmployee(emp);
		
		//4. 수정이 성공했을 때
		if(result > 0) {
			//수정된 회원 정보를 세션에 다시 기록하기 위해 세션 객체 가지고 옴.
			HttpSession session = request.getSession(false); //없으면 null 리턴
			//수정된 회원 정보 조회해서 세션에 다시 기록함.
			Employee employee = empservice.selectEmployee(empNo);
			session.setAttribute("employee", employee);
			
			//내 정보 보기로 페이지 바꿈
			response.sendRedirect("/hiapt/empdetail?empno=" + empNo);
			
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", empNo + " 직원 정보 수정 실패");
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

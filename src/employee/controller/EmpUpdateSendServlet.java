package employee.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		employee.setEmpZipcode(request.getParameter("zipcode"));
				
		employee.setEmpAddress(String.join(",", request.getParameterValues("empaddress")));
		
		employee.setEmpEmail(request.getParameter("empemail"));
		employee.setEmpGender(request.getParameter("empgender"));
		employee.setSalary(Integer.parseInt(request.getParameter("salary").replaceAll("\\,", "")));
		employee.setPension(Integer.parseInt(request.getParameter("pension").replaceAll("\\,", "")));
		employee.setInsurance(Integer.parseInt(request.getParameter("insurance").replaceAll("\\,", "")));
		employee.setHireIns(Integer.parseInt(request.getParameter("hireins").replaceAll("\\,", "")));
		employee.setLongIns(Integer.parseInt(request.getParameter("longins").replaceAll("\\,", "")));
		employee.setIncomeTax(Integer.parseInt(request.getParameter("incometax").replaceAll("\\,", "")));
		employee.setLocalTax(Integer.parseInt(request.getParameter("localtax").replaceAll("\\,", "")));
		employee.setSalaryTot(Integer.parseInt(request.getParameter("salarytot").replaceAll("\\,", "")));
		employee.setMinusTot(Integer.parseInt(request.getParameter("minustot").replaceAll("\\,", "")));
		employee.setRealSalary(Integer.parseInt(request.getParameter("realsalary").replaceAll("\\,", "")));
		employee.setEmpEtc(request.getParameter("empetc"));;
		
		
		System.out.println("employee : " + employee);
		//3.
		EmployeeService empservice = new EmployeeService();
		
		
		int result = new EmployeeService().updateEmployee(employee);
		
		Employee family = new Employee();
		
		/*String[] fre = request.getParameterValues("frelation");
		System.out.println("fre: " + fre);

		String[] fssn = request.getParameterValues("fssn");
		String[] fn = request.getParameterValues("fname");
		String[] fdis = request.getParameterValues("fdisability");
		String[] fde = request.getParameterValues("fdeduction");
		String[] fto = request.getParameterValues("ftogether");
		String[] ftax = request.getParameterValues("ftax");
		String[] fch = request.getParameterValues("fchild");
		
		System.out.println("fre.length " + fre.length);*/
		
		ArrayList<Employee> farr = new ArrayList<Employee>();
		
		/*for(int i = 0; i <farr.length; i++) {
			family.setfRelation(request.getParameterValues("frelation")[i]);
			family.setfRelation(request.getParameterValues("fssn")[i]);
			family.setfRelation(request.getParameterValues("fname")[i]);
			family.setfRelation(request.getParameterValues("fdisability")[i]);
			family.setfRelation(request.getParameterValues("fdeduction")[i]);
			family.setfRelation(request.getParameterValues("ftogether")[i]);
			family.setfRelation(request.getParameterValues("ftax")[i]);
			family.setfRelation(request.getParameterValues("fchild")[i]);
			farr.add(new Employee(empNo, fre[i], fssn[i], fn[i], fdis[i], fde[i], fto[i], ftax[i], fch[i]));
			System.out.println("hi"+i);
			System.out.println("dd : "+farr);
			
		}*/
		int result2=0;
		for(Employee e : farr) {
		
		
		
		
		family.setfRelation(e.getfRelation());
		family.setfSSN(e.getfSSN());
		family.setfName(e.getfName());
		family.setfDisability(e.getfDisability());
		family.setfDeduction(e.getfDeduction());
		family.setfTogether(e.getfTogether());
		family.setfTax(e.getfTax());
		family.setfChild(e.getfChild());
		System.out.println("family: " + family);
		
		result2 = new EmployeeService().updateFamily(family);
		}
		
		
		
		
		
		System.out.println("result : "+result);
		//4. 수정이 성공했을 때
		if(result > 0 && result2 > 0) {
			/*HttpSession session = request.getSession(false);
			
			Employee loginMember = empservice.selectEmployee(empNo);
			session.setAttribute("loginMember", loginMember);*/
			
			
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

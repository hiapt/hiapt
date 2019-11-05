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
				
				String empId = request.getParameter("empid");
				
				employee.setEmpId(empId);
				
				employee.setEmpHireDate(Date.valueOf(request.getParameter("emphiredate")));
				employee.setEmpPhone(request.getParameter("empphone"));
				employee.setEmpSSN(request.getParameter("empssn"));
				employee.setEmpZipcode(request.getParameter("empzipcode"));
				
				
				String[] addressAll = request.getParameterValues("empaddress");
				String address = String.join(",", addressAll);
				employee.setEmpAddress(address);
				
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
				
				employee.setEmpEtc(request.getParameter("empetc"));
				
				System.out.println("employee : " + employee);
				
				
				
				int result = new EmployeeService().insertEmployee(employee);
				//System.out.println("employee : " + employee);

				int empno = new EmployeeService().selectEmpno(empId);
				
				String empNo = String.valueOf(empno);
				
				Employee family = new Employee();
				
				String[] fre = request.getParameterValues("frelation");
				//System.out.println("fre: " + fre);

				String[] fssn = request.getParameterValues("fssn");
				String[] fn = request.getParameterValues("fname");
				String[] fdis = request.getParameterValues("fdisability");
				String[] fde = request.getParameterValues("fdeduction");
				String[] fto = request.getParameterValues("ftogether");
				String[] ftax = request.getParameterValues("ftax");
				String[] fch = request.getParameterValues("fchild");
				
				//System.out.println("fre.length " + fre.length);
				
				ArrayList<Employee> farr = new ArrayList<Employee>();
				
				for(int i = 0; i <fre.length; i++) {
					/*String ffre = fre[i];
					String ffssn= fssn[i];
					String ffn = fn[i];
					String ffdis = fdis[i];
					String ffde = fde[i];
					String ffto = fto[i];
					String fftax = ftax[i];
					String ffch = fch[i];
					family.setfSSN(fssn[i]);
					family.setfName(fn[i]);
					family.setfDisability(fdis[i]);
					family.setfDeduction(fde[i]);
					family.setfTogether(fto[i]);
					family.setfTax(ftax[i]);
					family.setfChild(fch[i]);*/
					
					farr.add(new Employee(empNo, fre[i], fssn[i], fn[i], fdis[i], fde[i], fto[i], ftax[i], fch[i]));
					System.out.println("hi"+i);
					System.out.println("dd : "+farr);
					
				}
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
				
				result2 = new EmployeeService().insertFamily(empno, family);
				}
				
				
				
				if(result > 0 && result2 >0) {
					/*String empNo = request.getParameter("empno");
					
					int empno = new EmployeeService().selectEmpno(empId);
					
					Employee family = new Employee();
					
					String[] fre = request.getParameterValues("frelation");
					String[] fssn = request.getParameterValues("fssn");
					String[] fn = request.getParameterValues("fname");
					String[] fdis = request.getParameterValues("fdisability");
					String[] fde = request.getParameterValues("fdeduction");
					String[] fto = request.getParameterValues("ftogether");
					String[] ftax = request.getParameterValues("ftax");
					String[] fch = request.getParameterValues("fchild");
					
					
					for(int i = 0; i <fre.length; i++) {
						family.setfRelation(fre[i]);
						family.setfSSN(fssn[i]);
						family.setfName(fn[i]);
						family.setfDisability(fdis[i]);
						family.setfDeduction(fde[i]);
						family.setfTogether(fto[i]);
						family.setfTax(ftax[i]);
						family.setfChild(fch[i]);
					}*/
					
					
						response.sendRedirect("/hiapt/emplist");
				}else {
					RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "회원 가입2 실패!");
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

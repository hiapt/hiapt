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
 * Servlet implementation class EloginServlet
 */
@WebServlet("/ein")
public class EloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EloginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String empNo = request.getParameter("eid");
         String empPwd = request.getParameter("epwd");
         
         Employee employee = new EmployeeService().loginCheck(empNo, empPwd);
         
         if(employee != null) {
            HttpSession session = request.getSession();
            session.setAttribute("employee", employee);
            response.sendRedirect("/hiapt/index.jsp");
         }else {
            RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
            request.setAttribute("message", "로그인 실패! 아이디나 암호를 확인하고 다시 로그인하세요.");
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

package draft.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import draft.model.service.DraftService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class NewDocCountServlet
 */
@WebServlet("/ncount")
public class NewDocCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDocCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DraftService dservice = new DraftService();
		HttpSession session = request.getSession(false);
		Employee emp = (Employee)session.getAttribute("employee");
		int ncount = 0;
		if(emp.getEmpNo().equals("admin")) {
			ncount = dservice.getNewListCountAdmin();
		}else {
			ncount = dservice.getNewListCountEmp(emp.getEmpNo());
		}
		PrintWriter out = response.getWriter();
		out.append(String.valueOf(ncount));
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

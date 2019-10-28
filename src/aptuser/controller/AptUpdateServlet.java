package aptuser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aptuser.model.service.UloginService;
import aptuser.model.vo.Aptuser;

/**
 * Servlet implementation class AptUpdateServlet
 */
@WebServlet("/aptupdate")
public class AptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AptUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		Aptuser aptuser = new Aptuser();
		
		String userId = request.getParameter("userid");
		
		
		UloginService aptservice = new UloginService();
		Aptuser apt = new UloginService().selectAptuser(userId);
		
		RequestDispatcher view = null;
		if(apt != null) {
			view = request.getRequestDispatcher("views/user/apt/aptUpdate.jsp");
			request.setAttribute("apt", apt);
			
			//response.sendRedirect("/hiapt/empdetail?empno=" + empNo);
		
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", " 세대주 수정 실패");
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

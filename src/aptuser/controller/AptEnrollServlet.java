package aptuser.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aptuser.model.service.UloginService;
import aptuser.model.vo.Aptuser;


/**
 * Servlet implementation class AptEnrollServlet
 */
@WebServlet("/aptenroll")
public class AptEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AptEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Aptuser aptuser = new Aptuser();
		
		String[] useridAll = request.getParameterValues("userid");
		String userid = String.join("-", useridAll);
		aptuser.setUserId(userid);
		
		aptuser.setUserEnroll(Date.valueOf(request.getParameter("userenroll")));
		aptuser.setUserName(request.getParameter("username"));
		aptuser.setUserBirth(Date.valueOf(request.getParameter("userbirth")));
		aptuser.setUserPhone(request.getParameter("userphone"));
		aptuser.setUserEmail(request.getParameter("useremail"));
		aptuser.setUserEtc(request.getParameter("useretc"));
		aptuser.setCarType(request.getParameter("cartype"));
		aptuser.setCarNo(request.getParameter("carno"));
		aptuser.setCarEnroll(Date.valueOf(request.getParameter("carenroll")));
		
		System.out.println("aptuser : " + aptuser);
		
		int result = new UloginService().insertAptuser(aptuser);
		
		if(result > 0) {
			response.sendRedirect("/hiapt/index.jsp");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "세대주등록 실패!");
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

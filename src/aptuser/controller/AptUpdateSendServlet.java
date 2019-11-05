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
 * Servlet implementation class AptUpdateSendServlet
 */
@WebServlet("/aptupdsend")
public class AptUpdateSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AptUpdateSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		Aptuser aptuser = new Aptuser();
		
		String userId = String.join("-", request.getParameterValues("userid"));
		aptuser.setUserId(userId);
		
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
		//3.
		UloginService aptservice = new UloginService();
		
		
		int result = new UloginService().updateAptuser(aptuser);
		
		System.out.println("result : "+result);
		if(result > 0) {
			
			
			response.sendRedirect("/hiapt/aptdetail?userid=" + userId);
			
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

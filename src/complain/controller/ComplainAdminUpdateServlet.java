package complain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import complain.model.service.ComplainService;
import complain.model.vo.Complain;

/**
 * Servlet implementation class ComplainAdminUpdateServlet
 */
@WebServlet("/co.ad.update")
public class ComplainAdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainAdminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Complain comp = new Complain();
		
		comp.setCompNo(Integer.parseInt(request.getParameter("cno")));
		comp.setCompReponse(request.getParameter("cresponse"));
		comp.setCompResultStatus(request.getParameter("cresult"));
		
		int result = new ComplainService().updateAdminComplain(comp);
		
		RequestDispatcher view = null;
		if(result > 0) {
			response.sendRedirect("/hiapt/co.list");
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "민원 답변등록 실패!");
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

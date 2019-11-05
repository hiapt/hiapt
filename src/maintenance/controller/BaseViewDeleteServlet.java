package maintenance.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.BaseViewService;
import maintenance.model.vo.Bill;

/**
 * Servlet implementation class BaseViewDeleteServlet
 */
@WebServlet("/bvidel")
public class BaseViewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseViewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// baseView 삭제 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		int result = 0;
		String[] merchantUides = request.getParameterValues("checkRow");
		for(String s : merchantUides) {
			long merchantUid = Long.parseLong(s);
			result = new BaseViewService().deleteBaseView(merchantUid);
			System.out.println(result);
		}
		
		RequestDispatcher view = null;
		if(result > 0) {
			response.sendRedirect("/hiapt/bvis");
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "고지서 삭제 실패!");
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

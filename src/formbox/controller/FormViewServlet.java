package formbox.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formbox.model.service.FormboxService;
import formbox.model.vo.Formbox;

/**
 * Servlet implementation class FormViewServlet
 */
@WebServlet("/fview")
public class FormViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FormboxService fservice = new FormboxService();
		
		ArrayList<Formbox> list = fservice.selectList();

		RequestDispatcher view = null; //아래 if else 둘 다에서 사용함 --> 미리 만들어놓음
	
		if(list.size() > 0) {
			
			view = request.getRequestDispatcher("views/emp/approval/formView.jsp");

			request.setAttribute("list", list);
		
				
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "목록에 문서가 없습니다.");
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

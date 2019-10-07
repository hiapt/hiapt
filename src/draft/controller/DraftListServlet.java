package draft.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import draft.model.service.DraftService;
import draft.model.vo.Draft;

/**
 * Servlet implementation class DraftListServlet
 */
@WebServlet("/dlist")
public class DraftListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전자결재 목록
		ArrayList<Draft> list = new DraftService().selectAll();
		RequestDispatcher view = null; //아래 if else 둘 다에서 사용함 --> 미리 만들어놓음
	
		if(list.size() > 0) {
			
			view = request.getRequestDispatcher("views/employee/approval/docList.jsp");

			request.setAttribute("list", list);
				
				
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "공지사항 전체 목록 조회 실패!");
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

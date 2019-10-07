package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeAdminListView
 */
@WebServlet("/nlist.ad")
public class NoticeAdminListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeAdminListView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*ArrayList<Notice> list = new ArrayList<Notice>();
		NoticeService nservice = new NoticeService();
		list = nservice.selectAll();*/
		ArrayList<Notice> list = new NoticeService().selectAll();
		
		RequestDispatcher view = null;
		if(list.size()>0) {
		view=request.getRequestDispatcher("views/notice/AdmintListView.jsp");
		request.setAttribute("list", list);	
		}else {
		view=request.getRequestDispatcher("views/common/error.jsp");
		request.setAttribute("message", "공지사항");
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

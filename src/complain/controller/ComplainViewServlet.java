package complain.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import complain.model.service.ComplainService;
import complain.model.vo.Complain;
import complain.model.vo.ComplainImgs;
import employee.model.vo.Employee;

/**
 * Servlet implementation class ComplainViewServlet
 */
@WebServlet("/co.view")
public class ComplainViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt(request.getParameter("cno"));
		int currentPage = 1;
		String upORview = request.getParameter("uporview");

		ComplainService cservice = new ComplainService();

		Complain comp = cservice.selectView(cNo);//게시판
		ArrayList<ComplainImgs> imglist = cservice.selectImgs(cNo);//이미지목록
		
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		RequestDispatcher view = null;
		request.setAttribute("comp", comp);
		request.setAttribute("imglist", imglist);
		currentPage = Integer.parseInt(request.getParameter("page"));
		request.setAttribute("currentPage", currentPage);
		
			if(comp != null) {
				if(employee !=null) {//직원일경우
				view = request.getRequestDispatcher("views/master/complain/complainAdminDetailView.jsp");
				}else {//세대주일경우
				if(upORview.equals("view")) {//상세보기일겨우
				view = request.getRequestDispatcher("views/user/complain/complainDetailView.jsp");
				}else{//업데이트일경우
				view = request.getRequestDispatcher("views/user/complain/complainUpdate.jsp");
				}
				}//세대주일경우
			}else {
				view = request.getRequestDispatcher("views/common/user404.jsp");
				request.setAttribute("message", "민원 상세조회 실패!");
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

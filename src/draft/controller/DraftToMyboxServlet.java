package draft.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import draft.model.service.DraftService;
import mybox.model.service.MyboxService;
import mybox.model.vo.Mybox;

/**
 * Servlet implementation class DraftToMyboxServlet
 */
@WebServlet("/dmbox")
public class DraftToMyboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftToMyboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] docnoArr = request.getParameterValues("docno");
		String empno = request.getParameter("empno");
		String myboxcode = request.getParameter("myboxcode");
		int result = 0;
		Mybox mbox = new Mybox();
		for(String docno : docnoArr) {
			System.out.println(docno + empno); 
			mbox.setDocno(Integer.parseInt(docno));
			mbox.setEmpno(empno);
			mbox.setMyboxcode(myboxcode);
			result = new MyboxService().insertMybox(mbox);
		}	
		
		if(result > 0) {
			response.sendRedirect("/hiapt/mylist.emp?empno=" + empno + "&myboxcode=" + myboxcode + "&page=1");
			
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "내문서함에 저장하기 실패");
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

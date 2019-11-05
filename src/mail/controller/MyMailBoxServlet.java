package mail.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mail.model.service.MailService;
import mail.model.vo.Mailm;

/**
 * Servlet implementation class MyMailBoxServlet
 */
@WebServlet("/mymb")
public class MyMailBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMailBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int mcode = Integer.parseInt(request.getParameter("mcode"));
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		System.out.println(mcode + ", " + email + ", " + name);
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10;	//한 페이지에 출력할 목록 갯수
		MailService mservice = new MailService();
		
		int listCount = mservice.getListCountMy(email, mcode);		//테이블의 전체 목록 갯수 조회
		//총 페이지 수 계산
		int maxPage = listCount / limit;
		if(listCount % limit > 0)
			maxPage++;
		System.out.println(listCount);
		
		//currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
		//예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
		int beginPage = (currentPage / limit) * limit + 1;
		int endPage = beginPage + limit - 1;
		if(endPage > maxPage)
			endPage = maxPage;
		
		//currentPage 에 출력할 목록의 조회할 행 번호 계산
		int startRow = (currentPage * limit) - 9 ;
		int endRow = currentPage * limit;
		
		//조회할 목록의 시작행과 끝행 번호 전달하고 결과받기
		ArrayList<Mailm> list = mservice.selectListMy(email, mcode, startRow, endRow);
		
		RequestDispatcher view = null;
		if(list.size() >= 0) {
			view = request.getRequestDispatcher("views/emp/mail/myBoxMail.jsp");
			request.setAttribute("list", list);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("name", name);
			request.setAttribute("mcode", mcode);
			view.forward(request, response);								
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", currentPage + " 페이지 목록 조회 실패!");
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

package draft.controller;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class DraftSearchServlet
 */
@WebServlet("/dsearch")
public class DraftSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 검색 처리용 컨트롤러
				// 제목 검색, 작성자 검색, 작성날짜 검색 기능
				
				//1. 인코딩 처리
				request.setCharacterEncoding("utf-8");
				
				//2. 변수에 옮기기
				String search = request.getParameter("search");
				
				//3. 
				ArrayList<Draft> list = null;
				DraftService dservice = new DraftService();
				
				switch(search) {
				case "title" :  String draftTitle = request.getParameter("keyword"); 	//case "" 에는 value 값 써야함 // parameter 에는 name 값
									list = dservice.draftTitleSearch(draftTitle);
									break;
				case "writer" : String draftWriter = request.getParameter("keyword");
									list = dservice.draftWriterSearch(draftWriter);	break;
				case "date" : 	String beginDate = request.getParameter("from");
									String toDate = request.getParameter("to");
									list = dservice.draftDateSearch(Date.valueOf(beginDate), Date.valueOf(toDate));
									break;
				case "formtype" : String draftFormname = request.getParameter("keyword");
									list = dservice.draftFormtypeSearch(draftFormname);	break;
				}
				
				//4.
				RequestDispatcher view = null;
				if(list.size()>0) {
					view = request.getRequestDispatcher("views/emp/approval/docList.jsp");
					request.setAttribute("list", list);
					view.forward(request, response);
					
					
				}else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", search + "검색 조회 실패!!");
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

package formbox.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import draft.model.service.DraftService;
import formbox.model.service.FormboxService;
import formbox.model.vo.Formbox;

/**
 * Servlet implementation class FormSearchServlet
 */
@WebServlet("/fsearch")
public class FormSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// 2. 변수에 옮기기
		String search = request.getParameter("search");
		// 3.
		RequestDispatcher view = null;
		ArrayList<Formbox> list = null;
		FormboxService fservice = new FormboxService();

		int currentPage = 1;

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10; // 한 페이지에 출력할 목록 갯수
		
		// currentPage 에 출력할 목록의 조회할 행 번호 계산
		int startRow = (currentPage * limit) - 9;
		int endRow = currentPage * limit;

		switch (search) {
		case "title":

			String formName = request.getParameter("keyword");


			int listCount = fservice.getFormListSearchT(formName); // 테이블의 전체 목록 갯수 조회
			// 총 페이지 수 계산
			int maxPage = listCount / limit;
			if (listCount % limit > 0)
				maxPage++;

			// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
			// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
			int beginPage = (currentPage / limit) * limit + 1;
			int endPage = beginPage + 9;
			if (endPage > maxPage)
				endPage = maxPage;


			list = fservice.draftFormSearchName(formName, startRow, endRow);
			
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/master/approval/formList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("count", listCount);
				request.setAttribute("keyword", formName);
				
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "해당 양식명이 존재하지 않습니다.");
			}

			view.forward(request, response);	 
			break;
			
		case "formtype":
			String formType = request.getParameter("keyword");
			int listCount2 = fservice.getFormListSearchF(formType); // 테이블의 전체 목록 갯수 조회
			// 총 페이지 수 계산
			int maxPage2 = listCount2 / limit;
				maxPage2++;

			// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
			// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
			int beginPage2 = (currentPage / limit) * limit + 1;
			int endPage2 = beginPage2 + 9;
			if (endPage2 > maxPage2)
				endPage2 = maxPage2;

			list = fservice.draftFormSearchType(formType, startRow, endRow);


			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/master/approval/formList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage2);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage2);
				request.setAttribute("endPage", endPage2);
				request.setAttribute("count", listCount2);
				request.setAttribute("keyword", formType);
				
			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "해당 문서양식이 존재하지 않습니다.");
			}
			view.forward(request, response);	 break;
			
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

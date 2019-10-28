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
 * Servlet implementation class DraftReturnSearchServlet
 */
@WebServlet("/dsearchr")
public class DraftReturnSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftReturnSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 제목 검색, 작성자 검색, 작성날짜 검색, 문서형식 검색 기능

				// 1. 인코딩 처리
				request.setCharacterEncoding("utf-8");

				// 2. 변수에 옮기기
				String search = request.getParameter("search");
				String empno = request.getParameter("empno");
				String progress = "2";
				
				// 3.
				RequestDispatcher view = null;
				ArrayList<Draft> list = null;
				DraftService dservice = new DraftService();

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

					String draftTitle = request.getParameter("keyword");
					
					int listCount = dservice.getProgressSearchCountT(draftTitle, empno, progress); // 테이블의 전체 목록 갯수 조회
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


					list = dservice.draftProgressTitleSearch(draftTitle, empno, startRow, endRow, progress);

					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/emp/approval/returnDoc.jsp");
						request.setAttribute("list", list);
						request.setAttribute("maxPage", maxPage);
						request.setAttribute("currentPage", currentPage);
						request.setAttribute("beginPage", beginPage);
						request.setAttribute("endPage", endPage);
						request.setAttribute("count", listCount);
						request.setAttribute("keyword", draftTitle);

					} else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", "해당 제목이 존재하지 않습니다.");
					}

					view.forward(request, response);	 break;
					
				case "writer":
					String draftWriter = request.getParameter("keyword");
					
					int listCount2 = dservice.getProgressSearchCountW(draftWriter, empno, progress); // 테이블의 전체 목록 갯수 조회
					// 총 페이지 수 계산
					int maxPage2 = listCount2 / limit;
						maxPage2++;

					// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
					// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
					int beginPage2 = (currentPage / limit) * limit + 1;
					int endPage2 = beginPage2 + 9;
					if (endPage2 > maxPage2)
						endPage2 = maxPage2;

					list = dservice.draftProgressWriterSearch(draftWriter, empno, startRow, endRow, progress);


					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/emp/approval/returnDoc.jsp");
						request.setAttribute("list", list);
						request.setAttribute("maxPage", maxPage2);
						request.setAttribute("currentPage", currentPage);
						request.setAttribute("beginPage", beginPage2);
						request.setAttribute("endPage", endPage2);
						request.setAttribute("count", listCount2);
						request.setAttribute("keyword", draftWriter);
						
					} else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", search + "해당 작성자가 존재하지 않습니다.");
					}

					view.forward(request, response);	 break;
					
				case "date":
					String beginDate = request.getParameter("from");
					String toDate = request.getParameter("to");
					
					int listCount3 = dservice.getProgressSearchCountD(Date.valueOf(beginDate), Date.valueOf(toDate), empno, progress); // 테이블의 전체 목록 갯수 조회
					// 총 페이지 수 계산
					int maxPage3 = listCount3 / limit;
						maxPage3++;

					// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
					// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
					int beginPage3 = (currentPage / limit) * limit + 1;
					int endPage3 = beginPage3 + 9;
					if (endPage3 > maxPage3)
						endPage3 = maxPage3;

					list = dservice.draftProgressDateSearch(Date.valueOf(beginDate), Date.valueOf(toDate), empno, startRow, endRow, progress);


					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/emp/approval/returnDoc.jsp");
						request.setAttribute("list", list);
						request.setAttribute("maxPage", maxPage3);
						request.setAttribute("currentPage", currentPage);
						request.setAttribute("beginPage", beginPage3);
						request.setAttribute("endPage", endPage3);
						request.setAttribute("count", listCount3);
						request.setAttribute("begin", beginDate.toString());
						request.setAttribute("to", toDate.toString());
						
					} else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", "해당 문서가 존재하지 않습니다.");
					}
					view.forward(request, response);	 break;
					
					
				case "formtype":
					String draftFormname = request.getParameter("keyword");
					int listCount4 = dservice.getProgressSearchCountF(draftFormname, empno, progress); // 테이블의 전체 목록 갯수 조회
					// 총 페이지 수 계산
					int maxPage4 = listCount4 / limit;
						maxPage4++;

					// currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
					// 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
					int beginPage4 = (currentPage / limit) * limit + 1;
					int endPage4 = beginPage4 + 9;
					if (endPage4 > maxPage4)
						endPage4 = maxPage4;

					list = dservice.draftProgressFormtypeSearch(draftFormname, empno, startRow, endRow, progress);


					if (list.size() > 0) {
						view = request.getRequestDispatcher("views/emp/approval/returnDoc.jsp");
						request.setAttribute("list", list);
						request.setAttribute("maxPage", maxPage4);
						request.setAttribute("currentPage", currentPage);
						request.setAttribute("beginPage", beginPage4);
						request.setAttribute("endPage", endPage4);
						request.setAttribute("count", listCount4);
						request.setAttribute("keyword", draftFormname);
						
					} else {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", "해당 문서가 존재하지 않습니다.");
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

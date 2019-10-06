package maintenance.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maintenance.model.service.BillViewService;
import maintenance.model.vo.BillView;

/**
 * Servlet implementation class BillViewServlet
 */
@WebServlet("/bwlist")
public class BillViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 고지서 간략 리스트 조회 처리용 컨트롤러 : 페이징 처리됨
		
		ArrayList<BillView> list = new ArrayList<BillView>();
		BillViewService bwservice = new BillViewService();		
		
		int currentPage = 1; //현재 보여지는 페이지
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int limit = 10; // 한 페이지에 출력할 목록 갯수
		
		
		int listCount = bwservice.getListCount(); // 테이블 전체 목록 갯수 조회
		// 총 페이지 수 계산
		int maxPage = listCount / limit;//몫만 나옴
		if(listCount % limit > 0)
			maxPage++; //최대 페이지를 0증가 시켜라
		
		// currentPage 가 속한 그룹의 시작페이지 숫자와 끝 숫자 계산
		int beginPage = (currentPage / limit) * limit + 1;
		int endPage = beginPage + 9;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		int startRow = (currentPage * limit) - 9; // 시작 페이지
		int endRow = currentPage * limit; // 끝 페이지
		
		// 조회할 목록의 시작행과 끝행 번호 전달하고 결과 받기
		list = bwservice.selectList(startRow, endRow);		
		//list = bwservice.selectList();
		
		RequestDispatcher view = null;
		
		if(list.size() > 0 ) {
			view = request.getRequestDispatcher("views/employee/maintenance/BillViewList.jsp");
			request.setAttribute("list", list);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "고지서 조회 실패!");			
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

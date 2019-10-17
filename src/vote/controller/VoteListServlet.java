package vote.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vote.model.service.VoteService;
import vote.model.vo.Vote;

/**
 * Servlet implementation class VoteListServlet
 */
@WebServlet("/vo.list")
public class VoteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String titleName= request.getParameter("titlename");
		System.out.println(titleName);
		if(titleName != null) { //제목입력 했을시.
			System.out.println("titlename");
		int listCount = new VoteService().getSearchListCount(titleName);
		int listSize = 3; 	// 페이지당 목록수 3개
		int pageSize = 3; // 페이징바당 페이지개수 3개
		int currentPage = 1; //현재페이지  1~3목록이보여야함
		//인덱스에서 처음 들어올땐  기본값1 나머지는 if문으로 체크
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}	
		//1페이지에는 1~3 목록
		//2 4~6
		//3 7~9
		int maxPage = listCount / listSize; // 마지막페이지완전끝
		if(listCount % listSize >0 )
			maxPage++;
		//1 4 7 ...                            1 / 3
		int beginPage=(currentPage/pageSize)*pageSize+1;
		if(currentPage%pageSize==0) {
			beginPage -= pageSize;
		}
		int endPage = beginPage + (pageSize-1); //목록에서의 끝페이지 1~3에서 3
		if(endPage > maxPage)
			endPage = maxPage;
		
		int startlist = (currentPage * listSize)-(listSize-1); //시작목록 1 4
		int endlist = currentPage * listSize; //마지막목록                 3 6
		
		ArrayList<Vote> vlist = new VoteService().searchTitle(titleName,startlist,endlist);

		RequestDispatcher view =null;
		if(vlist.size()>0) {
		view = request.getRequestDispatcher("views/master/vote/voteAdminListView.jsp");
		request.setAttribute("vlist", vlist);	
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("titlename", titleName);
		}else{
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "주민투표 리스트 조회 실패");
		}
		view.forward(request, response);
		
		}else {//null(시작)시
			int listCount = new VoteService().getListCount();
			System.out.println(listCount);
			int listSize = 3; 	// 페이지당 목록수 3개
			int pageSize = 3; // 페이징바당 페이지개수 3개
			int currentPage = 1; //현재페이지  1~3목록이보여야함
			//인덱스에서 처음 들어올땐  기본값1 나머지는 if문으로 체크
			if(request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}	
			System.out.println(currentPage);
			//1페이지에는 1~3 목록
			//2 4~6
			//3 7~9
			int maxPage = listCount / listSize; // 마지막페이지완전끝
			if(listCount % listSize >0 )
				maxPage++;
			//1 4 7 ...                            1 / 3
			int beginPage=(currentPage/pageSize)*pageSize+1;
			if(currentPage%pageSize==0) {
				beginPage -= pageSize;
			}
			int endPage = beginPage + (pageSize-1); //목록에서의 끝페이지 1~3에서 3
			if(endPage > maxPage)
				endPage = maxPage;
			
			int startlist = (currentPage * listSize)-(listSize-1); //시작목록 1 4
			int endlist = currentPage * listSize; //마지막목록                 3 6
			
			ArrayList<Vote> vlist = new VoteService().selectList(startlist,endlist);

			RequestDispatcher view =null;
			if(vlist.size()>0) {
			view = request.getRequestDispatcher("views/master/vote/voteAdminListView.jsp");
			request.setAttribute("vlist", vlist);	
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("beginPage", beginPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("titlename", titleName);
			}else{
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "주민투표 리스트 조회 실패");
			}
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

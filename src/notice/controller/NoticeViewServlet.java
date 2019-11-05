package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.vo.BoardFiles;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.NoticeFiles;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet("/no.view")
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 관리자용 공지 상세보기, 세대주용 공지 상세보기, 관리자용 공지 수정하기 처리용 서블릿
				String want = request.getParameter("uporview");
				//want는 admin, view, up
				int nNo = Integer.parseInt(request.getParameter("nno"));
				int currentPage = Integer.parseInt(request.getParameter("page"));
				NoticeService nservice = new NoticeService();
				Notice notice = nservice.selectOne(nNo);
				ArrayList<NoticeFiles> nfiles = nservice.selectFile(nNo);//파일목록
				

				
				RequestDispatcher view = null;
				
				if(notice != null) {
					if(want.equals("admin")) {
						nservice.updateReadCount(nNo);	
						view = request.getRequestDispatcher("views/master/notice/noticeAdminDetailView.jsp");
					}else if(want.equals("view")) {
						nservice.updateReadCount(nNo);	
						view = request.getRequestDispatcher("views/user/notice/noticeDetailView.jsp");
					}else if(want.equals("up")){
						view = request.getRequestDispatcher("views/master/notice/noticeAdminUpdateForm.jsp");
					}		
					request.setAttribute("nfiles", nfiles);
					
					request.setAttribute("notice", notice);
					request.setAttribute("currentPage", currentPage);
				}else {	
					
					if(want.equals("admin")) {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", nNo + "번 공지 상세조회 실패!");
					}else if(want.equals("view")) {
						view = request.getRequestDispatcher("views/common/user404.jsp");
						request.setAttribute("message", nNo+"번 공지 상세조회 실패!");
					}else if(want.equals("up")) {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", nNo+"번 게시글 수정페이지 이동 실패!");
					}	
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

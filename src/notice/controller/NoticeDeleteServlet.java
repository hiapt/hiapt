package notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.BoardFiles;
import notice.model.service.NoticeService;
import notice.model.vo.NoticeFiles;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/no.del")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		
		// 1.
		request.setCharacterEncoding("utf-8");
		NoticeService nservice = new NoticeService();
		// 2.
		int noticeNo = Integer.parseInt(request.getParameter("nno"));
		ArrayList<NoticeFiles> nfiles = nservice.selectFile(noticeNo);

		// 3.
		int result = nservice.deleteNotice(noticeNo);
		// 4.
		if (result > 0) {
			if (nfiles.size() > 0) {
				for (NoticeFiles nf : nfiles) {
					String renameFileName = nf.getNoticeRnameFileName();
					if (renameFileName != null) {
						String savePath = request.getSession().getServletContext()
								.getRealPath("/resources/notice_upfiles");
						File renameFile = new File(savePath + "\\" + renameFileName);
						renameFile.delete();
					} // rename 삭제 이프
				} // bf포문
			} // bfiles size if문
			response.sendRedirect("/hiapt/no.list");

		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/user404.jsp");
			request.setAttribute("message", noticeNo+"번 공지사항 삭제 실패!");
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

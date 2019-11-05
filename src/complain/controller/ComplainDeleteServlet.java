package complain.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.vo.BoardFiles;
import complain.model.service.ComplainService;
import complain.model.vo.ComplainImgs;

/**
 * Servlet implementation class ComplainDeleteServlet
 */
@WebServlet("/co.delete")
public class ComplainDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.
				request.setCharacterEncoding("utf-8");
				ComplainService cservice = new ComplainService();
				// 2.
				int cNo = Integer.parseInt(request.getParameter("compno"));
				ArrayList<ComplainImgs> imglist = cservice.selectImgs(cNo);;

				// 3.
				int result = cservice.deleteComplain(cNo);
				// 4.
				if (result > 0) {
					if (imglist.size() > 0) {
						for (ComplainImgs ci : imglist) {
							String renameFileName = ci.getCompRenameImgname();
							if (renameFileName != null) {
								String savePath = request.getSession().getServletContext()
										.getRealPath("/resources/complainImgs");
								File renameFile = new File(savePath + "\\" + renameFileName);
								renameFile.delete();
							} // rename 삭제 이프
						} // ci포문
					} // size if문
					response.sendRedirect("/hiapt/co.list");

				} else {
					RequestDispatcher view = request.getRequestDispatcher("views/common/user404.jsp");
					request.setAttribute("message", "민원 삭제 실패!");
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

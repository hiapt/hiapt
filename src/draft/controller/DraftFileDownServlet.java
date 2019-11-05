package draft.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DraftFileDownServlet
 */
@WebServlet("/dfiled")
public class DraftFileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftFileDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String savePath = request.getSession().getServletContext().getRealPath("/resources/draft_upload");
				
				String originname = request.getParameter("ofile");
				String renamename = request.getParameter("rfile");
				
				File downFile = new File(savePath + "/" + renamename);
				BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
				
				ServletOutputStream downOut = response.getOutputStream();
				
				response.setContentType("text/plain; charset=utf-8");
				response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(originname.getBytes("UTF-8"), "ISO-8859-1") +"\"");
				
				response.setContentLength((int) downFile.length());
				
				int read = -1;
				while((read = bin.read()) != -1) {
					downOut.write(read);
					downOut.flush();
				}
				
				//스트림 닫기
				downOut.close();
				bin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

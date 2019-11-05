package draft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import draft.model.service.DraftService;
import draft.model.vo.Draft;

/**
 * Servlet implementation class DraftSendServlet
 */
@WebServlet("/dsend")
public class DraftSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DraftSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기안 전송
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form 태그에 enctype 속성 사용 안 되었음.");
			view.forward(request, response);
		}
		int maxSize = 1024 * 1024 * 20;
		String savePath = request.getSession().getServletContext().getRealPath("/resources/draft_upload");
		
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		
		String empno = mrequest.getParameter("drafter");
		String deadline = mrequest.getParameter("deadline");
		String[] apparr = mrequest.getParameterValues("approver");
		String approver = String.join(",", apparr);
		String[] disarr = mrequest.getParameterValues("display");
		String display ="";
		if(disarr != null) {
			display = String.join(",", disarr);
		}
		
		Draft draft = new Draft();
		draft.setEmpno(mrequest.getParameter("drafter"));
		draft.setDisplay(display);
		draft.setDoctitle(mrequest.getParameter("drafttitle"));
		draft.setDoccontent(mrequest.getParameter("doccontent"));
		draft.setFormcode(Integer.parseInt(mrequest.getParameter("formcode")));
		draft.setDocstatus(mrequest.getParameter("docstatus"));
		draft.setDisplay(mrequest.getParameter("display"));
		draft.setApprover(approver);
		if(draft.equals("") || draft == null) {
			draft.setDeadline(null);
		}else {
			draft.setDeadline(Date.valueOf(deadline));
		}
		
		String originname = mrequest.getFilesystemName("draftup");
		
		
		if(originname != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			
			String renamename = sdf.format( new java.sql.Date(System.currentTimeMillis())) + "." + originname.substring(originname.lastIndexOf(".") + 1);
			
			File originalfile = new File(savePath + "\\" + originname);
			File renamefile = new File(savePath + "\\" + renamename);
			
			if(!originalfile.renameTo(renamefile)) {
				int read = -1;
				byte[] buf = new byte[1024];	
				
				FileInputStream fin = new FileInputStream(originalfile);
				FileOutputStream fout = new FileOutputStream(renamefile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				fin.close();
				fout.close();
				originalfile.delete();
			}
			draft.setOriginfile(originname);
			draft.setRenamefile(renamename);
			
		}
		
		System.out.println("draft : " + draft );

		int result = new DraftService().insert(draft);
		
		if(result > 0) {
			response.sendRedirect("/hiapt/dlist?empno=" + empno + "&page=1");
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "기안작성실패");
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

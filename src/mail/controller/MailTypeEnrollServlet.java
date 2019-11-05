package mail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import mail.model.service.MailService;
import mail.model.vo.MailBoxType;

/**
 * Servlet implementation class MailTypeEnrollServlet
 */
@WebServlet("/mtenroll")
public class MailTypeEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailTypeEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mbox = request.getParameter("mbox");
		String email = request.getParameter("empemail");
		
		MailService mservice = new MailService();
		int result = mservice.enrollMailBox(mbox, email);
		MailBoxType mbt = mservice.selectOneMailBox(mbox, email);
		
		JSONObject job = new JSONObject();
		job.put("mcode", mbt.getMailCode());
		job.put("name", URLEncoder.encode(mbt.getMailBoxName(), "UTF-8"));
		job.put("email", mbt.getEmpEmail());

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(job.toJSONString());
		out.flush();
		out.close();		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

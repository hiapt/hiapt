package formbox.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import formbox.model.service.FormboxService;
import formbox.model.vo.Formbox;

/**
 * Servlet implementation class FormSelectServlet
 */
@WebServlet("/fselect")
public class FormSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String form = request.getParameter("form");
			int formcode = 0;
			FormboxService fservice = new FormboxService();
			Formbox fbox = new Formbox();
			if(form != null) {
			formcode = Integer.parseInt(form);
			fbox = fservice.selectOne(formcode);
			}
			JSONObject job = new JSONObject();	

				job.put("form", URLEncoder.encode(fbox.getFormcontent(), "UTF-8"));
				job.put("no", fbox.getFormcode());
				
				System.out.println("job : " + job.toJSONString());
				
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

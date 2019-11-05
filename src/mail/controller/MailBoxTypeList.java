package mail.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import mail.model.service.MailService;
import mail.model.vo.MailBoxType;

/**
 * Servlet implementation class MailBoxTypeList
 */
@WebServlet("/mbtlist")
public class MailBoxTypeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailBoxTypeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("empemail");
		
		ArrayList<MailBoxType> list = new MailService().selectMailBoxList(email);
		//전송용 json 객체 생성
				JSONObject sendJson = new JSONObject();
				//list 옮겨 저장할 json 배열객체 생성
				JSONArray jarr = new JSONArray();
				
				//list 를 jarr 로 옮기기
				for(MailBoxType m : list) {
					//b 객체 저장할 json 객체 생성
					JSONObject job = new JSONObject();
					job.put("mcode", m.getMailCode());
					//JSON 에서 한글깨짐 막으려면, java.net.URLEncoder.encode() 메소드로 인코딩 처리
					job.put("name", URLEncoder.encode(m.getMailBoxName(), "UTF-8"));
					job.put("email", m.getEmpEmail());
					
					jarr.add(job);
				}
				
				//json 배열을 전송용 json 객체에 저장함
				sendJson.put("list", jarr);
				
				//요청한 뷰로 응답처리함
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write(sendJson.toJSONString());
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

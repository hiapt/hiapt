package schedule.controller;

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

import schedule.model.service.ScheduleService;
import schedule.model.vo.Schedule;

/**
 * Servlet implementation class ScheduleListServlet
 */
@WebServlet("/schlist")
public class ScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		
		
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		System.out.println("year : "+ year + ", month : "+month);
		String writer = request.getParameter("writer");
		//request.getParameter("month");
		String ym = year+"-"+month;
		ArrayList<Schedule> list = new ScheduleService().selectAll(ym, writer);
	
		JSONObject sendJSON = new  JSONObject();
		JSONArray jarr = new JSONArray();
		for(Schedule s : list) {
			JSONObject job = new JSONObject();
			job.put("cnum", s.getSchNo());
			job.put("ctitle", URLEncoder.encode(s.getSchTitle()));
			job.put("cstart", s.getSchStart().toString());
			job.put("cend", s.getSchEnd().toString());
			job.put("color", URLEncoder.encode(s.getSchBgColor()));
			job.put("cwriter", URLEncoder.encode(s.getWriter()));
			jarr.add(job);
		}
		sendJSON.put("list", jarr);
		response.setContentType("application/json; charset= utf-8");
		PrintWriter out = response.getWriter();
		out.write(sendJSON.toJSONString());
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

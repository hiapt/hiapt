package schedule.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schedule.model.service.ScheduleService;
import schedule.model.vo.Schedule;

/**
 * Servlet implementation class ScheduleInsertServlet
 */
@WebServlet("/schin")
public class ScheduleInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		 System.out.println("일정등록 서블릿");
		request.setCharacterEncoding("utf-8");
		
		Schedule sch = new Schedule();
		sch.setSchTitle(request.getParameter("title"));
		String schtype=request.getParameter("schtype");
		sch.setSchType(schtype);
		Date start = Date.valueOf(request.getParameter("start"));
		sch.setSchStart(start);
		sch.setSchEnd(Date.valueOf(request.getParameter("end")));
		sch.setSchMemo(request.getParameter("memo"));
		sch.setSchOpen(request.getParameter("open"));
		sch.setSchAlarm(request.getParameter("alarm"));
		sch.setSchBgColor(request.getParameter("bgcolor"));
		sch.setImportance(request.getParameter("importance"));
		sch.setWriter(request.getParameter("writer"));
		
		int result = new ScheduleService().insertSchedule(sch);
		
		if(result > 0) {
			response.sendRedirect("/hiapt/common/schedule/schedulemain.jsp");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "일정 등록 실패");
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

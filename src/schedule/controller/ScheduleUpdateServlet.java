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
 * Servlet implementation class ScheduleUpdateServlet
 */
@WebServlet("/schup")
public class ScheduleUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		Schedule sch = new Schedule();
		
		String schNo = request.getParameter("schNo");
		sch.setSchNo(Integer.parseInt(schNo));
		sch.setSchTitle(request.getParameter("title"));
		sch.setSchType(request.getParameter("schtype"));
		
		Date start = Date.valueOf(request.getParameter("start"));
		sch.setSchStart(start);
		sch.setSchEnd(Date.valueOf(request.getParameter("end")));
		sch.setSchMemo(request.getParameter("momo"));
		sch.setSchOpen(request.getParameter("open"));
		sch.setSchAlarm(request.getParameter("alarm"));
		sch.setSchBgColor(request.getParameter("bgcolor"));
		sch.setImportance(request.getParameter("importance"));
		sch.setWriter(request.getParameter("writer"));
		
		int result = new ScheduleService().updateSchedule(sch);
		System.out.println("여기는 schup 서블릿입니다. result는 "+result);
		RequestDispatcher view = null;
		if(result > 0) {
			view = request.getRequestDispatcher("views/common/schedule/schedulemain.jsp");
			
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "일정 수정 실패");
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

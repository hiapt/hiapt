package schedule.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schedule.model.service.ScheduleService;
import schedule.model.vo.Schedule;

/**
 * Servlet implementation class ScheduleDetailServlet
 */
@WebServlet("/schdetail")
public class ScheduleDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//일정 디테일 뷰 처리용 컨트롤러
		
		 String snum = (String)request.getParameter("snum");
		    Schedule sch = new ScheduleService().selectOne(snum);
		    RequestDispatcher view = null;
		    if(sch != null) {

				view = request.getRequestDispatcher("views/common/schedule/scheduleDetail.jsp");
				request.setAttribute("schedule", sch);
				view.forward(request, response);
			}else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "일정 상세 보기 실패");
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

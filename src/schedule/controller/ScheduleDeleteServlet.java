package schedule.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schedule.model.service.ScheduleService;

/**
 * Servlet implementation class ScheduleDeleteServlet
 */
@WebServlet("/schdel")
public class ScheduleDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  등록된 일정 삭제 처리용 컨트롤러
			String schNo = request.getParameter("snum");
			int result = new ScheduleService().deleteSchedule(schNo);
			if(result > 0) {
				response.sendRedirect("/third/cal/calendar3.jsp");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "일정 삭제 실패");
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

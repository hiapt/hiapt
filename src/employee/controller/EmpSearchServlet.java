package employee.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;

/**
 * Servlet implementation class EmpSearchServlet
 */
@WebServlet("/empsearch")
public class EmpSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// 2. 변수에 옮기기
		String search = request.getParameter("search");

		// 3.
		RequestDispatcher view = null;
		ArrayList<Employee> list = null;
		EmployeeService empservice = new EmployeeService();

		int currentPage = 1;

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10; // 한 페이지에 출력할 목록 갯수
		
		// currentPage 에 출력할 목록의 조회할 행 번호 계산
		int startRow = (currentPage * limit) - 9;
		int endRow = currentPage * limit;
		
		switch(search) { 
		case "name": 
			String empName = request.getParameter("keyword");
			
			int listCount = empservice.getListCountName(empName);  //테이블의 전체 목록 갯수 조회
			//총 페이지 수 계산
			int maxPage = listCount / limit;
			if(listCount % limit > 0)
				maxPage++;

			int beginPage = (currentPage / limit) * limit + 1;
			
			if(currentPage % limit == 0) {
				beginPage -= limit;
			}
			
			int endPage = beginPage + 9;
			if(endPage > maxPage)
				endPage = maxPage;
			
			list = empservice.selectNameSearch(empName, startRow, endRow);
			
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/emp/employee/empList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("count", listCount);

			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "해당 직원이 존재하지 않습니다.");
				
			}

			view.forward(request, response);	 break;
			
			
			
			
		case "no": 
			String empNo = request.getParameter("keyword");
			
			int listCount2 = empservice.getListCountName(empNo);  //테이블의 전체 목록 갯수 조회
			//총 페이지 수 계산
			int maxPage2 = listCount2 / limit;
				maxPage2++;

				int beginPage2 = (currentPage / limit) * limit + 1;
				
				if(currentPage % limit == 0) {
					beginPage2 -= limit;
				}
				
				int endPage2 = beginPage2 + 9;
				if (endPage2 > maxPage2)
					endPage2 = maxPage2;
			
			list = empservice.selectNoSearch(empNo, startRow, endRow);
			
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/emp/employee/empList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage2);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage2);
				request.setAttribute("endPage", endPage2);
				request.setAttribute("count", listCount2);

			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", search + "해당 사번이 존재하지 않습니다.");
			}

			view.forward(request, response);	 break;
			
		case "id": 
			
			String empId = request.getParameter("keyword");
			
			int listCount3 = empservice.getListCountName(empId);  //테이블의 전체 목록 갯수 조회
			//총 페이지 수 계산
			int maxPage3 = listCount3 / limit;
				maxPage3++;

				int beginPage3 = (currentPage / limit) * limit + 1;
				
				if(currentPage % limit == 0) {
					beginPage3 -= limit;
				}
				
				int endPage3 = beginPage3 + 9;
				if (endPage3 > maxPage3)
					endPage3 = maxPage3;
			
			list = empservice.selectIdSearch(empId, startRow, endRow);
			
			if (list.size() > 0) {
				view = request.getRequestDispatcher("views/emp/employee/empList.jsp");
				request.setAttribute("list", list);
				request.setAttribute("maxPage", maxPage3);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("beginPage", beginPage3);
				request.setAttribute("endPage", endPage3);
				request.setAttribute("count", listCount3);

			} else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "해당 직급이 존재하지 않습니다.");
			}
			view.forward(request, response);	 break;
			
		}
		System.out.println(list);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

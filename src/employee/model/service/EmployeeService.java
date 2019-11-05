package employee.model.service;

import java.sql.*;
import java.util.ArrayList;

import draft.model.vo.Draft;
import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;
import static common.JDBCTemplate.*;
import employee.model.vo.Family;

public class EmployeeService {
	private EmployeeDao edao = new EmployeeDao();
	
	public EmployeeService() {}
	
	public Employee loginCheck(String empNo, String empPwd) {
		Connection conn = getConnection();
		Employee employee = edao.loginCheck(conn, empNo, empPwd);
		close(conn);
		return employee;
	}

	public Employee selectEmployee(String empNo) {
		Connection conn = getConnection();
		Employee employee = edao.selectOne(conn, empNo);
		close(conn);
		return employee;
		
	}

	public int insertEmployee(Employee employee) {
		Connection conn = getConnection();
		int result = edao.insertEmployee(conn, employee);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateEmployee(Employee employee) {
		Connection conn = getConnection();
		int result = edao.updateEmployee(conn, employee);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteEmployee(String empNo) {
		Connection conn = getConnection();
		int result = edao.deleteEmployee(conn, empNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public ArrayList<Employee> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<Employee> selectNameSearch(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectNameSearch(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}
	
	public ArrayList<Employee> selectIdSearch(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectIdSearch(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public ArrayList<Employee> selectNoSearch(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectNoSearch(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = edao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public int getListCountName(String keyword) {
		Connection conn = getConnection();
		int listCount = edao.getListCountName(conn, keyword);
		close(conn);
		return listCount;
	}
	
	public int getListCountNo(String keyword) {
		Connection conn = getConnection();
		int listCount = edao.getListCountNo(conn, keyword);
		close(conn);
		return listCount;
	}
	
	public int getListCountId(String keyword) {
		Connection conn = getConnection();
		int listCount = edao.getListCountId(conn, keyword);
		close(conn);
		return listCount;
	}

	public int insertFamily(int empno, Family family) {
		Connection conn = getConnection();
		int result = edao.insertFamily(conn, empno, family);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int selectEmpno(String empId) {
		Connection conn = getConnection();
		int result = edao.selectEmpno(conn, empId);
		close(conn);
		return result;
	}

	public int updateFamily(Family family) {
		Connection conn = getConnection();
		int result = edao.updateFamily(conn, family);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public Family selectFamily(String empNo) {
		Connection conn = getConnection();
		Family family = edao.selectFamily(conn, empNo);
		close(conn);
		return family;
	}

	public ArrayList<Family> selectListFamily(String empNo) {
		Connection conn = getConnection();
		ArrayList<Family> list = edao.selectListFamily(conn, empNo);
		close(conn);
		return list;
	}
	
	// 로그인 처리
	public int checkId(String id) {
		Connection conn = getConnection();
		int result = edao.checkId(conn, id);
		close(conn);
		return result;

	}

	public int updatePassword(String id, String password) {
		Connection conn = getConnection();
		int result = edao.updatePassword(conn, id, password);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;	
	}

	public ArrayList<Employee> empEmailList() {
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.empEmailList(conn);
		close(conn);
		return list;
	}
}

//Servlet > Service > Dao
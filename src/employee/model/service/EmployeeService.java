package employee.model.service;

import java.sql.*;
import java.util.ArrayList;

import employee.model.dao.EmployeeDao;
import employee.model.vo.Employee;
import static common.JDBCTemplate.*;

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

	public ArrayList<Employee> selectList() {
		Connection conn = getConnection();
		ArrayList<Employee> list = edao.selectList(conn);
		close(conn);
		return list;
	}

}

//Servlet > Service > Dao
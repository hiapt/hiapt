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

	public Employee selectMember(String empNo) {
		Connection conn = getConnection();
		Employee employee = edao.selectOne(conn, empNo);
		close(conn);
		return employee;
		
	}

	public int insertMember(Employee employee) {
		Connection conn = getConnection();
		int result = edao.insertMember(conn, employee);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateMember(Employee employee) {
		Connection conn = getConnection();
		int result = edao.updateMember(conn, employee);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteMember(String empNo) {
		Connection conn = getConnection();
		int result = edao.deleteMember(conn, empNo);
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
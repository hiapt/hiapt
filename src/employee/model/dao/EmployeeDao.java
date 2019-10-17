package employee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import employee.model.vo.Employee;
import static common.JDBCTemplate.*;

public class EmployeeDao {
	public EmployeeDao() {}
	
	public Employee loginCheck(Connection conn, String empNo, String empPwd) {
		Employee employee = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where empno = ? and emppwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			pstmt.setString(2, empPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				employee = new Employee();
				
				employee.setEmpNo(empNo);
				employee.setEmpPwd(empPwd);
				employee.setEmpId(rset.getString("empid"));
				employee.setEmpName(rset.getString("empname"));
				employee.setEmpHireDate(rset.getDate("emphiredate"));
				employee.setEmpPhone(rset.getString("empphone"));
				employee.setEmpSSN(rset.getString("empssn"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				employee.setEmpFamily(rset.getInt("empfamily"));
				employee.setEmpEtc(rset.getString("empetc"));
				employee.setSalary(rset.getInt("salary"));
				employee.setPension(rset.getDouble("pension"));
				employee.setInsurance(rset.getDouble("insurance"));
				employee.setLongIns(rset.getDouble("longins"));
				employee.setHireIns(rset.getDouble("hireins"));
				employee.setIncomeTax(rset.getDouble("incometax"));
				employee.setLocalTax(rset.getDouble("localtax"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return employee;
	}

	public Employee selectOne(Connection conn, String empNo) {
		Employee employee = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee where empno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { //select한 행이 있다면
				employee = new Employee(); //성공했을때 멤버 객체가 만들어짐
				
				employee.setEmpNo(empNo);
				employee.setEmpPwd(rset.getString("emppwd")); 
				employee.setEmpId(rset.getString("empid"));
				employee.setEmpName(rset.getString("empname"));
				employee.setEmpHireDate(rset.getDate("emphiredate"));
				employee.setEmpPhone(rset.getString("empphone"));
				employee.setEmpSSN(rset.getString("empssn"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				employee.setEmpFamily(rset.getInt("empfamily"));
				employee.setEmpEtc(rset.getString("empetc"));
				employee.setSalary(rset.getInt("salary"));
				employee.setPension(rset.getDouble("pension"));
				employee.setInsurance(rset.getDouble("insurance"));
				employee.setLongIns(rset.getDouble("longins"));
				employee.setHireIns(rset.getDouble("hireins"));
				employee.setIncomeTax(rset.getDouble("incometax"));
				employee.setLocalTax(rset.getDouble("localtax"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return employee;
	}

	public int insertEmployee(Connection conn, Employee employee) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		if(employee.getEmpId().equals("보안직원")) {
			query = "insert into employee values ("
					+ "seq_security.nextval, seq_security.currval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}else if(employee.getEmpId().equals("경리")) {
			query = "insert into employee values ("
					+ "seq_accountancy.nextval, seq_accountancy.currval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}else if(employee.getEmpId().equals("설비과장")) {
			query = "insert into employee values ("
					+ "seq_facility.nextval, seq_facility.currval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}else if(employee.getEmpId().equals("검침기사")) {
			query = "insert into employee values ("
					+ "seq_reading.nextval, seq_reading.currval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpId());
			pstmt.setDate(3, employee.getEmpHireDate());
			pstmt.setString(4, employee.getEmpPhone());
			pstmt.setString(5, employee.getEmpSSN());
			pstmt.setString(6, employee.getEmpAddress());
			pstmt.setString(7, employee.getEmpEmail());
			pstmt.setInt(8, employee.getEmpFamily());
			pstmt.setInt(9, employee.getSalary());
			pstmt.setDouble(10, employee.getPension());
			pstmt.setDouble(11, employee.getInsurance());
			pstmt.setDouble(12, employee.getLongIns());
			pstmt.setDouble(13, employee.getHireIns());
			pstmt.setDouble(14, employee.getIncomeTax());
			pstmt.setDouble(15, employee.getLocalTax());
			pstmt.setString(16, employee.getEmpEtc());
					
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateEmployee(Connection conn, Employee employee) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update employee set empname = ?, empid = ?, empphone = ?, empssn = ?, empaddress = ?, empemail = ?, empfamily = ?,  salary = ?, empetc = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpId());
			pstmt.setString(3, employee.getEmpPhone());
			pstmt.setString(4, employee.getEmpSSN());
			pstmt.setString(5, employee.getEmpAddress());
			pstmt.setString(6, employee.getEmpEmail());
			pstmt.setInt(7, employee.getEmpFamily());
			pstmt.setInt(8, employee.getSalary());
			pstmt.setString(9, employee.getEmpEtc());
						
			result = pstmt.executeUpdate();
			//System.out.println("처리된 행 갯수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteEmployee(Connection conn, String empNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from employee where empno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			
			result = pstmt.executeUpdate();
			//System.out.println("처리된 행 갯수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Employee> selectList(Connection conn) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Employee employee = new Employee();
				
				employee.setEmpNo(rset.getString("empno"));
				employee.setEmpName(rset.getString("empname"));
				//employee.setEmpPwd(rset.getString("emppwd")); 
				employee.setEmpId(rset.getString("empid"));
				employee.setEmpHireDate(rset.getDate("emphiredate"));
				employee.setEmpPhone(rset.getString("empphone"));
				//employee.setEmpSSN(rset.getString("empssn"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				//employee.setEmpFamily(rset.getInt("empfamily"));
				employee.setSalary(rset.getInt("salary"));
				employee.setEmpEtc(rset.getString("empetc"));
				/*employee.setPension(rset.getDouble("pension"));
				employee.setInsurance(rset.getDouble("insurance"));
				employee.setLongIns(rset.getDouble("longins"));
				employee.setHireIns(rset.getDouble("hireins"));
				employee.setIncomeTax(rset.getDouble("incometax"));
				employee.setLocalTax(rset.getDouble("localtax"));*/
				
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
}

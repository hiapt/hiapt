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
				employee.setEmpName(rset.getString("empname"));
				employee.setEmpId(rset.getString("empid"));
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

	public int insertMember(Connection conn, Employee employee) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into employee values (?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getEmpNo());
			pstmt.setString(2, employee.getEmpPwd());
			pstmt.setString(3, employee.getEmpName());
			pstmt.setString(4, employee.getEmpId()); //다음에 입사일
			pstmt.setString(5, employee.getEmpPhone());
			pstmt.setString(6, employee.getEmpSSN());
			pstmt.setString(7, employee.getEmpAddress());
			pstmt.setString(8, employee.getEmpEmail());
			pstmt.setInt(9, employee.getEmpFamily());
			pstmt.setString(10, employee.getEmpEtc());
			pstmt.setInt(11, employee.getSalary());
			pstmt.setDouble(12, employee.getPension());
			pstmt.setDouble(13, employee.getInsurance());
			pstmt.setDouble(14, employee.getLongIns());
			pstmt.setDouble(15, employee.getHireIns());
			pstmt.setDouble(16, employee.getIncomeTax());
			pstmt.setDouble(17, employee.getLocalTax());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateMember(Connection conn, Employee employee) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update member set empid = ?, phone = ?, empaddress = ?, empemail = ?, empfamily = ?,  salary = ?, empetc = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, employee.getEmpId());
			pstmt.setString(2, employee.getEmpPhone());
			pstmt.setString(3, employee.getEmpAddress());
			pstmt.setString(4, employee.getEmpEmail());
			pstmt.setInt(5, employee.getEmpFamily());
			pstmt.setInt(6, employee.getSalary());
			pstmt.setString(7, employee.getEmpEtc());
						
			result = pstmt.executeUpdate();
			//System.out.println("처리된 행 갯수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, String empNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from member where empno = ?";
		
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

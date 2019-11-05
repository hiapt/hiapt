package employee.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import employee.model.vo.Employee;
import static common.JDBCTemplate.*;

import employee.model.vo.Family;

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
				employee.setEmpZipcode(rset.getString("empzipcode"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				employee.setEmpGender(rset.getString("empgender"));
				employee.setEmpEtc(rset.getString("empetc"));
				employee.setSalary(rset.getInt("salary"));
				employee.setPension(rset.getInt("pension"));
				employee.setInsurance(rset.getInt("insurance"));
				employee.setLongIns(rset.getInt("longins"));
				employee.setHireIns(rset.getInt("hireins"));
				employee.setIncomeTax(rset.getInt("incometax"));
				employee.setLocalTax(rset.getInt("localtax"));
				employee.setSalaryTot(rset.getInt("salarytot"));
				employee.setMinusTot(rset.getInt("minustot"));
				employee.setRealSalary(rset.getInt("realsalary"));
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
				employee.setEmpZipcode(rset.getString("empzipcode"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				employee.setEmpGender(rset.getString("empgender"));
				employee.setEmpEtc(rset.getString("empetc"));
				employee.setSalary(rset.getInt("salary"));
				employee.setPension(rset.getInt("pension"));
				employee.setInsurance(rset.getInt("insurance"));
				employee.setLongIns(rset.getInt("longins"));
				employee.setHireIns(rset.getInt("hireins"));
				employee.setIncomeTax(rset.getInt("incometax"));
				employee.setLocalTax(rset.getInt("localtax"));
				employee.setSalaryTot(rset.getInt("salarytot"));
				employee.setMinusTot(rset.getInt("minustot"));
				employee.setRealSalary(rset.getInt("realsalary"));
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
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}else if(employee.getEmpId().equals("경리")) {
			query = "insert into employee values ("
					+ "seq_accountancy.nextval, seq_accountancy.currval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}else if(employee.getEmpId().equals("설비과장")) {
			query = "insert into employee values ("
					+ "seq_facility.nextval, seq_facility.currval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}else if(employee.getEmpId().equals("검침기사")) {
			query = "insert into employee values ("
					+ "seq_reading.nextval, seq_reading.currval, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpId());
			pstmt.setDate(3, employee.getEmpHireDate());
			pstmt.setString(4, employee.getEmpPhone());
			pstmt.setString(5, employee.getEmpSSN());
			pstmt.setString(6, employee.getEmpZipcode());
			pstmt.setString(7, employee.getEmpAddress());
			pstmt.setString(8, employee.getEmpEmail());
			pstmt.setString(9, employee.getEmpGender());
			pstmt.setString(10, employee.getEmpEtc());
			pstmt.setInt(11,employee.getSalary());
			pstmt.setInt(12, employee.getPension());
			pstmt.setInt(13, employee.getInsurance());
			pstmt.setInt(14, employee.getLongIns());
			pstmt.setInt(15, employee.getHireIns());
			pstmt.setInt(16, employee.getIncomeTax());
			pstmt.setInt(17, employee.getLocalTax());
			pstmt.setInt(18, employee.getSalaryTot());
			pstmt.setInt(19, employee.getMinusTot());
			pstmt.setInt(20, employee.getRealSalary());
			
				
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
		System.out.println(employee.getEmpNo().length());
		String query = "update employee "
				+ "set empname = ?, empid = ?, empphone = ?, empzipcode = ?, empaddress = ?, empemail = ?, empgender = ?, "
				+ "salary = ?, pension = ?, insurance = ?, longins = ?, hireins = ?, incometax = ?, localtax = ?, salarytot = ?, minustot = ?, realsalary = ?, empetc = ? "
				+ "where empno = ?";
		
		try {	
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, employee.getEmpName());
			pstmt.setString(2, employee.getEmpId());
			pstmt.setString(3, employee.getEmpPhone());
			pstmt.setString(4, employee.getEmpZipcode());
			pstmt.setString(5, employee.getEmpAddress());
			pstmt.setString(6, employee.getEmpEmail());
			pstmt.setString(7, employee.getEmpGender());
			pstmt.setInt(8,employee.getSalary());
			pstmt.setInt(9, employee.getPension());
			pstmt.setInt(10, employee.getInsurance());
			pstmt.setInt(11, employee.getLongIns());
			pstmt.setInt(12, employee.getHireIns());
			pstmt.setInt(13, employee.getIncomeTax());
			pstmt.setInt(14, employee.getLocalTax());
			pstmt.setInt(15, employee.getSalaryTot());
			pstmt.setInt(16, employee.getMinusTot());
			pstmt.setInt(17, employee.getRealSalary());
			pstmt.setString(18, employee.getEmpEtc());
			pstmt.setString(19, employee.getEmpNo());
				
			result = pstmt.executeUpdate();
			System.out.println("처리된 행 갯수 : " + result);

						
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

	public ArrayList<Employee> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, empno, empname, empid, emphiredate, empphone, empzipcode, empaddress, "
				+ "empemail, salary, empetc "
				+ "from (select * from employee "
				+ "order by emphiredate asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee();
				
				employee.setEmpNo(rset.getString("empno"));
				employee.setEmpName(rset.getString("empname"));
				//employee.setEmpPwd(rset.getString("emppwd")); 
				employee.setEmpId(rset.getString("empid"));
				employee.setEmpHireDate(rset.getDate("emphiredate"));
				employee.setEmpPhone(rset.getString("empphone"));
				//employee.setEmpSSN(rset.getString("empssn"));
				employee.setEmpZipcode(rset.getString("empzipcode"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				//employee.setEmpFamily(rset.getInt("empfamily"));
				employee.setSalary(rset.getInt("salary"));
				employee.setEmpEtc(rset.getString("empetc"));
				/*employee.setPension(rset.getInt("pension"));
				employee.setInsurance(rset.getInt("insurance"));
				employee.setLongIns(rset.getInt("longins"));
				employee.setHireIns(rset.getInt("hireins"));
				employee.setIncomeTax(rset.getInt("incometax"));
				employee.setLocalTax(rset.getInt("localtax"));*/
				
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Employee> selectNameSearch(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, empno, empname, empid, emphiredate, empphone, empzipcode, empaddress, "
				+ "empemail, salary, empetc "
				+ "from (select * from employee where empname like ? "
				+ "order by emphiredate asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee();
				
				employee.setEmpNo(rset.getString("empno"));
				employee.setEmpName(rset.getString("empname"));
				employee.setEmpId(rset.getString("empid"));
				employee.setEmpHireDate(rset.getDate("emphiredate"));
				employee.setEmpPhone(rset.getString("empphone"));
				employee.setEmpZipcode(rset.getString("empzipcode"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				employee.setSalary(rset.getInt("salary"));
				employee.setEmpEtc(rset.getString("empetc"));
				
				list.add(employee);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Employee> selectIdSearch(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, empno, empname, empid, emphiredate, empphone, empzipcode, empaddress, "
				+ "empemail, salary, empetc "
				+ "from (select * from employee where empid like ? "
				+ "order by emphiredate asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee();
				
				employee.setEmpNo(rset.getString("empno"));
				employee.setEmpName(rset.getString("empname"));
				employee.setEmpId(rset.getString("empid"));
				employee.setEmpHireDate(rset.getDate("emphiredate"));
				employee.setEmpPhone(rset.getString("empphone"));
				employee.setEmpZipcode(rset.getString("empzipcode"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				employee.setSalary(rset.getInt("salary"));
				employee.setEmpEtc(rset.getString("empetc"));
				
				list.add(employee);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Employee> selectNoSearch(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, empno, empname, empid, emphiredate, empphone, empzipcode, empaddress, "
				+ "empemail, salary, empetc "
				+ "from (select * from employee where empno like ? "
				+ "order by emphiredate asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Employee employee = new Employee();
				
				employee.setEmpNo(rset.getString("empno"));
				employee.setEmpName(rset.getString("empname"));
				employee.setEmpId(rset.getString("empid"));
				employee.setEmpHireDate(rset.getDate("emphiredate"));
				employee.setEmpPhone(rset.getString("empphone"));
				employee.setEmpZipcode(rset.getString("empzipcode"));
				employee.setEmpAddress(rset.getString("empaddress"));
				employee.setEmpEmail(rset.getString("empemail"));
				employee.setSalary(rset.getInt("salary"));
				employee.setEmpEtc(rset.getString("empetc"));
				
				list.add(employee);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from employee";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public int getListCountName(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from employee where empname like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int getListCountNo(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from employee where empno like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public int getListCountId(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from employee where empid like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public int insertFamily(Connection conn, int empno, Family family) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into family values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empno);
			pstmt.setString(2, family.getfRelation());
			pstmt.setString(3, family.getfName());
			pstmt.setString(4, family.getfSSN());
			pstmt.setString(5, family.getfDisability());
			pstmt.setString(6, family.getfDeduction());
			pstmt.setString(7, family.getfTogether());
			pstmt.setString(8, family.getfTax());
			pstmt.setString(9, family.getfChild());
			
				
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int selectEmpno(Connection conn, String empId) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = null;
		
		if(empId.equals("보안직원")) {
			query = "select max(empno) from employee where empid = '보안직원'";
		}else if(empId.equals("경리")) {
			query = "select max(empno) from employee where empid ='경리'";
		}else if(empId.equals("설비과장")) {
			query = "select max(empno) from employee where empid ='설비과장'";
		}else if(empId.equals("검침기사")) {
			query = "select max(empno) from employee where empid ='검침기사'";
		}
		
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next())
				result = rset.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}

	public int updateFamily(Connection conn, Family family) {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println(family.getEmpNo().length());
		String query = "update family "
				+ "set FRELATION = ?, FNAME = ?, FSSN = ?, FDISABILITY = ?, FDEDUCTION = ?, FTOGETHER = ?, FTAX = ?, "
				+ "FCHILD = ? "
				+ "where empno = ?";
		
		try {	
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, family.getfRelation());
			pstmt.setString(2, family.getfName());
			pstmt.setString(3, family.getfSSN());
			pstmt.setString(4, family.getfDisability());
			pstmt.setString(5, family.getfDeduction());
			pstmt.setString(6, family.getfTogether());
			pstmt.setString(7, family.getfTax());
			pstmt.setString(8,family.getfChild());
			pstmt.setString(9, family.getEmpNo());
				
			result = pstmt.executeUpdate();
			System.out.println("처리된 행 갯수 : " + result);

						
			result = pstmt.executeUpdate();
			//System.out.println("처리된 행 갯수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Family selectFamily(Connection conn, String empNo) {
		Family family = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from family where empno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { //select한 행이 있다면
				family = new Family(); //성공했을때 멤버 객체가 만들어짐
				
				family.setEmpNo(empNo);
				family.setfRelation(rset.getString("frelation")); 
				family.setfName(rset.getString("fname"));
				family.setfSSN(rset.getString("fssn")); 
				family.setfDisability(rset.getString("fdisability")); 
				family.setfDeduction(rset.getString("fdeduction")); 
				family.setfTogether(rset.getString("ftogether")); 
				family.setfTax(rset.getString("ftax")); 
				family.setfChild(rset.getString("fchild")); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return family;
	}

	public ArrayList<Family> selectListFamily(Connection conn, String empNo) {
		ArrayList<Family> list = new ArrayList<Family>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select empno, frelation, fname, fssn, fdisability, fdeduction, ftogether, "
				+ "ftax, fchild "
				+ "from family) where empno =?";
		
		try {
			pstmt = conn.prepareStatement(query);	
			pstmt.setString(1, empNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Family family = new Family(); //성공했을때 멤버 객체가 만들어짐
				
				family.setEmpNo(empNo);
				family.setfRelation(rset.getString("frelation")); 
				family.setfName(rset.getString("fname"));
				family.setfSSN(rset.getString("fssn")); 
				family.setfDisability(rset.getString("fdisability")); 
				family.setfDeduction(rset.getString("fdeduction")); 
				family.setfTogether(rset.getString("ftogether")); 
				family.setfTax(rset.getString("ftax")); 
				family.setfChild(rset.getString("fchild")); 
				
				list.add(family);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	// 
	public int checkId(Connection conn, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from employee where EMPNO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updatePassword(Connection conn, String id, String password) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update employee set EMPPWD = ? where EMPNO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Employee> empEmailList(Connection conn) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from employee";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Employee employee = new Employee();
				

				employee.setEmpName(rset.getString("empname"));
				employee.setEmpEmail(rset.getString("empemail"));
				
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

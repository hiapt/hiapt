package aptuser.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import aptuser.model.vo.Aptuser;
import draft.model.vo.Draft;
import employee.model.vo.Employee;

import static common.JDBCTemplate.close;

public class UloginDao {
	public UloginDao() {}

	public Aptuser loginCheck(Connection conn, String userId, String userPwd) {
		Aptuser aptuser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from aptuser where userid = ? and userpwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				aptuser = new Aptuser();
				
				aptuser.setUserId(userId);
				aptuser.setUserPwd(userPwd);
				aptuser.setUserName(rset.getString("username"));
				aptuser.setUserEnroll(rset.getDate("userenroll"));
				aptuser.setUserBirth(rset.getDate("userbirth"));
				aptuser.setUserPhone(rset.getString("userphone"));
				aptuser.setUserEmail(rset.getString("useremail"));
				aptuser.setUserEtc(rset.getString("useretc"));
				aptuser.setCarType(rset.getString("cartype"));
				aptuser.setCarNo(rset.getString("carno"));
				aptuser.setCarEnroll(rset.getDate("carenroll"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return aptuser;
	}
	
	// 로그인 세대주 추가 부분
	public int checkId(Connection conn, String id) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from aptuser where userid = ?";
		
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
		
		String query = "update aptuser set USERPWD = ? where USERID = ?";
		
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
	// 추가부분
	public int insertAptuser(Connection conn, Aptuser aptuser) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into aptuser values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
				
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, aptuser.getUserId());
			pstmt.setString(2, aptuser.getUserId());
			pstmt.setString(3, aptuser.getUserName());
			pstmt.setDate(4, aptuser.getUserEnroll());
			pstmt.setDate(5, aptuser.getUserBirth());
			pstmt.setString(6, aptuser.getUserPhone());
			pstmt.setString(7, aptuser.getUserEmail());
			pstmt.setString(8, aptuser.getUserEtc());
			pstmt.setString(9, aptuser.getCarType());
			pstmt.setString(10, aptuser.getCarNo());
			pstmt.setDate(11,aptuser.getCarEnroll());
			
			
				
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from aptuser";
		
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

	public ArrayList<Aptuser> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Aptuser> list = new ArrayList<Aptuser>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, userid, username, userenroll, userbirth, userphone, useremail, useretc, "
				+ "cartype, carno, carenroll "
				+ "from (select * from aptuser "
				+ "order by userid asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Aptuser aptuser = new Aptuser();
				
				aptuser.setUserId(rset.getString("userid"));
				aptuser.setUserName(rset.getString("username"));
				aptuser.setUserEnroll(rset.getDate("userenroll"));
				aptuser.setUserBirth(rset.getDate("userbirth"));
				aptuser.setUserPhone(rset.getString("userphone"));
				aptuser.setUserEmail(rset.getString("useremail"));
				aptuser.setUserEtc(rset.getString("useretc"));
				aptuser.setCarType(rset.getString("cartype"));
				aptuser.setCarNo(rset.getString("carno"));
				aptuser.setCarEnroll(rset.getDate("carenroll"));
				
				
				list.add(aptuser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public Aptuser selectOne(Connection conn, String userId) {
		Aptuser aptuser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from aptuser where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { //select한 행이 있다면
				aptuser = new Aptuser(); //성공했을때 멤버 객체가 만들어짐
				
				aptuser.setUserId(userId);
				aptuser.setUserPwd(rset.getString("userpwd"));
				aptuser.setUserName(rset.getString("username"));
				aptuser.setUserEnroll(rset.getDate("userenroll"));
				aptuser.setUserBirth(rset.getDate("userbirth"));
				aptuser.setUserPhone(rset.getString("userphone"));
				aptuser.setUserEmail(rset.getString("useremail"));
				aptuser.setUserEtc(rset.getString("useretc"));
				aptuser.setCarType(rset.getString("cartype"));
				aptuser.setCarNo(rset.getString("carno"));
				aptuser.setCarEnroll(rset.getDate("carenroll"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return aptuser;
	}
	
	public int updateAptuser(Connection conn, Aptuser aptuser) {
		int result = 0;
		PreparedStatement pstmt = null;
		//System.out.println(aptuser.getUserId().length());
		String query = "update aptuser "
				+ "set userid = ?, username = ?, userenroll = ?, userbirth = ?, userphone = ?, useremail = ?, useretc = ?, "
				+ "cartype = ?, carno = ?, carenroll = ? "
				+ "where userid = ?";
		
		try {	
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, aptuser.getUserId());
			pstmt.setString(2, aptuser.getUserName());
			pstmt.setDate(3, aptuser.getUserEnroll());
			pstmt.setDate(4, aptuser.getUserBirth());
			pstmt.setString(5, aptuser.getUserPhone());
			pstmt.setString(6, aptuser.getUserEmail());
			pstmt.setString(7, aptuser.getUserEtc());
			pstmt.setString(8, aptuser.getCarType());
			pstmt.setString(9, aptuser.getCarNo());
			pstmt.setDate(10,aptuser.getCarEnroll());
				
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

	public int deleteAptuser(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from aptuser where userid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			//System.out.println("처리된 행 갯수 : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int getListCountDongho(Connection conn, String dong, String ho) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from aptuser where substr(userid,1,(instr(?,'-')-1)) like ? and substr(userid,(instr(userid,'-',1,1)+1)) like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + dong  + "%");
			pstmt.setString(2, "%" + ho  + "%");
			
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

	public ArrayList<Aptuser> selectDonghoSearch(Connection conn, String dong, String ho, int startRow, int endRow) {
		ArrayList<Aptuser> list = new ArrayList<Aptuser>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, userid, username, userenroll, userbirth, userphone, useremail, useretc, "
				+ "cartype, carno, carenroll "
				+ "from (select * from aptuser where substr(userid,1,(instr(userid,'-')-1)) like ? and substr(userid,(instr(userid,'-',1,1)+1)) like ? "
				+ "order by userid asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + dong  + "%");
			pstmt.setString(2, "%" + ho  + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Aptuser aptuser = new Aptuser();
				
				aptuser.setUserId(rset.getString("userid"));
				aptuser.setUserName(rset.getString("username"));
				aptuser.setUserEnroll(rset.getDate("userenroll"));
				aptuser.setUserBirth(rset.getDate("userbirth"));
				aptuser.setUserPhone(rset.getString("userphone"));
				aptuser.setUserEmail(rset.getString("useremail"));
				aptuser.setUserEtc(rset.getString("useretc"));
				aptuser.setCarType(rset.getString("cartype"));
				aptuser.setCarNo(rset.getString("carno"));
				aptuser.setCarEnroll(rset.getDate("carenroll"));
				
				
				list.add(aptuser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int getListCountName(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from aptuser where username like ?";
		
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

	public ArrayList<Aptuser> selectNameSearch(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Aptuser> list = new ArrayList<Aptuser>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, userid, username, userenroll, userbirth, userphone, useremail, useretc, "
				+ "cartype, carno, carenroll "
				+ "from (select * from aptuser where username like ? "
				+ "order by userid asc)) "
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Aptuser aptuser = new Aptuser();
				
				aptuser.setUserId(rset.getString("userid"));
				aptuser.setUserName(rset.getString("username"));
				aptuser.setUserEnroll(rset.getDate("userenroll"));
				aptuser.setUserBirth(rset.getDate("userbirth"));
				aptuser.setUserPhone(rset.getString("userphone"));
				aptuser.setUserEmail(rset.getString("useremail"));
				aptuser.setUserEtc(rset.getString("useretc"));
				aptuser.setCarType(rset.getString("cartype"));
				aptuser.setCarNo(rset.getString("carno"));
				aptuser.setCarEnroll(rset.getDate("carenroll"));
				
				
				list.add(aptuser);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCountDate(Connection conn, Date from, Date to) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
				"from aptuser " + 
				"where userenroll between ? and ? order by userid desc";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
						
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

	public ArrayList<Aptuser> selectDateSearch(Connection conn, Date from, Date to, int startRow, int endRow) {
		ArrayList<Aptuser> list = new ArrayList<Aptuser>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from (select rownum rnum, userid, username, userenroll, userbirth, userphone, useremail, useretc, " 
				+ "cartype, carno, carenroll  "
				+ "from (select * from aptuser "
				+ "where userenroll between ? and ? order by userid desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Aptuser aptuser = new Aptuser();
				
				aptuser.setUserId(rset.getString("userid"));
				aptuser.setUserName(rset.getString("username"));
				aptuser.setUserEnroll(rset.getDate("userenroll"));
				aptuser.setUserBirth(rset.getDate("userbirth"));
				aptuser.setUserPhone(rset.getString("userphone"));
				aptuser.setUserEmail(rset.getString("useremail"));
				aptuser.setUserEtc(rset.getString("useretc"));
				aptuser.setCarType(rset.getString("cartype"));
				aptuser.setCarNo(rset.getString("carno"));
				aptuser.setCarEnroll(rset.getDate("carenroll"));
				
				
				list.add(aptuser);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}

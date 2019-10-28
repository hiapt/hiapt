package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import maintenance.model.vo.ImposeViewAptuser;

public class ImposeViewAptuserDao {

	public ImposeViewAptuserDao() {
	}

	// 세대주 이름, 동호 조회용
	public ArrayList<ImposeViewAptuser> selectList(Connection conn) {
		ArrayList<ImposeViewAptuser> alist = new ArrayList<ImposeViewAptuser>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select distinct * from impose_view_aptuser";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				ImposeViewAptuser u = new ImposeViewAptuser();

				u.setUserId(rset.getString("userid"));
				u.setUserName(rset.getString("username"));
				u.setUserPhone(rset.getString("userphone"));

				alist.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		System.out.println("dao alist : " + alist);
		return alist;
	}// end selectList

	// 동호수 페이지 조회용
	public int getListCount(Connection conn, String userId) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT DISTINCT * FROM IMPOSE_VIEW_APTUSER where userid Like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + userId);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		System.out.println("dao userid : " + listCount);
		return listCount;
	}

	// 전체조회용
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from impose_view_aptuser";
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		System.out.println("dao 전체리스트 : " + listCount);
		return listCount;
	} // end listCount;

	// 검색용 시작페이지, 끝 페이지
	public ArrayList<ImposeViewAptuser> selectUserId(Connection conn, int startRow, int endRow) {
		ArrayList<ImposeViewAptuser> alist = new ArrayList<ImposeViewAptuser>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from( " + "SELECT ROWNUM RNUM, USERID, USERNAME, USERPHONE " + "FROM( "
				+ "SELECT * FROM IMPOSE_VIEW_APTUSER " + "ORDER BY USERID ASC)) " + "where rnum >= ? and rnum <=?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				ImposeViewAptuser u = new ImposeViewAptuser();

				u.setUserId(rset.getString("userid"));
				u.setUserName(rset.getString("username"));
				u.setUserPhone(rset.getString("userphone"));

				alist.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao alist : " + alist);
		return alist;

	}// end selectList

	

	public ArrayList<ImposeViewAptuser> selectUserId(Connection conn, String userId, int startRow, int endRow) {
		ArrayList<ImposeViewAptuser> alist = new ArrayList<ImposeViewAptuser>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from( " + 
				"SELECT ROWNUM RNUM, USERID, USERNAME, USERPHONE " + 
				"FROM( " + 
				"SELECT * FROM IMPOSE_VIEW_APTUSER where userid Like ? " + 
				"ORDER BY USERID ASC)) " + 
				"where rnum >= ? and rnum <=?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + userId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				ImposeViewAptuser u = new ImposeViewAptuser();

				u.setUserId(rset.getString("userid"));
				u.setUserName(rset.getString("username"));
				u.setUserPhone(rset.getString("userphone"));

				alist.add(u);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao alist : " + alist);
		return alist;
	}
}

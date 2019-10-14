package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import maintenance.model.vo.Bill;

public class BillDao {
	// 기본생성자
	public BillDao() {}
	
	// 고지서 전체 조회용 리스트
	public ArrayList<Bill> selectList(Connection conn) {
		ArrayList<Bill> list = new ArrayList<Bill>();
		Statement stmt = null;
		ResultSet rset = null;
		
		
		return null;
	}

	// 페이징 처리용 Count();
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from bill";
		
		try {

			stmt = conn.createStatement();
			// 쿼리문 별도 내용 없으므로 바로 실행하면 됨
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1); // int로 받아오면 컬럼명을 쓸 수 없으므로 순번을 적으면 됨, 오라클은 1번부터, 오라클에서 애칭을 사용해도 됨
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	// 페이징 시작번호, 끝 번호
	public ArrayList<Bill> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Bill> list = new ArrayList<Bill>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
		
		try {
			pstmt = conn.prepareStatement(query);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
}

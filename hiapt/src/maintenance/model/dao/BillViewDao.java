package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import maintenance.model.vo.BillView;

public class BillViewDao {
	// 기본 생성자
	public BillViewDao() {}
	
	// 전체 간략 조회용 리스트용
	public ArrayList<BillView> selectList(Connection conn) {
		ArrayList<BillView> list = new ArrayList<BillView>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from BILL_VIEW";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				BillView bview = new BillView();
				
				bview.setMerchantUid(rset.getLong("merchant_uid"));
				bview.setUserId(rset.getString("userid"));
				bview.setAmount(rset.getInt("amount"));
				bview.setArrears(rset.getInt("arrears"));
				bview.setArrearsFine(rset.getInt("arrears_fine"));
				bview.setBeforeAmount(rset.getInt("before_amount"));
				bview.setAfterAmount(rset.getInt("after_amount"));
				
				list.add(bview);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		System.out.println(list);
		return list;
	} // end selectList
	
	// 페이징 처리를 위한 메소드, 전체 list 갯수
	public int getListCount(Connection conn) {
		int listCount = 0;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from bill_view";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	// 페이징 처리를 위한 메소드, 시작페이지, 끝 페이지 용
	public ArrayList<BillView> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<BillView> list = new ArrayList<BillView>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ("
				+ " select rownum rnum, userid, arrears, merchant_uid "
				+ "from ( select * from bill_view order by userid asc, merchant_uid desc))"
				+ "where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				BillView bview = new BillView();
				bview.setMerchantUid(rset.getLong("merchant_uid"));
				bview.setUserId(rset.getString("userid"));
				//bview.setAmount(rset.getInt("amount"));
				bview.setArrears(rset.getInt("arrears"));
				//bview.setArrearsFine(rset.getInt("arrears_fine"));
				//bview.setAfterAmount(rset.getInt("after_amount"));
				//bview.setBeforeAmount(rset.getInt("before_amount"));
				
				list.add(bview);
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(list);		
		return list;
	}
	
} // end class()

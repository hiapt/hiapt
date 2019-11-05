package maintenance.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import maintenance.model.vo.BaseView;
import maintenance.model.vo.Bill;

public class BaseViewDao {

	public BaseViewDao() {
	}

	// 전체 리스트 갯수 count로 가져온다.
	public int getListCount(Connection conn, String months) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) " +
				" FROM BASE_VIEW " +
				" WHERE TO_CHAR(BILL_YEAR_MONTH, 'yyyy/mm') Like ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + months + "%");
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return listCount;
	}// end getListCount;

	// page 가져오기
	public ArrayList<BaseView> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<BaseView> list = new ArrayList<BaseView>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM (SELECT ROWNUM RNUM, IMPOSE_STATUS, BILL_YEAR_MONTH, CALCULATE_START_DAY, "
				+ "CALCULATE_END_DAY, impose_end_date, ACCEPT_DATE, CUTOFF_DATE, IMPOSE_COUNT, MERCHANT_UID "
				+ "from (SELECT * " + "FROM BASE_VIEW " + "ORDER BY BILL_YEAR_MONTH DESC, CUTOFF_DATE DESC)) "
				+ "where rnum >=? and rnum <=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				BaseView bv = new BaseView();
				bv.setImposeStatus(rset.getString("impose_status"));				
				bv.setBillYearMonth(rset.getDate("bill_year_month"));
				bv.setCalculateStartDay(rset.getDate("calculate_start_day"));
				bv.setCalculateEndDay(rset.getDate("calculate_end_day"));
				bv.setImposeEndDate(rset.getDate("impose_end_date"));
				bv.setAcceptDate(rset.getDate("accept_date"));
				bv.setCutoffDate(rset.getDate("cutoff_date"));
				bv.setImposeCount(rset.getInt("impose_count"));
				bv.setMerchantUid(rset.getLong("merchant_uid"));

				list.add(bv);
				System.out.println("bill_year_month: " + list);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		System.out.println("전체 목록 갯수 dao : " + list);
		return list;

	}

	// search month
	public ArrayList<BaseView> selectMonthSearch(Connection conn, String months) {
		ArrayList<BaseView> list = new ArrayList<BaseView>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		/*String query = "SELECT TO_CHAR(BILL_YEAR_MONTH, 'yyyy-mm') " + " FROM BASE_VIEW "
				+ " where TO_CHAR(BILL_YEAR_MONTH, 'yyyy-mm') like ?";*/
		
		/*String query = "SELECT * FROM BASE_VIEW "
				+ "where BILL_YEAR_MONTH >= ?";*/
		
		String query = "SELECT * FROM BASE_VIEW "
				+ " where TO_CHAR(BILL_YEAR_MONTH, 'yyyy-mm') like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+ months);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				BaseView bv = new BaseView();

				bv.setImposeStatus(rset.getString("impose_status"));
				bv.setBillYearMonth(rset.getDate("bill_year_month"));
				bv.setCalculateStartDay(rset.getDate("calculate_start_day"));
				bv.setCalculateEndDay(rset.getDate("calculate_end_day"));
				bv.setImposeEndDate(rset.getDate("impose_end_date"));
				bv.setAcceptDate(rset.getDate("accept_date"));
				bv.setCutoffDate(rset.getDate("cutoff_date"));
				bv.setImposeCount(rset.getInt("impose_count"));
				bv.setMerchantUid(rset.getLong("merchant_uid"));

				list.add(bv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("months dao: " + list);
		return list;
	}

	// 전체조회
	public ArrayList<BaseView> selectAll(Connection conn) {
		ArrayList<BaseView> list = new ArrayList<BaseView>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from base_view order bill_year_month desc";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				BaseView bv = new BaseView();

				bv.setImposeStatus(rset.getString("impose_status"));
				bv.setBillYearMonth(rset.getDate("bill_year_month"));
				bv.setCalculateStartDay(rset.getDate("calculate_start_day"));
				bv.setCalculateEndDay(rset.getDate("calculate_end_day"));
				bv.setImposeEndDate(rset.getDate("impose_end_date"));
				bv.setAcceptDate(rset.getDate("accept_date"));
				bv.setCutoffDate(rset.getDate("cutoff_date"));
				bv.setImposeCount(rset.getInt("impose_count"));
				bv.setMerchantUid(rset.getLong("merchant_uid"));

				list.add(bv);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		System.out.println(list);
		return list;
	}

	//search list
	public ArrayList<BaseView> selectMonthSearch(Connection conn, String months, int startRow, int endRow) {
		ArrayList<BaseView> list = new ArrayList<BaseView>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query = "SELECT * FROM BASE_VIEW "
				+ " where TO_CHAR(BILL_YEAR_MONTH, 'yyyy-mm') like ?";*/
		
		String query  = "SELECT * FROM (SELECT ROWNUM RNUM, IMPOSE_STATUS, BILL_YEAR_MONTH, CALCULATE_START_DAY, "
				+ "CALCULATE_END_DAY, impose_end_date, ACCEPT_DATE, CUTOFF_DATE, IMPOSE_COUNT, MERCHANT_UID "
				+ "from (SELECT * FROM BASE_VIEW " + 
				"WHERE TO_CHAR(BILL_YEAR_MONTH, 'yyyy-mm') LIKE ? " + 
				"ORDER BY BILL_YEAR_MONTH DESC, CUTOFF_DATE DESC)) "
				+ "where rnum >=? and rnum <=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+ months + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				BaseView bv = new BaseView();

				bv.setImposeStatus(rset.getString("impose_status"));
				bv.setBillYearMonth(rset.getDate("bill_year_month"));
				bv.setCalculateStartDay(rset.getDate("calculate_start_day"));
				bv.setCalculateEndDay(rset.getDate("calculate_end_day"));
				bv.setImposeEndDate(rset.getDate("impose_end_date"));
				bv.setAcceptDate(rset.getDate("accept_date"));
				bv.setCutoffDate(rset.getDate("cutoff_date"));
				bv.setImposeCount(rset.getInt("impose_count"));
				bv.setMerchantUid(rset.getLong("merchant_uid"));

				list.add(bv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("dao months: " + list);
		return list;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) " + 
				"FROM BASE_VIEW";

		try {

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return listCount;
	}
	
	// 고지서 삭제
	public int deleteBaseView(Connection conn, long merchantUid) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "delete from base_view where MERCHANT_UID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			/*pstmt.setLong(1, merchantUid);*/
			pstmt.setLong(1, merchantUid);
			
			result = pstmt.executeUpdate();
			
			System.out.println("삭제된 행의 갯수 : " + result );
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/*// 기초부과 입력단
	public int insertImposeView(Connection conn, JSONObject sendJson) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO BASE_VIEW VALUES(" + 
				"BILL_SEQ.NEXTVAL, ?, ?, ?, ?, ?, " + 
				"?, ?, ? )";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, String.valueOf(sendJson.get("imposeStatus")));
			pstmt.setString(2, String.valueOf(sendJson.get("billYearMonth")));
			pstmt.setString(3, String.valueOf(sendJson.get("")));
			pstmt.setDate(2, sendJson.getBillYearMonth());
			pstmt.setDate(3, sendJson.getCalculateStartDay());
			pstmt.setDate(4, sendJson.getCalculateEndDay());
			pstmt.setDate(5, sendJson.getImposeEndDate());
			pstmt.setDate(6, sendJson.getAcceptDate());
			pstmt.setDate(7, sendJson.getCutoffDate());
			pstmt.setInt(8, sendJson.getImposeCount());
					
			result = pstmt.executeUpdate();
			System.out.println("처리된 행의 갯수 :" + result);			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}// end insertBaseView
*/	
	// baseView insert
	public int insertBaseView(Connection conn, BaseView bview) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into base_view values(BILL_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bview.getImposeStatus());
			pstmt.setDate(2, bview.getBillYearMonth());
			pstmt.setDate(3, bview.getCalculateStartDay());
			pstmt.setDate(4, bview.getCalculateEndDay());
			pstmt.setDate(5, bview.getImposeEndDate());
			pstmt.setDate(6, bview.getAcceptDate());
			pstmt.setDate(7, bview.getCutoffDate());
			pstmt.setInt(8, bview.getImposeCount());

			result = pstmt.executeUpdate();
			System.out.println("처리된 행의 갯수 : " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}// insertBaseView
	
	// ajax 사용을 위한 top 10
	public ArrayList<BaseView> selectTop10(Connection conn) {
		ArrayList<BaseView> list = new ArrayList<BaseView>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM (SELECT ROWNUM RNUM, IMPOSE_STATUS, BILL_YEAR_MONTH, CALCULATE_START_DAY, " + 
				"				CALCULATE_END_DAY, impose_end_date, ACCEPT_DATE, CUTOFF_DATE, IMPOSE_COUNT, MERCHANT_UID " + 
				"				from (SELECT * FROM BASE_VIEW " + 
				"				ORDER BY BILL_YEAR_MONTH DESC, CUTOFF_DATE DESC)) " + 
				"				where rnum >=1 and rnum <=10";
		
		try {
			 
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				BaseView bview = new BaseView();
				
				bview.setMerchantUid(rset.getLong("merchant_uid"));
				bview.setImposeStatus(rset.getString("impose_status"));
				bview.setBillYearMonth(rset.getDate("bill_year_month"));
				bview.setCalculateStartDay(rset.getDate("calculate_start_day"));
				bview.setCalculateEndDay(rset.getDate("calculate_end_day"));
				bview.setImposeEndDate(rset.getDate("impose_end_date"));
				bview.setAcceptDate(rset.getDate("accept_date"));
				bview.setCutoffDate(rset.getDate("cutoff_date"));
				bview.setImposeCount(rset.getInt("impose_count"));
				
				list.add(bview);

			}			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
				
		return list;
	}// end selectTop10
	
	/*// null 일경우 getlistcount
	public int getbvListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "SELECT COUNT(*) " + 
				"FROM BASE_VIEW";

		try {

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}

		return listCount;
	}*/

}

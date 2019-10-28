package schedule.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import schedule.model.vo.Schedule;

import static common.JDBCTemplate.*;

public class ScheduleDao {

	public ArrayList<Schedule> selectAll(Connection conn, String ym, String writer) {
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from schedule where (empno = ? or sch_open = 'Y')"
				+ " and (substr(to_char(sch_start,'yyyy-mm-dd'),1,7)=?"
				+ " and substr(to_char(sch_end,'yyyy-mm-dd'),1,7)=?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, writer);
			pstmt.setString(2, ym);
			pstmt.setString(3, ym);
			
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Schedule sch = new Schedule();
				sch.setSchNo(rset.getInt("sch_no"));
				sch.setSchTitle(rset.getString("sch_title"));
				sch.setSchStart(rset.getDate("sch_start"));
				sch.setSchEnd(rset.getDate("sch_end"));
				sch.setSchMemo(rset.getString("sch_memo"));
				sch.setSchOpen(rset.getString("sch_open"));
				sch.setSchAlarm(rset.getString("sch_alarm"));
				sch.setSchBgColor(rset.getString("sch_color"));
				sch.setImportance(rset.getString("importance"));
				sch.setWriter(rset.getString("empno"));
				list.add(sch);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("list dao : "+list.size());
		return list;
	}

	public int insertCalendar(Connection conn, Schedule sch) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into Schedule values(sch_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sch.getSchTitle());
			pstmt.setString(2, sch.getSchType());
			pstmt.setDate(3, sch.getSchStart());
			pstmt.setDate(4, sch.getSchEnd());
			pstmt.setString(5, sch.getSchMemo());
			pstmt.setString(6, sch.getSchOpen());
			pstmt.setString(7, sch.getSchAlarm());
			pstmt.setString(8, sch.getSchBgColor());
			pstmt.setString(9, sch.getImportance());
			pstmt.setString(10, sch.getWriter());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Schedule selectOne(Connection conn, String snum) {
		
		  Schedule sch = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from schedule where sch_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, snum);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				sch = new Schedule();
				
				sch.setSchNo(rset.getInt("sch_no"));
				sch.setSchTitle(rset.getString("sch_title"));
				sch.setSchType(rset.getString("sch_type"));
				sch.setSchStart(rset.getDate("sch_start"));
				sch.setSchEnd(rset.getDate("sch_end"));
				sch.setSchMemo(rset.getString("sch_memo"));
				sch.setSchOpen(rset.getString("sch_open"));
				sch.setSchAlarm(rset.getString("sch_alarm"));
				sch.setSchBgColor(rset.getString("sch_color"));
				sch.setImportance(rset.getString("importance"));
				sch.setWriter(rset.getString("empno"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("sch : "+sch);
		return sch;
		
	}

	public int deleteSchedule(Connection conn, String schNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from schedule where sch_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, schNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateSchedule(Connection conn, Schedule sch) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update schedule set sch_title = ?, sch_type = ?, sch_start = ?, "
				+ "sch_end = ?, sch_memo = ?, sch_open = ?, sch_alarm = ?, sch_color = ?, importance = ? "
				+ "where sch_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, sch.getSchTitle());
			pstmt.setString(2, sch.getSchType());
			pstmt.setDate(3, sch.getSchStart());
			pstmt.setDate(4, sch.getSchEnd());
			pstmt.setString(5, sch.getSchMemo());
			pstmt.setString(6, sch.getSchOpen());
			pstmt.setString(7, sch.getSchAlarm());
			pstmt.setString(8, sch.getSchBgColor());
			pstmt.setString(9, sch.getImportance());
			pstmt.setInt(10, sch.getSchNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		System.out.println("result :"+result);
		return result;
	}

}

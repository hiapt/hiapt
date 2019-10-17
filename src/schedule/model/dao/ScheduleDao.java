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
		String query = "select * from schedule where "
				+ "substr(to_char(sch_start,'yyyy-mm-dd'),1,7)=?"
				+ " and substr(to_char(sch_end,'yyyy-mm-dd'),1,7)=?"
				+ " and empno = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ym);
			pstmt.setString(2, ym);
			pstmt.setString(3, writer);
			
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
		return list;
	}

}

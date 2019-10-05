package notice.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static common.JDBCTemplate.*;
import notice.model.vo.Notice;

public class NoticeDao {

	public ArrayList<Notice> selectAll(Connection conn) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query ="select noticeno, noticetitle, noticedate, noticereadcount, empname " + 
				"from notice " + 
				"join employee on(noticewriter=empno)";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt(1));
				notice.setNoticeTitle(rset.getString(2));
				notice.setNoticeDate(rset.getDate(3));
				notice.setNoticeReadCount(rset.getInt(4));
				notice.setNoticeWriter(rset.getString(5));
				
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

}





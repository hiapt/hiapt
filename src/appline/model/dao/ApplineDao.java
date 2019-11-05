package appline.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import appline.model.vo.Appline;

import static common.JDBCTemplate.*;

public class ApplineDao {
	public int insert(Connection conn, Appline app, String empno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into linelist values ((select count(*) from linelist where empno = ?) + 1, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, empno);
			pstmt.setString(3, app.getLinename());
			pstmt.setString(4, app.getLinecontent());
			pstmt.setString(5, app.getLinevalue());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}

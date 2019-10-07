package common;

import java.sql.*;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", 
					"hiapt", "hiapt");
			conn.setAutoCommit(false);
			
			System.out.println("데이터 베이스에 정상적으로 접속했습니다.");
			
		} catch (ClassNotFoundException e) {	
		} catch (SQLException e) {
			System.out.println("해당클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) 
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) 
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) 
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	
}

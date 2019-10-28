package formbox.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import formbox.model.vo.Formbox;

public class FormboxDao {
	
	public ArrayList<Formbox> selectAll (Connection conn, int startRow, int endRow) {
		ArrayList<Formbox> list = new ArrayList<Formbox>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum rnum, formcode, formtype, formname, formcontent "
							+ "from ( select * from formbox "
							+ "order by formcode desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Formbox form = new Formbox();
				
				form.setFormcode(rset.getInt("formcode"));
				form.setFormtype(rset.getString("formtype"));
				form.setFormname(rset.getString("formname"));
				form.setFormcontent(rset.getString("formcontent"));
				
				list.add(form);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public Formbox selectOne (Connection conn, int formcode) {
		Formbox form = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from formbox where formcode = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, formcode);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				form = new Formbox();
				
				form.setFormcode(rset.getInt("formcode"));
				form.setFormtype(rset.getString("formtype"));
				form.setFormname(rset.getString("formname"));
				form.setFormcontent(rset.getString("formcontent"));
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return form;
		
	}
	
	public int addForm (Connection conn, Formbox form) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into formbox values (formcode_seq.nextval, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, form.getFormtype());
			pstmt.setString(2, form.getFormname());
			pstmt.setString(3, form.getFormcontent());
			
			result = pstmt.executeUpdate();
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getFormListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from formbox";
		
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
	public ArrayList<Formbox> selectList (Connection conn) {
		ArrayList<Formbox> list = new ArrayList<Formbox>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select * from formbox";
		

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Formbox form = new Formbox();
				
				form.setFormcode(rset.getInt("formcode"));
				form.setFormtype(rset.getString("formtype"));
				form.setFormname(rset.getString("formname"));
				form.setFormcontent(rset.getString("formcontent"));
				
				list.add(form);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
		
	}

	public int getFormListSearchT(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from formbox where formname like ?";
		
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

	public ArrayList<Formbox> draftFormSearchName(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Formbox> list = new ArrayList<Formbox>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum rnum, formcode, formtype, formname, formcontent "
							+ "from ( select * from formbox where formname like ? "
							+ "order by formcode desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Formbox form = new Formbox();
				
				form.setFormcode(rset.getInt("formcode"));
				form.setFormtype(rset.getString("formtype"));
				form.setFormname(rset.getString("formname"));
				form.setFormcontent(rset.getString("formcontent"));
				
				list.add(form);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public int getFormListSearchF(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) from formbox where formtype like ?";
		
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

	public ArrayList<Formbox> draftFormSearchType(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Formbox> list = new ArrayList<Formbox>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from (select rownum rnum, formcode, formtype, formname, formcontent "
							+ "from ( select * from formbox where formtype like ? "
							+ "order by formcode desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Formbox form = new Formbox();
				
				form.setFormcode(rset.getInt("formcode"));
				form.setFormtype(rset.getString("formtype"));
				form.setFormname(rset.getString("formname"));
				form.setFormcontent(rset.getString("formcontent"));
				
				list.add(form);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
}

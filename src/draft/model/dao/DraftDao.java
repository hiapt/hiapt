package draft.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import draft.model.vo.Draft;
import static common.JDBCTemplate.*;

public class DraftDao {


	public ArrayList<Draft> selectAll (Connection conn, String empno) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where display = 'Y' and formtype not like '업무일지' or empno = ? and formtype not like '업무일지'" 
							+ "order by docno desc";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setEmpname(rset.getString("empname"));
				draft.setEmpid(rset.getString("empid"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				draft.setFormname(rset.getString("formname"));
				list.add(draft);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public Draft selectOne (Connection conn, int docno) {
		Draft draft = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from draft join formbox using(formcode) where docno = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, docno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setEmpname(rset.getString("empname"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return draft;
		
	}

	public int insert(Connection conn, Draft draft) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into draft values (docno_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, default, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, draft.getEmpno());
			pstmt.setInt(2, draft.getFormcode());
			pstmt.setString(3, draft.getDoctitle());
			pstmt.setString(4, draft.getDoccontent());
			pstmt.setString(5, draft.getOriginfile());
			pstmt.setString(6, draft.getRenamefile());
			pstmt.setString(7, draft.getDisplay());
			pstmt.setString(8, draft.getNewcode());
			
			result = pstmt.executeUpdate();
			System.out.println("처리된 행 개수 : " + result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int update(Connection conn, Draft draft) {
		
		
		return 0;
	}

	
	public ArrayList<Draft> selectProgressStandby(Connection conn) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		
		
		Statement stmt =null;
		ResultSet rset = null;
		String query = "select * from draft where progress = '0' order by docno desc";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	public ArrayList<Draft> selectApprovedDoc(Connection conn) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		
		
		Statement stmt =null;
		ResultSet rset = null;
		String query = "select * from draft where progress = '1' order by docno desc";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	
	public ArrayList<Draft> selectReturnDoc(Connection conn) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		
		
		Statement stmt =null;
		ResultSet rset = null;
		String query = "select * from draft where progress = '2' order by docno desc";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	public ArrayList<Draft> selectDeferDoc(Connection conn) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		
		
		Statement stmt =null;
		ResultSet rset = null;
		String query = "select * from draft where progress = '3' order by docno desc";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	public ArrayList<Draft> selectTempDoc(Connection conn) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		
		
		Statement stmt =null;
		ResultSet rset = null;
		String query = "select * from draft where progress = '4' order by docno desc";
		
		try {
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int tempSave(Connection conn, Draft draft) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into draft values (docno_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, 4, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, draft.getEmpno());
			pstmt.setInt(2, draft.getFormcode());
			pstmt.setString(3, draft.getDoctitle());
			pstmt.setString(4, draft.getDoccontent());
			pstmt.setString(5, draft.getOriginfile());
			pstmt.setString(6, draft.getRenamefile());
			pstmt.setString(7, draft.getDisplay());
			pstmt.setString(8, draft.getNewcode());
			
			result = pstmt.executeUpdate();
			System.out.println("처리된 행 개수 : " + result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public ArrayList<Draft> draftTitleSearch(Connection conn, String keyword) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from draft join employee using (empno) "
							+ "join formbox using (formcode) "
							+ "where doctitle like ? order by docno desc";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setEmpname(rset.getString("empname"));
				draft.setEmpid(rset.getString("empid"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setFormname(rset.getString("formname"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public ArrayList<Draft> draftWriterSearch(Connection conn, String keyword) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from draft join employee using (empno) join formbox using (formcode) where empno like ? order by docno desc";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setEmpname(rset.getString("empname"));
				draft.setEmpid(rset.getString("empid"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setFormname(rset.getString("formname"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public ArrayList<Draft> draftDateSearch(Connection conn, Date from, Date to) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from draft join employee using (empno) join formbox using (formcode) where draftdate between ? and ? order by docno desc";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setEmpname(rset.getString("empname"));
				draft.setEmpid(rset.getString("empid"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setFormname(rset.getString("formname"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				list.add(draft);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public ArrayList<Draft> draftFormtypeSearch(Connection conn, String keyword) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from draft join employee using (empno) join formbox using (formcode) where formname like ? order by docno desc";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setDoccontent(rset.getString("doccontent"));
				draft.setEmpno(rset.getString("empno"));
				draft.setEmpname(rset.getString("empname"));
				draft.setEmpid(rset.getString("empid"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setProgress(rset.getString("progress"));
				draft.setFormname(rset.getString("formname"));
				list.add(draft);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
}

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


	public ArrayList<Draft> selectAll (Connection conn, int startRow, int endRow, String empno) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, progress, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where display = 'Y' and formtype not like '업무일지' and progress != '4' "
							+ "or empno = ? and formtype not like '업무일지' and progress != '4' " 
							+ "order by docno desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
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

	public int tempSave(Connection conn, Draft draft) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into draft values (tempdocno_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, 4, ?, ?)";
		
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
	
	
	public ArrayList<Draft> draftTitleSearch(Connection conn, String keyword, String empno, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, progress, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and formtype not like '업무일지' and progress != '4' and  doctitle like ? "
				+ "or empno = ? and formtype not like '업무일지' and progress != '4' and  doctitle like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";


		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword  + "%");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
			
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
	
	public ArrayList<Draft> draftWriterSearch(Connection conn, String keyword, String empno, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, progress, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and formtype not like '업무일지' and progress != '4' and  empname like ?"
				+ "or empno = ? and formtype not like '업무일지' and progress != '4' and empname like ?" 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword  + "%");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
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
	
	public ArrayList<Draft> draftDateSearch(Connection conn, Date from, Date to, String empno, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, progress, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and formtype not like '업무일지' and progress != '4' and draftdate between ? and ? "
				+ "or empno = ? and formtype not like '업무일지' and progress != '4' and draftdate between ? and ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			pstmt.setString(3, empno);
			pstmt.setDate(4, from);
			pstmt.setDate(5, to);
			pstmt.setInt(6, startRow);
			pstmt.setInt(7, endRow);
			
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
	
	public ArrayList<Draft> draftFormtypeSearch(Connection conn, String keyword, String empno, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, progress, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and formtype not like '업무일지' and progress != '4' and formname like ? "
				+ "or empno = ? and formtype not like '업무일지' and progress != '4' and formname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword  + "%");
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
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
	
	
	public int getListCount(Connection conn, String empno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and formtype not like '업무일지' and progress != '4' " + 
							"or empno = ? and formtype not like '업무일지' and progress != '4' ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			
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


	public int getListCountProgress(Connection conn, String empno, String progress) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and formtype not like '업무일지' and progress = ? " + 
							"or empno = ? and formtype not like '업무일지' and progress = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, progress);
			pstmt.setString(2, empno);
			pstmt.setString(3, progress);
			
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
	
	public int getSearchCountT(Connection conn, String keyword, String empno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and formtype not like '업무일지' and progress != '4' and doctitle like ? " + 
							"or empno = ? and formtype not like '업무일지' and progress != '4' and doctitle like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword  + "%");
			
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

	public int getSearchCountW(Connection conn, String keyword, String empno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and formtype not like '업무일지' and progress != '4' and empname like ? " + 
							"or empno = ? and formtype not like '업무일지' and progress != '4' and empname like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword  + "%");
			
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

	public int getSearchCountD(Connection conn, Date from, Date to, String empno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		String query = " select count(*) " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) " + 
				"where display = 'Y' and formtype not like '업무일지' and progress != '4' and draftdate between ? and ? " + 
				"or empno = ? and formtype not like '업무일지' and progress != '4' and draftdate between ? and ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			pstmt.setString(3, empno);
			pstmt.setDate(4, from);
			pstmt.setDate(5, to);
			
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
	
	public int getSearchCountF(Connection conn, String keyword, String empno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and formtype not like '업무일지' and progress != '4' and formname like ? " + 
							"or empno = ? and formtype not like '업무일지' and progress != '4' and formname like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword  + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword  + "%");
			
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

	public ArrayList<Draft> selectProgress(Connection conn, int startRow, int endRow, String empno, String progress) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, progress, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where display = 'Y' and formtype not like '업무일지' and progress = ? "
							+ "or empno = ? and formtype not like '업무일지' and progress = ? " 
							+ "order by docno desc )) "
							+ "where rnum >= ? and rnum <= ?";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, progress);
			pstmt.setString(2, empno);
			pstmt.setString(3, progress);
			pstmt.setInt(4, startRow);
			pstmt.setInt(5, endRow);
			
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
	
	

	public ArrayList<Draft> selectAllAdmin (Connection conn, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, progress, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where formtype not like '업무일지' and progress != '4' " 
							+ "order by docno desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
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

	public int getListCountAdmin(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and progress != '4' ";
		
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
	public ArrayList<Draft> selectAdminProgress (Connection conn, int startRow, int endRow, String progress) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, progress, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where formtype not like '업무일지' and progress != '4' and progress = ? " 
							+ "order by docno desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, progress);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
		
			
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

	public int getListCountAdminProgress(Connection conn, String progress) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and progress != '4' and progress = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, progress);
			
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

}

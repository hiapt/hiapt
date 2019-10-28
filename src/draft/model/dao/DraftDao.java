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
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ ""
							+ " where display like ? and docstatus != '5' "
							+ "or empno = ? and docstatus != '5' "
							+ "or approver like ? and docstatus != '5' " 
							+ "order by docno desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + empno + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + empno + "%");
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
				draft.setDocstatus(rset.getString("docstatus"));
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
		
		String query = "select d.docno, d.doctitle, d.doccontent, d.empno, p.empname, p.empid, d.draftdate, d.display, d.formcode, "
							+ "d.originfile, d.docstatus, d.formcode, f.formname, d.feedback, d.appdate, d.approver, e.empid, e.empname "
							+ "from draft d "
							+ "join formbox f on(d.formcode = f.formcode) "
							+ "join employee p on (d.empno = p.empno) "
							+ "join employee e on (d.approver = e.empno) "
							+ "where docno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, docno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				draft = new Draft();
			
				draft.setDocno(rset.getInt(1));
				draft.setDoctitle(rset.getString(2));
				draft.setDoccontent(rset.getString(3));
				draft.setEmpno(rset.getString(4));
				draft.setEmpname(rset.getString(5));
				draft.setEmpid(rset.getString(6));
				draft.setDraftdate(rset.getDate(7));
				draft.setDisplay(rset.getString(8));
				draft.setFormcode(rset.getInt(9));
				draft.setOriginfile(rset.getString(10));
				draft.setDocstatus(rset.getString(11));
				draft.setFormcode(rset.getInt(12));
				draft.setFormname(rset.getString(13));
				draft.setFeedback(rset.getString(14));
				draft.setAppdate(rset.getDate(15));
				draft.setAppempno(rset.getString(16));
				draft.setAppid(rset.getString(17));
				draft.setAppname(rset.getString(18));
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
		String query = "insert into draft values (docno_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, default, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, draft.getEmpno());
			pstmt.setInt(2, draft.getFormcode());
			pstmt.setString(3, draft.getDoctitle());
			pstmt.setString(4, draft.getDoccontent());
			pstmt.setString(5, draft.getOriginfile());
			pstmt.setString(6, draft.getRenamefile());
			pstmt.setString(7, draft.getDisplay());
			pstmt.setString(8, draft.getAppempno());
			pstmt.setDate(9, draft.getAppdate());
			pstmt.setString(10, draft.getFeedback());
			
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
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and docstatus != '4' and doctitle like ? "
				+ "or empno = ? and docstatus != '4' and doctitle like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";


		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword + "%");
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
				draft.setDocstatus(rset.getString("docstatus"));
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
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and docstatus != '4' and empname like ?"
				+ "or empno = ? and docstatus != '4' and empname like ?" 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword + "%");
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
				draft.setDocstatus(rset.getString("docstatus"));
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
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and docstatus != '4' and draftdate between ? and ? "
				+ "or empno = ? and docstatus != '4' and draftdate between ? and ? " 
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
				draft.setDocstatus(rset.getString("docstatus"));
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
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and docstatus != '4' and formname like ? "
				+ "or empno = ? and docstatus != '4' and formname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword + "%");
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
				draft.setDocstatus(rset.getString("docstatus"));
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
							"where display = 'Y' and docstatus != '4' " + 
							"or empno = ? and docstatus != '4' ";
		
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


	public int getListCountdocstatus(Connection conn, String empno, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and docstatus = ? " + 
							"or empno = ? and docstatus = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, empno);
			pstmt.setString(3, docstatus);
			
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
							"where display = 'Y' and docstatus != '4' and doctitle like ? " + 
							"or empno = ? and docstatus != '4' and doctitle like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword + "%");
			
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
							"where display = 'Y' and docstatus != '4' and empname like ? " + 
							"or empno = ? and docstatus != '4' and empname like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword + "%");
			
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
				"where display = 'Y' and docstatus != '4' and draftdate between ? and ? " + 
				"or empno = ? and docstatus != '4' and draftdate between ? and ? ";

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
							"where display = 'Y' and docstatus != '4' and formname like ? " + 
							"or empno = ? and docstatus != '4' and formname like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, empno);
			pstmt.setString(3, "%" + keyword + "%");
			
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

	public ArrayList<Draft> selectdocstatus(Connection conn, int startRow, int endRow, String empno, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where display = 'Y' and docstatus = ? "
							+ "or empno = ? and docstatus = ? " 
							+ "order by docno desc )) "
							+ "where rnum >= ? and rnum <= ?";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, empno);
			pstmt.setString(3, docstatus);
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
				draft.setDocstatus(rset.getString("docstatus"));
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
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where formtype not like '업무일지' and docstatus != '4' " 
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
				draft.setDocstatus(rset.getString("docstatus"));
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
							"where formtype not like '업무일지' and docstatus != '4' ";
		
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
	public ArrayList<Draft> selectAdmindocstatus (Connection conn, int startRow, int endRow, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where formtype not like '업무일지' and docstatus = ? " 
							+ "order by docno desc)) "
							+ "where rnum >= ? and rnum <= ? ";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getListCountAdmindocstatus(Connection conn, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			
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


	public int getNewListCountAdmin(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
								"from draft " + 
								"join formbox using (formcode) " + 
								"join employee using (empno) " + 
								"where formtype not like '업무일지' and docstatus != '4' and docstatus = '0' "
								+ "or formtype not like '업무일지' and docstatus != '4' and docstatus = '3' ";

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

	public int getSearchCountTAdmin(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus != '4' and doctitle like ? ";

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftTitleSearchAdmin(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where formtype not like '업무일지' and docstatus != '4' and doctitle like ? "
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
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
				draft.setFormname(rset.getString("formname"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getSearchCountWAdmin(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus != '4' and empname like ? ";

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftWriterSearchAdmin(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where formtype not like '업무일지' and docstatus != '4' and empname like ? "
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
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
				draft.setFormname(rset.getString("formname"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getSearchCountDAdmin(Connection conn, Date from, Date to) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus != '4' and draftdate between ? and ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			
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

	public ArrayList<Draft> draftDateSearchAdmin(Connection conn, Date from, Date to, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where formtype not like '업무일지' and docstatus != '4' and draftdate between ? and ? "
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getSearchCountFAdmin(Connection conn, String keyword) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus != '4' and formname like ? ";

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftFormtypeSearchAdmin(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where formtype not like '업무일지' and docstatus != '4' and formname like ? "
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
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
				draft.setFormname(rset.getString("formname"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountTAd(Connection conn, String keyword, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus = ? and doctitle like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftdocstatusTitleSearchAd(Connection conn, String keyword, int startRow, int endRow, String docstatus) {
			ArrayList<Draft> list = new ArrayList<Draft>();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	
	String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
			+ "display, formcode, originfile, docstatus, formname "
			+ "from ( select * from draft "
			+ "join formbox using (formcode) "
			+ "join employee using (empno) "
			+ "where formtype not like '업무일지' and docstatus = ? and doctitle like ? "
			+ "order by docno desc)) "
			+ "where rnum >= ? and rnum <= ? ";


	try {
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, docstatus);
		pstmt.setString(2, "%" + keyword + "%");
		pstmt.setInt(3, startRow);
		pstmt.setInt(4, endRow);
		
		
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
			draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountWAd(Connection conn, String keyword, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus = ? and empname like ? " ;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftdocstatusWriterSearchAd(Connection conn, String keyword, int startRow,
			int endRow, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where formtype not like '업무일지' and docstatus = ? and empname like ? "
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountDAd(Connection conn, Date from, Date to, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		String query = " select count(*) " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) " + 
				"where formtype not like '업무일지' and docstatus = ? and draftdate between ? and ? "; 

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
			
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

	public ArrayList<Draft> draftdocstatusDateSearchAd(Connection conn, Date from, Date to, int startRow,
			int endRow, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where formtype not like '업무일지' and docstatus = ? and draftdate between ? and ? "
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountFAd(Connection conn, String keyword, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where formtype not like '업무일지' and docstatus = ? and formname like ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftdocstatusFormtypeSearchAd(Connection conn, String keyword, int startRow,
			int endRow, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where formtype not like '업무일지' and docstatus = ? and formname like ? "
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";


		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountT(Connection conn, String keyword, String empno, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and docstatus = ? and doctitle like ? " + 
							"or empno = ? and docstatus = ? and doctitle like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, empno);
			pstmt.setString(4, docstatus);
			pstmt.setString(5, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftdocstatusTitleSearch(Connection conn, String keyword, String empno, int startRow, int endRow, String docstatus) {
			ArrayList<Draft> list = new ArrayList<Draft>();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	
	String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
			+ "display, formcode, originfile, docstatus, formname "
			+ "from ( select * from draft "
			+ "join formbox using (formcode) "
			+ "join employee using (empno) "
			+ "where display = 'Y' and docstatus = ? and doctitle like ? "
			+ "or empno = ? and docstatus = ? and doctitle like ? " 
			+ "order by docno desc)) "
			+ "where rnum >= ? and rnum <= ? ";


	try {
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, docstatus);
		pstmt.setString(2, "%" + keyword + "%");
		pstmt.setString(3, empno);
		pstmt.setString(4, docstatus);
		pstmt.setString(5, "%" + keyword + "%");
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
			draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountW(Connection conn, String keyword, String empno, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and docstatus = ? and empname like ? " + 
							"or empno = ? and docstatus = ? and empname like ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, empno);
			pstmt.setString(4, docstatus);
			pstmt.setString(5, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftdocstatusWriterSearch(Connection conn, String keyword, String empno, int startRow,
			int endRow, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and docstatus = ? and empname like ? "
				+ "or empno = ? and docstatus = ? and empname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";


		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, empno);
			pstmt.setString(4, docstatus);
			pstmt.setString(5, "%" + keyword + "%");
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountD(Connection conn, Date from, Date to, String empno, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		String query = " select count(*) " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) " + 
				"where display = 'Y' and docstatus = ? and draftdate between ? and ? " + 
				"or empno = ? and docstatus = ? and draftdate between ? and ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
			pstmt.setString(4, empno);
			pstmt.setString(5, docstatus);
			pstmt.setDate(6, from);
			pstmt.setDate(7, to);
			
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

	public ArrayList<Draft> draftdocstatusDateSearch(Connection conn, Date from, Date to, String empno, int startRow,
			int endRow, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and docstatus = ? and draftdate between ? and ? "
				+ "or empno = ? and docstatus = ? and draftdate between ? and ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
			pstmt.setString(4, empno);
			pstmt.setString(5, docstatus);
			pstmt.setDate(6, from);
			pstmt.setDate(7, to);
			pstmt.setInt(8, startRow);
			pstmt.setInt(9, endRow);
			
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getdocstatusSearchCountF(Connection conn, String keyword, String empno, String docstatus) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = " select count(*) " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) " + 
							"where display = 'Y' and docstatus = ? and formname like ? " + 
							"or empno = ? and docstatus = ? and formname like ? ";


		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, empno);
			pstmt.setString(4, docstatus);
			pstmt.setString(5, "%" + keyword + "%");
			
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

	public ArrayList<Draft> draftdocstatusFormtypeSearch(Connection conn, String keyword, String empno, int startRow,
			int endRow, String docstatus) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select * from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "where display = 'Y' and docstatus = ? and formname like ? "
				+ "or empno = ? and docstatus = ? and formname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";


		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, empno);
			pstmt.setString(4, docstatus);
			pstmt.setString(5, "%" + keyword + "%");
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int signDraft(Connection conn, Draft draft, String docstatus) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update draft set docstatus = ?, display = ?, "
				+ "appempno = ?, appdate = sysdate , feedback = ? "
				+ "where docno = ? and docstatus = '0' or docno = ? and docstatus = '3' ";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, docstatus);
			pstmt.setString(2, draft.getDisplay());
			pstmt.setString(3, draft.getAppempno());
			pstmt.setString(4, draft.getFeedback());
			pstmt.setInt(5, draft.getDocno());
			pstmt.setInt(6, draft.getDocno());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Draft> selectLogAd (Connection conn, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where formtype like '%업무%' and empno like 'admin' " 
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
				draft.setDocstatus(rset.getString("docstatus"));
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
	public ArrayList<Draft> selectLogEmp (Connection conn, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where formtype like '%업무%' and empno not like 'admin' " 
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
				draft.setDocstatus(rset.getString("docstatus"));
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
	public ArrayList<Draft> selectLogMy (Connection conn, int startRow, int endRow, String empno) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, docno, doctitle, doccontent, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select * from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "where formtype like '%업무%' and empno = ? " 
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
				draft.setDocstatus(rset.getString("docstatus"));
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

	public int getMyLogCount(Connection conn, String empno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		String query = " select count(*) " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) " + 
				"where formtype like '%업무%' and empno = ? ";
		
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
	
	
}

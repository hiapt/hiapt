package draft.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import draft.model.vo.Draft;
import draft.model.vo.DraftProcess;

import static common.JDBCTemplate.*;

public class DraftDao {


	public ArrayList<Draft> selectAll (Connection conn, int startRow, int endRow, String empno) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname, deadline "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname, deadline  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where empno = ? and docstatus != '5' " 
				+ "or display like ? and docstatus != '5' "
				+ "or appno = ? and docstatus != '5' "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus != '5' and nvl(signresult, 0) != '2' " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + empno + "%");	
			pstmt.setString(3, empno);
			pstmt.setString(4, empno);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			rset = pstmt.executeQuery();
			System.out.println(empno);
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
				draft.setEmpno(rset.getString("empno"));
				draft.setEmpname(rset.getString("empname"));
				draft.setEmpid(rset.getString("empid"));
				draft.setDraftdate(rset.getDate("draftdate"));
				draft.setDisplay(rset.getString("display"));
				draft.setFormcode(rset.getInt("formcode"));
				draft.setOriginfile(rset.getString("originfile"));
				draft.setDocstatus(rset.getString("docstatus"));
				draft.setFormname(rset.getString("formname"));
				draft.setDeadline(rset.getDate("deadline"));
				
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
	
	public DraftProcess selectOne (Connection conn, int docno) {
		DraftProcess dp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select docno, doctitle, doccontent, e1.empno, e1.empname, e1.empid, draftdate, display, " + 
				" originfile, docstatus, formname, feedback , ea1.empname, ea1.empid, ea2.empname, ea2.empid, " + 
				"ea3.empname, ea3.empid, ea4.empname, ea4.empid, ea5.empname, ea5.empid, " + 
				"ed1.empname, ed1.empid, ed2.empname, ed2.empid, ed3.empname, ed3.empid, " + 
				"ed4.empname, ed4.empid, ed5.empname, ed5.empid, deadline, appdate, signresult, appstep, renamefile " + 
				"from draft d " + 
				"join formbox using (formcode)" + 
				"join employee e1 on (d.empno = e1.empno) " + 
				"left join process using (docno) " + 
				"left join employee ea1 on (substr(approver, 1, 5) =ea1.empno) " + 
				"left join employee ea2 on (substr(approver, 7, 5) =ea2.empno) " + 
				"left join employee ea3 on (substr(approver, 13, 5) =ea3.empno) " + 
				"left join employee ea4 on (substr(approver, 19, 5) =ea4.empno) " + 
				"left join employee ea5 on (substr(approver, 25, 5) =ea5.empno) " + 
				"left join employee ed1 on (substr(display, 1, 5) =ed1.empno) " + 
				"left join employee ed2 on (substr(display, 7, 5) =ed2.empno) " + 
				"left join employee ed3 on (substr(display, 13, 5) =ed3.empno) " + 
				"left join employee ed4 on (substr(display, 19, 5) =ed4.empno) " + 
				"left join employee ed5 on (substr(display, 25, 5) =ed5.empno) " + 
				"where docno = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, docno);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				dp = new DraftProcess();
			
				dp.setDocno(rset.getInt(1));
				dp.setDoctitle(rset.getString(2));
				dp.setDoccontent(rset.getString(3));
				dp.setEmpno(rset.getString(4));
				dp.setEmpname(rset.getString(5));
				dp.setEmpid(rset.getString(6));
				dp.setDraftdate(rset.getDate(7));
				dp.setDisplay(rset.getString(8));
				dp.setOriginfile(rset.getString(9));
				dp.setDocstatus(rset.getString(10));
				dp.setFormname(rset.getString(11));
				dp.setFeedback(rset.getString(12));
				dp.setAppname1(rset.getString(13));
				dp.setAppid1(rset.getString(14));
				dp.setAppname2(rset.getString(15));
				dp.setAppid2(rset.getString(16));
				dp.setAppname3(rset.getString(17));
				dp.setAppid3(rset.getString(18));
				dp.setAppname4(rset.getString(19));
				dp.setAppid4(rset.getString(20));
				dp.setAppname5(rset.getString(21));
				dp.setAppid5(rset.getString(22));
				dp.setDisname1(rset.getString(23));
				dp.setDisid1(rset.getString(24));
				dp.setDisname2(rset.getString(25));
				dp.setDisid2(rset.getString(26));
				dp.setDisname3(rset.getString(27));
				dp.setDisid3(rset.getString(28));
				dp.setDisname4(rset.getString(29));
				dp.setDisid4(rset.getString(30));
				dp.setDisname5(rset.getString(31));
				dp.setDisid5(rset.getString(32));
				dp.setDeadline(rset.getDate(33));
				dp.setAppdate(rset.getDate(34));
				dp.setSignresult(rset.getString(35));
				dp.setAppstep(rset.getString(36));
				dp.setRenamefile(rset.getString(37));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return dp;
		
	}
	
	public ArrayList<DraftProcess> SignResult (Connection conn, int docno) {
		ArrayList<DraftProcess> list = new ArrayList<DraftProcess>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	
		String query = "select signresult, appdate, appno" + 
							" from process " + 
							" where docno = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, docno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DraftProcess dp = new DraftProcess();
				dp.setSignresult(rset.getString(1));
				dp.setAppdate(rset.getDate(2));
				dp.setAppno(rset.getString(3));
				
				list.add(dp);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	

	public int insert(Connection conn, Draft draft) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into draft values (docno_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, draft.getEmpno());
			pstmt.setInt(2, draft.getFormcode());
			pstmt.setString(3, draft.getDoctitle());
			pstmt.setString(4, draft.getDoccontent());
			pstmt.setString(5, draft.getOriginfile());
			pstmt.setString(6, draft.getRenamefile());
			pstmt.setString(7, draft.getDocstatus());
			pstmt.setString(8, draft.getApprover());
			pstmt.setDate(9, draft.getDeadline());
			pstmt.setString(10, draft.getDisplay());
			
			
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

		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus != '5' and doctitle like ? " 
				+ "or display like ? and docstatus != '5' and doctitle like ? "	
				+ "or appno = ? and docstatus != '5' and doctitle like ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus != '5' and nvl(signresult, 0) != '2' and doctitle like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, empno);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, "%" + keyword + "%");
			pstmt.setInt(9, startRow);
			pstmt.setInt(10, endRow);
			
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus != '5' and empname like ? " 
				+ "or display like ? and docstatus != '5' and empname like ? "	
				+ "or appno = ? and docstatus != '5' and empname like ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus != '5' and nvl(signresult, 0) != '2' and empname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, empno);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, "%" + keyword + "%");
			pstmt.setInt(9, startRow);
			pstmt.setInt(10, endRow);
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus != '5' and draftdate between ? and ? " 
				+ "or display like ? and docstatus != '5' and draftdate between ? and ? "	
				+ "or appno = ? and docstatus != '5' and draftdate between ? and ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus != '5' and nvl(signresult, 0) != '2' and draftdate between ? and ?  " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
			pstmt.setString(4, "%" + empno + "%");
			pstmt.setDate(5, from);
			pstmt.setDate(6, to);
			pstmt.setString(7, empno);
			pstmt.setDate(8, from);
			pstmt.setDate(9, to);
			pstmt.setString(10, empno);
			pstmt.setDate(11, from);
			pstmt.setDate(12, to);
			pstmt.setInt(13, startRow);
			pstmt.setInt(14, endRow);
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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

		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
						+ "display, formcode, originfile, docstatus, formname "
						+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
						+ "from draft "
						+ "join formbox using (formcode) "
						+ "join employee using (empno) "
						+ "left join process using (docno) "
						+ " where empno = ? and docstatus != 5 and formname like ? " 
						+ "or display like ? and docstatus != 5 and formname like ? "	
						+ "or appno = ? and docstatus != '5' "
						+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus != '5' and nvl(signresult, 0) != '2' and formname like ? " 
						+ "order by docno desc)) "
						+ "where rnum >= ? and rnum <= ? ";
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, empno);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, "%" + keyword + "%");
			pstmt.setInt(9, startRow);
			pstmt.setInt(10, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno)   " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) "  
							+ "left join process using (docno) "
							+ " where empno = ? and docstatus != '5' " 
							+ "or display like ? and docstatus != '5' "
							+ "or appno = ? and docstatus != '5' "
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus != '5' and nvl(signresult, 0) != '2' ";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + empno + "%");
			pstmt.setString(3, empno);
			pstmt.setString(4, empno);
			
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
		
		String query = " select count(distinct docno) " 
							+ "from draft " 
							+ "join formbox using (formcode) " 
							+ "join employee using (empno) "
							+ "left join process using (docno) " 
							+ "where empno = ? and docstatus = ? " 
							+ "or display like ? and docstatus = ? "
							+ "or appno = ? and docstatus = ? "
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ? and nvl(signresult, 0) != '2' "; 

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, docstatus);
			pstmt.setString(5, empno);
			pstmt.setString(6, docstatus);
			pstmt.setString(7, empno);
			pstmt.setString(8, docstatus);
			
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
		
		String query = " select count(distinct docno) " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) "  
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus != '5' and doctitle like ? " 
				+ "or display like ? and docstatus != '5' and doctitle like ? "
				+ "or appno = ? and docstatus != '5' and doctitle like ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus != '5' and nvl(signresult, 0) != '2' and doctitle like ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, empno);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, "%" + keyword + "%");
			
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
		
		String query = " select count(distinct docno) " 
							+ "from draft " 
							+ "join formbox using (formcode) " 
							+ "join employee using (empno) "  
							+ "left join process using (docno) "
							+ " where empno = ? and docstatus != '5' and empname like ? " 
							+ "or display like ? and docstatus != '5' and empname like ? "
							+ "or appno = ? and docstatus != '5' and empname like ? "
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and nvl(signresult, 0) != '2' and docstatus != '5' and empname like ? "; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, empno);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, "%" + keyword + "%");
			
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

		String query = " select count(distinct docno) " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) "  
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus != '5' and draftdate between ? and ? " 
				+ "or display like ? and docstatus != '5' and draftdate between ? and ? "
				+ "or appno = ? and docstatus != '5' and draftdate between ? and ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and nvl(signresult, 0) != '2' and docstatus != '5' and draftdate between ? and ? " ;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
			pstmt.setString(4, "%" + empno + "%");
			pstmt.setDate(5, from);
			pstmt.setDate(6, to);
			pstmt.setString(7, empno);
			pstmt.setDate(8, from);
			pstmt.setDate(9, to);
			pstmt.setString(10, empno);
			pstmt.setDate(11, from);
			pstmt.setDate(12, to);
			
			
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
		
		String query = " select count(distinct docno) " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) "  
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus != '5' and formname like ? " 
				+ "or display like ? and docstatus != '5' and formname like ? "
				+ "or appno = ? and docstatus != '5' and formname like ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and nvl(signresult, 0) != '2' and docstatus != '5' and formname like ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, empno);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, "%" + keyword + "%");
			
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
	
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus = ? " 
				+ "or display like ? and docstatus = ? "
				+ "or appno = ? and docstatus = ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and nvl(signresult, 0) != '2' and docstatus = ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setString(3, "%" + empno + "%");
			pstmt.setString(4, docstatus);
			pstmt.setString(5, empno);
			pstmt.setString(6, docstatus);
			pstmt.setString(7, empno);
			pstmt.setString(8, docstatus);
			pstmt.setInt(9, startRow);
			pstmt.setInt(10, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5' and signresult != '2' "
				+ "or approver = 'admin' and docstatus != '5' " 
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
		
		String query = " select count(distinct docno) "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5' and signresult != '2'  "
							+ "or approver = 'admin' and docstatus != '5' ";

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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
							+ "display, formcode, originfile, docstatus, formname "
							+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ? and signresult != '2' "
							+ "or approver = 'admin' and docstatus = ? " 
							+ "order by docno desc)) "
							+ "where rnum >= ? and rnum <= ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, docstatus);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
		
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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

		String query = " select count(distinct docno) "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ? and signresult != '2'  "
							+ "or approver = 'admin' and docstatus = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, docstatus);
			
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

		String query = " select count(distinct docno) "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = '0' and signresult != '2'  "
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = '1' and signresult != '2'  "
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = '4' and signresult != '2'  "
							+ "or approver = 'admin' and docstatus = '0' "
							+ "or approver = 'admin' and docstatus = '1' "
							+ "or approver = 'admin' and docstatus = '4' ";
		
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
		
		String query = " select count(distinct docno) "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5' and signresult != '2'  and doctitle like ? "
							+ "or approver = 'admin' and docstatus != '5' and doctitle like ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
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

	public ArrayList<Draft> draftTitleSearchAdmin(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5' and signresult != '2'  and doctitle like ? "
				+ "or approver = 'admin' and docstatus != '5' and doctitle like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno) "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5'  and signresult != '2' and empname like ? "
							+ "or approver = 'admin' and docstatus != '5' and empname like ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
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

	public ArrayList<Draft> draftWriterSearchAdmin(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5' and signresult != '2' and empname like ? "
				+ "or approver = 'admin' and docstatus != '5' and empname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno) "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5'  and signresult != '2'  and draftdate between ? and ? "
							+ "or approver = 'admin' and docstatus != '5' and draftdate between ? and ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			pstmt.setDate(3, from);
			pstmt.setDate(4, to);
			
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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5' and signresult != '2' and draftdate between ? and ?  "
				+ "or approver = 'admin' and docstatus != '5' and draftdate between ? and ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, from);
			pstmt.setDate(2, to);
			pstmt.setDate(3, from);
			pstmt.setDate(4, to);
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno) "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5' and signresult != '2' and formname like ? "
				+ "or approver = 'admin' and docstatus != '5' and formname like ? ";

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
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

	public ArrayList<Draft> draftFormtypeSearchAdmin(Connection conn, String keyword, int startRow, int endRow) {
		ArrayList<Draft> list = new ArrayList<Draft>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus != '5'  and signresult != '2' and formname like ? "
				+ "or approver = 'admin' and docstatus != '5' and formname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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

		String query = " select count(distinct docno) "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ? and signresult != '2' and doctitle like ? "
				+ "or approver = 'admin' and docstatus = ? and doctitle like ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, docstatus);
			pstmt.setString(4, "%" + keyword + "%");
			
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
	
	String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
					+ "display, formcode, originfile, docstatus, formname "
					+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
					+ "from draft "
					+ "join formbox using (formcode) "
					+ "join employee using (empno) "
					+ "left join process using (docno) "
					+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ? and signresult != '2' and doctitle like ? "
					+ "or approver = 'admin' and docstatus = ? and doctitle like ? " 
					+ "order by docno desc)) "
					+ "where rnum >= ? and rnum <= ? ";

	try {
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, docstatus);
		pstmt.setString(2, "%" + keyword + "%");
		pstmt.setString(3, docstatus);
		pstmt.setString(4, "%" + keyword + "%");
		pstmt.setInt(5, startRow);
		pstmt.setInt(6, endRow);
		
		rset = pstmt.executeQuery();

		while(rset.next()) {
			Draft draft = new Draft();
			draft.setDocno(rset.getInt("docno"));
			draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno) "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ? and signresult != '2' and empname like ? "
				+ "or approver = 'admin' and docstatus = ? and empname like ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, docstatus);
			pstmt.setString(4, "%" + keyword + "%");
			
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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ? and signresult != '2' and empname like ? "
				+ "or approver = 'admin' and docstatus = ? and empname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, docstatus);
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno) "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ?  and signresult != '2'  and draftdate between ? and ?  "
				+ "or approver = 'admin' and docstatus = ?  and draftdate between ? and ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
			pstmt.setString(4, docstatus);
			pstmt.setDate(5, from);
			pstmt.setDate(6, to);
			
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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ? and signresult != '2'  and draftdate between ? and ? "
				+ "or approver = 'admin' and docstatus = ? and draftdate between ? and ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setDate(2, from);
			pstmt.setDate(3, to);
			pstmt.setString(4, docstatus);
			pstmt.setDate(5, from);
			pstmt.setDate(6, to);
			pstmt.setInt(7, startRow);
			pstmt.setInt(8, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno) "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ?  and signresult != '2' and formname like ? "
				+ "or approver = 'admin' and docstatus = ? and formname like ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, docstatus);
			pstmt.setString(4, "%" + keyword + "%");
			
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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = 'admin' and docstatus = ?  and signresult != '2'  and formname like ? "
				+ "or approver = 'admin' and docstatus = ? and formname like ? " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docstatus);
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, docstatus);
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setInt(5, startRow);
			pstmt.setInt(6, endRow);
			
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno)   " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) "  
							+ "left join process using (docno) "
							+ " where empno = ? and docstatus = ? and doctitle like ? " 
							+ "or display like ? and docstatus = ? and doctitle like ? "
							+ "or appno = ? and docstatus = ? and doctitle like ? "
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ? and nvl(signresult, 0) != '2' and doctitle like ? " ;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + empno + "%");
			pstmt.setString(5, docstatus);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, docstatus);
			pstmt.setString(9, "%" + keyword + "%");
			pstmt.setString(10, empno);
			pstmt.setString(11, docstatus);
			pstmt.setString(12, "%" + keyword + "%");
			
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
	
	String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
						+ "display, formcode, originfile, docstatus, formname "
						+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
						+ "from draft "
						+ "join formbox using (formcode) "
						+ "join employee using (empno) "
						+ "left join process using (docno) "
						+ " where empno = ? and docstatus = ? and doctitle like ? " 
						+ "or display like ? and docstatus = ? and doctitle like ? "
						+ "or appno = ? and docstatus = ? and doctitle like ? "
						+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ?  and nvl(signresult, 0) != '2' and doctitle like ? " 
						+ "order by docno desc)) "
						+ "where rnum >= ? and rnum <= ? ";

	try {
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, empno);
		pstmt.setString(2, docstatus);
		pstmt.setString(3, "%" + keyword + "%");
		pstmt.setString(4, "%" + empno + "5");
		pstmt.setString(5, docstatus);
		pstmt.setString(6, "%" + keyword + "%");
		pstmt.setString(7, empno);
		pstmt.setString(8, docstatus);
		pstmt.setString(9, "%" + keyword + "%");
		pstmt.setString(10, empno);
		pstmt.setString(11, docstatus);
		pstmt.setString(12, "%" + keyword + "%");
		pstmt.setInt(13, startRow);
		pstmt.setInt(14, endRow);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			Draft draft = new Draft();
			draft.setDocno(rset.getInt("docno"));
			draft.setDoctitle(rset.getString("doctitle"));
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

		String query = " select count(distinct docno)   " + 
							"from draft " + 
							"join formbox using (formcode) " + 
							"join employee using (empno) "  
							+ "left join process using (docno) "
							+ " where empno = ? and docstatus = ? and empname like ? " 
							+ "or display like ? and docstatus = ? and empname like ? "
							+ "or appno = ? and docstatus = ? and empname like ? "
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ?  and nvl(signresult, 0) != '2' and empname like ? " ;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + empno + "%");
			pstmt.setString(5, docstatus);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, docstatus);
			pstmt.setString(9, "%" + keyword + "%");
			pstmt.setString(10, empno);
			pstmt.setString(11, docstatus);
			pstmt.setString(12, "%" + keyword + "%");
			
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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus = ? and empname like ? " 
				+ "or display like ? and docstatus = ? and empname like ? "
				+ "or appno = ? and docstatus != '5' "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ?  and nvl(signresult, 0) != '2' and docstatus != '5' " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + empno + "%");
			pstmt.setString(5, docstatus);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, docstatus);
			pstmt.setString(9, "%" + keyword + "%");
			pstmt.setString(10, empno);
			pstmt.setString(11, docstatus);
			pstmt.setString(12, "%" + keyword + "%");
			pstmt.setInt(13, startRow);
			pstmt.setInt(14, endRow);
			
			
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno)   " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) "  
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus = ? and draftdate between ? and ? " 
				+ "or display like ? and docstatus = ? and draftdate between ? and ?"
				+ "or appno = ? and docstatus = ? and draftdate between ? and ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ?  and nvl(signresult, 0) != '2' and draftdate between ? and ? " ;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setDate(3, from);
			pstmt.setDate(4, to);
			pstmt.setString(5, "%" + empno + "%");
			pstmt.setString(6, docstatus);
			pstmt.setDate(7, from);
			pstmt.setDate(8, to);
			pstmt.setString(9, empno);
			pstmt.setString(10, docstatus);
			pstmt.setDate(11, from);
			pstmt.setDate(12, to);
			pstmt.setString(13, empno);
			pstmt.setString(14, docstatus);
			pstmt.setDate(15, from);
			pstmt.setDate(16, to);
			
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

		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
						+ "display, formcode, originfile, docstatus, formname "
						+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
						+ "from draft "
						+ "join formbox using (formcode) "
						+ "join employee using (empno) "
						+ "left join process using (docno) "
						+ " where empno = ? and docstatus = ? and draftdate between ? and ? " 
						+ "or display like ? and docstatus = ? and draftdate between ? and ? "
						+ "or appno = ? and docstatus = ? and draftdate between ? and ? "
						+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ?  and nvl(signresult, 0) != '2' and draftdate between ? and ? " 
						+ "order by docno desc)) "
						+ "where rnum >= ? and rnum <= ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setDate(3, from);
			pstmt.setDate(4, to);
			pstmt.setString(5, "%" + empno + "%");
			pstmt.setString(6, docstatus);
			pstmt.setDate(7, from);
			pstmt.setDate(8, to);
			pstmt.setString(9, empno);
			pstmt.setString(10, docstatus);
			pstmt.setDate(11, from);
			pstmt.setDate(12, to);
			pstmt.setString(13, empno);
			pstmt.setString(14, docstatus);
			pstmt.setDate(15, from);
			pstmt.setDate(16, to);
			pstmt.setInt(17, startRow);
			pstmt.setInt(18, endRow);
			
			rset = pstmt.executeQuery();
			

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		
		String query = " select count(distinct docno)   " + 
				"from draft " + 
				"join formbox using (formcode) " + 
				"join employee using (empno) "  
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus = ? and formname like ? " 
				+ "or display like ? and docstatus = ? and formname like ? "
				+ "or appno = ? and docstatus = ? and formname like ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ? and nvl(signresult, 0) != '2' and formname like ? " ;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + empno + "%");
			pstmt.setString(5, docstatus);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, docstatus);
			pstmt.setString(9, "%" + keyword + "%");
			
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
		
		String query = "select * from ( select rownum rnum, docno, doctitle, empno, empid, empname, draftdate, "
				+ "display, formcode, originfile, docstatus, formname "
				+ "from ( select distinct  docno, doctitle, empno, empid, empname, draftdate, display, formcode, originfile, docstatus, formname  "
				+ "from draft "
				+ "join formbox using (formcode) "
				+ "join employee using (empno) "
				+ "left join process using (docno) "
				+ " where empno = ? and docstatus = ? and formname like ? " 
				+ "or display like ? and docstatus = ? and formname like ? "
				+ "or appno = ? and docstatus = ? and formname like ? "
				+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = ?  and nvl(signresult, 0) != '2'  and formname like ?  " 
				+ "order by docno desc)) "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, docstatus);
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + empno + "%");
			pstmt.setString(5, docstatus);
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, empno);
			pstmt.setString(8, docstatus);
			pstmt.setString(9, "%" + keyword + "%");
			pstmt.setString(10, empno);
			pstmt.setString(11, docstatus);
			pstmt.setString(12, "%" + keyword + "%");
			pstmt.setInt(13, startRow);
			pstmt.setInt(14, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Draft draft = new Draft();
				draft.setDocno(rset.getInt("docno"));
				draft.setDoctitle(rset.getString("doctitle"));
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
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int signDraft(Connection conn, Draft draft, int docno, String empno, String sresult) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into process values (?, ?, (select count(*) from process where docno = ? ) + 1, ?, sysdate, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, docno);
			pstmt.setString(2, empno);
			pstmt.setInt(3, docno);
			pstmt.setString(4, sresult);
			pstmt.setString(5, draft.getFeedback());
			
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
	
	public int deleteTemp(Connection conn, String docno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from draft where docno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, docno);
			
			result = pstmt.executeUpdate();
			System.out.println("처리된 행 개수 : " + result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getNewListCountEmp(Connection conn, String empno) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(distinct docno) "
							+ "from draft "
							+ "join formbox using (formcode) "
							+ "join employee using (empno) "
							+ "left join process using (docno) "
							+ "where substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = '0'  and nvl(signresult, 0) != '2' " 
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = '1'  and nvl(signresult, 0) != '2' " 
							+ "or substr(approver, decode(appstep, null, 1, 1, 7, 2, 13, 3, 19, 4, 25), 5) = ? and docstatus = '4'  and nvl(signresult, 0) != '2' " ;
				
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, empno);
			pstmt.setString(3, empno);
			
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

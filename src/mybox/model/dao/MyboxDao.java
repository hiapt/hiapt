package mybox.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mybox.model.vo.Mybox;


public class MyboxDao {
	
	public ArrayList<Mybox> selectAll (Connection conn, String empno) {
		ArrayList<Mybox> list = new ArrayList<Mybox>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from myboxlist where empno = ? order by myboxcode asc";
		

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Mybox my = new Mybox();
				my.setMyboxcode(rset.getString("myboxcode"));
				my.setMyboxname(rset.getString("myboxname"));
				
				list.add(my);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Mybox> selectList(Connection conn, int startRow, int endRow, String empno, String myboxcode) {
		ArrayList<Mybox> list = new ArrayList<Mybox>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from ( select rownum rnum, myboxcode, myboxname, docno, empno, savedate, "
							+ "doctitle, doccontent, empid, empname, draftdate, docstatus, originfile, formname "
							+ "from (select m.myboxcode, l.myboxname, m.docno, m.empno, m.savedate, d.doctitle, d.doccontent,  "
							+ "e.empid, e.empname, d.draftdate, d.docstatus, d.originfile, f.formname "
							+ "from mybox m "
							+ "join draft d on (m.docno = d.docno) "
							+ "join employee e on (m.empno = e.empno) "
							+ "join myboxlist l on (l.myboxcode = m.myboxcode) "
							+ "join formbox f on (d.formcode = f.formcode) "
							+ "where m.empno = ? and m.myboxcode = ? order by m.savedate desc, m.docno desc )) "
							+ "where rnum >= ? and rnum <= ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, myboxcode);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Mybox my = new Mybox();
				my.setMyboxcode(rset.getString(2));
				my.setMyboxname(rset.getString(3));
				my.setDocno(rset.getInt(4));
				my.setEmpno(rset.getString(5));
				my.setSavedate(rset.getDate(6));
				my.setDoctitle(rset.getString(7));
				my.setDoccontent(rset.getString(8));
				my.setEmpid(rset.getString(9));
				my.setEmpname(rset.getString(10));
				my.setDraftdate(rset.getDate(11));
				my.setDocstatus(rset.getString(12));
				my.setOriginfile(rset.getString(13));
				my.setFormname(rset.getString(14));
				list.add(my);
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int getMyboxCount(Connection conn, String empno, String myboxcode) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) " + 
							"from mybox m " + 
							"join draft d using (docno) " + 
							"join employee e on (m.empno = e.empno) " + 
							"join formbox f using (formcode) " + 
							 "where empno = ? and myboxcode = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, myboxcode);
			
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
	
	public int addmybox(Connection conn, Mybox my, String empno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into myboxlist values ((select count(*) from myboxlist where empno = ? ) + 1, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, empno);
			pstmt.setString(3, my.getMyboxname());
			
			result = pstmt.executeUpdate();
			System.out.println("처리된 행 개수 : " + result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int insertMybox(Connection conn, Mybox mbox) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into mybox values (?, ?, ?, sysdate)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mbox.getMyboxcode());
			pstmt.setString(2, mbox.getEmpno());
			pstmt.setInt(3, mbox.getDocno());
			
			result = pstmt.executeUpdate();
			System.out.println("처리된 행 개수 : " + result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}

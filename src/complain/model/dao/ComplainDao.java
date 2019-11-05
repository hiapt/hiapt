package complain.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.BoardFiles;
import complain.model.vo.Complain;
import complain.model.vo.ComplainImgs;
import vote.model.vo.Vote;

public class ComplainDao {
	// 페이지 처리용 전체목록 갯수조회
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(comp_no) from complain";

		try {
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}
	//전체목록조회
	public ArrayList<Complain> selectList(Connection conn, int startlist, int endlist) {
			ArrayList<Complain> clist = new ArrayList<Complain>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "SELECT * " + 
						   "FROM (SELECT ROWNUM AS RNUM, COMP_NO, COMP_TITLE, USERNAME, USERID, COMP_DATE, COMP_RESULT_STATUS, COMP_SECRET, COMP_RESPONSE " + 
						   "      FROM (SELECT * " + 
						   "            FROM complain " + 
						   "            JOIN APTUSER USING(USERID) "+
						   "            ORDER BY COMP_NO DESC)) " + 
						   "WHERE RNUM BETWEEN ? AND ?";
			
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setInt(1, startlist);
				pstmt.setInt(2, endlist);
				rset=pstmt.executeQuery();

				while(rset.next()) {
					Complain comp = new Complain();
					comp.setCompNo(rset.getInt(2));
					comp.setCompTitle(rset.getString(3));
					comp.setUserName(rset.getString(4));
					comp.setUserId(rset.getString(5));
					comp.setCompDate(rset.getDate(6));
					comp.setCompResultStatus(rset.getString(7));
					comp.setCompSecret(rset.getString(8));
					comp.setCompReponse(rset.getString(9));
					
					clist.add(comp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return clist;
		}
	//민원등록
	public int insertComplain(Connection conn, Complain comp) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "insert into complain values(COMPLAIN_SEQ.nextval, ?, default, ?, default, ?, null, 'admin', ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, comp.getCompTitle());
			pstmt.setString(2, comp.getCompContents());
			pstmt.setString(3, comp.getCompSecret());
			pstmt.setString(4, comp.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//마지막 번호조회
	public int selectLastCno(Connection conn) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select max(comp_no) from complain";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
	
			if(rset.next())
				result = rset.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	
	//이미지파일등록
	public int insertComplainImg(Connection conn, int cno, ComplainImgs cImg) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "insert into complainimg values(?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cno);
			pstmt.setString(2, cImg.getCompOriginalImgname());
			pstmt.setString(3, cImg.getCompRenameImgname());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//상세조회
	public Complain selectView(Connection conn, int cNo) {
		Complain comp = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select comp_no, comp_title, comp_date, comp_contents, comp_result_status, comp_secret, comp_response, empno, empname, userid, username, userphone " + 
				"from complain " + 
				"JOIN APTUSER USING(USERID) " + 
				"join employee using(empno) " + 
				"where comp_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				comp = new Complain();
				
				comp.setCompNo(rset.getInt(1));
				comp.setCompTitle(rset.getString(2));
				comp.setCompDate(rset.getDate(3));
				comp.setCompContents(rset.getString(4));
				comp.setCompResultStatus(rset.getString(5));
				comp.setCompSecret(rset.getString(6));
				comp.setCompReponse(rset.getString(7));
				comp.setEmpNo(rset.getString(8));
				comp.setEmpName(rset.getString(9));
				comp.setUserId(rset.getString(10));
				comp.setUserName(rset.getString(11));
				comp.setUserPhone(rset.getString(12));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return comp;
	}
	//이미지조회
	public ArrayList<ComplainImgs> selectImgs(Connection conn, int cNo) {
		ArrayList<ComplainImgs> imglist = new ArrayList<ComplainImgs>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select comp_original_imgname, comp_rename_imgname " + 
				"from complainimg " + 
				"where comp_no = ? " + 
				"order by comp_rename_imgname asc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ComplainImgs cimg = new ComplainImgs();
				
				cimg.setCompOriginalImgname(rset.getString(1));
				cimg.setCompRenameImgname(rset.getString(2));
				
				imglist.add(cimg);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return imglist;
	}
	//민원 글 삭제
	public int deleteComplain(Connection conn, int cNo) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "delete from complain where comp_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNo);

			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//민원 내용 수정
	public int updateComplain(Connection conn, Complain comp) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "update complain set comp_title=?, comp_contents=?, comp_secret=? "
				+ " where comp_no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, comp.getCompTitle());
			pstmt.setString(2, comp.getCompContents());
			pstmt.setString(3, comp.getCompSecret());
			pstmt.setInt(4, comp.getCompNo());

			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteFile(Connection conn, String renameFileName) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "delete from complainimg where comp_rename_imgname= ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, renameFileName);

			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//제목목록갯수
	public int getSearchTitleListCount(Connection conn, String searchText) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="select count(comp_no) from complain where comp_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			
			rset=pstmt.executeQuery();
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
	//제목검색
	public ArrayList<Complain> searchTitle(Connection conn, int startlist, int endlist, String searchText) {
		ArrayList<Complain> clist = new ArrayList<Complain>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="SELECT * " + 
					  "FROM (SELECT ROWNUM AS RNUM, COMP_NO, COMP_TITLE, USERNAME, " + 
					  "             USERID, COMP_DATE, COMP_RESULT_STATUS, COMP_SECRET, COMP_RESPONSE " + 
					  "      FROM (SELECT * " + 
					  "			   FROM COMPLAIN " + 
					  "			   WHERE COMP_TITLE LIKE ?" + 
					  "			   ORDER BY COMP_NO DESC) " + 
					  "      JOIN APTUSER USING (USERID)) " + 
					  " WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			pstmt.setInt(2, startlist);
			pstmt.setInt(3, endlist);
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Complain comp = new Complain();
				
				comp.setCompNo(rset.getInt(2));
				comp.setCompTitle(rset.getString(3));
				comp.setUserName(rset.getString(4));
				comp.setUserId(rset.getString(5));
				comp.setCompDate(rset.getDate(6));
				comp.setCompResultStatus(rset.getString(7));
				comp.setCompSecret(rset.getString(8));
				comp.setCompReponse(rset.getString(9));
				
				clist.add(comp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return clist;
	}
	//작성자 목록갯수
	public int getSearchUserNameListCount(Connection conn, String searchText) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="select count(comp_no) " + 
					  "from complain " + 
					  "where userid in (select userid " + 
					  "                 from aptuser " + 
					  "                 WHERE username like ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			
			rset=pstmt.executeQuery();
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
	}//작성자검색
	public ArrayList<Complain> searchUserName(Connection conn, int startlist, int endlist, String searchText) {
		ArrayList<Complain> clist = new ArrayList<Complain>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="SELECT * " + 
					  "FROM (SELECT ROWNUM AS RNUM, COMP_NO, COMP_TITLE, USERNAME, " + 
					  "             USERID, COMP_DATE, COMP_RESULT_STATUS, COMP_SECRET, COMP_RESPONSE " + 
					  "      FROM (select * " + 
					  "            from complain " + 
					  "            where userid in (select userid " + 
					  "                             from aptuser " + 
					  "                             WHERE username like ?) " + 
					  "			   ORDER BY COMP_NO DESC) " + 
					  "      JOIN APTUSER USING (USERID)) " + 
					  " WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			pstmt.setInt(2, startlist);
			pstmt.setInt(3, endlist);
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Complain comp = new Complain();
				
				comp.setCompNo(rset.getInt(2));
				comp.setCompTitle(rset.getString(3));
				comp.setUserName(rset.getString(4));
				comp.setUserId(rset.getString(5));
				comp.setCompDate(rset.getDate(6));
				comp.setCompResultStatus(rset.getString(7));
				comp.setCompSecret(rset.getString(8));
				comp.setCompReponse(rset.getString(9));
				
				clist.add(comp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return clist;
	}
	//관리자 답변 작성,수정
	public int updateAdminComplain(Connection conn, Complain comp) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "update complain set comp_result_status=?, comp_response=? "
				+ " where comp_no=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, comp.getCompResultStatus());
			pstmt.setString(2, comp.getCompReponse());
			pstmt.setInt(3, comp.getCompNo());

			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}



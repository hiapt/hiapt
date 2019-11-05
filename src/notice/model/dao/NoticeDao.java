package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.BoardFiles;

import static common.JDBCTemplate.*;
import notice.model.vo.Notice;
import notice.model.vo.NoticeFiles;
import vote.model.vo.Vote;

public class NoticeDao {

	//전체 목록 갯수 O
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query ="select count(notice_no) from notice";
		
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
	//전체 목록 조회 O
	public ArrayList<Notice> selectList(Connection conn, int startlist, int endlist) {
		ArrayList<Notice> nlist = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="select * " + 
				"from(select rownum as rnum, notice_no, notice_title, notice_date, notice_read_count, notice_writer, " + 
				"case when notice_no in (select notice_no from noticefiles) then 'Y' else 'N' end as fileYorN " + 
				"from(select distinct notice_no, notice_title, notice_date, notice_read_count, notice_writer from notice " + 
				"left outer join noticefiles using(notice_no) order by notice_no desc)) " +
				"where rnum between ? and ?";	
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, startlist);
			pstmt.setInt(2, endlist);
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt(2));
				notice.setNoticeTitle(rset.getString(3));				
				notice.setNoticeDate(rset.getDate(4));
				notice.setNoticeReadCount(rset.getInt(5));
				notice.setNoticeWriter(rset.getString(6));
				notice.setFileYorN(rset.getString(7));
				
				nlist.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return nlist;
	}
	
	//조회수 증가 O
	public int updateReadCount(Connection conn, int nNo) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "update notice set notice_read_count = notice_read_count +1"
				+ " where notice_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//공지 상세보기 O 
	public Notice selectOne(Connection conn, int nNo) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				
				notice.setNoticeNo(rset.getInt(1));
				notice.setNoticeTitle(rset.getString(2));				
				notice.setNoticeDate(rset.getDate(3));
				notice.setNoticeReadCount(rset.getInt(4));
				notice.setNoticeWriter(rset.getString(5));				
				notice.setNoticeContents(rset.getString(6));
			
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}
	//공지 인서트O
	public int insertNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into notice values(NOTICE_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setDate(2, notice.getNoticeDate());
			pstmt.setInt(3, notice.getNoticeReadCount());
			pstmt.setString(4, notice.getNoticeWriter());
			pstmt.setString(5, notice.getNoticeContents());
			
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		
		return result;
		
	}
	//공지 수정
	public int updateNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query ="update notice set notice_title = ?, notice_date = ?, notice_contents = ? where notice_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setDate(2, notice.getNoticeDate());
			pstmt.setString(3, notice.getNoticeContents());
			pstmt.setInt(4, notice.getNoticeNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//검색 후 공지 리스트 갯수 O
	public int getSearchListCount(Connection conn, String titleName) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="select count(notice_no) from notice where notice_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+titleName+"%");
			
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
	//검색 후 노티스 리스트 O
	public ArrayList<Notice> searchTitle(Connection conn, String titleName, int startlist, int endlist) {
		ArrayList<Notice> nlist = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * " + 
				"from(select rownum as rnum, notice_no, notice_title, notice_date, notice_read_count, notice_writer, " + 
				"case when notice_no in (select notice_no from noticefiles) then 'Y' else 'N' end as fileYorN " + 
				"from(select distinct notice_no, notice_title, notice_date, notice_read_count, notice_writer from notice " + 
				"left outer join noticefiles using(notice_no) where notice_title like ? order by notice_no desc)) " +
				"where rnum between ? and ?";

		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, "%"+titleName+"%");
			pstmt.setInt(2, startlist);
			pstmt.setInt(3, endlist);
			rset=pstmt.executeQuery();

			while(rset.next()) {
				
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt(2));
				notice.setNoticeTitle(rset.getString(3));				
				notice.setNoticeDate(rset.getDate(4));
				notice.setNoticeReadCount(rset.getInt(5));
				notice.setNoticeWriter(rset.getString(6));
				notice.setFileYorN(rset.getString(7));
				
				nlist.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return nlist;
	}
	//첨부파일 전체 조회
	public ArrayList<NoticeFiles> selectFile(Connection conn, int nNo) {
		ArrayList<NoticeFiles> nFiles = new ArrayList<NoticeFiles>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select *"//notice_original_file_name, notice_rename_file_name, notice_file_size "
				+" from noticefiles" 
				+" where notice_no = ? "
				+" order by notice_rename_file_name asc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeFiles notilefiles = new NoticeFiles();
				notilefiles.setNoticeNo(rset.getInt(1));
				notilefiles.setNoticeOriginalFileName(rset.getString(2));
				notilefiles.setNoticeRnameFileName(rset.getString(3));
				notilefiles.setNoticeFileSize(rset.getString(4));
				nFiles.add(notilefiles);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return nFiles;
	}
	//노티스 삭제O
	public int deleteNotice(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query ="delete from notice where notice_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//인서트용 마지막 노티스넘 조회 O
	public int selectLastNoticeNo(Connection conn) {
		int result = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select max(notice_no) from notice";
		
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
	//노티스 파일 인서트 O
	public int insertNoticeFile(Connection conn, int nNo, NoticeFiles noticeFile) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "insert into noticefiles values(?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nNo);
			pstmt.setString(2, noticeFile.getNoticeOriginalFileName());
			pstmt.setString(3, noticeFile.getNoticeRnameFileName());
			pstmt.setString(4, noticeFile.getNoticeFileSize());

			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		return result;
	}
	public int deleteFile(Connection conn, String renameFileName) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "delete from noticefiles where notice_rename_file_name = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, renameFileName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}





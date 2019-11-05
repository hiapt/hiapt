package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.vo.BoardFiles;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticeFiles;
import vote.model.vo.Vote;
public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	//공지사항 관리자용 전체조회 목록리스트
	public ArrayList<Notice> selectList(int startlist, int endlist) {
		Connection conn = getConnection();
		ArrayList<Notice> nlist = ndao.selectList(conn, startlist, endlist);
		close(conn);
		return nlist;
	}
	//제목 조회 시 목록 갯수 
	public int getSearchListCount(String titleName) {
		Connection conn = getConnection();
		int listCount = ndao.getSearchListCount(conn,titleName);
		close(conn);
		return listCount;
		
	}
	//제목 조회
	public ArrayList<Notice> searchTitle(String titleName, int startlist, int endlist) {
		Connection conn = getConnection();
		ArrayList<Notice> nlist = ndao.searchTitle(conn, titleName, startlist, endlist);
		close(conn);
		return nlist;
	}
	//전체 리스트 갯수
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = ndao.getListCount(conn);
		close(conn);
		return listCount;
	}
	//조회수 
	public void updateReadCount(int nNo) {
		Connection conn = getConnection();
		int result =ndao.updateReadCount(conn, nNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}

	public Notice selectOne(int nNo) {
		Connection conn = getConnection();
		Notice notice= ndao.selectOne(conn, nNo);
		close(conn);
		return notice;
	}
	public int insertNotice(Notice notice) {
		Connection conn = getConnection();
		int result =ndao.insertNotice(conn, notice);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.updateNotice(conn, notice);
		if(result> 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public ArrayList<NoticeFiles> selectFile(int nNo) {
		Connection conn = getConnection();
		ArrayList<NoticeFiles> nFiles =ndao.selectFile(conn, nNo);
		close(conn);
		return nFiles;
	}
	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		int result =ndao.deleteNotice(conn, noticeNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	public int selectLastNoticeNo() {
		Connection conn = getConnection();
		int result =ndao.selectLastNoticeNo(conn);
		close(conn);
		return result;
	}
	public void insertNoticeFile(int nNo, NoticeFiles noticeFile) {
		Connection conn = getConnection();
		int result =ndao.insertNoticeFile(conn, nNo, noticeFile);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}
	public void deleteFile(String renameFileName) {
		Connection conn = getConnection();
		int result =ndao.deleteFile(conn, renameFileName);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		
	}

}

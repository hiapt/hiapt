package draft.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import draft.model.dao.DraftDao;
import draft.model.vo.Draft;

public class DraftService {
	private DraftDao ad = new DraftDao();
	public DraftService() {}
	

	
	public ArrayList<Draft> selectAll(int startRow, int endRow, String empno) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectAll(conn, startRow, endRow, empno);
		close(conn);
		return list;
	}

	
	public int insert(Draft draft) {
		Connection conn = getConnection();
		int result = ad.insert(conn, draft);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Draft selectOne(int docno) {
		Connection conn = getConnection();
		Draft draft = ad.selectOne(conn, docno);
		close(conn);
		
		
		return draft;
	}


	public int tempSave(Draft draft) {
		Connection conn = getConnection();
		int result = ad.tempSave(conn, draft);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Draft> draftTitleSearch(String keyword, String empno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.draftTitleSearch(conn, keyword, empno, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> draftWriterSearch(String keyword, String empno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.draftWriterSearch(conn, keyword, empno, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> draftDateSearch(Date from, Date to, String empno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.draftDateSearch(conn, from, to, empno, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> draftFormtypeSearch(String keyword, String empno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.draftFormtypeSearch(conn, keyword, empno, startRow, endRow);
		close(conn);
		return list;
	}
	
	public int getListCount(String empno) {
		Connection conn = getConnection();
		int listCount = ad.getListCount(conn, empno);
		close(conn);
		return listCount;
	}


	public int getListCountProgress(String empno, String progress) {
		Connection conn = getConnection();
		int listCount = ad.getListCountProgress(conn, empno, progress);
		close(conn);
		return listCount;
	}
	
	public int getSearchCountT(String keyword, String empno) {
		Connection conn = getConnection();
		int listCount = ad.getSearchCountT(conn, keyword, empno);
		close(conn);
		return listCount;
	}



	public int getSearchCountW(String keyword, String empno) {
		Connection conn = getConnection();
		int listCount = ad.getSearchCountW(conn, keyword, empno);
		close(conn);
		return listCount;
	}



	public int getSearchCountD(Date beginDate, Date toDate, String empno) {
		Connection conn = getConnection();
		int listCount = ad.getSearchCountD(conn, beginDate, toDate, empno);
		close(conn);
		return listCount;
	}
	
	public int getSearchCountF(String keyword, String empno) {
		Connection conn = getConnection();
		int listCount = ad.getSearchCountF(conn, keyword, empno);
		close(conn);
		return listCount;
	}


	public ArrayList<Draft> selectProgress(int startRow, int endRow, String empno, String progress) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectProgress(conn, startRow, endRow, empno, progress);
		close(conn);
		return list;
	}
	
	public ArrayList<Draft> selectAllAdmin (int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectAllAdmin(conn, startRow, endRow);
		close(conn);
		return list;
	}



	public int getListCountAdmin() {
		Connection conn = getConnection();
		int listCount = ad.getListCountAdmin(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Draft> selectAdminProgress (int startRow, int endRow, String progress) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectAdminProgress(conn, startRow, endRow, progress);
		close(conn);
		return list;
	}



	public int getListCountAdminProgress (String progress) {
		Connection conn = getConnection();
		int listCount = ad.getListCountAdminProgress(conn, progress);
		close(conn);
		return listCount;
	}
}

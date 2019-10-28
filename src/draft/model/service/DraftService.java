package draft.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import draft.model.dao.DraftDao;
import draft.model.vo.Draft;

public class DraftService {
	private DraftDao ddao = new DraftDao();
	public DraftService() {}
	

	
	public ArrayList<Draft> selectAll(int startRow, int endRow, String empno) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.selectAll(conn, startRow, endRow, empno);
		close(conn);
		return list; 
	}

	
	public int insert(Draft draft) {
		Connection conn = getConnection();
		int result = ddao.insert(conn, draft);
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
		Draft draft = ddao.selectOne(conn, docno);
		close(conn);
		
		return draft;
	}

	public int tempSave(Draft draft) {
		Connection conn = getConnection();
		int result = ddao.tempSave(conn, draft);
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
		ArrayList<Draft> list = ddao.draftTitleSearch(conn, keyword, empno, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> draftWriterSearch(String keyword, String empno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftWriterSearch(conn, keyword, empno, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> draftDateSearch(Date from, Date to, String empno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftDateSearch(conn, from, to, empno, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> draftFormtypeSearch(String keyword, String empno, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftFormtypeSearch(conn, keyword, empno, startRow, endRow);
		close(conn);
		return list;
	}
	
	public int getListCount(String empno) {
		Connection conn = getConnection();
		int listCount = ddao.getListCount(conn, empno);
		close(conn);
		return listCount;
	}


	public int getListCountdocstatus(String empno, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getListCountdocstatus(conn, empno, docstatus);
		close(conn);
		return listCount;
	}
	
	public int getSearchCountT(String keyword, String empno) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountT(conn, keyword, empno);
		close(conn);
		return listCount;
	}



	public int getSearchCountW(String keyword, String empno) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountW(conn, keyword, empno);
		close(conn);
		return listCount;
	}



	public int getSearchCountD(Date beginDate, Date toDate, String empno) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountD(conn, beginDate, toDate, empno);
		close(conn);
		return listCount;
	}
	
	public int getSearchCountF(String keyword, String empno) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountF(conn, keyword, empno);
		close(conn);
		return listCount;
	}


	public ArrayList<Draft> selectdocstatus(int startRow, int endRow, String empno, String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.selectdocstatus(conn, startRow, endRow, empno, docstatus);
		close(conn);
		return list;
	}
	
	public ArrayList<Draft> selectAllAdmin (int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.selectAllAdmin(conn, startRow, endRow);
		close(conn);
		return list;
	}



	public int getListCountAdmin() {
		Connection conn = getConnection();
		int listCount = ddao.getListCountAdmin(conn);
		close(conn);
		return listCount;
	}
	
	public ArrayList<Draft> selectAdmindocstatus (int startRow, int endRow, String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.selectAdmindocstatus(conn, startRow, endRow, docstatus);
		close(conn);
		return list;
	}



	public int getListCountAdmindocstatus (String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getListCountAdmindocstatus(conn, docstatus);
		close(conn);
		return listCount;
	}
	
	public int getNewListCountAdmin() {
		Connection conn = getConnection();
		int listCount = ddao.getNewListCountAdmin(conn);
		close(conn);
		return listCount;
	}



	public int getSearchCountTAdmin(String keyword) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountTAdmin(conn, keyword);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftTitleSearchAdmin(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftTitleSearchAdmin(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}



	public int getSearchCountWAdmin(String keyword) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountWAdmin(conn, keyword);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftWriterSearchAdmin(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftWriterSearchAdmin(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}



	public int getSearchCountDAdmin(Date beginDate, Date toDate) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountDAdmin(conn, beginDate, toDate);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftDateSearchAdmin(Date beginDate, Date toDate, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftDateSearchAdmin(conn, beginDate, toDate, startRow, endRow);
		close(conn);
		return list;
	}

	
	public int getSearchCountFAdmin(String keyword) {
		Connection conn = getConnection();
		int listCount = ddao.getSearchCountFAdmin(conn, keyword);
		close(conn);
		return listCount;
	}

	public ArrayList<Draft> draftFormtypeSearchAdmin(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftFormtypeSearchAdmin(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}



	public int getdocstatusSearchCountTAd(String keyword, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountTAd(conn, keyword, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusTitleSearchAd(String keyword, int startRow, int endRow, String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusTitleSearchAd(conn, keyword, startRow, endRow, docstatus);
		close(conn);
		return list;
	}



	public int getdocstatusSearchCountWAd(String keyword, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountWAd(conn, keyword, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusWriterSearchAd(String keyword, int startRow, int endRow,
			String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusWriterSearchAd(conn, keyword, startRow, endRow, docstatus);
		close(conn);
		return list;
	}



	public int getdocstatusSearchCountDAd(Date from, Date to, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountDAd(conn, from, to, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusDateSearchAd(Date from, Date to, int startRow, int endRow,
			String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusDateSearchAd(conn, from, to, startRow, endRow, docstatus);
		close(conn);
		return list;
	}



	public int getdocstatusSearchCountFAd(String keyword, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountFAd(conn, keyword, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusFormtypeSearchAd(String keyword, int startRow, int endRow,
			String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusFormtypeSearchAd(conn, keyword, startRow, endRow, docstatus);
		close(conn);
		return list;
	}

	


	public int getdocstatusSearchCountT(String keyword, String empno, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountT(conn, keyword, empno, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusTitleSearch(String keyword, String empno, int startRow, int endRow, String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusTitleSearch(conn, keyword, empno, startRow, endRow, docstatus);
		close(conn);
		return list;
	}



	public int getdocstatusSearchCountW(String keyword, String empno, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountW(conn, keyword, empno, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusWriterSearch(String keyword, String empno, int startRow, int endRow,
			String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusWriterSearch(conn, keyword, empno, startRow, endRow, docstatus);
		close(conn);
		return list;
	}



	public int getdocstatusSearchCountD(Date from, Date to, String empno, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountD(conn, from, to, empno, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusDateSearch(Date from, Date to, String empno, int startRow, int endRow,
			String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusDateSearch(conn, from, to, empno, startRow, endRow, docstatus);
		close(conn);
		return list;
	}



	public int getdocstatusSearchCountF(String keyword, String empno, String docstatus) {
		Connection conn = getConnection();
		int listCount = ddao.getdocstatusSearchCountF(conn, keyword, empno, docstatus);
		close(conn);
		return listCount;
	}



	public ArrayList<Draft> draftdocstatusFormtypeSearch(String keyword, String empno, int startRow, int endRow,
			String docstatus) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.draftdocstatusFormtypeSearch(conn, keyword, empno, startRow, endRow, docstatus);
		close(conn);
		return list;
	}
	public int signDraft(Draft draft, String docstatus) {
		Connection conn = getConnection();
		int result = ddao.signDraft(conn, draft, docstatus);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Draft> selectLogAd (int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.selectLogAd(conn, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> selectLogEmp (int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.selectLogEmp(conn, startRow, endRow);
		close(conn);
		return list;
	}
	public ArrayList<Draft> selectLogMy (int startRow, int endRow, String empno) {
		Connection conn = getConnection();
		ArrayList<Draft> list = ddao.selectLogMy(conn, startRow, endRow, empno);
		close(conn);
		return list;
	}



	public int getMyLogCount(String empno) {
		Connection conn = getConnection();
		int listCount = ddao.getMyLogCount(conn, empno);
		close(conn);
		return listCount;
	}

}

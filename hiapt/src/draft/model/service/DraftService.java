package draft.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import draft.model.dao.DraftDao;
import draft.model.vo.Draft;

public class DraftService {
	private DraftDao ad = new DraftDao();
	public DraftService() {}
	

	
	public ArrayList<Draft> selectAll() {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectAll(conn);
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
	public int update(Draft draft) {
		Connection conn = getConnection();
		int result = ad.update(conn, draft);
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
	public ArrayList<Draft> selectProgressStandby() {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectProgressStandby(conn);
		close(conn);
		return list;
	}
	public ArrayList<Draft> selectApprovedDoc() {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectApprovedDoc(conn);
		close(conn);
		return list;
	}
	public ArrayList<Draft> selectReturnDoc() {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectReturnDoc(conn);
		close(conn);
		return list;
	}

	public ArrayList<Draft> selectDeferDoc() {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectDeferDoc(conn);
		close(conn);
		return list;
	}
	public ArrayList<Draft> selectTempDoc() {
		Connection conn = getConnection();
		ArrayList<Draft> list = ad.selectTempDoc(conn); 
		close(conn);
		return list;
	}
}

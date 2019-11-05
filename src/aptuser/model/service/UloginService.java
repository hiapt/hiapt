package aptuser.model.service;

import aptuser.model.dao.UloginDao;
import aptuser.model.vo.Aptuser;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

public class UloginService {

	private UloginDao udao = new UloginDao();
	
	public UloginService() {}
	
	public Aptuser loginCheck(String userId, String userPwd) {
		Connection conn = getConnection();
		Aptuser aptuser = udao.loginCheck(conn, userId, userPwd);
		close(conn);
		return aptuser;
	}
	
	// 추가 세대주 로그인 부분
	public int checkId(String id) {
		Connection conn = getConnection();
		int result = udao.checkId(conn, id);
		close(conn);
		return result;
	}

	public int updatePassword(String id, String password) {
		Connection conn = getConnection();
		int result = udao.updatePassword(conn, id, password);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;		
	}
	// 추가 로그인 부분 끝 

	public int insertAptuser(Aptuser aptuser) {
		Connection conn = getConnection();
		int result = udao.insertAptuser(conn, aptuser);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = udao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Aptuser> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Aptuser> list = udao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}

	public Aptuser selectAptuser(String userId) {
		Connection conn = getConnection();
		Aptuser aptuser = udao.selectOne(conn, userId);
		close(conn);
		return aptuser;
	}
	
	public int updateAptuser(Aptuser aptuser) {
		Connection conn = getConnection();
		int result = udao.updateAptuser(conn, aptuser);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int deleteAptuser(String userId) {
		Connection conn = getConnection();
		int result = udao.deleteAptuser(conn, userId);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int getListCountDongho(String dong, String ho) {
		Connection conn = getConnection();
		int listCount = udao.getListCountDongho(conn, dong, ho);
		close(conn);
		return listCount;
	}

	public ArrayList<Aptuser> selectDonghoSearch(String dong, String ho, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Aptuser> list = udao.selectDonghoSearch(conn, dong, ho, startRow, endRow);
		close(conn);
		return list;
	}

	public int getListCountName(String keyword) {
		Connection conn = getConnection();
		int listCount = udao.getListCountName(conn, keyword);
		close(conn);
		return listCount;
	}

	public ArrayList<Aptuser> selectNameSearch(String keyword, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Aptuser> list = udao.selectNameSearch(conn, keyword, startRow, endRow);
		close(conn);
		return list;
	}

	public int getListCountDate(Date beginDate, Date toDate) {
		Connection conn = getConnection();
		int listCount = udao.getListCountDate(conn, beginDate, toDate);
		close(conn);
		return listCount;
	}

	public ArrayList<Aptuser> selectDateSearch(Date from, Date to, int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Aptuser> list = udao.selectDateSearch(conn, from, to, startRow, endRow);
		close(conn);
		return list;
	}

}

package aptuser.model.service;

import aptuser.model.dao.UloginDao;
import aptuser.model.vo.Aptuser;
import employee.model.vo.Employee;

import static common.JDBCTemplate.*;

import java.sql.Connection;
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

}

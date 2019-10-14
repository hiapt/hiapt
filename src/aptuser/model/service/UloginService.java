package aptuser.model.service;

import aptuser.model.dao.UloginDao;
import aptuser.model.vo.Aptuser;

import static common.JDBCTemplate.*;

import java.sql.Connection;

public class UloginService {

	private UloginDao udao = new UloginDao();
	
	public Aptuser loginCheck(String userId, String userPwd) {
		Connection conn = getConnection();
		Aptuser aptuser = udao.loginCheck(conn, userId, userPwd);
		close(conn);
		return aptuser;
	}

}

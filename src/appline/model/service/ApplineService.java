package appline.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;

import appline.model.dao.ApplineDao;
import appline.model.vo.Appline;

public class ApplineService {
	private ApplineDao adao = new ApplineDao();
	
	public ApplineService () {}
	
	public int insert(Appline app, String empno) {
		Connection conn = getConnection();
		int result = adao.insert(conn, app, empno);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

}

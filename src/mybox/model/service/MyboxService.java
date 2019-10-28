package mybox.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import mybox.model.dao.MyboxDao;
import mybox.model.vo.Mybox;

public class MyboxService {
	private MyboxDao mdao = new MyboxDao();
	
	public MyboxService () {}
	
	public ArrayList<Mybox> selectAll (String empno) {
		Connection conn = getConnection();
		ArrayList<Mybox> list = mdao.selectAll(conn, empno);
		close(conn);
		return list;
	}

	public ArrayList<Mybox> selectList(int startRow, int endRow, String empno, String myboxcode) {
		Connection conn = getConnection();
		ArrayList<Mybox> list = mdao.selectList(conn, startRow, endRow, empno, myboxcode);
		close(conn);
		return list;
	}

	public int getMyboxCount(String empno, String myboxcode) {
		Connection conn = getConnection();
		int listCount = mdao.getMyboxCount(conn, empno, myboxcode);
		close(conn);
		return listCount;
	}
	public int addmybox(Mybox my, String empno) {
		Connection conn = getConnection();
		int result = mdao.addmybox(conn, my, empno);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}

package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	//공지사항 관리자용 전체조회 목록리스트
	public ArrayList<Notice> selectAll() {
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectAll(conn);
		close(conn);
		return list;
	}

}

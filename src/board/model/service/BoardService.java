package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;

public class BoardService {
	private BoardDao bdao = new BoardDao();
	
	//전체목록갯수 
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	// 전체목록조회
	public ArrayList<Board> selectList(int startlist, int endlist) {
		Connection conn = getConnection();
		ArrayList<Board> blist = bdao.selectList(conn, startlist, endlist);
		close(conn);
		return blist;
	}
}

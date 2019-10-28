package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardFiles;
import vote.model.vo.Vote;

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
	//조회수증가
	public void updateReadCount(int bNo) {
		Connection conn = getConnection();
		int result =bdao.updateReadCount(conn, bNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}
	//상세조회
	public Board selectView(int bNo) {
		Connection conn = getConnection();
		Board board= bdao.selectView(conn, bNo);
		close(conn);
		return board;
	}
	//게시판 등록
	public int insertBoard(Board board) {
		Connection conn = getConnection();
		int result =bdao.insertBoard(conn, board);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
	//파일 등록
	public void insertBoardFile(int bno, BoardFiles bFiles) {
		Connection conn = getConnection();
		int result =bdao.insertBoardFile(conn, bno, bFiles);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}
	//게시판 마지막번호 조회
	public int selectLastBno() {
		Connection conn = getConnection();
		int result = bdao.selectLastBno(conn);
		close(conn);
		return result;
	}
	// 게시판 파일조회
	public ArrayList<BoardFiles> selectFile(int bNo) {
		Connection conn = getConnection();
		ArrayList<BoardFiles> boardFiles = bdao.selectFile(conn, bNo);
		close(conn);
		return boardFiles;
	}
	//삭제
	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		int result =bdao.deleteBoard(conn, boardNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updateBoard(Board board) {
		Connection conn = getConnection();
		int result =bdao.updateBoard(conn, board);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
}

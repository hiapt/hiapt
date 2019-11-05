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
import board.model.vo.BoardReply;
import complain.model.vo.Complain;
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
	//수정
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
	//파일삭제
	public void deleteFile(String renameFileName) {
		Connection conn = getConnection();
		int result =bdao.deleteFile(conn, renameFileName);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}
	//제목검색목록갯수
	public int getSearchTitleListCount(String searchText) {
		Connection conn = getConnection();
		int listCount = bdao.getSearchTitleListCount(conn, searchText);
		close(conn);
		return listCount;
	}
	//제목으로검색
	public ArrayList<Board> searchTitle(int startlist, int endlist, String searchText) {
		Connection conn = getConnection();
		ArrayList<Board> blist = bdao.searchTitle(conn, startlist, endlist, searchText);
		close(conn);
		return blist;
	}
	//작성자검색목록갯수
	public int getSearchUserNameListCount(String searchText) {
		Connection conn = getConnection();
		int listCount = bdao.getSearchUserNameListCount(conn, searchText);
		close(conn);
		return listCount;
	}
	//작성자로검색
	public ArrayList<Board> searchUserName(int startlist, int endlist, String searchText) {
		Connection conn = getConnection();
		ArrayList<Board> blist = bdao.searchUserName(conn, startlist, endlist, searchText);
		close(conn);
		return blist;
	}
	//댓글 조회
	public ArrayList<BoardReply> selectReply(int bNo) {
		Connection conn = getConnection();
		ArrayList<BoardReply> brlist = bdao.selectReply(conn, bNo);
		close(conn);
		return brlist;
	}
	//댓글 갯수조회
	public int replyCount(int bNo) {
		Connection conn = getConnection();
		int replyCount = bdao.replyCount(conn,bNo);
		close(conn);
		return replyCount;
	}
	//0번계층 댓글작성.
	public int insertBoardReply(int bNo, String brContent,String userid) {
		Connection conn = getConnection();
		int result =bdao.insertBoardReply(conn, bNo, brContent,userid);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
}

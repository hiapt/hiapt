package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Board;
import board.model.vo.BoardFiles;
import board.model.vo.BoardReply;
import complain.model.vo.Complain;
import vote.model.vo.Vote;


public class BoardDao {
	
	//페이지 처리용 전체목록 갯수조회 
		public int getListCount(Connection conn) {
			int listCount = 0;
			Statement stmt = null;
			ResultSet rset = null;
			
			String query ="select count(boardno) from board";
			
			try {
				stmt = conn.createStatement();
				
				rset = stmt.executeQuery(query);
				
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(stmt);
			}
			
			return listCount;
		}
		
		//전체목록조회
		public ArrayList<Board> selectList(Connection conn, int startlist, int endlist) {
			ArrayList<Board> blist = new ArrayList<Board>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query ="SELECT * " + 
					"FROM (SELECT ROWNUM AS RNUM, BOARDNO, BOARDTITLE, USERID, USERNAME, BOARDDATE, BOARDREADCOUNT " + 
					"	   FROM (SELECT * " + 
					"			 FROM BOARD" + 
					"            ORDER BY BOARDNO DESC)" + 
					"      JOIN APTUSER USING(USERID))" + 
					"WHERE RNUM BETWEEN ? AND ?";
			
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setInt(1, startlist);
				pstmt.setInt(2, endlist);
				rset=pstmt.executeQuery();

				while(rset.next()) {
					Board board = new Board();
					board.setBoardNo(rset.getInt(2));
					board.setBoardTitle(rset.getString(3));
					board.setUserId(rset.getString(4));
					board.setBoardWriter(rset.getString(5));
					board.setBoardDate(rset.getDate(6));
					board.setBoardReadCount(rset.getInt(7));
					
					blist.add(board);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return blist;
		}
		//조회수증가
		public int updateReadCount(Connection conn, int bNo) {
			int result = 0;
			PreparedStatement pstmt =null;
			
			String query = "update board set boardreadcount = boardreadcount+1"
					+ " where boardno = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bNo);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		//상세조회
		public Board selectView(Connection conn, int bNo) {
			Board board = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select boardno, boardtitle, username, boarddate, boardcontents, boardreadcount, userid " + 
					"from board " + 
					"JOIN APTUSER USING(USERID) " + 
					"where boardno = ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					board = new Board();
					
					board.setBoardNo(rset.getInt(1));
					board.setBoardTitle(rset.getString(2));
					board.setBoardWriter(rset.getString(3));
					board.setBoardDate(rset.getDate(4));
					board.setBoardContents(rset.getString(5));
					board.setBoardReadCount(rset.getInt(6));
					board.setUserId(rset.getString(7));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return board;
		}
		//자유게시판 목록 인서트
		public int insertBoard(Connection conn, Board board) {
			int result = 0;
			PreparedStatement pstmt =null;
			
			String query = "insert into board values(BOARD_SEQ.nextval, ?, default, ?, default, ?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, board.getBoardTitle());
				pstmt.setString(2, board.getBoardContents());
				pstmt.setString(3, board.getUserId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

		public int insertBoardFile(Connection conn, int bno, BoardFiles bFiles) {
			int result = 0;
			PreparedStatement pstmt =null;
			
			String query = "insert into boardfiles values(?, ?, ?, ?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bno);
				pstmt.setString(2, bFiles.getBoardOriginalFileName());
				pstmt.setString(3, bFiles.getBoardRnameFileName());
				pstmt.setString(4, bFiles.getBoardFileSize());

				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

		public int selectLastBno(Connection conn) {
			int result = 0;
			Statement stmt = null;
			ResultSet rset = null;
			
			String query = "select max(boardno) from board";
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				if(rset.next())
					result = rset.getInt(1);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(stmt);
			}
			return result;
		}
		//파일 조회
		public ArrayList<BoardFiles> selectFile(Connection conn, int bNo) {
			ArrayList<BoardFiles> boardFiles = new ArrayList<BoardFiles>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select board_original_file_name, board_rename_file_name, board_file_size "
					+" from boardfiles" 
					+" where boardno = ? "
					+" order by board_rename_file_name asc";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bNo);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					BoardFiles bfile = new BoardFiles();
					
					bfile.setBoardOriginalFileName(rset.getString(1));
					bfile.setBoardRnameFileName(rset.getString(2));
					bfile.setBoardFileSize(rset.getString(3));
					boardFiles.add(bfile);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return boardFiles;
		}
		//삭제
		public int deleteBoard(Connection conn, int boardNo) {
			int result = 0;
			PreparedStatement pstmt =null;
			
			String query = "delete from board where boardno=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, boardNo);

				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		//수정
		public int updateBoard(Connection conn, Board board) {
			int result = 0;
			PreparedStatement pstmt =null;
			
			String query = "update board set boardtitle=?, boardContents=?"
					+ " where boardno=?";

			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, board.getBoardTitle());
				pstmt.setString(2, board.getBoardContents());
				pstmt.setInt(3, board.getBoardNo());

				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}

		public int deleteFile(Connection conn, String renameFileName) {
			int result = 0;
			PreparedStatement pstmt =null;
			
			String query = "delete from boardfiles where board_rename_file_name= ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, renameFileName);

				result=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		//제목목록갯수
		public int getSearchTitleListCount(Connection conn, String searchText) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query ="select count(boardno) from board where boardtitle like ?";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+searchText+"%");
				
				rset=pstmt.executeQuery();
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return listCount;
		}
		//제목검색
		public ArrayList<Board> searchTitle(Connection conn, int startlist, int endlist, String searchText) {
			ArrayList<Board> blist = new ArrayList<Board>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query ="SELECT * " + 
						  "FROM (SELECT ROWNUM AS RNUM, boardNO, boardTITLE, USERNAME, " + 
						  "             USERID,boardDate, boardreadcount " + 
						  "      FROM (SELECT * " + 
						  "			   FROM board " + 
						  "			   WHERE boardTITLE LIKE ?" + 
						  "			   ORDER BY boardNO DESC) " + 
						  "      JOIN APTUSER USING (USERID)) " + 
						  " WHERE RNUM BETWEEN ? AND ?";
			
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setString(1, "%"+searchText+"%");
				pstmt.setInt(2, startlist);
				pstmt.setInt(3, endlist);
				rset=pstmt.executeQuery();

				while(rset.next()) {
					Board board = new Board();
					
					board.setBoardNo(rset.getInt(2));
					board.setBoardTitle(rset.getString(3));
					board.setBoardWriter(rset.getString(4));
					board.setUserId(rset.getString(5));
					board.setBoardDate(rset.getDate(6));
					board.setBoardReadCount(rset.getInt(7));
					
					blist.add(board);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return blist;
		}
		//작성자 목록갯수
		public int getSearchUserNameListCount(Connection conn, String searchText) {
			int listCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query ="select count(boardno) " + 
						  "from board " + 
						  "where userid in (select userid " + 
						  "                 from aptuser " + 
						  "                 WHERE username like ?)";
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+searchText+"%");
				
				rset=pstmt.executeQuery();
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return listCount;
		}//작성자검색
		public ArrayList<Board> searchUserName(Connection conn, int startlist, int endlist, String searchText) {
			ArrayList<Board> blist = new ArrayList<Board>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query ="SELECT * " + 
						  "FROM (SELECT ROWNUM AS RNUM, boardNO, boardTITLE, USERNAME, " + 
						  "		 USERID,boardDate, boardreadcount " + 
						  "      FROM (select * " + 
						  "            from board " + 
						  "      	   JOIN APTUSER USING (USERID) " +
						  "            where userid in (select userid " + 
						  "                             from aptuser " + 
						  "                             WHERE username like ?) " +
						  "			   ORDER BY boardno DESC)) " + 						  
						  " WHERE RNUM BETWEEN ? AND ?";
			
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setString(1, "%"+searchText+"%");
				pstmt.setInt(2, startlist);
				pstmt.setInt(3, endlist);
				rset=pstmt.executeQuery();

				while(rset.next()) {
					Board board = new Board();
					
					board.setBoardNo(rset.getInt(2));
					board.setBoardTitle(rset.getString(3));
					board.setBoardWriter(rset.getString(4));
					board.setUserId(rset.getString(5));
					board.setBoardDate(rset.getDate(6));
					board.setBoardReadCount(rset.getInt(7));
					
					blist.add(board);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return blist;
		}
		//댓글가져오기
		public ArrayList<BoardReply> selectReply(Connection conn, int bNo) {
			ArrayList<BoardReply> brlist = new ArrayList<BoardReply>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query ="select BOARDREPLY_ORIGINAL_NO, BOARDREPLY_GROUP_NO,BOARDREPLY_GROUP_ORDER, " + 
					"BOARDREPLY_GROUP_LAYER,to_char(BOARDREPLY_DATE,'yy/mm/dd hh24:mi'),BOARDREPLY_CONTENTS,USERID, username " + 
					"from boardreply " + 
					"join aptuser using(userid) " + 
					"where board_no=? " + 
					"order by BOARDREPLY_GROUP_NO asc,BOARDREPLY_GROUP_ORDER asc";
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setInt(1, bNo);
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					BoardReply bReply = new BoardReply();
					
					bReply.setBoardReplyOriginalNo(rset.getInt(1));
					bReply.setBoardReplyGroupNo(rset.getInt(2));
					bReply.setBoardReplyGroupOrder(rset.getInt(3));
					bReply.setBoardReplyGroupLayer(rset.getInt(4));
					bReply.setBoardReplyDate(rset.getString(5));
					bReply.setBoardReplyContents(rset.getString(6));
					bReply.setUserId(rset.getString(7));
					bReply.setUserName(rset.getString(8));
					
					brlist.add(bReply);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}

			return brlist;
		}

		public int replyCount(Connection conn, int bNo) {
			int replyCount = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select count(board_no) from boardReply where board_no=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1, bNo);
				rset=pstmt.executeQuery();
				
				if(rset.next()){
					replyCount=rset.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return replyCount;
		}
		//0계층 댓글 등록
		public int insertBoardReply(Connection conn, int bNo, String brContent, String userid) {
			int result = 0;
			PreparedStatement pstmt =null;
			
			String query = "insert into BOARDREPLY values(?, BOARDREPLY_SEQ.nextval, BOARDREPLY_SEQ.currval,"
					+ " 0, 0, sysdate, ?, ?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bNo);
				pstmt.setString(2, brContent);
				pstmt.setString(3, userid);	
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
}


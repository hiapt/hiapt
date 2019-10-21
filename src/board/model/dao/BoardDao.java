package board.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Board;
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
}

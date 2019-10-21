package vote.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vote.model.vo.Vote;
import vote.model.vo.VoteResult;
public class VoteDao {
	
	//페이지 처리용 전체목록 갯수조회 
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query ="select count(vote_no) from uservote";
		
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
	public ArrayList<Vote> selectList(Connection conn, int startlist, int endlist) {
		ArrayList<Vote> vlist = new ArrayList<Vote>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="SELECT * " + 
				"FROM (SELECT ROWNUM AS RNUM, VOTE_NO, VOTE_TITLE, VOTE_WRITER, VOTE_DATE, VOTE_FINAL_DATE, VOTE_READ_COUNT\r\n" + 
				"          FROM (SELECT * " + 
				"                    FROM USERVOTE " + 
				"                    ORDER BY VOTE_NO DESC)) " + 
				"WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, startlist);
			pstmt.setInt(2, endlist);
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Vote vote = new Vote();
				vote.setVoteNo(rset.getInt(2));
				vote.setVoteTitle(rset.getString(3));
				vote.setVoteWrite(rset.getString(4));
				vote.setVoteDate(rset.getDate(5));
				vote.setVoteFinalDate(rset.getDate(6));
				vote.setVoteReadCount(rset.getInt(7));
				
				vlist.add(vote);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return vlist;
	}
	//주민투표 인서트(트리거로 VOTERESULT도 인서트됨)
	public int insertVote(Connection conn, Vote vote) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = "insert into uservote values("
				+ "VOTE_SEQ.NEXTVAL, ?, ?, sysdate, ?, default, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, vote.getVoteTitle());
			pstmt.setString(2, vote.getVoteWrite());
			pstmt.setDate(3, vote.getVoteFinalDate());
			pstmt.setString(4, vote.getVoteSecret());
			pstmt.setString(5, vote.getVoteContents());
			pstmt.setString(6, vote.getVoteOne());
			pstmt.setString(7, vote.getVoteTwo());
			pstmt.setString(8, vote.getVoteThree());
			pstmt.setString(9, vote.getVoteFour());
			pstmt.setString(10, vote.getVoteFive());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
//조회수증가
	public int updateReadCount(Connection conn, int vNo) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "update uservote set vote_read_count = vote_read_count +1"
				+ " where vote_no = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//주민투표 상세조회
	public Vote selectView(Connection conn, int vNo) {
		Vote vote = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from uservote where vote_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, vNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				vote = new Vote();
				
				vote.setVoteNo(rset.getInt(1));
				vote.setVoteTitle(rset.getString(2));
				vote.setVoteWrite(rset.getString(3));
				vote.setVoteDate(rset.getDate(4));
				vote.setVoteFinalDate(rset.getDate(5));
				vote.setVoteReadCount(rset.getInt(6));
				vote.setVoteSecret(rset.getString(7));
				vote.setVoteContents(rset.getString(8));
				vote.setVoteOne(rset.getString(9));
				vote.setVoteTwo(rset.getString(10));
				vote.setVoteThree(rset.getString(11));
				vote.setVoteFour(rset.getString(12));
				vote.setVoteFive(rset.getString(13));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return vote;
	}
//투표결과+1작업
	public int updateVoteResult(Connection conn, int voteNo, int voteResultNo) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query=null;
		if(voteResultNo==1) 
			query = "update voteresult set voteone_result = voteone_result+1 where vote_no=?";
		else if(voteResultNo==2)
			query = "update voteresult set votetwo_result = votetwo_result+1 where vote_no=?";
		else if(voteResultNo==3)
			query = "update voteresult set votethree_result = votethree_result+1 where vote_no=?";
		else if(voteResultNo==4)
			query = "update voteresult set votefour_result = votefour_result+1 where vote_no=?";
		else if(voteResultNo==5)
			query = "update voteresult set votefive_result =votefive_result+1 where vote_no=?";
		
		try {

			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, voteNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
//투표결과뽑아오기 에이작스
	public VoteResult selectVoteResult(Connection conn, int voteNo) {
		VoteResult voteResult = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from voteresult where vote_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, voteNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				voteResult = new VoteResult();
				
				voteResult.setVoteNo(rset.getInt(1));
				voteResult.setVoteOneResult(rset.getInt(2));
				voteResult.setVoteTwoResult(rset.getInt(3));
				voteResult.setVoteThreeResult(rset.getInt(4));
				voteResult.setVoteFourResult(rset.getInt(5));
				voteResult.setVoteFiveResult(rset.getInt(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return voteResult;

	}

	public ArrayList<Vote> searchTitle(Connection conn, String titleName, int startlist, int endlist) {
		ArrayList<Vote> vlist = new ArrayList<Vote>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="SELECT * " + 
				"FROM (SELECT ROWNUM AS RNUM, VOTE_NO, VOTE_TITLE, VOTE_WRITER, VOTE_DATE, VOTE_FINAL_DATE, VOTE_READ_COUNT " + 
				"          FROM (SELECT * " + 
				"                    FROM USERVOTE " + 
				" 					 WHERE VOTE_TITLE LIKE ? " +
				"                    ORDER BY VOTE_NO DESC)) " + 
				"WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, "%"+titleName+"%");
			pstmt.setInt(2, startlist);
			pstmt.setInt(3, endlist);
			rset=pstmt.executeQuery();

			while(rset.next()) {
				Vote vote = new Vote();
				vote.setVoteNo(rset.getInt(2));
				vote.setVoteTitle(rset.getString(3));
				vote.setVoteWrite(rset.getString(4));
				vote.setVoteDate(rset.getDate(5));
				vote.setVoteFinalDate(rset.getDate(6));
				vote.setVoteReadCount(rset.getInt(7));
				
				vlist.add(vote);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return vlist;
	}

	public int getSearchListCount(Connection conn,String titleName) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query ="select count(vote_no) from uservote where vote_title like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+titleName+"%");
			
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

	public int deleteVote(Connection conn, int voteNo) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query="delete from uservote where vote_No=?";	
		try {

			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, voteNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateVote(Connection conn, Vote vote) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query="update uservote set vote_title = ?, vote_final_date = ?,"
				+ " vote_contents = ? where vote_no=?";	
		try {

			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, vote.getVoteTitle());
			pstmt.setDate(2, vote.getVoteFinalDate());
			pstmt.setString(3, vote.getVoteContents());
			pstmt.setInt(4, vote.getVoteNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectDoubleCheck(Connection conn, int voteNo, String userId) {
		int doubleCheck =0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from votecheck where vote_no=? and userid=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, voteNo);
			pstmt.setString(2, userId);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				doubleCheck=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return doubleCheck;
	}

	public int insertDouBleCheck(Connection conn, int voteNo, String userId, int voteResultNo, String vSecret) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String query = "insert into votecheck values(?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, voteNo);
			if(vSecret.equals("Y"))
				pstmt.setInt(3, voteResultNo);
			else 
				pstmt.setString(3, "NULL");

			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
}







package vote.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import vote.model.dao.VoteDao;
import vote.model.vo.Vote;
import vote.model.vo.VoteResult;

import static common.JDBCTemplate.*;

public class VoteService {
	private VoteDao vdao = new VoteDao();

//전체목록갯수 
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = vdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	// 전체목록조회
	public ArrayList<Vote> selectList(int startlist, int endlist) {
		Connection conn = getConnection();
		ArrayList<Vote> vlist = vdao.selectList(conn, startlist, endlist);
		close(conn);
		return vlist;
	}
//주민투표 인서트(트리거로 VOTERESULT도 인서트됨)
	public int insertVote(Vote vote) {
		Connection conn = getConnection();
		int result =vdao.insertVote(conn, vote);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public void updateReadCount(int vNo) {
		Connection conn = getConnection();
		int result =vdao.updateReadCount(conn, vNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}

	public Vote selectView(int vNo) {
		Connection conn = getConnection();
		Vote vote= vdao.selectView(conn, vNo);
		close(conn);
		return vote;
	}

	public void updateVoteResult(int voteNo, int voteResultNo) {
		Connection conn = getConnection();
		int result = vdao.updateVoteResult(conn,voteNo,voteResultNo);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
	}

	public VoteResult selectVoteResult(int voteNo) {
		Connection conn = getConnection();
		VoteResult voteResult= vdao.selectVoteResult(conn, voteNo);
		close(conn);
		return voteResult;
	}

	public ArrayList<Vote> searchTitle(String titleName, int startlist, int endlist) {
		Connection conn = getConnection();
		ArrayList<Vote> vlist = vdao.searchTitle(conn, titleName, startlist, endlist);
		close(conn);
		return vlist;
	}

	public int getSearchListCount(String titleName) {
		Connection conn = getConnection();
		int listCount = vdao.getSearchListCount(conn,titleName);
		close(conn);
		return listCount;
	}



}

package vote.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import vote.model.dao.VoteDao;
import vote.model.vo.Vote;
import vote.model.vo.VoteCheck;
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
	//조회수 업데이트
	public void updateReadCount(int vNo) {
		Connection conn = getConnection();
		int result =vdao.updateReadCount(conn, vNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}
	//상세조회
	public Vote selectView(int vNo) {
		Connection conn = getConnection();
		Vote vote= vdao.selectView(conn, vNo);
		close(conn);
		return vote;
	}
	//투표결과 카운트업데이트
	public void updateVoteResult(int voteNo, int voteResultNo) {
		Connection conn = getConnection();
		int result = vdao.updateVoteResult(conn,voteNo,voteResultNo);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
	}
	//투표결과 조회
	public VoteResult selectVoteResult(int voteNo) {
		Connection conn = getConnection();
		VoteResult voteResult= vdao.selectVoteResult(conn, voteNo);
		close(conn);
		return voteResult;
	}
	//제목검색후 목록들조회
	public ArrayList<Vote> searchTitle(String titleName, int startlist, int endlist) {
		Connection conn = getConnection();
		ArrayList<Vote> vlist = vdao.searchTitle(conn, titleName, startlist, endlist);
		close(conn);
		return vlist;
	}
	//제목검색용 목록갯수 조회용
	public int getSearchListCount(String titleName) {
		Connection conn = getConnection();
		int listCount = vdao.getSearchListCount(conn,titleName);
		close(conn);
		return listCount;
	}
	//투표삭제
	public int deleteVote(int voteNo) {
		Connection conn = getConnection();
		int result = vdao.deleteVote(conn,voteNo);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}
	//투표수정
	public int updateVote(Vote vote) {
		Connection conn = getConnection();
		int result = vdao.updateVote(conn,vote);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		
		close(conn);
		
		return result;
	}
	//투표중복체크 확인
	public int selectDoubleCheck(int voteNo, String userId) {
		Connection conn = getConnection();
		int doubleCheck = vdao.selectDoubleCheck(conn,voteNo,userId);
		close(conn);
		return doubleCheck;
	}
	//투표중복체크 인서트
	public void insertDouBleCheck(int voteNo, String userId, int voteResultNo, String vSecret) {
		Connection conn = getConnection();
		int result =vdao.insertDouBleCheck(conn, voteNo, userId, voteResultNo, vSecret);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}

	public ArrayList<VoteCheck> selectVoteCheck(int voteNo) {
		Connection conn = getConnection();
		ArrayList<VoteCheck> vclist = vdao.selectVoteCheck(conn, voteNo);
		close(conn);
		return vclist;
	}



}

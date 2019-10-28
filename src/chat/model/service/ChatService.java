package chat.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import chat.model.dao.ChatDao;
import chat.model.vo.ChatList;
import chat.model.vo.ChatMessage;
import chat.model.vo.ChatPerson;

public class ChatService {
	private ChatDao cdao = new ChatDao();
	
	//자기 자신제외한 전부조회
	public ArrayList<ChatPerson> selectAll(String empNo) {
		Connection conn = getConnection();
		ArrayList<ChatPerson> clist = cdao.selectAll(conn, empNo);
		close(conn);
		return clist;
	}
	
	//채팅목록,마지막메시지조회
	public ArrayList<ChatList> selectChatList(String empNo) {
		Connection conn = getConnection();
		ArrayList<ChatList> crmlist = cdao.selectChatList(conn, empNo);
		close(conn);
		return crmlist;
	}

	//채팅방인원조회

	public ArrayList<int[]> selectCount(String empNo) {
		Connection conn = getConnection();
		ArrayList<int[]> crpCountlist = cdao.selectCount(conn, empNo);
		close(conn);
		return crpCountlist;
	}

	//방하나의 메세지 전체조회
	public ArrayList<ChatMessage> selectMessageOne(int chatno) {
		Connection conn = getConnection();
		ArrayList<ChatMessage> cmlist = cdao.selectMessageOne(conn, chatno);
		close(conn);
		return cmlist;
	}
	//메세지저장
	public void insertMessage(ChatMessage cmessage) {
		Connection conn = getConnection();
		int result = cdao.insertMessage(conn, cmessage);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}

	public int selectRoom(String empno, String empno2) {
		Connection conn = getConnection();
		int result = cdao.selectRoom(conn, empno,empno2);
		close(conn);
		return result;
	}

	public void insertNewChatRoom(String empno) {
		Connection conn = getConnection();
		int result = cdao.insertNewChatRoom(conn, empno);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}

	public int selectNewChatRoom(String empno) {
		Connection conn = getConnection();
		int result = cdao.selectNewChatRoom(conn, empno);
		close(conn);
		return result;
	}

	public void insertNewChatRoom2(int chatno, String empno2) {
		Connection conn = getConnection();
		int result = cdao.insertNewChatRoom2(conn, chatno, empno2);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}
	
}

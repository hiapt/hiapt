package chat.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import chat.model.dao.ChatDao;
import chat.model.vo.ChatMessage;
import chat.model.vo.ChatPerson;
import chat.model.vo.ChatRoomPerson;

public class ChatService {
	private ChatDao cdao = new ChatDao();
	
	//자기 자신제외한 전부조회
	public ArrayList<ChatPerson> selectAll(String empNo) {
		Connection conn = getConnection();
		ArrayList<ChatPerson> clist = cdao.selectAll(conn, empNo);
		close(conn);
		return clist;
	}
	//자신의 방목록전체 조회...
	public ArrayList<ChatRoomPerson> selectCRPList(String empNo) {
	      Connection conn = getConnection();
	      ArrayList<ChatRoomPerson> crplist = cdao.selectCRPList(conn, empNo);
	      close(conn);
	      return crplist;
	}
	//자신의방에 있는 마지막메세지 찾고 맨위로보이게함..
	public ArrayList<ChatMessage> selectCMList(String empNo) {
	      Connection conn = getConnection();
	      ArrayList<ChatMessage> cmlist = cdao.selectCMList(conn, empNo);
	      close(conn);
	      return cmlist;
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
	//방하나 조회
	public int selectRoom(String empno, String empno2) {
		Connection conn = getConnection();
		int result = cdao.selectRoom(conn, empno,empno2);
		close(conn);
		return result;
	}
	//새로운방 인서트
	public void insertNewChatRoom(String empno) {
		Connection conn = getConnection();
		int result = cdao.insertNewChatRoom(conn, empno);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}
	//새로운방 조회
	public int selectNewChatRoom(String empno) {
		Connection conn = getConnection();
		int result = cdao.selectNewChatRoom(conn, empno);
		close(conn);
		return result;
	}
	//새로운방에 선택한친구 추가
	public void insertNewChatRoom2(int chatno, String empno2) {
		Connection conn = getConnection();
		int result = cdao.insertNewChatRoom2(conn, chatno, empno2);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}
	//프로필조회
	public ChatPerson selectPersonOne(String empNo2) {
		Connection conn = getConnection();
		ChatPerson chatPerson = cdao.selectPersonOne(conn, empNo2);
		close(conn);
		return chatPerson;
	}
	//방제목 변경
	public void updateRoomTitle(String chatNo, String empNo, String roomTitle) {
		Connection conn = getConnection();
		int result = cdao.updateRoomTitle(conn, chatNo, empNo, roomTitle);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}
	//목록최신화를위한 제목검색
	public String selectTitle(int chatNo, String empNo) {
		Connection conn = getConnection();
		String chatTitle = cdao.selectTitle(conn,chatNo,empNo);
		close(conn);
		return chatTitle;
	}
	//목록최신화를 위한 채팅인원수조회
	public int selectChatPCount(int chatNo) {
		Connection conn = getConnection();
		int chatPcount = cdao.selectChatPCount(conn,chatNo);
		close(conn);
		return chatPcount;
	}
	//목록최신화를 위환 채팅인원들조회(방에참여한인원들)
	public ArrayList<String> selectChatP(int chatNo) {
		Connection conn = getConnection();
		ArrayList<String> chatPerson = cdao.selectChatP(conn,chatNo);
		close(conn);
		return chatPerson;
	}
	//방목록삭제
	public void deleteChatRoomOut(String empNo, int chatNo) {
		Connection conn = getConnection();
		int result = cdao.deleteChatRoomOut(conn, chatNo, empNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
	}
	//채팅방참여한사람 이름 조회
	public ArrayList<ChatPerson> selectChatPName(int chatNo) {
		Connection conn = getConnection();
		ArrayList<ChatPerson> chatPerson = cdao.selectChatPName(conn,chatNo);
		close(conn);
		return chatPerson;
	}
	//초대인원 목록조회
	public ArrayList<ChatPerson> selectInvitePerson(int chatNo) {
		Connection conn = getConnection();
		ArrayList<ChatPerson> chatPerson = cdao.selectInvitePerson(conn,chatNo);
		close(conn);
		return chatPerson;
	}
	
	//선택한방에 초대할사람이있는지 조회
	public int selectRoomPersonOne(String empNo, String chatNo) {
		Connection conn = getConnection();
		int result = cdao.selectRoomPersonOne(conn, empNo, chatNo);
		close(conn);
		return result;
	}
	//초대하기
	public void insertInvitePerson(String empNo, String chatNo) {
		Connection conn = getConnection();
		int result = cdao.insertInvitePerson(conn, chatNo, empNo);
		if(result>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
	}
	//방의 마지막메시지..
	public String selectLastMessage(int chatNo1) {
		Connection conn = getConnection();
		String nameMessage = cdao.selectLastMessage(conn, chatNo1);
		close(conn);
		return nameMessage;
	}



	
}

package chat.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import chat.model.vo.ChatList;
import chat.model.vo.ChatMessage;
import chat.model.vo.ChatPerson;

public class ChatDao {
	//자기자신제외한 채팅인원목록조회
	public ArrayList<ChatPerson> selectAll(Connection conn, String empNo) {
		ArrayList<ChatPerson> clist = new ArrayList<ChatPerson>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select empno, empname, empid, empphone, empemail " + 
				"from employee " + 
				"where empno not in(?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				ChatPerson chatp = new ChatPerson();
				
				chatp.setEmpNo(rset.getString("empno"));
				chatp.setEmpName(rset.getString("empname"));
				chatp.setEmpId(rset.getString("empid"));
				chatp.setEmpPhone(rset.getString("empphone"));
				chatp.setEmpEmail(rset.getString("empemail"));
				
				clist.add(chatp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return clist;
	}
	//채팅방목록//메세지도
		public ArrayList<ChatList> selectChatList(Connection conn, String empNo) {
			ArrayList<ChatList> crmlist = new ArrayList<ChatList>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select chatno, empno, chatcontents, empname, chatorder, chattitle " + 
						   "from chatmessage " + 
					       "join CHAT_ROOM_PERSON using(chatno,empno) " + 
					       "join employee using(empno) " + 
					       "where chatorder in (select max(chatorder) " + 
					       "                    from chatmessage " + 
					       "                    where chatno in (select chatno " + 
					       "                                     from chat_room_person " + 
					       "                                     where empno=?) " + 
					       "                    group by chatno) " + 
					       "order by chatorder desc ";
			
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1, empNo);
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					ChatList cl = new ChatList();
					
					cl.setChatNo(rset.getInt(1));
					cl.setEmpNo(rset.getString(2));
					cl.setChatContents(rset.getString(3));
					cl.setEmpName(rset.getString(4));
					cl.setChatOrder(rset.getInt(5));
					cl.setChatTitle(rset.getString(6));
					crmlist.add(cl);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return crmlist;
		}
		
		
	//채팅인원수
	public ArrayList<int[]> selectCount(Connection conn, String empNo) {
		
		ArrayList<int[]> crpCountlist = new ArrayList<int[]>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select chatno, count(empno) " + 
					   "from (select chatno, empno " + 
				       "      from chat_room_person " + 
			           "      where chatno in (select chatno " + 
				       "                       from chat_room_person " + 
				       "                       where empno=?)) " + 
				       "group by chatno";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				int arr[]=new int[2];
				
				arr[0]=rset.getInt(1);
				arr[1]=rset.getInt(2);
				
				crpCountlist.add(arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return crpCountlist;
	}
	
	//채팅메세지 가져오기
	public ArrayList<ChatMessage> selectMessageOne(Connection conn, int chatno) {
		ArrayList<ChatMessage> cmlist = new ArrayList<ChatMessage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select chatno,CHATWRITEDATE,empname,CHATCONTENTS, empno " + 
				"from chatmessage " + 
				"join employee using (empno) " + 
				"where chatno=? " + 
				"order by chatorder asc";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, chatno);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				ChatMessage chatm = new ChatMessage();
				
				chatm.setChatNo(rset.getInt(1));
				chatm.setChatWriteDate(rset.getDate(2));
				chatm.setEmpName(rset.getString(3));
				chatm.setChatContents(rset.getString(4));
				chatm.setEmpNo(rset.getString(5));
				cmlist.add(chatm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return cmlist;
	}

	public int insertMessage(Connection conn, ChatMessage cmessage) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into chatmessage values(default, ?, CHATMESSAGE_SEQ.nextval, ?, ?)";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, cmessage.getChatContents());
			pstmt.setInt(2, cmessage.getChatNo());
			pstmt.setString(3, cmessage.getEmpNo());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int selectRoom(Connection conn, String empno, String empno2) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select chatno " + 
					   "from (select chatno, count(chatno) as chn " + 
					   "      from (select chatno " + 
					   "            from chat_room_person " + 
					   "            where chatno in (select chatno " + 
					   "                             from chat_room_person " + 
					   "                             where empno = ? " + 
					   "                             INTERSECT " + 
					   "                             select chatno " + 
					   "                             from chat_room_person " + 
					   "                             where empno = ?)) " + 
					   "        group by chatno) " + 
					   "where chn=2";
	
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, empno);
			pstmt.setString(2, empno2);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int insertNewChatRoom(Connection conn, String empno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into chat_room_person values((select max(chatno) " + 
				"                                            from chat_room_person)+1, ?, default)";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, empno);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int selectNewChatRoom(Connection conn, String empno) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select max(chatno) " + 
					   "from chat_room_person " + 
					   "where empno=?";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, empno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return result;

	}
	public int insertNewChatRoom2(Connection conn, int chatno, String empno2) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into chat_room_person values(? , ?, default)";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, chatno);
			pstmt.setString(2, empno2);
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



}

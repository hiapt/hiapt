package chat.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import chat.model.vo.ChatMessage;
import chat.model.vo.ChatPerson;
import chat.model.vo.ChatRoomPerson;

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
	//보관된 방목록조회
		public ArrayList<ChatRoomPerson> selectCRPList(Connection conn, String empNo) {
			  ArrayList<ChatRoomPerson> crplist = new ArrayList<ChatRoomPerson>();
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      
		      String query = "select chatno, empno, chattitle " + 
		            "from chat_room_person " + 
		            "where empno=? ";
		      
		      try {
		         pstmt=conn.prepareStatement(query);
		         pstmt.setString(1, empNo);
		         rset=pstmt.executeQuery();
		         
		         while(rset.next()) {
		            ChatRoomPerson chatrp = new ChatRoomPerson();
		            
		            chatrp.setChatNo(rset.getInt(1));
		            chatrp.setEmpNo(rset.getString(2));
		            chatrp.setChatTitle(rset.getString(3));
		            
		            crplist.add(chatrp);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }finally {
		         close(rset);
		         close(pstmt);
		      }
		      
		      return crplist;
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
	//자신방의 마지막채팅가져오기
	public ArrayList<ChatMessage> selectCMList(Connection conn, String empNo) {
		ArrayList<ChatMessage> cmlist = new ArrayList<ChatMessage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select chatno, chatcontents, empname " + 
					   "from chatmessage " + 
					   "join employee using(empno) " + 
					   "where chatorder in (select max(chatorder) " + 
					   "                    from chatmessage " + 
					   "                    where chatno in (select chatno " + 
					   "                                     from chat_room_person" + 
					   "                                     where empno=?) " + 
					   "                    group by chatno) " + 
					   "order by chatorder desc";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				ChatMessage chatm = new ChatMessage();
				
				chatm.setChatNo(rset.getInt(1));
				chatm.setChatContents(rset.getString(2));
				chatm.setEmpName(rset.getString(3));
				

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
	
	
	//채팅메세지 가져오기
	public ArrayList<ChatMessage> selectMessageOne(Connection conn, int chatno) {
		ArrayList<ChatMessage> cmlist = new ArrayList<ChatMessage>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select chatno,to_char(chatwritedate,'yy/mm/dd hh24:mi'),empname,CHATCONTENTS, empno " + 
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
				chatm.setChatWriteDate(rset.getString(2));
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
	//메세지추가
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
	//방번호 조회(1:1대화에서 기존방이 있는지 아니면 없는지.. 없으면0 있으면 기존방연결)
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
	//새로운방추가
	public int insertNewChatRoom(Connection conn, String empno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into chat_room_master values(CHATNO_SEQ.nextval, ?)";
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
	//새로운방조회
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
	//새로운방(1:!) 상대방추가
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
	//프로필조회
	public ChatPerson selectPersonOne(Connection conn, String empNo2) {
		ChatPerson chatPerson = new ChatPerson();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String query = "select empno,empname,empid,empphone,empemail"
				+ " from employee"
				+ " where empno=?";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, empNo2);
			rset =pstmt.executeQuery();
			
			if(rset.next()) {
				chatPerson.setEmpNo(empNo2);
				chatPerson.setEmpName(rset.getString(2));
				chatPerson.setEmpId(rset.getString(3));
				chatPerson.setEmpPhone(rset.getString(4));
				chatPerson.setEmpEmail(rset.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return chatPerson;
	}
	//방제목변경
	public int updateRoomTitle(Connection conn, String chatNo, String empNo, String roomTitle) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "update chat_room_person set CHATTITLE= ? " + 
				"where empno = ? and chatno = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, roomTitle);
			pstmt.setString(2, empNo);
			pstmt.setInt(3, Integer.parseInt(chatNo));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
	public String selectTitle(Connection conn, int chatNo, String empNo) {
		String chatTitle=null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String query = "select chattitle " + 
					   "from chat_room_person " + 
					   "where chatno=? and empno=?";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, chatNo);
			pstmt.setString(2, empNo);
			rset =pstmt.executeQuery();
			
			if(rset.next()) {
				chatTitle = rset.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return chatTitle;
	}
	public int selectChatPCount(Connection conn, int chatNo) {
		int result=0;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String query = "select count(empno) " + 
					   "from chat_room_person " + 
					   "where chatno=?";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, chatNo);
			rset =pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return result;
	}
	//목록최신화를 위환 채팅사람들조회
	public ArrayList<String> selectChatP(Connection conn, int chatNo) {
		ArrayList<String> chatPerson= new ArrayList<String>();
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String query = "select empno " + 
					   "from chat_room_person " + 
					   "where chatno=?";
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, chatNo);
			rset =pstmt.executeQuery();
			
			while(rset.next()) {
				String empno =rset.getString(1);
				chatPerson.add(empno);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return chatPerson;
	}
	public int deleteChatRoomOut(Connection conn, int chatNo, String empNo) {
		int result=0;
		PreparedStatement pstmt = null;
		
		String query = "delete from chat_room_person where chatno=? and empno=?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, chatNo);
			pstmt.setString(2, empNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//채팅방참여자목록
	public ArrayList<ChatPerson> selectChatPName(Connection conn, int chatNo) {
		ArrayList<ChatPerson> clist = new ArrayList<ChatPerson>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select empname, empid " + 
					   "from chat_room_person " + 
					   "join employee using(empno) " + 
					   "where chatno= ? ";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, chatNo);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				ChatPerson chatp = new ChatPerson();
				chatp.setEmpName(rset.getString("empname"));
				chatp.setEmpId(rset.getString("empid"));
				
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
	//채팅초대목록(참여자 제외)
	public ArrayList<ChatPerson> selectInvitePerson(Connection conn, int chatNo) {
		ArrayList<ChatPerson> clist = new ArrayList<ChatPerson>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select empno,empname,empid " + 
					   "from employee " + 
					   "where empno not in (select empno " + 
					   "                    from chat_room_person " + 
					   "                    join employee using(empno) " + 
					   "                    where chatno=?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, chatNo);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				ChatPerson chatp = new ChatPerson();
				chatp.setEmpNo(rset.getString("empno"));
				chatp.setEmpName(rset.getString("empname"));
				chatp.setEmpId(rset.getString("empid"));
				
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
	public int selectRoomPersonOne(Connection conn, String empNo, String chatNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(empNo) " + 
					   "from chat_room_person " + 
					   "where empno=? and chatno=? ";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, empNo);
			pstmt.setInt(2, Integer.parseInt(chatNo));
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	public int insertInvitePerson(Connection conn, String chatNo, String empNo) {
		int result=0;
		PreparedStatement pstmt = null;
		
		String query = "insert into chat_room_person values(?, ?, default)";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(chatNo));
			pstmt.setString(2, empNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public String selectLastMessage(Connection conn, int chatNo1) {
		String nameMessage = " ";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select empname||':'||chatcontents " + 
					   "from chatmessage " + 
					   "join EMPLOYEE using(empno) " + 
					   "where chatorder=(select max(chatorder) " + 
					   "                 from chatmessage " + 
					   "                 where chatno=?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, chatNo1);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				nameMessage=rset.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return nameMessage;
	}



}

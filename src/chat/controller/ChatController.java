package chat.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import chat.model.service.ChatService;
import chat.model.vo.ChatMessage;

@ServerEndpoint("/ChatController")
public class ChatController {
	private ChatService cservice = new ChatService();
	private static Map<Session, String> clients = Collections.synchronizedMap(new HashMap<Session, String>());// 접속인원저장
	private static Map<Session, String> rooms = Collections.synchronizedMap(new HashMap<Session, String>());// 접속인원저장
	private static Map<Session, String> invites = Collections.synchronizedMap(new HashMap<Session, String>());// 접속인원저장	
	private static String clientEmpNo = "empno";
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(session + "연결됨");
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println(session + "연결취소됨");
		
		synchronized (clients) {
			String empno = clients.get(session);
			clientEmpNo=clientEmpNo.replace(","+empno, "");
			clients.remove(session);
			for (Session key : clients.keySet()) {
				try {
					key.getBasicRemote().sendText(clientEmpNo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}//동기화
			if(invites.size()>0) {
				synchronized (invites) {
					invites.remove(session);
				}//동기화
			}
			
			if(rooms.size()>0) {
				synchronized (rooms) {
					rooms.remove(session);
				}//동기화
			}
		
	}//onclose
	
	@OnError
	public void onError(Throwable error) {
		// 메세지 전송과정에서 에러가 발생한 경우 자동 실행됨
		error.printStackTrace();
	} //에러

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		if(message.substring(0, 7).equals("online:")) //최초온라인접속 세션연결
			online(message,session);
		else if(message.substring(0, 5).equals("room:")) //목록에서 방열기 세션연결
			 openRoom(message,session);
		else if(message.substring(0, 5).equals("chat:")) //방에 메세지주기
			sendToMessage(message,session);
		else if(message.substring(0, 4).equals("crt:")) //방제목바꾸기
			changeRoomTitle(message);
		else if(message.substring(0, 5).equals("rout,")) //방나가기
			roomOut(message);
		else if(message.substring(0, 8).equals("newRoom,")) //1:1대화방새로만들기or기존방주기.
			newCreateRoom(message);
		else if(message.substring(0, 7).equals("invite:"))//초대 세션연결
			openInvite(message,session);
		else if(message.substring(0, 8).equals("inviteP,"))//초대 했을경우
			invitePerson(message);
	}//온메세지
	
	//채팅초대
	private void invitePerson(String empnoChatnoEmpname) throws IOException {
		
		String ecs[] = empnoChatnoEmpname.split(",");
		String empNo = ecs[1];
		String chatNo = ecs[2];
		String empName = ecs[3];
		int result = cservice.selectRoomPersonOne(empNo, chatNo);// 채팅방에 그사람이있는지 조회

		if (result == 0) {// 없다면디비에 저장
			cservice.insertInvitePerson(empNo, chatNo);
			synchronized (invites) {
				for (Session key : invites.keySet()) {
					// session은 key이다, value=clients.get(key)이다
					key.getBasicRemote().sendText("ok," +empNo+","+empName);// 목록을줌
				}
			} // 동기화
			//채팅매니저 목록최신화.
			int chatNo1 = Integer.parseInt(chatNo);
			String chatTitle = cservice.selectTitle(chatNo1,empNo);
			int chatPCount = cservice.selectChatPCount(chatNo1);
			String nameMessage = cservice.selectLastMessage(chatNo1);
			String cetcm = chatNo+","+empNo+","+chatTitle+","+chatPCount+","+nameMessage;
			
			synchronized (clients) {
				for (Session key : clients.keySet()) { // 세션에 저장된 모든 사번
						if (clients.get(key).equals(empNo)) // 세션에저장된 사람들에게 만약 방에참가해있으ㅕㅁ
							key.getBasicRemote().sendText(cetcm);// 목록을줌
				}//세션
			}//동기화
			
			//방에 접속된 사람들중 같은방번호들에게만 메세지보내줌...
			
			synchronized (rooms) {
				for (Session key : rooms.keySet()) { //세션에 저장된 모든 방번호사번
				//session은 key이다, value=clients.get(key)이다 //같은 방번호 사람한테만 전해줘야함.
					String empnoChatno=rooms.get(key);
					String encn[]=empnoChatno.split(",");
					int cn= Integer.parseInt(encn[1]);
					if(Integer.parseInt(chatNo)==cn) {
					key.getBasicRemote().sendText("rin:"+empName);
					}
				}	
			}//동기화
			
		} else {// 이미방에 존재한다면 ..
			synchronized (invites) {
				for (Session key : invites.keySet()) {
					// session은 key이다, value=clients.get(key)이다
					key.getBasicRemote().sendText("false," + empName);// 초대목록에만 목록을줌
				}
			}//초대방 동기화
		}//else끝
		
	}

	//초대 연결
	private void openInvite(String chatNo, Session session) {
		String chatNos[] = chatNo.split(":");
		String chatno = chatNos[1];
		invites.put(session, chatno); // 사번세션저장
	}

	//새로운 채팅방 체크
	private void newCreateRoom(String empnoEmpno2) throws IOException {
		String emps[]=empnoEmpno2.split(",");
		String empNo = emps[1];
		String empNo2 = emps[2];
		int chatno = 0;
		chatno = cservice.selectRoom(empNo,empNo2);
		
		if(chatno==0) { //1:1대화기록없고 new일경우
			cservice.insertNewChatRoom(empNo);//방장기록하면 trigger로 roomperson에같이 기록된다.
			chatno = cservice.selectNewChatRoom(empNo);
			cservice.insertNewChatRoom2(chatno, empNo2);//방장기록과동시에 1:1대화상대 등록.
		}
		
		synchronized (clients) {
			for (Session key : clients.keySet()) { // 세션에 저장된 모든 사번
				// session은 key이다, value=clients.get(key)이다
					if (clients.get(key).equals(empNo)) {
						key.getBasicRemote().sendText(String.valueOf("newRoom,"+chatno));// 목록을줌
							break;
					}
				}
		}//동기화
		
	}
	
	private void online(String empNo, Session session) throws IOException {
		// 채팅온라인 체크, 온로드시 반응함. 첫로그인시 전체목록조회
		String empNos[] = empNo.split(":");
		String empno = empNos[1];
		clients.put(session, empno); // 사번세션저장
		clientEmpNo+=","+empno;
		synchronized (clients) {
			for (Session key : clients.keySet()) {
				key.getBasicRemote().sendText(clientEmpNo);
			}
		}//동기화
	}
	//방열기
	private void openRoom(String empNoChatNo, Session session) {
		ChatMessage cmessage = new ChatMessage(); //메세지를 디비에 저장시키기 위한객체
		// 채팅온라인 체크, 온로드시 반응함. 첫로그인시 전체목록조회
		String empNoChatNos[] = empNoChatNo.split(":");
		String empnochatno = empNoChatNos[1];
		rooms.put(session, empnochatno); // 채팅내용이아니라 최초접속이면 사번세션 맵에저장
			//admin 4번방 session
		    //10001 4번방에 ssioon
	}
	//메시지보내기
	private void sendToMessage(String message, Session session) throws IOException{
		ChatMessage cmessage = new ChatMessage();//디비저장메세지객체
		String chatMessage1 = message.replaceFirst("chat:", ""); //받은메세지에서 chat제외시키고 chat:김박사:메세지=> 김박사:메세지
		String empName= chatMessage1.substring(0, chatMessage1.indexOf(":")+1);//제외한 다음은 ex) 이름:메세지 에서 이름:만냄김
		String chatMessage = chatMessage1.replaceFirst(empName, "");//메세지만남김 이름:만 제거
		cmessage.setChatContents(chatMessage);//chat,사번 제거한 메세지만 객체에저장.
		//
		//나중에 추가. 받아온 사번으로 아이디를 찾아서 보낸사람아이디를 앞에붙여서 보낸다.
		//
		synchronized (rooms) {
			String id = rooms.get(session); //접속된 세션에서 empno chatno추출
			String idd[]=id.split(","); 
			String EmpNo = idd[0]; //현 접속된 사람의 사번
			int chatNo = Integer.parseInt(idd[1]); //현 접속된 사람의 방번호
			cmessage.setEmpNo(EmpNo);//객체에 사번저장
			cmessage.setChatNo(chatNo);//객체에 방번호저장
			for (Session key : rooms.keySet()) { //세션에 저장된 모든 방번호사번
			//session은 key이다, value=clients.get(key)이다 //같은 방번호 사람한테만 전해줘야함.
				
				if(!id.equals(rooms.get(key))) {//보낸사람제외하고
					String chn= rooms.get(key);
					String chnn[]=chn.split(",");
					int chatn= Integer.parseInt(chnn[1]);
					if(chatNo==chatn) {//현접속된 사람의 방번호와 저장된 방번호가 같으면.
				key.getBasicRemote().sendText(chatMessage1);//이메세지를 전한다.(ex 김보안:하이요)
					}
				}
			}	
		}//동기화
		cservice.insertMessage(cmessage); //디비에 날짜,대화,순서,chatno,empno
		sendToManager(cmessage,chatMessage1);
	}
	//채팅목록최신화
	private void sendToManager(ChatMessage cm, String nameMessage) throws IOException {
		int chatNo = cm.getChatNo();
		String empNo = cm.getEmpNo();
		String chatTitle = cservice.selectTitle(chatNo,empNo);
		int chatPCount = cservice.selectChatPCount(chatNo);
		ArrayList<String> chatPerson = cservice.selectChatP(chatNo);
		String cetcm = String.valueOf(chatNo)+","+empNo+","+chatTitle+","+chatPCount+","+nameMessage;
		//보낼떈,,manager세션에서 admin이 101와 대화하면 admin 101 단체면 쭈루룩에게 보냄 그러니까 채팅참여자 전부껄알려줘야함.
		
		synchronized (clients) {
			for (Session key : clients.keySet()) { // 세션에 저장된 모든 사번
				// session은 key이다, value=clients.get(key)이다
				for (String cp : chatPerson) {
					if (clients.get(key).equals(cp)) // 세션에저장된 사람들에게 만약 방에참가해있으ㅕㅁ
						key.getBasicRemote().sendText(cetcm);// 목록을줌

				}//인원
			}//세션
		}//동기화
	}//메소드

	//방제목변경
	private void changeRoomTitle(String message) {
		String crt[] = message.split(":");
		String chatNo = crt[1];
		String empNo = crt[2];
		String roomTitle = crt[3];
		
		cservice.updateRoomTitle(chatNo,empNo,roomTitle);	
	}
	//방탈출
	private void roomOut(String empnoChatnoEmpname) throws IOException {
		String roomOut[] = empnoChatnoEmpname.split(",");
		String empNo = roomOut[1];
		int chatNo = Integer.parseInt(roomOut[2]);
		String empName = roomOut[3];
		synchronized (clients) {
			for (Session key : clients.keySet()) { // 세션에 저장된 모든 사번
				// session은 key이다, value=clients.get(key)이다
					if (clients.get(key).equals(empNo)) { // empno가 같으면
						key.getBasicRemote().sendText(empnoChatnoEmpname);// 목록을줌
						break;
					}
			}//세션
		}//동기화
		//방에 접속된 사람들중 같은방번호들에게만 메세지보내줌...
		
		synchronized (rooms) {
			for (Session key : rooms.keySet()) { //세션에 저장된 모든 방번호사번
			//session은 key이다, value=clients.get(key)이다 //같은 방번호 사람한테만 전해줘야함.
				String empnoChatno=rooms.get(key);
				String encn[]=empnoChatno.split(",");
				int cn= Integer.parseInt(encn[1]);
				if(chatNo==cn) {
				key.getBasicRemote().sendText("rout:"+empName);
				}
			}	
		}//동기화
	
		cservice.deleteChatRoomOut(empNo,chatNo);

	}
	
}

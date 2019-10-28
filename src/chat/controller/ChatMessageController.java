package chat.controller;

import java.io.IOException;
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

@ServerEndpoint("/ChatMessageController")
public class ChatMessageController {
	private ChatService cservice = new ChatService();
	private static Map<Session, String> clients = Collections.synchronizedMap(new HashMap<Session, String>());// 접속인원저장
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println(session + "연결됨");
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println(session + "연결취소됨");
		
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		ChatMessage cmessage = new ChatMessage(); //메세지를 디비에 저장시키기 위한객체
		// 채팅온라인 체크, 온로드시 반응함. 첫로그인시 전체목록조회
		if(!message.substring(0,5).equals("chat:")) {
			System.out.println(message);
		clients.put(session, message); // 채팅내용이아니라 최초접속이면 사번세션 맵에저장
		}else {                        // 맵에 session이 key, message는 empno,chatno이다.

			String chatMessage = message.replaceFirst("chat:", ""); //받은메세지에서 chat제외시키고
			cmessage.setChatContents(chatMessage);//chat제거한 메세지 객체에저장.
			//
			//나중에 추가. 받아온 사번으로 아이디를 찾아서 보낸사람아이디를 앞에붙여서 보낸다.
			//
			synchronized (clients) {
				String id = clients.get(session); //접속된 세션에서 empno chatno추출
				String idd[]=id.split(","); 
				String EmpNo = idd[0];
				int chatNo = Integer.parseInt(idd[1]); //현 접속된 사람의 방번호 사번
				cmessage.setEmpNo(EmpNo);//객체에 사번저장
				cmessage.setChatNo(chatNo);//객체에 방번호저장
				for (Session key : clients.keySet()) { //세션에 저장된 모든 방번호사번
				//session은 key이다, value=clients.get(key)이다 //같은 방번호 사람한테만 전해줘야함.
					
					if(!id.equals(clients.get(key))) {//보낸사람제외하고
						String chn= clients.get(key);
						String chnn[]=chn.split(",");
						int chatn= Integer.parseInt(chnn[1]);
						if(chatNo==chatn) {
					key.getBasicRemote().sendText(chatMessage);//이메세지를 전한다.
						}
					}
				}	
			}//동기화
			cservice.insertMessage(cmessage); //디비에 날짜,대화,순서,chatno,empno
		}//메세지전송이라면
	}//온메세지 메소드

	@OnError
	public void onError(Throwable error) {
		// 메세지 전송과정에서 에러가 발생한 경우 자동 실행됨
		error.printStackTrace();
	}
}

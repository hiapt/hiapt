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

@ServerEndpoint("/ChatController")
public class ChatController {
	private ChatService cservice = new ChatService();
	private static Map<Session, String> clients = Collections.synchronizedMap(new HashMap<Session, String>());// 접속인원저장
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
		}
		
		synchronized (clients) {
			for (Session key : clients.keySet()) {
				try {
					key.getBasicRemote().sendText(clientEmpNo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@OnMessage
	public void onMessage(String empNo, Session session) throws IOException {
		// 채팅온라인 체크, 온로드시 반응함. 첫로그인시 전체목록조회
		clients.put(session, empNo); // 사번세션저장
		
		clientEmpNo+=","+empNo;
		
		synchronized (clients) {
			for (Session key : clients.keySet()) {
				key.getBasicRemote().sendText(clientEmpNo);
			}
		}
	}

	@OnError
	public void onError(Throwable error) {
		// 메세지 전송과정에서 에러가 발생한 경우 자동 실행됨
		error.printStackTrace();
	}
}

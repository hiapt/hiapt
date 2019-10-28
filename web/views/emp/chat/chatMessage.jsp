<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chat.model.vo.ChatMessage, java.util.*" %>
<%
	ArrayList<ChatMessage> cmlist = (ArrayList<ChatMessage>)request.getAttribute("cmlist");
	String empNo = (String)request.getAttribute("empno");
	int chatNo = (int)request.getAttribute("chatno");
	String messageId = empNo+","+String.valueOf(chatNo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#messageWindow {
		background: LightSkyBlue;
		height: 300px;
		overflow: auto;
	}
	.other-side {
		background: white;
		float: left;
		clear: both;
	}
	.other-side:after {
		content: '';
		positon: absolute;
		right: 0;
		top: 50%;
		width: 0;
		height: 0;
		border: 20px solid transparent;
		border-right-color: white;
		border-left: 0;
		border-top: 0;
		margin-top: -3.5px;
		margin-right: -10px;
	}
</style>
<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
 var webSocket =null;
$(function(){
	 webSocket = new WebSocket("ws://localhost:8900/hiapt/ChatMessageController");
										/* url/path/mapping */
	
	 messageId ="<%= messageId %>";
	 console.log(messageId);
	webSocket.onopen = function(event){
		console.log("웹소켓 연결됨");
		webSocket.send(messageId);
	};
	
	webSocket.onclose = function(event){
	};
	
	webSocket.onerror = function(event){
		consols.log(event);
	};
	
	webSocket.onmessage = function(event){
		onMessage(event);
	};
});

function SocketClose(){
	webSocket.close();
	return false;
};

function onMessage(event){
	var $textarea = $('#messageWindow'); //div채팅창
	$textarea.html($textarea.html() +
			"id(name전달) : " + event.data + "<br>");
	//화면이 위로 스크롤되게 처리함
	$textarea.scrollTop($textarea.height());
};

function send(){
	var $textarea = $('#messageWindow'); //div채팅창
	var inputMessage = document.getElementById("inputMessage").value; 
	console.log(inputMessage);
	//메세지를 입력하지 않고 버튼 누른 경우
	if(inputMessage== "") {
		alert("전송할 메세지를 입력하세요.");
	}else{  //메세지가 입력된 경우
		$textarea.html($textarea.html() + 
				"<h3 align='right' style='margin:0'> 나 : "
			+inputMessage+ "</h3><br>");
		webSocket.send("chat:"+inputMessage);
		document.getElementById("inputMessage").value="";
	}
	//화면이 위로 스크롤되게 처리함
	$textarea.scrollTop($textarea.height());
	return false;
};  //send()

	//전송할 메세지 입력하면서, 키보드 키에서 손뗄때마다
	//실행되는 이벤트핸들러 함수
	function enterKey(){
		//누른 키가 엔터키(Enter) 이면 메세지 전송함
		if(window.event.keyCode == 13){
			send();
		}
		return false;
	}

</script>
</head>
<body onunload="SocketClose();">
<div id="chatbox">
	<fieldset>
		<div id="messageWindow">
 		<% if(cmlist.size()!=0) {%>
		<%for(ChatMessage cm : cmlist){ %>
		<%if(empNo.equals(cm.getEmpNo())){ %>
		<h3 align="right" style="margin:0">나 : <%= cm.getChatContents() %></h3>
		<%}else{%>
		<%= cm.getEmpName() %> : <%= cm.getChatContents() %><br>
		<%}}} %>	 
		</div> <br>
		<input type="text" id="inputMessage" onkeyup="enterKey();">
		<input type="button" value="보내기" onclick="send();">
		<input type="button" value="방나가기(목록제거)" onclick="roomOut();">
	</fieldset>
</div>
</body>
</html>







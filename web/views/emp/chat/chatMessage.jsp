<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chat.model.vo.ChatMessage, java.util.*, employee.model.vo.Employee" %>
<%
	Employee employee = (Employee)session.getAttribute("employee");
	ArrayList<ChatMessage> cmlist = (ArrayList<ChatMessage>)request.getAttribute("cmlist");
	String empNo = (String)request.getAttribute("empno");
	String ctitle = (String)request.getAttribute("ctitle");
	int chatNo = (int)request.getAttribute("chatno");
	String messageId = empNo+","+String.valueOf(chatNo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= ctitle %></title>
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
 var $textarea;
 var messageId ="<%= messageId %>";
 var chatNo = "<%= chatNo %>";
$(function(){
	$textarea = $('#messageWindow');
	 webSocket = new WebSocket("ws://localhost:12080/hiapt/ChatController");
										/* url/path/mapping */

	webSocket.onopen = function(event){
		console.log("웹소켓 연결됨");
		webSocket.send("room:"+messageId);
	};
	
	webSocket.onclose = function(event){
	};
	
	webSocket.onerror = function(event){
		console.log(event);
	};
	
	webSocket.onmessage = function(event){
		onMessage(event);
	};
	$textarea.scrollTop($textarea[0].scrollHeight);
});

function SocketClose(){
	webSocket.close();
	return false;
};

function onMessage(event){
	var message = event.data.split(":");
	if(message[0]=="rout"){//친구가 방나갓을 떄 신호받음.
		$textarea.html($textarea.html()+"<h4 align='center' style='margin:0'>"+
				message[1]+"님이 방에서 나가셨습니다.</h4>");
		$textarea.scrollTop($textarea[0].scrollHeight);
	}else if(message[0]=="rin"){//누군가가 방에 초대로 들어왔을경우.
		$textarea.html($textarea.html()+"<h4 align='center' style='margin:0'>"+
				message[1]+"님이 초대 되었습니다.</h4>");
		$textarea.scrollTop($textarea[0].scrollHeight);
	}else{
	$textarea.html($textarea.html() + event.data + 
			"<h6 style='margin:0'>"+getTimeStamp()+"</h6>"+
			"<br>");
	//화면이 위로 스크롤되게 처리함
	$textarea.scrollTop($textarea[0].scrollHeight);
	}
};

function getTimeStamp() { //날짜 얻기함수 리턴으로 현재시간알려줌
	  var d = new Date();
	  var year = d.getFullYear().toString().substr(2,2);
	  var s =
	    leadingZeros(year, 2) + '/' +
	    leadingZeros(d.getMonth() + 1, 2) + '/' +
	    leadingZeros(d.getDate(), 2) + ' ' +
	    leadingZeros(d.getHours(), 2) + ':' +
	    leadingZeros(d.getMinutes(), 2);

	  return s;
}

function leadingZeros(n, digits) { //이함수로 앞에숫자가 01시 일경우 0을 붙여줌.
	  var zero = '';
	  n = n.toString();

	  if (n.length < digits) {
	    for (i = 0; i < digits - n.length; i++)
	      zero += '0';
	  }
	  return zero + n;
}


function send(){

	var inputMessage = document.getElementById("inputMessage").value; 
	if(151<inputMessage.length){
		alert('메세지 전달은 150글자 이내에서만 가능합니다.');
		document.getElementById("inputMessage").value="";
		return false;
	}//글자 제한두기
	//메세지를 입력하지 않고 버튼 누른 경우
	if(inputMessage== "") {
		alert("전송할 메세지를 입력하세요.");
	}else{  //메세지가 입력된 경우
		$textarea.html($textarea.html() + 
				"<h3 align='right' style='margin:0'> 나 : "
			+inputMessage+ "</h3>"
			+"<h6 align='right' style='margin:0'>"+getTimeStamp()+"</h6>");
		webSocket.send("chat:<%= employee.getEmpName() %>:"+inputMessage);
		document.getElementById("inputMessage").value="";
	}
	//화면이 위로 스크롤되게 처리함
	$textarea.scrollTop($textarea[0].scrollHeight);
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
};

function checkPerson(){
	window.open("/hiapt/ch.checkPerson?chatno="+chatNo,"cp"+chatNo,"width=430,height=550"); 
	return false;
}

function invitePerson(){//초대하기
	window.open("/hiapt/ch.inviteP?chatno="+chatNo,"ip"+chatNo,"width=430,height=550"); 
	return false;
}

function roomOut(){//방나가기
	var empName = "<%= employee.getEmpName()%>";
	var check = confirm("정말 목록에서 제거하시겠습니까? \n제거를 하실 경우 초대를 받으셔야 다시 방에 들어오실 수 있습니다. \n그냥 나가시길 원하실 경우 취소를 누르시고 오른쪽 위 x를 눌러주세요")
	if(check===true){
		webSocket.send("rout,"+messageId+","+empName);
		webSocket.close();
		window.close();
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
		<h6 align="right" style="margin:0"><%= cm.getChatWriteDate() %></h6>
		<%}else{%>
		<%= cm.getEmpName() %> : <%= cm.getChatContents() %><br>
		<h6 style="margin:0"><%= cm.getChatWriteDate() %></h6>
		<%}}} %>	 
		</div> <br>
		<input type="text" id="inputMessage" onkeyup="enterKey();">
		<input type="button" value="보내기" onclick="send();">&nbsp;
		<input type="button" value="참여자목록" onclick="checkPerson();">&nbsp;
		<input type="button" value="초대하기" onclick="invitePerson();">&nbsp;
		<input type="button" value="방나가기(목록제거)" onclick="roomOut();">
	</fieldset>
</div>
</body>
</html>







<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="chat.model.vo.ChatPerson,java.util.ArrayList,employee.model.vo.Employee"%>
<%
	Employee employee = (Employee)session.getAttribute("employee");
	ArrayList<ChatPerson> cplist = (ArrayList<ChatPerson>)request.getAttribute("chatperson");
	int chatNo = (int)request.getAttribute("chatno");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초대 목록</title>

<!-- Custom fonts for this template-->
	<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
	
	<!-- Custom styles for this template-->
	<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="/hiapt/resources/css/basic.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
	<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
 var webSocket =null;
 var chatNo = "<%= chatNo %>";
$(function(){
	 webSocket = new WebSocket("ws://localhost:12080/hiapt/ChatController");
										/* url/path/mapping */

	webSocket.onopen = function(event){
		console.log("웹소켓 연결됨");
		webSocket.send("invite:"+chatNo);
	};
	
	webSocket.onclose = function(event){
	};
	
	webSocket.onerror = function(event){
		console.log(event);
	};
	
	webSocket.onmessage = function(event){
		onMessage(event);
	};
});

function SocketClose(){
	webSocket.close();
	return false;
}

function invitePerson(empno,empname){
	
	var empNo;
	var empName=empname.value;
	if(typeof(empno)==="number")
	empNo = empno;
	else
	empNo = empno.value;
	
	webSocket.send("inviteP,"+empNo+","+chatNo+","+empName);	
}

function onMessage(event){
	var message = event.data.split(",");
	var listTr = document.getElementById(message[1]);
	console.log(event.data);
	console.log(listTr);
	if(listTr!=null)
	listTr.remove();

	if(message[0]=="ok"){//초대했다면
		alert(message[2]+"님이 초대되었습니다.");
	}else{//이미 초대되었다면..
		alert(message[2]+"님이 이미 방에 존재합니다.");
	}
}
</script>
</head>
<body onunload="SocketClose();">

<div class="card shadow mb-4">
	<div class="card-body">
	<h2 align="center" >초대 목록</h2>
	<table class="table table-bordered">
	<tr align="center"><th>이름</th><th>직책</th><th>초대 버튼</th></tr>
	<%for(ChatPerson cp : cplist) {%>
	<input type="hidden" id="h<%= cp.getEmpNo() %>" value="<%= cp.getEmpNo() %>">
	<input type="hidden" id="hn<%= cp.getEmpNo() %>" value="<%= cp.getEmpName() %>">
	<tr align="center" id="<%= cp.getEmpNo() %>"><th><%= cp.getEmpName() %></th><td><%= cp.getEmpId() %></td><td>
	<button onclick="invitePerson(h<%= cp.getEmpNo() %>,hn<%= cp.getEmpNo() %>)">초대하기</button>
	</td></tr>
	<%} %>
	</table>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="employee.model.vo.Employee, chat.model.vo.ChatPerson, 
				chat.model.vo.ChatList, java.util.*"
%>    
<%
	Employee employee = (Employee)session.getAttribute("employee");
	ArrayList<ChatPerson> clist = (ArrayList<ChatPerson>)request.getAttribute("clist");
	ArrayList<ChatList> crmlist = (ArrayList<ChatList>)request.getAttribute("crmlist");
	ArrayList<int[]> crpCountlist = (ArrayList<int[]>)request.getAttribute("crpCountlist");
%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chatting</title>

<!-- Custom fonts for this template-->
	<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
	<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
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
/* 채팅 네비 전환 */
function viewbcp(){
	var chatPerson = document.getElementById("chatperson");
	var chatRooms = document.getElementById("chatrooms");
	chatRooms.style.display="none";
	chatPerson.style.display="";

}
function viewbcr(){
	var chatPerson = document.getElementById("chatperson");
	var chatRooms = document.getElementById("chatrooms");
	chatPerson.style.display="none";
	chatRooms.style.display="";
}
/* 채팅view */
/* 켜자마자 웹소켓연결 */
$(function(){
	 var webSocket = new WebSocket("ws://localhost:8900/hiapt/ChatController");
										/* url/path/mapping */		
	empNo = "<%= employee.getEmpNo() %>";								
	webSocket.onopen = function(event){
		console.log("웹소켓 연결됨");
		webSocket.send(empNo);
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
};

function onMessage(event){
	var elist = event.data.split(",");
	var onOff=document.getElementsByClassName("onoff");

	for(var i=0; i<onOff.length; i++){
		onOff[i].innerHTML='오프라인';
	}
	
	for(var i=1; i<elist.length; i++){
		var empno = elist[i];
		var obj=document.getElementById(empno);
		if(obj!=null)
		 obj.innerHTML ='온라인';
	}
};
function openNewRoom(empno2){
	var empNo2 = empno2
	window.open("/hiapt/ch.message?newold=new&empno="+empNo+"&empno2="+empNo2,"","width=500,height=350");
}

function openOldRoom(chatno){
	var chatNo = chatno;
	window.open("/hiapt/ch.message?newold=old&empno="+empNo+"&chatno="+chatNo,"","width=500,height=350");
	return false;
}
</script>
</head>
<body onunload="SocketClose();">
<nav>
	<button id="bcp" onclick="viewbcp();">접속인원</button>&nbsp;&nbsp;
	<button id="bcr" onclick="viewbcr();">방목록</button>
</nav>
	<section>
<%-- 		<div id="chatperson" style="display:"><!-- 채팅인원  -->
			<table id= "chatp">
				<tr><th colspan="2"><h2 style="color:blue">나(<%= employee.getEmpName() %>)</h2></th></tr>
				<%for(ChatPerson cp : clist){%>
				<tr><td><input type="hidden" id="<%= cp.getEmpNo() %>" value="<%= cp.getEmpNo() %>">
				<a href="#" onclick="openNewRoom(<%= cp.getEmpNo() %>);"><h1><%= cp.getEmpName() %></h1></a>
				</td><td class="onoff" id="<%= cp.getEmpNo() %>"></td></tr>
				<%} %>
			</table>
		</div>	 --%>
		<div id="chatperson" style="display:">
				<table id= "chatp">
				<tr><th colspan="2"><h2 style="color:blue">나(<%= employee.getEmpName() %>)</h2></th></tr>
				
				<%for(ChatPerson cp : clist){%>
				<tr><td><input type="hidden" id="<%= cp.getEmpNo() %>" value="<%= cp.getEmpNo() %>">
  				<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
  				<%= cp.getEmpName() %>
 				</button>
 			 </td><td class="onoff" id="<%= cp.getEmpNo() %>"></td></tr>
				
  				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
  				  <a class="dropdown-item" href="#" onclick="openNewRoom(<%= cp.getEmpNo() %>);" >1:1대화</a>
   				 <a class="dropdown-item" href="#">프로필보기</a>
  				</div>
  				<%} %>	
 				 </table>
				</div>
					
		
		
		<div id="chatrooms" style="display: none"><!-- 채팅방목록 -->
			<table id="chatr">
				<%for(ChatList cl : crmlist){%>
				<tr><th><input type="hidden" id="<%= cl.getChatNo() %>" value="<%= cl.getChatNo() %>">
				<h2><a href="#" onclick="openOldRoom(<%= cl.getChatNo() %>);"><%= cl.getChatTitle() %></a></h2>
				</th><!-- 채팅방제목 -->
				<td><%for(int[] crpCount : crpCountlist) {%><!-- 채팅인원 -->
				<%if(crpCount[0] == cl.getChatNo()){ %><!-- crpcount0은 챗넘버에 1은 인원수 -->
				<%= crpCount[1] %>명
				<%}} %>
				</td>
				</tr>
				<tr>
				<td colspan="2" align="center"><%= cl.getEmpName() %>:<%= cl.getChatContents() %></td>
				</tr>
				<%} %>
			</table>
			
		</div>
	</section>
</body>
</html>
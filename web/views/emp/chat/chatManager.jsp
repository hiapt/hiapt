<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="employee.model.vo.Employee, chat.model.vo.*, java.util.*"
%>    
<%
	Employee employee = (Employee)session.getAttribute("employee");
	ArrayList<ChatPerson> clist = (ArrayList<ChatPerson>)request.getAttribute("clist");
	ArrayList<ChatRoomPerson> crplist = (ArrayList<ChatRoomPerson>)request.getAttribute("crplist");
	ArrayList<ChatMessage> cmlist = (ArrayList<ChatMessage>)request.getAttribute("cmlist");
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
 webSocket = null;
$(function(){
	 webSocket = new WebSocket("ws://localhost:12080/hiapt/ChatController");
										/* url/path/mapping */		
	empNo = "<%= employee.getEmpNo() %>";								
	webSocket.onopen = function(event){
		console.log("웹소켓 연결됨");
		webSocket.send("online:"+empNo);
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
	if(elist[0]=="empno"){//온라인오프라인표시할때
	var onOff=document.getElementsByClassName("onoff");

	for(var i=0; i<onOff.length; i++){
		onOff[i].innerHTML='&nbsp;&nbsp;&nbsp;<i class="fas fa-user-slash fa-2x"></i>';
	}
	for(var i=1; i<elist.length; i++){
		var empno = elist[i];
		var obj=document.getElementById("on"+empno);
		if(obj!=null)
		 obj.innerHTML ='&nbsp;&nbsp;&nbsp;<i class="fas fa-user fa-2x"></i>';
	}
	}//온라인오프라인표시할때
	else if(elist[0]=="rout"){//방에서 나갈때(목록제외)
		var roomOutlist = document.getElementById(elist[2]);
		roomOutlist.remove();	
	
	}//방에서 나갈때(목록제외)
	else if(elist[0]=="newRoom"){//새로운방일경우
		openOldRoom(elist[1]);
	}//새로운방일경우 chatno부여
	else{//메세지가와서 목록최신화시킬떄..
		var cetcm = event.data.split(",");
		var chatn = cetcm[0];
		var empn = cetcm[1];
		var ctitle = cetcm[2];
		var chatCount = cetcm[3];
		var chatMessage = cetcm[4];
		
		var listDiv = document.getElementById(chatn);
		if(listDiv!=null){
		listDiv.remove();
		}
		 
		 var startdiv = "<div id='"+chatn+"' class='dropdown'><div style='padding: 5px'></div>";
		 var button = "&nbsp;<button style='background-color:gray' class='btn btn-primary' type='button' id='dropdownMenuButton' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>";
		 var chatTitle = "<div  class='dropdown-toggle' id='chatTitle"+chatn+"'>"+ctitle+"</div></button>&nbsp;&nbsp;";
		 var chatCount1 = chatCount+"명<br>";
		 var chatContent = "&nbsp;<span>"+chatMessage+"</span>";
		 var buttonDropDown1 = "<div class='dropdown-menu' aria-labelledby='dropdownMenuButton'>"+"<a class='dropdown-item' href='#' onclick='openOldRoom("+chatn+")'>대화방 참여</a>";
		 var buttonDropDown2 = "<a class='dropdown-item' href='#' onclick='changeRoomTitle("+chatn+",chatTitle"+chatn+");'>방제목 변경</a></div></dvi>";
		
		 $('#chatrooms').prepend(startdiv+button+chatTitle+chatCount1+chatContent+buttonDropDown1+buttonDropDown2);
		 
	}
	return false;
};

function openProFile(empno2){
	var empNo2;
	if(typeof(empno2)==="number")
	empNo2 = empno2;
	else
	empNo2 = empno2.value;
	
	window.open("/hiapt/ch.profile?empno2="+empNo2,empNo2,"width=430,height=300"); 
	return false;
}

function openNewRoom(empno2){
	var empNo2;
	if(typeof(empno2)==="number")
	empNo2 = empno2;
	else
	empNo2 = empno2.value;
	
	webSocket.send("newRoom,"+empNo+","+empNo2);
	return false;
}

function openOldRoom(chatno){
	var chatNo = chatno;
	window.open("/hiapt/ch.message?empno="+empNo+"&chatno="+chatNo,chatNo,"width=600,height=380");
	return false;
}

function changeRoomTitle(chatno,chattitle){
	var chatNo = chatno;
	var roomTitle = prompt('바꾸실 방제목을 입력해주세요','');
	if(31<roomTitle.length){
		alert('제목 변경은 30글자 이내에서만 가능합니다.')
		return false;
	}
	if(roomTitle!=""&&roomTitle!=null){
	var crt = "crt:"+chatNo+":"+empNo+":"+roomTitle;
	webSocket.send(crt);
	chattitle.innerText=roomTitle;
	}else{
		alert("제목을 입력하셔야합니다");
	}
	return false;
}
</script>
</head>
<body onunload="SocketClose();">
<br>
<nav>	<div align="center">
	<button style="background-color:#849ada" class="btn btn-primary" id="bcp" onclick="viewbcp();">친구 목록</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button style="background-color:#849ada" class="btn btn-primary" id="bcr" onclick="viewbcr();">채팅 목록</button>
		</div>
</nav>
	<section>
		<div id="chatperson" style="display:"><!-- 친구목록 -->
			<br>
			<h3 style="display:inline" style="color: blue">
				&nbsp;<strong><%=employee.getEmpName()%>(나)</strong> 
			</h3> &nbsp;&nbsp;<i class="fas fa-user fa-2x"></i>
			<%for (ChatPerson cp : clist) {	%>
			<div class="dropdown">
				<input type="hidden" id="<%= cp.getEmpNo() %>" value="<%=cp.getEmpNo()%>">
				<div style="padding: 5px"></div>
				&nbsp;<button style="background-color:gray" class="btn btn-primary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">	<%=cp.getEmpName()%>
				</button><span class="onoff" id="on<%=cp.getEmpNo()%>"></span>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#" onclick="openNewRoom(<%=cp.getEmpNo()%>);">1:1대화</a> <a
					   class="dropdown-item" href="#" onclick="openProFile(<%=cp.getEmpNo()%>);">프로필보기</a>
				</div>
			</div>
			<% } %>
		</div>


		<div id="chatrooms" style="display: none"><!-- 채팅방목록 -->
				<%for(ChatMessage cm : cmlist){%>
				<div id="<%= cm.getChatNo() %>" class="dropdown">
					<div style="padding: 5px"></div>
					&nbsp;<button style="background-color:gray" class="btn btn-primary" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
						<%for(ChatRoomPerson crp : crplist) {%>
						<%if(cm.getChatNo()==crp.getChatNo() ) {%>
						<div class="dropdown-toggle" id="chatTitle<%= crp.getChatNo() %>"><%= crp.getChatTitle() %></div><!-- 채팅방제목 -->
						<%}} %>
					</button>&nbsp;&nbsp;
						<%for(int[] crpCount : crpCountlist) {%><!-- 채팅인원 -->
						<%if(crpCount[0] == cm.getChatNo()){ %><!-- crpcount0은 챗넘버에 1은 인원수 -->
						<%= crpCount[1] %>명
						<%}} %><br>
				&nbsp;<span><%= cm.getEmpName() %>:<%= cm.getChatContents() %></span>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="#" onclick="openOldRoom(<%= cm.getChatNo() %>)">대화방 참여</a>
					<a class="dropdown-item" href="#" onclick="changeRoomTitle(<%= cm.getChatNo() %>,chatTitle<%= cm.getChatNo() %>);">방제목 변경</a>
				</div>
				</div>
				<%} %>
		</div>

	</section>
</body>
</html>
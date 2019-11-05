<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="employee.model.vo.Employee, schedule.model.vo.Schedule"%>
<%
	Employee emp = (Employee)session.getAttribute("employee"); 
	Schedule sch = (Schedule)request.getAttribute("schedule"); 
 %>   
  
<!--복사 시작 ////////////////////////////--------------------->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HIAPTProject</title>

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
<script src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->

<style>
#intable tr th {
text-align:center;
}
</style>
<script type="text/javascript"src="/third/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
<% 
String type = sch. getSchType(); 
String color = sch.getSchBgColor(); 
String open = sch.getSchOpen();
String alarm = sch.getSchAlarm();
String memo = sch.getSchMemo();
String importance =  sch.getImportance();
String loginId = emp.getEmpNo();
String writer = sch.getWriter();
%>
function update(){
	location.href="/hiapt/schupview?snum=<%= sch.getSchNo() %>";
	return false;
}
function del(){
	var returnValue = window.confirm("해당 일정을 삭제하시겠습니까 ?");
	if(returnValue){
		location.href="/hiapt/schdel?snum=<%= sch.getSchNo() %>";
	}else{
		return;
	}	
	self.close();
	return true;
	
	
}

</script>
</head>

<body id="page-top" onunload="javascript:opener.document.location.reload();">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 



<!-- 왼쪽 메인 메뉴바 끝  --> 
<!-- ================================================================================= -->

<!--- 중앙 전체 큰 틀 ---------------------------------------------->
<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">
<!-- Main Content -->
<div id="content">

<!-- ================================================================================= -->
<!---탑메뉴  시작 =================---------------------------->

<!---탑 메뉴 끝 ------------------------------------------->
<!--========================================================================================== -->
<!-- Begin Page Content -->
<div class="container-fluid">
<!-- 본문 타이틀 들어가는 부분 ---->		


			
<!--///////본문 내용 시작 ///////-------->	
<br>
<h4 class="h4 mb-4 text-gray-800">일정 조회</h4>
<div text-align="center" class="card shadow mb-4">
<div class="card-body">
<!-- <h2 align="center"></h2> -->
<table class="table table-borderedz" id="intable">
<div align="right">
<%
if(writer.equals(loginId)){
%>	
<button class="btn btn-outline-warning btn-sm" onclick="update();">수정</button>
&nbsp;&nbsp;&nbsp;
<button class="btn btn-outline-danger btn-sm" onclick="del();">삭제</button>
&nbsp;&nbsp;&nbsp;

<%}%>
<input class="btn btn-outline-secondary btn-sm" type="button" value="닫기" onclick="window.close();">

</div>
<br>
<tr><th>일정 제목</th><td> <%= sch.getSchTitle() %></td></tr>
<tr><th>일정 구분</th><td>
<%if(type.equals("work")){ %>
업무
<%}else{ %>
개인일정
<%} %>
</td></tr>

<tr><th>시작 일자</th><td><%= sch.getSchStart() %></td></tr>
<tr><th>종료 일자</th><td><%= sch.getSchEnd() %></td></tr>

<tr><th>일정 메모</th><td>
<%if(memo == null){%>
내용 없음
<% }%></td></tr>
<tr><th>공개 여부</th><td>
<%
if(open.equals("Y")){%>
	공개
<%}else{%>
	비공개
<%}%>
</td></tr>
<tr><th>알람 여부</th><td>
<%
if(alarm.equals("Y")){%>
	설정
<%}else{%>
	미설정
<%}%>
<tr><th>색&nbsp;&nbsp;&nbsp;&nbsp;상</th><td>
<div style="display:inline-block; width:15px; height:15px; background-color:<%= sch.getSchBgColor() %>;"></div>
<%switch(color){
case "#D25565" :%>빨간색<% break;
case "#9775fa" :%>보라색<% break;
case "#ffa94d" :%>주황색<% break;
case "#74c0fc" :%>파란색<% break;
case "#f06595" :%>핑크색<% break;
case "#63e6be" :%>연두색<% break;
case "#a9e34b" :%>초록색<% break;
case "#4d638c" :%>남   색<% break;
}%>
</td></tr>
<tr><th>중 요 도</th><td>
<%if(importance.equals("1")){ %>
上
<%}else if(importance.equals("2")){ %>
中
<%}else{ %>
下
<%} %></td></tr>
<tr><th>작 성 자</th><td><%=writer %></td></tr>
</table>
	</div>
	</div>	
	
</div><!-- /.container-fluid -->				
</div><!-- End of Main Content -->	
<!---//// 본문 내용 끝 ///////------------------->
<!-- footer 시작 -->
<!-- footer 시작 -->
</div>	<!-- End of Content Wrapper -->
</div>	<!-- End of Page Wrapper -->	
<!--========================================================================================== -->
<!-- top 버튼 -->
<%@ include file = "../../common/topbutton.html" %>
<!--========================================================================================== -->
</body>
</html>
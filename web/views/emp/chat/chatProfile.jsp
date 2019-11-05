<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="chat.model.vo.ChatPerson" %>

<%
	ChatPerson chatPerson = (ChatPerson)request.getAttribute("chatperson");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필보기</title>

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

</head>
<body>

<div class="card shadow mb-4">
	<div class="card-body">
		<h2 align="center"><%= chatPerson.getEmpName() %>님의 프로필</h2>
		<table class="table table-bordered">
			<tr align="center"><th>이름</th><td><%= chatPerson.getEmpName() %></td></tr>
			<tr align="center"><th>직책</th><td><%= chatPerson.getEmpId() %></td></tr>
			<tr align="center"><th>전화번호</th><td><%= chatPerson.getEmpPhone() %></td></tr>
			<tr align="center"><th>이메일</th><td><%= chatPerson.getEmpEmail() %></td></tr>
		</table>
	</div>
</div>
</body>
</html>
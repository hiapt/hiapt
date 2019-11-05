<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vote.model.vo.VoteCheck, java.util.ArrayList" %>    
<%
	ArrayList<VoteCheck> vclist = (ArrayList<VoteCheck>)request.getAttribute("vclist");
	String voteSecret = (String)request.getAttribute("votesecret");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표인원체크</title>
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
	<br>
	<h2 align="center"><%if(voteSecret.equals("Y")) {%>
	유기명 투표입니다.
	<%}else{ %>
	무기명 투표입니다.
	<%} %>
	</h2>
	<br>
	<table class="table table-bordered">
	<tr align="center"><th>투표자</th><th>선택결과</th></tr>
	<%if(vclist.size()>0) {%>
	<%for(VoteCheck vc : vclist) {%>
	<tr align="center"><td><%= vc.getUserName() %></td>
	<%if(voteSecret.equals("Y")) {%>
	<td><%= vc.getVoteResult() %></td>
	<%}else{ %>
	<td>확인 불가(무기명 투표)</td></tr>
	<%}}} %>
	</table>
	</div>
	</div>
</body>
</html>
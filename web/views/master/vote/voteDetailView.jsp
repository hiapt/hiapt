<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vote.model.vo.Vote" %>
<%
	Vote vote = (Vote)request.getAttribute("vote");
	String vote1 = vote.getVoteOne();
	String vote2 = vote.getVoteTwo();
	String vote3 = vote.getVoteThree();
	String vote4 = vote.getVoteFour();
	String vote5 = vote.getVoteFive();
	String voteName[] = {vote1, vote2, vote3, vote4, vote5};

%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

$(function(){
 	var count = 0;
	<% for(int i=0; i<voteName.length; i++) {
	if(voteName[i]!=null){%>
	count++;
	<%}}%>
	$("#vbutton").click(function(){
		var voteCheck = $(":input[name=voteresult]:checked").val();
	$.ajax({
		url : "vo.vrUpdate",
		data : { voteresult : voteCheck, voteno : <%= vote.getVoteNo() %>,
					votecount : count},
		type : "post",
		dataType : "json",
		success : function(data){
			console.log("data : " + data);
			
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : " +textStatus);
		}
	});//아이작스
	return false;
	});//클릭
});//펑션

</script>
</head>
<body>

<table align="center" border="1">
<tr><th>제목</th><td><%= vote.getVoteTitle() %></td></tr>
<tr><th>작성자</th><td><%= vote.getVoteWrite() %></td></tr>
<tr><th>작성날짜</th><td><%= vote.getVoteDate() %></td></tr>
<tr><th>조회수</th><td><%= vote.getVoteReadCount() %></td></tr>
<tr><th>내용</th><td><%= vote.getVoteContents() %></td></tr>
<tr><th>투표목록</th><th>투표결과(확인)</th></tr>
<%for(int i=0; i<5; i++) {
		if(voteName[i]==null)
				break;
%><tr class="vtr"><th> 
	<%= voteName[i] %><input type="radio" name="voteresult" value="<%= i+1 %>" required>
		</th></tr>
<%} %>
<tr><td colspan="2"><button id="vbutton">확인</button></td></tr>

<tr><td colspan="2"><button onclick="javascript:window.history.go(-1);">목록</button></td></tr>
</table>
<div id="div4">

</div>

</body>
</html>
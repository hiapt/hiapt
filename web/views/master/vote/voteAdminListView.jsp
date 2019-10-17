<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="vote.model.vo.Vote, java.util.ArrayList"%>
<%
	ArrayList<Vote> vlist = (ArrayList<Vote>)request.getAttribute("vlist");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int pageSize = ((Integer)request.getAttribute("pageSize")).intValue();
	String titleName = (String)request.getAttribute("titlename");


%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->

<script type="text/javascript">
function voteWrite(){
	window.location.href="/hiapt/views/master/vote/voteAdminWriteForm.jsp";
	return false;
};	

</script>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 

<%@ include file ="../../common/empnavi.jsp" %>

<!-- 왼쪽 메인 메뉴바 끝  --> 

<!--- 중앙 전체 큰 틀 ---------------------------------------------->
<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">
<!-- Main Content -->
<div id="content">

<!-- ================================================================================= -->
<!---탑메뉴  시작 =================---------------------------->

<%@ include file ="../../common/empTopNavi.jsp" %>
<!---탑 메뉴 끝 ------------------------------------------->
<!--========================================================================================== -->
<!-- Begin Page Content -->
<div class="container-fluid">
				
<!--///////본문 내용 시작 ///////-------->	

	<h1 align="center">주민투표</h1>
	<br>
	<!-- 테이블 -->
	<div class="card shadow mb-4">
	<div class="card-body">
	<!-- 테이블시작 -->
	<div align="right">
		<form action="/hiapt/vo.list">
		찾을 제목 : 
		<input type="text" name="titlename">
		<input type="submit" value="찾기">&nbsp;
		</form>
		<button onclick="voteWrite();">작성하기</button>&nbsp;
	</div>

	<table class="table table-bordered" >
		<tr align="center">
			<th width = "80">글번호</th>
			<th>제목</th>
			<th width = "150" >작성자</th>
			<th width = "150" >작성일</th>
			<th width = "150" >투표마감일</th>
			<th width = "80" >조회수</th>
		</tr>
		<% for(Vote v : vlist){ %>
		<tr align="center">
			<td><%= v.getVoteNo() %></td>
			<td><a href="/hiapt/vo.view?vno=<%= v.getVoteNo() %>&page=<%= currentPage %>"><%= v.getVoteTitle() %></a></td>
			<td><%= v.getVoteWrite() %></td>
			<td><%= v.getVoteDate() %></td>
			<td><%= v.getVoteFinalDate() %></td>
			<td><%= v.getVoteReadCount() %></td>
		</tr>
		<%} %>
	</table>


	<div align="center">
	<%if(titleName != null) {%>
<a href ="/hiapt/vo.list?page=1&titlename=<%= titleName %>">|◁</a>&nbsp;
<% if((beginPage- pageSize)<=1) {%>
	<a href="/hiapt/vo.list?page=1&titlename=<%= titleName %>">◀◀</a>
<% }else{ %>
	<a href="/hiapt/vo.list?page=<%= beginPage-pageSize %>&titlename=<%= titleName %>">◀◀</a>
<% } %>&nbsp;
<% for(int p = beginPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<a href="/hiapt/vo.list?page=<%= p %>&titlename=<%= titleName %>"><font color="red"><b>[<%= p %>]</b></font></a>
<% }else{ %>
	<a href="/hiapt/vo.list?page=<%= p %>&titlename=<%= titleName %>"><%= p %></a>
<% }}  %> &nbsp;
<% if((endPage + pageSize) > maxPage){ %>
	<a href="/hiapt/vo.list?page=<%= maxPage %>&titlename=<%= titleName %>">▶▶</a>
<% }else{ %>
	<a href="/hiapt/vo.list?page=<%= beginPage + pageSize %>&titlename=<%= titleName %>">▶▶</a>
<% } %> &nbsp;
<a href="/hiapt/vo.list?page=<%= maxPage %>&titlename=<%= titleName %>">▷|</a>

<!-- titlename이 null일경우 -->
<%}else {%>
<a href ="/hiapt/vo.list?page=1&">|◁</a>&nbsp;
<% if((beginPage- pageSize)<=1) {%>
	<a href="/hiapt/vo.list?page=1&">◀◀</a>
<% }else{ %>
	<a href="/hiapt/vo.list?page=<%= beginPage-pageSize %>">◀◀</a>
<% } %>&nbsp;
<% for(int p = beginPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<a href="/hiapt/vo.list?page=<%= p %>"><font color="red"><b>[<%= p %>]</b></font></a>
<% }else{ %>
	<a href="/hiapt/vo.list?page=<%= p %>"><%= p %></a>
<% }}  %> &nbsp;
<% if((endPage + pageSize) > maxPage){ %>
	<a href="/hiapt/vo.list?page=<%= maxPage %>">▶▶</a>
<% }else{ %>
	<a href="/hiapt/vo.list?page=<%= beginPage + pageSize %>">▶▶</a>
<% } %> &nbsp;
<a href="/hiapt/vo.list?page=<%= maxPage %>">▷|</a>
<%} %>
</div>

<!-- 테이블틀끝 -->
</div>
</div>
<!---//// 본문 내용 끝 ///////------------------->
</div><!-- /.container-fluid -->				
</div><!-- End of Main Content -->	
<!---//// 본문 내용 끝 ///////------------------->
<!-- footer 시작 -->
<%@ include file = "../../common/empfooter.html" %>
<!-- footer 시작 -->
</div>	<!-- End of Content Wrapper -->
</div>	<!-- End of Page Wrapper -->	
<!--========================================================================================== -->
<!-- top 버튼 -->
<%@ include file = "../../common/topbutton.html" %>
<!--========================================================================================== -->

</body>
</html>



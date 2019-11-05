<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="complain.model.vo.Complain, java.util.ArrayList, aptuser.model.vo.Aptuser"%>
				
<%
	ArrayList<Complain> clist = (ArrayList<Complain>)request.getAttribute("clist");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int pageSize = ((Integer)request.getAttribute("pageSize")).intValue();
	String selectOption = (String)request.getAttribute("selectoption");
	String searchText = (String)request.getAttribute("searchtext");
%>

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->

<script type="text/javascript">


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

	<h1 align="center">민원관리</h1>
	<br>
	<!-- 테이블 -->
	<div class="card shadow mb-4">
	<div class="card-body">
	<!-- 테이블시작 -->
	<div align="right">
		<form action="/hiapt/co.list">
		<select name="selectoption">
			<option value="title">제목</option>
			<option value="uname">작성자</option>
		</select>
		<input type="text" name="searchtext">
		<input type="submit" value="찾기">&nbsp;
		</form>
	</div>

	<table class="table table-bordered">
	<tr>
			<th style="text-align:center" width = "80">글번호</th>
			<th style="text-align:center" >제목</th>
			<th style="text-align:center" width = "100" >작성자</th>
			<th style="text-align:center" width = "100" >답변상태</th>
			<th style="text-align:center" width = "100" >처리상태</th>
			<th style="text-align:center" width = "130" >작성일</th>
			
	</tr>
	
	<% for(Complain c : clist){ %>
		<tr align="center">
			<td><%= c.getCompNo() %></td>
			<%if(c.getCompSecret().equals("Y")){ %><!-- 비공개글  -->
			<td><a href="/hiapt/co.view?uporview=view&cno=<%= c.getCompNo() %>&page=<%= currentPage %>">비공개 글입니다.</a></td>			
			<%}else{%>
			<td><a href="/hiapt/co.view?uporview=view&cno=<%= c.getCompNo() %>&page=<%= currentPage %>"><%= c.getCompTitle() %></a></td>
			<%} %>
			<td>
			<%if(c.getCompNo()==1) {%>
			테스트
			<%}else{ %>
			<%= c.getUserName() %></td>
			<%} %>
			<%if(c.getCompReponse() == null) {%>
 			<td> 답변 대기 </td>
 			<%}else{%>
 			<td> 답변 완료 </td>
 			<%} %>
 			<%if(c.getCompResultStatus().equals("N")){ %>
 			<td> 처리 대기 </td>
 			<%}else{ %>
 			<td> 처리 완료 </td>
 			<%} %>
 			<td><%= c.getCompDate() %></td>
 			
		</tr>
		<%} %>
	</table>
	
	
<div align="center">
	<%if(selectOption != null) {%>
	<a href ="/hiapt/co.list?page=1&selectoption=<%= selectOption %>&searchtext=<%= searchText %>">|◁</a>&nbsp;
<% if((beginPage- pageSize)<=1) {%>
	<a href="/hiapt/co.list?page=1&selectoption=<%= selectOption %>&searchtext=<%= searchText %>">◀◀</a>
<% }else{ %>
	<a href="/hiapt/co.list?page=<%= beginPage-pageSize %>&selectoption=<%= selectOption %>&searchtext=<%= searchText %>">◀◀</a>
<% } %>&nbsp;
<% for(int p = beginPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<a href="/hiapt/co.list?page=<%= p %>&selectoption=<%= selectOption %>&searchtext=<%= searchText %>"><font color="red"><b>[<%= p %>]</b></font></a>
<% }else{ %>
	<a href="/hiapt/co.list?page=<%= p %>&selectoption=<%= selectOption %>&searchtext=<%= searchText %>"><%= p %></a>
<% }}  %> &nbsp;
<% if((endPage + pageSize) > maxPage){ %>
	<a href="/hiapt/co.list?page=<%= maxPage %>&selectoption=<%= selectOption %>&searchtext=<%= searchText %>">▶▶</a>
<% }else{ %>
	<a href="/hiapt/co.list?page=<%= beginPage + pageSize %>&selectoption=<%= selectOption %>&searchtext=<%= searchText %>">▶▶</a>
<% } %> &nbsp;
<a href="/hiapt/co.list?page=<%= maxPage %>&selectoption=<%= selectOption %>&searchtext=<%= searchText %>">▷|</a>

<%}else{ %><!--검색을안했을경우  -->
	<a href ="/hiapt/co.list?page=1&">|◁</a>&nbsp;
<% if((beginPage- pageSize)<=1) {%>
	<a href="/hiapt/co.list?page=1&">◀◀</a>
<% }else{ %>
	<a href="/hiapt/co.list?page=<%= beginPage-pageSize %>">◀◀</a>
<% } %>&nbsp;
<% for(int p = beginPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<a href="/hiapt/co.list?page=<%= p %>"><font color="red"><b>[<%= p %>]</b></font></a>
<% }else{ %>
	<a href="/hiapt/co.list?page=<%= p %>"><%= p %></a>
<% }}  %> &nbsp;
<% if((endPage + pageSize) > maxPage){ %>
	<a href="/hiapt/co.list?page=<%= maxPage %>">▶▶</a>
<% }else{ %>
	<a href="/hiapt/co.list?page=<%= beginPage + pageSize %>">▶▶</a>
<% } %> &nbsp;
<a href="/hiapt/co.list?page=<%= maxPage %>">▷|</a>

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



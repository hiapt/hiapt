<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.util.ArrayList, aptuser.model.vo.Aptuser"%>
				
<%
	ArrayList<Board> blist = (ArrayList<Board>)request.getAttribute("blist");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int pageSize = ((Integer)request.getAttribute("pageSize")).intValue();
%>
<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html" %>
<!-- head 끝  -->
<body>
<!-- navi 시작  -->
<%@ include file="../userheader.jsp" %>
<!-- navi 끝  -->

<!-- /// 본문 시작////// -->
<!-- 본문 제목 타이틀 부분 복사 시작 ===================================================================================-->
   <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="index2.jsp">Home</a></li>
          <li>자유게시판</li>
        </ul>
        <h2>자유게시판 목록</h2>
      </div>
    </div>
  </section>
  <!-- end post-wrapper-top -->
<!-- 본문 타이틀 복사 끝 ======================================================================================================-->
<section class="section1">
    <div class="container clearfix">
    
    <table class="table table-bordered">
	<tr>
			<th style="text-align:center" width = "80">글번호</th>
			<th style="text-align:center" >제목</th>
			<th style="text-align:center" width = "150" >작성자</th>
			<th style="text-align:center" width = "150" >작성일</th>
			<th style="text-align:center" width = "80" >조회수</th>
	</tr>
	
	<% for(Board b : blist){ %>
		<tr align="center">
			<td><%= b.getBoardNo() %></td>
			<td><%-- <a href="/hiapt/vo.ad.view?vno=<%= v.getVoteNo() %>&page=<%= currentPage %>"> --%><%= b.getBoardTitle() %><!-- </a> --></td>
			<td><%= b.getBoardWriter() %></td>
			<td><%= b.getBoardDate() %></td>
 			<td><%= b.getBoardReadCount() %></td>
		</tr>
		<%} %>
	</table>
	
	
	<div align="center">
	<a href ="/hiapt/bo.list?page=1&">|◁</a>&nbsp;
<% if((beginPage- pageSize)<=1) {%>
	<a href="/hiapt/bo.list?page=1&">◀◀</a>
<% }else{ %>
	<a href="/hiapt/bo.list?page=<%= beginPage-pageSize %>">◀◀</a>
<% } %>&nbsp;
<% for(int p = beginPage; p <= endPage; p++){ 
		if(p == currentPage){
%>
	<a href="/hiapt/bo.list?page=<%= p %>"><font color="red"><b>[<%= p %>]</b></font></a>
<% }else{ %>
	<a href="/hiapt/bo.list?page=<%= p %>"><%= p %></a>
<% }}  %> &nbsp;
<% if((endPage + pageSize) > maxPage){ %>
	<a href="/hiapt/bo.list?page=<%= maxPage %>">▶▶</a>
<% }else{ %>
	<a href="/hiapt/bo.list?page=<%= beginPage + pageSize %>">▶▶</a>
<% } %> &nbsp;
<a href="/hiapt/bo.list?page=<%= maxPage %>">▷|</a>
	
	
    </div>
    </div>
</section>




<!--  /// 본문 끝//////  -->
<!-- footer 시작 -->
 <%@ include file="../userfooter.jsp" %>
<!-- footer 끝  -->
 </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="vote.model.vo.Vote, java.util.ArrayList, aptuser.model.vo.Aptuser
				,java.util.*,java.text.*"%>
				
<%
	ArrayList<Vote> vlist = (ArrayList<Vote>)request.getAttribute("vlist");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int pageSize = ((Integer)request.getAttribute("pageSize")).intValue();
	String titleName = (String)request.getAttribute("titlename");
%>	
<%
	Date date =new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
	Date today = simpleDate.parse(sysdate);
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
          <li>주민투표</li>
        </ul>
        <h2>주민투표 목록</h2>
      </div>
    </div>
  </section>
  <!-- end post-wrapper-top -->
<!-- 본문 타이틀 복사 끝 ======================================================================================================-->

<section class="section1">
    <div class="container clearfix">
	<div align="right">
		<form action="/hiapt/vo.list">
		찾을 제목 : 
		<input type="text" name="titlename">
		<input type="submit" value="찾기">&nbsp;
		</form>
	</div>
<table class="table table-bordered">
	<tr>
			<th style="text-align:center" width = "80">글번호</th>
			<th style="text-align:center" >제목</th>
			<th style="text-align:center" width = "150" >작성자</th>
			<th style="text-align:center" width = "150" >작성일</th>
			<th style="text-align:center" width = "200" >투표마감일</th>
			<th style="text-align:center" width = "80" >조회수</th>
		</tr>
<% for(Vote v : vlist){ %>
		<tr align="center">
			<td><%= v.getVoteNo() %></td>
			<td><a href="/hiapt/vo.ad.view?vno=<%= v.getVoteNo() %>&page=<%= currentPage %>"><%= v.getVoteTitle() %></a></td>
			<td><%= v.getVoteWrite() %></td>
			<td><%= v.getVoteDate() %></td>
 			<%if(v.getVoteFinalDate().compareTo(today)>=0) {%> 
			<td><%= v.getVoteFinalDate() %>(진행중)</td>
			<%}else {%>
			<td><%= v.getVoteFinalDate() %>(마감됨)</td>
			<%} %> 
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



</div>
</section>


<!--  /// 본문 끝//////  -->
<!-- footer 시작 -->
 <%@ include file="../userfooter.jsp" %>
<!-- footer 끝  -->
 </body>
</html>
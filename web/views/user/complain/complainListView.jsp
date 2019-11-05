<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html" %>
<!-- head 끝  -->

<script type="text/javascript">
function complainWrite(){
	window.location.href="/hiapt/views/user/complain/complainWriteForm.jsp";
	return false;
};	

</script>
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
          <li>민원접수</li>
        </ul>
        <h2>민원접수 목록</h2>
      </div>
    </div>
  </section>
  <!-- end post-wrapper-top -->
<!-- 본문 타이틀 복사 끝 ======================================================================================================-->
<section class="section1">
    <div class="container clearfix">
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
			<th style="text-align:center" width = "150" >작성자</th>
			<th style="text-align:center" width = "100" >답변상태</th>
			<th style="text-align:center" width = "100" >처리상태</th>
			<th style="text-align:center" width = "100" >작성일</th>
			
	</tr>
	
	<% for(Complain c : clist){ %>
		<tr align="center">
			<td><%= c.getCompNo() %></td>
			<%if(c.getCompSecret().equals("Y")){ %>
			<%if(c.getUserId().equals(aptuser.getUserId())){ %>
			<td><a href="/hiapt/co.view?uporview=view&cno=<%= c.getCompNo() %>&page=<%= currentPage %>">비공개 글입니다.</a></td>
			<%}else{%>
			<td> 비공개 글입니다.</td>
			<%}}else{%>
			<td><a href="/hiapt/co.view?uporview=view&cno=<%= c.getCompNo() %>&page=<%= currentPage %>"><%= c.getCompTitle() %></a></td>
			<%} %>
			<td>
			<% if(c.getCompNo()==1) {%>
			테스트
			<%}else{ %>
			<%= c.getUserName() %>
			<%} %>
			</td>
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
	<div align="right">
	<button onclick="complainWrite();">작성하기</button>&nbsp;
	</div>
    </div>
</section>


<!--  /// 본문 끝//////  -->
<!-- footer 시작 -->
 <%@ include file="../userfooter.jsp" %>
<!-- footer 끝  -->
 </body>
</html>
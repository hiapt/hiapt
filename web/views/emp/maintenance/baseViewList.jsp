<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.BaseView, java.util.ArrayList" %>
<%
	ArrayList<BaseView> list = (ArrayList<BaseView>)request.getAttribute("list");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
%>

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 

<%@ include file ="../../common/empnavi.jsp" %>

<!-- 왼쪽 메인 메뉴바 끝  --> 
<!-- ================================================================================= -->

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

<!-- 본문 타이틀 들어가는 부분 ---->
<h1 class="h3 mb-4 text-gray-800">부과기초작업</h1>
<h6>전체 목록 : <%= list.size() %> 개</h6>
					
<!--///////본문 내용 시작 ///////-------->
<div class="card shadow mb-4">
<div class="card-body">
<!--  검색 -->
<form action="/first/bvsearch" method="post">
<input type="hidden" name="search" value="date" />
<label>부과년월 선택
<input type="date" name="date" value="date">
</label>
<input type="submit" value="검색">
</form>
<input type="">
<table class="table table-bordered">
	<thead>
		<tr>
			<th rowspan="2">삭제</th>
			<th rowspan="2">상태</th>
			<th rowspan="2">부과년월</th>
			<th colspan="2">산출기간</th>
			<th rowspan="2">납부마감일</th>
			<th rowspan="2">부과마감일</th>
			<th rowspan="2">마감횟수</th>
			<th rowspan="2">출력의뢰일시</th>
		</tr>
		<tr>
			<th>시작일</th>
			<th>종료일</th>
			
		</tr>
	</thead>
	<tbody>
	<% for(int i = 0; i < list.size(); i++){
		BaseView ba = list.get(i);
	%>
		<tr>
			<td>
				<label class="check">
				<input type="checkbox">
				<span class="checkmark"></span>
				</label>
			</td>
			<td><%= ba.getImposeStatus() %></td>
			<td><%= ba.getBillYearMonth() %></td>			
			<td><%= ba.getCalculateStartDay() %></td>
			<td><%= ba.getCalculateEndDay() %></td>
			<td><%= ba.getCutoffDate() %></td>
			<td><%= ba.getImposeEndDate() %></td>
			<td><%= ba.getImposeCount() %></td>
			<td><%= ba.getCutoffDate() %></td>			
		</tr>
	<% } %>
	</tbody>
</table>

<!-- pageing -->

		<div class="col-sm-12">
			<div class="paging_simple_numbers">
				<ul class="pagination" style="justify-content: center;">
					<li class="paginate_button page-item previous disabled"
						id="dataTable_previous"><a href="/hiapt/bvilis?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
					<% if((beginPage - 10) < 1){ %>
					<li class="paginate_button page-item previous back"
						id="dataTable_previous"><a href="/hiapt/bvilis?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } else { %>
					<li class="paginate_button page-item active back"
						id="dataTable_previous"><a href="/hiapt/bvilis?page=<%= beginPage -10 %>" aria-controls="dataTable"
						data-dt-idx="<%= beginPage - 10 %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } %>
					<% for(int p = beginPage; p <= endPage; p++){
						if(p == currentPage){	
					%>
					<li class="paginate_button page-item active next"><a href="/hiapt/bvilis?page<%= p %>"
						aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% } else { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvilis?page=<%= p %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% }} %>
					<% if((endPage + 10) > maxPage ) { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvilis?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } else { %>	
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvilis?page<%= endPage + 10 %>" aria-controls="dataTable" data-dt-idx="<%= endPage + 10 %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvilis?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;</a></li>
				</ul>
			</div>
		</div>
		
		<%-- <div id="pagebox" align="center">
		<a href="/hiapt/bwlist?page=1">|◁</a> &nbsp;
		<% if((beginPage - 10) < 1){ %>
		<a href="/hiapt/bwlist?page=1">◀◀</a>
		<% } else { %>
		<a href="/hiapt/bwlist?page=<%= beginPage - 10 %>">◀◀</a>
		<% } %> &nbsp;
		<% for(int p = beginPage; p <= endPage; p++){
			if(p == currentPage){
			%>
			<a href="/hiapt/bwlist?page=<%= p %>"><font color="red"><b>[ <%= p %> ]</b></font></a>
		<% } else { %>
		<a href="/hiapt/bwlist?page=<%= p %>"><%= p %></a>
		<% }} %> &nbsp;
		<% if((endPage + 10) > maxPage ){ %>
		<a href="/hiapt/bwlist?page=<%= maxPage %>">▶▶</a>
		<% } else { %>
		<a href="/hiapt/bwlist?page=<%= endPage + 10 %>">▶▶</a>
		<% } %> &nbsp;
		<a href="/hiapt/bwlist?page=<%= maxPage %>">▷|</a>
		</div>
		 --%>
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


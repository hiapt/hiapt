<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.BillView, java.util.ArrayList" %>
<%
	ArrayList<BillView> list = (ArrayList<BillView>)request.getAttribute("list");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
%>
<!-- 타이틀 시작 -->
<div class="row">
	<div id="breadcrumb" class="col-xs-12">
		<!-- 삼디다스 버튼 -->
		<a href="#" class="show-sidebar"> <i class="fa fa-bars"></i>
		</a>
		<ol class="breadcrumb pull-left">
			<!-- 첫번째 타이틀 시작 -->
			<li><a href="index.html">관리비</a></li>
			<!-- 두번째 하위 메뉴 시작 -->
			<li><a href="#">고지서조회</a></li>
			<!-- 세번째 하위 메뉴 시작 -->
			<!--li><a href="#">부과항목등록</a></li-->
		</ol>
	</div>
</div>
<!-- 타이틀 끝 -->
<!-- 고지서목록 -->
<div class="bs-callout bs-callout-info"
	id="callout-tabs-extends-component">
	<h4>고지서</h4><h6>전체 목록 : <%= list.size() %> 개</h6>
</div>
<br>
<table class="table table-borderedz">
	<thead>
		<tr>
			<th>고지서번호</th>
			<th>동/호</th>
			<th>부과금액</th>
			<th>미납액</th>
			<th>미납연체료</th>
			<th>납기내금액</th>
			<th>납기후금액</th>
		</tr>
	</thead>
	<tbody>
	<% for(BillView b : list){
	%>
		<tr>
			<td><%= b.getMerchantUid() %></td>
			<td><%= b.getUserId() %></td>			
			<td><%= b.getAmount() %></td>
			<td><%= b.getArrears() %></td>
			<td><%= b.getArrearsFine() %></td>
			<td><%= b.getBeforeAmount() %></td>
			<td><%= b.getAfterAmount() %></td>
		</tr>
	<% } %>
	</tbody>
</table>
<!-- pageing -->
<div class="row">
<div class="pagination-centered">
	<ul class="pagination main-menu">
		<li class="disabled"><a href="/hiapt/bwlist?page=1" aria-label="Previous"><span
				aria-hidden="true">&lsaquo;</span></a></li>
		<% if((beginPage - 10 ) < 1){ %>
		<li class="disabled"><a href="/hiapt/bwlist?page=1" aria-label="Previous"><span
				aria-hidden="true">«</span></a></li>
		<% } else { %>
		<li class="disabled"><a href="/hiapt/bwlist?page=<%= beginPage - 10 %>" aria-label="Previous"><span
				aria-hidden="true">«</span></a></li>
		<% } %>
		<% for(int p = beginPage; p <= endPage; p++){ 
			if( p == currentPage) {
		%>
		<li class="active"><a href="/hiapt/bwlist?page=<%= p %>" class="ajax-link">1 <span class="sr-only"><%= p %></span></a></li>
		<% } else { %>
		<li><a href="/hiapt/bwlist?page=<%= p %>" class="ajax-link"><%= p %></a></li>
		<% }} %>
		<% if((endPage + 10) > maxPage ){ %>
		<li><a href="/hiapt/bwlist?page=<%= maxPage %>" aria-label="Next"><span aria-hidden="true">»</span></a></li>
		<% } else { %>
		<li><a href="/hiapt/bwlist?page=<%= endPage + 10 %>" aria-label="Next"><span aria-hidden="true">»</span></a></li>
		<% } %>
		<li><a href="/hiapt/bwlist?page=<%= maxPage %>" aria-label="Next"><span aria-hidden="true">&rsaquo;</span></a></li>
	</ul>
</div>
</div>

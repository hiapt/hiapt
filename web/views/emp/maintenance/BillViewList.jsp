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

<%@ include file ="../../../head.html" %>

<%@ include file="../../../top.jsp" %>

<!-- 본문 타이틀 들어가는 부분 ---->
<h1 class="h3 mb-4 text-gray-800">제목 샘플</h1>
					
<!--///////본문 내용 시작 ///////-------->
<!-- 고지서목록 -->
<div class="bs-callout bs-callout-info"
	id="callout-tabs-extends-component">
	<h4>고지서</h4><h6>전체 목록 : <%= list.size() %> 개</h6>
</div>
<br>
<table class="table table-borderedz">
	<thead>
		<tr>
			<th>번호</th>
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
	<% for(int i = 0; i < list.size(); i++){
		BillView b = list.get(i);
	%>
		<tr>
			<td><%= i + 1 %></td>
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

		<div class="col-sm-12">
			<div class="paging_simple_numbers">
				<ul class="pagination" style="justify-content: center;">
					<li class="paginate_button page-item previous disabled"
						id="dataTable_previous"><a href="/hiapt/bwlist?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
					<% if((beginPage - 10) < 1){ %>
					<li class="paginate_button page-item previous back"
						id="dataTable_previous"><a href="/hiapt/bwlist?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } else { %>
					<li class="paginate_button page-item active back"
						id="dataTable_previous"><a href="/hiapt/bwlist?page=<%= beginPage -10 %>" aria-controls="dataTable"
						data-dt-idx="<%= beginPage - 10 %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } %>
					<% for(int p = beginPage; p <= endPage; p++){
						if(p == currentPage){	
					%>
					<li class="paginate_button page-item active next"><a href="/hiapt/bwlist?page<%= p %>"
						aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% } else { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bwlist?page=<%= p %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% }} %>
					<% if((endPage + 10) > maxPage ) { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bwlist?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } else { %>	
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bwlist?page<%= endPage + 10 %>" aria-controls="dataTable" data-dt-idx="<%= endPage + 10 %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bwlist?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
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
	

<!---//// 본문 내용 끝 ///////------------------->
<%@ include file="../../../footer.html" %>
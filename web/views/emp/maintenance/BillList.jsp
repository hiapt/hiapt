<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.Bill, java.util.ArrayList" %>
<%
	ArrayList<Bill> list = (ArrayList<Bill>)request.getAttribute("list");
	String message = (String)request.getAttribute("message"); 
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
<table class="table table-bordered">
	<thead>
		<tr>
			<th>고지서번호</th>
			<th>동/호</th>
			<th>부과금액</th>
			<th>미납액</th>
			<th>미납연체료</th>
			<th>납기내금액</th>
			<th>후연체료</th>
			<th>납기후금액</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>Tor</td>
			<td>http://torproject.org</td>
			<td>Anonymous network</td>
			<td>1</td>
			<td>Tor</td>
			<td>http://torproject.org</td>
			<td>Anonymous network</td>
		</tr>

	</tbody>
</table>
<!-- pageing -->
<nav aria-label="...">
	<ul class="pagination">
		<li class="disabled"><a href="#" aria-label="Previous"><span
				aria-hidden="true">«</span></a></li>
		<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
	</ul>
</nav>

<!--- 본문 내용 끝 ------------------->
<%@ include file = "../../../footer.html" %>
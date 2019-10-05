<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h4>고지서</h4>
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

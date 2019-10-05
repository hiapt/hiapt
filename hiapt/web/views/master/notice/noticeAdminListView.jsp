<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@page import="notice.model.vo.Notice, java.util.ArrayList" %>  --%>
<!-- ================================================================================= -->
<div class="row">
	<div id="breadcrumb" class="col-xs-12">
		<!-- 삼디다스 버튼 -->
		<a href="#" class="show-sidebar">
			<i class="fa fa-bars"></i>
		</a>
		<ol class="breadcrumb pull-left">
			<!-- 첫번째 타이틀 시작 -->
			<li><a href="/hiapt/login.jsp">홈페이지관리</a></li>
			<!-- 두번째 하위 메뉴 시작 -->
			<li><a href="#">공지사항</a></li>
			<!-- 세번째 하위 메뉴 시작 -->
			<!--li><a href="#">전월발생금액가져오기</a></li-->
		</ol>		
	</div>
</div>
<!-- ================================================================================= -->

<h1 align="center">공지사항</h1>
<br>

<div class="row">
	<div class="col-xs-12 ">
		<table class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Fireㅁㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㅇㄹ</td>
					<td>Mozilla</td>
					<td>Gecko</td>
					<td>Gecko</td>
				</tr>

			</tbody>
		</table>

	</div>
</div>



<script type="text/javascript">
$(document).ready(function() {
	// Drag-n-Drop feature
	WinMove();
});
</script>





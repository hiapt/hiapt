<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee, java.util.ArrayList" %>
<%
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer) request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	int count = ((Integer) request.getAttribute("count")).intValue();
%>

<!--복사 시작 ////////////////////////////--------------------->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HIAPTProject</title>

<!-- Custom fonts for this template-->
<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/hiapt/resources/css/basic.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->

<style>
.check {
	    display: inline-block !important;
}
</style>

<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function() {
	showDiv();

	$("select[name=searchselect]").on("change", function() {
		showDiv();
	});
});

function showDiv() {
	if ($("#searchselect option:eq(0)").is(":selected")) {
		$("#name").css("display", "block");
		$("#no").css("display", "none");
		$("#id").css("display", "none");
	}
	if ($("#searchselect option:eq(1)").is(":selected")) {
		$("#name").css("display", "none");
		$("#no").css("display", "block");
		$("#id").css("display", "none");
	}
	if ($("#searchselect option:eq(2)").is(":selected")) {
		$("#name").css("display", "none");
		$("#no").css("display", "none");
		$("#id").css("display", "block");
	}
	
}


$(function() {
	  $("#submitbtn").click(function(){
	        $("#searchform").submit();
	    });
	  $("#submitbtn2").click(function(){
	        $("#searchform2").submit();
	    });
	  $("#submitbtn3").click(function(){
	        $("#searchform3").submit();
	    });
});
</script>

</head>


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
<!-- 본문 타이틀 들어가는 부분 ---->		


			
<!--///////본문 내용 시작 ///////-------->	
<h1 class="btn btn-primary btn-icon-split" style=" width:100px; height:30px; text-align:center;" onclick="location.href='/hiapt/emplist'">직원 조회</h1>
<div class="card shadow mb-4">
<div class="card-body">

<div class="box-content">
<div style="float: right; display: flex;">
	<div>
		<select id="searchselect" name="searchselect"
			style="width: 100px; padding-left: 5px;"
			class="form-control form-control-sm">
			<option selected="selected">직원명</option>
			<option id="opt2">사번</option>
			<option id="opt3">직급</option>
		</select>
	</div>
	
	<div id="name">
		<form action="/hiapt/empsearch" method="get" id="searchform">
			<input type="hidden" name="search" value="name">
			<div class="input-group" style="margin-left: 5px;">
				<input type="text" id="search" name="keyword"
					class="form-control form-control-sm" placeholder="직원명을 입력하세요."
					style="width: 250px;">
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button" id="submitbtn">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<div id="no">
		<form action="/hiapt/empsearch" method="get" id="searchform2">
			<input type="hidden" name="search" value="no">
			<div class="input-group" style="margin-left: 5px;">
				<input type="text" id="search" name="keyword"
					class="form-control form-control-sm" placeholder="사번을 입력하세요."
					style="width: 250px;">
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button" id="submitbtn2">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<div id="id">
		<form action="/hiapt/empsearch" method="get" id="searchform3">
			<input type="hidden" name="search" value="id">
			<div class="input-group" style="margin-left: 5px;">
				<input type="text" id="search" name="keyword"
					class="form-control form-control-sm" placeholder="직급을 입력하세요."
					style="width: 250px;">
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button" id="submitbtn3">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	</div>
	</div>
	<br>	<br>
				
				
		<table class="table beauty-table table-hover"
			style="text-align: center;">
			<thead>
				<tr>
					<th width="10">
						<!-- <div class="checkbox" style="margin: 0px; margin-left: 10px;">
							<label> <input type="checkbox"> <i
								class="fa fa-square-o small"></i>
							</label>
						</div> -->
					</th>
					<th style="text-align: center;">사번</th>
					<th style="text-align: center;">이름</th>
					<th style="text-align: center;">직급</th>
					<% if(emp != null && emp.getEmpId().equals("관리자")){ %>
					<th style="text-align: center;">입사년도</th>
					<% }else{ %>
					<% } %>
					<th style="text-align: center;">휴대전화</th>
					<!-- <th style="text-align: center;"></th> -->
					<th style="text-align: center;">이메일</th>
					<% if(emp != null && emp.getEmpId().equals("관리자")){ %>
					<th style="text-align: center;">급여명세서</th>
					<th style="text-align: center;">상세정보</th>
					<% }else{ %>
					<% } %>
				</tr>
			</thead>
			<%
			for(int i = 0; i < list.size(); i++) { 
				Employee e = list.get(i);
			%>
			<tr>
				<td><%= i + 1 %></td>
				<td><%= e.getEmpNo() %></td>
				<td><%= e.getEmpName() %></td>
				<td><%= e.getEmpId() %></td>
				<% if(emp != null && emp.getEmpId().equals("관리자")){ %>
				<td><%= e.getEmpHireDate() %></td>
				<% }else{ %>
					<% } %>
				<td>
				<% if(e.getEmpPhone() != null) { %>
				<%= e.getEmpPhone() %>
				<% }else{ %>
				<% } %></td>
				<td>
				<% if(e.getEmpEmail() != null) { %>
				<%= e.getEmpEmail() %>
				<% }else{ %>
				
				<% } %></td>
				
				<% if(emp != null && emp.getEmpId().equals("관리자")){ %>
				<td><a href="/hiapt/salary?empno=<%= e.getEmpNo() %>">보기</a></td>
				<td><a href="/hiapt/empdetail?empno=<%= e.getEmpNo() %>">보기</a></td>
				<% }else{ %>
				<% } %>
			</tr>
			<% } %>
		</table>




			<div class="col-sm-12">
				<div class="paging_simple_numbers">
					<ul class="pagination" style="justify-content: center;">
						<li class="paginate_button page-item previous"
							id="dataTable_previous">
							<a href="/hiapt/emplist?page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
						<%
							if ((beginPage - 10) < 1) {
						%>
						<li class="paginate_button page-item previous back"
							id="dataTable_previous">
							<a href="/hiapt/emplist?page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item active back"
							id="dataTable_previous">
							<a href="/hiapt/emplist?page=<%=beginPage - 10%>"
							aria-controls="dataTable" data-dt-idx="<%=beginPage - 10%>"
							tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							}
						%>
						<%
							for (int p = beginPage; p <= endPage; p++) {
								if (p == currentPage) {
						%>
						<li class="paginate_button page-item active next">
						<a href="/hiapt/emplist?page=<%=p%>"
							aria-controls="dataTable" data-dt-idx="<%=p%>" tabindex="0"
							class="page-link"><%=p%></a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/emplist?page=<%=p%>"
							aria-controls="dataTable" data-dt-idx="<%=p%>" tabindex="0"
							class="page-link"><%=p%></a></li>
						<%
							}
							}
						%>
						<%
							if ((endPage + 10) > maxPage) {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/emplist?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/emplist?page=<%=endPage + 10%>"
							aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							}
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/emplist?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;</a></li>
					</ul>
				</div>
			</div>
			
		</div>
</div>
			

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
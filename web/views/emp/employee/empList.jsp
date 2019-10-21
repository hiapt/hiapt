<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="employee.model.vo.Employee, java.util.ArrayList" %>
<%
	ArrayList<Employee> list = (ArrayList<Employee>)request.getAttribute("list");
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

</head>

<script type="text/javascript"></script>
<script>
function formview() {
	   var width = '1000';
	   var height = '600';
	   var left = Math.ceil((window.screen.width - width) / 2);
	   var top = Math.ceil((window.screen.width - height) / 2);
	   
	   window.open('/hiapt/salary', '문서보기', 'width=' + width + ', height=' + height + ', left=' + left + ', top' + top);
	   
}
</script>

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
<h1 class="h3 mb-4 text-gray-800">직원 조회</h1>
<div class="card shadow mb-4">
<div class="card-body">

<div class="box-content">
	<div class="input-group" style ="width: 25%;  float: right;">
				<input type="text" class="form-control input-lg" placeholder="사번 검색">
				<span class="input-group-btn">
					<button class="btn btn-primary" type="button">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
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
					<th style="text-align: center;">입사년도</th>
					<th style="text-align: center;">휴대전화</th>
					<!-- <th style="text-align: center;"></th> -->
					<th style="text-align: center;">이메일</th>
					<th style="text-align: center;">급여명세서</th>
					<th style="text-align: center;">상세정보</th>
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
				<td><%= e.getEmpHireDate() %></td>
				<td><%= e.getEmpPhone() %></td>
				<td><%= e.getEmpEmail() %></td>
				<td><button onclick="formview();" class="btn btn-secondary btn-icon-split btn-sm" style="padding: 4px;">보기</button></td>
				<td><a href="/hiapt/empdetail?empno=<%= e.getEmpNo() %>">보기</a></td>
			</tr>
			<% } %>
		</table>


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
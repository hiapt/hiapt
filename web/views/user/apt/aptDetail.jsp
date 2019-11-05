<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "employee.model.vo.Employee" import="aptuser.model.vo.Aptuser"%>
<% 
	Aptuser aptuser = (Aptuser)request.getAttribute("aptdetail");
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

/* #navi{
	height: 30px;
	/* width: 110px; */
	display: block;
	font-family:"굴림";
	font-weight:600;
	font-size:14px;
	padding: 5px 25px;
	margin : 5px 25px;
	color: white;
	background: #365873;
	text-decoration: none;
} */

#userid{
	background : lightgray;
}

th{
	text-align: center;
}

#aptuser{
	padding-left: 10px;
}

#date, #job {
	height:25px;
}
</style>

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
<h1 class="btn btn-primary btn-icon-split" style=" width:130px; height:30px; text-align:center;">세대주 상세정보</h1>

<div class="card shadow mb-4">
<form action="/hiapt/empupdate" method="post">
<table class="table table-bordered dataTable">

<tr><th style="text-align:center; width:150px;">동/호수</th>
<td id="aptuser"><%= aptuser.getUserId() %></td>

<tr><th style="text-align:center;">세대주명*</th>
<td id="aptuser"><%= aptuser.getUserName() %></td></tr>

<tr><th style="text-align:center;">입주일</th>
<td><%= aptuser.getUserEnroll() %></td></tr>

<tr><th style="text-align:center;">생년월일</th>
<td id="aptuser"><%= aptuser.getUserBirth() %></td></tr>

<tr><th style="text-align:center;">전화번호</th>
<td id="aptuser"><%= aptuser.getUserPhone() %></td></tr>

<tr><th style="text-align:center;">이메일</th>
<td id="aptuser"><%= aptuser.getUserEmail() %></td></tr>

<tr><th style="text-align:center;">기타정보</th>
<td id="aptuser"><%= aptuser.getUserEtc() %></td></tr>

<tr><th style="text-align:center;">차량번호</th>
<td id="aptuser"><%= aptuser.getCarNo() %></td></tr>

<tr><th style="text-align:center;">차량등록일</th>
<td id="aptuser"><%= aptuser.getCarEnroll() %></td></tr>
	 


<tr>
	
	<th colspan="2">
		<input type="button" value="수정하기"  class="btn btn-primary btn-icon-split" style=" width:70px; height:30px; text-align:center;"
		onclick="location.href='/hiapt/aptupdate?userid=<%= aptuser.getUserId() %>'"> &nbsp;
		<input type="button" value="이전으로" class="btn btn-primary btn-icon-split" style=" width:70px; height:30px; text-align:center;"
		onclick="location.href='javascript:history.go(-1);'">&nbsp;
		<% if(emp != null && emp.getEmpId().equals("관리자")){ %>
		<input type="button" value="삭제하기"  class="btn btn-primary btn-icon-split" style=" width:70px; height:30px; text-align:center;"
		onclick="location.href='/hiapt/aptdelete?userid=<%= aptuser.getUserId() %>'"> 
		
	</th>
	<% }else{ %>
	<% } %>
</tr>

</table>
</form>
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
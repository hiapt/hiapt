<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "employee.model.vo.Employee"%>
<% 
	Employee employee = (Employee)request.getAttribute("empsalary");
%> 
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

th{
	text-align: center;
}

#employee{
	padding-left: 10px;
}

#date, #job {
	height:25px;
}
</style>

</head>


<script type="text/javascript"></script>
<script>

function info_print() {
    // 안보이게 할 영역 숨기기
    $("#hide").hide();
    
    //인쇄
    var initBody = document.body.innerHTML;
    window.onbeforeprint = function () {
       document.body.innerHTML = document.getElementById("#print").innerHTML;
    }
    window.onafterprint = function () {

       document.body.innerHTML = initBody;
    }
    window.print();
    
    // 인쇄창 끄면 다시 보이게
    $("#hide").show();
 }
</script>


<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- ================================================================================= -->

<!--- 중앙 전체 큰 틀 ---------------------------------------------->
<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">
<!-- Main Content -->
<div id="content">

<!--========================================================================================== -->
<!-- Begin Page Content -->
<div class="container-fluid">
<!-- 본문 타이틀 들어가는 부분 ---->		


			
<!--///////본문 내용 시작 ///////-------->	
<div class="card shadow mb-4" id="print">
<div class="card-body">

<div style="text-align: center; width: 900px; color: #214c70; " >
<h2 >급여명세서</h2><br>

<table style="width:900px; height: 50px;" >

<tr>
<th style="text-align:center; width:150px;">사번</th>
<td><%= employee.getEmpNo() %></td>
<th>이름</th>
<td><%= employee.getEmpName() %></td>
</tr>

<tr>
<th>직급 </th>
<td><%= employee.getEmpId() %></td>
<th></th>
<td></td>
</tr>

</table>

</div>
</div>	
</div>

</div><!-- /.container-fluid -->				
</div><!-- End of Main Content -->	
<!---//// 본문 내용 끝 ///////------------------->

</div>	<!-- End of Content Wrapper -->
</div>	<!-- End of Page Wrapper -->	
<!--========================================================================================== -->
<!-- top 버튼 -->
<%@ include file = "../../common/topbutton.html" %>
<!--========================================================================================== -->
</body>
</html>
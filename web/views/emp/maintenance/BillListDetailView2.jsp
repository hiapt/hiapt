<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	<script
		src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->



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
<h1 class="h3 mb-4 text-gray-800">관리비 상세목록</h1>			
<!--///////본문 내용 시작 ///////-------->	
<div class="card shadow mb-4">
<div class="card-body">


 <br>
<table class="table table-bordered">
	<thead>
		<tr>
			<th colspan="2" class="danger">전기 에너지</th>
			<th>000000원</th>
			<th colspan="2" class="danger">열 에너지</th>
			<th>000000원</th>
		</tr>		
	</thead>
	<tr>
			<td colspan="2" style="text-align:right;">세대전기료</td>
			<td></td>
			<td colspan="2" style="text-align:right;">난방사용료</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">공동전기료</td>
			<td></td>
			<td colspan="2" style="text-align:right;">온수사용료</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">Tv수신료</td>
			<td></td>
			<td colspan="3"></td>
		</tr>
		<tr class="">
			<th colspan="6" class="primary">전년동월과 당월비교</th>			
		</tr>
		<tr>
			<th class="active"></th>
			<th>전년 사용량</th>
			<th>사용요금</th>
			<th>당월 사용량</th>
			<th>사용요금</th>
			<th></th>
		</tr>
		<tr>
			<th class="active">전기</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th class="active">온수</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th class="active">수도</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th class="active">난방</th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<th colspan="2" style="font-size:13pt; text-align:center; color:black; background:#fff;">2019년 9월</th>
			<th colspan="2" style="font-size:13pt; text-align:center; color:black; background:#fff;">101동101호</th>
			<th colspan="2" style="font-size:13pt; text-align:center; color:black; background:#fff;">홍길동 귀하</th>
		</tr>
	<tbody>
		<tr>
			<td>일반관리비</td>
			<td>22222원</td>
			<th colspan="2" class="warning">전기사용료</th>
			<th>당월부과액</th>
			<td>2222222원</td>
		</tr>
		<tr>
			<td>청소비</td>
			<td>22222원</td>
			<td>세대전기료</td>
			<td>222222원</td>
			<th>미납액</th>
			<td>0</td>
		</tr>
		<tr>
			<td>소독비</td>
			<td>22222원</td>
			<td>공동전기료</td>
			<td>222222원</td>
			<th>미납연체료</th>
			<td>0</td>
		</tr>
		<tr>
			<td>승강기유지비</td>
			<td>22222원</td>
			<td>Tv수신료</td>
			<td>222222원</td>
			<th>납기후 연체료</th>
			<td>0</td>
		</tr>
		<tr>
			<td>수선유지비</td>
			<td>22222원</td>
			<th colspan="4" class="active"></th>
		</tr>
		<tr>
			<td>장기수선충당금</td>
			<td>22222원</td>
			<th colspan="2" class="primary">수도사용료</th>
			<th colspan="2">관리비 납입계좌번호</th>	
		</tr>
		<tr>
			<td>음식물수거료</td>
			<td>22222원</td>
			<td>세대수도료</td>
			<td>222222원</td>
			<td>신한은행</td>
			<td>0</td>
		</tr>
		<tr>
			<td>경비비</td>
			<td>22222원</td>
			<td>공동수도료</td>
			<td>222222원</td>
			<td>국민은행</td>
			<td>0</td>
		</tr>
		<tr>
			<td>화재보험료</td>
			<td>22222원</td>
			<td colspan="2" class="active"></td>
			<td>하나은행</td>
			<td>0</td>
		</tr>
		<tr>
			<td>위탁관리수수료</td>
			<td>22222원</td>
			<td colspan="2" class="active"></td>
			<td>우리은행</td>
			<td>0</td>
		</tr>
		<tr>
			<th class="danger" style="text-align:center;">납기내</th>				
			<th rowspan="2" colspan="2" style="font-size:20pt; text-align:center; line-height:40pt;">34588원</th> 
			<th class="danger" style="text-align:center;">납기후</th>
			<th rowspan="2" colspan="2" style="font-size:20pt; text-align:center; line-height:40pt;">34588원</th> 
		</tr>
		<tr>
		<th class="active" style="text-align:center;">까지</th>	
		<th class="active" style="text-align:center;">까지</th>
		</tr>
		
	</tbody>
</table>


</div></div>
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
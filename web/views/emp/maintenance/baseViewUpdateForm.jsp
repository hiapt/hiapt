<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.BaseView, java.util.ArrayList"%>
<%
 BaseView bview = (BaseView)request.getAttribute("bview");
%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>HIAPTProject</title>

<!-- Custom fonts for this template-->
<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/hiapt/resources/css/basic.css" rel="stylesheet">

<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<style>
.form-control2 {
	display: block;
	width: 87%;
	height: calc(1.5em + .75rem + 2px);
	padding: .375rem 0rem;
	font-size: .8rem;
	font-weight: 300;
	line-height: 1.5;
	color: #6e707e;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid #d1d3e2;
	border-radius: .35rem;
	transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}
</style>
<!--// css or jQuery or javaScript 삽입 부분    -->
<script type="text/javascript">
function validation(){
	return true;	
}
</script>


</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- 왼쪽 메인 메뉴바 시작 -->

		<%@ include file="../../common/empnavi.jsp"%>

		<!-- 왼쪽 메인 메뉴바 끝  -->
		<!-- ================================================================================= -->

		<!--- 중앙 전체 큰 틀 ---------------------------------------------->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">

				<!-- ================================================================================= -->
				<!---탑메뉴  시작 =================---------------------------->

				<%@ include file="../../common/empTopNavi.jsp"%>
				<!---탑 메뉴 끝 ------------------------------------------->
				<!--========================================================================================== -->
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!--///////본문 내용 시작 ///////-------->

					<!-- 본문 타이틀 들어가는 부분 ---->
					<h1 class="h3 mb-4 text-gray-800">부과기초작업</h1>
					<%-- <h6>
						전체 목록 :<%= list.size() %>개
					</h6> --%>

					<!--///////본문 내용 시작 ///////-------->
					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="card-title" style="float: right;">
								<form action="/hiapt/bviin" method="post" onclick="return validation();" class="form">									
									<input type="submit" value="저장" class="btn btn-sm btn-danger shadow-sm">&nbsp;
									<input type="reset" value="취소" class="btn btn-sm btn-secondary shadow-sm" >&nbsp;
									<a href="javascript:history.go(-1);" class="btn btn-sm btn-primary shadow-sm" >이전페이지로 이동</a>&nbsp;
							<br>
							</div>
							<br> <br>


							<div class="table-responsive-sm">
								<table class="table table-bordered" id="BaseView">
									<thead>
										<tr class="header">
											<!-- <th rowspan="2">삭제
										</th> -->
											<th>선택</th>
											<th rowspan="2">상태</th>
											<th rowspan="2">고지서번호<span class="text-danger">*<br>
													<small>자동부과</small></span></th>
											<th rowspan="2">부과년월</th>
											<th colspan="2">산출기간</th>
											<th rowspan="2">납부마감일</th>
											<th rowspan="2">부과마감일</th>
											<th rowspan="2">마감횟수</th>
											<th rowspan="2">출력의뢰일시</th>
										</tr>
										<tr class="header">
											<th><label class="check"> <input type="checkbox"
													class="custom-control-input" id="th_checkAll"
													onclick="checkAll();"> <span
													class="checkmark center-block"></span></th>
											<th>시작일</th>
											<th>종료일</th>
										</tr>
									</thead>
									<tbody>
										<tr class="data">
											<td></td>
											<td style="padding-right: 0;"><input
												class="form-control2 input-sm" type="text"
												name="imposeStatus" id="imposeStatus" value=""
												placeholder="상태"></td>
											<td placeholder="고지서번호"></td>'
											<td style="padding-right: 0;"><input type="date"
												class="form-control2 input-sm" name="billYearMonth"
												id="billYearMonth" value="" placeholder="부과년월"
												min="2019-01-01"></td>
											<td style="padding-right: 0;"><input type="date"
												class="form-control2 input-sm" name="calculateStartDay"
												id="calculateStartDay" value="" placeholder="산출기간시작일"
												min="2019-01-01"></td>
											<td style="padding-right: 0;"><input type="date"
												class="form-control2 input-sm" name="calculateEndDay"
												id="calculateEndDay" value="" placeholder="산출기간종료일"
												min="2019-01-01"></td>
											<td style="padding-right: 0;"><input type="date"
												class="form-control2 input-sm" name="imposeEndDate"
												id="imposeEndDate" value="" placeholder="납부마감일"
												min="2019-01-01"></td>
											<td style="padding-right: 0;"><input type="date"
												class="form-control2 input-sm" name="cutoffDate"
												id="cutoffDate" value="" placeholder="부과마감일"
												min="2019-01-01"></td>
											<td style="padding-right: 0;"><input type="number"
												class="form-control2 input-sm" name="imposeCount"
												id="imposeCount" value="" placeholder="마감횟수" min="0"></td>
											<td style="padding-right: 0;"><input type="date"
												class="form-control2 input-sm" name="acceptDate"
												id="acceptDate" value="" placeholder="출력의뢰일시"
												min="2019-01-01"></td>
										</tr>
									</tbody>

								</table>
								</form>
							</div>

						</div>
						<!-- . shadow mb-4 -->
					</div>
					<!-- .card-body -->


					<!---//// 본문 내용 끝 ///////------------------->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<!---//// 본문 내용 끝 ///////------------------->
			<!-- footer 시작 -->
			<%@ include file="../../common/empfooter.html"%>
			<!-- footer 시작 -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<!--========================================================================================== -->
	<!-- top 버튼 -->
	<%@ include file="../../common/topbutton.html"%>
	<!--========================================================================================== -->
	<script src="/hiapt/resources/js/jquery.tabletojson.min.js"></script>
</body>
</html>


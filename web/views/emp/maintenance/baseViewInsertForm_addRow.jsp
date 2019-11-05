<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.BaseView, java.util.ArrayList"%>

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
 function callFunction(){
	 window.location.href ="/hiapt/views/emp/maintenance/BillViewInsertForm.jsp";
	 return false; // 다른 이벤트 전달 막기
 }
 function callFunction4(){
	 window.location.href ="/hiapt/views/emp/maintenance/baseViewInsertForm_addRow.jsp";
	 return false; // 다른 이벤트 전달 막기
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
								<form action="/hiapt/bviin2" method="post" class="form">

									<button name="addRow"
										class="btn btn-sm btn-outline-success shadow-sm">행추가</button>
									<button type="button" id="save"
										class="btn btn-sm btn-outline-danger shadow-sm">저장</button>
									<!-- <button onclick="callUp();"
										class="btn btn-sm btn-outline-danger shadow-sm">수정</button> -->
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
									</tbody>
							
								</table>
								</form>
							</div>

 <script type="text/javascript">
//추가버튼
 var count = 0;
 var fullcount = 1;
 
	$(document).on(	"click", "button[name=addRow]",	function(){
		
		/*갯수 체크 */
		count++;
		console.log(count);
		if(count > fullcount){
			alert("최대 1개까지만 가능합니다.");
			count = 5;
			return false;
		} else {
			
			var addRowText = '<tr class="data1">'
			+ '<td><button class="btn btn-sm btn-outline-danger shadow-sm" name="delImpose"><small>삭제</small></button></td>'
			+ ' <td style="padding-right:0;"><input class="form-control2 input-sm" type="text" name="imposeStatus" id="imposeStatus" value="" placeholder="상태"></td> '
			+ '<td placeholder="고지서번호"></td>'
			+ '<td style="padding-right:0;"><input type="date" class="form-control2 input-sm" name="billYearMonth" id="billYearMonth" value="" placeholder="부과년월" min="2019-01-01"></td>'
			+ '<td style="padding-right:0;"><input type="date" class="form-control2 input-sm" name="calculateStartDay" id="calculateStartDay" value="" placeholder="산출기간시작일" min="2019-01-01"></td>'
			+ '<td style="padding-right:0;"><input type="date" class="form-control2 input-sm" name="calculateEndDay" id="calculateEndDay" value="" placeholder="산출기간종료일" min="2019-01-01"></td>'
			+ '<td style="padding-right:0;"><input type="date" class="form-control2 input-sm" name="imposeEndDate" id="imposeEndDate" value="" placeholder="납부마감일" min="2019-01-01"></td>'
			+ '<td style="padding-right:0;"><input type="date" class="form-control2 input-sm" name="cutoffDate" id="cutoffDate" value="" placeholder="부과마감일" min="2019-01-01"></td>'
			+ '<td style="padding-right:0;"><input type="number" class="form-control2 input-sm" name="imposeCount" id="imposeCount" value="" placeholder="마감횟수" min="1"></td>'
			+ '<td style="padding-right:0;"><input type="date" class="form-control2 input-sm" name="acceptDate" id="acceptDate" value="" placeholder="출력의뢰일시" min="2019-01-01"></td>'
			+ '</tr>';

								
				//var trHtml = $("tr[name=trimpose]:last"); // last를 사용하여 trImpose 라는 명을 가진 마지막 태그 호출
				//trHtml.after(addRowText);
				$("table tbody").append(addRowText);

				return false;
				
				
		}// end if;
		
		
		});
	
	
	 // 행삭제
	$(document).on("click", "button[name=delImpose]", function() {
		var trHtml = $(this).parent().parent();
		console.log(trHtml);
		trHtml.remove(); // tr태그 삭제
	});
	
//  $("#changeBtn").click(function(){ 
$("#save").click(function(){
	var data = { imposeStatus : $("#imposeStatus").val() ,  billYearMonth : $("#billYearMonth").val() ,
			 calculateStartDay : $("#calculateStartDay").val() , calculateEndDay : $("#calculateEndDay").val() ,
				imposeEndDate : $("#imposeEndDate").val() ,  acceptDate : $("#acceptDate").val() ,
				cutoffDate : $("#cutoffDate").val() ,  imposeCount : $("#imposeCount").val() }; 
	console.log(data);

		$.ajax({
			 url : "/hiapt/bviin2",
			 type : "post",
			 data : data , 
			 dataType : "json",
			 success : function(data){
				 console.log("data : " + data);
				 var jsonStr = JSON.stringify(data);
				 var json = JSON.parse(jsonStr);
				 
				 var values = "";
				 for(var i in json.list){
					 values += '<tr class="data2">'
						+ '<td><a href="href="/hiapt/bidv?merchantUid="' + json.list[i].merchantUid  
						+ '">상세보기</a></td>'
						+ '<td>' + decodeURIComponent(json.list[i].imposeStatus).replace(/\+/gi, ' ') + '</td> '
						+ '<td>' + json.list[i].merchantUid + '</td>'
						+ '<td>' + json.list[i].billYearMonth + '</td>'
						+ '<td>' + json.list[i].calculateStartDay + '</td>'
						+ '<td>' + json.list[i].calculateEndDay + '</td>'
						+ '<td>' + json.list[i].imposeEndDate + '</td>'
						+ '<td>' + json.list[i].cutoffDate + '</td>'
						+ '<td>' + json.list[i].imposeCount + '</td>'
						+ '<td>' + json.list[i].acceptDate + '</td>'
						+ '</tr>';
				 } // end for
				 $("table tbody").prepend(values);
			 }, 
			 error : function( jqXHR, textStatus, errorThrown ){ 
				 console.log("error : " + textStatus);
			 } 
			 
		 });
		
		$(".data1").remove();
		
	 }); 
	 

 </script>

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


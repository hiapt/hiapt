<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="employee.model.vo.Employee, java.util.ArrayList"%>
<%
	String code = new String("write");
	ArrayList<Employee> list = (ArrayList<Employee>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>HIAPTProject</title>

<!-- Custom fonts for this template-->
<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/hiapt/resources/css/basic.css" rel="stylesheet">
<style>
.listtosel {
	overflow: hidden;
	margin-top: 34px; /* width:700px; */
}

.listtosel h2 {
	font-family: 'nngb';
	font-size: 13px;
}

.listtosel .schlist {
	float: left;
	width: 243px;
}

.listtosel .ctrl {
	float: left;
	margin: 0 26px;
	padding: 60px 0 0 0;
	text-align: center;
}

.listtosel .ctrl a {
	display: block;
}

.listtosel .ctrl .first {
	margin-bottom: 17px;
}

.listtosel .ctrl .second {
	margin-bottom: 4px;
}

.listtosel .ctrl .last {
	margin-top: 17px;
}

.listtosel .sellist {
	float: left;
	width: 243px;
}

.listtosel select {
	border: 1px solid #c5cfd8;
	width: 100%;
	height: 209px;
	padding: 14px 0;
	margin-top: 8px;
}

.listtosel option {
	padding: 0 8px;
}

.listtosel option:selection {
	background: #e7edf6;
}
</style>
<!-- Page level plugins -->
	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
	
<!-- Page level plugins -->
<script type="text/javascript"
	src="/hiapt/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		//전역변수선언
		var editor_object = [];

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : editor_object,
			elPlaceHolder : "smarteditor",
			sSkinURI : "/hiapt/resources/smarteditor/SmartEditor2Skin.html",
			fCreator: "createSEditor2",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : false,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		var a ="";
		//전송버튼 클릭이벤트
		$("#savebutton").click(
				
				
				function() {
					//id가 smarteditor인 textarea에 에디터에서 대입
					editor_object.getById["smarteditor"].exec(
							"UPDATE_CONTENTS_FIELD", []);

					// 이부분에 에디터 validation 검증
					if($("#recipient").val == ""){
						alert("받는사람을 입력해주세요.");
						return false;
					}
					
					//폼 submit
					$("#frm").submit();
				})

		//전송버튼 클릭이벤트
		$("#tempbutton").click(
				function() {
					//id가 smarteditor인 textarea에 에디터에서 대입

					editor_object.getById["smarteditor"].exec(
							"UPDATE_CONTENTS_FIELD", []);

					// 이부분에 에디터 validation 검증

					//폼 submit
					$("#tmp").submit();
				})
				
		$("#ok").click(function(){
			var a = $("select[name=select]").val();
			var b = "";
			for(var i = 0; i < a.length; i++){
				if(i+1 == a.length){
					b += a[i];
				}else{
					b += a[i] + ", ";
				}
				
			}
			$("#recipient").val(b);
		});
	})
	
function getPost(mode)
{
		
var theForm = document.frmSubmit;
if(mode == "01")
{
 theForm.method = "post";
 theForm.action = "/hiapt/mwrite";
 if($("#recipient").val() == ""){
	 alert("받는 사람을 입력해주세요.");
	 return false; 
 }
 
}
else if(mode == "02")
{
  theForm.method = "post";
  theForm.action = "/hiapt/mtwrite"
} 


/* theForm.submit(); */
}
</script>
</head>
<!-- head 시작 -->
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
					<!-- 본문 타이틀 들어가는 부분 ---->
					<!--///////본문 내용 시작 ///////-------->
					<h4>편지쓰기</h4>

					<div class="card shadow mb-4">
						<div class="card-body">
							<br>
							<!-- name="form" -->
							<form method="post" name="frmSubmit"
								enctype="multipart/form-data">
								<input type="submit" value="보내기" id="savebutton"
									onclick="return getPost('01')"> <input type="submit"
									value="임시저장" id="tempbutton" onclick="return getPost('02')">
								<!-- <input type="submit" value="보내기" id="savebutton" onclick="javascript: form.action='/hiapt/mwrite'">
<input type="submit" value="임시저장" id="tempbutton" onclick="javascript: form.action='/hiapt/mtwrite'"> -->
								<input type="hidden" name="email"
									value="<%= emp.getEmpEmail() %>"> <input type="hidden"
									name="code" value="<%= code %>">
								<table>
									<tr>
										<th>받는사람</th>
										<td><input type="text" id="recipient" name="recipient"
											value="" style="width: 800px;"></td>
										<td><button type="button"
												class="btn btn-primary text-white" data-toggle="modal"
												data-target="#Modal">주소록</button></td>
									</tr>
									<tr>
										<th>제목</th>
										<td colspan="2"><input type="text" id="title"
											name="title" style="width: 800px;"></td>
									</tr>
									<tr>
										<th>파일첨부</th>
										<td><input type="file" name="file"></td>
									</tr>
									<tr>
										<th colspan="2">
											<div
												style="width: 900px; height: 450px; background-color: white; margin-top: 15px;">
												<textarea name="doccontent" id="smarteditor" rows="10"
													cols="100" style="width: 897px; height: 400px;"
													required="required"></textarea>
											</div>
										</th>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->



			<script>
jQuery.fn.listtosel = function () {
	var $obj = $(this);
	var $list = $obj.find(".schlist");
	var $sellst = $obj.find(".sellist");
	
	var $ctrl = $obj.find(".ctrl");
	var $allsel = $ctrl.find(".allsel");
	var $onesel = $ctrl.find(".onesel");
	var $onedesel = $ctrl.find(".onedesel");
	var $alldesel = $ctrl.find(".alldesel");
	
	var dom, idx;
	
	// 전체 선택
	$allsel.on("click", function () {
		if ($list.find("option").length != 0) {
			dom = $list.find("select").html();
			$sellst.find("select").append(dom);
			$list.find("option").remove();
		}
		
		return false;
	});
	
	// 전체 취소
	$alldesel.on("click", function () {
		if ($sellst.find("option").length != 0) {
			dom = $sellst.find("select").html();
			$list.find("select").append(dom);
			$sellst.find("option").remove();
		}
		
		return false;
	});
	
	// 하나 선택
	$onesel.on("click", function () {
		$list.find("option").each(function () {
			if ($(this).is(":selected") == true) {
				dom = this;
				$sellst.find("select").append(dom);
			}
		});
		
		return false;
	});
	
	// 하나 취소
	$onedesel.on("click", function () {
		$sellst.find("option").each(function () {
			if ($(this).is(":selected") == true) {
				dom = this;
				$list.find("select").append(dom);
			}
		});
		
		return false;
	});
}

$(function () {
	$(".listtosel").listtosel();
});
</script>
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
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<!--========================================================================================== -->
	<!-- Bootstrap core JavaScript-->
	<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>
	<!--========================================================================================== -->
	<!-- Modal -->
	<div class="modal fade" id="Modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="width: 600px; height: 400px;">
				<div class="listtosel">
					<div class="schlist">
						<h2>검색된 사람</h2>
						<select name="" multiple="multiple">
							<% for(Employee employee : list){ %>
							<option value="<%= employee.getEmpEmail() %>"><%= employee.getEmpEmail() %>
								<<%= employee.getEmpName() %>></option>
							<%
								}
							%>
						</select>
					</div>
					<div class="ctrl">
						<a href="#" class="first allsel">&gt;&gt;</a> <a href="#"
							class="second onesel">&gt;</a> <a href="#" class="onedesel">&lt;</a>
						<a href="#" class="last alldesel">&lt;&lt;</a>
					</div>
					<div class="sellist">
						<h2>선택한 사람</h2>
						<select name="select" multiple="multiple">
						</select>
					</div>
					<center>
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							id="ok">확인</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>
					</center>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
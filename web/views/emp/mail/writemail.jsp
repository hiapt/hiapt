<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="employee.model.vo.Employee"%>

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

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

		//전송버튼 클릭이벤트
		$("#savebutton").click(
				function() {
					//id가 smarteditor인 textarea에 에디터에서 대입
					editor_object.getById["smarteditor"].exec(
							"UPDATE_CONTENTS_FIELD", []);

					// 이부분에 에디터 validation 검증

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
	})
</script>
<!-- head 시작 -->
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
	<h4>편지쓰기</h4>

<br>
<button id="savebutton">보내기</button>
<button id="tempbutton">임시저장</button>
<input type="hidden" name="email" value="<%= emp.getEmpEmail() %>">
<table>
	<tr>
		<th>받는사람</th>
		<td><input type="text" name="recipient"></td>
		<td><button>주소록</button></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="2"><input type="text" name="title"></td>
	</tr>
	<tr>
		<th>파일첨부</th>
		<td><input type="file"></td>
	</tr>
	<tr>
	<th colspan="2">
	<div
		style="width: 900px; height: 450px; background-color: white; margin-top: 15px;">
		<textarea name="doccontent" id="smarteditor" rows="10" cols="100"
			style="width: 897px; height: 400px;" required="required"></textarea>
	</div>
	</th>
	</tr>
</table>
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
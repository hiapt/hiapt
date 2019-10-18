<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

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
<button id="send">보내기</button>
<button id="temp">임시저장</button>
<input type="hidden" name="sender" value="<%= emp.getEmpNo() %>">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = new String("selfwrite");
%>
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
<h4>내게쓰기</h4>

<div class="card shadow mb-4">
<div class="card-body">
<br>
<form method="post" name="form">
<input type="submit" value="저장" id="savebutton" onclick="javascript: form.action='/hiapt/smwrite'">
<input type="submit" value="임시저장" id="tempbutton" onclick="javascript: form.action='/hiapt/mtwrite'">
<input type="hidden" name="email" value="<%= emp.getEmpEmail() %>">
<input type="hidden" name="code" value="<%= code %>">
<table>
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
</form>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message"); /*set으로 저장한거 get으로 가져옴*/
	/*String 으로 다운캐스팅 하거나 toString 써서 변환하거나 */
%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="emphead.html" %>

<!-- head 시작 -->
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 

<%@ include file ="empnavi.jsp" %>

<!-- 왼쪽 메인 메뉴바 끝  --> 
<!-- ================================================================================= -->

<!--- 중앙 전체 큰 틀 ---------------------------------------------->
<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">
<!-- Main Content -->
<div id="content">

<!-- ================================================================================= -->
<!---탑메뉴  시작 =================---------------------------->

<%@ include file ="empTopNavi.jsp" %>
<!---탑 메뉴 끝 ------------------------------------------->
<!--========================================================================================== -->
<!-- Begin Page Content -->
<div class="container-fluid">
<!-- 본문 타이틀 들어가는 부분 ---->					
<!--///////본문 내용 시작 ///////-------->	

<!-- 404 Error Text -->
         
     <div class="text-center">
        <div class="error mx-auto" data-text="404">404</div>
		<p class="lead text-gray-800 mb-5">에러 발생 : <%= message %></p>
		<a href="/hiapt/login.jsp">&larr; 홈으로 이동</a>
     </div>

</div><!-- /.container-fluid -->				
</div><!-- End of Main Content -->	
<!---//// 본문 내용 끝 ///////------------------->
<!-- footer 시작 -->
<%@ include file = "empfooter.html" %>
<!-- footer 시작 -->
</div>	<!-- End of Content Wrapper -->
</div>	<!-- End of Page Wrapper -->	
<!--========================================================================================== -->
<!-- top 버튼 -->
<%@ include file = "topbutton.html" %>
<!--========================================================================================== -->
</body>
</html>



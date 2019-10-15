<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String message = (String)request.getAttribute("message"); 
	
%>
<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../user/userhead.html" %>
<!-- head 끝  -->

<body>
<!-- navi 시작  -->
<%@ include file="../user/userheader.jsp" %>
<!-- navi 끝  -->

<section class="section1">
    <div class="container clearfix">
      <div class="content col-lg-12 col-md-12 col-sm-12 clearfix">
        <div class="notfound">
          <h1 class="big-title">웹 페이지를 찾을 수 없습니다.</h1>
          <h4 class="small-title">에러 발생 : <%= message %></h4>
          <a class="button" href="/hipat/index2.jsp">BACK TO HOME</a>
        </div>
        <!-- end message -->
      </div>
      <!-- end content -->
    </div>
    <!-- end container -->
  </section>
  <!-- end section -->
  

<!-- footer 시작 -->
 <%@ include file="../user/userfooter.jsp" %>
<!-- footer 끝  -->
</body>
</html>
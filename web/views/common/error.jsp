<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message"); /*set으로 저장한거 get으로 가져옴*/
	/*String 으로 다운캐스팅 하거나 toString 써서 변환하거나 */
%>
<!--/// jsp 코드 ///-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="elogin.model.vo.Employee"%>

<%
	Employee loginEmployee = (Employee) session.getAttribute("employee");
%>

<!--복사 시작 ////////////////////////////--------------------->
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

<!--// css or jQuery or javaScript 삽입 부분    -->



</head>

<body id="page-top">

<%@ include file="../../header.jsp" %>
					
<!--///////본문 내용 시작 ///////-------->


 <!-- 404 Error Text -->
          <div class="text-center">
            <div class="error mx-auto" data-text="404">404</div>
				<p class="lead text-gray-800 mb-5">에러 발생 : <%= message %></p>
				<a href="/hiapt/login.jsp">&larr; 홈으로 이동</a>
            
            </div>



<!---//// 본문 내용 끝 ///////------------------->
<%@ include file = "../../../footer.html" %>
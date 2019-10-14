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

<%@ include file="../../../header.jsp" %>

<!-- 본문 타이틀 들어가는 부분 ---->
<h1 class="h3 mb-4 text-gray-800">제목 샘플</h1>
					
<!--///////본문 내용 시작 ///////-------->

<h1 align="center">공지사항</h1>
<br>

<div class="row">
	<div class="col-xs-12 ">
		<table class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Fireㅁㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㅇㄹ</td>
					<td>Mozilla</td>
					<td>Gecko</td>
					<td>Gecko</td>
				</tr>

			</tbody>
		</table>

	</div>
</div>



<!---//// 본문 내용 끝 ///////------------------->

<%@ include file = "../../../footer.html" %>
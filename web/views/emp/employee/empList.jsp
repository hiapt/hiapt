<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="employee.model.vo.Employee, java.util.ArrayList, elogin.model.vo.Employee" %>
<%
	ArrayList<Employee> list = (ArrayList<Employee>)request.getAttribute("list");
	Employee loginEmployee = (Employee) session.getAttribute("employee");
%>
<!--/// jsp 코드 ///-->


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
<style>
.check {
	    display: inline-block !important;
}

#navi{
	height: 30px;
	width: 110px;
	display: block;
	font-family:"굴림";
	font-weight:600;
	font-size:14px;
	padding: 5px 25px;
	margin : 5px 25px;
	color: white;
	background: #365873;
	text-decoration: none;
}
</style>
</head>

<body id="page-top">

<%@ include file="../../../header.jsp" %>

<!-- 본문 타이틀 들어가는 부분 ---->
<h1 class="h3 mb-4 text-gray-800">제목 샘플</h1>
					
<!--///////본문 내용 시작 ///////-------->

<div id="navi" align="left"> 직원조회</div>
<div class="box-content">
	<input type="checkbox" name="delete" class="check">삭제
	<div class="input-group" style ="width: 25%;  float: right;">
				<input type="text" class="form-control input-lg" placeholder="사번 검색">
				<span class="input-group-btn">
					<button class="btn btn-primary" type="button">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		<table class="table beauty-table table-hover"
			style="text-align: center;">
			<thead>
				<tr>
					<th width="10">
						<div class="checkbox" style="margin: 0px; margin-left: 10px;">
							<label> <input type="checkbox"> <i
								class="fa fa-square-o small"></i>
							</label>
						</div>
					</th>
					<th style="text-align: center;">사번</th>
					<th style="text-align: center;">이름</th>
					<th style="text-align: center;">직급</th>
					<th style="text-align: center;">입사년도</th>
					<th style="text-align: center;">휴대전화</th>
					<th style="text-align: center;">주소</th>
					<th style="text-align: center;">이메일</th>
					<th style="text-align: center;">급여</th>
					<th style="text-align: center;">기타정보</th>
				</tr>
			</thead>
			<tbody>
			<%
			for(int i = 0; i < list.size(); i++) { 
				Employee e = list.get(i);
			%>
			<tr>
				<td><%= i + 1 %></td>
				<td><%= e.getEmpNo() %></td>
				<td><%= e.getEmpName() %></td>
				<td><%= e.getEmpId() %></td>
				<td><%= e.getEmpHireDate() %></td>
				<td><%= e.getEmpPhone() %></td>
				<td><%= e.getEmpAddress() %></td>
				<td><%= e.getEmpEmail() %></td>
				<td><%= e.getSalary() %></td>
				<td><%= e.getEmpEtc() %></td>
			</tr>
			</tbody>
			<% } %>
		</table>

		

<!---//// 본문 내용 끝 ///////------------------->
<%@ include file = "../../../footer.html" %>		
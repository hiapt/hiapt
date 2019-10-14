<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.Draft, java.util.ArrayList"%>
    
 <%
 	ArrayList<Draft> list = (ArrayList<Draft>)request.getAttribute("list");
 	
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

<%@ include file="../../../top.jsp" %>

<!-- 본문 타이틀 들어가는 부분 ---->
<h1 class="h3 mb-4 text-gray-800">제목 샘플</h1>
					
<!--///////본문 내용 시작 ///////-------->

<form action="" method="post">
<h4>임시보관 문서 : <%= list.size() %>개 </h4>
<table class="table beauty-table table-hover" style="text-align: center;">
					<thead>
						<tr>
							<th width="10">
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<input type="checkbox" id="checkall">
								<i class="fa fa-square-o small"></i>
							</label>
							</div></th>
							<th style="text-align: center;">제목</th>
							<th width="150" style="text-align: center;">작성자</th>
							<th width="100" style="text-align: center;">임시저장일</th>
							<th width="150" style="text-align: center;">문서종류</th>
							
						</tr>
					</thead>
					<% for(int i = 0; i < list.size(); i++) { 
							Draft d = list.get(i);%>
					<tbody>
						<tr>
							<td>				
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<input type="checkbox">
								<i class="fa fa-square-o small"></i>
							</label>
							</div>
							</td>
							<td><i class="fa fa-paperclip"></i></td>
							<td><%= d.getDocno() %></td>
							<td><a href="/employee/index.jsp?#/employee/dview?docno=<%= d.getDocno() %>"><%= d.getDoctitle()%></a></td>
							<td><%= d.getEmpno() %></td>
							<td><%= d.getDraftdate() %></td>
							<td><%= d.getFormcode()%></td>
							
						</tr>
					</tbody>
					<%} %>
				</table>	
	<div style="float: right;">
	<input type="button" value="이동" class="btn btn-default btn-xs" style="letter-spacing: 7px; padding-left: 10px;">
	</div>
</form>




<!---//// 본문 내용 끝 ///////------------------->
<%@ include file = "../../../footer.html" %>
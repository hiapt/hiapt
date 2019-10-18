<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mail.model.vo.Mailm, java.util.ArrayList"%>

<%
	ArrayList<Mailm> list = (ArrayList<Mailm>)request.getAttribute("list");
	int currentPage = (Integer)request.getAttribute("currentPage");
	int beginPage = (Integer)request.getAttribute("beginPage");
	int endPage = (Integer)request.getAttribute("endPage");
	int maxPage = (Integer)request.getAttribute("maxPage");
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

<h1>임시 보관함</h1>
<div class="card shadow mb-4">
<div class="card-body">
<input type="search" value="메일검색"> &nbsp;&nbsp; <span>임시보관함/</span><br>
<input type="checkbox"> &nbsp; <button>삭제</button> 
<table class="table beauty-table table-hover" style="text-align: center;">
					<thead>
						<tr>
							<th width="10">
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<input type="checkbox">
								<i class="fa fa-square-o small"></i>
							</label>
							</div></th>
							<th width="75" style="text-align: center;">받는사람</th>
							<!-- <th width="100" style="text-align: center;">제목</th> -->
							<th style="text-align: center;">제목</th>
							<th width="150" style="text-align: center;">시간</th>
							
						</tr>
						<% for(Mailm m : list){ %>						
						<tr><td><input type="checkbox"></td>
						<td><%= m.getRecipient() %></td>
						<td><%= m.getMailTitle() %></td>
						<td><%= m.getMailTime() %></td>
						</tr>
						<% } %>
					</thead>
					</table>
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
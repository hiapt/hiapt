<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.Bill, java.util.ArrayList" %>
<%
	ArrayList<Bill> list = (ArrayList<Bill>)request.getAttribute("list");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
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
<h1 class="h3 mb-4 text-gray-800">고지서 목록</h1>
					
<!--///////본문 내용 시작 ///////-------->
<!-- 고지서목록 -->
<div class="bs-callout bs-callout-info"
	id="callout-tabs-extends-component">
	<h4>고지서</h4><h6>전체 목록 : <%= list.size() %> 개</h6>
</div>
<div class="card shadow mb-4">
<div class="card-body">

<table class="table table-borderedz">
	<thead>
		<tr>
			<th>고지서번호</th>
			<th>동/호</th>
			<th>부과금액</th>
			<th>미납액</th>
			<th>미납연체료</th>
			<th>납기내금액</th>
			<th>납기후금액</th>
		</tr>
	</thead>
	<tbody>
	<% for(int i = 0; i < list.size(); i++){
		Bill b = list.get(i);
	%>
		<tr>
			<td><%= i + 1 %></td>
			<td><%= b.getMerchantUid() %></td>
			<td><%= b.getUserId() %></td>			
			<td><%= b.getAmount() %></td>
			<td><%= b.getArrears() %></td>
			<td><%= b.getArrearsFine() %></td>
			<td><%= b.getBeforeAmount() %></td>
			<td><%= b.getAfterAmount() %></td>
		</tr>
	<% } %>
	</tbody>
</table>




</div></div>
<!---//// 본문 내용 끝 ///////------------------->
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

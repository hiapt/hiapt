<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mail.model.vo.Mailm, java.util.ArrayList"%>

<%
	ArrayList<Mailm> list = (ArrayList<Mailm>)request.getAttribute("list");
	int currentPage = (Integer)request.getAttribute("currentPage");
	int beginPage = (Integer)request.getAttribute("beginPage");
	int endPage = (Integer)request.getAttribute("endPage");
	int maxPage = (Integer)request.getAttribute("maxPage");
	String code = new String("all");
	String code2 = new String("self");
	String allmail = new String("allmail");
%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
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
	
	<!-- Bootstrap core JavaScript-->
	<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>


<!--// css or jQuery or javaScript 삽입 부분    -->
<script>
$(function() {
	showDiv();

	$("select[name=searchselect]").on("change", function() {
		showDiv();
	});
});

function showDiv() {
	if ($("#searchselect option:eq(0)").is(":selected")) {
		$("#title").css("display", "inline");
		$("#sender").css("display", "none");
		$("#recipient").css("display", "none");

	}
	if ($("#searchselect option:eq(1)").is(":selected")) {
		$("#title").css("display", "none");
		$("#sender").css("display", "inline");
		$("#recipient").css("display", "none");

	}
	if ($("#searchselect option:eq(2)").is(":selected")) {
		$("#title").css("display", "none");
		$("#sender").css("display", "none");
		$("#recipient").css("display", "inline");

	}
}
</script>


</head>

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


<h1>전체 메일함</h1>
<hr>
<div class="card shadow mb-4">
<div class="card-body">
<%-- <form action="/hiapt/mtsearch" method="post">
<input type="search" id="title" name="title">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
</form>
<form action="#" method="post">
<input type="search" id="sender" name="sender">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
</form>
<form action="#" method="post">
<input type="search" id="recipient" name="recipient">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
</form>
<select id="searchselect" name="searchselect">
			<option selected="selected">제목</option>
			<option>보낸사람</option>
			<option>받는사람</option>			
</select>
&nbsp; --%> 
<span>전체메일함/</span><br>
<input type="checkbox" id="checkall"> &nbsp;
<form method="post" name="form">
<input type="submit" value="삭제" onclick="javascript: form.action='/hiapt/movew'" class="btn btn-primary btn-sm shadow-sm" >
<input type="submit" value="이동" onclick="javascript: form.action='/hiapt/mtwrite'" class="btn btn-primary btn-sm shadow-sm" >
<input type="hidden" name="page" value="<%= currentPage %>">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
<input type="hidden" name="code" value="<%= code %>">
<table class="table beauty-table table-hover" style="text-align: center;">
					<thead>
						<tr>
							<th width="10">
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<i class="fa fa-square-o small"></i>
							</label>
							</div></th>
							<th width="75" style="text-align: center;">보낸사람</th>
							<!-- <th width="100" style="text-align: center;">제목</th> -->
							<th style="text-align: center;">제목</th>
							<th width="150" style="text-align: center;">시간</th>
							
						</tr>
						<% for(Mailm m : list){ %>
						<% if(m.getMailCode() == 2){ %>						
						<tr><td><input type="checkbox" name="mailno" value="<%= m.getMailNo() %>"></td>
						<td><%= m.getEmpEmail() %></td>
						<td><a href="/hiapt/mdetail?mailno=<%= m.getMailNo() %>&page=<%= currentPage %>&code=<%= code2 %>"><%-- &allmail=<%= allmail %> --%>
						[내게쓴메일함]<%= m.getMailTitle() %></a></td>   
						<td><%= m.getMailTime() %></td>
						</tr>
						<% }else{ %>
						<tr><td><input type="checkbox" name="mailno" value="<%= m.getMailNo() %>"></td>
						<td><%= m.getEmpEmail() %></td>
						<td><a href="/hiapt/mdetail?mailno=<%= m.getMailNo() %>&page=<%= currentPage %>&code=<%= code %>&allmail=<%= allmail %>">
						[받은메일함]<%= m.getMailTitle() %></a></td>   
						<td><%= m.getMailTime() %></td>
						</tr>
						<% } %>
						<% } %>
					</thead>
					</table>
</form>				
					

<!-- pageing -->

		<div class="col-sm-12">
			<div class="paging_simple_numbers">
				<ul class="pagination" style="justify-content: center;">
					<li class="paginate_button page-item previous disabled"
						id="dataTable_previous"><a href="/hiapt/amlist?page=1&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
					<% if((beginPage - 10) < 1){ %>
					<li class="paginate_button page-item previous back"
						id="dataTable_previous"><a href="/hiapt/amlist?page=1&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } else { %>
					<li class="paginate_button page-item active back"
						id="dataTable_previous"><a href="/hiapt/amlist?page=<%= beginPage -10 %>&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable"
						data-dt-idx="<%= beginPage - 10 %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } %>
					<% if(currentPage == 0){ %>
					<li class="paginate_button page-item active"
						id="dataTable_previous"><a href="/hiapt/selfmlist?page=1&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">1</a></li>
					<% }else{ %>
					<% for(int p = beginPage; p <= endPage; p++){
						if(p == currentPage){	
					%>
					<li class="paginate_button page-item active next"><a href="/hiapt/amlist?page<%= p %>&empemail=<%= emp.getEmpEmail() %>"
						aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% } else { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/amlist?page=<%= p %>&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% }} %>
					<% } %>
					<% if((endPage + 10) > maxPage ) { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/amlist?page=<%= maxPage %>&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } else { %>	
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/amlist?page<%= endPage + 10 %>&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable" data-dt-idx="<%= endPage + 10 %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/amlist?page=<%= maxPage %>&empemail=<%= emp.getEmpEmail() %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;</a></li>
				</ul>
			</div>
		</div>
		</div>
					</div>
<script type="text/javascript">
	$("#checkall").click(function() {

		if ($("#checkall").prop("checked")) {

			$("input[type=checkbox]").prop("checked", true);
		} else {
			$("input[type=checkbox]").prop("checked", false);
		}
	});
</script>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.Draft, java.util.ArrayList"%>

<%
	ArrayList<Draft> list = (ArrayList<Draft>) request.getAttribute("list");
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer) request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	int count = ((Integer) request.getAttribute("count")).intValue();
%>

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

<!--// css or jQuery or javaScript 삽입 부분    -->

<style>
table {
	font-size: 10pt;
	text-align: center;
}


</style>
</head>
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

<!--///////본문 내용 시작 ///////-------->

<div style="float: right; display: flex;">
	<div>
		<select id="searchselect" name="searchselect"
			style="width: 100px; padding-left: 5px;"
			class="form-control form-control-sm">
			<option selected="selected">제목</option>
			<option id="opt2">작성자</option>
			<option id="opt3">날짜</option>
			<option id="opt4">문서형식</option>
		</select>
	</div>
	<div id="title">
		<form action="/hiapt/dsearch" method="post" id="searchform">
			<input type="hidden" name="empno" value="<%=emp.getEmpNo()%>">
			<input type="hidden" name="search" value="title">
			<div class="input-group" style="margin-left: 5px;">
				<input type="text" id="search" name="keyword"
					class="form-control form-control-sm" placeholder="검색할 제목을 입력하세요."
					style="width: 250px;">
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button" id="submitbtn">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<div id="writer">
		<form action="/hiapt/dsearch" method="post" id="searchform2">
			<input type="hidden" name="empno" value="<%=emp.getEmpNo()%>">
			<input type="hidden" name="search" value="writer">
			<div class="input-group" style="margin-left: 5px;">
				<input type="text" id="search" name="keyword"
					class="form-control form-control-sm" placeholder="검색할 작성자를 입력하세요."
					style="width: 250px;">
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button"
						id="submitbtn2">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<div id="date">
		<form action="/hiapt/dsearch" method="post" id="searchform3">
			<input type="hidden" name="empno" value="<%=emp.getEmpNo()%>">
			<input type="hidden" name="search" value="date">
			<div class="input-group" style="margin-left: 5px;">
				<input type="date" name="from" id="search"
					class="form-control form-control-sm"
					style="width: 140px; border-radius: 3px;"> &nbsp; ～ &nbsp;<input
					type="date" name="to" id="search"
					class="form-control form-control-sm"
					style="width: 140px; border-radius: 3px;">
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button"
						id="submitbtn3">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<div id="formtype">
		<form action="/hiapt/dsearch" method="post" id="searchform4">
			<input type="hidden" name="empno" value="<%=emp.getEmpNo()%>">
			<input type="hidden" name="search" value="formtype">
			<div class="input-group" style="margin-left: 5px;">
				<input type="text" id="search" name="keyword"
					class="form-control form-control-sm" placeholder="검색할 문서형식을 입력하세요."
					style="width: 250px;">
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button"
						id="submitbtn4">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
</div>
<br>
	<h5>
		승인 문서 :
		<%=count%>개
	</h5>
	<div class="card shadow mb-4">
		<div class="card-body" align="center">

			<table class="table beauty-table table-hover"
				style="text-align: center; ">
					<tr>
						<th width="10" >
								<label class="check">
       					     <input type="checkbox" id="checkall">
         					 <span class="checkmark"></span>
          				 	 </label>
						</th>
						<th width="80">첨부파일</th>
						<th width="100">문서번호</th>
						<th>제목</th>
						<th width="125">기안자</th>
						<th width="100">기안일</th>
						<th width="120">문서종류</th>
						<th width="80">진행상태</th>
					</tr>
				<%
					for (int i = 0; i < list.size(); i++) {
						Draft d = list.get(i);
				%>
					<tr>
						<td>
						<label class="check">
       				    <input type="checkbox">
       					<span class="checkmark"></span>
        			    </label>
						</td>
						<td>
						<% if(d.getOriginfile() != null && !d.getOriginfile().equals("null")) { %>
						<i class="fa fa-paperclip"></i>
						<% } else { %>
							
						<% } %></td>
						<td><%=d.getDocno()%></td>
						<td><a href="/hiapt/dview?docno=<%=d.getDocno()%>"><%=d.getDoctitle()%></a></td>
						<td><%=d.getEmpid()%>&nbsp;<%=d.getEmpname()%></td>
						<td><%=d.getDraftdate()%></td>
						<td><%=d.getFormname()%></td>
						<td>
							<%
								if (d.getProgress().equals("0")) {
							%> 대기 <%
								} else if (d.getProgress().equals("1")) {
							%> 승인 <%
								} else if (d.getProgress().equals("2")) {
							%> 반려 <%
								} else if (d.getProgress().equals("3")) {
							%> 보류 <%
								}
							%>
						</td>
					</tr>
				<%
					}
				%>
			</table>
			<div style="float: right;">
				<input type="button" value="이동" class="btn btn-default btn-xs"
					style="letter-spacing: 7px; padding-left: 10px;">
			</div>

			<div class="col-sm-12">
				<div class="paging_simple_numbers">
					<ul class="pagination" style="justify-content: center;">
						<li class="paginate_button page-item previous"
							id="dataTable_previous">
							<a href="/hiapt/dapproved.ad?page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
						<%
							if ((beginPage - 10) < 1) {
						%>
						<li class="paginate_button page-item previous back"
							id="dataTable_previous">
							<a href="/hiapt/dapproved.ad?page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item active back"
							id="dataTable_previous">
							<a href="/hiapt/dapproved.ad?page=<%=beginPage - 10%>"
							aria-controls="dataTable" data-dt-idx="<%=beginPage - 10%>"
							tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							}
						%>
						<%
							for (int p = beginPage; p <= endPage; p++) {
								if (p == currentPage) {
						%>
						<li class="paginate_button page-item active next">
						<a href="/hiapt/dapproved.ad?page<%=p%>"
							aria-controls="dataTable" data-dt-idx="<%=p%>" tabindex="0"
							class="page-link"><%=p%></a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dapproved.ad?page=<%=p%>"
							aria-controls="dataTable" data-dt-idx="<%=p%>" tabindex="0"
							class="page-link"><%=p%></a></li>
						<%
							}
							}
						%>
						<%
							if ((endPage + 10) > maxPage) {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dapproved.ad?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dapproved.ad?page<%=endPage + 10%>"
							aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							}
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dapproved.ad?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
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

	$(function() {
		showDiv();

		$("select[name=searchselect]").on("change", function() {
			showDiv();
		});
	});

	function showDiv() {
		if ($("#searchselect option:eq(0)").is(":selected")) {
			$("#title").css("display", "block");
			$("#writer").css("display", "none");
			$("#date").css("display", "none");
			$("#formtype").css("display", "none");
		}
		if ($("#searchselect option:eq(1)").is(":selected")) {
			$("#title").css("display", "none");
			$("#writer").css("display", "block");
			$("#date").css("display", "none");
			$("#formtype").css("display", "none");
		}
		if ($("#searchselect option:eq(2)").is(":selected")) {
			$("#title").css("display", "none");
			$("#writer").css("display", "none");
			$("#date").css("display", "block");
			$("#formtype").css("display", "none");
		}
		if ($("#searchselect option:eq(3)").is(":selected")) {
			$("#title").css("display", "none");
			$("#writer").css("display", "none");
			$("#date").css("display", "none");
			$("#formtype").css("display", "block");
		}
	}
</script>
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

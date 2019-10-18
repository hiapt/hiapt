<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="formbox.model.vo.Formbox, java.util.ArrayList"%>
    <%
	ArrayList<Formbox> list = (ArrayList<Formbox>) request.getAttribute("list");
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer) request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	int count = ((Integer) request.getAttribute("count")).intValue();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<!--// css or jQuery or javaScript 삽입 부분    -->

<style>

table {
	font-size: 10pt;
	text-align: center;
}


</style>
</head>

<%@ include file="../../../top.jsp"%>

<body>

<div style="float: right; display: flex;">
	<div>
		<select id="searchselect" name="searchselect"
			style="width: 100px; padding-left: 5px;"
			class="form-control form-control-sm">
			<option selected="selected">제목</option>
			<option>양식분류</option>
		</select>
	</div>
	<div id="title">
		<form action="/hiapt/dsearch" method="get" id="searchform">
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
	<div id="formtype">
		<form action="/hiapt/dsearch" method="get" id="searchform2">
			<input type="hidden" name="empno" value="<%=emp.getEmpNo()%>">
			<input type="hidden" name="search" value="formtype">
			<div class="input-group" style="margin-left: 5px;">
				<input type="text" id="search" name="keyword"
					class="form-control form-control-sm" placeholder="검색할 문서형식을 입력하세요."
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
</div>
<br>
<h5>
		전체 문서 :
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
						<th width="100">양식번호</th>
						<th>양식명</th>
						<th width="120">양식분류</th>
					</tr>
				<%
					for (int i = 0; i < list.size(); i++) {
						Formbox f = list.get(i);
				%>
					<tr>
						<td>
						<label class="check">
       				    <input type="checkbox">
       					<span class="checkmark"></span>
        			    </label>
						</td>
						
						<td><%=f.getFormcode()%></td>
						<td><%=f.getFormname()%></td>
						<td><%=f.getFormtype()%></td>
					</tr>
				<%
					}
				%>
			</table>
			<div style="float: right;">
				<input type="button" value="수정" class="btn btn-default btn-xs"
					style="letter-spacing: 7px; padding-left: 10px;">
					<input type="button" value="삭제" class="btn btn-default btn-xs"
					style="letter-spacing: 7px; padding-left: 10px;">
			</div>

			<div class="col-sm-12">
				<div class="paging_simple_numbers">
					<ul class="pagination" style="justify-content: center;">
						<li class="paginate_button page-item previous"
							id="dataTable_previous">
							<a href="/hiapt/flist?page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
						<%
							if ((beginPage - 10) < 1) {
						%>
						<li class="paginate_button page-item previous back"
							id="dataTable_previous">
							<a href="/hiapt/flist?page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item active back"
							id="dataTable_previous">
							<a href="/hiapt/flist?page=<%=beginPage - 10%>"
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
						<a href="/hiapt/flist?page=<%=p%>"
							aria-controls="dataTable" data-dt-idx="<%=p%>" tabindex="0"
							class="page-link"><%=p%></a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/flist?page=<%=p%>"
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
						<a href="/hiapt/flist?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/flist?page=<%=endPage + 10%>"
							aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							}
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/flist?page=<%=maxPage%>"
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
			$("#formtype").css("display", "none");
		}
		if ($("#searchselect option:eq(1)").is(":selected")) {
			$("#title").css("display", "none");
			$("#formtype").css("display", "block");
		}
		
	}
	
	
	$(function() {
		  $("#submitbtn").click(function(){
		        $("#searchform").submit();
		    });
		  $("#submitbtn2").click(function(){
		        $("#searchform2").submit();
		    });
		  
	});
</script>
</body>
</html>
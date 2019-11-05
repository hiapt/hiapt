<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.Draft, java.util.ArrayList, java.sql.Date, mybox.model.vo.Mybox"%>

<%
	ArrayList<Draft> list = (ArrayList<Draft>) request.getAttribute("list");
	ArrayList<Mybox> mlist = (ArrayList<Mybox>) request.getAttribute("mlist");
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer) request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer) request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer) request.getAttribute("maxPage")).intValue();
	int count = ((Integer) request.getAttribute("count")).intValue();
	String keyword = (String) request.getAttribute("keyword");
	String search = (String) request.getAttribute("search");
	String begin = (String) request.getAttribute("begin");
	String to = (String) request.getAttribute("to");
	String empno = (String) request.getAttribute("empno");
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
	<div id="writer">
		<form action="/hiapt/dsearch" method="get" id="searchform2">
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
		<form action="/hiapt/dsearch" method="get" id="searchform3">
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
		<form action="/hiapt/dsearch" method="get" id="searchform4">
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
	<div style="display: flex;">
		<div style="color: #444;">
		［전체 문서 : <%=count%>개］
		</div>
</div>
	<% if(keyword != null) { %>
	<div align="center" style="color: #644b90; font-size: 11pt; font-weight: bold;">
		［검색어 : <%= keyword %>］
	</div>
	<% } else if (begin != null && to != null) { %>
	<div  align="center" style="color: #644b90; font-size: 11pt; font-weight: bold;">
		［검색 날짜 : <%= begin %> ~ <%= to %>］
	</div>
	<% } %>
	<br>
	<div class="card shadow mb-4">
		<div class="card-body" align="center">
				<div id="myadd" style="position: absolute; width: 550px; height: 60px; background: #eaecf1; 
			left: 20%; top: 35%; border-radius: 5px; padding-top: 15px; display: none; border: 1px solid #ddd;">
			<select name="myboxcode" id="myboxcode">
			<% if(mlist != null){
				for(int i = 0; i < mlist.size(); i++){ 
				Mybox m = mlist.get(i); %>
			<option value="<%= m.getMyboxcode()%>"><%= m.getMyboxname() %></option>
			<%} }%>
			</select>
			<input type="submit" value=" 등 록 " class="btn btn-primary btn-icon-split btn-sm" style="padding: 4px; margin-bottom: 2px;" id="addmbox"> &nbsp;
			<input type="button" value=" 취 소 " id="cancel" class="btn btn-secondary btn-icon-split btn-sm" style="padding: 4px; margin-bottom: 2px;"> 
			</div>
			
			<table class="table beauty-table table-hover"
				style="text-align: center; ">
					<tr>
						<th width="10" >
							<label class="check">
       					     <input type="checkbox" id="checkall">
         					 <span class="checkmark"></span>
          				 	 </label>
						</th>
						<th width="60">첨부</th>
						<th width="100">문서번호</th>
						<th>제목</th>
						<th width="125">기안자</th>
						<th width="100">기안일</th>
						<th width="100">기한</th>
						<th width="80">양식</th>
						<th width="60">상태</th>
					</tr>
				<%
					for (int i = 0; i < list.size(); i++) {
						Draft d = list.get(i);
				%>
					<tr>
						<td>
						<label class="check">
       				    <input type="checkbox" name="docno" value="<%= d.getDocno() %>">
       				    <input type="hidden" name="empno" value="<%= d.getEmpno() %>">
       					<span class="checkmark"></span>
        			    </label>
						</td>
						<td>
						
						<% if(d.getOriginfile() != null && !d.getOriginfile().equals("null")) { %>
						<i class="fa fa-paperclip"></i>
						<% } else { %>
							
						<% } %>
				
						</td>
						<td><%=d.getDocno()%></td>
						<td><a href="/hiapt/dview?empno=<%= emp.getEmpNo() %>&docno=<%=d.getDocno()%>"><%=d.getDoctitle()%></a></td>
						<td><%=d.getEmpid()%>&nbsp;<%=d.getEmpname()%></td>
						<td><%=d.getDraftdate()%></td>
						<td><%=d.getDeadline() %></td>
						<td><%=d.getFormname()%></td>
						<td>
							<%
								if (d.getDocstatus().equals("0")) {
							%> 대기중 <%
								} else if (d.getDocstatus().equals("1")) {
							%> 진행중 <%
								} else if (d.getDocstatus().equals("2")) {
							%> 결재완료 <%
								} else if (d.getDocstatus().equals("3")) {
							%> 반려됨 <%
								} else if (d.getDocstatus().equals("4")) { %> 
								 보류중
							 <% }%>
						</td>
					</tr>
				<%
					}
				%>
			</table>
			
<% if(keyword == null) { %>
			<div class="col-sm-12">
				<div class="paging_simple_numbers">
					<ul class="pagination" style="justify-content: center;">
						<li class="paginate_button page-item previous"
							id="dataTable_previous">
							<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
						<%
							if ((beginPage - 10) < 1) {
						%>
						<li class="paginate_button page-item previous back"
							id="dataTable_previous">
							<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item active back"
							id="dataTable_previous">
							<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=<%=beginPage - 10%>"
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
						<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=<%=p%>"
							aria-controls="dataTable" data-dt-idx="<%=p%>" tabindex="0"
							class="page-link"><%=p%></a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=<%=p%>"
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
						<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=<%=endPage + 10%>"
							aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							}
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;</a></li>
					</ul>
				</div>
			</div>
		<% } else {%>
		<div class="col-sm-12">
				<div class="paging_simple_numbers">
					<ul class="pagination" style="justify-content: center;">
						<li class="paginate_button page-item previous"
							id="dataTable_previous">
							<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&search=<%=search %>&keyword=<%= keyword%>&page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
						<%
							if ((beginPage - 10) < 1) {
						%>
						<li class="paginate_button page-item previous back"
							id="dataTable_previous">
							<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&search=<%=search %>&keyword=<%= keyword%>&page=1" aria-controls="dataTable"
							data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item active back"
							id="dataTable_previous">
							<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&page=<%=beginPage - 10%>"
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
						<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&search=<%=search %>&keyword=<%= keyword%>&page=<%=p%>"
							aria-controls="dataTable" data-dt-idx="<%=p%>" tabindex="0"
							class="page-link"><%=p%></a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&search=<%=search %>&keyword=<%= keyword%>&page=<%=p%>"
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
						<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&search=<%=search %>&keyword=<%= keyword%>&page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&search=<%=search %>&keyword=<%= keyword%>&page=<%=endPage + 10%>"
							aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							}
						%>
						<li class="paginate_button page-item next" id="dataTable_next">
						<a href="/hiapt/dsearch?empno=<%= emp.getEmpNo() %>&search=<%=search %>&keyword=<%= keyword%>&page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>" tabindex="0"
							class="page-link">&rsaquo;</a></li>
					</ul>
				</div>
			</div>
		<% } %>
		</div>
	</div>
		<div style="float: right;">
				<input type="button" value=" 내문서함에 저장 "  id="mboxbtn"
				class="btn btn-secondary btn-icon-split" style="padding: 5px; padding-left: 6px;">
			
			</div>
	
<script type="text/javascript">
$("#checkall").click(function(){
	 var check = $("#checkall").prop("checked");
	 if(check) {
	  $("input[name=docno]").prop("checked", true);
	 } else {
	  $("input[name=docno]").prop("checked", false);
	 }
	});
$("input[name=docno]").click(function(){
	  $("#checkall").prop("checked", false);
	 });
	 
$(function () {
	$("#mboxbtn").click(function() {
	if($("input[name=docno]:checked").length > 0) {
		$("#myadd").css("display", "block");
	}else {
		alert("저장할 문서를 선택하십시오.");
	}

});
	$("#cancel").click(function() {
		$("#myadd").css("display", "none");

});
});


$("#addmbox").click(function(){
	  var confirm_del = confirm("해당 문서를 내문서함에 저장하시겠습니까?");
	  
	  if(confirm_del) {
		var checkArr = []; 
		  $("input[name=docno]:checked").each(function(){ 
			    checkArr.push($(this).val());
		});
	   console.log(checkArr);
	   console.log($("input[name=docno]:checked"));
	   
	   var data = { docno : checkArr , empno : $("input[name=empno]").val(), myboxcode : $("#myboxcode").val()};
  		console.log(data);
	   $.ajax({
	    url : "/hiapt/dmbox",
	    type : "post",
	    data : data,
	    success : function(){
	     location.href = "/hiapt/mylist.emp?empno=" + <%= emp.getEmpNo() %>  + "&myboxcode=" + $("#myboxcode").val() + "&page=1";
	    },
	    traditional : true
	   });
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
	
	
	$(function() {
		  $("#submitbtn").click(function(){
		        $("#searchform").submit();
		    });
		  $("#submitbtn2").click(function(){
		        $("#searchform2").submit();
		    });
		  $("#submitbtn3").click(function(){
		        $("#searchform3").submit();
		    });
		  $("#submitbtn4").click(function(){
		        $("#searchform4").submit();
		    });
		  
	});
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.UserBill, java.util.ArrayList"%>
<%-- <%
   Aptuser aptuser = (Aptuser)session.getAttribute("aptuser");
%> --%>
<%
	ArrayList<UserBill> ublist = (ArrayList<UserBill>) request.getAttribute("list");
	UserBill ubill = (UserBill) request.getAttribute("ubill");
	int currentPage = (Integer) request.getAttribute("currentPage");
	int beginPage = (Integer) request.getAttribute("beginPage");
	int endPage = (Integer) request.getAttribute("endPage");
	int maxPage = (Integer) request.getAttribute("maxPage");
	String months = (String) request.getAttribute("months");
%>

<head>
<meta charset="utf-8">
<title>HiAPTU</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<!--  <link href="img/favicon.png" rel="icon"> -->


<!-- Bootstrap CSS File -->
<link href="/hiapt/resources/css/bootstrap.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="/hiapt/resources/css/prettyphoto.css" rel="stylesheet">
<link href="/hiapt/resources/css/hoverex-all.css" rel="stylesheet">
<link href="/hiapt/resources/css/jetmenu.css" rel="stylesheet">
<link href="/hiapt/resources/css/owl-carousel.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="/hiapt/resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="/hiapt/resources/css/blue.css">

<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">

$(function(){
	$.ajax({
		url : "/hiapt/ubtop1",
		type : "get",
		dataType : "json",
		success : function(data){
			var jsonStr = JSON.stringify(data);
			
			var jsonStr = JSON.stringify(data);
			//문자열을 json 배열 객체로 바꿈
			var json = JSON.parse(jsonStr);
			
			var values = ""; // 빈 값을 생성
			
			for(var i in json.list){ //로그인되어 있으면 페이지 번호를 연결해서 상세보기로 넘어가게
				
			values += "<tr><td><a href='*'" + json.list[i].merchantUid + "&page=1'>" 
			+ "</a></td><td>" + json.list[i].billYearMonth+ "</td><td>"
			+ "</td><td>" + json.list[i].amount + "</td><td>"
			+ "</td><td>" + json.list[i].arrears + "</td><td>"
			+ "</td><td>" + json.list[i].arrearsFine + "</td><td>"
			+ "</td><td>" + json.list[i].beforeAmount + "</td><td>"
			+ "</td><td>" + json.list[i].afterAmount + "</td></tr>";
			
			}
			$("#userBill").html($("#userBill").html() + values);
		},
		error : function(jqXHR, textStatus, errorThrown ){
			console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);			
		}
	});// end top1
});
</script>


</head>

<%@ include file="../userheader.jsp"%>

<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 시작==================================================================================-->
<section class="post-wrapper-top">
	<div class="container">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<ul class="breadcrumb">
				<li><a href="/hiapt/index2.jsp">Home</a></li>
				<li>관리비조회</li>
			</ul>
			<h2>
				<sapn class="text-info"><%=aptuser.getUserName()%></sapn>
				&nbsp; 님의
				<%-- <%= ubill.getBillYearMonth() %> --%>
				월분 관리비조회
			</h2>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<!-- search -->
			<div class="search-bar">
				<!-- 부과년월 검색 -->
				<form action="/hiapt/bvis" method="post">
					<input type="hidden" name="search" value="months" /> <label>부과년월&nbsp;
						<input type="month" name="months"
						class="form-control form-control-sm">
					</label> <input type="submit" value="검색" onclick="sendIt()"
						class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
				</form>
				<!-- <form action="" method="get">
					<fieldset>
						<input type="image" src="/hiapt/resources/images/pixel.gif"
							class="searchsubmit" alt="" /> <input type="date"
							class="search_text showtextback form-control" name="s" id="s"
							max="9999-12" value="" />

					</fieldset>
				</form> -->
			</div>
			<!-- / end div .search-bar -->
		</div>
	</div>
</section>
<!-- end post-wrapper-top -->
<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 끝==================================================================================-->
<!--  -->
<section class="section1" style="">
	<div class="container clearfix">
		<div class="content col-xs-12 clearfix">

			<h4 class="title">
				<span>9월분</span>&nbsp <small>납부마감일</small>
				<h4>고지서</h4>
				<%-- <h6>
					<%
						if (ublist != null) {
					%>
					전체 목록 :
					<%=ublist.size()%>
					<%
						}
					%>
					개
				</h6>
			</h4>

			<div class="pull-right">
				<input type="submit" value="당월고지서인쇄" id="submit" class="button">
			</div>
			<div class="clearfix"></div>
			<hr>

			<table class="table table-striped" data-effect="fade">
				<thead>
					<tr>
						<th>고지서번호</th>
						<th>당월부과액</th>
						<th>미납액</th>
						<th>미납연체료</th>
						<th>납기내 금액</th>
						<th>납기후 금액</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < ublist.size(); i++) {
							UserBill b = ublist.get(i);
					%>

					<tr>

						<td><%=b.getMerchantUid()%></td>
						<td><%=b.getAmount()%></td>
						<td><%=b.getArrears()%></td>
						<td><%=b.getArrearsFine()%></td>
						<td><%=b.getBeforeAmount()%></td>
						<td><%=b.getAfterAmount()%></td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table> --%>
			<script type="text/javascript">


			</script>
			<!-- ajax를 이용해 top1 -->
			<table class="table table-striped" id="userBill">
				<thead>
					<tr>
						<th>고지서번호</th>
						<th>당월부과액</th>
						<th>미납액</th>
						<th>미납연체료</th>
						<th>납기내 금액</th>
						<th>납기후 금액</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

			<div class="col-sm-12">
				<div class="paging_simple_numbers">
					<%
						if (months != null) {
					%>
					<ul class="pagination" style="justify-content: center;">
						<li class="paginate_button page-item previous"
							id="dataTable_previous"><a href="/hiapt/ublist?page=1"
							aria-controls="dataTable" data-dt-idx="0" tabindex="0"
							class="page-link">&lsaquo;</a></li>
						<%
							if ((beginPage - 10) < 1) {
						%>
						<li class="paginate_button page-item previous back"
							id="dataTable_previous"><a href="/hiapt/ublist?page=1"
							aria-controls="dataTable" data-dt-idx="0" tabindex="0"
							class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item active back"
							id="dataTable_previous"><a
							href="/hiapt/ublist?page=<%=beginPage - 10%>"
							aria-controls="dataTable" data-dt-idx="<%=beginPage - 10%>"
							tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							}
						%>
						<%
							if ((beginPage - 10) <= 9) {
						%>
						<li class="paginate_button page-item active"
							id="dataTable_previous"><a href="/hiapt/ublist?page=1"
							aria-controls="dataTable" data-dt-idx="0" tabindex="0"
							class="page-link">1</a></li>
						<%
							} else {
						%>
						<%
							for (int p = beginPage; p <= endPage; p++) {
										if (p == currentPage) {
						%>
						<li class="paginate_button page-item active next"><a
							href="/hiapt/ublist?page<%=p%>" aria-controls="dataTable"
							data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page=<%=p%>" aria-controls="dataTable"
							data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
						<%
							}
									}
						%>
						<%
							}
						%>
						<%
							if ((endPage + 10) > maxPage) {
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page<%=endPage + 10%>"
							aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							}
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
							tabindex="0" class="page-link">&rsaquo;</a></li>
					</ul>
					<%
						} else {
					%>

					<ul class="pagination" style="justify-content: center;">
						<li class="paginate_button page-item previous"
							id="dataTable_previous"><a href="/hiapt/ublist?page=1"
							aria-controls="dataTable" data-dt-idx="0" tabindex="0"
							class="page-link">&lsaquo;</a></li>
						<%
							if ((beginPage - 10) < 1) {
						%>
						<li class="paginate_button page-item previous back"
							id="dataTable_previous"><a href="/hiapt/ublist?page=1"
							aria-controls="dataTable" data-dt-idx="0" tabindex="0"
							class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item active back"
							id="dataTable_previous"><a
							href="/hiapt/ublist?page=<%=beginPage - 10%>"
							aria-controls="dataTable" data-dt-idx="<%=beginPage - 10%>"
							tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
						<%
							}
						%>
						<%-- <% if(currentPage == 1){ %>
               		<li class="paginate_button page-item active"
                  		id="dataTable_previous"><a href="/hiapt/bvis?page=1" aria-controls="dataTable"
                  		data-dt-idx="0" tabindex="0" class="page-link">1</a></li>
               		<% }else{ %> --%>

						<%
							for (int p = beginPage; p <= endPage; p++) {
									if (p == currentPage) {
						%>
						<li class="paginate_button page-item active next"><a
							href="/hiapt/ublist?page<%=p%>" aria-controls="dataTable"
							data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page=<%=p%>" aria-controls="dataTable"
							data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
						<%
							}
								}
						%>
						<%-- <% } %> --%>
						<%
							if ((endPage + 10) > maxPage) {
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							} else {
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page<%=endPage + 10%>"
							aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
							tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
						<%
							}
						%>
						<li class="paginate_button page-item next" id="dataTable_next"><a
							href="/hiapt/ublist?page=<%=maxPage%>"
							aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
							tabindex="0" class="page-link">&rsaquo;</a></li>
					</ul>
					<%
						}
					%>
				</div>
			</div>
			<div class=" text-center">

				<div id="pagebox" align="center">
					<a href="/hiapt/bilist?page=1">|◁</a> &nbsp;
					<%
						if ((beginPage - 10) < 1) {
					%>
					<a href="/hiapt/bilist?page=1">◀◀</a>
					<%
						} else {
					%>
					<a href="/hiapt/bilist?page=<%=beginPage - 10%>">◀◀</a>
					<%
						}
					%>&nbsp;
					<%
						for (int p = beginPage; p <= endPage; p++) {
							if (p == currentPage) {
					%>
					<a href="/hiapt/bilist?page=<%=p%>"><font color="red"><b>[<%=p%>]
						</b></font></a>
					<%
						} else {
					%>
					<a href="/hiapt/bilist?page=<%=p%>"><%=p%></a>
					<%
						}
						}
					%>&nbsp;
					<%
						if ((endPage + 10) > maxPage) {
					%>
					<a href="/hiapt/bilist?page=<%=maxPage%>">▶▶</a>
					<%
						} else {
					%>
					<a href="/hiapt/bilist?page=<%=endPage + 10%>">▶▶</a>
					<%
						}
					%>&nbsp; <a href="/hiapt/bilist?page=<%=maxPage%>">▷|</a>
				</div>

			</div>
			<ul class="pager">
				<li class="previous"><a
					href="/hiapt/views/user/maintenance/ReceiptList.jsp">← 납부내역조회</a></li>
				<li class="next"><a href="#">아파트관리비 납부하기 →</a></li>
			</ul>

		</div>
		<!-- end content -->


	</div>
	<!-- end container -->
</section>
<!-- end section -->

<!--  /// 본문 끝//////  -->

<%@ include file="../userfooter.jsp"%>
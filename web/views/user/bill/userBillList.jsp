<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.UserBill, java.util.ArrayList, java.util.*,java.text.*" %>
<%
	ArrayList<UserBill> ublist = (ArrayList<UserBill>) request.getAttribute("list");
	UserBill ubill = (UserBill) request.getAttribute("ubill");
	int currentPage = (Integer) request.getAttribute("currentPage");
	int beginPage = (Integer) request.getAttribute("beginPage");
	int endPage = (Integer) request.getAttribute("endPage");
	int maxPage = (Integer) request.getAttribute("maxPage");
	String months = (String) request.getAttribute("months");
%>
<%
DecimalFormat df = new DecimalFormat("###,###");
SimpleDateFormat ft = new SimpleDateFormat ( "yyyy년 M월");
%>
<head>
<meta charset="utf-8">
<title>HiAPTU</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
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
				&nbsp;님의 관리비조회
			</h2>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" style="margin-top: 53px;">
			<!-- search -->
			
				<!-- 부과년월 검색 -->
				 <form action="/hiapt/ublist" method="post">
					<input type="hidden" name="search" value="months" /> 
					부과년월&nbsp;
					<label>
						<input type="month" name="months"
						class="form-control form-control-sm">
					</label> <input type="submit" value="검색" onclick="sendIt()"
						class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm" style="margin-bottom: 5px;
    padding-bottom: 7px;">
				</form>
				
			
			<!-- / end div .search-bar -->
		</div>
	</div>
</section>
<!-- end post-wrapper-top -->
<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 끝==================================================================================-->
<!--  -->
<section class="section1">
	<div class="container clearfix">
		
	<!-- 검색버튼 사용시  -->
		<% if(months != null){ %>
			<!-- <div class="pull-right">
				<input type="submit" value="당월고지서인쇄" id="submit" class="button">
			</div> -->

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

						<td><a href='/hiapt/ubdt?merchantUid=<%= b.getMerchantUid() %>'><%=b.getMerchantUid()%></a></td>
						<td><%= df.format(b.getAmount())%>원</td>
						<td><%= df.format(b.getArrears())%>원</td>
						<td><%= df.format(b.getArrearsFine())%>원</td>
						<td><%= df.format(b.getBeforeAmount())%>원</td>
						<td><%= df.format(b.getAfterAmount())%>원</td>
					</tr>
					<%
						}
					%>

				</tbody>
			</table> 
			
			
			<div class="col-sm-12">
				<div class="paging_simple_numbers">
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
				</div><!-- paging_simple_numbers -->
			</div><!-- .col-sm-12 -->
			
			
			
			
			<% } else if(months == null){ %>
			<!--  검색 버튼 비사용시 먼저 뜨는 화면 -->
			<div class="content col-xs-12 clearfix" id="userBill"></div>
			
			<script type="text/javascript">
				$(function() {
				$.ajax({
					url : "/hiapt/ubtop1",
					type : "get",
					dataType : "json",
					success : function(data) {
						var jsonStr = JSON.stringify(data);

						var jsonStr = JSON.stringify(data);
						//문자열을 json 배열 객체로 바꿈
						var json = JSON.parse(jsonStr);

						var values = ""; // 빈 값을 생성

						for ( var i in json.ulist) { //로그인되어 있으면 페이지 번호를 연결해서 상세보기로 넘어가게

							values += "<div class='general-title text-center'><h3>"
									+ json.ulist[i].billYearMonth.slice(0,7)
									+ "월분</h3><p>납부마감일 : "
									+ json.ulist[i].cutoffDate
									+ "</p><hr></div>"
									+ "<table class='table table-striped'><tr><th scope='col'>고지서번호</th><td>"
									+ json.ulist[i].merchantUid
									+ "&nbsp;&nbsp; <a class='button small' href='/hiapt/ubdt?merchantUid="+ json.ulist[i].merchantUid 
									+ "&page=1'>당월고지서 인쇄</a>"
									+ "</a></td><tr><th scope='col'>당월부과액</th><td>"
									+ json.ulist[i].amount
									+ "원</a></td><tr><th scope='col'>미납액</th><td>"
									+ json.ulist[i].arrears
									+ "원</td><tr><th scope='col'>미납 연체료</th><td>"
									+ json.ulist[i].arrearsFine
									+ "원</td><tr><th scope='col'>납기내 금액</th><td>"
									+ json.ulist[i].beforeAmount
									+ "원</td><tr><th scope='col'>납기후 금액</th><td>"
									+ json.ulist[i].afterAmount
									+ "원</td></tr></table>"
								    +" <ul class='pager'><li class='previous'>"
								    + "<a href='/hiapt/views/user/maintenance/ReceiptList.jsp'>← 납부내역조회</a></li>"
								    + "<li class='next'><a href='/hiapt/paylist?merchantUid=" + json.ulist[i].merchantUid + "&page=1'>"
								    + "아파트관리비 납부하기 →</a></li></ul>";

						}
						$("#userBill").html($("#userBill").html() + values);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log("error : " + jqXHR + ", " + textStatus
								+ ", " + errorThrown);
					}
				});// end top1
	});
</script>
			<% } %>

	</div>
	<!-- end content -->


	</div>
	<!-- end container -->
</section>
<!-- end section -->

<!--  /// 본문 끝//////  -->

<%@ include file="../userfooter.jsp"%>
</body>
</html>
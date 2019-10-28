<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mail.model.vo.Mailm, mail.model.vo.MailBoxType, java.util.ArrayList"%>

<%
	ArrayList<Mailm> list = (ArrayList<Mailm>)request.getAttribute("list");
	ArrayList<MailBoxType> list2 = (ArrayList<MailBoxType>)request.getAttribute("list2");
	int currentPage = (Integer)request.getAttribute("currentPage");
	int beginPage = (Integer)request.getAttribute("beginPage");
	int endPage = (Integer)request.getAttribute("endPage");
	int maxPage = (Integer)request.getAttribute("maxPage");
	int listCount = (Integer)request.getAttribute("listCount");
	String title = (String)request.getAttribute("title");
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


<h3><%= title %> 검색(제목) 결과 : (<%= listCount %>)건</h3>
<hr>
<div class="card shadow mb-4">
<div class="card-body">
<input type="checkbox" id="checkall"> &nbsp;
<form method="post" name="form">
<input type="submit" value="삭제" onclick="javascript: form.action='/hiapt/movew'" class="btn btn-primary btn-sm shadow-sm" >
<input type="submit" value="이동" onclick="javascript: form.action='/hiapt/mtwrite'" class="btn btn-primary btn-sm shadow-sm" >
<input type="hidden" name="page" value="<%= currentPage %>">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
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
						<tr><td><input type="checkbox" name="mailno" value="<%= m.getMailNo() %>"></td>
						<td><%= m.getEmpEmail() %></td>
						<td><a href="/hiapt/mdetail?mailno=<%= m.getMailNo() %>&page=<%= currentPage %>&code=<%= code2 %>&allmail=<%= allmail %>">
						<%= m.getMailTitle() %></a></td>   
						<td><%= m.getMailTime() %></td>
						</tr>
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
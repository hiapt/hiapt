<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mail.model.vo.Mailm, java.util.ArrayList"%>

<%
	ArrayList<Mailm> list = (ArrayList<Mailm>)request.getAttribute("list");
	int currentPage = (Integer)request.getAttribute("currentPage");
	int beginPage = (Integer)request.getAttribute("beginPage");
	int endPage = (Integer)request.getAttribute("endPage");
	int maxPage = (Integer)request.getAttribute("maxPage");
	int mcode = (Integer)request.getAttribute("mcode");
	String name = (String)request.getAttribute("name");
	String code = Integer.toString(mcode);
%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>
<style>
#boxlist{
	list-style : none;
	margin : 0px;
}
#myboxlist{
	list-style : none;
	margin : 0px;
}
#typelist{
	display : none;
}
.search{
	float : right;
}
</style>
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
<script type="text/javascript">
$(function() {
	/* 이동 창 내 메일함 리스트 출력 */
	$.ajax({
		url : "/hiapt/mbtlist",
		type : "post",
		data : {empemail : $("#empemail").val()},
		dataType : "json",
		success : function(data){
			var jsonStr = JSON.stringify(data);
			var json = JSON.parse(jsonStr);
			
			var values = "";
			for(var i in json.list){
				values += "<li class='list'><a href='#' class='w' id='box"+ i +"'>" + decodeURIComponent(json.list[i].name).replace(/\+/gi, " ")
				+ "</a></li><input type='hidden' id='mcode"+ i +"' value='"+json.list[i].mcode+"'>";
				
			}
			
			$("#myboxlist").html($("#myboxlist").html() + values);
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
		}
	});
	
	/* 전체선택 / 전체취소 */
	$("#checkall").click(function() {

		if ($("#checkall").prop("checked")) {

			$("input[type=checkbox]").prop("checked", true);
		} else {
			$("input[type=checkbox]").prop("checked", false);
		}
		
	});
	
	/* 이동 */
	$("#receive").click(function(){
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&code=<%= code %>&mcode=1&mailno="+countno();  
	});
	
	$("#send").click(function(){
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&code=<%= code %>&mcode=2&mailno="+countno();    
	});
	
	$("#self").click(function(){
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&code=<%= code %>&mcode=4&mailno="+countno();	    
	});
	
	$("#trash").click(function(){
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&code=<%= code %>&mcode=5&mailno="+countno();	    
	});
	
	/* 검색창 */
	showDiv();

	$("select[name=searchselect]").on("change", function() {
		showDiv();
	});
	
});

/* 검색창 변경 */
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

// 체크된 메일 번호 반환
function countno(){
	var values = document.getElementsByName("mailno");
    var r = "";
    for(var i = 0; i<values.length; i++){
       if(values[i].checked) {
          r += values[i].value + ",";
       }
    }
    return r;
}

window.onload = function(){
	/* 새 메일함들 이동 */	
	$(".w").each(function(i){
		$(this).click(function(){
			var val = $("#mcode"+i).val();
			location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&code=<%= code %>&mcode="+val+"&mailno="+countno();		
		})
	});
	
	}
	
</script>
<!---탑 메뉴 끝 ------------------------------------------->
<!--========================================================================================== -->
<!-- Begin Page Content -->
<div class="container-fluid">
<!-- 본문 타이틀 들어가는 부분 ---->					
<!--///////본문 내용 시작 ///////-------->	


<h3><%= name %></h3>
<div class="card shadow mb-4">
<div class="card-body">
<form action="/hiapt/mtsearch" method="post">
<input type="search" id="title" name="title" class="search">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
</form>
<form action="#" method="post">
<input type="search" id="sender" name="sender" class="search">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
</form>
<form action="#" method="post">
<input type="search" id="recipient" name="recipient" class="search">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
</form>
<select id="searchselect" name="searchselect" class="search">
			<option selected="selected">제목</option>
			<option>보낸사람</option>
			<option>받는사람</option>			
</select>

<form method="post" name="form">
<input type="submit" value="삭제" onclick="javascript: form.action='/hiapt/movew'" class="btn btn-primary btn-sm shadow-sm" >
<button class="btn btn-primary btn-sm shadow-sm" type="button" id="dropdownMenuButton" data-toggle="dropdown">
  							이동</button>
  	<div id="drop-mail-box" class="dropdown-menu"> 
  		<ul id="boxlist" style="padding-left:7px;">
			<li class="list"><a href="#" id="all">받은 편지함</a></li>
			<li class="list"><a href="/hiapt/">보낸 편지함</a></li>
			<li class="list"><a href="/hiapt/">내게쓴편지함</a></li>
			<li class="list"><a href="/hiapt/">휴지통</a></li>
		</ul> 							
  	</div>
<input type="hidden" name="page" value="<%= currentPage %>">
<input type="hidden" name="empemail" value="<%= emp.getEmpEmail() %>">
<input type="hidden" name="code" value="<%= code %>">
<table class="table beauty-table table-hover" style="text-align: center;">
					<thead>
						<tr>
							<th width="10">
							<input type="checkbox" id="checkall">
							</th>
							<th width="75" style="text-align: center;">보낸사람</th>
							<!-- <th width="100" style="text-align: center;">제목</th> -->
							<th style="text-align: center;">제목</th>
							<th width="150" style="text-align: center;">시간</th>
							
						</tr>
						<% for(Mailm m : list){ %>					
						<tr><td><input type="checkbox" name="mailno" value="<%= m.getMailNo() %>"></td>
						<td><%= m.getEmpEmail() %></td>
						<td><a href="/hiapt/mdetail?mailno=<%= m.getMailNo() %>&page=<%= currentPage %>&code=<%= code %>">
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
						id="dataTable_previous"><a href="/hiapt/mymb?page=1&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
					<% if((beginPage - 10) < 1){ %>
					<li class="paginate_button page-item previous back"
						id="dataTable_previous"><a href="/hiapt/mymb?page=1&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } else { %>
					<li class="paginate_button page-item active back"
						id="dataTable_previous"><a href="/hiapt/mymb?page=<%= beginPage -10 %>&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable"
						data-dt-idx="<%= beginPage - 10 %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } %>
					<% if(currentPage == 0){ %>
					<li class="paginate_button page-item active"
						id="dataTable_previous"><a href="/hiapt/mymb?page=1&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">1</a></li>
					<% }else{ %>
					<% for(int p = beginPage; p <= endPage; p++){
						if(p == currentPage){	
					%>
					<li class="paginate_button page-item active next"><a href="/hiapt/mymb?page<%= p %>&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>"
						aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% } else { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/mymb?page=<%= p %>&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% } %>
					<% } %>
					<% } %>
					<% if((endPage + 10) > maxPage ) { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/mymb?page=<%= maxPage %>&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } else { %>	
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/mymb?page<%= endPage + 10 %>&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable" data-dt-idx="<%= endPage + 10 %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/mymb?page=<%= maxPage %>&mcode=<%= mcode %>&email=<%= emp.getEmpEmail() %>&name=<%= name %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;</a></li>
				</ul>
			</div>
		</div>
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
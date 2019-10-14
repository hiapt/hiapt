<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.Draft, java.util.ArrayList"%>
    
 <%
 	ArrayList<Draft> list = (ArrayList<Draft>)request.getAttribute("list");
 	
 %>
 
 <!--복사 시작 ////////////////////////////--------------------->
<!DOCTYPE html>
<html>
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

<!--// css or jQuery or javaScript 삽입 부분    -->

 <style>
	#searchselect{
	border: 1px solid #ccc;
	height: 30px;
	border-radius: 4px;
	}
	#search{
	border: 1px solid #ccc;
	height: 30px;
	border-radius: 4px;
	}

 </style>
 
 <script type="text/javascript">
$("#checkall").click(function() {

    if($("#checkall").prop("checked")) {

        $("input[type=checkbox]").prop("checked", true);
    }
    else {
        $("input[type=checkbox]").prop("checked",false);
    } 
});

$(function(){
	showDiv();
	
	$("select[name=searchselect]").on("change", function() {
		showDiv();
	});
});

function showDiv(){
	if($("#searchselect option:eq(0)").is(":selected")) {
		$("#title").css("display", "block");
		$("#writer").css("display", "none");
		$("#date").css("display", "none");
		$("#formtype").css("display", "none");
	}
	if($("#searchselect option:eq(1)").is(":selected")) {
		$("#title").css("display", "none");
		$("#writer").css("display", "block");
		$("#date").css("display", "none");
		$("#formtype").css("display", "none");
	}
	if($("#searchselect option:eq(2)").is(":selected")) {
		$("#title").css("display", "none");
		$("#writer").css("display", "none");
		$("#date").css("display", "block");
		$("#formtype").css("display", "none");
	}
	if($("#searchselect option:eq(3)").is(":selected")) {
		$("#title").css("display", "none");
		$("#writer").css("display", "none");
		$("#date").css("display", "none");
		$("#formtype").css("display", "block");
	}
}
	
</script>

</head>

<%@ include file="../../../top.jsp" %>

<!-- 본문 타이틀 들어가는 부분 ---->
<h1 class="h3 mb-4 text-gray-800">제목 샘플</h1>
					
<!--///////본문 내용 시작 ///////-------->

<div style="float: right; display: flex;">
<div>
<select id="searchselect" name="searchselect" style="width: 100px; padding-left: 5px;">
<option name="opt1" selected="selected">제목</option>
<option name="opt2" id="opt2">작성자</option>
<option name="opt3" id="opt3">날짜</option>
<option name="opt4" id="opt4">문서형식</option>
</select>
</div>
<div id="title">
<form action="/hiapt/dsearch" method="post">
<input type="hidden" name="search" value="title">
<i class="fa fa-search" style="position: relative; left: 14px;"></i>
<input type="search" id="search" name="keyword"
style="width: 250px; position: static; padding-left: 28px; margin-left: -12px;" placeholder="검색할 제목을 입력하세요.">
<input type="submit" value="검 색" class="btn btn-default btn-xs"  style="border-radius: 0px 4px 4px 0px; position: relative; right: 17px;" >
</form>
</div>
<div id="writer">
<form action="/hiapt/dsearch" method="post">
<input type="hidden" name="search" value="writer">
<i class="fa fa-search" style="position: relative; left: 14px;"></i>
<input type="search" id="search" name="keyword"
style="width: 250px; position: static; padding-left: 28px; margin-left: -12px;"  placeholder="검색할 작성자를 입력하세요.">
<input type="submit" value="검 색" class="btn btn-default btn-xs"  style="border-radius: 0px 4px 4px 0px; position: relative; right: 17px;" >
</form>
</div>
<div id="date">
<form action="/hiapt/dsearch" method="post">
<input type="hidden" name="search" value="date"> &nbsp;
<input type="date" name="from" id="search" style="padding-left: 10px; width: 130px;">
 ~ <input type="date" name="to" id="search" style="padding-left: 10px; width: 130px;">
<input type="submit" value="검 색" class="btn btn-default btn-xs"  style="border-radius: 4px ; margin-left: 4px;" >
</form>
</div>
<div id="formtype">
<form action="/hiapt/dsearch" method="post">
<input type="hidden" name="search" value="formtype">
<i class="fa fa-search" style="position: relative; left: 14px;"></i>
<input type="search" id="search" name="keyword"
style="width: 250px; position: static; padding-left: 28px; margin-left: -12px;" placeholder="검색할 문서형식을 입력하세요.">
<input type="submit" value="검 색" class="btn btn-default btn-xs"  style="border-radius: 0px 4px 4px 0px; position: relative; right: 17px;" >
</form>
</div>
</div>
<br>
<form action="" method="post">
<h4>전체 문서 : <%= list.size() %>개 </h4>
<table class="table beauty-table table-hover" style="text-align: center;">
					<thead>
						<tr>
							<th width="10">
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<input type="checkbox"  id="checkall">
								<i class="fa fa-square-o small"></i>
							</label>
							</div></th>
							<th width="75" style="text-align: center;">첨부파일</th>
							<th width="100" style="text-align: center;">문서번호</th>
							<th style="text-align: center;">제목</th>
							<th width="150" style="text-align: center;">기안자</th>
							<th width="100" style="text-align: center;">기안일</th>
							<th width="150" style="text-align: center;">문서종류</th>
							<th width="80" style="text-align: center;">진행상태</th>
						</tr>
					</thead>
					<% for(int i = 0; i < list.size(); i++) { 
							Draft d = list.get(i);%>
					<tbody>
						<tr>
							<td>				
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<input type="checkbox">
								<i class="fa fa-square-o small"></i>
							</label>
							</div>
							</td>
							<td><i class="fa fa-paperclip"></i></td>
							<td><%= d.getDocno() %></td>
							<td><a href="/hiapt/dview?docno=<%=  d.getDocno() %>"><%= d.getDoctitle()%></a></td>
							<td><%= d.getEmpid() %>&nbsp;<%= d.getEmpname()%>
							<td><%= d.getDraftdate() %></td>
							<td><%= d.getFormname()%></td>
							<td><% if(d.getProgress().equals("0")){ %>
							 대기
							 <% } else if (d.getProgress().equals("1")) { %>
							 승인
							<%} else if (d.getProgress().equals("2")) { %>
							반려
							<% } else if (d.getProgress().equals("3")){ %>
							보류
							<% } %> 
							</td>
						</tr>
					</tbody>
					<%} %>
				</table>	
	<div style="float: right;">
	<input type="button" value="이동" class="btn btn-default btn-xs" style="letter-spacing: 7px; padding-left: 10px;">
	</div>
</form>



<!---//// 본문 내용 끝 ///////------------------->
<%@ include file = "../../../footer.html" %>
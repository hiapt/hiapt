<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="mybox.model.vo.Mybox, java.util.ArrayList"%>
    <%
    ArrayList<Mybox> list = (ArrayList<Mybox>) request.getAttribute("list");
    %>
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
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.min.js" type="text/javascript"></script>    

  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>  
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
		<br>
	<div class="card shadow mb-4">
		<div class="card-body" align="center">
			
			<form action="/hiapt/myadd" method="post">
			<div id="myadd" style="position: absolute; width: 550px; height: 60px; background: #eaecf1; 
			left: 20%; top: 35%; border-radius: 5px; padding-top: 15px; display: none; border: 1px solid #ddd;">
			<input type="text" name="myboxname" style="width: 400px; height: 30px; border: 1px solid #ddd; border-radius: 3px;  padding-left: 15px;">&nbsp;&nbsp;
			<input type="submit" value=" 등 록 " class="btn btn-primary btn-icon-split btn-sm" style="padding: 4px; margin-bottom: 2px;"> &nbsp;
			<input type="button" value=" 취 소 " id="cancel" class="btn btn-secondary btn-icon-split btn-sm" style="padding: 4px; margin-bottom: 2px;"> 
			<input type="hidden" value="<%= emp.getEmpNo()%>" name="empno">
			</div>
			</form>

			<table class="table beauty-table table-hover"
				style="text-align: center; ">
				
					<tr>
						<th width="10" >
							<label class="check">
       					     <input type="checkbox" id="checkall">
         					 <span class="checkmark"></span>
          				 	 </label>
						</th>
						<th width="150">내문서함 번호</th>
						<th>문서함 이름</th>
					</tr>
				<%
					for (int i = 0; i < list.size(); i++) {
						Mybox m = list.get(i);
				%>
			
					<tr>
						<td>
						<label class="check">
       				    <input type="checkbox">
       					<span class="checkmark"></span>
        			    </label>
						</td>
						<td><%= m.getMyboxcode() %></td>
						<td><a href="/hiapt/mylist.emp?empno=<%= emp.getEmpNo() %>&myboxcode=<%= m.getMyboxcode() %>&page=1"><%= m.getMyboxname() %></a></td>
					</tr>
				<%
					}
				%>
			
			</table>
		</div>
	</div>
	<input type="button" class="btn btn-primary btn-icon-split" value="내문서함 등록" style="padding: 7px;" 
	id="add">
	<script type="text/javascript">
	$("#checkall").click(function() {

		if ($("#checkall").prop("checked")) {

			$("input[type=checkbox]").prop("checked", true);
		} else {
			$("input[type=checkbox]").prop("checked", false);
		}
	});

	$(function () {
		$("#add").click(function() {
			if($("tr").length < 10){
			$("#myadd").css("display", "block");
			}else {
				alert("내문서함은 9개까지만 생성 가능합니다.");
			}

	});
		$("#cancel").click(function() {
			$("#myadd").css("display", "none");

	});
	});

	$(function() {
		$("#myadd").draggable({
			cursor : "move",
			opacity : 0.7
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.DraftProcess, java.util.ArrayList"%>

<%  
	DraftProcess dp = (DraftProcess) request.getAttribute("dp"); 
	ArrayList<DraftProcess> dplist = (ArrayList<DraftProcess>) request.getAttribute("dplist");
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
<script type="text/javascript">
$(function() {
	
$("#approvebtn").click(function(){
	$("[name='sresult']").val("1");
		var a = confirm("승인 하시겠습니까?");
    	if(a) {
      	$("#sign").submit();
    	}else {
    	
    	}
	});
$("#returnbtn").click(function(){
	$("[name='sresult']").val("2");
		var a = confirm("반려 하시겠습니까?");
    	if(a) {
    		if($("textarea#feed").val() == null || $("textarea#feed").val() == ""){
    			alert("반려시 첨삭 및 의견란을 작성해주세요.");
    			$("textarea#feed").focus();
    		}else{
      		$("#sign").submit();
    		}
    	}else {
    	
    	}
	});
$("#deferbtn").click(function(){
	$("[name='sresult']").val("3");
		var a = confirm("보류 하시겠습니까?");
    	if(a) {
    		if($("textarea#feed").val() == null || $("textarea#feed").val() == ""){
    			alert("보류시 첨삭 및 의견란을 작성해주세요.");
    			$("textarea#feed").focus();
    		}else{
      		$("#sign").submit();
    		}
    	}else {
    	
    	}
	});

	


});

</script>

<style type="text/css">
body {
	color: #444;
}

fieldset {
	width: 900px;
}

th {
	border: solid 1.5px #777;
	border-collapse: collapse;
	padding: 7px;
	text-align: center;
	font-size: 11pt;
	height: 30px;
	background-color: #eee;
	color: black;
}

td {
	border: solid 1.5px #777;
	border-collapse: collapse;
	padding-top: 7px;
	padding-bottom: 7px;
	text-align: center;
	font-size: 11pt;
	height: 30px;
	color: black;
	font-weight: 600; 
	background-color: white;

}


#formselect {
	border-radius: 4px;
	border: none;
	width: 205px;
	height: 28px;
	padding-left: 5px;
	color: #5a5c69;
}

#boxselect {
	border-radius: 4px;
	border: none;
	width: 175px;
	height: 28px;
	padding-left: 5px;
	color: #5a5c69;
}
legend {
	font-weight: bold;
	font-size: 13pt;
	color: #5a5c69;
	line-height: 45px;
	margin-bottom: 15px;
	border-bottom: solid 1px #777;
	text-align: left;
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
<% if (emp.getEmpNo().contains(empno)) { %>
<form method="post" action="/hiapt/dsign" id="sign">
<input type="hidden" value="<%= emp.getEmpNo() %>" name="empno">
<div class="row" style="margin-left: 2px;">
		<input type="hidden" name="sresult" >
		<input type="hidden" name="docno" value="<%= dp.getDocno() %>">
		<input type="button" value=" 승 인 " class="btn btn-primary btn-icon-split" id="approvebtn" style="padding: 7px;">
		 
		<input type="button" value=" 반 려 " class="btn btn-danger btn-icon-split" id="returnbtn" style="padding: 7px; margin-left: 25px;">
			
		<input type="button" value=" 보 류 " class="btn btn-warning btn-icon-split" id="deferbtn" style="padding: 7px; margin-left: 25px;">
</div>
<br>
<div class="card shadow mb-4">
		<div class="card-body" align="center">
<br>
<div style="text-align: center; width: 900px; color: #444; " >
<h2 >일반기안문서</h2><br>
<h2>제목 : <%= dp.getDoctitle()%></h2> <br>
<table style="width:900px; height: 50px;" id="view">
<tr>
<th style="width: 10%; height: 30px;">작성자</th>
<td style="width: 16%;">
 <%= dp.getEmpid() %> <%= dp.getEmpname()%>
</td>
<th style="width: 16%;">기안일</th>
<td style="width: 16%;">
<%= dp.getDraftdate() %> 
</td>
<th style="width: 16%;">결재 기한</th>
<td style="width: 16%;">
<%= dp.getDeadline() %> 
</td>
</tr>
<tr>
<th rowspan="2">결재</th>
<td style="height: 120px; font-size: 40pt; padding: 15px 0px 0px 20px;" align="center">
<%if (dplist.size() > 0){ %>
<%if(dplist.get(0).getSignresult().equals("1")){ %> 
<h3 style="margin-left:20px; width: 75px; height: 75px; font-weight: bold; color: #6265aa; border: 4px solid #6265aa; border-radius: 50px; padding-top: 18px;">
승인 
<h6 style="margin-right:30px;"><%= dplist.get(0).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(0).getSignresult().equals("2")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #c55656; border: 3px solid #c55656; border-radius: 50px; padding-top: 18px;">
반려
<h6 style="margin-right:30px;"><%= dplist.get(0).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(0).getSignresult().equals("3")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #844798; border: 3px solid #844798; border-radius: 50px; padding-top: 18px;">
보류
<h6 style="margin-right:30px;"><%= dplist.get(0).getAppdate() %></h6>
</h3>
<% }} %>
</td>
<td style="height: 120px; font-size: 40pt; padding: 10px 0px 0px 20px;">
<%if (dplist.size() > 1){ %>
<%if(dplist.get(1).getSignresult().equals("1")){ %> 
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #6265aa; border: 4px solid #6265aa; border-radius: 50px; padding-top: 18px;">
승인 
<h6 style="margin-right:30px;"><%= dplist.get(1).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(1).getSignresult().equals("2")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #bf3636; border: 3px solid #bf3636; border-radius: 50px; padding-top: 18px;">
반려
<h6 style="margin-right:30px;"><%= dplist.get(1).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(1).getSignresult().equals("3")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #844798; border: 3px solid #844798; border-radius: 50px; padding-top: 18px;">
보류
<h6 style="margin-right:30px;"><%= dplist.get(1).getAppdate() %></h6>
</h3>
<% } %>
<%} %>
</td>
<td style="height: 120px; font-size: 40pt; padding: 10px 0px 0px 20px;"><%if (dplist.size() > 2){ %>
<%if(dplist.get(2).getSignresult().equals("1")){ %> 
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #6265aa; border: 4px solid #6265aa; border-radius: 50px; padding-top: 18px;">
승인 
<h6 style="margin-right:30px;"><%= dplist.get(2).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(2).getSignresult().equals("2")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #bf3636; border: 3px solid #bf3636; border-radius: 50px; padding-top: 18px;">
반려
<h6 style="margin-right:30px;"><%= dplist.get(2).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(2).getSignresult().equals("3")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #844798; border: 3px solid #844798; border-radius: 50px; padding-top: 18px;">
보류
<h6 style="margin-right:30px;"><%= dplist.get(2).getAppdate() %></h6>
</h3>
<% } %>
<%} %>
</td>
<td style="height: 120px; font-size: 40pt; padding: 10px 0px 0px 20px;">
<%if (dplist.size() > 3){ %>
<%if(dplist.get(3).getSignresult().equals("1")){ %> 
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #6265aa; border: 4px solid #6265aa; border-radius: 50px; padding-top: 18px;">
승인 
<h6 style="margin-right:30px;"><%= dplist.get(3).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(3).getSignresult().equals("2")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #bf3636; border: 3px solid #bf3636; border-radius: 50px; padding-top: 18px;">
반려
<h6 style="margin-right:30px;"><%= dplist.get(3).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(3).getSignresult().equals("3")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #844798; border: 3px solid #844798; border-radius: 50px; padding-top: 18px;">
보류
<h6 style="margin-right:30px;"><%= dplist.get(3).getAppdate() %></h6>
</h3>
<% } %>
<%} %></td>
<td style="height: 120px; font-size: 40pt; padding: 10px 0px 0px 20px;">
<%if (dplist.size() > 4){ %>
<%if(dplist.get(5).getSignresult().equals("1")){ %> 
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #6265aa; border: 4px solid #6265aa; border-radius: 50px; padding-top: 18px;">
승인 
<h6 style="margin-right:30px;"><%= dplist.get(4).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(5).getSignresult().equals("2")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #bf3636; border: 3px solid #bf3636; border-radius: 50px; padding-top: 18px;">
반려
<h6 style="margin-right:30px;"><%= dplist.get(4).getAppdate() %></h6>
</h3>
<% }else if(dplist.get(5).getSignresult().equals("3")) { %>
<h3 style="margin-left:20px; width: 70px; height: 70px; font-weight: bold; color: #844798; border: 3px solid #844798; border-radius: 50px; padding-top: 18px;">
보류
<h6 style="margin-right:30px;"><%= dplist.get(4).getAppdate() %></h6>
</h3>
<% } %>
<%} %></td>
</tr>
<tr>
<td>
<%if(dp.getAppname1() != null ){ %>
<%= dp.getAppid1() %> <%= dp.getAppname1() %>
<%} %>
</td>
<td>
<%if(dp.getAppname2() != null ){ %>
<%= dp.getAppid2() %> <%= dp.getAppname2() %>
<%} %>
</td>
<td>
<%if(dp.getAppname3() != null ){ %>
<%= dp.getAppid3() %> <%= dp.getAppname3() %>
<%} %>
</td>
<td>
<%if(dp.getAppname4() != null ){ %>
<%= dp.getAppid4() %> <%= dp.getAppname4() %>
<%} %>
</td>
<td>
<%if(dp.getAppname5() != null ){ %>
<%= dp.getAppid5() %> <%= dp.getAppname5() %>
<%} %>
</td>
</tr>
<tr>
<th style="height: 30px;">공람자</th>
<td colspan="5">
<%if(dp.getDisname1() != null){ %>
<%=dp.getDisid1()%> <%=dp.getDisname1() %>
<%} %> 
<%if(dp.getDisname2() != null){%>
, <%=dp.getDisid2()%> <%=dp.getDisname2() %>
<% } %> 
<%if(dp.getDisname3() != null){%>
, <%=dp.getDisid3()%> <%=dp.getDisname3() %>
<% } %>
<%if(dp.getDisname4() != null){%>
, <%=dp.getDisid4()%> <%=dp.getDisname4() %>
<% } %>
<%if(dp.getDisname5() != null){%>
, <%=dp.getDisid5()%> <%=dp.getDisname5() %>
<% } %>
</td>

</tr>
</table>
<div style="width:900px; height:450px; background-color: none; margin-top: 15px;" align="center">
<div id="smarteditor"  style="width:900px; height:1000px; border: 1px solid #777; resize: none; padding: 30px;">
<%= dp.getDoccontent() %></div>
</div>
</div>

<div id="hide" style="margin-top: 600px;">
<fieldset style="margin-top: 20px;">
<legend>첨부파일</legend>
</fieldset><br>
<div style="text-align: left; padding-left: 25px; margin-top: -20px;">
<% if(dp.getOriginfile() != null) {%>
<a href="/hiapt/dfiled?ofile=<%= dp.getOriginfile() %>&rfile=<%= dp.getRenamefile() %>"><%= dp.getOriginfile() %></a>
<% } else { %>
	첨부파일 없음
<% } %>
</div>
<fieldset style="margin-top: 20px;">
<legend>첨삭 및 의견</legend>
</fieldset>
<textarea id="feed" name="feedback" style="width:900px; height:120px; border: 1px solid #777; resize: none; padding: 15px;" placeholder="첨삭 및 의견을 작성해주세요.">
</textarea>
</div>
<br>
</div>
</div>
</form>
<% } else { %>
<div style="font-size: 40pt; color: #b31" align="center" ><br> 결재 페이지 접근 권한이 없습니다. </div>
<%} %>

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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="draft.model.vo.Draft, java.util.ArrayList"%>

<%  
	Draft draft = (Draft) request.getAttribute("draft"); 
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
<script type="text/javascript" src="/hiapt/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>


<style type="text/css">
body {
	color: #444;
}

fieldset {
	width: 900px;
}

th {
	border: solid 1px #fff;
	border-collapse: collapse;
	padding: 15px;
	text-align: center;
	font-size: 11pt;
	height: 60px;
	background-color: rgba(87, 104, 173, 0.9);
	color: #f8f9fc;
}

td {
	border: solid 1px #fff;
	border-collapse: collapse;
	padding-top: 15px;
	padding-bottom: 15px;
	text-align: center;
	font-size: 11pt;
	height: 60px;
	color: #5a5c69;
	font-weight: 600; 
	background-color: rgba(87, 104, 173, 0.15);

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
	border-bottom: dashed 1px #5a5c69;
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
<% if (draft.getDisplay().contains(emp.getEmpNo()) || emp.getEmpNo().equals(draft.getEmpno()) || draft.getAppempno().contains(emp.getEmpNo())) { %>

<button onclick="printDiv();" class="btn btn-secondary btn-icon-split" style="padding: 7px;">&nbsp;인 쇄&nbsp;</button>
<br>
<br>
<div class="card shadow mb-4" id="test">
		<div class="card-body" align="center">
<br>
<div style="text-align: center; width: 900px; color: #214c70; " >
<h2 ><%= draft.getDocno() %> - <%= draft.getFormname() %></h2><br>
<h2>제목 : <%= draft.getDoctitle()%></h2> <br>
<table style="width:900px; height: 50px;" >

<tr>

<th style="width: 120px;">작성자</th>
<td width="120px;" style="width: 120px;">
<%= draft.getEmpid() %> <%= draft.getEmpname() %>
</td>
<th style="width: 120px;">결재자</th>
<td width="120px;" style="width: 120px;">


</td>
</tr>
<tr>
<th style="width: 120px;">공개 여부</th>
<td width="25%">
<% if(draft.getDisplay().equals("Y")) { %>
전체 공개
<% } else { %>
비공개
<% } %>
</td>

<th style="width: 120px;">결재 여부</th>
<td width="25%" >
<% if (draft.getDocstatus().equals("0")) { %> 
	대기
<% } else if (draft.getDocstatus().equals("1")) { %> 
	승인
<% } else if (draft.getDocstatus().equals("2")) { %> 
	반려 
<% } else if (draft.getDocstatus().equals("3")) { %> 
	보류 
<% }%>
</td>


</tr>
</table>
<div style="width:900px; height:450px; background-color: none; margin-top: 15px;" align="center">
<div id="smarteditor"  style="width:895px; height:1000px; border: 1px solid rgba(87, 104, 173, 0.9); ; resize: none; padding: 30px;">
<%= draft.getDoccontent() %></div>
</div>
</div>
<div id="hide" style="margin-top: 600px;">
<div style="line-height: 1px; font-weight: bold; color: #5a5c69; float: left; margin-left: 25px;">첨부파일</div><br>
<hr width="895px" align="center" style="border: 1px dashed #5a5c69;"><br><br>
<% if (draft.getFeedback() != null) { %>
<div  style="width:900px; height:180px; background: #9598a3; text-align: center; padding-top: 25px" >
<div style="color: white; font-size: 12pt; font-weight: bolder; text-shadow: 1px 1px 1px  rgba(0, 0, 0, 0.3);"> 첨삭 및 의견 </div> 
<textarea style="width:870px; height:	100px; border: none;  ;margin-top: 15px; resize: none; padding: 15px;" readonly="readonly">
<%= draft.getFeedback() %>
</textarea>
</div>
</div>
<% } %>
<br>
</div>
</div>

<%} else { %>
<div style="font-size: 40pt; color: #b31" align="center" ><br> 해당 문서에 대한 접근 권한이 없습니다. </div>
<%} %>

<script type="text/javascript">
function printDiv() {
    // 안보이게 할 영역 숨기기
    $("#hide").hide();
    
    //인쇄
    var initBody = document.body.innerHTML;
    window.onbeforeprint = function () {
       document.body.innerHTML = document.getElementById("test").innerHTML;
    }
    window.onafterprint = function () {

       document.body.innerHTML = initBody;
    }
    window.print();
    
    // 인쇄창 끄면 다시 보이게
    $("#hide").show();
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

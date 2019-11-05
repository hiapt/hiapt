<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.text.*"%>
<%
	Date date =new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
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
<!-- Custom styles for this template-->
<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/hiapt/resources/css/basic.css" rel="stylesheet">

<!-- Bootstrap core JavaScript-->
<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->

<style>

td{
border :  solid 3px #fff;
}

#AptMain{
	border: none;
	border-collapse: collapse;
	padding: 15px;
	text-align: center;
	font-size: 11pt;
	height: 50px;
	background-color: #4e73df;
	color: #f8f9fc;
	/* border-radius: 9px; */
	width : 10%;
}

#AptTitle{
	border:none;
	border-collapse: collapse;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-right:10px;
	text-align: right;
	font-size: 10.5pt;
	height: 50px;
	color: #5a5c69;
	font-weight: 600; 
	width:10%;
}

#AptData{
	border: none;
	border-collapse: collapse;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left:15px;
	text-align: left;
	font-size: 10.5pt;
	height: 50px;
	color: #5a5c69;
	font-weight: 600; 
	width:20%;
}

#button{
	align:right;

}

</style>

</head>

<script type="text/javascript" src="/hiapt/resources/js/bootstrap.min.js"></script>
<script>
function validation(){
	return true; //전송함
}

$('input[type="text"]').keydown(function() {
    if (eventkeyCode === 13) {
        event.preventDefault();
    }
});
function moveFocus(next){
	if(eventkeycode == 13){
		document.getElementById(next).Focus();
	}
}

$(function(){
	$('#aptenroll').on('submit', function(event){
	var dong = $("#dong");
	var ho = $("#ho");
	var username = $('input[name=username]');
	var userphone = $('input[name=userphone]');
	
	var dongVal = $("#dong").val();
	var hoVal = $("#ho").val();
	var usernameVal = $('input[name=username]').val();
	var userphoneVal = $('input[name=userphone]').val();
	
	
	if(dongVal == ""){
		alert('동을 입력하세요');
		dong.focus();
		return false;
	}
	
	 if(hoVal == ""){
		alert('호수를 입력하세요');
		ho.focus();
		return false;
	}
	 
	if(usernameVal == ""){
		alert('세대주명을 입력하세요');
		username.focus();
		return false;
	}
	
	if(userphoneVal == ""){
		alert('핸드폰번호를 입력하세요');
		userphone.focus();
		return false;
	}	
	
	if(invalidPhone(empphoneVal)){
		alert('핸드폰 번호를 양식에 맞게 입력해주세요.');
		empphone.select();
		return false;
	}
	
	$(this).submit();
	//event.preventdefault();
	return true;

	});
});

function invalidPhone(value){
	var invalidP = false;

	var re = /^0(2|1[01689])-[0-9]{4}-[0-9]{4}$/;
	if(!re.test(value))
		invalidP = true;

	return invalidP;
} 
</script>

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
<h1 class="btn btn-primary btn-icon-split" style=" width:100px; height:30px; text-align:center;">입주자 등록</h1>

<div class="card shadow mb-4">
<div class="card-body">

<form action="/hiapt/aptenroll" method="post" onsubmit="return validation();" id="aptenroll">
<!-- <table class="table table-bordered dataTable"> -->
<table style=" width:1000px; border:0px; padding:20px; margin:auto;" cellpadding="0" cellspacing="1" >
<tbody>
	<tr>
		<th id="button" colspan="2" style="text-align:right;">
		<input type="button" value="취소"  class="btn btn-primary btn-icon-split" style=" width:50px; height:30px; text-align:center;"
onclick="location.href='/hiapt/aptlist'">  &nbsp;
		<input type="submit" value="등록 " 
				class="btn btn-primary btn-icon-split" id="button" style="padding: 3px;">
		</th>
	</tr>

	<tr>
		<td>
			<table style="width:100%; border-collapse: collapse; margin-bottom:10px; 
			border: 2px solid #4e73df; border-radius: 9px;"cellpadding="0" cellspacing="1">
			<tbody>
				<tr>
				<th id="AptMain">입주</th>
					<td id="AptTitle">동*</td>
					<td id="AptData"><input type="text" name="userid" id="dong" size="7"></td>
					<td id="AptTitle">호*</td>
					<td id="AptData"><input type="text" name="userid" id="ho" size="7"></td>
					<td id="AptTitle">입주일*</td>
					<td id="AptData"><input type="date" name="userenroll" id="userenroll" value="<%= sysdate %>"></td>
				</tr>
			</tbody>
			</table>
		</td>
	</tr>
		
	<tr>
		<td>
			<table style="width:100%; border-collapse: collapse; margin-bottom:10px; 
			border: 2px solid #4e73df; border-radius: 9px;"cellpadding="0" cellspacing="1">
			<tbody>
				<tr>
				<th id="AptMain" rowspan="3">세대주</th>
					<td id="AptTitle">성명*</td>
					<td id="AptData"><input type="text" name="username"></td>
					<td id="AptTitle">생년월일</td>
					<td id="AptData"><input type="date" name="userbirth" value="<%= sysdate %>"></td>
					<td id="AptTitle"></td>
					<td id="AptData"></td>
				</tr>				
				<tr>
					<td id="AptTitle">연락처*</td>
					<td id="AptData"><input type="text" name="userphone"></td>
					<td id="AptTitle">이메일</td>
					<td id="AptData"><input type="email" name="useremail" size="25"></td>
					<td id="AptTitle"></td>
					<td id="AptData"></td>
				</tr>
				<tr>
					<td id="AptTitle">기타</td>
					<td id="AptData" colspan="5"><textarea name="useretc" rows="5" cols="100"></textarea></td>			
				</tr>				
			</tbody>
			</table>
		</td>
	</tr>
			
	<tr>
		<td>
			<table style="width:100%; border-collapse: collapse; margin-bottom:10px; 
			border: 2px solid #4e73df; border-radius: 9px;"cellpadding="0" cellspacing="1">
			<tbody>
				<tr>
				<th id="AptMain">차량정보</th>
					<td id="AptTitle">차종</td>
					<td id="AptData"><input type="text" name="cartype"></td>
					<td id="AptTitle">차량번호</td>
					<td id="AptData"><input type="text" name="carno"></td>
					<td id="AptTitle">차량등록일</td>
					<td id="AptData"><input type="date" name="carenroll" value="1900-01-01"></td>
				</tr>
			</tbody>
			</table>
		</td>
	</tr>
	

			
</tbody>
</table>

<!-- <tr>
<th rowspan="2">세대주</th>
<td>성명</td><td><input type="text" name="username" size="10"></td><td><input type="date" name="birth"></td><br>
<td>성명</td><td><input type="text" name="username" size="10"></td><td><input type="date" name="birth"></td> -->






</form>



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
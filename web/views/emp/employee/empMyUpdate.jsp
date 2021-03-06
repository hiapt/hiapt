<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "employee.model.vo.Employee"%>

<% 
	Employee employee = (Employee)request.getAttribute("emp"); 
	String[] addressAll = employee.getEmpAddress().split(",");
	//String[] array = new String[3];
	for(int i=0 ; i<addressAll.length ; i++)
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
.check {
	    display: inline-block !important;
}


th{
	text-align: center;
}

#date, #job {
	height:25px;
}

#empMain{
	border: solid white 1px;
	border-collapse: collapse;
	padding: 5px;
	text-align: center;
	font-size: 10pt;
	height: 40px;
	background-color: #4e73df;
	color: #f8f9fc;
	/* border-radius: 9px; */
	width : 10%;
}

#empData{
	border: none;
	border-collapse: collapse;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left:10px;
	text-align: left;
	font-size: 10.5pt;
	height: 50px;
	color: #5a5c69;
	font-weight: 600; 
}

#empHeader{
	border: none;
	border-collapse: collapse;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left:10px;
	text-align: center;
	font-size: 10.5pt;
	height: 50px;
	color: #5a5c69;
	font-weight: 600; 
	border-bottom: 1px solid #4e73df;
}

#salarytitle1{
	border: none;
	border-collapse: collapse;
	padding: 5px;
	text-align: center;
	font-size: 10pt;
	height: 10px;
	background-color: #6482b9;
	color: white;
	/* border-radius: 9px; */
}

#salarytitle2{
	border: none;
	border-collapse: collapse;
	padding: 5px;
	text-align: center;
	font-size: 10pt;
	height: 10px;
	background-color: #a297bd;
	color: white;
	/* border-radius: 9px; */
}

#SalaryItemData {
    height: 30px;
    border-color: #c4cfda;
    border-left: 0.08em solid #c4cfda;
    border-top: 0.08em solid #c4cfda;
    border-right: 0.08em solid #c4cfda;
    border-bottom: 0.08em solid #c4cfda;
    padding-left: 5px;
    text-align: left;
    font-size: 10pt;
}

#SalaryItemData2 {
    height: 30px;
    border-color: #c4cfda;
    border-left: 0.08em solid #c4cfda;
    border-top: 0.08em solid #c4cfda;
    border-right: 0.08em solid #c4cfda;
    border-bottom: 0.08em solid #c4cfda;
    padding-left: 5px;
    text-align: center;
    font-size: 10pt;
}

</style>



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
	$('#enroll').on('submit', function(event){
	var empname = $('input[name=empname]');
	var empid = $('select[name=empid] option:selected');
	var empphone = $('input[name=empphone]');
	var empssn = $('input[name=empssn]');	
	

	var empnameVal = $('input[name=empname]').val();
	var empidVal = $('select[name=empid] option:selected').val();
	var empphoneVal = $('input[name=empphone]').val();
	var empssnVal = $('input[name=empssn]').val();

	
	
	if(empnameVal == ""){
		alert('직원명을 입력하세요');
		empname.focus();
		return false;
	}
	
	 if(empidVal == ""){
		alert('직급을 입력하세요');
		empid.focus();
		return false;
	}
	 
	if(empphoneVal == ""){
		alert('휴대전화를 입력하세요');
		empphone.focus();
		return false;
	}
	

	if(invalidPhone(empphoneVal)){
		alert('핸드폰 번호를 양식에 맞게 입력해주세요.');
		empphone.select();
		return false;
	}
	
	if(empssnVal == ""){
		alert('주민번호를 입력하세요');
		empssn.focus();
		return false;
	}
	

	if(invalidSSN(empssnVal)){
		alert('주민번호양식에 맞게 입력해주세요.');
		empssn.select();
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

function invalidSSN(value){
	var invalidS = false;

	var re = /^[0-9]{6}-[0-9]{7}$/;
	if(!re.test(value))
		invalidS = true;

	return invalidS;
}

</script>
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
<!-- 본문 타이틀 들어가는 부분 ---->		


			
<!--///////본문 내용 시작 ///////-------->	
<h1 class="h3 mb-4 text-gray-800">내정보 수정</h1>

<div class="card shadow mb-4">
<form action="/hiapt/myupdsend" method="post" onsubmit="return validation();" id="enroll">
<table style=" width:1000px; border:0px; padding:20px; margin:auto;" cellpadding="0" cellspacing="1" >
<tbody>
	<tr>
		<td>
			<table style="width:100%; border-collapse: collapse; margin-bottom:10px; 
			border: 2px solid #4e73df; border-radius: 9px;"cellpadding="0" cellspacing="1">
			<tbody>
			
	<tr>
		<th style="text-align:center;" id="empMain">사 번*</th>
		<td id="empData" style="width:40%;"><input type="text" name="empno" id="empno" readonly style="background-color: #e2e2e2;" value="<%= employee.getEmpNo() %>"></td>
		<th style="text-align:center;" id="empMain">입사일*</th>
		<td id="empData"><input type="date" name="emphiredate" id="date" value="<%= employee.getEmpHireDate() %>" readonly></td>
	</tr>
	
	<tr>
		<th style="text-align:center;" id="empMain">이 름*</th>
		<td id="empData" style="width:40%;"><input type="text" name="empname" id="name" style="border:none;" value="<%= employee.getEmpName() %>"></td>
		<th style="text-align:center;" id="empMain">직 급*</th>
		<td id="empData">
			<% 
			if(employee.getEmpId().equals("관리자") == true){ %>
			<select name="empid">
			<option value="관리자" selected> 관리자</option>
			<option value="보안직원"> 보안직원 </option>
			<option value="경리" > 경리 </option>
			<option value="설비과장" > 설비과장 </option>
			<option value="검침기사" > 검침기사</option>
			</select>
			<% }else if(employee.getEmpId().equals("보안직원") == true){ %>
			<select name="empid">
			<option value="관리자" hidden> 관리자</option>
			<option value="보안직원" selected> 보안직원 </option>
			<option value="경리" > 경리 </option>
			<option value="설비과장" > 설비과장 </option>
			<option value="검침기사" > 검침기사</option>
			</select>
			<% }else if(employee.getEmpId().equals("경리") == true){ %>
			<select name="empid">
			<option value="관리자" hidden> 관리자</option>
			<option value="보안직원" > 보안직원 </option>
			<option value="경리" selected> 경리 </option>
			<option value="설비과장"> 설비과장 </option>
			<option value="검침기사"> 검침기사</option>
			</select>
			<% }else if(employee.getEmpId().equals("설비과장") == true){ %>
			<select name="empid" hidden>
			<option value="관리자 "> 관리자</option>
			<option value="보안직원"> 보안직원 </option>
			<option value="경리" > 경리 </option>
			<option value="설비과장" selected> 설비과장 </option>
			<option value="검침기사"> 검침기사</option>
			</select>
			<% }else if(employee.getEmpId().equals("검침기사") == true){ %>
			<select name="empid">
			<option value="관리자 " hidden> 관리자</option>
			<option value="보안직원"> 보안직원 </option>
			<option value="경리"> 경리 </option>
			<option value="설비과장"> 설비과장 </option>
			<option value="검침기사" selected> 검침기사</option>
			</select>
			<% } %>
		</td>
	</tr>
	
	<tr>
		<th style="text-align:center;" id="empMain">주민등록번호*</th>
		<td id="empData"><input type="text" name="empssn" id="ssn" style="border:none;" value="<%= employee.getEmpSSN() %>" size="30"></td>
		<th style="text-align:center;" id="empMain">성별</th>
		<td id="empData">
			<% if(employee.getEmpGender().equals("M") == true){ %>
			<input type="radio" name="gender" value="M" checked> 남자 &nbsp;
			<input type="radio" name="gender" value="F" > 여자
			<% }else{ %>
			<input type="radio" name="gender" value="M" > 남자 &nbsp;
			<input type="radio" name="gender" value="F" checked> 여자
			<% } %>
			</td>
	</tr>

	<tr>
		<th style="text-align:center;" id="empMain">휴대전화*</th>
		<td id="empData"><input type="tel" name="empphone" id="phone" style="border:none;"value="<%= employee.getEmpPhone() %>" size="30"></td>
		<th style="text-align:center;" id="empMain">이메일</th>
		<td id="empData"><input type="email" name="empemail" value="<%= employee.getEmpEmail() %>" style="border:none;" size="30"></td>
	</tr>

	<tr>
		<th style="text-align:center;" id="empMain">주소</th>
		<td id="empData" colspan="3">
			<input type="text" id="sample6_postcode" placeholder="우편번호" name="zipcode" value="<%= employee.getEmpZipcode() %>">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample6_address" placeholder="주소" name="empaddress" size="43" value="<%= addressAll[0] %>"><br>
			<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="empaddress" value="<%= addressAll[1] %>">
			<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="empaddress" value="<%= addressAll[2] %>">
		</td>
	</tr>

	<tr>
		<th style="text-align:center;" id="empMain">기타정보</th>
		<td id="empData" colspan="3"><textarea name="empetc" rows="3" cols="100"><%= employee.getEmpEtc() %></textarea></td>
	</tr>
</tbody>
</table>
</td>
</tr>
		
	<tr></tr>	 

<tr>
	<th id="button" colspan="2" style="text-align:center;">
		<input type="button" value="취소"  class="btn btn-primary btn-icon-split" style=" width:50px; height:30px; text-align:center;"
		onclick="location.href='/hiapt/emplist'">  &nbsp;
		<input type="submit" value="등록 " class="btn btn-primary btn-icon-split" id="button" style=" width:50px; height:30px; text-align:center;">
		</th>
	</tr>
			
</tbody>
</table>
</form>
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
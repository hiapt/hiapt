<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "employee.model.vo.Employee, java.util.ArrayList" %>
<% 
	Employee employee = (Employee)request.getAttribute("emp"); 
/* ArrayList<Employee> family = (Employee)request.getAttribute("fam");
 */
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


<script src="/hiapt/resources/js/jquery.number.min.js"></script>
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
	
$(document).ready(function(){
		$(".comma").number(true);
		$(".floatnum").number(true,2);
	});


$(function(){
	$("#cal").click(function(){
		var salary = $("#salary").val().replace(/[^\d]+/g,'');
		var family = $("#family").val();		
		
		$("#pension").val(Math.round(Number(salary) * 0.045 / 10) * 10);
		$("#insurance").val(Math.round(Number(salary) * 0.0323/10) * 10);
		$("#longins").val(Math.round(Number(salary) * 0.0851/10) * 10);
		$("#hireins").val(Math.round(Number(salary) * 0.008/10) * 10);
		$("#incometax").val(Math.round(Number(salary) * Number(family) * 1/10) * 10);
		$("#localtax").val(Math.round(Number(salary) * Number(family) * 1/10) * 10);
		
				
		var pnum = $("#pension").val(Math.round(Number(salary) * 0.045/10) * 10).val();
		var insnum = $("#insurance").val(Math.round(Number(salary) * 0.0323/10) * 10).val();
		var longnum = $("#longins").val(Math.round(Number(salary) * 0.0851/10) * 10).val();
		var hirenum = $("#hireins").val(Math.round(Number(salary) * 0.008/10) * 10).val();
		
		
		$("#minustot").val(Number(pnum) + Number(insnum) + Number(longnum) + Number(hirenum));
		$("#salarytot").val(Number(salary));
		
		
		var mtot = $("#minustot").val(Number(pnum) + Number(insnum) + Number(longnum) + Number(hirenum)).val();
		var stot = $("#salarytot").val(Number(salary)).val();
		
		$("#realsalary").val(Number(stot) - Number(mtot));
		
	});
});



$(function(){
	$('#enroll').on('submit', function(event){
	var empname = $('input[name=empname]');
	var empid = $('select[name=empid] option:selected');
	var empphone = $('input[name=empphone]');
	var empssn = $('input[name=empssn]');
	var salary = $('input[name=salary]');
	
	

	var empnameVal = $('input[name=empname]').val();
	var empidVal = $('select[name=empid] option:selected').val();
	var empphoneVal = $('input[name=empphone]').val();
	var empssnVal = $('input[name=empssn]').val();
	var salaryVal = $('input[name=salary]').val();
	var pensionVal = $('input[name=pension]').val();
	var insuranceVal = $('input[name=insurance]').val();
	var longinsVal = $('input[name=longins]').val();
	var hireinsVal = $('input[name=hireins]').val();
	var incometaxVal = $('input[name=incometax]').val();
	var localtaxVal = $('input[name=localtax]').val();
	var salarytotVal = $('input[name=salarytotVal]').val();
	var minustotVal = $('input[name=minustotVal]').val();
	var realsalaryVal = $('input[name=realsalaryVal]').val();
	
	
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
	
	if(salaryVal == ""){
		alert('급여를 입력하세요');
		salary.focus();
		return false;
	}
	
	if(pensionVal == 0 || insuranceVal == 0 ||longinsVal == 0 || hireinsVal == 0 || 
			incometaxVal == 0 || localtaxVal == 0 || salarytotVal == 0 || minustotVal == 0 || realsalaryVal == 0){
		alert('계산하기 버튼을 클릭하세요');
		salary.focus();
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
<h1 class="btn btn-primary btn-icon-split" style=" width:100px; height:30px; text-align:center;"><%= employee.getEmpName() %> 수정</h1>

<div class="card shadow mb-4">
<div class="card-body">

<form action="/hiapt/updsend" method="post" onsubmit="return validation();" id="enroll">
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
			<input type="text" id="sample6_address" placeholder="주소" name="empaddress" size="43" value="<%= addressAll[0] %>">
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
	<td>
		<table style="width:100%; border-collapse: collapse; margin-bottom:10px; 
		border: 2px solid #4e73df; border-radius: 9px;" cellpadding="0" cellspacing="1" >
		<tbody id="my-tbody">	
		<tr>
			<th id="empMain" colspan="9">부양가족 정보</th>
		</tr>
			
		<tr>
			<td id="empHeader" width="30px;"><input type="button" id="addFamily" name="addFamily" value="추가" onclick="add_row()" style=" width:50px; height:30px; text-align:center;"></td>
			<td id="empHeader">관계</td>
			<td id="empHeader">이름</td>
			<td id="empHeader">주민등록번호</td>
			<td id="empHeader">장애여부</td>					
			<td id="empHeader">인적공제</td>
			<td id="empHeader">동거여부</td>
			<td id="empHeader">갑근세</td>
			<td id="empHeader">다자녀</td>				
		</tr>	
				
		<%
			String ffre = "";
			String ffdis = "";
			String ffded = "";
			String ffto = "";
			String fftax = "";
			String ffch = "";
			for(int i = 0; i < list.size(); i++) { 
				Family fe = list.get(i);
				
				allffre += ffre[0]+",";
				allffdis += ffdis[0]+",";
				allffded += ffded[0]+",";
				allffto += ffto[0]+",";
				allfftax += fftax[0]+",";
				allffch += ffch[0]+",";
				
				
				
				String[] ffre = allffre.split(",");
				String[] ffdis = allffdis.split(",");
				String[] ffded = allffded.split(",");
				String[] ffto = allffto.split(",");
				String[] fftax = allfftax.split(",");
				String[] ffch = allffch.split(",");
				//String[] array = new String[3];
			%>		
				
				
				
		<tr name="trFamily">
			<td id="empHeader"></td>
			<td id="empHeader">
			<% 
			if(ffre[i].equals("") == true){ %>
			<select name="frelation" id="frelation">
				<option value=""selected>선택안함</option>
				<option value="배우자">배우자</option>
				<option value="소득자직계존속">소득자 직계존속</option>
				<option value="직계비속(자녀/입양자)">직계비속(자녀/입양자)</option>
				</select>
			<% }else if(ffre[i].equals("배우자") == true){ %>
			<select name="frelation" id="frelation">
				<option value="">선택안함</option>
				<option value="배우자"selected>배우자</option>
				<option value="소득자직계존속">소득자 직계존속</option>
				<option value="직계비속(자녀/입양자)">직계비속(자녀/입양자)</option>
				</select>
			<% }else if(ffre[i].equals("소득자직계존속") == true){ %>
			<select name="frelation" id="frelation">
				<option value="">선택안함</option>
				<option value="배우자">배우자</option>
				<option value="소득자직계존속" selected>소득자 직계존속</option>
				<option value="직계비속(자녀/입양자)">직계비속(자녀/입양자)</option>
				</select>
			<% }else if(ffre[i].equals("직계비속(자녀/입양자)") == true){ %>
			<select name="frelation" id="frelation">
				<option value="">선택안함</option>
				<option value="배우자">배우자</option>
				<option value="소득자직계존속">소득자 직계존속</option>
				<option value="직계비속(자녀/입양자)"selected>직계비속(자녀/입양자)</option>
				</select>
			<% } %>	
			</td>
			
			<td id="empHeader"><input type="text" size="7" name="fname" id="fname" value="<%= employee.getfName()%>"></td>					<td id="empHeader"><input type="text" size="20" name="fssn" id="fssn" value="<%= employee.getfSSN()%>"></td>
			<td id="empHeader">
			<% 
			if(ffdis[i].equals("N") == true){ %>
				<select name="fdisability" id="fdisability">
				<option value="N"selected>N</option>
				<option value="Y">Y</option>
				</select>
			<% }else if(ffdis[i].equals("Y") == true){ %>
				<select name="fdisability" id="fdisability">
				<option value="N">N</option>
				<option value="Y"selected>Y</option>
				</select>
			<% } %>	
			</td>
			
			<td id="empHeader">
			<% 
			if(ffded[i].equals("N") == true){ %>
				<select name="fdeduction" id="fdeduction">
				<option value="N"selected>N</option>
				<option value="Y">Y</option>
				</select>
			<% }else if(ffede[i].equals("Y") == true){ %>
				<select name="fdeduction" id="fdeduction">
				<option value="N">N</option>
				<option value="Y"selected>Y</option>
				</select>
			<% } %>	
			</td>
			<td id="empHeader">
			<% 
			if(ffto[i].equals("N") == true){ %>
				<select name="ftogether" id="ftogether">
				<option value="N"selected>N</option>
				<option value="Y">Y</option>
				</select>
			<% }else if(ffto[i].equals("Y") == true){ %>
				<select name="ftogether" id="ftogether">
				<option value="N">N</option>
				<option value="Y"selected>Y</option>
				</select>
			<% } %>	
			</td>
			<td id="empHeader">
			<% 
			if(fftax[i].equals("N") == true){ %>
				<select name="ftax" id="ftax">
				<option value="N"selected>N</option>
				<option value="Y">Y</option>
				</select>
			<% }else if(fftax[i].equals("Y") == true){ %>
				<select name="ftax" id="ftax">
				<option value="N">N</option>
				<option value="Y"selected>Y</option>
				</select>
			<% } %>	
			</td>
			<td id="empHeader">
			<% 
			if(ffch[i].equals("N") == true){ %>
				<select name="fchild" id="fchild">
				<option value="N"selected>N</option>
				<option value="Y">Y</option>
				</select>
			<% }else if(ffch[].equals("Y") == true){ %>
				<select name="fchild" id="fchild">
				<option value="N">N</option>
				<option value="Y"selected>Y</option>
				</select>
			<% } %>	
			</td>
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
  		<th style="text-align:center;" rowspan="9" id="empMain">급여* <br>
		<input type="button" id="cal" value="계산하기">
  	</th>
  	
  		<th id="salarytitle1">지급항목</th>
		<th id="salarytitle2">공제항목</th>
 	 </tr>
 	 
  	<tr>
		<td id="SalaryItemData">기본급 : <input type="text" name="salary" id="salary" class="type1 comma" style="border:none;" value="<%= employee.getSalary() %>"></td>
		<td id="SalaryItemData">국민연금 : <input type="text" name="pension" id="pension" class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getPension() %>"></td>
 	 </tr>
 	 
 	 <tr>
		<td></td>
		<td id="SalaryItemData">건강보험 : <input type="text" name="insurance" id="insurance" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getInsurance() %>"></td>
  	</tr>
  	
  	<tr>
		<td></td>
		<td id="SalaryItemData">장기요양보험 : <input type="text" name="longins" id="longins" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getLongIns() %>"></td>
  	</tr>
  	
  	<tr>
		<td></td>
		<td id="SalaryItemData">고용보험 : <input type="text" name="hireins" id="hireins" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getHireIns() %>"></td>
  	</tr>
  	
  	<tr>
		<td></td>
		<td id="SalaryItemData">소득세 : <input type="text" name="incometax" id="incometax" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getIncomeTax() %>"></td>
 	 </tr>
 	 
  	<tr>
		<td></td>
		<td id="SalaryItemData">지방소득세 : <input type="text" name="localtax" id="localtax" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getLocalTax() %>"></td>
  	</tr>
  	
 	 <tr>
		<td id="SalaryItemData">지급총액 : <input type="text" name="salarytot" id="salarytot" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getSalaryTot() %>">
		<td id="SalaryItemData">공제총액 : <input type="text" name="minustot" id="minustot" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getMinusTot() %>">
  	</tr>
  	
  	<tr>
		<td colspan="2"  id="SalaryItemData2" style="align:center;">실지급액 : <input type="text" name="realsalary" id="realsalary" readonly class="type1 comma" value="0" 
										style="border:none; background-color: #e2e2e2;" value="<%= employee.getRealSalary() %>"></td>
  	</tr>
  </tbody>
 	</table>
</td>
</tr>

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
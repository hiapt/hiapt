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
		
		$("#pension").val(Math.round(Number(salary) * 0.045 / 10) * 10);
		$("#insurance").val(Math.round(Number(salary) * 0.0323/10) * 10);
		$("#longins").val(Math.round(Number(salary) * 0.0851 * 0.5 / 10) * 10);
		$("#hireins").val(Math.round(Number(salary) * 0.008/10) * 10);
		
		if($("#ftax").is(":checked")){
			$("#incometax").val(Math.round(Number(salary) * 10/10) * 10);
		}else {
			$("#incometax").val(Math.round(Number(salary) /10) * 10);
		}
		
		var incometax = $("#incometax").val();
		
		$("#localtax").val(Math.round(Number(incometax) * 0.1 / 10) * 10);
		
				
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
<h1 class="btn btn-primary btn-icon-split" style=" width:100px; height:30px; text-align:center;">직원 등록</h1>

<div class="card shadow mb-4">
<div class="card-body">


<form action="/hiapt/empenroll" method="post" onsubmit="return validation();" id="enroll">
<!-- <table class="table table-bordered dataTable"> -->
<table style=" width:1000px; border:0px; padding:20px; margin:auto;" cellpadding="0" cellspacing="1" >
<tbody>

	<tr>
		<td>
			<table style="width:100%; border-collapse: collapse; margin-bottom:10px; 
			border: 2px solid #4e73df; border-radius: 9px;"cellpadding="0" cellspacing="1">
			<tbody>

<tr>
<th style="text-align:center;" id="empMain">사 번*</th>
<td id="empData" style="width:40%;"> (사번은 자동으로 입력됩니다.)</td>
<th style="text-align:center;" id="empMain">입사일*</th>
<td id="empData"><input type="date" name="emphiredate" id="date" value="<%= sysdate %>"></td>

</tr>


<tr>
<th style="text-align:center;" id="empMain">이 름*</th>
<td id="empData" style="width:40%;"><input type="text" name="empname" id="name" style="border:none;"></td>
<th style="text-align:center;" id="empMain">직 급*</th>
<td id="empData"><select name="empid" id="job"> <!-- select : drop down으로 목록선택창 뜸 -->
	<option value="">선택안함</option>
	<option value="관리자">관리자</option>
	<option value="보안직원">보안직원</option>
	<option value="경리">경리</option>
	<option value="설비과장">설비과장</option>
	<option value="검침기사">검침기사</option>
</select>
</td>

</tr>

<tr>
<th style="text-align:center;" id="empMain">주민등록번호*</th>
<td id="empData"><input type="text" name="empssn" id="ssn" style="border:none;" placeholder="('-'를 포함하여 입력하세요.)" size="30"></td>
<th style="text-align:center;" id="empMain">성별</th>
<td id="empData">
		<input type="radio" name="empgender" id="gender" value="M" required> 남자 &nbsp;
		<input type="radio" name="empgender" id="gender" value="F" required> 여자
</tr>


<tr>
	<th style="text-align:center;" id="empMain">휴대전화*</th>
	<td id="empData"><input type="tel" name="empphone" id="phone" style="border:none;" placeholder="('-'를 포함하여 입력하세요.)" size="30"></td>
	<th style="text-align:center;" id="empMain">이메일</th>
	<td id="empData"><input type="email" name="empemail" placeholder="(sample@naver.com)" style="border:none;" size="30"></td>
</tr>

<tr><th style="text-align:center;" id="empMain">주소</th>
<td id="empData" colspan="3">
<input type="text" id="sample6_postcode" placeholder="우편번호" name="empzipcode">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" placeholder="주소" name="empaddress" size="43">
<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="empaddress">
<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="empaddress">

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</td></tr>
<tr><th style="text-align:center;" id="empMain">기타정보</th>
<td id="empData" colspan="3"><textarea name="empetc" rows="3" cols="100"></textarea></td>
</tr>
</tbody>
			</table>
		</td>
	</tr>
		
	<tr>
		
	</tr>	
		
	<tr>
		<td>
		
			<table style="width:100%; border-collapse: collapse; margin-bottom:10px; 
			border: 2px solid #4e73df; border-radius: 9px;" cellpadding="0" cellspacing="1" >
			<tbody id="my-tbody">	
			<tr>
			<th id="empMain" colspan="9">부양가족 정보 등록</th>
		</tr>
			
				<tr>
					<td id="empHeader" width="30px;"><input type="button" id="addFamily" name="addFamily" 
					value="추가" onclick="add_row()" style=" width:50px; height:30px; text-align:center;"></td>
					<td id="empHeader">관계</td>
					<td id="empHeader">이름</td>
					<td id="empHeader">주민등록번호</td>
					<td id="empHeader">장애여부</td>
					<td id="empHeader">인적공제</td>
					<td id="empHeader">동거여부</td>
					<td id="empHeader">갑근세</td>
					<td id="empHeader">다자녀</td>
					
				</tr>	
				
				<tr name="trFamily">
				<td id="empHeader" >
				</td>
					<td id="empHeader">
						<select name="frelation" id="frelation">
						<option value="">선택안함</option>
						<option value="배우자">배우자</option>
						<option value="소득자직계존속">소득자 직계존속</option>
						<option value="직계비속(자녀/입양자)">직계비속(자녀/입양자)</option>
						</select></td>
					<td id="empHeader"><input type="text" size="7" name="fname" id="fname" ></td>
					<td id="empHeader"><input type="text" size="20" name="fssn" id="fssn" ></td>
					<td id="empHeader"><select name="fdisability" id="fdisability">
				  <option value="N">N</option>
				  <option value="Y">Y</option>	
				  </select></td>
				  <td id="empHeader"><select name="fdeduction" id="fdeduction">
				  <option value="N">N</option><option value="Y">Y</option>
				  </select></td>
				  <td id="empHeader"><select name="ftogether" id="ftogether">
				  <option value="N">N</option><option value="Y">Y</option>
				  </select></td>
				  <td id="empHeader"><select name="ftax" id="ftax">
				  <option value="N">N</option><option value="Y">Y</option>
				  </select></td>
				  <td id="empHeader"><select name="fchild" id="fchild">
				  <option value="N">N</option><option value="Y">Y</option>
				  </select></td>
				  
							
					
				</tr>
				</tbody>
								
			</table>
			
			<script>
				var addCount;
				  function add_row() {
					  addCount=1;
				  var addFamilyText =  '<tr name="trFamily"><td id="empHeader">' + 
				  '<button name="delFamily">삭제</button></td>'+ 
				  '<td id="empHeader"><select name="frelation"'+addCount+' id="frelation">' + 
				  '<option value="">선택안함</option>' +
				  '<option value="배우자">배우자</option>' + 
				  '<option value="소득자직계존속">소득자 직계존속</option>' +
				  '<option value="직계비속(자녀/입양자)">직계비속(자녀/입양자)</option>' + 
				  '</select></td>' +
				  '<td id="empHeader"><input type="text" size="7" name="fname"'+addCount+' id="fname"></td>' + 
				  '<td id="empHeader"><input type="text" size="20" name="fssn"'+addCount+' id="fssn"></td>' + 
				  '<td id="empHeader"><select name="fdisability"'+addCount+' id="fdisability">' + 
				  '<option value="N">N</option><option value="Y">Y</option>	' + 
				  '</select></td>' +
				  '<td id="empHeader"><select name="fdeduction"'+addCount+' id="fdeduction">' + 
				  '<option value="N">N</option><option value="Y">Y</option>	' + 
				  '</select></td>' +
				  '<td id="empHeader"><select name="ftogether"'+addCount+' id="ftogether">' + 
				  '<option value="N">N</option><option value="Y">Y</option>' + 
				  '</select></td>' +
				  '<td id="empHeader"><select name="ftax"'+addCount+' id="ftax">' + 
				  '<option value="N">N</option><option value="Y">Y</option>	' + 
				  '</select></td>' +
				  '<td id="empHeader"><select name="fchild"'+addCount+' id="fchild">' + 
				  '<option value="N">N</option><option value="Y">Y</option>	' + 
				  '</select></td>' +
				  '</tr>'
				  
				 var trHtml = $( "tr[name=trFamily]:last" );
				  trHtml.after(addFamilyText);
			         
				  addCount++;
				    }
				  
				  $(document).on("click","button[name=delFamily]",function(){
				         
				        var trHtml = $(this).parent().parent();
				         
				        trHtml.remove(); //tr 테그 삭제
				         addCount--;
				    });
			</script>
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
	<td id="SalaryItemData">기본급 : <input type="text" name="salary" id="salary" class="type1 comma" style="border:none;"></td>
	<td id="SalaryItemData">국민연금 : <input type="text" name="pension" id="pension" class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  <tr>
	<td></td>
	<td id="SalaryItemData">건강보험 : <input type="text" name="insurance" id="insurance" readonly class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  <tr>
	<td></td>
	<td id="SalaryItemData">장기요양보험 : <input type="text" name="longins" id="longins" readonly class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  <tr>
	<td></td>
	<td id="SalaryItemData">고용보험 : <input type="text" name="hireins" id="hireins" readonly class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  <tr>
	<td></td>
	<td id="SalaryItemData">소득세 : <input type="text" name="incometax" id="incometax" readonly class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  <tr>
	<td></td>
	<td id="SalaryItemData">지방소득세 : <input type="text" name="localtax" id="localtax" readonly class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  <tr>
	<td id="SalaryItemData">지급총액 : <input type="text" name="salarytot" id="salarytot" readonly class="type1 comma" value="0" style="border:none;"></td>
	<td id="SalaryItemData">공제총액 : <input type="text" name="minustot" id="minustot" readonly class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  <tr>
	<td colspan="2"  id="SalaryItemData2" style="align:center;">실지급액 : <input type="text" name="realsalary" id="realsalary" readonly class="type1 comma" value="0" style="border:none;"></td>
  </tr>
  </tbody>
			</table>
		</td>
	</tr>
	
	<tr>
		<th id="button" colspan="2" style="text-align:center;">
		<input type="button" value="취소"  class="btn btn-primary btn-icon-split" style=" width:50px; height:30px; text-align:center;"
onclick="location.href='/hiapt/emplist'">  &nbsp;
		<input type="submit" value="등록 " 
				class="btn btn-primary btn-icon-split" id="button2" style=" width:50px; height:30px; text-align:center;">
		</th>
	</tr>
			
</tbody>
</table>

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
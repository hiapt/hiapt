<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

#employee{
	padding-left: 10px;
}

#date, #job {
	height:25px;
}
</style>

</head>

<script type="text/javascript" src="/hiapt/resources/js/bootstrap.min.js"></script>
<script>
function validation(){
	return true; //전송함
}

$(function(){
	$("#cal").click(function(){
		var salary = $("#salary").val();
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
<h1 class="h3 mb-4 text-gray-800">직원 등록</h1>

<div class="card shadow mb-4">
<div class="card-body">
<form action="/hiapt/empenroll" method="post" onsubmit="return validation();">
<table class="table table-bordered dataTable">

<tr><th style="text-align:center; width:150px;">사 번*</th>
<td id="employee"> (사번은 자동으로 입력됩니다.)

<tr><th style="text-align:center;">이 름*</th>
<td id="employee"><input type="text" name="empname"></td></tr>

<tr><th style="text-align:center;">직 급*</th>
<td id="employee"><select name="empid" id="job"> <!-- select : drop down으로 목록선택창 뜸 -->
	<option value="관리자">관리자</option>
	<option value="보안직원">보안직원</option>
	<option value="경리">경리</option>
	<option value="설비과장">설비과장</option>
	<option value="검침기사">검침기사</option>
</select>
</td></tr>

<tr><th style="text-align:center;">입사일</th>
<td id="employee"><input type="date" name="emphiredate" id="date"></td></tr>

<tr><th style="text-align:center;">휴대전화*</th>
<td id="employee"><input type="tel" name="empphone"> ("-" 를 포함해서 입력해주세요.)</td></tr>



<tr><th style="text-align:center;">주민등록번호*</th>
<td id="employee"><input type="text" name="empssn"> ("-" 를 포함해서 입력해주세요.)</td></tr>

<tr><th style="text-align:center;">주소</th>
<td id="employee">
<input type="text" id="sample6_postcode" placeholder="우편번호" name="zipcode">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" placeholder="주소" name="empaddress" size="43"><br>
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

<tr><th style="text-align:center;">이메일</th>
<td id="employee"><input type="email" name="empemail" placeholder="sample@naver.com"></td></tr>
	 
<tr><th style="text-align:center;">부양가족수</th>
<td id="employee"><input type="number" id="family" name="empfamily" min="0"></td>
	 
<tr><th style="text-align:center;">급여* <br>
		<input type="button" id="cal" value="계산하기"><br>
	</th>
<td style="padding-left:10px;"><table  width="800" height=250" border="1" >
  <tr>
	<th style="background:skyblue; text-align:center;" width="225" >지급항목</th>
	<th style="background:pink; text-align:center;"  width="225">공제항목</th>
  </tr>
  <tr>
	<td id="employee">기본급 : <input type="text" name="salary" id="salary"></td>
	<td id="employee">국민연금 : <input type="text" name="pension" id="pension" ></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">건강보험 : <input type="text" name="insurance" id="insurance" ></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">장기요양보험 : <input type="text" name="longins" id="longins" ></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">고용보험 : <input type="text" name="hireins" id="hireins" ></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">소득세 : <input type="text" name="incometax" id="incometax" ></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">지방소득세 : <input type="text" name="localtax" id="localtax" ></td>
  </tr>
  <tr>
	<td id="employee">지급총액 : <input type="text" name="salarytot" id="salarytot"></td>
	<td id="employee">공제총액 : <input type="text" name="minustot" id="minustot"></td>
  </tr>
  <tr>
	<td colspan="2" align="center">실지급액 : <input type="text" name="realsalary" id="realsalary"></td>
	
  </tr>
  </table></td></tr>
  

<tr><th style="text-align:center;">기타정보</th>
<td id="employee"><textarea name="empetc" rows="7" cols="75"></textarea></td></tr>

<tr><th colspan="2">
<input type="reset" value="취소"> &nbsp;
<input type="submit" value="등록 ">
</th></tr>

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
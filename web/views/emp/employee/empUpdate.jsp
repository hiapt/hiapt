<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "employee.model.vo.Employee"%>
<% 
	Employee employee = (Employee)session.getAttribute("employee"); %>
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

/* #navi{
	height: 30px;
	/* width: 110px; */
	display: block;
	font-family:"굴림";
	font-weight:600;
	font-size:14px;
	padding: 5px 25px;
	margin : 5px 25px;
	color: white;
	background: #365873;
	text-decoration: none;
} */

#userid{
	background : lightgray;
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
		$("#pension").val(Number(salary) * 0.045);
		$("#insurance").val(Number(salary) * 0.323);
		$("#longins").val(Number(salary) * 0.04255);
		$("#hireins").val(Number(salary) * 0.065);
		$("#incometax").val(Number(salary) * Number(family) * 1);
		$("#localtax").val(Number(salary) * Number(family) * 1);
		
		var pnum = $("#pension").val(Number(salary) * 0.045).val();
		var insnum = $("#insurance").val(Number(salary) * 0.323).val();
		var longnum = $("#longins").val(Number(salary) * 0.04255).val();
		var hirenum = $("#hireins").val(Number(salary) * 0.065).val();
		
		
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
<h1 class="h3 mb-4 text-gray-800"><%= employee.getEmpName() %> 수정</h1>

<div class="card shadow mb-4">
<form action="/hiapt/empupdate" method="post">
<table class="table table-bordered dataTable">

<tr><th style="text-align:center; width:150px;">사 번*</th>
<td id="employee"> <input type="text" name="empno" id="empno" readonly value="<%= employee.getEmpNo() %>"></td></tr>

<tr><th style="text-align:center;">이 름*</th>
<td id="employee"><input type="text" name="empname" value="<%= employee.getEmpName() %>"></td></tr>

<tr><th style="text-align:center;">직 급*</th>
<!-- <td id="employee"><select name="empid" id="job"> select : drop down으로 목록선택창 뜸
	<option value="보안직원"> 보안직원</option>
	<option value="경리"> 경리</option>
	<option value="설비과장"> 설비과장</option>
	<option value="검침기사"> 검침기사</option>
</select> -->
	<td>
	<% if(employee.getEmpId().equals("보안직원") == true){ %>
		<select>
		<option value="보안직원" selected> 보안직원 </option>
		<option value="경리" > 경리 </option>
		<option value="설비과장" > 설비과장 </option>
		<option value="검침기사" > 검침기사</option>
		</select>
	<% }else if(employee.getEmpId().equals("경리") == true){ %>
		<select>
		<option value="보안직원" > 보안직원 </option>
		<option value="경리" selected> 경리 </option>
		<option value="설비과장" > 설비과장 </option>
		<option value="검침기사" > 검침기사</option>
		</select>
	<% }else if(employee.getEmpId().equals("설비과장") == true){ %>
		<select>
		<option value="보안직원" > 보안직원 </option>
		<option value="경리" > 경리 </option>
		<option value="설비과장" selected> 설비과장 </option>
		<option value="검침기사" > 검침기사</option>
		</select>
	<% }else { %>
		<select>
		<option value="보안직원" > 보안직원 </option>
		<option value="경리" > 경리 </option>
		<option value="설비과장" > 설비과장 </option>
		<option value="검침기사" selected> 검침기사</option>
		</select>
	<% } %>

</td></tr>

<tr><th style="text-align:center;">입사일</th>
<td id="employee"><input type="date" name="emphiredate" id="date" value="<%= employee.getEmpHireDate() %>" readonly></td></tr>

<tr><th style="text-align:center;">휴대전화</th>
<td id="employee"><input type="tel" name="empphone" value="<%= employee.getEmpPhone() %>"></td></tr>



<tr><th style="text-align:center;">주민등록번호</th>
<td id="employee"><input type="text" name="empssn" value="<%= employee.getEmpSSN() %>"></td></tr>

<tr><th style="text-align:center;">주소</th>
<td id="employee">
<input type="text" id="sample6_postcode" placeholder="우편번호">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" placeholder="주소" name="empaddress1" width="200px" value="<%= employee.getEmpAddress() %>"><br>
<input type="text" id="sample6_detailAddress" placeholder="상세주소">
<input type="text" id="sample6_extraAddress" placeholder="참고항목">

</td></tr>

<tr><th style="text-align:center;">이메일</th>
<td id="employee"><input type="email" name="empemail" value="<%= employee.getEmpEmail() %>"></td></tr>
	 
<tr><th style="text-align:center;">부양가족수</th>
<td id="employee"><input type="number" id="family" name="empfamily" min="0" value="<%= employee.getEmpFamily() %>"></td>
	 
<tr><th style="text-align:center;">급여* <br>
		<input type="button" id="cal" value="계산하기"><br>
	</th>
<td style="padding-left:10px;"><table  width="800" height=250" border="1" >
  <tr>
	<th style="background:skyblue; text-align:center;" width="225" >지급항목</th>
	<th style="background:pink; text-align:center;"  width="225">공제항목</th>
  </tr>
  <tr>
	<td id="employee">기본급 : <input type="text" name="salary" id="salary" readonly value="<%= employee.getSalary() %>"></td>
	<td id="employee">국민연금 : <input type="text" name="pension" id="pension" readonly value="<%= employee.getPension() %>"></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">건강보험 : <input type="text" name="insurance" id="insurance" readonly value="<%= employee.getInsurance() %>"></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">장기요양보험 : <input type="text" name="longins" id="longins" readonly value="<%= employee.getLongIns() %>"></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">고용보험 : <input type="text" name="hireins" id="hireins" readonly value="<%= employee.getHireIns() %>"></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">소득세 : <input type="text" name="incometax" id="incometax" readonly value="<%= employee.getIncomeTax() %>"></td>
  </tr>
  <tr>
	<td></td>
	<td id="employee">지방소득세 : <input type="text" name="localtax" id="localtax" readonly value="<%= employee.getLocalTax() %>"></td>
  </tr>
  <tr>
	<td id="employee">지급총액 : <input type="text" id="salarytot" readonly></td>
	<td id="employee">공제총액 : <input type="text" id="minustot" readonly></td>
  </tr>
  <tr>
	<td colspan="2" align="center">실지급액 : <input type="text" id="realsalary" readonly></td>
	
  </tr>
  </table></td></tr>
  

<tr><th style="text-align:center;">기타정보</th>
<td id="employee"><textarea name="empetc" rows="7" cols="75" value="<%= employee.getEmpEtc() %>"></textarea></td></tr>


<tr><th colspan="2">
<input type="reset" value="취소"> &nbsp;
<input type="submit" value="수정">
</th></tr>

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
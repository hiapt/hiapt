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
var ss = '<%= employee.getEmpId()%>';
console.log(ss);
</script>


<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 

<!-- 왼쪽 메인 메뉴바 시작  --> 
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

<!-- 스마일 로고 -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/hiapt/login.jsp">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					HIAPT <sup>2</sup>
				</div>
			</a>

<!-- 왼쪽 메뉴바 시작 -->
<!-- ============================================================= -->		
		<hr class="sidebar-divider">
		<!-- Heading 나중에 삭제부분-->
      	<div class="sidebar-heading">직원</div>
<!-- ============================================================= -->
<!-- 메일 시작 -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#mail"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-envelope-open"></i> <span>메일(직원)</span>
			</a>
				<div id="mail" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/views/emp/mail/allmail.jsp">전체메일함</a>
						<a class="collapse-item" href="cards.html">메일2</a>
					</div>
				</div>
			</li>
<!-- 메일 끝 -->
<!-- ====================================================================================== -->
<!-- ====================================================================================== -->			
<!--인사정보 시작 -->
		<hr class="sidebar-divider">
		<!-- Heading 나중에 삭제부분-->
      	<div class="sidebar-heading">직원</div>
<!-- ====================================================================================== -->	      	
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#employee" aria-expanded="true"
				aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-address-card"></i> <span>인사</span>
			</a>
				<div id="employee" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/emplist">직원조회</a> <a
							class="collapse-item"
							href="/hiapt/views/emp/employee/empEnroll.jsp">직원등록</a> <a
							class="collapse-item" href="utilities-animation.html">Animations</a>
						<a class="collapse-item" href="utilities-other.html">Other</a>
					</div>
				</div>
			</li>

<!-- 인사정보 끝 -->
<!-- ================================================================================= -->

<!-- ================================================================================= -->
<!--전자결재 시작 -->
		<hr class="sidebar-divider">
		<!-- Heading 나중에 삭제부분-->
      	<div class="sidebar-heading">직원</div>
<!-- ====================================================================================== -->	
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#draft" aria-expanded="true"
				aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-folder"></i> <span>전자결재</span>
			</a>
				<div id="draft" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item"
							href="/hiapt/views/emp/approval/draftWrite.jsp">기안작성테스트</a> 
							<a class="collapse-item" href="/hiapt/dtemp">임시보관함</a> 
							<a class="collapse-item" href="/hiapt/dlist?empno=<%= employee.getEmpNo() %>">전자결재 전체목록</a>
							<a class="collapse-item" href="/hiapt/dstandby">전자결재 대기목록</a> <a
							class="collapse-item" href="/hiapt/dapproved">전자결재 승인목록</a> <a
							class="collapse-item" href="/hiapt/dreturn">전자결재 반려목록</a> <a
							class="collapse-item" href="/hiapt/ddefer">전자결재 보류목록</a>
					</div>
				</div>
			</li>
<!-- 전자결재 끝 -->
<!-- ================================================================================= -->
<!-- ================================================================================= -->
<!--관리비 시작 -->
		<hr class="sidebar-divider">
		<!-- Heading 나중에 삭제부분-->
      	<div class="sidebar-heading">직원</div>
<!-- ====================================================================================== -->	
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#maintenance"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-calculator"></i> <span>관리비관리</span>
			</a>
				<div id="maintenance" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/bwlist">일반관리비 목록 </a> <a
							class="collapse-item" href="/hiapt/bilist">고지서 목록 </a> <a
							class="collapse-item"
							href="/hiapt/views/emp/maintenance/BillList.jsp">고지서 상세 목록 조회</a>
						<a class="collapse-item"
							href="/hiapt/views/emp/maintenance/BillListDetailView.jsp">상세보기</a>
						<a class="collapse-item" href="/hiapt/bvilis">부과기초작업</a> <a
							class="collapse-item" href="*">4</a>
					</div>
				</div>
			</li>
<!-- 관리비 끝 -->
<!-- ================================================================================= -->
<!-- ================================================================================= -->
<!--공지사항 시작 -->
		<hr class="sidebar-divider">
	  	<!-- Heading 나중에 삭제부분-->
      	<div class="sidebar-heading">관리자</div>
<!-- ================================================================================= -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#notice"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-bullhorn"></i> <span>행정관리</span>
			</a>
				<div id="notice" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/views/master/notice/noticeAdminListView.jsp">공지사항 관리</a> 
						<a class="collapse-item" href="*">민원 관리 </a> 
						<a class="collapse-item" href="/hiapt/vo.list">주민투표 관리</a>
						<a class="collapse-item" href="*">자유게시판 관리</a>
					</div>
				</div>
			</li>
<!--공지사항 끝 -->
<!-- ================================================================================= -->
<!-- ================================================================================= -->
<!--캘린더 시작 -->
      <hr class="sidebar-divider">
        <!-- Heading 나중에 삭제부분-->
         <div class="sidebar-heading">emp</div>
<!-- ================================================================================= -->
         <li class="nav-item"><a class="nav-link"
            href="/hiapt/views/common/schedule/schedulemain.jsp"> <i
               class="fas fa-fw fa-calendar-alt"></i> <span>Calendar</span></a>
         </li>
<!--캘린더 끝 -->
<!-- ================================================================================= -->
<!-- ================================================================================= -->
<!-- Nav Item - Pages Collapse Menu 삭제용 -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Components</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Components:</h6>
            <a class="collapse-item" href="/hiapt/views/ex/buttons.html">Buttons</a>
            <a class="collapse-item" href="/hiapt/views/ex/cards.html">Cards</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Utilities:</h6>
            <a class="collapse-item" href="/hiapt/views/ex/utilities-color.html">Colors</a>
            <a class="collapse-item" href="/hiapt/views/ex/utilities-border.html">Borders</a>
            <a class="collapse-item" href="/hiapt/views/ex/utilities-animation.html">Animations</a>
            <a class="collapse-item" href="/hiapt/views/ex/utilities-other.html">Other</a>
          </div>
        </div>
      </li>
<!--page 시작(삭제용) -->
<hr class="sidebar-divider">
			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#page"
				aria-expanded="true" aria-controls="collapsePages"> <i
					class="fas fa-fw fa-folder"></i> <span>Pages</span>
			</a>
				<div id="page" class="collapse"
					aria-labelledby="headingPages" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Login Screens:</h6>
						<a class="collapse-item" href="/hiapt/views/ex/login.html">Login</a>
						<a class="collapse-item" href="/hiapt/views/ex/register.html">Register</a>
						<a class="collapse-item"
							href="/hiapt/views/ex/forgot-password.html">Forgot Password</a>
						<div class="collapse-divider"></div>
						<h6 class="collapse-header">Other Pages:</h6>
						<a class="collapse-item" href="/hiapt/views/ex/404.html">404
							Page</a> <a class="collapse-item" href="/hiapt/views/ex/blank.html">Blank
							Page</a>
					</div>
				</div>
			</li>
<!--page 끝 -->
<!-- ================================================================================= -->
<!-- ================================================================================= -->
<!-- charts 시작(삭제용) -->		
			<li class="nav-item"><a class="nav-link"
				href="/hiapt/views/ex/charts.html"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Charts</span></a>
			</li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link"
				href="/hiapt/views/ex/tables.html"> <i
					class="fas fa-fw fa-table"></i> <span>Tables</span></a>
			</li>
<!-- charts 끝 -->
<!-- ================================================================================= -->

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
<!-- 왼쪽 메인 메뉴 끝 -->
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
<form action="/hiapt/updsend" method="post">
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

</td></tr>

<tr><th style="text-align:center;">입사일</th>
<td id="employee"><input type="date" name="emphiredate" id="date" value="<%= employee.getEmpHireDate() %>" readonly></td></tr>

<tr><th style="text-align:center;">휴대전화</th>
<td id="employee"><input type="tel" name="empphone" value="<%= employee.getEmpPhone() %>"></td></tr>



<tr><th style="text-align:center;">주민등록번호</th>
<td id="employee"><input type="text" name="empssn" value="<%= employee.getEmpSSN() %>"></td></tr>

<tr><th style="text-align:center;">주소</th>
<td id="employee">
<input type="text" id="sample6_postcode" placeholder="우편번호" name="zipcode" value="<%= employee.getEmpZipcode() %>">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample6_address" placeholder="주소" name="empaddress" size="43" value="<%= addressAll[0] %>"><br>
<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="empaddress" value="<%= addressAll[1] %>">
<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="empaddress" value="<%= addressAll[2] %>">

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
	<td id="employee">기본급 : <input type="text" name="salary" id="salary" value="<%= employee.getSalary() %>"></td>
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
	<td id="employee">지급총액 : <input type="text" name="salarytot" id="salarytot" readonly value="<%= employee.getSalaryTot() %>"></td>
	<td id="employee">공제총액 : <input type="text" name="minustot" id="minustot" readonly value="<%= employee.getMinusTot() %>"></td>
  </tr>
  <tr>
	<td colspan="2" align="center">실지급액 : <input type="text" name="realsalary" id="realsalary" readonly value="<%= employee.getRealSalary() %>"></td>
	
  </tr>
  </table></td></tr>
  

<tr><th style="text-align:center;">기타정보</th>
<td id="employee"><textarea name="empetc" rows="7" cols="75"><%= employee.getEmpEtc() %></textarea></td></tr>

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
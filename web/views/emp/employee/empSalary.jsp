<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "employee.model.vo.Employee"%>
<% 
	Employee employee = (Employee)request.getAttribute("empsalary");
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

#SalaryTitle {
    height: 30px;
    line-height: 30px;
    background-color: #e9edf5;
    border-color: #c4cfda;
    border-left: 0.08em solid #c4cfda;
    border-top: 0.08em solid #c4cfda;
    border-right: 0.08em solid #c4cfda;
    border-bottom: 0.08em solid #c4cfda;
    text-align: center;
    font-size: 10pt;
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

#SalaryAmtData {
    height: 30px;
    border-color: #c4cfda;
    border-left: 0.08em solid #c4cfda;
    border-top: 0.08em solid #c4cfda;
    border-right: 0.08em solid #c4cfda;
    border-bottom: 0.08em solid #c4cfda;
    padding-right: 5px;
    text-align: right;
    font-size: 10pt;
}

#SalarySummaryTitle {
    height: 30px;
    line-height: 30px;
    background-color: #e9edf5;
    border-color: #c4cfda;
    border-left: 0.08em solid #c4cfda;
    border-top: 0.08em solid #c4cfda;
    border-right: 0.08em solid #c4cfda;
    border-bottom: 0.08em solid #c4cfda;
    text-align: center;
    font-size: 10pt;
}

#SalarySummaryAmtData {
    height: 30px;
    border-color: #c4cfda;
    border-left: 0.08em solid #c4cfda;
    border-top: 0.08em solid #c4cfda;
    border-right: 0.08em solid #c4cfda;
    border-bottom: 0.08em solid #c4cfda;
    padding-right: 5px;
    text-align: right;
    font-weight: 500;
    font-size: 10pt;
}

#SalaryItemHeaderData {
    height: 30px;
    border-color: #c4cfda;
    border-left: 0.08em solid #c4cfda;
    border-top: 0.08em solid #c4cfda;
    border-right: 0.08em solid #c4cfda;
    border-bottom: 0.08em solid #c4cfda;
    text-align: center;
    font-size: 10pt;
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

function info_print() {
    // 안보이게 할 영역 숨기기
    
    //인쇄
    var initBody = document.body.innerHTML;
    window.onbeforeprint = function () {
       document.body.innerHTML = document.getElementById("#print").innerHTML;
    }
    window.onafterprint = function () {

       document.body.innerHTML = initBody;
    }
    window.print();
    
    // 인쇄창 끄면 다시 보이게
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
<div class="card shadow mb-4" id="print">
<form action="/hiapt/salary" method="post">
<table style=" width:650px; border:0px; padding:20px; margin:auto;" cellpadding="0" cellspacing="1">
		<tbody>
		<tr>
			<td align="center"><h3>급여명세서</h3></td><br>
		</tr>
		<tr>
			<td><br>
				<table style="width:100%; border-collapse: collapse; margin-bottom:10px;" border="1" cellpadding="0" cellspacing="1">
					<tbody><tr style="border-top: 2px solid #000000;">
						<td id="SalaryTitle" style="width: 50px;">사번</td>
						<td id="SalaryItemHeaderData" style="width: 80px;"><%= employee.getEmpNo() %></td>
						<td id="SalaryTitle" style="width: 50px;">성명</td>
						<td id="SalaryItemHeaderData" style="width: 80px;"><%= employee.getEmpName() %></td>
						<td id="SalaryTitle" style="width: 50px;">직급</td>
						<td id="SalaryItemHeaderData" style="width: 80px;"><%= employee.getEmpId() %></td>
					</tr>
				</tbody></table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" style="border-collapse:collapse;" border="1" cellpadding="0" cellspacing="1">
					<tbody><tr style="border-top: 2px solid #000000;">
						<td id="SalaryTitle" style="width: 80px;" rowspan="5">지급사항</td>
						<td id="SalaryTitle">항목</td>
						<td id="SalaryTitle">금액</td>
						<td id="SalaryTitle">항목</td>
						<td id="SalaryTitle">금액</td>
					</tr>				
					<tr>
				<td id="SalaryItemData">기본급</td>
				<td id="SalaryAmtData"><%= employee.getSalary() %></td>
				<td id="SalaryItemData">6세미만보육수당</td>
				<td id="SalaryAmtData"></td>
			</tr>			<tr>
				<td id="SalaryItemData">연장근무수당</td>
				<td id="SalaryAmtData">17,483</td>
				<td id="SalaryItemData">연구개발수당</td>
				<td id="SalaryAmtData"></td>
			</tr>			<tr>
				<td id="SalaryItemData">휴일근무수당</td>
				<td id="SalaryAmtData">17,483</td>
				<td id="SalaryItemData">식대</td>
				<td id="SalaryAmtData"></td>
			</tr>			<tr>
				<td id="SalarySummaryTitle" colspan="2">지급총액</td>
				<td id="SalarySummaryAmtData" colspan="2"><%= employee.getSalaryTot() %></td>
			</tr>
			<tr style="border-top: 2px solid #000000;">
				<td id="SalaryTitle"style="width: 80px;"" rowspan="6">공제사항</td>
				<td id="SalaryTitle">항목</td>
				<td id="SalaryTitle">금액</td>
				<td id="SalaryTitle">항목</td>
				<td id="SalaryTitle">금액</td>
			</tr>			<tr>
				<td id="SalaryItemData">국민연금</td>
				<td id="SalaryAmtData"><%= employee.getPension() %></td>
				<td id="SalaryItemData">고용보험</td>
				<td id="SalaryAmtData"><%= employee.getInsurance() %></td>
			</tr>			<tr>
				<td id="SalaryItemData">건강보험</td>
				<td id="SalaryAmtData"><%= employee.getLongIns() %></td>
				<td id="SalaryItemData">소득세</td>
				<td id="SalaryAmtData"><%= employee.getIncomeTax() %></td>
			</tr>			<tr>
				<td id="SalaryItemData">장기요양</td>
				<td id="SalaryAmtData"><%= employee.getHireIns() %></td>
				<td id="SalaryItemData">지방소득세</td>
				<td id="SalaryAmtData"><%= employee.getLocalTax() %></td>
			</tr>						<tr>
							<td id="SalarySummaryTitle" colspan="2">공제총액</td>
							<td id="SalarySummaryAmtData" colspan="2"><%= employee.getMinusTot() %></td>
						</tr>
						<tr>
							<td id="SalarySummaryTitle" colspan="2">차감지급 금액</td>
							<td id="SalarySummaryAmtData" colspan="2"><%= employee.getRealSalary() %></td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			<tr>
				<td>
					<div style="height: 20px; text-align: right; margin-right: 50px; margin-bottom: 5px; margin-top: 5px; font-size: 10pt;">* 수고하셨습니다</div>
					<table width="100%" border="1" style="border-collapse: collapse;" cellpadding="0" cellspacing="1">
						<tbody><tr style="border-top: 2px solid #000000;">
							<td id="SalaryTitle" style="width: 55px; height:60px;">기타</td>
							<td id="SalaryItemData"><input type="text" style="height: 40px; width:580px;"></td>
						</tr>
					</tbody></table>
				</td>
			</tr>
			
			<tr>
			<td colspan="2">
<input type="reset" value="취소"> &nbsp;
<input type="submit" value="등록 ">
</th></tr>
			
		</tbody></table><br>
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
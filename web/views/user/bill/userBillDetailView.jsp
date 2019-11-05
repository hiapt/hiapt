<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="maintenance.model.vo.UserBill, java.util.ArrayList, java.util.*,java.text.*" %>
    
    <% UserBill ubill = (UserBill) request.getAttribute("ubill"); %>
   
<%
DecimalFormat df = new DecimalFormat("###,###");
long val = ubill.getAmount();
System.out.println(df.format(val));
%>
<%
SimpleDateFormat ft = new SimpleDateFormat ( "yyyy년 M월");
String bill = ft.format(ubill.getBillYearMonth());
System.out.println(bill);

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
Date eDate = dateFormat.parse(ubill.getCutoffDate().toString());
Calendar c = Calendar.getInstance();
System.out.println(",,,," + eDate);
int month = eDate.getMonth();
int year = c.get(Calendar.YEAR);

c.set(year,month,1);
System.out.println("출력 : " + ", " + month + ", " + year);
String endDay = String.valueOf(c.getActualMaximum(Calendar.DAY_OF_MONTH));
String year2 = String.valueOf(year);
String endMonth = String.valueOf(c.get(Calendar.MONTH));
//System.out.println("endofMonth" + endofMonth);
//String edate = ubill.getCutoffDate().toString().substring(0, 8) + endofMonth;
String after = year + "-" + endMonth + "-" + endDay;
System.out.println("변해라 ~~ " + after);

%>

<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<head>
<meta charset="utf-8">
<title>HiAPTU</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<!--  <link href="img/favicon.png" rel="icon"> -->


<!-- Bootstrap CSS File -->
<link href="/hiapt/resources/css/bootstrap.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="/hiapt/resources/css/prettyphoto.css" rel="stylesheet">
<link href="/hiapt/resources/css/hoverex-all.css" rel="stylesheet">
<link href="/hiapt/resources/css/jetmenu.css" rel="stylesheet">
<link href="/hiapt/resources/css/owl-carousel.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="/hiapt/resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="/hiapt/resources/css/blue.css">

<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">

function print(printArea)
{
		win = window.open(); 
		self.focus(); 
		win.document.open();
		
		/*
			1. div 안의 모든 태그들을 innerHTML을 사용하여 매개변수로 받는다.
			2. window.open() 을 사용하여 새 팝업창을 띄운다.
			3. 열린 새 팝업창에 기본 <html><head><body>를 추가한다.
			4. <body> 안에 매개변수로 받은 printArea를 추가한다.
			5. window.print() 로 인쇄
			6. 인쇄 확인이 되면 팝업창은 자동으로 window.close()를 호출하여 닫힘
		*/
		win.document.write('<html><head><title></title><link href="/hiapt/resources/css/bootstrap.css" rel="stylesheet"><link href="/hiapt/resources/css/style.css" rel="stylesheet"><style>');
		win.document.write('body, td {font-falmily: Verdana; font-size: 10pt;}');
		win.document.write('</style></head><body>');
		win.document.write(printArea);
 		win.document.write('</body></html>');
		win.document.close();
		win.print();
		win.close();
}

</script>
</head>
<!-- head 끝  -->
<body>
<%@ include file="../userheader.jsp"%>

<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 시작==================================================================================-->
<section class="post-wrapper-top">
	<div class="container">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<ul class="breadcrumb">
				<li><a href="/hiapt/index2.jsp">Home</a></li>
				<li>고지서 출력</li>
			</ul>
			<h2>
				<sapn class="text-info"><%= ubill.getMerchantUid() %></sapn>
			 번 고지서출력
			</h2>
		</div>	
		
	</div>
</section>
<!-- end post-wrapper-top -->
<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 끝==================================================================================-->

<!--  -->
<section class="section1">
    <div class="container clearfix">
      <div class="content content col-lg-12 col-md-12 col-sm-12 clearfix">
	
	<i class="fa fa-print"></i>
	<input type = "button" 
	class="btn btn-primary" onClick="print(document.getElementById('printArea').innerHTML)" value="인쇄하기"/>
	<div class="clearfix"></div>
	<div class="divider"></div>
	
	<div id="printArea">
	
	<table class="table table-bordered">
	<thead>
		<tr>
			<th colspan="2">전기 에너지</th>
			<th>금액</th>
			<th colspan="2">열 에너지</th>
			<th>금액</th>
		</tr>		
	</thead>
	<tr>
			<td colspan="2" style="text-align:right;">세대전기료</td>
			<td><%= df.format(ubill.getElectricCost()) %>원</td>
			<td colspan="2" style="text-align:right;">난방사용료</td>
			<td><%= df.format(ubill.getHeatingCost()) %>원</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">공동전기료</td>
			<td><%= df.format(ubill.getAllElectricCost()) %>원</td>
			<td colspan="2" style="text-align:right;">온수사용료</td>
			<td><%= df.format(ubill.getHwaterCost()) %>원</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">Tv수신료</td>
			<td><%= df.format(ubill.getTvCost()) %>원</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<th colspan="2" style="font-size:13pt; text-align:center; color:black; background:#fff;"><%= ft.format(ubill.getBillYearMonth()) %>분</th>
			<th colspan="2" style="font-size:13pt; text-align:center; color:black; background:#fff;"><%= ubill.getUserId().substring(0,3) %>동 
			<%= ubill.getUserId().substring(4,7) %>호</th>
			<th colspan="2" style="font-size:13pt; text-align:center; color:black; background:#fff;"><%= ubill.getUserName() %> 귀하</th>
		</tr>
	<tbody>
		<tr>
			<td>일반관리비</td>
			<td><%= df.format(ubill.getGeneralCost()) %>원</td>
			<th colspan="2" class="warning">전기사용료</th>
			<th>당월부과액</th>
			<td><%= df.format(ubill.getAmount()) %>원</td>
		</tr>
		<tr>
			<td>청소비</td>
			<td><%= df.format(ubill.getCleanCost()) %>원</td>
			<td>세대전기료</td>
			<td><%= df.format(ubill.getElectricCost()) %>원</td>
			<th>미납액</th>
			<td><%= df.format(ubill.getArrears()) %>원</td>
		</tr>
		<tr>
			<td>소독비</td>
			<td><%= df.format(ubill.getDisinfectCost()) %>원</td>
			<td>공동전기료</td>
			<td><%= df.format(ubill.getAllElectricCost()) %>원</td>
			<th>미납연체료</th>
			<td><%= df.format(ubill.getArrearsFine()) %>원</td>
		</tr>
		<tr>
			<td>승강기유지비</td>
			<td><%= df.format(ubill.getElevatorCost()) %>원</td>
			<td>Tv수신료</td>
			<td><%= df.format(ubill.getTvCost()) %>원</td>
			<th>납기후 연체료</th>
			<td><%= df.format(ubill.getAfterAmount()) %>원</td>
		</tr>
		<tr>
			<td>수선유지비</td>
			<td><%= df.format(ubill.getRepairCost()) %>원</td>
			<th colspan="4" class="active"></th>
		</tr>
		<tr>
			<td>경비비</td>
			<td><%= df.format(ubill.getGuardCost()) %>원</td>
			<th colspan="2" class="primary">수도사용료</th>
			<th colspan="2">관리비 납입계좌번호</th>	
		</tr>
		<tr>
			<td>화재보험료</td>
			<td><%= df.format(ubill.getFireInsuranceCost()) %>원</td>
			<td>세대수도료</td>
			<td><%= df.format(ubill.getWaterCost()) %>원</td>
			<td>신한은행</td>
			<td>110-179-435008</td>
		</tr>
		<tr>
			<td>위탁관리수수료</td>
			<td><%= df.format(ubill.getCommission()) %>원</td>
			<td>공동수도료</td>
			<td><%= df.format(ubill.getAllWaterCost()) %>원</td>
			<td>국민은행</td>
			<td>763201-01-148210</td>
		</tr>
		<tr>
			
			<td colspan="4" class="active"></td>
			<td>하나은행</td>
			<td>175320-51-018603</td>
		</tr>
		<tr>
			
			<td colspan="4" class="active"></td>
			<td>우체국</td>
			<td>402172-01-001467</td>
		</tr>
		<tr>
			<th class="danger" style="text-align:center;">납기내</th>				
			<th rowspan="2" colspan="2" style="font-size:20pt; text-align:center; line-height:40pt;"><%= df.format(ubill.getBeforeAmount()) %>원</th> 
			<th class="danger" style="text-align:center;">납기후</th>
			<th rowspan="2" colspan="2" style="font-size:20pt; text-align:center; line-height:40pt;"><%= df.format(ubill.getAfterAmount()) %>원</th> 
		</tr>
		<tr>
		<th class="active" style="text-align:center;"><%= ubill.getCutoffDate() %>까지</th>	
		<th class="active" style="text-align:center;">
		
		<%= after %>까지</th>
		</tr>
		
	</tbody> 
</table>
</div><!-- printArea -->

<div class="card-title" style="float:right;">						          
		<a href="/hiapt/index2.jsp" class="dmbutton button large pull-right">HOME</a></div>
		
	</div>
	<!-- end content -->


	</div>
	<!-- end container -->
</section>
<!-- end section -->

<!--  /// 본문 끝//////  -->

<%@ include file="../userfooter.jsp"%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar, employee.model.vo.Employee"%>
<%
	Employee emp = (Employee)session.getAttribute("employee");
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
.intable{
height:700px;
border:1px;
cellspacing:0;
cellpadding:5;
width:100%;
align:center;
table-layout : fixed;
}
</style>
<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
<%
	Calendar tDay = Calendar.getInstance();//캘린더 객체 생성
	int cy = tDay.get(Calendar.YEAR);//객체에서 년도 변수에 저장 
	int cm = tDay.get(Calendar.MONTH);//객체에서 월 변수에 저장
	int cd = tDay.get(Calendar.DATE);//객체에서 일 변수에 저장
    String Year = request.getParameter("year");
	String Month = request.getParameter("month");

	int year, month;
	if(Year == null && Month == null){
		year = cy;
		month = cm;
	}else{
		year = Integer.parseInt(Year);
		month = Integer.parseInt(Month);
		if(month < 0){
			month = 11; 
			year = year-1;
		}			
		if(month >11){
			month = 0;
			year = year+1;
		}
	}
tDay.set(year, month, 1);//현재 년월 1일을 객체에 저장

int start = tDay.get(Calendar.DAY_OF_WEEK);//현재 년월 1일의 요일을 yo에 저장 일요일 : 1, 월요일:2, 화요일:3..
int lastday = tDay.getActualMaximum(Calendar.DAY_OF_MONTH);//매월이 가질 수 있는 값의 최대값을 마지막일자로 저장함



%>

var str="";
var popup;

$(function(){
	$("td:nth-child(1)").css("color","red");
	$("td:nth-child(7)").css("color","blue");
	$(".intable").css("text-align","right").css("valign","top");
	
	
	var year = <%=year%>
	var mon = <%=month%>
	var month = Number(mon)+1;
	
	var day;
	$(".intable td").on("click", function(){
		
		day=$(this).attr("id");
		
	
		str = year+"-"+month+"-"+day;
		console.log(str);
		
		var url ="scheduleInsert.jsp?y="+year+"&m="+month+"&d="+day;
		var name = "schedule insert";
		var option = "width=500, height=500, top= 100, left = 200, location=no";
		popup = window.open(url, name, option );
		
				
	})
	
	
	$.ajax({
		url : "/hiapt/schlist?year="+year+"&month="+month+"&wr=<%=emp.getEmpNo()%>",
		type : "get",
		dataType : "json",
		success : function(data){
			var jsonStr = JSON.stringify(data);
			var json = JSON.parse(jsonStr);
			
			var value = "";
			
			var onlyday = "";
			
			for(var i in json.list){
				value += 
				json.list[i].cnum+"<br>"+
				decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"<br>"+				
				decodeURIComponent(json.list[i].color).replace(/\+/gi," ")+"<br>"+
				decodeURIComponent(json.list[i].cwriter).replace(/\+/gi," ")+"<br>"+
				json.list[i].cstart.split("-")+"<br>"+
				json.list[i].cend.split("-")+"<br>";
				
					
				var tt = json.list[i].cstart.split("-");
				onlyday += tt[2]+",";
				var dlist = onlyday.split(",");
				
				var div = "<div style='background-color:"+
				decodeURIComponent(json.list[i].color).replace(/\+/gi," ")+";'>"+
				decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"</div>";
				
				if(dlist[i].charAt(0)==0){
					dlist[i] = dlist[i].substr(1);
				}
				
				$("#"+dlist[i]).html($("#"+dlist[i]).html()+div);
				
			//////
			
			//var ss = "<div style='background-color:"
			//+decodeURIComponent(json.list[i].color).replace(/\+/gi," ")
			//+";'>"+decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"</div>"
			//$("#4").html($("#4").html()+ss);
			
			}//for in문 종료
			
			var dlist = onlyday.split(",");
			for(var i in dlist){
				console.log(dlist[i]);
			}
			//test중
			//value 를 달력에 선택자로 div 추가 태그를 함
//			var ss ="<div style='background-color:#D25565;'>title</div>"
//			$("#2").html($("#2").html()+ss);
			
			//받아온 json 출력
			$("#test").html(value+"<br>");
			
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : "+jqXHR+", "+textStatus+", "+errorThrown);
		}
		
	})
	
	

})

</script>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 


<!-- ============================================================= -->
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
							<a class="collapse-item" href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>">전자결재 전체목록</a>
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
<!-- ================================================================================= -->

<!-- 왼쪽 메인 메뉴바 끝  --> 
<!-- ================================================================================= -->

<!--- 중앙 전체 큰 틀 ---------------------------------------------->
<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">
<!-- Main Content -->
<div id="content">

<!-- ================================================================================= -->
<!---탑메뉴  시작 =================---------------------------->

<%@ include file ="../empTopNavi.jsp" %>
<!---탑 메뉴 끝 ------------------------------------------->
<!--========================================================================================== -->
<!-- Begin Page Content -->
<div class="container-fluid">
<!-- 본문 타이틀 들어가는 부분 ---->		


			
<!--///////본문 내용 시작 ///////-------->	
<h1 class="h3 mb-4 text-gray-800">Schedule</h1>
<div class="card shadow mb-4">
<div class="card-body">
<table width="100%"  border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td align="left"colspan="2">
				<button><a href="schedulemain.jsp?year=<%out.print(year-1);%>&month=<%out.print(month);%>">◀</a></button>
				<button><a href="schedulemain.jsp?year=<%out.print(year+1);%>&month=<%out.print(month);%>">▶</a></button>
	
				
			</td>
			<td align="center"colspan="3">
				<button><a href="schedulemain.jsp?year=<%out.print(year);%>&month=<%out.print(month-1);%>">◁</a></button>
						<span style="font-size:20pt;"><% out.print(year); %>년<% out.print(month+1); %>월</span>
		
				<button><a href="schedulemain.jsp?year=<%out.print(year);%>&month=<%out.print(month+1);%>">▷</a></button>
			
			
			</td>
			<td align=right colspan="2"><button id="schin">일정 등록</button></td>
		</tr>
	</table>
  	<table border=1 cellspacing=0 cellpadding="5" width="100%" align="center"> 
		<tr align="center">
    		<td>일</td> <!-- 일=1 -->
   		 	<td>월</td> <!-- 월=2 -->
    		<td>화</td> <!-- 화=3 -->
    		<td>수</td> <!-- 수=4 -->
   			<td>목</td> <!-- 목=5 -->
   			<td>금</td> <!-- 금=6 -->
   			<td>토</td> <!-- 토=7 -->
		</tr>
	</table>
  	<table class="intable" border="1" valign="top"> 
		<tr>
		<%
			int br = 0;
			for(int i = 0; i < (start-1); i++){
				out.println("<td>&nbsp;</td>");
				br++;
				if((br % 7) == 0){
					out.println("<br>");
				}
			}
			
			for(int i = 1; i <= lastday; i++){
				out.println("<td id='"+i+"'>"+i+"</td>");
				br++;
				if((br%7) == 0 && i != lastday){
					out.println("</tr><tr>");
				}
			}
			while((br++) % 7 != 0){
				out.println("<td>&nbsp;</td>");
			}			
			
		%>	
		</tr>

	</table>
	<div id="test"></div>


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
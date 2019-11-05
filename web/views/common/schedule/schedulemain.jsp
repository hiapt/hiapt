<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Calendar, employee.model.vo.Employee"%>
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

<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<!--// css or jQuery or javaScript 삽입 부분    -->
<style>
.check {
display: inline-block !important;
}
table > tbody> tr.intable, table > tbody> tr.intable > td{
height:7rem;
cellspacing:0;
cellpadding:5;
align:center;
table-layout : fixed;
padding:0;
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
var div="";
var str="";


$(function(){
	$("td:nth-child(1)").css("color","red");
	$("td:nth-child(7)").css("color","blue");
	$(".intable").css("text-align","right").css("valign","top");
	var writer ='<%= emp.getEmpNo()%>';
	var year = <%=year%>
	var mon = <%=month%>
	var month = Number(mon)+1;
	var day;
	//일정 db에서 끌어오기
	$.ajax({
		url : "/hiapt/schlist?year="+year+"&month="+month+"&wr="+writer,
		type : "get",
		dataType : "json",
		success : function(data){
			var jsonStr = JSON.stringify(data);
			var json = JSON.parse(jsonStr);
			
			var value = "";
			
			var onlySday = "";
			var onlyEday = "";
			
			for(var i in json.list){
				//가져온 json 변수에 담기
				value += 
				json.list[i].cnum+"<br>"+
				decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"<br>"+				
				decodeURIComponent(json.list[i].color).replace(/\+/gi," ")+"<br>"+
				decodeURIComponent(json.list[i].cwriter).replace(/\+/gi," ")+"<br>"+
				json.list[i].cstart.split("-")+"<br>"+
				json.list[i].cend.split("-")+"<br>";
				
				//시작일자 나눠서 변수에 담기	
				var startdays = json.list[i].cstart.split("-");
				var enddays = json.list[i].cend.split("-");
				
				//일(day)만 String 변수에 담기
				onlySday += startdays[2]+",";
				onlyEday += enddays[2]+",";
				//일(dat)만 array 변수에 담기
				var sDlist = onlySday.split(",");
				var eDlist = onlyEday.split(",");
				
				if(sDlist[i] == eDlist[i]){//시작일자 끝일자 동일하다면 
					var div = "<div class='div' id='"+
					json.list[i].cnum+
					"'style='z-index:1000; cursor:pointer; diplay:block; color:#ffffff; background-color:"+
					decodeURIComponent(json.list[i].color).replace(/\+/gi," ")+";'>"+
					decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"</div>";
					
					if(sDlist[i].charAt(0)==0){
						sDlist[i] = sDlist[i].substr(1);
					}
					
					$("#"+sDlist[i]).html($("#"+sDlist[i]).html()+div);
				}else{//시작일자와 끝일자 동일하지 않다면
					var div = "<div class='div' id='" + json.list[i].cnum+
					"'style='z-index:1000; cursor:pointer; diplay:block; color:#ffffff; background-color:"+
					decodeURIComponent(json.list[i].color).replace(/\+/gi," ")+";'>"+
					decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"</div>";
					
					if(sDlist[i].charAt(0)==0){
						sDlist[i] = sDlist[i].substr(1);
					}else if(eDlist[i].charAt(0)==0){
						eDlist[i] = eDlist[i].substr(1);
					}
					
					
					$("#"+sDlist[i]).html($("#"+sDlist[i]).html()+div);
					$("#"+eDlist[i]).html($("#"+eDlist[i]).html()+div);
				}
				
				
			
			}//for in문 종료
			
			var sslist = onlySday.split(",");
			for(var i in sslist){
				console.log(sslist[i]);
			}
			//받아온 json 출력
			$("#test").html(value+"<br>");
			
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : "+jqXHR+", "+textStatus+", "+errorThrown);
		}
		
	})//ajax 종료	
	
	$(".intable").click(function(event){
		if($(event.target).is(".div")){//클릭한 타겟이 div 클래스라면
			div=$(event.target).attr("id");

			var url ="/hiapt/schdetail?snum="+div;
			var name = "schedule detail";
			var option = "width=600, height=600, top= 100, left = 200, location=no";
			window.open(url, name, option );
		}else if($(event.target).is("td")){
			day=$(event.target).attr("id");
			if(day != null){
				if(month.toString().length == 1){
					month = "0"+month.toString();
				}			
				if(day.length == 1){
					day = "0"+day;
				}		
				
				str = year+"-"+month+"-"+day;			
				console.log(str);
				
				var url ="scheduleInsert.jsp?y="+year+"&m="+month+"&d="+day;
				var name = "schedule insert";
				var option = "width=600, height=600, top= 100, left = 200, location=no";
				popup = window.open(url, name, option );
			}
		}
	})
	
	$("#schin").on("click",function(){
		
		location.href="/hiapt/views/common/schedule/schedulemain.jsp?year=<%=cy%>&month=<%=cm%>";
		return false;
	})
	
});//도큐멘트 리드


</script>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

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
<!-- ============================================================= -->
<!-- 메일 시작 -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#mail" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-envelope-open"></i>
			<span>메일</span>
	</a>
		<div id="mail" class="collapse" aria-labelledby="headingUtilities"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="/hiapt/views/emp/mail/writemail.jsp">메일쓰기</a>
				<a class="collapse-item"
					href="/hiapt/views/emp/mail/selfwritemail.jsp">내게쓰기</a></a> <a
					class="collapse-item"
					href="/hiapt/amlist?empemail=<%=emp.getEmpEmail()%>">전체메일함</a> <a
					class="collapse-item"
					href="/hiapt/rlist?empemail=<%=emp.getEmpEmail()%>">받은메일함</a> <a
					class="collapse-item"
					href="/hiapt/smlist?empemail=<%=emp.getEmpEmail()%>">보낸메일함</a></a> <a
					class="collapse-item"
					href="/hiapt/tmlist?empemail=<%=emp.getEmpEmail()%>">임시보관함</a></a> <a
					class="collapse-item"
					href="/hiapt/selfmlist?empemail=<%=emp.getEmpEmail()%>">내게 쓴
					메일함</a> <a class="collapse-item"
					href="/hiapt/wmlist?empemail=<%=emp.getEmpEmail()%>">휴지통</a>
				<hr>
				
				 <div class="dropdown" style="display:inline-block;">
  							&nbsp;<button class="btn btn-link btn-sm dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown">
  							</button><span>내 메일함</span>&nbsp;
  							<div id="a" class="dropdown-menu">  							
  							</div>
						</div>
				<!-- <button id="insert"><i class="fas fa-plus fa-fw fa-envelope-open"></i></button> -->
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
					<i class="fas fa-plus fa-fw fa-envelope-open"></i>  
				</button>



				<!-- <div>
						<a class="collapse-item" style="display:inline-block;">내 메일함</a>&nbsp;<a href="#"><i class="fas fa-plus fa-fw fa-envelope-open"></i></a>
						</div> -->

			</div>
		</div></li>

	<!-- 메일 끝 -->
<!-- ====================================================================================== -->
<!-- ====================================================================================== -->			
<!--인사정보 시작 -->
		<hr class="sidebar-divider">
		<!-- Heading 나중에 삭제부분-->
<!-- ====================================================================================== -->	      	
			<% if(emp != null && emp.getEmpId().equals("관리자")){ %>
			<li class="nav-item">
			<a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#employee" 
				aria-expanded="true" aria-controls="collapseUtilities"> 
				<i class="fas fa-fw fa-address-card"></i> 
				<span>인사</span>
			</a>
				<div id="employee" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/emplist">직원조회</a> 
						<a class="collapse-item" href="/hiapt/views/emp/employee/empEnroll.jsp">직원등록</a> 
						<a class="collapse-item" href="/hiapt/views/apt/aptEnroll.jsp">입주자등록</a> 
						<a class="collapse-item" href="/hiapt/aptlist">입주자조회</a>
					</div>
				</div>
			</li>
			<% }else{ %>
			<li class="nav-item">
			<a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#employee" 
				aria-expanded="true" aria-controls="collapseUtilities"> 
				<i class="fas fa-fw fa-address-card"></i> 
				<span>인사</span>
			</a>
				<div id="employee" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/empdetail?empno=<%= emp.getEmpNo() %>">내정보보기</a> 
						<a class="collapse-item" href="/hiapt/emplist">직원조회</a> 
						<a class="collapse-item" href="/hiapt/views/user/apt/aptEnroll.jsp">입주자등록</a> 
						<a class="collapse-item" href="/hiapt/aptlist">입주자조회</a>
					</div>
				</div>
			</li>
			
			
			<%-- <li class="nav-item">
			<a class="nav-link collapsed" href="#" 
				data-toggle="collapse" data-target="#employee" 
				aria-expanded="true" aria-controls="collapseUtilities"> 
				<i class="fas fa-fw fa-address-card"></i> 
				<a href="/hiapt/empdetail?empno=<%= emp.getEmpNo() %>"><span>내정보보기</span></a>
			</a>
			</li> --%>
			<% } %>
			

<!-- 인사정보 끝 -->
<!-- ================================================================================= -->

<!-- ================================================================================= -->
<!--전자결재 시작 -->
		<hr class="sidebar-divider">
		<!-- Heading 나중에 삭제부분-->
<!-- ====================================================================================== -->	
			<% if(emp != null && emp.getEmpNo().equals("admin")) { %>
			
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#draft" aria-expanded="true"
				aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-folder"></i> <span>전자결재</span>
			</a>
				<div id="draft" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
							<a class="collapse-item" href="/hiapt/dlist.ad?page=1">전자결재 전체목록</a>
							<a class="collapse-item" href="/hiapt/dstandby.ad?page=1">전자결재 대기목록</a> 
							<a class="collapse-item" href="/hiapt/dapproved.ad?page=1">전자결재 승인목록</a> 
							<a class="collapse-item" href="/hiapt/dreturn.ad?page=1">전자결재 반려목록</a> 
							<a class="collapse-item" href="/hiapt/ddefer.ad?page=1">전자결재 보류목록</a>
							<a class="collapse-item" href="/hiapt/flist?page=1">문서 양식함</a>
							<a class="collapse-item" href="">업무일지 작성</a>
							<a class="collapse-item" href="">직원 업무일지함</a>
							<a class="collapse-item" href="">관리자 업무일지함</a>
							
					</div>
				</div>
			</li>
			
			<%} else { %>
		
			
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#draft" aria-expanded="true"
				aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-folder"></i> <span>전자결재</span>
			</a>
				<div id="draft" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item"
							href="/hiapt/views/emp/approval/draftWrite.jsp">기안작성</a> 
							<a class="collapse-item" href="/hiapt/dtemp?empno=<%= emp.getEmpNo() %>&page=1">임시보관함</a> 
							<a class="collapse-item" href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=1">전자결재 전체목록</a>
							<a class="collapse-item" href="/hiapt/dstandby?empno=<%= emp.getEmpNo() %>&page=1">전자결재 대기목록</a> <a
							class="collapse-item" href="/hiapt/dapproved?empno=<%= emp.getEmpNo() %>&page=1">전자결재 승인목록</a> <a
							class="collapse-item" href="/hiapt/dreturn?empno=<%= emp.getEmpNo() %>&page=1">전자결재 반려목록</a> <a
							class="collapse-item" href="/hiapt/ddefer?empno=<%= emp.getEmpNo() %>&page=1">전자결재 보류목록</a>
					</div>
				</div>
			</li>
				<%}  %>
<!-- 전자결재 끝 -->
<!-- ================================================================================= -->
<!-- ================================================================================= -->
<!--관리비 시작 -->
		<hr class="sidebar-divider">
		<!-- Heading 나중에 삭제부분-->
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
							class="collapse-item" href="/hiapt/bilist">고지서(전부) 목록 </a> <a
							class="collapse-item"
							href="/hiapt/views/emp/maintenance/BillList.jsp">고지서 상세 목록 조회</a>
						<a class="collapse-item"
							href="/hiapt/views/emp/maintenance/BillListDetailView.jsp">상세보기</a>
						<a class="collapse-item" href="/hiapt/bvis">부과기초작업</a> <a
							class="collapse-item" href="/hiapt/imvas">연습용</a>
					</div>
				</div>
			</li>
<!-- 관리비 끝 -->
<!-- ================================================================================= -->
<!-- ================================================================================= -->
	
<!--공지사항 시작 -->
		<hr class="sidebar-divider">
	  	<!-- Heading 나중에 삭제부분-->
<!-- ================================================================================= -->

			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#notice"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-bullhorn"></i> <span>행정관리</span>
			</a>
				<div id="notice" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/no.list">공지사항 관리</a> 
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
<!-- ================================================================================= -->
         <li class="nav-item"><a class="nav-link"
            href="/hiapt/views/common/schedule/schedulemain.jsp"> <i
               class="fas fa-fw fa-calendar-alt"></i> <span>Calendar</span></a>
         </li>
<!--캘린더 끝 -->
<!-- ================================================================================= -->
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
<table class="table">
		<tr>
			<td align="left"colspan="2">
				<button class="btn btn-primary btn-sm"><a href="schedulemain.jsp?year=<%out.print(year-1);%>&month=<%out.print(month);%>"><span class="text-white">◀</span></a></button>
				<button class="btn btn-primary btn-sm"><a href="schedulemain.jsp?year=<%out.print(year+1);%>&month=<%out.print(month);%>"><span class="text-white">▶</span></a></button>
			</td>
			<td align="center"colspan="3">
			<button class="btn btn-primary btn-sm"><a href="schedulemain.jsp?year=<%out.print(year);%>&month=<%out.print(month-1);%>"><span class="text-white">◁</span></a></button>
			<span style="font-size:20pt;"><% out.print(year); %>년<% out.print(month+1); %>월</span>
			<button class="btn btn-primary btn-sm"><a href="schedulemain.jsp?year=<%out.print(year);%>&month=<%out.print(month+1);%>"><span class="text-white">▷</span></a></button>
			</td>
			<td align=right colspan="2"><button class="btn btn-sm btn-outline-primary shadow-sm" id="schin" >
			오늘 날짜</button></td>
		</tr>
	</table>
  	<table class="table table-bordered">
		<thead class="thead-dark">
   		<tr class="text-center">
     		<th scope="col" style="width:13.5%">일</th><!-- 일=1 -->
      		<th scope="col"style="width:14%">월</th><!-- 월=2 -->
      		<th scope="col"style="width:14%">화</th><!-- 화=3 -->
      		<th scope="col"style="width:14%">수</th><!-- 수=4 -->
      		<th scope="col"style="width:14%">목</th><!-- 목=5 -->
      		<th scope="col"style="width:14%">금</th><!-- 금=6 -->
      		<th scope="col" style="width:13.5%">토</th><!-- 토=7 -->
    	</tr> 
  		</thead>
  <tbody>
		<tr class="intable">
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
				
				if(year == cy && month == cm&& i==cd){
					
					out.println("<td style='z-index:100; background:#FCF8E3;' id='"+i+"'>"+i+"</td>");
				}else{
					out.println("<td style='z-index:100;' id='"+i+"'>"+i+"</td>");
				}
				br++;
				
				if((br%7) == 0 && i != lastday){
					out.println("</tr><tr class='intable'>");
				}
			}
			while((br++) % 7 != 0){
				out.println("<td>&nbsp;</td>");
			}			
			
		%>	
		</tr>

	</tbody>
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
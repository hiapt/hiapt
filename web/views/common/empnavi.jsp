<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee"%>
<%
	Employee emp = (Employee)session.getAttribute("employee");
%>
<!-- 메일관련 요소 -->
<style>

.contextmenu {
  display: none;
  position: absolute;
  width: 200px;
  margin: 0;
  padding: 0;
  background: #FFFFFF;
  border-radius: 5px;
  list-style: none;
  box-shadow:
    0 15px 35px rgba(50,50,90,0.1),
    0 5px 15px rgba(0,0,0,0.07);
  overflow: hidden;
  z-index: 999999;
}

</style>
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script>
$(function(){	
		$.ajax({
			url : "/hiapt/mbtlist",
			type : "post",
			data : {empemail : $("#empemail").val()},
			dataType : "json",
			success : function(data){
				var jsonStr = JSON.stringify(data);
				var json = JSON.parse(jsonStr);
				
				var values = "";
				for(var i in json.list){
					values += "<a href='#'>" + decodeURIComponent(json.list[i].bname).replace(/\+/gi, " ") + "</a><br>";
				}
				
				$("#a").html($("#a").html() + values);
			},
			error : function(jqXHR, textStatus, errorThrown){
				console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
			}
		});
		console.log("성공")
	
	$("#send").click(function(){
		$.ajax({
			url : "/hiapt/mtenroll",
			type : "post",
			data : { mbox : $("#boxname").val()}
		});
		
		$("#a").html($("#a").html() + "<a>" + $("#boxname").val() + "</a><br>");
		$("#boxname").val("");
		
	});
		
		$(document).contextmenu(function(e){
		    //Get window size:
		    var winWidth = $(document).width();
		    var winHeight = $(document).height();
		    //Get pointer position:
		    var posX = e.pageX;
		    var posY = e.pageY;
		    //Get contextmenu size:
		    var menuWidth = $(".contextmenu").width();
		    var menuHeight = $(".contextmenu").height();
		    //Security margin:
		    var secMargin = 10;
		    //Prevent page overflow:
		    if(posX + menuWidth + secMargin >= winWidth
		    && posY + menuHeight + secMargin >= winHeight){
		      //Case 1: right-bottom overflow:
		      posLeft = posX - menuWidth - secMargin + "px";
		      posTop = posY - menuHeight - secMargin + "px";
		    }
		    else if(posX + menuWidth + secMargin >= winWidth){
		      //Case 2: right overflow:
		      posLeft = posX - menuWidth - secMargin + "px";
		      posTop = posY + secMargin + "px";
		    }
		    else if(posY + menuHeight + secMargin >= winHeight){
		      //Case 3: bottom overflow:
		      posLeft = posX + secMargin + "px";
		      posTop = posY - menuHeight - secMargin + "px";
		    }
		    else {
		      //Case 4: default values:
		      posLeft = posX + secMargin + "px";
		      posTop = posY + secMargin + "px";
		    };
		    //Display contextmenu:
		    $(".contextmenu").css({
		      "left": posLeft,
		      "top": posTop
		    }).show();
		    //Prevent browser default contextmenu.
		    return false;
		  });
		  //Hide contextmenu:
		  $(document).click(function(){
		    $(".contextmenu").hide();
		  });
});

/* window.oncontextmenu = function () {
	  return false;
	}; */

</script>
<input type="hidden" id="empemail" value="<%= emp.getEmpEmail() %>">

<ul class="contextmenu">
  <li><a href="#">Simple link</a></li>
  <li><a href="#">Link to somewhere</a></li>
</ul>
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
		data-toggle="collapse" data-target="#mail" aria-expanded="true"
		aria-controls="collapseTwo"> <i class="fas fa-fw fa-envelope-open"></i>
			<span>메일(직원)</span>
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
      	<div class="sidebar-heading">직원</div>
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
      	<div class="sidebar-heading">직원</div>
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
<hr class="sidebar-divider">
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
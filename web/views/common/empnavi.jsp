<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="employee.model.vo.Employee"%>
<%
	Employee emp = (Employee)session.getAttribute("employee");
%>

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
						<a class="collapse-item" href="/hiapt/emplist">직원정보</a> <a
							class="collapse-item"
							href="/hiapt/views/emp/member/empenroll.html">직원등록</a> <a
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
					class="fas fa-fw fa-bullhorn"></i> <span>공지사항</span>
			</a>
				<div id="notice" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/hiapt/views/master/notice/noticeAdminListView.jsp">공지사항 목록</a> 
						<a class="collapse-item" href="*">공지사항 대기목록 </a> 
						<a class="collapse-item" href="*">공지사항2</a>
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
            href="z"> <i
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
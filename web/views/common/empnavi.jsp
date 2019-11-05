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
				values += "<a href='/hiapt/mymb?mcode="+json.list[i].mcode+"&email="+json.list[i].email+"&name="
						+decodeURIComponent(json.list[i].name).replace(/\+/gi, " ")+"' class='q'>"
						+ decodeURIComponent(json.list[i].name).replace(/\+/gi, " ") + "</a><br>";
			}
			json.list[i].email
			$("#a").html($("#a").html() + values);
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
		}
	});
	
	$("#send").click(function(){
		$.ajax({
		url : "/hiapt/mtenroll",
		type : "post",
		data : { mbox : $("#boxname").val(),
				 empemail : $("#empemail").val()
		},
		dataType : "json",
		success : function(data){
			$("#a").html($("#a").html() 
		+ "<a href='/hiapt/mymb?mcode="+data.mcode+"&email="+data.email+"&name="
			+decodeURIComponent(data.name).replace(/\+/gi, " ")+"' class='q'>"
			+ decodeURIComponent(data.name).replace(/\+/gi, " ") + "</a><br>");
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
		}
	});	
});
	
		
		
});

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
				href="/hiapt/index.jsp">
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
				<a class="collapse-item" href="/hiapt/emlist">메일쓰기</a>
				<!-- "/hiapt/views/emp/mail/writemail.jsp" -->
				<a class="collapse-item"
					href="/hiapt/views/emp/mail/selfwritemail.jsp">내게쓰기</a><a
					class="collapse-item"
					href="/hiapt/mlist?empemail=<%=emp.getEmpEmail()%>&mcode=0">전체메일함</a> <a
					class="collapse-item"
					href="/hiapt/mlist?empemail=<%=emp.getEmpEmail()%>&mcode=1">받은메일함</a> <a
					class="collapse-item"
					href="/hiapt/mlist?empemail=<%=emp.getEmpEmail()%>&mcode=2">보낸메일함</a><a
					class="collapse-item"
					href="/hiapt/mlist?empemail=<%=emp.getEmpEmail()%>&mcode=3">임시보관함</a><a
					class="collapse-item"
					href="/hiapt/mlist?empemail=<%=emp.getEmpEmail()%>&mcode=4">내게 쓴
					메일함</a> <a class="collapse-item"
					href="/hiapt/mlist?empemail=<%=emp.getEmpEmail()%>&mcode=5">휴지통</a>
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
							<a class="collapse-item" href="/hiapt/dapproved.ad?page=1">전자결재 완료목록</a> 
							<a class="collapse-item" href="/hiapt/dreturn.ad?page=1">전자결재 반려목록</a> 
							<a class="collapse-item" href="/hiapt/flist?page=1">문서 양식함</a>
							<a class="collapse-item" href="">업무일지 작성</a>
							<a class="collapse-item" href="/hiapt/llist.emp?page=1">직원 업무일지함</a>
							<a class="collapse-item" href="/hiapt/llist.ad?page=1">관리자 업무일지함</a>
							
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
							href="/hiapt/dwrite">기안작성</a> 
							<a class="collapse-item" href="/hiapt/dtemp?empno=<%= emp.getEmpNo() %>&page=1">임시보관함</a> 
							<a class="collapse-item" href="/hiapt/dlist?empno=<%= emp.getEmpNo() %>&page=1">전자결재 전체목록</a>
							<a class="collapse-item" href="/hiapt/dstandby?empno=<%= emp.getEmpNo() %>&page=1">전자결재 대기목록</a>
							 <a class="collapse-item" href="/hiapt/dapproved?empno=<%= emp.getEmpNo() %>&page=1">전자결재 완료목록</a> 
							<a class="collapse-item" href="/hiapt/dreturn?empno=<%= emp.getEmpNo() %>&page=1">전자결재 반려목록</a> 
							<a class="collapse-item" href="/hiapt/llist.my?empno=<%= emp.getEmpNo() %>&page=1">내 업무일지함</a>
							<a class="collapse-item" href="/hiapt/mlist.emp?empno=<%= emp.getEmpNo() %>">내 문서함 목록</a>
							
					</div>
				</div>
			</li>
				<%}  %>
<!-- 전자결재 끝 --> 	
<!-- ================================================================================= -->
<!-- ================================================================================= -->
<!--관리비 시작 -->
<% if(emp != null && !(emp.getEmpNo().equals("admin"))) { %>
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
						<a class="collapse-item" href="/hiapt/bvis">부과기초작업</a> 
						<a class="collapse-item" href="/hiapt/bwlist">고지서목록 </a>			
						<a class="collapse-item" href="/hiapt/*">수납목록</a> 
						<a class="collapse-item" href="/hiapt/views/emp/maintenance/baseViewInsertForm_addRow.jsp">부과기초작업연습용</a>
						<a class="collapse-item" href="/hiapt/views/emp/maintenance/sms.jsp">sms연습용</a>
					</div>
				</div>
			</li>
<!-- 관리비 끝 -->
<% } %>
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
						<a class="collapse-item" href="/hiapt/co.list">민원 관리 </a> 
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
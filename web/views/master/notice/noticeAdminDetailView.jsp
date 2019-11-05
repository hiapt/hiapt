<!--/// jsp 코드 ///-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee, notice.model.vo.Notice, java.util.ArrayList, notice.model.vo.NoticeFiles"%>

<%
	Employee loginEmployee = (Employee) session.getAttribute("employee");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	Notice notice = (Notice)request.getAttribute("notice");
	ArrayList<NoticeFiles> nfiles = (ArrayList<NoticeFiles>)request.getAttribute("nfiles");

%>

<!--복사 시작 ////////////////////////////--------------------->

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->

<script type="text/javascript">
function noUpdate(){
	window.location.href="/hiapt/no.view?uporview=up&nno=<%= notice.getNoticeNo() %>&page=<%=currentPage%>";
	return false;
}
function noDelete(){
	var returnValue = window.confirm("해당 공지를 삭제하시겠습니까 ?");
	if(returnValue){
		window.location.href="/hiapt/no.del?nno=<%=notice.getNoticeNo()%>";
	}else{
		return;
	}	
	return false;
}
function moveList(){
	window.location.href="/hiapt/no.list?page=<%=currentPage%>";
	return false;
}
</script>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 

<%@ include file ="../../common/empnavi.jsp" %>

<!-- 왼쪽 메인 메뉴바 끝  --> 

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
					
<!--///////본문 내용 시작 ///////-------->

<h1 align="center">공지사항 상세보기</h1>
<br>
<div class="card shadow mb-4">
<div class="card-body">



	<table class="table table-borderedz" >
		<div align="right">
		
		<%if( loginEmployee.getEmpNo().equals("admin")) {%>
		<button class="btn btn-outline-warning btn-sm" onclick="noUpdate();">수정하기</button>&nbsp;&nbsp;&nbsp;
		<button class="btn btn-outline-danger btn-sm" onclick="noDelete();">삭제하기</button>&nbsp;&nbsp;&nbsp;
		<button class="btn btn-outline-secondary btn-sm" onclick="moveList();">목록이동</button>
		<%}else{ %>
		<button class="btn btn-outline-secondary btn-sm" onclick="javascript:window.history.go(-1);">목록이동</button>
		<%} %>
		</div>
		<br>
		<tr><th>글번호</th><td><%=notice.getNoticeNo() %></td><th>조회수</th><td><%=notice.getNoticeReadCount() %></td></tr>
		<tr><th>작성자</th><td><%=notice.getNoticeWriter()%></td><th>작성일 </th><td><%=notice.getNoticeDate() %></td></tr>
		<tr><th>제목</th><td colspan="3"><%=notice.getNoticeTitle() %></td></tr>
		<tr><th>내용</th><td colspan="3"><%=notice.getNoticeContents() %></td></tr>
		<tr><th>첨부파일</th><td colspan="3">
			<%if(nfiles.size() != 0) {%>
			<%for(NoticeFiles nf : nfiles) {%>
			<div align ="right">
			<h5 style="display:inline-block"><i class="fa fa-paperclip"></i></h5>
			<a href="/hiapt/no.fdown?ofile=<%= nf.getNoticeOriginalFileName() %>&rfile=<%= nf.getNoticeRnameFileName() %>">
			<h6 style="display:inline-block"><%= nf.getNoticeOriginalFileName() %></h6></a>
			<h6 style="display:inline-block"><%= nf.getNoticeFileSize() %></h6>
			</div>
			<%}}else{ %>		
			첨부파일 없음
			<%} %>		
		</td></tr>
	</table>
   </div>
</div>
<!---//// 본문 내용 끝 ///////------------------->
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
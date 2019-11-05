<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee, notice.model.vo.Notice, java.util.ArrayList, notice.model.vo.NoticeFiles"%>

<%
	//Employee loginEmployee = (Employee) session.getAttribute("employee");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();	
	Notice notice = (Notice)request.getAttribute("notice");
	ArrayList<NoticeFiles> nfiles = (ArrayList<NoticeFiles>)request.getAttribute("nfiles");
%>	
<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html" %>
<!-- head 끝  -->

<body>
<!-- navi 시작  -->
<%@ include file="../userheader.jsp" %>
<!-- navi 끝  -->

<!-- /// 본문 시작////// -->
<!-- 본문 제목 타이틀 부분 복사 시작 ===================================================================================-->
   <section class="post-wrapper-top">
    <div class="container">
      <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
        <ul class="breadcrumb">
          <li><a href="index2.jsp">Home</a></li>
          <li>공지사항</li>
        </ul>
        <h2>공지사항 목록</h2>
      </div>
    </div>
  </section>
  <!-- end post-wrapper-top -->
<!-- 본문 타이틀 복사 끝 ======================================================================================================-->

<section class="section1" align="center">
    <div class="container clearfix">
	<table class="table table-bordered" style="text-align:center;">
		<div align="right">
		<button onclick="javascript:window.history.go(-1);">목록으로 이동</button>
		</div>
		<tr><th>글번호</th><td><%=notice.getNoticeNo() %></td><th>조회수</th><td><%=notice.getNoticeReadCount() %></td></tr>
		<tr><th>작성자</th><td><%=notice.getNoticeWriter() %></td><th>작성일 </th><td><%=notice.getNoticeDate() %></td></tr>
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
</section>


<!--  /// 본문 끝//////  -->
<!-- footer 시작 -->
 <%@ include file="../userfooter.jsp" %>
<!-- footer 끝  -->
 </body>
</html>
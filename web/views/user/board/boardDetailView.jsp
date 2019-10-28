<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.*,aptuser.model.vo.Aptuser, java.util.*"%>
<%
	Board board = (Board) request.getAttribute("board");
	ArrayList<BoardFiles> bfiles = (ArrayList<BoardFiles>)request.getAttribute("bfiles");
	int currentPage = (int)request.getAttribute("currentPage");
%>
<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html"%>
<!-- head 끝  -->
<script type="text/javascript">

function boardUpdate(){
	window.location.href="/hiapt/bo.view?uporview=up&bno=<%= board.getBoardNo() %>";
	return false;
};	

function boardDelete(){
	var yn = confirm("정말로 삭제하시겠습니까?");
	if(yn==true)
	window.location.href="/hiapt/bo.delete?bno=<%= board.getBoardNo() %>";
	return false;
};	

function boardView(){
	window.location.href="/hiapt/bo.list?page=<%= currentPage %>";
	return false;
};

</script>

<body>
	<!-- navi 시작  -->
	<%@ include file="../userheader.jsp"%>
	<!-- navi 끝  -->

	<!-- /// 본문 시작////// -->
	<!-- 본문 제목 타이틀 부분 복사 시작 ===================================================================================-->
	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="index2.jsp">Home</a></li>
					<li>자유게시판</li>
				</ul>
				<h2>자유게시판 조회</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<!-- 본문 타이틀 복사 끝 ======================================================================================================-->
	<section class="section1">
		<div class="container clearfix">

			<table class="table table-bordered">
				<tr>
					<th width="70" style="text-align: center"><%= board.getBoardNo() %> </th>
					<th style="text-align: center"><%=board.getBoardTitle()%></th>
					<th width="150" style="text-align: center"><%=board.getBoardWriter()%></th>
					<th width="150" style="text-align: center"><%=board.getBoardDate()%></th>
				</tr>
				<tr>
					<td colspan="4" style="text-align: center">
					<%if(bfiles.size() != 0) {%>
					<%for(BoardFiles bf : bfiles) {%>
					<div align ="right">
					<h5 style="display:inline-block">첨부파일 : </h5>
					<a href="/hiapt/bo.fdown?ofile=<%= bf.getBoardOriginalFileName() %>&rfile=<%= bf.getBoardRnameFileName() %>">
				 	<h6 style="display:inline-block"><%= bf.getBoardOriginalFileName() %></h6></a>
				 	<h6 style="display:inline-block"><%= bf.getBoardFileSize() %></h6>
					</div>
					<%} %>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<%=board.getBoardContents()%>
					<%}else{%>
					<%=board.getBoardContents()%>
					<%}%>
					</td>
				</tr>
			</table>
			<div align="right">
			<%if(aptuser.getUserId().equals(board.getUserId())) {%>
				<button onclick="boardUpdate();">수정페이지</button>&nbsp;
				<button onclick="boardDelete();">삭제하기</button>&nbsp;
			<%} %>
				<button onclick="boardView();">목록보기</button>&nbsp;
			</div>
		</div>
	</section>



	<!--  /// 본문 끝//////  -->
	<!-- footer 시작 -->
	<%@ include file="../userfooter.jsp"%>
	<!-- footer 끝  -->
</body>
</html>
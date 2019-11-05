<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="employee.model.vo.Employee,complain.model.vo.*, java.util.ArrayList"%>
<%
	Employee employee = (Employee)session.getAttribute("employee");
	Complain comp = (Complain)request.getAttribute("comp");
	ArrayList<ComplainImgs> imglist = (ArrayList<ComplainImgs>)request.getAttribute("imglist");
	int currentPage = (int)request.getAttribute("currentPage");
%>

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->

<script type="text/javascript">
function checkSubmit(){
	var compNo ="<%= comp.getCompNo() %>";
	if(compNo==1){
		alert("테스트글은 답변을 달수 없습니다.");
		return false;
	}
	
	var cResponse = document.getElementById("cresponse").value;
	
	if(cResponse.length>1001){
		alert("글내용은 1000글자 이하만 가능합니다.");
		$("#cresponse").focus();
		return false;
	}
	return true;
}

function cdelete(){
	var compNo ="<%= comp.getCompNo() %>";
	if(compNo==1){
		alert("테스트글은 삭제 할 수 없습니다.");
	}else{
	var yn = confirm("정말로 삭제하시겠습니까?")
	if(yn==true)
	window.location.href="/hiapt/co.delete?compno="+compNo;
	}
	return false;
};

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

	<h1 align="center">민원 관리</h1>
	<br>
	<!-- 테이블 -->
	<div class="card shadow mb-4">
	<div class="card-body">
	<!-- 테이블시작 -->

	<table class="table table-bordered">
				<tr>
					<td width="70" style="text-align: center"><%= comp.getCompNo() %> </td>
					<th style="text-align: center"><%= comp.getCompTitle() %></th>
					<td width="120" style="text-align: center">
					<%if(comp.getCompNo()==1) {%>
					테스트
					<%}else{ %>
					<%= comp.getUserName() %></td>
					<%} %>
					<td width="130" style="text-align: center"><%= comp.getCompDate() %></td>
					<%if(comp.getCompSecret().equals("Y")){ %>
					<td width="100" style="text-align: center">비공개</td>
					<%}else{ %>
					<td width="100" style="text-align: center">공개</td>
					<%} %>
				</tr>
				<tr>
					<td colspan="6">
					<%for(int i=0; i<imglist.size(); i++) {%>
					<img src="/hiapt/resources/complainImgs/<%= imglist.get(i).getCompRenameImgname() %>" onclick="openImg(this.src)" width="250" height="250">
					<%} %>
					<br><%= comp.getCompContents() %>
					</td>
				</tr>
	</table>
	<%if( employee.getEmpNo().equals("admin")) {%>
	<form action="/hiapt/co.ad.update" method="post" onsubmit="return checkSubmit();">
	<table class="table table-bordered">
		<tr style="text-align: center">
				<input type="hidden" name="cno" value="<%= comp.getCompNo() %>">
				<th style="text-align: center">처리 여부</th>
				<%if( comp.getCompResultStatus().equals("N")) {%>
				<td><input type="radio" name="cresult" value="N" checked="checked"> 처리 중 &nbsp; &nbsp; 
					<input type="radio" name="cresult" value="Y"> 처리 완료</td>
				<%}else{ %>
				<td><input type="radio" name="cresult" value="N"> 처리 중 &nbsp; &nbsp; 
					<input type="radio" name="cresult" value="Y" checked="checked"> 처리 완료</td>
				<%} %>
		</tr>
		<tr><td colspan="2"><h4><%= comp.getEmpName() %>님의 답변입니다.</h4>
				<textarea id="cresponse" rows="10" cols="50" name="cresponse" required>
				<%if(comp.getCompReponse() != null) {%>
				<%= comp.getCompReponse() %>
				<%} %>
				</textarea>
		</td></tr>
		<tr>			
			<td style="text-align: center" colspan="2">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
				<input type="submit" value ="작성저장"> &nbsp; &nbsp;
				<input type="reset" value="작성취소"> &nbsp; &nbsp;
				<input type="button" value="삭제하기" onclick="cdelete();">&nbsp;&nbsp;
				<input type="button" value="이전페이지로" onclick="history.go(-1);">
			</td>
		</tr>
	</table>
	</form>
	<% }else{ %>
	<table class="table table-bordered">
		<tr style="text-align: center">
			<th>처리상태</th><td><% if(comp.getCompResultStatus().equals("N")) {%>
			처리 중
			<%} else{%>
			처리 완료
			<%} %>
			</td>
		</tr>
		<tr>
		<td colspan="2">
		<h4><%= comp.getEmpName() %>님의 답변입니다.</h4>
		<%if(comp.getCompReponse()==null) {%>
		민원 처리 대기중입니다. 확인 후 연락드리겠습니다.
		<%}else {%>
		<%= comp.getCompReponse() %>
		<%} %>
		</td>
		</tr>
	</table>
	<div align="right">
		<button onclick="history.go(-1);">목록</button>
	</div>	
	<% } %>
<!-- 테이블틀끝 -->
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



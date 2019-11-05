<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee,java.util.*,java.text.*"%>
<%
	Employee employee = (Employee) session.getAttribute("employee");
%>
<%
	Date date =new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->

<script type="text/javascript">
	var addCount = 0;
	var addVote = document.getElementsByClassName("addvote");
	var inputVote = document.getElementsByClassName("inputvote");
	function voteAddFunction() {
		if (addCount === -1)
			addCount++;

		if (addCount > 2) {
			alert("더이상 추가 할 수 없습니다.");
		} else {
			addVote[addCount].style.display = "";
			addCount++;
		}
		return false;
	}

	function voteDeleteFunction() {
		addCount--;
		if (addCount < 0) {
			alert("더이상 삭제 할 수 없습니다.");
		} else {
			addVote[addCount].style.display = "none";
			inputVote[addCount].value="";

		}
		return false;
	}
	
	function checkSubmit(){
		var vTitle = document.getElementById("vtitle").value;
		var vContent = document.getElementById("vcontent").value;
		
		if(vTitle.length>31){
			alert("제목은 30글자 이하만 가능합니다.");
			$("#vtitle").focus();
			return false;
		}
		
		if(vContent.length>1001){
			alert("글내용은 1000글자 이하만 가능합니다.");
			$("#content").focus();
			return false;
		}
		
		for(var i=1; i<6; i++){
			var voteName = document.getElementById("v"+i).value;
			if(voteName.length>16){
				alert("투표"+i+"은(는) 15글자 이하만 가능합니다.");
				$("#v"+i).focus();
				return false;
			}
		}
		
		return true;
	}
</script>
<body id="page-top" >

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

	<h2 align="center">주민투표 작성</h2>
	<br>
	<!-- 테이블 -->
	<div class="card shadow mb-4">
	<div class="card-body">
	<!-- 테이블시작 -->
	<form action="/hiapt/vo.ad.write" method="post" onsubmit="return checkSubmit();">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="vtitle" id="vtitle" required></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>관리자</td>
				<input type="hidden" name="vwrite" value="<%= employee.getEmpNo() %>">
			</tr>
			<tr>
				<th>투표시작일(작성날짜)</th>
				<td><%= sysdate %></td>
			</tr>
			<tr>
				<th>투표마감일</th>
				<td><input type="date" name="vfinaldate" required></td>
			</tr>
			<tr>
				<th>유기명(Y/N)</th>
				<td><input type="radio" name="vsecret" value="Y" required
					checked>Y(유기명) <input type="radio" name="vsecret" value="N">N(무기명)</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50" name="vcontent" id="vcontent" required></textarea></td>
			</tr>
			<tr>
				<th>투표1</th>
				<td><input id="v1" type="text" name="vote1" required></td>
			</tr>
			<tr>
				<th>투표2</th>
				<td><input id="v2" type="text" name="vote2" required>&nbsp;&nbsp;
					<input type="button" onclick="voteAddFunction();" value="추가">&nbsp;
					<input type="button" onclick="voteDeleteFunction();" value="삭제"></td>
			</tr>
			<tr class="addvote" style="display: none">
				<th>투표3</th>
				<td><input id="v3" class="inputvote" type="text" name="vote3" ></td>
			</tr>
			<tr class="addvote" style="display: none">
				<th>투표4</th>
				<td><input id="v4" class="inputvote" type="text" name="vote4" ></td>
			</tr>
			<tr class="addvote" style="display: none">
				<th>투표5</th>
				<td><input id="v5" class="inputvote" type="text" name="vote5" ></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
					<input type="submit" value ="작성저장"> &nbsp;
					<input type="reset" value="작성취소"> &nbsp; 
					<input type="button" value="이전페이지로" onclick="javascript:window.history.go(-1);">
				</td>
			</tr>
		</table>
	</form>
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



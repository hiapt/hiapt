<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="employee.model.vo.Employee,vote.model.vo.Vote,vote.model.vo.VoteResult,java.util.*,java.text.*"%>
<%
	Employee employee = (Employee)session.getAttribute("employee");
	Vote vote = (Vote)request.getAttribute("vote");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	String vote1 = vote.getVoteOne();
	String vote2 = vote.getVoteTwo();
	String vote3 = vote.getVoteThree();
	String vote4 = vote.getVoteFour();
	String vote5 = vote.getVoteFive();
	String voteName[] = {vote1, vote2, vote3, vote4, vote5};
	VoteResult voteResult = (VoteResult)request.getAttribute("voteresult");
	int voteResultName[] = {voteResult.getVoteOneResult(),voteResult.getVoteTwoResult(),
			voteResult.getVoteThreeResult(),voteResult.getVoteFourResult(),
			voteResult.getVoteFiveResult()};
%>  

<%
	Date date =new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
	Date today = simpleDate.parse(sysdate);
%>

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->

<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
function vdelete(){
	var voteNo ="<%= vote.getVoteNo() %>";
	if(voteNo==1){
		alert("테스트글은 삭제 할 수 없습니다.");
	}else{
	var yn = confirm("정말로 삭제하시겠습니까?")
	if(yn==true)
	window.location.href="/hiapt/vo.ad.delete?voteno="+voteNo;
	}
	return false;
};
function vupdate(){
	var voteNo ="<%= vote.getVoteNo() %>";
	if(voteNo==1)
		alert("테스트글은 수정 할 수 없습니다.");
	else
		window.location.href="/hiapt/vo.ad.upview?vno="+voteNo;
	return false;
};

function vcheck(){
	var voteNo ="<%= vote.getVoteNo() %>";
	var voteSecret = "<%= vote.getVoteSecret() %>";
	window.open("/hiapt/vo.vrpcheck?voteno="+voteNo+"&votesecret="+voteSecret,"voteCheck","width=330,height=500");
	return false;
}

function vList(){
	window.location.href="/hiapt/vo.list?page=<%= currentPage %>";
	return false;
}
</script>
</head>
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

	<h1 align="center">주민투표</h1>
	<br>
	<!-- 테이블 -->
	<div class="card shadow mb-4">
	<div class="card-body">
	<!-- 테이블시작 -->				


<table class="table table-bordered">
	<tr align="center">
		<td width="50"><%= vote.getVoteNo() %></td>
		<th><%= vote.getVoteTitle() %></th>
		<td width="80">관리자</td>
		<td width="400">투표 진행일 : <%= vote.getVoteDate() %> ~
		<%if(vote.getVoteFinalDate().compareTo(today)>=0) {%> 
		<%= vote.getVoteFinalDate() %>(진행중)
		<%}else{ %>
		<%= vote.getVoteFinalDate() %>(마감됨)
		<%} %></td>
		<td width="80"><%if(vote.getVoteSecret().equals("Y")) {%>
		유기명
		<%}else{ %>
		무기명
		<%} %>
		</td>		
	<tr align="center"><td colspan="5"><%= vote.getVoteContents() %></td></tr>
</table>
<table class="table table-bordered">
<tr align="center"><th width="300">투표목록</th><th>투표결과</th></tr>
<%for(int i=0; i<5; i++) {
		if(voteName[i]==null)
			break;
%><tr align="center"><td> 
	<%=i+1%> : <%=voteName[i] %></td><td><%=voteResultName[i]%></td></tr>
<%} %>
<tr align="center"><td colspan="2">
<%if( employee.getEmpNo().equals("admin")) {%>
<button onclick="vupdate();">수정</button>&nbsp;&nbsp;&nbsp;
<button onclick="vdelete();">삭제</button>&nbsp;&nbsp;&nbsp;
<button onclick="vcheck();">투표인원확인</button>&nbsp;&nbsp;&nbsp;
<%} %>
<button onclick="vList();">목록</button>
</td></tr>

</table>

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
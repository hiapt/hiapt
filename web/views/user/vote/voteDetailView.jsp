<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="aptuser.model.vo.Aptuser,vote.model.vo.Vote,java.util.*,java.text.*
,vote.model.vo.VoteResult"%>
<%
	Vote vote = (Vote) request.getAttribute("vote");
	String vote1 = vote.getVoteOne();
	String vote2 = vote.getVoteTwo();
	String vote3 = vote.getVoteThree();
	String vote4 = vote.getVoteFour();
	String vote5 = vote.getVoteFive();
	String voteName[] = {vote1, vote2, vote3, vote4, vote5};

	VoteResult voteResult = (VoteResult) request.getAttribute("voteresult");
	int voteResultName[] = {voteResult.getVoteOneResult(), voteResult.getVoteTwoResult(),
			voteResult.getVoteThreeResult(), voteResult.getVoteFourResult(), voteResult.getVoteFiveResult()};
%>
<%
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
	Date today = simpleDate.parse(sysdate);
%>

<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html"%>
<!-- head 끝  -->
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
					<li>주민투표</li>
				</ul>
				<h2>주민투표 조회</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<!-- 본문 타이틀 복사 끝 ======================================================================================================-->

	<script type="text/javascript"
		src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var userId ="<%=aptuser.getUserId()%>";
			var vSecret ="<%= vote.getVoteSecret() %>";
			var count = 0;
	<%for (int i = 0; i < voteName.length; i++) {
				if (voteName[i] != null) {%>
		count++;
	<%}}%>
		$("#vbutton").click(function() {
				var voteCheck = $(":input[name=voteresult]:checked").val();
				if (voteCheck != null) {
					$.ajax({
						url : "vo.vrUpdate",
						data : {
							voteresult : voteCheck,
							vsecret : vSecret, 
							voteno :<%=vote.getVoteNo()%>,
							userid : userId
						},
						type : "post",
						dataType : "json",
						success : function(data) {
							var v1 = data.vre1;
							var v2 = data.vre2;
							var v3 = data.vre3;
							var v4 = data.vre4;
							var v5 = data.vre5;
							var vrcount = [ v1, v2, v3, v4, v5 ];
							var dcheck = data.dcheck;
							if (dcheck == 1)
								alert("이미 투표하셨습니다");
							else
								alert("투표가 완료되었습니다");

							for (var i = 0; i < count; i++) {
								$("#" + i + "").text(vrcount[i]);

							}

						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log("error : " + textStatus);
						}
					});//아이작스
				} else {
					alert("투표 체크를 하십시오.")
				}
				return false;
			});//클릭
		});//펑션
	</script>

	<section class="section1">
		<div class="container clearfix">

			<table class="table table-bordered">
				<tr>
					<th style="text-align: center" width="300">제목</th>
					<td style="text-align: center"><%=vote.getVoteTitle()%></td>
				</tr>
				<tr>
					<th style="text-align: center">작성자</th>
					<td style="text-align: center"><%=vote.getVoteWrite()%></td>
				</tr>
				<tr>
					<th style="text-align: center">작성 날짜</th>
					<td style="text-align: center"><%=vote.getVoteDate()%></td>
				</tr>
				<tr>
					<th style="text-align: center">조회수</th>
					<td style="text-align: center"><%=vote.getVoteReadCount()%></td>
				</tr>
				<tr>
					<th style="text-align: center">내용</th>
					<td style="text-align: center"><%=vote.getVoteContents()%></td>
				</tr>
			</table>

			<%
				if (vote.getVoteFinalDate().compareTo(today) >= 0) {
			%><!-- 투표진행중 -->
			<table class="table table-bordered">
				<tr>
					<th style="text-align: center" width="300">투표 목록</th>
					<th style="text-align: center">투표결과(확인)</th>
				</tr>
				<%
					for (int i = 0; i < 5; i++) {
							if (voteName[i] == null)
								break;
				%><tr>
					<th style="text-align: center"><input type="radio"
						name="voteresult" value="<%=i + 1%>" required>&nbsp;&nbsp;&nbsp;&nbsp;
						<%=i + 1%> : <%=voteName[i]%></th>
					<td id="<%=i%>" style="text-align: center"></td>
				</tr>
				<%
					}
				%>
				</table>
					<div align="center">
						<button id="vbutton">확인</button>&nbsp;&nbsp;&nbsp;&nbsp;
						<button onclick="javascript:window.history.go(-1);">목록</button>
					</div>
				<%
					} else {
				%><!-- 투표마감시보여질 화면 -->
				<h3 align="center">투표가 마감되었습니다.</h3>
				<table class="table table-bordered">
				<tr >
					<th style="text-align: center" width="300">투표 목록</th>
					<th style="text-align: center">투표 결과</th>
				</tr>
				<%
					for (int i = 0; i < 5; i++) {
							if (voteName[i] == null)
								break;
				%><tr align="center">
					<td><%=i + 1%> : <%=voteName[i]%></td>
					<td><%=voteResultName[i]%></td>
				</tr>
				<%}	}%>
				</table>
				<div align="right">
				<button onclick="javascript:window.history.go(-1);">목록</button>
				</div>
		</div>
	</section>

	<!--  /// 본문 끝//////  -->
	<!-- footer 시작 -->
	<%@ include file="../userfooter.jsp"%>
	<!-- footer 끝  -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="vote.model.vo.Vote,vote.model.vo.VoteResult,java.util.*,java.text.*"%>
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
<html>
<!-- head 시작 -->
<%@ include file="../../common/emphead.html"%>

<!-- head 시작 -->

<script type="text/javascript"
	src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">


</script>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- 왼쪽 메인 메뉴바 시작 -->

		<%@ include file="../../common/empnavi.jsp"%>

		<!-- 왼쪽 메인 메뉴바 끝  -->

		<!--- 중앙 전체 큰 틀 ---------------------------------------------->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">

				<!-- ================================================================================= -->
				<!---탑메뉴  시작 =================---------------------------->

				<%@ include file="../../common/empTopNavi.jsp"%>
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

							<form action="/hiapt/vo.ad.update" method="post">
							<input type="hidden" name="vrvoteno" value="<%= vote.getVoteNo() %>">
								<table class="table table-bordered">
									<tr align="center">
										<th width="300">제목</th>
										<td>
										<input type="text" name= "vrtitle" value="<%=vote.getVoteTitle()%>" required>
										</td>
									</tr>
									<tr align="center">
										<th>작성자</th>
										<td><%=vote.getVoteWrite()%></td>
									</tr>
									<tr align="center">
										<th>작성날짜</th>
										<td><%=vote.getVoteDate()%></td>
									</tr>
									<tr align="center">
										<th>투표마감날짜</th>
										<td>
										<input type="date" name= "vrfdate" value="<%=vote.getVoteFinalDate()%>" required>
										</td>
									</tr>
									<tr align="center">
										<th>유기명여부(Y/N)</th>
										<td><%=vote.getVoteSecret()%></td>
									</tr>
									<tr align="center">
										<th>조회수</th>
										<td><%=vote.getVoteReadCount()%></td>
									</tr>
									<tr align="center">
										<th>투표내용</th>
										<td>
										<textarea rows="10" cols="50" name="vrcontent"required>
										<%=vote.getVoteContents()%>
										</textarea>
										</td>
									</tr>
								</table>
								<table class="table table-bordered">
									<tr align="center">
										<th width="300">투표목록</th>
										<th>투표결과</th>
									</tr>
									<%
										for (int i = 0; i < 5; i++) {
											if (voteName[i] == null)
												break;
									%><tr align="center">
										<td><%=i + 1%>번 : <%=voteName[i]%></td>
										<td><%=voteResultName[i]%></td>
									</tr>
									<%
										}
									%>
									<tr align="center">
										<td colspan="2">
											<input type="submit" value="수정완료" onclick="alert('수정이 완료되었습니다.')";>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											</from>
											<button onclick="history.go(-1);" return false;>이전페이지로</button>
										</td>
									</tr>

								</table>

								<!-- 테이블틀끝 -->
						</div>
					</div>
					<!---//// 본문 내용 끝 ///////------------------->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<!---//// 본문 내용 끝 ///////------------------->
			<!-- footer 시작 -->
			<%@ include file="../../common/empfooter.html"%>
			<!-- footer 시작 -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<!--========================================================================================== -->
	<!-- top 버튼 -->
	<%@ include file="../../common/topbutton.html"%>
	<!--========================================================================================== -->


</body>
</html>
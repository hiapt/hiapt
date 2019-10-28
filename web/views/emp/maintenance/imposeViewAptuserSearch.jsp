<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="maintenance.model.vo.ImposeViewAptuser, java.util.ArrayList"%>
<%
	ArrayList<ImposeViewAptuser> alist = (ArrayList<ImposeViewAptuser>) request.getAttribute("alist");
	int currentPage = (Integer) request.getAttribute("currentPage");
	int beginPage = (Integer) request.getAttribute("beginPage");
	int endPage = (Integer) request.getAttribute("endPage");
	int maxPage = (Integer) request.getAttribute("maxPage");
	String userId = (String) request.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HIAPTProject</title>

<!-- Custom fonts for this template-->
<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/hiapt/resources/css/basic.css" rel="stylesheet">

<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->


</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- 왼쪽 메인 메뉴바 시작 -->

		<!-- 왼쪽 메인 메뉴바 끝  -->
		<!-- ================================================================================= -->

		<!--- 중앙 전체 큰 틀 ---------------------------------------------->
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">

				<!-- ================================================================================= -->
				<!---탑메뉴  시작 =================---------------------------->


				<!---탑 메뉴 끝 ------------------------------------------->
				<!--========================================================================================== -->
				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- 본문 타이틀 들어가는 부분 ---->
					<h1 class="h3 mb-4 text-gray-800">세대주 정보</h1>
					<h6>
						전체 목록 :<%=alist.size()%>개
					</h6>
					<!--///////본문 내용 시작 ///////-------->
					<div class="card shadow mb-4">
						<div class="card-body">

							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" onclick="window.close()">
								<span aria-hidden="true">&times;</span>
							</button>
							<!-- 동/호 검색 -->
							<form action="/hiapt/imvas" method="post" class="form-inline">
								<input type="hidden" name="search" value="userid" /> <label>동/호&nbsp;
									<input type="text" name="userid"
									class="form-control form-control-sm">
								</label>&nbsp; <input type="submit" value="검색" onclick="sendIt()"
									class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							</form>


							<br>
							<form name="form">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th scope="col">동/호</th>
											<th scope="col">이름</th>
											<th scope="col">전화번호</th>
											<th scope="col">적용</th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < alist.size(); i++) {
												ImposeViewAptuser a = alist.get(i);
										%>
										<tr>
											<td><p id="parentId1"><%=a.getUserId()%></p></td>
											<td><p id="parentId2"><%=a.getUserName()%></p></td>
											<td><%=a.getUserPhone()%></td>
											<td>
												<button type="button" value="전달하기"
													onclick="sendChildValue()"
													class="btn btn-link popover-test checkBtn">적용</button>
											</td>

											<%
												}
											%>
										</tr>
									</tbody>
								</table>
							</form>
							<script type="text/javascript">
							/* function sendChildValue(){
								window.opener.document.getElementById("parentId1").value = "";
								window.opener.document.getElementById("parentId2").value = "";
								window.self.close();
							}	 */		
							
										$(".checkBtn").click(function(){
											var str="";
											var tdArr = new Array(); // 배열선언
											var checkBtn = $(this);
											
											// 현재 클릭된 row(<tr>)
											var tr = checkBtn.parent().parent();
											var td = tr.children();
											
											console.log("클릭한 row의 모든 데이터 : " + tr.text());
											
											var userid = td.eq(0).text();
											var username = td.eq(1).text();
											
											console.log("클릭한 row의 1번 데이터 : " + userid);
											console.log("클릭한 row의 2번 데이터 : " + username);
											
											// 반복문을 통해서 배열에 값을 담아 사용할 수 잇다.
											td.each(function(i){
												tdArr.push(td.eq(i).text());
											});
											
											console.log("배열에 담긴 값 : " + tdArr);
											
											window.opener.document.getElementById("parentId1").value = userid;
											window.opener.document.getElementById("parentId2").value = username;
											
											window.self.close();
											
										});
										
										
										
										
										
											<%-- function sendChildValue(userId){
											window.opener.document.getElementById("parentId1").value = "<%=a.getUserId()%>";
											window.opener.document.getElementById("parentId2").value = "<%=a.getUserName()%>";
											window.self.close();
											}  --%>
											
										</script>
							<!-- pageing -->

							<div class="col-sm-12">
								<div class="paging_simple_numbers">
									<%
										if (userId != null) {
									%>
									<ul class="pagination" style="justify-content: center;">
										<li class="paginate_button page-item previous"
											id="dataTable_previous"><a href="/hiapt/imvas?page=1"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">&lsaquo;</a></li>
										<%
											if ((beginPage - 10) < 1) {
										%>
										<li class="paginate_button page-item previous back"
											id="dataTable_previous"><a href="/hiapt/imvas?page=1"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">&lsaquo;&lsaquo;</a></li>
										<%
											} else {
										%>
										<li class="paginate_button page-item active back"
											id="dataTable_previous"><a
											href="/hiapt/imvas?page=<%=beginPage - 10%>"
											aria-controls="dataTable" data-dt-idx="<%=beginPage - 10%>"
											tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
										<%
											}
										%>
										<%
											if ((beginPage - 10) <= 9) {
										%>
										<li class="paginate_button page-item active"
											id="dataTable_previous"><a href="/hiapt/imvas?page=1"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">1</a></li>
										<%
											} else {
										%>
										<%
											for (int p = beginPage; p <= endPage; p++) {
														if (p == currentPage) {
										%>
										<li class="paginate_button page-item active next"><a
											href="/hiapt/imvas?page<%=p%>" aria-controls="dataTable"
											data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
										<%
											} else {
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page=<%=p%>" aria-controls="dataTable"
											data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
										<%
											}
													}
										%>
										<%
											}
										%>
										<%
											if ((endPage + 10) > maxPage) {
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page=<%=maxPage%>"
											aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
											tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
										<%
											} else {
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page<%=endPage + 10%>"
											aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
											tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
										<%
											}
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page=<%=maxPage%>"
											aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
											tabindex="0" class="page-link">&rsaquo;</a></li>
									</ul>
									<%
										} else {
									%>

									<ul class="pagination" style="justify-content: center;">
										<li class="paginate_button page-item previous"
											id="dataTable_previous"><a href="/hiapt/imvas?page=1"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">&lsaquo;</a></li>
										<%
											if ((beginPage - 10) < 1) {
										%>
										<li class="paginate_button page-item previous back"
											id="dataTable_previous"><a href="/hiapt/imvas?page=1"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">&lsaquo;&lsaquo;</a></li>
										<%
											} else {
										%>
										<li class="paginate_button page-item active back"
											id="dataTable_previous"><a
											href="/hiapt/imvas?page=<%=beginPage - 10%>"
											aria-controls="dataTable" data-dt-idx="<%=beginPage - 10%>"
											tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
										<%
											}
										%>
										<%
											if ((beginPage - 10) <= 9) {
										%>
										<li class="paginate_button page-item active"
											id="dataTable_previous"><a href="/hiapt/imvas?page=1"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">1</a></li>
										<%
											} else {
										%>

										<%
											for (int p = beginPage; p <= endPage; p++) {
														if (p == currentPage) {
										%>
										<li class="paginate_button page-item active next"><a
											href="/hiapt/imvas?page<%=p%>" aria-controls="dataTable"
											data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
										<%
											} else {
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page=<%=p%>" aria-controls="dataTable"
											data-dt-idx="<%=p%>" tabindex="0" class="page-link"><%=p%></a></li>
										<%
											}
													}
										%>
										<%
											}
										%>
										<%
											if ((endPage + 10) > maxPage) {
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page=<%=maxPage%>"
											aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
											tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
										<%
											} else {
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page<%=endPage + 10%>"
											aria-controls="dataTable" data-dt-idx="<%=endPage + 10%>"
											tabindex="0" class="page-link">&rsaquo;&rsaquo;</a></li>
										<%
											}
										%>
										<li class="paginate_button page-item next" id="dataTable_next"><a
											href="/hiapt/imvas?page=<%=maxPage%>"
											aria-controls="dataTable" data-dt-idx="<%=maxPage%>"
											tabindex="0" class="page-link">&rsaquo;</a></li>
									</ul>
									<%
										}
									%>
								</div>
							</div>


							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									onclick="window.close()">Close</button>
							</div>

						</div>
					</div>
					<!---//// 본문 내용 끝 ///////------------------->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<!---//// 본문 내용 끝 ///////------------------->
			<!-- footer 시작 -->

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
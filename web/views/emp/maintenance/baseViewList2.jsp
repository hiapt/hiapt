<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="maintenance.model.vo.BaseView, java.util.ArrayList"%>
<%
	ArrayList<BaseView> list = (ArrayList<BaseView>) request.getAttribute("list");
	//BaseView bview = (BaseView)request.getAttribute("bview");
	int currentPage = (Integer) request.getAttribute("currentPage");
	int beginPage = (Integer) request.getAttribute("beginPage");
	int endPage = (Integer) request.getAttribute("endPage");
	int maxPage = (Integer) request.getAttribute("maxPage");
	String months = (String)request.getAttribute("months");
%>

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>HIAPTProject</title>

	<!-- Custom fonts for this template-->
	<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
	<!-- Custom styles for this template-->
	<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="/hiapt/resources/css/basic.css" rel="stylesheet">	
	
	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->
<script type="text/javascript">
 function callFunction(){
	 window.location.href ="/hiapt/views/emp/maintenance/imposeViewInsertForm.jsp";
	 return false; // 다른 이벤트 전달 막기
 }
 function callFunction4(){
	 window.location.href ="/hiapt/views/emp/maintenance/baseViewInsertForm.jsp";
	 return false; // 다른 이벤트 전달 막기
 } 
 // 체크박스 전체선택
 function checkAll(){
       if( $("#th_checkAll").is(':checked') ){
        $("input[name=checkRow]").prop("checked", true);
        }else{
         $("input[name=checkRow]").prop("checked", false);
       }
 } 
  
 // 
 function test_checkbox(){
	 var flag = false;
	 // 체크박스 접근 후 체크된 갯수 확인
	 var values = document.getElementsByName("checkRow");
	 console.log(values.length);
	 var count = 0;
	 var r= null;
	 for(var i = 0; i<values.length; i++){
		 if(values[i].checked) {
			 count++;
			 r = values[i].value;
			 console.log(", " + r + ", " + typeof(r));
		 }
	 }
	 if(count < 1 ){
		 alert("1개 이상 선택해야 합니다.");
	 } else if(confirm("정말 삭제하시겠습니까?") == true) {		
		 flag = true;
	 } else{
		 return flag;
	 }
	 return flag;	
 }
 
 // 추가버튼
 $(document).on("click", "button[name=addRow]", function(){
	 var addRowText = '<tr name="trImpose">' +
	 '<td><button class="btn btn-sm btn-outline-danger shadow-sm" name="delImose">삭제</button></td>' +
	' <td><input type="text" class="form-control"></td> ' +
	'<td>고지서번호<span class="text-danger">*</span><br>자동발부</td>' +
	'<td class="col-xs-2"><input type="date" class="form-control"></td>' +
	'<td class="col-xs-2"><input type="date" class="form-control"></td>' +
	'<td><input type="date" class="form-control"></td>' +
	'<td><input type="date" class="form-control"></td>' +
	'<td><input type="date" class="form-control"></td>' +
	'<td><input type="date" class="form-control"></td>' +
	'<td><input type="date" class="form-control"></td>' +
	'</tr>';
	
	var trHtml = $("tr[name=trImpose]:first"); // last를 사용하여 trImpose 라는 명을 가진 마지막 태그 호출
	trHtml.before(addRowText); //마지막에 trImpose명 뒤에 붙인다.
 }); 
 
 // 행삭제
 $(document).on("click", "button[name=delImpose]", function(){
	var trHtml = $(this).parent().parent();
	trHtml.remove(); // tr태그 삭제
 });
 
</script>


</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- 왼쪽 메인 메뉴바 시작 -->

		<%@ include file="../../common/empnavi.jsp"%>

		<!-- 왼쪽 메인 메뉴바 끝  -->
		<!-- ================================================================================= -->

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

					<!-- 본문 타이틀 들어가는 부분 ---->
					<h1 class="h3 mb-4 text-gray-800">부과기초작업</h1>
					<%-- <h6>
						전체 목록 :<%= list.size() %>개
					</h6> --%>
					
					<!--///////본문 내용 시작 ///////-------->
					<div class="card shadow mb-4">
						<div class="card-body">
              
							<!-- 부과년월 검색 -->
							<form action="/hiapt/bvis" method="post" class="form-inline">
								<input type="hidden" name="search" value="months"/> <label>부과년월&nbsp;
									<input type="month" name="months"
									class="form-control form-control-sm">
								</label> 
								<input type="submit" value="검색" onclick="sendIt()"
									class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
							</form>
							
						
							<div class="card-title" style="float:right;">
							<button onclick="callFunction();" class="btn btn-sm btn-warning shadow-sm" >관리비등록</button>&nbsp;
							<button onclick="callFunction2();" class="btn btn-sm btn-success shadow-sm" >엑셀자료올리기</button>&nbsp;
							<button onclick="callFunction3();" class="btn btn-sm btn-info shadow-sm" >전날금액가져오기</button>&nbsp;
							<button onclick="callFunction4();" class="btn btn-sm btn-info shadow-sm" >부과기초작업등록</button>&nbsp;
							<br></div>
							<br><br>
							<button name="addRow" class="btn btn-sm btn-outline-primary shadow-sm">행추가</button>
							<form method="post" action="/hiapt/bvidel" name="form" onsubmit="return test_checkbox();">
							<div class="card-title" style="float:right;">
							
							<input class="btn btn-sm btn-outline-primary shadow-sm" type="submit" value="삭제"> 
							<button type="sumbit" value="이동" onclick="javascript: form.action='/hiapt/bviup'" 
							class="btn btn-sm btn-outline-danger shadow-sm">수정</button>
							</div> 
							<br>
							<br>
							
							<div class="table-responsive">
                			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

								<thead>
									<tr>
										<!-- <th rowspan="2">삭제
										</th> -->
										<th>삭제</th>		 							
										<th rowspan="2">상태</th>
										<th rowspan="2">고지서번호</th>
										<th rowspan="2">부과년월</th>
										<th colspan="2">산출기간</th>
										<th rowspan="2">납부마감일</th>
										<th rowspan="2">부과마감일</th>
										<th rowspan="2">마감횟수</th>
										<th rowspan="2">출력의뢰일시</th>
									</tr>
									<tr>
										<th>
										<label class="check"> 
								<input type="checkbox" class="custom-control-input"
  								id="th_checkAll" onclick="checkAll();">
								<span class="checkmark center-block" ></span> 
										</th>
										<th>시작일</th>
										<th>종료일</th>

									</tr>
								</thead>
								<tbody>									
									<%
										for (BaseView ba : list) {
									%>
									<tr name="trImpose">
										<td>
										<div class="checkBox">
										<label class="check"> 
										<input type="checkbox" class="custom-control-input" name="checkRow" value="<%=ba.getMerchantUid() %>" 
  											id="customCheck">
										<span class="checkmark" ></span>
										</label>
										</div>
										</td>
										<td><%=ba.getImposeStatus()%></td>
										<td><%=ba.getMerchantUid() %></td>
										<td><%=ba.getBillYearMonth()%></td>
										<td><%=ba.getCalculateStartDay()%></td>
										<td><%=ba.getCalculateEndDay()%></td>
										<td><%=ba.getCutoffDate()%></td>
										<td><%=ba.getImposeEndDate()%></td>
										<td><%=ba.getImposeCount()%></td>
										<td><%=ba.getCutoffDate()%></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							</div>
							</form> 
							
							
							
	<!-- pageing -->

		  <div class="col-sm-12">
			<div class="paging_simple_numbers">
			<% if( months != null){ %>
				<ul class="pagination" style="justify-content: center;">
					<li class="paginate_button page-item previous"
						id="dataTable_previous"><a href="/hiapt/bvis?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
					<% if((beginPage - 10) < 1){ %>
					<li class="paginate_button page-item previous back"
						id="dataTable_previous"><a href="/hiapt/bvis?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } else { %>
					<li class="paginate_button page-item active back"
						id="dataTable_previous"><a href="/hiapt/bvis?page=<%= beginPage -10 %>" aria-controls="dataTable"
						data-dt-idx="<%= beginPage - 10 %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } %>		
					<% if( (beginPage -10) <= 9){ %>
               		<li class="paginate_button page-item active"
                  		id="dataTable_previous"><a href="/hiapt/bvis?page=1" aria-controls="dataTable"
                 	 	data-dt-idx="0" tabindex="0" class="page-link">1</a></li>
              	 	<% }else{ %>			
					<% for(int p = beginPage; p <= endPage; p++){
						if(p == currentPage){	
					%>					
					<li class="paginate_button page-item active next"><a href="/hiapt/bvis?page<%= p %>"
						aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% } else { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page=<%= p %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% }} %>
					 <% } %> 
					<% if((endPage + 10) > maxPage ) { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } else { %>	
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page<%= endPage + 10 %>" aria-controls="dataTable" data-dt-idx="<%= endPage + 10 %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;</a></li>
				</ul>				
					<% } else { %>
				
				<ul class="pagination" style="justify-content: center;">
					<li class="paginate_button page-item previous"
						id="dataTable_previous"><a href="/hiapt/bvis?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
					<% if((beginPage - 10) < 1){ %>
					<li class="paginate_button page-item previous back"
						id="dataTable_previous"><a href="/hiapt/bvis?page=1" aria-controls="dataTable"
						data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } else { %>
					<li class="paginate_button page-item active back"
						id="dataTable_previous"><a href="/hiapt/bvis?page=<%= beginPage -10 %>" aria-controls="dataTable"
						data-dt-idx="<%= beginPage - 10 %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
					<% } %>
					 <%-- <% if(currentPage == 1){ %>
               		<li class="paginate_button page-item active"
                  		id="dataTable_previous"><a href="/hiapt/bvis?page=1" aria-controls="dataTable"
                  		data-dt-idx="0" tabindex="0" class="page-link">1</a></li>
               		<% }else{ %> --%>
					
					<% for(int p = beginPage; p <= endPage; p++){
						if(p == currentPage){	
					%>
					<li class="paginate_button page-item active next"><a href="/hiapt/bvis?page<%= p %>"
						aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% } else { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page=<%= p %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
						class="page-link"><%= p %></a></li>
					<% }} %>
					<%-- <% } %> --%>
					<% if((endPage + 10) > maxPage ) { %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } else { %>	
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page<%= endPage + 10 %>" aria-controls="dataTable" data-dt-idx="<%= endPage + 10 %>" tabindex="0"
						class="page-link">&rsaquo;&rsaquo;</a></li>
					<% } %>
					<li class="paginate_button page-item next" id="dataTable_next"><a
						href="/hiapt/bvis?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
						class="page-link">&rsaquo;</a></li>
				</ul>
				 <% } %>
			</div>
		</div> 
		<div class="card-title" style="float:right;">						          
		<a href="/hiapt/index.jsp" class="btn btn-sm btn-secondary shadow-sm">HOME</a></div>


<%-- <div id="pagebox" align="center">
	<a href="/hiapt/bvis?page=1">|◁</a> &nbsp;
		<% if ((beginPage - 10) < 1) { %>
	<a href="/hiapt/bvis?page=1">◀◀</a>
		<%	} else { %>
	<a href="/hiapt/bvis?page=<%=beginPage - 10%>">◀◀</a>
		<%	} %>&nbsp;
		<% for (int p = beginPage; p <= endPage; p++) {
			if (p == currentPage) { %>
	<a href="/hiapt/bvis?page=<%=p%>"><font color="red"><b>[<%=p%>]</b></font></a>
		<%	} else { %>
	<a href="/hiapt/bvis?page=<%=p%>"><%=p%></a>
	 	<%	}	} %>&nbsp;
		<% if ((endPage + 10) > maxPage) {%>
	<a href="/hiapt/bvis?page=<%=maxPage%>">▶▶</a>
		<%	} else {	%>
	<a href="/hiapt/bvis?page=<%=endPage + 10%>">▶▶</a>
		<%	}	%>&nbsp; 
	<a href="/hiapt/bvis?page=<%=maxPage%>">▷|</a>
</div>


<div id="pagebox" align="center">
	<a href="/hiapt/bvilis?page=1">|◁</a> &nbsp;
	<%	if ((beginPage - 10) < 1) {	%>
	<a href="/hiapt/bvilis?page=1">◀◀</a>
	<%	} else { %>
	<a href="/hiapt/bvilis?page=<%=beginPage - 10%>">◀◀</a>
	<%	}	%> &nbsp;
	<% for (int p = beginPage; p <= endPage; p++) {
	if (p == currentPage) { %>
	<a href="/hiapt/bvilis?page=<%=p%>"><font color="red"><b>[<%=p%>]</b></font></a>
	<%	} else { %>
	<a href="/hiapt/bvilis?page=<%=p%>"><%=p%></a>
	<% } }	%>&nbsp;
	<%	if ((endPage + 10) > maxPage) {	%>
	<a href="/hiapt/bvilis?page=<%=maxPage%>">▶▶</a>
	<%	} else { %>
	<a href="/hiapt/bvilis?page=<%=endPage + 10%>">▶▶</a>
	<%	} %>&nbsp; 
	<a href="/hiapt/bvilis?page=<%=maxPage%>">▷|</a>
</div>
		 
					
<div id="pagebox" align="center">
    <ul class="pagination modal-1">
      <li><a href="/hiapt/bwlist?page=1" class="prev">&lt;</a> </li>
      <% if ((beginPage - 10) < 1) { %>
      <li><a href="/hiapt/bwlist?page=1" class="prev">&laquo</a></li>
      <% } else { %>      
      <li><a href="/hiapt/bwlist?page=<%=beginPage - 10%>" class="prev">&laquo</a></li>
      <% }  %>
      <% for (int p = beginPage; p <= endPage; p++) {
         if (p == currentPage) {
      %>
      <li> <a href="/hiapt/bwlist?page=<%=p%>" class="active"><%=p%></a></li>
      <% } else { %>
      <li> <a href="/hiapt/bwlist?page=<%=p%>"><%=p%></a></li>
      <% } } %>
      <% if ((endPage + 10) > maxPage) { %>
      <li><a href="/hiapt/bwlist?page=<%=maxPage%>" class="next">&raquo;</a></li>
      <% } else { %>
      <li><a href="/hiapt/bwlist?page=<%=endPage + 10%>" class="next">&raquo;</a></li>
      <% }  %>
      <li><a href="/hiapt/bwlist?page=<%=maxPage%>" class="next">&gt;</a></li>
    </ul>
  </div>		 
  <% } %>	
   --%>
							
							
							
						
					
					
					
					
	
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


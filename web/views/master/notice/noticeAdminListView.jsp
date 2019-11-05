<!--/// jsp 코드 ///-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee, java.util.ArrayList, notice.model.vo.Notice"%>

<%
	Employee loginEmployee = (Employee) session.getAttribute("employee");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int pageSize = ((Integer)request.getAttribute("pageSize")).intValue();
	String titleName = (String)request.getAttribute("titlename");
	ArrayList<Notice>nlist = (ArrayList<Notice>)request.getAttribute("nlist");
	int count = ((Integer)request.getAttribute("listCount")).intValue();
	
%>

<!--복사 시작 ////////////////////////////--------------------->

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->
<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function noWrite(){
	window.location.href="/hiapt/views/master/notice/noticeAdminWriteForm.jsp";
	return false;
}
$(function(){
	$("#submitbtn").on("click",function(){
		$("#searchform").submit();
		return false;
	})
})


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

<h1 align="center">공지사항</h1>
<br>
<div class="card shadow mb-4">
<div class="card-body">
	<div align="right">
	<form action="/hiapt/no.list" method="post" id="searchform">
			
			<div class="input-group col-sm-3" style="margin-left: 5px;">
				<input type="text" id="search" name="titlename" class="form-control form-control-sm" placeholder="검색할 제목을 입력하세요.">
				
				<div class="input-group-append">
					<button class="btn btn-primary btn-sm" type="button" id="submitbtn">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
	</form>
	
	</div>
	<%if( loginEmployee.getEmpNo().equals("admin")) {%>
		<button class="btn btn-primary btn-sm"  onclick="noWrite();" style="margin-top:-56px">작성하기</button>&nbsp;
	<%} %>
	
	
	<div align="left">
	<h5>
		공지사항 
		<%=count%>개
	</h5>
	</div>

	<table class="table table-bordered" >
		<tr align="center">
			<th width = "80">글번호</th>
			<th>제목</th>
			<th width = "150" >첨부파일</th>
			<th width = "150" >작성일</th>
			<th width = "200" >작성자</th>
			<th width = "80" >조회수</th>
		</tr>
		<% for(Notice n : nlist){ %>
		<tr align="center">
			<td><%= n.getNoticeNo() %></td>			
			<td><a href="/hiapt/no.view?uporview=admin&nno=<%= n.getNoticeNo() %>&page=<%=currentPage%>">
			<%= n.getNoticeTitle() %></a></td>			
			<!--첨부파일 유무 -->
			<td>
			<%
			if(n.getFileYorN().equals("Y")){
			%>
			<i class="fa fa-paperclip"></i>
			<%}else{ %>
			<%} %>
			</td>
			<td><%= n.getNoticeDate() %></td> 
			<td><%= n.getNoticeWriter()%></td>
			
			<td><%= n.getNoticeReadCount() %></td>
		</tr>
		<%} %>
	</table>
      <div class="col-sm-12">
         <div class="paging_simple_numbers">
 
         <%if(titleName != null) {%>
            <ul class="pagination" style="justify-content: center;">
               <li class="paginate_button page-item previous" id="dataTable_previous">
                  <a href="/hiapt/no.list?page=1&titlename=<%=titleName %>" aria-controls="dataTable"
                  data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
               <% if((beginPage - pageSize) <= 1){ %>
               <li class="paginate_button page-item previous back" id="dataTable_previous">
                  <a href="/hiapt/no.list?page=1&titlename=<%=titleName %>" aria-controls="dataTable"
                  data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
               <% } else { %>
               <li class="paginate_button page-item active back"
                  id="dataTable_previous"><a href="/hiapt/no.list?page=<%= beginPage -pageSize %>&titlename=<%=titleName %>" aria-controls="dataTable"
                  data-dt-idx="<%= beginPage - pageSize %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
               <% } %>
                     
                     
                            
               <% for(int p = beginPage; p <= endPage; p++){
                  if(p == currentPage){   
               %>               
               <li class="paginate_button page-item active next">
               <a href="/hiapt/no.list?page=<%= p %>&titlename=<%=titleName %>"
                  aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
                  class="page-link"><%= p %></a></li>
               <% } else { %>
               <li class="paginate_button page-item next" id="dataTable_next">
               <a href="/hiapt/no.list?page=<%= p %>&titlename=<%=titleName %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
                  class="page-link"><%= p %></a></li>
               <% } %>
               
               
              
                <% } %> 
               <% if((endPage + pageSize) > maxPage ) { %>
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= maxPage %>&titlename=<%=titleName %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
                  class="page-link">&rsaquo;&rsaquo;</a></li>
               <% } else { %>   
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= beginPage + pageSize %>&titlename=<%=titleName %>" aria-controls="dataTable" data-dt-idx="<%= endPage + pageSize %>" tabindex="0"
                  class="page-link">&rsaquo;&rsaquo;</a></li>
               <% } %>
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= maxPage %>&titlename=<%=titleName %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
                  class="page-link">&rsaquo;</a></li>
            </ul>            
              
              
              
              
              
               <% } else { %>
              
               
               
               
               
            
            <ul class="pagination" style="justify-content: center;">
               <li class="paginate_button page-item previous"
                  id="dataTable_previous"><a href="/hiapt/no.list?page=1" aria-controls="dataTable"
                  data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
               <% if((beginPage - pageSize) < 1){ %>
               <li class="paginate_button page-item previous back"
                  id="dataTable_previous"><a href="/hiapt/no.list?page=1" aria-controls="dataTable"
                  data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
               <% } else { %>
               <li class="paginate_button page-item active back"
                  id="dataTable_previous"><a href="/hiapt/no.list?page=<%= beginPage -pageSize %>" aria-controls="dataTable"
                  data-dt-idx="<%= beginPage - pageSize %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
               <% } %>
               
               
               
               
               <% for(int p = beginPage; p <= endPage; p++){
                  if(p == currentPage){   
               %>
               <li class="paginate_button page-item active next"><a href="/hiapt/no.list?page<%= p %>"
                  aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
                  class="page-link"><%= p %></a></li>
               <% } else { %>
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= p %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
                  class="page-link"><%= p %></a></li>
               <% }} %>
               
               
               
            
               <% if((endPage + pageSize ) > maxPage ) { %>
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
                  class="page-link">&rsaquo;&rsaquo;</a></li>
               <% } else { %>   
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page<%= endPage + pageSize %>" aria-controls="dataTable" data-dt-idx="<%= endPage + pageSize %>" tabindex="0"
                  class="page-link">&rsaquo;&rsaquo;</a></li>
               <% } %>
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= maxPage %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
                  class="page-link">&rsaquo;</a></li>
            </ul>
             <% } %> 
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
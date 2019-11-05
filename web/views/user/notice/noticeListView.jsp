<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="notice.model.vo.Notice, java.util.ArrayList"%>				
<%
	ArrayList<Notice>nlist = (ArrayList<Notice>)request.getAttribute("nlist");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int pageSize = ((Integer)request.getAttribute("pageSize")).intValue();
	String titleName = (String)request.getAttribute("titlename");
	int count = ((Integer)request.getAttribute("listCount")).intValue();
%>	
		
<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html" %>
<!-- head 끝  -->
<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#submitbtn").on("click",function(){
		$("#searchform").submit();
		return false;
	})
	
})
</script>
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

<section class="section1">
    <div class="container clearfix">
	<div align="right">
	<form action="/hiapt/no.list" method="post" id="searchform">
			
			<div class="input-group col-sm-3" style="display: inline-flex;">
				<input type="text" id="search" name="titlename" class="form-control form-control-sm" placeholder="검색할 제목을 입력하세요.">
				
				<div class="input-group-append">
					<button class="btn btn-primary" type="button" id="submitbtn">
						<i class=" fa fa-search"></i>
					</button>
				</div>
			</div>
	</form>
	
	</div>
	<div align="left">
	<h5>
		공지사항 
		<%=count%>개
	</h5>
	</div>
	
	<table class="table table-bordered">
		<tr align="center">
			<th style="text-align:center; width:80;">글번호</th>
			<th style="text-align:center">제목</th>
			<th style="text-align:center;width:150;" >첨부파일</th>
			<th style="text-align:center;width:150" >작성일</th>
			<th style="text-align:center;width:200" >작성자</th>
			<th style="text-align:center;width:80" >조회수</th>
		</tr>
	
	<% for(Notice n : nlist){ %>
		<tr align="center">
			<td><%= n.getNoticeNo() %></td>
			<td><a href="/hiapt/no.view?uporview=view&nno=<%= n.getNoticeNo() %>&page=<%= currentPage %>"><%= n.getNoticeTitle() %></a></td>			
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
<!-- pageing -->
	<div align="center">
<%if(titleName != null) {%>
            <ul class="pagination" style="justify-content: center;">
               <li class="paginate_button page-item previous"
                  id="dataTable_previous"><a href="/hiapt/no.list?page=1&titlename=<%=titleName %>" aria-controls="dataTable"
                  data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;</a></li>
               <% if((beginPage - pageSize) <= 1){ %>
               <li class="paginate_button page-item previous back"
                  id="dataTable_previous"><a href="/hiapt/no.list?page=1&titlename=<%=titleName %>" aria-controls="dataTable"
                  data-dt-idx="0" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
               <% } else { %>
               <li class="paginate_button page-item active back"
                  id="dataTable_previous"><a href="/hiapt/no.list?page=<%= beginPage -pageSize %>&titlename=<%=titleName %>" aria-controls="dataTable"
                  data-dt-idx="<%= beginPage - pageSize %>" tabindex="0" class="page-link">&lsaquo;&lsaquo;</a></li>
               <% } %>      
            <%--    <% if( (beginPage - pageSize) <= 9){ %>
                     <li class="paginate_button page-item active"
                        id="dataTable_previous"><a href="/hiapt/no.list?page=1" aria-controls="dataTable"
                        data-dt-idx="0" tabindex="0" class="page-link">1</a></li>
               <% }else{ %>   --%>
                     
                     
                     
                     
                            
               <% for(int p = beginPage; p <= endPage; p++){
                  if(p == currentPage){   
               %>               
               <li class="paginate_button page-item active next"><a href="/hiapt/no.list?page<%= p %>&titlename=<%=titleName %>"
                  aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
                  class="page-link"><%= p %></a></li>
               <% } else { %>
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= p %>&titlename=<%=titleName %>" aria-controls="dataTable" data-dt-idx="<%= p %>" tabindex="0"
                  class="page-link"><%= p %></a></li>
               <% } %>
               
               
               
               
               
               
                <% } %> 
               <% if((endPage + pageSize) > maxPage ) { %>
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page=<%= maxPage %>&titlename=<%=titleName %>" aria-controls="dataTable" data-dt-idx="<%= maxPage %>" tabindex="0"
                  class="page-link">&rsaquo;&rsaquo;</a></li>
               <% } else { %>   
               <li class="paginate_button page-item next" id="dataTable_next"><a
                  href="/hiapt/no.list?page<%= endPage + pageSize %>&titlename=<%=titleName %>" aria-controls="dataTable" data-dt-idx="<%= endPage + pageSize %>" tabindex="0"
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
</section>


<!--  /// 본문 끝//////  -->
<!-- footer 시작 -->
 <%@ include file="../userfooter.jsp" %>
<!-- footer 끝  -->
 </body>
</html>
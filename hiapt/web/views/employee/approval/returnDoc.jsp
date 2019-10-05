<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.Draft, java.util.ArrayList"%>
    
 <%
 	ArrayList<Draft> list = (ArrayList<Draft>)request.getAttribute("list");
 	
 %>
<!-- 타이틀 시작 -->
<div class="row">
	<div id="breadcrumb" class="col-xs-12">
		<!-- 삼디다스 버튼 -->
		<a href="#" class="show-sidebar"> <i class="fa fa-bars"></i>
		</a>
		<ol class="breadcrumb pull-left">
			<!-- 첫번째 타이틀 시작 -->
			<li><a href="index.html">전자결재</a></li>
			<!-- 두번째 하위 메뉴 시작 -->
			<li><a href="#">전체목록</a></li>
			<!-- 세번째 하위 메뉴 시작 -->
			<!--li><a href="#">부과항목등록</a></li-->
		</ol>
	</div>
</div>
<!-- 타이틀 끝 -->
<form action="" method="post">
<h4>반려 문서 : <%= list.size() %>개 </h4>
<table class="table beauty-table table-hover" style="text-align: center;">
					<thead>
						<tr>
							<th width="10">
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<input type="checkbox">
								<i class="fa fa-square-o small"></i>
							</label>
							</div></th>
							<th width="75" style="text-align: center;">첨부파일</th>
							<th width="100" style="text-align: center;">문서번호</th>
							<th style="text-align: center;">제목</th>
							<th width="150" style="text-align: center;">기안자</th>
							<th width="100" style="text-align: center;">기안일</th>
							<th width="150" style="text-align: center;">문서종류</th>
							<th width="80" style="text-align: center;">진행상태</th>
						</tr>
					</thead>
					<% for(int i = 0; i < list.size(); i++) { 
							Draft d = list.get(i);%>
					<tbody>
						<tr>
							<td>				
							<div class="checkbox" style="margin:0px; margin-left: 10px;">
							<label>
								<input type="checkbox">
								<i class="fa fa-square-o small"></i>
							</label>
							</div>
							</td>
							<td><i class="fa fa-paperclip"></i></td>
							<td><%= d.getDocno() %></td>
							<td><a href="/hiapt/index.jsp?#/hiapt/dview?docno=<%= d.getDocno() %>"><%= d.getDoctitle()%></a></td>
							<td><%= d.getEmpno() %></td>
							<td><%= d.getDraftdate() %></td>
							<td><%= d.getFormcode()%></td>
							<td>반려</td>
						</tr>
					</tbody>
					<%} %>
				</table>	
	<div style="float: right;">
	<input type="button" value="이동" class="btn btn-default btn-xs" style="letter-spacing: 7px; padding-left: 10px;">
	</div>
</form>
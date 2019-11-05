<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="complain.model.vo.*,aptuser.model.vo.Aptuser, java.util.*"%>
<%
	Complain comp = (Complain)request.getAttribute("comp");
	ArrayList<ComplainImgs> imglist = (ArrayList<ComplainImgs>)request.getAttribute("imglist");
	int currentPage = (int)request.getAttribute("currentPage");
%>
<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html"%>
<!-- head 끝  -->
<style type="text/css">
.image-container{
            overflow: hidden;
            display: flex;
            align-items: center;
            justify-content: center;
            width: 400px;
            height: 400px;
        }
</style>
<script type="text/javascript">
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
function cupdate(){
	var compNo ="<%= comp.getCompNo() %>";
	if(compNo==1)
		alert("테스트글은 수정 할 수 없습니다.");
	else
		window.location.href="/hiapt/co.view?uporview=up&cno="+compNo;
	return false;
};

function cView(){
	window.location.href="/hiapt/co.list?page=<%= currentPage %>";
	return false;
};


function openImg(url){
	var img=new Image();
	  img.src=url;
	  var img_width=img.width;
	  var win_width=img.width+25;
	  var img_height=img.height;
	  var win=img.height+30;
	  var OpenWindow=window.open('','_blank', 'width=500, height=500, menubars=no, scrollbars=auto');
	  OpenWindow.document.write("<style>body{margin:0px;}</style><img src='"+url+"' width='"+win_width+"'>");
}


</script>

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
					<li>민원게시판</li>
				</ul>
				<h2>민원 조회</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<!-- 본문 타이틀 복사 끝 ======================================================================================================-->
	<section class="section1">
		<div class="container clearfix">

			<table class="table table-bordered">
				<tr>
					<td width="70" style="text-align: center"><%= comp.getCompNo() %> </td>
					<th style="text-align: center"><%= comp.getCompTitle() %></th>
					<td width="120" style="text-align: center">
					<% if(comp.getCompNo()==1) {%>
					테스트
					<%}else{ %>
					<%= comp.getUserName() %>
					<%} %>
					</td>
					<td width="130" style="text-align: center"><%= comp.getCompDate() %></td>
					<%if(comp.getCompReponse() == null) {%>
 					<td width="100" style="text-align: center">답변 대기</td>
		 			<%}else{%>
 					<td width="100" style="text-align: center">답변 완료</td>
 					<%} %>
 					<%if(comp.getCompResultStatus().equals("N")){ %>
 					<td width="100" style="text-align: center">처리 대기</td>
 					<%}else{ %>
 					<td width="100" style="text-align: center">처리 완료</td>
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
				<tr>
					<td colspan="6"><h4><%= comp.getEmpName() %>님의 답변입니다.</h4>
					<%if(comp.getCompReponse()==null) {%>
					민원 처리 대기중입니다. 확인 후 연락드리겠습니다.
					<%}else {%>
					<%= comp.getCompReponse() %>
					<%} %>
					</td>
				</tr>
			</table>		
			<div align="right">
				<%if(aptuser.getUserId().equals(comp.getUserId())&&comp.getCompNo()!=1) {%>
				<button onclick="cupdate();">수정페이지</button>&nbsp;
				<button onclick="cdelete();">삭제하기</button>&nbsp;
				<%} %>
				<button onclick="cView();">목록보기</button>&nbsp;
			</div>
		</div>
	</section>



	<!--  /// 본문 끝//////  -->
	<!-- footer 시작 -->
	<%@ include file="../userfooter.jsp"%>
	<!-- footer 끝  -->
</body>
</html>
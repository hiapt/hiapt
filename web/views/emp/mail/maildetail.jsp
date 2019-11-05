<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mail.model.vo.Mailm, mail.model.vo.MailFileBox, java.util.ArrayList"%>

<%
	Mailm mailm = (Mailm)request.getAttribute("mailm");
	MailFileBox mbf = (MailFileBox)request.getAttribute("mbf");
	int currentPage = (Integer)request.getAttribute("currentPage");
	/* String code = (String)request.getAttribute("code"); */
	String code = (String)request.getAttribute("code");	
%>

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>
<style>
#boxlist{
	list-style : none;
	margin : 0px;
}
#myboxlist{
	list-style : none;
	margin : 0px;
}
</style>


<!-- head 시작 -->
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 

<!-- ============================================================= -->
<!-- 왼쪽 메인 메뉴바 시작  --> 
<%@ include file ="../../common/empnavi.jsp" %>

<script type="text/javascript">
$(function() {
	/* 이동 창 내 메일함 리스트 출력 */
	$.ajax({
		url : "/hiapt/mbtlist",
		type : "post",
		data : {empemail : $("#empemail").val()},
		dataType : "json",
		success : function(data){
			var jsonStr = JSON.stringify(data);
			var json = JSON.parse(jsonStr);
			size = json.list.length;
			
			var values = "";
			for(var i in json.list){
				values += "<li class='list'><a href='#' class='w' id='box"+ i +"'>" + decodeURIComponent(json.list[i].name).replace(/\+/gi, " ")
				+ "</a></li><input type='hidden' id='mcode"+ i +"' value='"+json.list[i].mcode+"'>";
				
			}
			
			$("#myboxlist").html($("#myboxlist").html() + values);
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
		}
	});
	
	/* 이동 */
	$("#receive").click(function(){
		console.log("a");
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&mcode=1&mailno=<%= mailm.getMailNo() %>&code=<%= code %>";  
	});
	
	$("#send").click(function(){
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&mcode=2&mailno=<%= mailm.getMailNo() %>&code=<%= code %>";    
	});
	
	$("#self").click(function(){
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&mcode=4&mailno=<%= mailm.getMailNo() %>&code=<%= code %>";	    
	});
	
	$("#trash").click(function(){
	    location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&mcode=5&mailno=<%= mailm.getMailNo() %>&code=<%= code %>";	    
	});
});

	//삭제
	function del(){
		location.href = "/hiapt/movew?mailno=<%= mailm.getMailNo() %>&page=<%= currentPage %>&empemail=<%= emp.getEmpEmail() %>&code=<%= code %>";
		return false;
	}
	
	//답장
	function reply(){
		location.href = "/hiapt/mreply?mailno=<%= mailm.getMailNo() %>&empemail=<%= emp.getEmpEmail() %>&code=<%= code %>";
		return false;
	}
	
	window.onload = function(){
		/* 새 메일함들 이동 */	
		$(".w").each(function(i){
			$(this).click(function(){
				var val = $("#mcode"+i).val();
				location.href = "/hiapt/mmbox?empemail=<%= emp.getEmpEmail() %>&page=<%= currentPage %>&code=<%= code %>&mcode="+val+"&mailno=<%= mailm.getMailNo() %>";	
			})
		});
		
		}
</script>
<!-- 왼쪽 메인 메뉴바 끝  --> 
<!-- ================================================================================= -->

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
<!-- 본문 타이틀 들어가는 부분 ---->					
<!--///////본문 내용 시작 ///////-------->
<h3>메일 상세보기</h3>
<div class="card shadow mb-4">
<div class="card-body">
<input type="checkbox"> &nbsp; 
<button class="btn btn-primary btn-sm shadow-sm" onclick="return del();">삭제</button> 
<% if(mailm.getMailCode() != 4){ %>
<button class="btn btn-primary btn-sm shadow-sm" onclick="return reply();">답장</button>
<% } %>
<% if(mailm.getMailCode() == 2){ %>
<button class="btn btn-primary btn-sm shadow-sm" onclick="return del();">다시보내기</button> 
<% } %> 
<% if(mailm.getMailCode() == 4){ %>
<button class="btn btn-primary btn-sm shadow-sm" onclick="return del();">수정</button> 
<% } %> 
<button class="btn btn-primary btn-sm shadow-sm" type="button" id="dropdownMenuButton" data-toggle="dropdown">
  							이동</button><br><hr>
<div id="drop-mail-box" class="dropdown-menu"> 
  		<ul id="boxlist" style="padding-left:7px;">
			<li class="list"><a href="#" id="receive">받은 편지함</a></li>
			<li class="list"><a id="send">보낸 편지함</a></li>
			<li class="list"><a href="#" id="self">내게쓴편지함</a></li>
			<li class="list"><a href="#" id="trash">휴지통</a></li>
		</ul><hr>
		<ul id="myboxlist" style="padding-left:7px;">
		</ul> 							
  	</div>
<h5><%= mailm.getMailTitle() %></h5>
<% if(code.equals("4")){ %>

<% }else{ %>
<span><b>보낸사람</b></span>&nbsp;<span><%= mailm.getEmpEmail() %></span><br>
<span><b>받는사람</b></span>&nbsp;<span><%= mailm.getRecipient() %></span><hr>
<% } %>
<span><b>파일 첨부</b></span>&nbsp;

<% if(mbf.getOriginalfile() != null){ %>
<a href="/hiapt/mfdown?ofile=<%= mbf.getOriginalfile() %>&rfile=<%= mbf.getRenamefile()%>">
<%= mbf.getOriginalfile() %></a><br>
<% }else { %>
없음
<% } %>
<hr>

<div align="center"><br><%= mailm.getMailContents() %><br></div>

</div>
</div>
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
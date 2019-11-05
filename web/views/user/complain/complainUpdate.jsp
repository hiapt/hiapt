<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="complain.model.vo.*,aptuser.model.vo.Aptuser,java.util.*,java.text.*"%>
<%
	Complain comp = (Complain)request.getAttribute("comp");
	ArrayList<ComplainImgs> imglist = (ArrayList<ComplainImgs>)request.getAttribute("imglist");
	
	ComplainImgs cims = new ComplainImgs(); 
	cims.setCompOriginalImgname("첨부이미지 없음");
	for(int i=imglist.size(); i<5; i++){
		imglist.add(cims);
	}
%>
<%
	Date date =new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
%>    
<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="../userhead.html"%>
<!-- head 끝  -->
<script type="text/javascript">
var addFile = document.getElementsByClassName("addfile"); 
var count= 4;
function fileAddFunction() {
	if(count==4){
		alert("더이상 추가 할 수 없습니다.");
	}else{	
		for(var i=0; i<4; i++){
			if(addFile[i].style.display == "none"){
				addFile[i].style.display="";
				count++;
				break;
			}/* if */
		}/*  for*/
	}/* else */
	return false;
}

function fileDeleteFunction(fileNo,dfileNo,vfile,hfile) {/* tr클레스/인풋id */
	count--;
	dfileNo.value=""; /* input file 초기화 */
	fileNo.style.display = "none"; /* 인풋타입 숨김 */
	vfile.innerHTML=""; //기존파일명 초기화
	hfile.value="";//hidden 초기화
	return false;
}
/* 파일첨부1번 초기화 */
function fileOneDelete(dfileNo,vfile,hfile) {
	dfileNo.value="";
	vfile.innerHTML="";
	hfile.value="";
	return false;
}

function checkFile(cfile,vfile,hfile){

	var file = cfile.files;
	var fileName=file[0].name
	
	var fileDot = fileName.lastIndexOf('.');
	var fileExtension = fileName.substring(fileDot,fileName.length);
	
	if(fileExtension != ".jpg" && fileExtension != ".gif" && fileExtension != ".png"){
		alert("이미지 파일만 첨부하실수 있습니다.");
		cfile.value="";
	}
	
	vfile.innerHTML="";
	hfile.value="";
	return false;
}

function checkSubmit(){
	var cTitle = document.getElementById("ctitle").value;
	var cContent = document.getElementById("ccontent").value;
	
	if(cTitle.length>31){
		alert("제목은 30글자 이하만 가능합니다.");
		$("#ctitle").focus();
		return false;
	}
	
	if(cContent.length>1001){
		alert("글내용은 1000글자 이하만 가능합니다.");
		$("#ccontent").focus();
		return false;
	}
	
	return true;
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
					<li>민원접수</li>
				</ul>
				<h2>민원접수 작성</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<!-- 본문 타이틀 복사 끝 ======================================================================================================-->
<section class="section1">
    <div class="container clearfix">
	<form action="/hiapt/co.update" method="post" enctype="multipart/form-data" onsubmit="return checkSubmit();">
		<table class="table table-bordered">
			<tr>
				<th style="text-align: center">제목</th>
				<input type="hidden" name="cno" value="<%= comp.getCompNo() %>">
				<td><input id="ctitle" type="text" name="ctitle" value="<%= comp.getCompTitle() %>"required></td>
			</tr>
			<tr>
				<th style="text-align: center">작성자</th>
				<td><%= aptuser.getUserName() %></td>
			</tr>
			<tr>
				<th style="text-align: center">작성 날짜</th>
				<td><%= comp.getCompDate() %></td>
			</tr>
			<tr>
				<th style="text-align: center">공개 여부</th>
				<%if( comp.getCompSecret().equals("N")) {%>
				<td><input type="radio" name="csecret" value="N" checked="checked"> 공개 &nbsp; &nbsp; 
					<input type="radio" name="csecret" value="Y"> 비공개</td>
				<%}else{ %>
				<td><input type="radio" name="csecret" value="N"> 공개 &nbsp; &nbsp; 
					<input type="radio" name="csecret" value="Y" checked="checked"> 비공개</td>
				<%} %>	
			</tr>
			
			<tr >
				<th style="text-align: center">이미지 첨부1</th>
				<td><div id="vfile1">
					<%= imglist.get(0).getCompOriginalImgname() %><br></div>
					<input type="hidden" name="hfile1" value="<%= imglist.get(0).getCompOriginalImgname() %>">
					<input id="dfile1" type="file" name="file1" accept="image/*" onchange="checkFile(this,vfile1,hfile1)" style="display:inline-block">
					<input type="button" onclick="fileAddFunction();" value="추가">&nbsp;
					<input type="button" onclick="fileOneDelete(dfile1,vfile1,hfile1);" value="이미지첨부1 초기화">&nbsp;&nbsp;
				</td>
			</tr>
			
			<%for(int i=2; i<6; i++) {%>
			<tr class="addfile" id="addfile<%= i %>">
				<th style="text-align: center">이미지 첨부<%= i %></th>
				<td><div id="vfile<%= i %>">
					<%= imglist.get(i-1).getCompOriginalImgname() %><br></div>
					<input type="hidden" name="hfile<%= i %>" value="<%= imglist.get(i-1).getCompOriginalImgname() %>">
					<input id="dfile<%= i %>" type="file" name="file<%= i %>" accept="image/*" onchange="checkFile(this,vfile<%=i %>,hfile<%=i %>)" style="display:inline-block">
					<input type="button" onclick="fileDeleteFunction(addfile<%= i %>, dfile<%= i %>, vfile<%=i %>,hfile<%=i%>);" value="삭제">&nbsp;&nbsp;
				</td>
			</tr >
			<%} %>
			
			<tr>
				<th style="text-align: center">내용</th>
				<td>
				<textarea id="ccontent" rows="10" cols="50" name="ccontent" required><%= comp.getCompContents() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
					<input type="submit" value ="수정완료"> &nbsp;
					<input type="reset" value="작성취소"> &nbsp; 
					<input type="button" value="이전페이지로" onclick="history.go(-1);">
				</td>
			</tr>
		</table>
	</form>
</div>
</section>
<!--  /// 본문 끝//////  -->
	<!-- footer 시작 -->
	<%@ include file="../userfooter.jsp"%>
	<!-- footer 끝  -->
</body>
</html>
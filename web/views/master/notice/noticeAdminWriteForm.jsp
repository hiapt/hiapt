<!--/// jsp 코드 ///-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee, notice.model.vo.Notice,java.util.*,java.text.*"%>

<%
	Employee loginEmployee = (Employee) session.getAttribute("employee");
	Date date =new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
%>
<!--복사 시작 ////////////////////////////--------------------->

<!DOCTYPE html>
<html>
<!-- head 시작 -->
<%@ include file ="../../common/emphead.html" %>

<!-- head 시작 -->
<style>
#intable tr th {
text-align:center;
}

</style>
<script type="text/javascript"
	src="/hiapt/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
var addFile = document.getElementsByClassName("addfile");
var count = 0;

function addfile(){
	
	if(count == 4){
		alert("파일은 최대 5개 첨부 가능합니다.");
	}else{
		for(var i = 0; i < 4; i++){
			if(addFile[i].style.display == "none"){
				addFile[i].style.display = "";
				count ++;
				break;
			}
		}
	}
	return false;
	
	
	
}
//추가된 파일 삭제하기
function oneFileDelete(divno, fileno, fileSize){
	count--;
	fileno.value="";
	divno.style.display="none";
	fileSize.innerText="";
	return false;
}
//파일 용량 체크하는 함수
function checkFileSize(ufile,sizePrint){
	var file = ufile.files;
	console.log("file : "+file);
	
	var fileSize = file[0].size;
	if(fileSize > 1024*1024*10){
		alert("10MB 이상의 파일은 등록할 수 없습니다.\n 현재 파일 용량 : "+(Math.round(fileSize/1024/1024*1000)/1000)+"MB");
		ufile.value="";
		sizePrint.innerText="";
	}else{//fileSize<=1024*1024*10
		sizePrint.innerText=(Math.round(fileSize/1024/1024*1000)/1000)+"MB";
	}
	return false;
	
	
	
}
function firstFileDelete(divid, fileSize){
	divid.value="";
	fileSize.innerText="";
	return false;
	
}



function moveList(){
	
	var returnValue = window.confirm("공지 사항 등록을 취소 하시겠습니까 ?");
	if(returnValue){
		window.location.href="/hiapt/no.list";
	}else{
		return;
	}
	return false;
}
$(function() {
		//전역변수선언
		var editor_object = [];

		nhn.husky.EZCreator.createInIFrame({
			oAppRef : editor_object,
			elPlaceHolder : "smarteditor",
			sSkinURI : "/hiapt/resources/smarteditor/SmartEditor2Skin.html",
			fCreator: "createSEditor2",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : false,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		//전송버튼 클릭이벤트
		$("#in").click(function() {
					//id가 smarteditor인 textarea에 에디터에서 대입
					editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

					// 이부분에 에디터 validation 검증
					var titleValue = $("#title").val();
					//제목 정규식 
					//1. 공백으로 시작하면 안됨
					//2. 20글자 이하 
					//3. 
					if(titleValue == null && )
					
					
					
					
					
					

					//폼 submit
					$("#newNotice").submit();
					
				
		})
			
		$("#title").on("change",function(){
			var titleValue = $("#title").val();
			console.log(titleValue);
				//if(titleValue == null && )
		})
			
				
				
	})//도큐먼트 레디 

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

<h1 align="center">공지사항 등록하기</h1>
<br>
<div class="card shadow mb-4">
<div class="card-body">


<form action="/hiapt/no.in"method="post" enctype="multipart/form-data" id="newNotice">

	<table class="table table-borderedz" id="intable">
	<div align="right">
		<!-- <tr><th colspan="2" align="center"> -->
		<input class="btn btn-outline-primary btn-sm" type="button" value="등록" id="in">&nbsp;&nbsp;
		
		<!-- <input class="btn btn-outline-danger btn-sm" type="button" value="작성취소" onclick="javascript:history.go(-1);">&nbsp;&nbsp; -->
		
		<input class="btn btn-outline-secondary btn-sm"type="button" value="목록이동" onclick="moveList();">
		<!-- </th></tr> -->
		</div>
		<br>
		<tr><th>제목</th><td>
		<input type="text" name="title" id="title" size="50">
		</td></tr>
		<tr><th>작성자</th><td>
		<input type="text" name="writer" value="<%= loginEmployee.getEmpNo()%>" readonly>
		</td></tr>
		<tr><th>작성일자</th><td>
		<input type="date" name="date" value="<%= sysdate%>" readonly>
		</td></tr>
		<tr><th>내용</th><td>
		<div
		style="width: 900px; height: 450px; background-color: white; margin-top: 15px;">
		<textarea name="doccontent" id="smarteditor" rows="10" cols="100"
			style="width: 897px; height: 400px;" required="required"></textarea>
		</div>
		</td></tr>
		
		
		
		
		<tr><th>첨부파일</th><td>
		<div id="div1">
		<input class="btn btn-outline-secondary btn-sm" type="file" id="file1" name="file1"onchange="checkFileSize(this,fileSize1)">
		&nbsp;&nbsp;
		<input class="btn btn-outline-danger btn-sm" type="button" onclick="firstFileDelete(file1, fileSize1);" value="첨부파일 초기화" >
		&nbsp;&nbsp;
		<input class="btn btn-outline-success btn-sm" type="button" onclick="addfile();" value="추가">
		
		<h6 id="fileSize1"></h6>
		</div>
		
		<div class="addfile" id="div2" style="display:none;">
			<input class="btn btn-outline-secondary btn-sm" id="file2" type="file" name="file2" onchange="checkFileSize(this,fileSize2)">&nbsp;&nbsp;
			<input type="button" onclick="oneFileDelete(div2, file2, fileSize2);" value="삭제" class="btn btn-outline-danger btn-sm">
			<h6 id="fileSize2"></h6>
		</div>
		
		<div class="addfile" id="div3" style="display:none;">
			<input class="btn btn-outline-secondary btn-sm" id="file3" type="file" name="file3" onchange="checkFileSize(this,fileSize3)">&nbsp;&nbsp;
			<input type="button" onclick="oneFileDelete(div3, file3, fileSize3);" value="삭제" class="btn btn-outline-danger btn-sm"> 
			<h6 id="fileSize3"></h6>
		</div>
		
		<div class="addfile" id="div4" style="display:none;">
			<input class="btn btn-outline-secondary btn-sm" id="file4"type="file" name="file4" onchange="checkFileSize(this,fileSize4)">&nbsp;&nbsp;
			<input type="button" onclick="oneFileDelete(div4, file4, fileSize4);" value="삭제" class="btn btn-outline-danger btn-sm">
			<h6 id="fileSize4"></h6>
		</div>
		
		<div class="addfile" id="div5" style="display:none;">
			<input class="btn btn-outline-secondary btn-sm" id="file5" type="file" name="file5" onchange="checkFileSize(this,fileSize5)">&nbsp;&nbsp;			
			<input type="button" onclick="oneFileDelete(div5, file5, fileSize5);" value="삭제" class="btn btn-outline-danger btn-sm">
			<h6 id="fileSize5"></h6>
		</div>
		</td></tr>
	</table>	
</form>	
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
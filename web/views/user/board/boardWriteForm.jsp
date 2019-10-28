<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="aptuser.model.vo.Aptuser,java.util.*,java.text.*"%>

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
var count=0;
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

function fileDeleteFunction(fileNo,dfileNo,fileSize) {/* tr클레스/인풋id */
	count--;
	dfileNo.value=""; /* input file 초기화 */
	fileNo.style.display = "none"; /* 인풋타입 숨김 */
	fileSize.innerText="";
	return false;
}
/* 파일첨부1번 초기화 */
function fileOneDelete(dfileNo,fileSize) {
	dfileNo.value="";
	fileSize.innerText="";
	
	return false;
}

function checkFile(cfile,fileSize){

	// files 로 해당 파일 정보 얻기.
	var file = cfile.files;
	/* FileList 형식으로반환. 길이가 1인 배열로...
		0: File
		lastModified: 1571969111985 //마지막으로 수행된 날짜
		lastModifiedDate: Fri Oct 25 2019 11:05:11 GMT+0900 (한국 표준시) {}
		name: "하이아파트자유게시판.sql"
		size: 1467
		type: "" */
	// file[0].size 는 ex 1467
	var fs = file[0].size;
	if(fs > 1024 * 1024 * 30){
		// 용량 초과시 경고후 해당 파일의 용량도 보여줌
		alert('30MB 미만의 파일만 등록할 수 있습니다.\n' + '현재파일 용량 : ' + (Math.round(fs/1024/1024*1000)/1000) + 'MB');
		cfile.value=""; //초기화시켜준다.
		//cfile.outerHTML = cfile.outerHTML; value가 안먹히면 새로 바꿔준다.
	}
        if(fs<=1024*1024*30)          
       fileSize.innerText=(Math.round(fs/1024/1024*1000)/1000) + 'MB';
        
	return false;

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
					<li>자유게시판</li>
				</ul>
				<h2>자유게시판 작성</h2>
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<!-- 본문 타이틀 복사 끝 ======================================================================================================-->
<section class="section1">
    <div class="container clearfix">
	<form action="/hiapt/bo.write" method="post" enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" required></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bwrite" readonly
					value="<%= aptuser.getUserName() %>"></td>
					<input type="hidden" name="buserid" value="<%= aptuser.getUserId() %>">
			</tr>
			<tr>
				<th>작성날짜</th>
				<td><%= sysdate %></td>
			</tr>
			<tr >
				<th>첨부파일1</th>
				<td><input id="dfile1" type="file" name="file1" onchange="checkFile(this,fileSize1)" style="display:inline-block">
					<input type="button" onclick="fileAddFunction();" value="추가">&nbsp;
					<input type="button" onclick="fileOneDelete(dfile1,fileSize1);" value="첨부파일1 초기화">&nbsp;&nbsp;
					<h6 id="fileSize1" style="display:inline-block"></h6>
				</td>
			</tr>
			<tr class="addfile" id="addfile2" style="display: none">
				<th>첨부파일2</th>
				<td><input id="dfile2" type="file" name="file2" onchange="checkFile(this,fileSize2)" style="display:inline-block">
					<input type="button" onclick="fileDeleteFunction(addfile2, dfile2, fileSize2);" value="삭제">&nbsp;&nbsp;
					<h6 id="fileSize2" style="display:inline-block"></h6>
				</td>
			</tr >
			<tr class="addfile" id="addfile3" style="display: none">
				<th>첨부파일3</th>
				<td><input id="dfile3" type="file" name="file3" onchange="checkFile(this,fileSize3)" style="display:inline-block">
					<input type="button" onclick="fileDeleteFunction(addfile3, dfile3, fileSize3);" value="삭제">&nbsp;&nbsp;
					<h6 id="fileSize3" style="display:inline-block"></h6>
				</td>
			</tr>
			<tr class="addfile" id="addfile4" style="display: none">
				<th>첨부파일4</th>
				<td><input id="dfile4" type="file" name="file4" onchange="checkFile(this,fileSize4)" style="display:inline-block">
					<input type="button" onclick="fileDeleteFunction(addfile4, dfile4, fileSize4);" value="삭제">&nbsp;&nbsp;
					<h6 id="fileSize4" style="display:inline-block"></h6>
				</td>
			</tr>
			<tr class="addfile" id="addfile5" style="display: none">
				<th>첨부파일5</th>
				<td><input id="dfile5" type="file" name="file5" onchange="checkFile(this,fileSize5)" style="display:inline-block">
					<input type="button" onclick="fileDeleteFunction(addfile5, dfile5, fileSize5);" value="삭제">&nbsp;&nbsp;
					<h6 id="fileSize5" style="display:inline-block"></h6>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50" name="bcontent" required></textarea></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
					<input type="submit" value ="작성저장"> &nbsp;
					<input type="reset" value="작성취소"> &nbsp; 
					<input type="button" value="이전페이지로" onclick="javascript:window.history.go(-1);">
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
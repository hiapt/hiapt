<!--/// jsp 코드 ///-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="employee.model.vo.Employee, notice.model.vo.Notice,java.util.*,java.text.*, notice.model.vo.NoticeFiles"%>

<%	//로그인세션
	Employee loginEmployee = (Employee) session.getAttribute("employee");
	//현재 페이지
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	//수정할 NOTICE 객체
	Notice notice = (Notice)request.getAttribute("notice");
	//수정할 noticefile 리스트
	ArrayList<NoticeFiles> nfiles = (ArrayList<NoticeFiles>)request.getAttribute("nfiles");
	
	//NoticeFiles객체.....
	NoticeFiles noticefiles = new NoticeFiles();
	noticefiles.setNoticeOriginalFileName("첨부파일 없음");
	noticefiles.setNoticeFileSize("0MB");
	for(int i = nfiles.size(); i < 5; i++){//이거 포문이나 포이치문으로 못바꾸나
		nfiles.add(noticefiles);
	}
	
	
	//현재 날짜 
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
function moveList(){
	var returnValue = window.confirm("공지 사항 수정을 취소 하시겠습니까 ?");
	if(returnValue){
		window.location.href="/hiapt/no.list?page=<%=currentPage%>";
	}else{
		return;
	}
	return false;
}
//파일 추가하기
var bigDiv = document.getElementsByClassName("bigdiv");
var count =4;

function plusfile(){
	if(count == 4){
		alert("파일 첨부는 최대 5개까지 가능합니다.")
	}else{
		for(var i = 0; i < 4; i++){			
			if(bigDiv[i].style.display == "none"){
				bigDiv[i].style.display = "";
				count++;
				break;
			} 
		}
	}
	return false;
}
//고정된 파일에 업로드된 값 지우기
function firstFileDelete(pfile1, fileSize1, div1, hiddenfile1){
	pfile1.value="";
	fileSize1.innerText="";
	div1.innerHTML="";
	hiddenfile1.value="";
	return false;
}


//업로드된 파일 용량 체크하기
function checkFile(pfileid, fileSizeid, divid, hiddenfilename){
	var file = pfileid.files;
	//console.log(file);
	var onefile = file[0].size;
	if(onefile > 1024 * 1024* 10){
		alert("10MB 미만의 파일만 첨부가 가능합니다. \n 선택한 파일 용량 : "+(Math.round(onefile/1024/1024*1000)/1000)+"")
		pfileid.value="";//input file 초기화
	}else{//용량이 맞다면
		fileSizeid.innerText=(Math.round(onefile/1024/1024*1000)/1000)+"MB"//용량을 기제
		divid.innerHTML="";
		hiddenfilename.value="";
		
	}
	return false;
}



//업로드된 파일에 업로드된 값 지우기
function fileDelete(bigdivid, pfileid, fileSizeid, divid,hiddenfilename){
	count--;
	pfileid.value="";//보여지는 input file 값 초기화
	bigdivid.style.display="none";//input file 숨김
	fileSizeid.innetText="";//기록된 파일 사이즈 초기화
	divid.innerHTML="";//기존 파일 명 들 기재된 거 초기화
	hiddenfilename.value="";//input file hidden 값 초기화
	return false;

}

$(function() {
	//전역변수선언
	var editor_object = [];
	var content = '${content}';

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
		},
		FOnAppLoad : function () {
            editor_object.getById["smarteditor"].exec("PASTE_HTML", [content]); 
        },
        fCreator: "createSEditor2"
	});

	//전송버튼 클릭이벤트
	$("#up").click(
			function() {
				//id가 smarteditor인 textarea에 에디터에서 대입
				editor_object.getById["smarteditor"].exec(
						"UPDATE_CONTENTS_FIELD", []);

				// 이부분에 에디터 validation 검증

				//폼 submit
				$("#updateNotice").submit();
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

<h1 align="center">공지사항 수정하기</h1>
<br>
<div class="card shadow mb-4">
<div class="card-body">


<form action="/hiapt/no.up"method="post" enctype="multipart/form-data" id="updateNotice">
<input type="hidden" name="no" value="<%=notice.getNoticeNo() %>">
<input type="hidden" name="page" value="<%=currentPage %>">

	<table class="table table-borderedz" id="intable">
		<div align="right">
		<input type="button" class="btn btn-outline-primary btn-sm" value="수정" id="up">&nbsp;&nbsp;		
		<input type="button" class="btn btn-outline-warning btn-sm" value="이전 페이지"  onclick="javascript:history.go(-1);" >&nbsp;&nbsp;	
		<input type="button" class="btn btn-outline-secondary btn-sm"value="목록 이동" onclick="moveList();">
		</div>
		<br>
		<tr><th>제목</th><td>
		<input type="text" name="title" id="title" size="30"value="<%=notice.getNoticeTitle()%>">
		</td></tr>
		<tr><th>작성자</th><td>
		<input type="text" name="writer" value="<%= notice.getNoticeWriter()%>" readonly>
		</td></tr>
		<tr><th>작성일자</th><td>
		<input type="date" name="date" value="<%= sysdate%>" readonly>
		</td></tr>
		
		<tr><th>내용</th><td>
		<div
		style="width: 900px; height: 450px; background-color: white; margin-top: 15px;">
		<textarea name="doccontent" id="smarteditor" rows="10" cols="100"
			style="width: 897px; height: 400px;" required="required"><%=notice.getNoticeContents() %></textarea>
		</div>
		</td></tr>
		
		
		
		
		<tr><th>첨부파일</th><td>
		<div id="bigdiv1">
			<div id="div1">
			<%= nfiles.get(0).getNoticeOriginalFileName() %>&nbsp;&nbsp;
			<%= nfiles.get(0).getNoticeFileSize()%><br>
			</div>
			<input type="hidden" name="hiddenfile1" value="<%=nfiles.get(0).getNoticeOriginalFileName()%>">
			<input class="btn btn-outline-secondary btn-sm" type="file" name="showfile1" id="pfile1" onchange="checkFile(this, fileSize1, div1, hiddenfile1);" style="display:inline-block">
			<input class="btn btn-outline-danger btn-sm" type="button" onclick = "firstFileDelete(pfile1, fileSize1, div1, hiddenfile1);" value="첨부파일 초기화" class="btn btn-primary btn-sm">&nbsp;&nbsp;
			<input class="btn btn-outline-success btn-sm" type="button" onclick="plusfile();" value="첨부파일 추가 " class="btn btn-primary btn-sm">&nbsp;
			
			<h6 id="fileSize1" style="display:inline-block"></h6>
		</div>
		<%for(int i =2; i < 6; i ++){ %>
		<div class="bigdiv"id="bigdiv<%=i %>" ><!-- 여기에 style을 none으로 주게 되면 파일이 몇개여도 하나만 보임...  -->
			<div id="div<%=i%>">
				<%= nfiles.get(i-1).getNoticeOriginalFileName()%>&nbsp;&nbsp;
				<%= nfiles.get(i-1).getNoticeFileSize()%>&nbsp;&nbsp;				
			</div>
			<input type="hidden" name="hiddenfile<%=i %>" value="<%= nfiles.get(i-1).getNoticeOriginalFileName()%>">
			<input class="btn btn-outline-secondary btn-sm"type="file" name="showfile<%=i %>" id="pfile<%=i %>" onchange="checkFile(this, fileSize<%=i %>, div<%=i %>, hiddenfile<%=i %>);" style="display:inline-block">
			<input class="btn btn-outline-danger btn-sm" type="button" onclick="fileDelete(bigdiv<%=i%>, pfile<%=i %>, fileSize<%=i%>, div<%=i%>, hiddenfile<%=i %>);" value="삭제"	class="btn btn-primary btn-sm">&nbsp;&nbsp;
			<h6 id="fileSize<%=i%>" style="display:inline-block"></h6>
		</div>
		<%} %>
		
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
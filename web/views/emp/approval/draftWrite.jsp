<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.Draft"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>HIAPTProject</title>

	<!-- Custom fonts for this template-->
	<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
	<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
	<!-- Custom styles for this template-->
	<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="/hiapt/resources/css/basic.css" rel="stylesheet">
	
	<!-- Bootstrap core JavaScript-->
	<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->

<script type="text/javascript" src="/hiapt/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
    //전역변수선언
    var editor_object = [];
     
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "smarteditor",
        sSkinURI: "/hiapt/resources/smarteditor/SmartEditor2Skin.html", 
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
    $("#savebutton").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
         
        // 이부분에 에디터 validation 검증
         
        //폼 submit
        $("#frm").submit();
    });
});
</script>

<script type="text/javascript">


function formview() {
	var width = '700';
	var height = '600';
	var left = Math.ceil((window.screen.width - width) / 2);
	var top = Math.ceil((window.screen.width - height) / 2);
	
	window.open('/hiapt/views/emp/approval/formView.jsp' , '문서보기', 'width=' + width + ', height=' + height + ', left=' + left + ', top' + top);
	
}

</script>

<style type="text/css">
body {
	color: #444;
}

fieldset {
	width: 900px;
}

th {
	border: solid 3px #fff;
	border-collapse: collapse;
	padding: 15px;
	text-align: center;
	font-size: 11pt;
	height: 60px;
	background-color: rgba(87, 104, 173, 0.9);
	color: #f8f9fc;
	border-radius: 9px;
}

td {
	border: solid 3px #fff;
	border-collapse: collapse;
	padding-top: 15px;
	padding-bottom: 15px;
	text-align: center;
	font-size: 10.5pt;
	height: 60px;
	color: #5a5c69;
	font-weight: 600; 
	border-radius: 9px;
	background-color: rgba(87, 104, 173, 0.15);

}

#formselect {
	border-radius: 4px;
	border: none;
	width: 205px;
	height: 28px;
	padding-left: 5px;
	color: #5a5c69;
}

#boxselect {
	border-radius: 4px;
	border: none;
	width: 175px;
	height: 28px;
	padding-left: 5px;
	color: #5a5c69;
}
legend {
	font-weight: bold;
	font-size: 13pt;
	color: #5a5c69;
	line-height: 45px;
	margin-bottom: 15px;
	border-bottom: dashed 1px #5a5c69;
	text-align: left;
}
</style>

</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 

<%@ include file ="../../common/empnavi.jsp" %>

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
					
<!--///////본문 내용 시작 ///////-------->
<form action="/hiapt/dsend" method="post" id="frm">

<div class="row" style="margin-left: 2px;">
 
		<input type="button" value=" 기안하기 " class="btn btn-primary btn-icon-split" id="savebutton"
		
		style="padding: 7px;">
		 
		
		<input type="button" value=" 임시저장 " class="btn btn-secondary btn-icon-split" id="tempbutton"
		
		style="padding: 7px; margin-left: 25px;">&nbsp;&nbsp;
</div>
<br>
<div class="card shadow mb-4">
		<div class="card-body" align="center">

<div id="form">

<input type="hidden" name="progress" value="0">

<fieldset style="border: none">
<legend>기본 설정 <br></legend> 
<table style="width:900px; height: 50px;" >

<tr><th style=" width: 120px;">문서 종류</th>
<td width="415px;" style="padding-bottom: 8px;" colspan="3">
<select name="formtype" id="formselect">
<option>공용</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;
<select name="formcode" id="formselect">
<option value="100">일반 기안서</option>
<option value="110">휴가 신청서</option>
<option value="120">기타1</option>
</select>
&nbsp;&nbsp;&nbsp;
<!-- <button style="height: 25px;">문서보기</button> -->
<button onclick="formview();" class="btn btn-secondary btn-icon-split btn-sm" style="padding: 4px;">문서보기</button>
</td>
<th style="width: 120px;">작성자</th>
<td width="120px;" style="width: 120px;">
<input type="hidden" name="drafter" value="<%= emp.getEmpNo()%>" 
style = "width: 100px; border: none; background: none; text-align: center; margin-top: 1px;">
<%= emp.getEmpId() %>  <%= emp.getEmpName() %>
</td>
</tr>
<tr id="tab2">
<th style="width: 120px;">공개 여부</th>
<td width="25%">
<input type="radio" name="display" value="Y"	 required="required"> 공개 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="radio" name="display" value="N" required="required" checked="checked"> 비공개</td>

<th style="width: 120px;">문서함</th>
<td width="25%">
<select name="newbox" id="boxselect">
<option >없음 (기본)</option>
<option value="0">새 문서함1</option>
<option value="1">새 문서함2</option>
<option value="2">새 문서함3</option>
<option value="3">새 문서함4</option>
<option value="4">새 문서함5</option>
</select>
</td>

<th style="width: 120px;">결재자</th>
<td width="120px;" style="width: 120px;">
<input type="text" name="approver" value="관리자로 고정" readonly 
style = "width: 100px; border: none; background: none; text-align: center; margin-top: 1px;">
</td>
</tr>
</table>
</fieldset>

<br>

<br>
<fieldset>
<legend>상세 설정</legend>
</fieldset>

<input type="text" placeholder="제목 입력" name= "drafttitle"  required="required"
style="width: 900px; height: 35px; border: solid 1px #afafaf; border-radius: 5px; padding-left: 10px;">

<div style="width:900px; height:750px; background-color: white; margin-top: 15px;">
<textarea name="doccontent" id="smarteditor" rows="10" cols="100" style="width:897px; height:700px;" required="required"></textarea>
</div>
</div>
<fieldset style="margin-top: 20px;">
<legend>파일 첨부</legend>
<input type="file" style="float: left;" >
</fieldset><br>
</div></div>
</form>

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

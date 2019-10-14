<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="draft.model.vo.Draft, draft.model.vo.Draft, java.util.ArrayList"%>

<%  
	Draft draft = (Draft) request.getAttribute("draft"); 
%>

<!--복사 시작 ////////////////////////////--------------------->
<!DOCTYPE html>
<html>
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

<!--// css or jQuery or javaScript 삽입 부분    -->


<style type="text/css">
body {
	color: #444;
}

fieldset {
	width: 900px;
}

th {
	border: solid 3px #fbfbf0;
	border-collapse: collapse;
	padding: 15px;
	text-align: center;
	font-size: 11pt;
	height: 60px;
	background-color: rgba(67, 110, 144, 0.9);
	color: #fbfbf0;
	border-radius: 9px;
}

td {
	border: solid 3px #fbfbf0;
	border-collapse: collapse;
	padding-top: 15px;
	padding-bottom: 15px;
	text-align: center;
	font-size: 10.5pt;
	height: 60px;
	color: #214c70;
	font-weight: 600; 
	border-radius: 9px;
	background-color: rgba(67, 110, 144, 0.2);

}

#formselect {
	border-radius: 4px;
	border: none;
	width: 205px;
	height: 28px;
	padding-left: 5px;
	color: #436E90;
}

#boxselect {
	border-radius: 4px;
	border: none;
	width: 175px;
	height: 28px;
	padding-left: 5px;
	color: #436E90;
}
legend {
	font-weight: bold;
	font-size: 13pt;
	color: #436E90;
	line-height: 45px;
	margin-bottom: 15px;
	border-bottom: dashed 1px #769fb3;
}
</style>

</head>

<%@ include file="../../../top.jsp" %>

<!-- 본문 타이틀 들어가는 부분 ---->
<h1 class="h3 mb-4 text-gray-800">제목 샘플</h1>
					
<!--///////본문 내용 시작 ///////-------->
<form method="post">
<div class="row">
	<div id="breadcrumb" class="col-xs-12" style="position: fixed; padding-top: 10px; padding-bottom: 2px;">
		&nbsp;&nbsp;
		<input type="submit"  value="승인" class="btn btn-primary btn-sm"
		
		style="font-size: 11pt; letter-spacing: 2px;">&nbsp;&nbsp;
		
		<input type="button" value="반려" class="btn btn-danger btn-sm"
		
		style="font-size: 11pt; letter-spacing: 2px;">&nbsp;&nbsp;
		
			<input type="button" value="보류" class="btn btn-warning btn-sm"
		
		style="font-size: 11pt; letter-spacing: 2px;">&nbsp;&nbsp;
	</div>
</div>
<br><br> <br><br> <br>
<div style="text-align: center; width: 900px; color: #214c70; " >
<h2 >일반기안문서</h2><br>
<h2>제목 : <%= draft.getDoctitle()%></h2> <br>
<table style="width:900px; height: 50px;" >

<tr>

<th style="width: 120px;">작성자</th>
<td width="120px;" style="width: 120px;">
<input type="text" name="drafter" value="S001" readonly 
style = "width: 100px; border: none; background: none; text-align: center; margin-top: 1px;">
</td>
<th style="width: 120px;">결재자</th>
<td width="120px;" style="width: 120px;">
<input type="text" name="approver" value="관리자로 고정" readonly 
style = "width: 100px; border: none; background: none; text-align: center; margin-top: 1px;">
</td>
</tr>
<tr>
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


</tr>
</table>
<div style="width:900px; height:450px; background-color: none; margin-top: 15px;" align="center">
<textarea  style="width:895px; height:1000px; border-radius: 10px; border: 3px solid rgba(67, 110, 144, 0.7) ; resize: none; padding: 15px;" readonly="readonly">
<%= draft.getDoccontent() %></textarea>
</div>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div style="line-height: 1px; font-weight: bold; color: #436E90; ">첨부파일</div>
<hr width="895px" align="left" style="border: 1px dashed rgba(67, 110, 144, 0.8); "><br><br>
<div  style="width:900px; height:200px; background: rgba(67, 110, 144, 0.8); text-align: center; border-radius: 10px; padding-top: 25px" ><div style="color: white; font-size: 12pt; font-weight: bolder; text-shadow: 1px 1px 1px  rgba(67, 110, 144, 1);"> 첨삭 및 의견 </div> 
<textarea style="width:860px; height:120px; border: none;  ;margin-top: 15px; border-radius: 10px; resize: none; padding: 15px;">
</textarea>
</div>

</form>



<!---//// 본문 내용 끝 ///////------------------->
<%@ include file = "../../../footer.html" %>
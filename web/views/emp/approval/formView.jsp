<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

body{
text-align: center;
background-color: #fbfbf0;
font-size: 12pt;
}

select, option{
font-size: 10pt;
width: 600px;
}

textarea {
	border-radius: 10px;
}

</style>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/css/select2.min.css" rel="stylesheet" />

</head>

<!-- head 시작 -->
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

<div align="center" id="title"><h2>문서양식 미리보기</h2></div>
<form>
<div>
<h3>문서양식 선택</h3>
<select class="form-control" >
<option>공용 - 일반 기안서</option>
<option>공용 - 휴가 신청서</option>
<option>업무일지 - 직원 업무 일지</option>
<option>업무일지 - 관리자 업무 일지</option>
<option>기타문서 - 기타1</option>
<option>기타문서 - 기타2</option>
<option>기타문서 - 기타3</option>
<option>기타문서 - 기타4</option>
<option>기타문서 - 기타5</option>
<option>기타문서 - 기타6</option>
<option>기타문서 - 기타7</option>
<option>기타문서 - 기타8</option>
<option>기타문서 - 기타9</option>
<option>기타문서 - 기타11</option>
<option>기타문서 - 기타12</option>
<option>기타문서 - 기타13</option>
<option>기타문서 - 기타14</option>
<option>기타문서 - 기타15</option>
</select>
</div>
<div>
<h3>미리보기</h3>
<textarea readonly="readonly" style="resize: none;" cols="88" rows="25">

</textarea>
</div>
<div>
<button>선택</button>
<button>취소</button>
</div>


</form>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- select2 javascript cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/js/select2.min.js"></script>
<script>
// select2 초기화
$('select').select2();
</script>



<!---//// 본문 내용 끝 ///////------------------->
<%@ include file = "../../../footer.html" %>
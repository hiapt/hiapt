<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="employee.model.vo.Employee"%>
<%
	Employee emp = (Employee)session.getAttribute("employee");
%>
    <% 
	String y = request.getParameter("y"); 
    String m = request.getParameter("m"); 
    String d = request.getParameter("d"); 
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

<!-- Bootstrap core JavaScript-->
<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->

<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  

<script type="text/javascript">
function cc(){
	alert("등록완료");
	self.close();
	return true;
}
$(function() {
    $(".testDatepicker").datepicker({
    	 changeMonth: true, 
         changeYear: true,
         nextText: '다음 달',
         prevText: '이전 달',
         showButtonPanel: true, 
         currentText: '오늘 날짜', 
         closeText: '닫기', 
         dateFormat: "yy-mm-dd",
      	 changeMonth: true, 
         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
         monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
    });

	//var str = $("#str", opener.document).val();
	//$("#start").attr("value",str);
	
  

    
});
</script>
</head>

<body id="page-top" onunload="javascript:opener.document.location.reload();">

	<!-- Page Wrapper -->
	<div id="wrapper">

<!-- 왼쪽 메인 메뉴바 시작 --> 



<!-- 왼쪽 메인 메뉴바 끝  --> 
<!-- ================================================================================= -->

<!--- 중앙 전체 큰 틀 ---------------------------------------------->
<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">
<!-- Main Content -->
<div id="content">

<!-- ================================================================================= -->
<!---탑메뉴  시작 =================---------------------------->

<!---탑 메뉴 끝 ------------------------------------------->
<!--========================================================================================== -->
<!-- Begin Page Content -->
<div class="container-fluid">
<!-- 본문 타이틀 들어가는 부분 ---->		


			
<!--///////본문 내용 시작 ///////-------->	
<h1 class="h3 mb-4 text-gray-800">Schedule</h1>
<div class="card shadow mb-4">
<div class="card-body">
<h2 align="center">일정 등록 페이지</h2>
<form action="/hiapt/schin" method="post" onsubmit="return cc();">
<input type="hidden" name="year" value="<%=y %>">
<input type="hidden" name ="month" value="<%=m %>">
<table align="center" width="400" cellspacing="0" cellpadding="8" border="1">

<tr><th>일정 제목</th><td><input type="text" name="title"></td></tr>
<tr><th>일정 구분</th><td><input type="radio" value="worked" name="schtype" checked>업무&nbsp;&nbsp;
<input type="radio" value="notworked" name="schtype">개인일정

</td></tr>

<tr><th>시작 일자</th><td>
<input type="text" name="start" id="start" class="testDatepicker" value="<%=y%>-<%=m%>-<%=d%>"></td></tr>
<tr><th>종료 일자</th><td>
<input type="text" name="end" class="testDatepicker"value="<%=y%>-<%=m%>-<%=d%>"></td></tr>
<tr><th>일정 메모</th><td><textarea rows="3" cols="21" name="memo"></textarea></td></tr>
<tr><th>공개 여부</th><td>
<input type="radio" name="open" value="Y">공개&nbsp;&nbsp;
<input type="radio" name="open" value="N" checked>비공개
</td></tr>
<tr><th>알람 여부</th><td>
<input type="radio" name="alarm" value="Y">설정&nbsp;&nbsp;
<input type="radio" name="alarm" value="N" checked>미설정</td></tr>
<tr><th>색&nbsp;&nbsp;&nbsp;&nbsp;상</th><td>
 <select class="" name="bgcolor" id="">
<option value="#D25565" style="color:#D25565;">빨간색</option>
<option value="#9775fa" style="color:#9775fa;">보라색</option>
<option value="#ffa94d" style="color:#ffa94d;">주황색</option>
<option value="#74c0fc" style="color:#74c0fc;">파란색</option>
<option value="#f06595" style="color:#f06595;">핑크색</option>
<option value="#63e6be" style="color:#63e6be;">연두색</option>
<option value="#a9e34b" style="color:#a9e34b;">초록색</option>
<option value="#4d638c" style="color:#4d638c;">남   색</option>
<option value="#495057" style="color:#495057;">검정색</option>
</select></td></tr>
<tr><th>중 요 도</th>
<td><input type="radio" name="importance" value="3">상&nbsp;
<input type="radio" name="importance" value="2" checked>중&nbsp;
<input type="radio" name="importance" value="1" >하</td></tr>
<tr><th>작 성 자</th><td><input type="text" name="writer" value="<%=emp.getEmpNo() %>" readonly></td></tr>
<tr><th colspan="2"><input type="submit" value="등록">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="다시 작성">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="취소" onclick="window.close();"></th></tr>
</table>
</form>



	</div>
	</div>	
	
</div><!-- /.container-fluid -->				
</div><!-- End of Main Content -->	
<!---//// 본문 내용 끝 ///////------------------->
<!-- footer 시작 -->
<!-- footer 시작 -->
</div>	<!-- End of Content Wrapper -->
</div>	<!-- End of Page Wrapper -->	
<!--========================================================================================== -->
<!-- top 버튼 -->
<%@ include file = "../../common/topbutton.html" %>
<!--========================================================================================== -->
</body>
</html>
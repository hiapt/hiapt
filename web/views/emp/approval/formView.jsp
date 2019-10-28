<%@page import="java.util.ArrayList, formbox.model.vo.Formbox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Formbox> flist = (ArrayList<Formbox>) request.getAttribute("list");
    %>
    
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
<script type="text/javascript">
</script>

<style type="text/css">

body{
text-align: center;
background-color: #f8f9fc;
color: #444;
}


textarea {
	border-radius: 5px;
}

</style>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/css/select2.min.css" rel="stylesheet" />

</head>

<!--///////본문 내용 시작 ///////-------->

<div align="center" id="title">문서양식 미리보기</div>
<form>
<div>
문서양식 선택<br>
<select class="form-control"  style="width: 614px;">

<%
for (int i = 0; i < flist.size(); i++) { 
	 Formbox f = flist.get(i); 
	 %>
	 
<option value="<%= f.getFormcode() %>"><%= f.getFormtype() %> - <%= f.getFormname() %></option>
<% } %>
</select>
</div>
<div>

미리보기
<br>

<textarea readonly="readonly" style="resize: none;" cols="75" rows="24">

</textarea>
</div>
<br>
<div>
<button>선택</button> &nbsp;
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
<!--========================================================================================== -->
<!-- top 버튼 -->
<!--========================================================================================== -->
</body>
</html>

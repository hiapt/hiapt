<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>HIAPTProject</title>

	<!-- Custom fonts for this template-->
	<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">	
	<!-- Custom styles for this template-->
	<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="/hiapt/resources/css/basic.css" rel="stylesheet">
	
	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->
<script type="text/javascript">
function validation(){
	return true;	
}

// 팝업창(세대주 정보 조회)
/* var openWin; */

/* function openChild(){
	window.name = "parentFrom";
	openWin = window.open("/hiapt/imvas", "childFrom", "width=570, height=600, resizable = no, scrollbars = no");
} */
// pup
function popup(){
    var url="/hiapt/imvas";
    var option="width=570, height=600, resizable = no, scrollbars = no";
    window.open(url, "", option);
}
// 천단위 자동콤마(,) 삽입 및 소수점 표현
function inputNumberAutoComma(obj){
	var number = obj.value;
	var integer = obj.value;
	var point = number.indexOf('.');
	var decimal ='';
	var checkcd ='';
	
	//첫번째 수부터 소수점 기호(.)를 사용방지
	if(number.charAt(0) == '.'){
		alert("첫번째 수부터 소수점 기호(.)를 사용할 수 없습니다.");
		obj.value ='';
		return false;
	}
	
	// 소수점이 존재하면 태우는 분기
	if(point > 0){
		// 소수점 앞 자리값만 따로 담는다.
		integer = number.substr(0, point);
		
		// 소수점 아래 자리값만 따로 담는다.
		decimal = number.substr((point + 1), number.lenght);
		chekcd = inputNumberisFinit(decimal);
		
		if(chekcd == "N"){
			alert("문자 또는 음수는 입력하실 수 없습니다.");
			obj.value ='';
			return false;
		}
	}
	
	// 정수형 콤마를 제거한다.
	integer = integer.replace(/\,/g,'');
	chekcd = inputNumberisFinit(integer);
	
	if(chekcd == "N"){
		alert("문자 또는 음수는 입력하실 수 없습니다.");
		obj.value =='';
		return false;
	}
	
	// 정수형 한번더 점검한다.
	integer = inputNumberWithComma(inputNumberRemoveComma(integer));
	
	// 소수가 존재하면 나누었던 콤마 기호를 삽입한다.
	if(point > 0){
		obj.value = integer + '.' + decimal;
	}
	
	// 소수가 존재하지 않는다면 콤마값을 넣은 정수만 삽입한다.
	else {
		obj.value = integer;
	}
	console.log("integer전 : " + integer + ", integer type : " + typeof(integer));
	console.log("chekcd : " + chekcd);
	
}

// 천단위 이상의 숫자에 콤마(,)를 삽입하는 함수
function inputNumberWithComma(str){
	str = String(str);
	return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,"$1,");
}

// 콤마가 들어간 값에 콤마를 제거하는 함수
function inputNumberRemoveComma(str){
	str = String(str);
	return str.replace(/[^\d]+/g,'');	
	
	console.log("n : " + n)
}


// 문자 여부를 확인하고 문자가 존재하면 N, 존재하지 않으면 Y를 리턴한다.
function inputNumberisFinit(str){
	if(isFinite(str) == false){
		return "N";
	} else {
		return "Y";
	}
}

//당월부과액 합계 내는 함수
$(document).ready(function(){
	$("#button_sum").click(function(){
		var sum = 0;
		$(".price").each(function(){
			sum += Number($(this).val().replace(/[^\d]+/g,''));			
			console.log("sum : " + sum + ", type: " + typeof(sum));			
		});
		
		sum = String(sum);
		$(".amount").val(inputNumberWithComma(sum));	
		console.log(sum + typeof(sum));
	});
	
	
});
</script>

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
<!-- 본문 타이틀 들어가는 부분 ---->	
<h1 class="h3 mb-4 text-gray-800">관리비 등록</h1>			
<!--///////본문 내용 시작 ///////-------->	
<div class="card shadow mb-4">
<div class="card-body">		

<form action="/hiapt/imin" method="post" onclick="return validation();" id="form">
<div class="card-title" style="float:right;">							          
			<input type="submit" value="저장" class="btn btn-sm btn-danger shadow-sm">&nbsp;
			<input type="reset" value="취소" class="btn btn-sm btn-secondary shadow-sm" >&nbsp;
			<a href="javascript:history.go(-1);" class="btn btn-sm btn-primary shadow-sm" >이전페이지로 이동</a>&nbsp;
			<br>
		</div>
	<table class="table table-bordered" id="myTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th colspan="2">고지서번호 &nbsp;<span class="text-danger">*<small>자동부여</small></span></th>
                      <th>부과년월</th>
                      <th colspan="2"><input type="date" name="bill_year_month" ></th>
                      <th colspan="2"></th>
                    </tr>
                  </thead>
                   <tbody>
                    <tr>
                      <th>동/호<span class="text-danger">*</span></th>
                      <td>
                      <div class="bt_r2">
						<label><input type="text" title="동/호" name="userid" class="" id="parentId1" value="">
						</label>
						<a href="javascript:popup()" class="btn btn-primary btn-sm shadow-sm">조회</a>
						
						<!-- <button type="button" 
						onclick="openChild()" class="btn btn-primary btn-sm shadow-sm">조회</button> -->
					</div>
					  </td>
                      <th>성명<span class="text-danger">*</span></th>
                      <td colspan="2"><input type="text" name="username" id="parentId2" requeired></td>
                    </tr>
                    <tr>
                    	<th>부과항목명</th>
                    	<th>금액</th>
                    	<th>전기에너지</th>
                    	<th>금액</th>
                    	<th>사용량</th>
                    </tr>
                    <tr>
                    	<th>일반관리비</th>
                    	<td>
                    	<input type="text" name="general_cost" class="price" 
                    	onKeyup="inputNumberAutoComma(this);" value="">
                    	<%--키보드 자체에서 음수가 입력 안되게 막는 것
                    	 <input type="text" name="general_cost" class="price" 
                    	onKeyup="inputNumberAutoComma(this);" value=""
                    	min="0" onkeypress="return (event.charCode == 8 || event.charCode == 0 ) ? null : event.charCode >= 48 && event.charCode <= 57"> --%></td>
                    	<th>세대전기료</th>
                    	<td><input type="text" name="electric_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<td><input type="text" name="electric_usage" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    </tr>
                    <tr>
                    	<th>청소비</th>
                    	<td><input type="text" name="clean_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<th>공동전기료</th>                    	
                    	<td><input type="text" name="allelectric_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<td></td>
                    </tr>
                    <tr>
                    	<th>소독비</th>
                    	<td><input type="text" name="disinfect_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<th>TV수신료</th>
                    	<td><input type="text" name="tv_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<td></td>
                    </tr>
                    <tr>
                    	<th>승강기유지비</th>
                    	<th><input type="text" name="elevator_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></th>
                    	<th>열에너지</th>                    	
                    	<th>금액</th>
                    	<th>사용량</th>
                    </tr>
                    <tr>
                    	<th>수선유지비</th>
                    	<td><input type="text" name="repair_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<th>난방사용료</th>
                    	<td><input type="text" name="heating_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<td><input type="text" name="heating_usage" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    </tr>
                    <tr>
                    	<th>경비비</th>
                    	<td><input type="text" name="guard_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<th>온수사용료</th>
                    	<td><input type="text" name="hwater_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<td><input type="text" name="hwater_usage" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    </tr>
                    <tr>
                    	<th>화재보험료</th>
                    	<td><input type="text" name="fireinsurance_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<th>수도사용료</th>                    	
                    	<th>금액</th>
                    	<th>사용량</th>
                    </tr>
                     <tr>
                    	<th>위탁관리수수료</th>
                    	<td><input type="text" name="commission" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<th>세대수도료</th>                   	
                    	<td><input type="text" name="water_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<td><input type="text" name="water_usage" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    </tr>
                    <tr>
                    	<td colspan="2"></td>
                    	<th>공동수도료</th>                    	
                    	<td><input type="text" name="allwater_cost" class="price" onKeyup="inputNumberAutoComma(this);" value=""></td>
                    	<td></td>
                    </tr>
                    
                    <tr>
                    	<th>당월부과액
                    	<button type="button" id="button_sum" class="btn btn-secondary btn-sm"><i class="fas fa-plus"></i></button>
                    	</th>
                    	<th><input type="text" name="amount" class="amount" onKeyup="inputNumberAutoComma(this);" value="">
                    	</th>
                    	<td colspan="3"></td>
                    </tr>
                    
                    </tbody>

</table>

</form>

</div></div>
      

<!---//// 본문 내용 끝 ///////------------------->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<!---//// 본문 내용 끝 ///////------------------->
			<!-- footer 시작 -->
			<%@ include file="../../common/empfooter.html"%>
			<!-- footer 시작 -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<!--========================================================================================== -->
	<!-- top 버튼 -->
	<%@ include file="../../common/topbutton.html"%>
	<!--========================================================================================== -->
	
	



</body>
</html>
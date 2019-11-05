<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ page import="maintenance.model.vo.UserBill, java.util.ArrayList, java.util.*,java.text.*" %>
    
    <% UserBill ubill = (UserBill) request.getAttribute("ubill"); %>
    
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>HiAPTU</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
 <!--  <link href="img/favicon.png" rel="icon"> -->


  <!-- Bootstrap CSS File -->
  <link href="/hiapt/resources/css/bootstrap.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="/hiapt/resources/css/prettyphoto.css" rel="stylesheet">
  <link href="/hiapt/resources/css/hoverex-all.css" rel="stylesheet">
  <link href="/hiapt/resources/css/jetmenu.css" rel="stylesheet">
  <link href="/hiapt/resources/css/owl-carousel.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="/hiapt/resources/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="/hiapt/resources/css/blue.css">
  <style>
.conLbox {/* 
    margin-bottom: 35px; */
    padding: 20px 20px 0 20px;/* 
    border-top: 1px solid #912790; */
    border-bottom: 1px solid #e6e6e6;
    background-color: #f5f5f5;
}
.pay_select ul {
    overflow: hidden;
    margin-bottom:0;
}
.pay_select ul li {
    float: left;
    min-width: 140px;
    margin-bottom:0;
}

.conLbox li {
    margin-left: 2px;
}
.pb12 {
    padding-bottom: 12px !important;
}
input, textarea, select {
    font-family: Gulim,'굴림',Helvetica,sans-serif;
    font-size: 12px;
    color: #585858;
    line-height: 1.5;
    text-align: left;
}

input, select, button {
    vertical-align: middle;
    margin: 0;
    padding: 0;
}
user agent stylesheet
input[type="radio" i] {
    background-color: initial;
    cursor: default;
    -webkit-appearance: radio;
    box-sizing: border-box;
    margin: 3px 3px 0px 5px;
    padding: initial;
    border: initial;
}
label {
    cursor: default;
}

ul, ol, dl {
    list-style: none;
}
dl {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
}
.payInfo dt {
    float: left;
}
.payInfo dd {
    padding: 0 0 10px 60px;
    display: block;
    margin-inline-start: 40px;
}
.pt5 {
    padding-top: 5px !important;
}
.payInfo input[type=text] {
    height: 23px;
    width: 67px;
    padding-left: 8px;
    border: 1px solid #ccc;
    color: #333;
    font-size: 15px;
    font-family: dotum;
}

</style>
  
  <!-- 결제연동을 위한 라이브러리 -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>

<!-- <script type="text/javascript">
var IMP = window.IMP; // 생략가능
IMP.init('imp11826978');  // 가맹점 식별 코드

IMP.request_pay({
   pg : 'kakao', // 결제방식
    pay_method : 'card',	// 결제 수단
    merchant_uid : 'merchant_' + new Date().getTime(),
   name : '주문명: 결제 테스트',	// order 테이블에 들어갈 주문명 혹은 주문 번호
    amount : '100',	// 결제 금액
    buyer_email : '',	// 구매자 email
   buyer_name :  '',	// 구매자 이름
    buyer_tel :  '',	// 구매자 전화번호
    buyer_addr :  '',	// 구매자 주소
    buyer_postcode :  '',	// 구매자 우편번호
    m_redirect_url : '/khx/payEnd.action'	// 결제 완료 후 보낼 컨트롤러의 메소드명
}, function(rsp) {
	if ( rsp.success ) { // 성공시
		var msg = '결제가 완료되었습니다.';
		msg += '고유ID : ' + rsp.imp_uid;
		msg += '상점 거래ID : ' + rsp.merchant_uid;
		msg += '결제 금액 : ' + rsp.paid_amount;
		msg += '카드 승인번호 : ' + rsp.apply_num;
	} else { // 실패시
		var msg = '결제에 실패하였습니다.';
		msg += '에러내용 : ' + rsp.error_msg;
	}
});

</script> -->

</head>
<body>
<%@ include file="../userheader.jsp"%>

  <section class="post-wrapper-top">
    <div class="container">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<ul class="breadcrumb">
				<li><a href="/hiapt/index2.jsp">Home</a></li>
				<li>관리비납부</li>
			</ul>
			<h2>
				<sapn class="text-info"><%=aptuser.getUserName()%></sapn>
				님의 아파트 관리비
			</h2>
		</div>
	</div>
</section>
<!-- end post-wrapper-top -->
<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 끝==================================================================================-->
<!--  -->
<section class="section1">
    <div class="container clearfix">
      <div class="content">
      
      <p>아임 서포트 결제 모듈 테스트 해보기</p>
<button id="check_module" type="button">아임 서포트 결제 모듈 테스트 해보기</button>
</p>



		<form id="personalinfo" action="" name="personalinfo" method="post">
		
        <table class="table table-striped checkout" data-effect="fade">
          <thead>
            <tr>
              <th>고지서번호</th>
              <th>납부금액</th>
              <th>연체료</th>
              <th>납부수수료</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th></th>
              <td>원</td>
              <td>원</td>
              <td>원</td>
            </tr>
          </tbody>
        </table>
       
        <div class="clearfix"></div>

        <div class="payments">
         <h5 class="title">결제수단 선택</h5>
        </div>
        
        
          <div>
          <button class="btn btn-large btn-primary pull-left">취소</button>&nbsp;<a href="/hiapt/views/user/bill/kakaoapi.jsp" class="btn btn-large btn-primary pull-right">납부하기</a>&nbsp;
          </div>
        </form>

      </div>
      <!-- end content -->
		
   		<div class="clearfix"></div>
        <div class="divider"></div>
           		

      </div>
      <!-- end sidebar -->
   
    <!-- end container -->
  </section>
  <!-- end section -->


<%-- <%@ include file="../userfooter.jsp"%> --%>
</body>
</html>
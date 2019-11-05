<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<!-- head 시작  -->
<%@ include file="views/user/userhead.html" %>
<!-- head 끝  -->

<body>
<!-- navi 시작  -->
<%@ include file="views/user/userheader.jsp" %>
<!-- navi 끝  -->

<!-- /// 본문 시작////// -->

  <section id="intro">
    <div class="container">
      <div class="ror">
        <div class="col-md-8 col-md-offset-2">
          <h1>하이 프리미엄,<br> 이곳은 Hi아파트 입니다.</h1>
          <p>화창한 날입니다. 그리고 전 그걸 볼수가 없죠.<br>It’s a beautiful day and I can’t see it.</p>
        </div>
      </div>
    </div>
  </section>


  <section class="section1">
    <div class="container">
      <div class="col-lg-4 col-md-4 col-sm-4">
        <div class="servicebox text-center">
          <div class="service-icon">
            <div class="dm-icon-effect-1" data-effect="slide-left">
              <a href="/hiapt/ublist"> <i class="active dm-icon fa fa-search fa-3x"></i> </a>
            </div>
            <div class="servicetitle">
              <h4>관리비조회</h4>
              <hr>
            </div>
            <p>고지서보다 빠르게, 인터넷으로 편하게, <br>지나달과 작년 같은 달과도 비교하고<br> 항목마다도 비교해 볼 수 있는 똑똑한 조회!</p>
          </div>
          <!-- service-icon -->
        </div>
        <!-- servicebox -->
      </div>
      <!-- large-4 -->

      <div class="col-lg-4 col-md-4 col-sm-4">
        <div class="servicebox text-center">
          <div class="service-icon">
            <div class="dm-icon-effect-1" data-effect="slide-bottom">
              <a href="/hiapt/ublist"> <i class="active dm-icon fa fa-credit-card fa-3x"></i> </a>
            </div>
            <div class="servicetitle">
              <h4>관리비결제</h4>
              <hr>
            </div>
            <p>언제 어디서나 편안하게<br> 자동이체로 납부하는 세대의 관리비 할인법 <br> 다음달 관리비 차감하자!</p>
          </div>
          <!-- service-icon -->
        </div>
        <!-- servicebox -->
      </div>
      <!-- large-4 -->

      <div class="col-lg-4 col-md-4 col-sm-4">
        <div class="servicebox text-center">
          <div class="service-icon">
            <div class="dm-icon-effect-1" data-effect="slide-right">
              <a href="/hiapt/co.list"> <i class="active dm-icon fa fa-pencil-square-o fa-3x"></i> </a>
            </div>
            <div class="servicetitle">
              <h4>민원접수</h4>
              <hr>
            </div>
            <p>작은 소리도 크게 듣겠습니다.  <br> 주민여러분과 함께 하는 온라인 단일창구 입니다.<br> 200가지 행복</p>
          </div>
          <!-- service-icon -->
        </div>
        <!-- servicebox -->
      </div>
      <!-- large-4 -->
    </div>
    <!-- end container -->
  </section>
  <!-- end section -->
  
  <!--  /// 본문 끝//////  -->

<!-- footer 시작 -->
 <%@ include file="views/user/userfooter.jsp" %>
<!-- footer 끝  -->
 </body>
</html>
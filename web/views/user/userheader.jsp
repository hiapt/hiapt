<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="aptuser.model.vo.Aptuser"%>
<%
   Aptuser aptuser = (Aptuser)session.getAttribute("aptuser");
%>

<div class="topbar clearfix">
    <div class="container">
      <div class="col-lg-12 text-right">
        <div class="social_buttons">
          
          <span style="width:66px;padding: 16px;font-size: 16px;"><%= aptuser.getUserName() %></span>
          <span class="at_bar">|</span><a href="/hiapt/uout">로그아웃 </a>
        </div>
      </div>
    </div>
    <!-- end container -->
  </div>
  <!-- end topbar -->

  <header class="header">
    <div class="container">
      <div class="site-header clearfix">
        <div class="col-lg-3 col-md-3 col-sm-12 title-area">
          <div class="site-title" id="title">
            <a href="/hiapt/login.jsp" title="">
              <h2>Hi<span>APT</span></h2>
            </a>
          </div>
        </div>
        <!-- title area -->
        <div class="col-lg-9 col-md-12 col-sm-12">
          <div id="nav" class="right">
            <div class="container clearfix">
              <ul id="jetmenu" class="jetmenu blue">
                <!--li class="active"><a href="index.html">Home</a>
                </li-->
                <li><a href="#">샘플들</a>
                   <ul class="dropdown">
                    <li><a href="/hiapt/views/user/sample/contact.html">샘플1</a></li>
                    <li><a href="/hiapt/views/user/sample/sample.html">샘플2</a></li>
                    <li><a href="/hiapt/views/user/sample/404.html">샘플3</a></li>
                    <li><a href="/hiapt/views/user/sample/about.html">샘플4</a></li>  
                    <li><a href="/hiapt/views/user/sample/service.html">샘플5</a></li>
                    <li><a href="/hiapt/views/user/sample/support.html">샘플6</a></li>  
                    <li><a href="/hiapt/views/user/sample/testimonials.html">샘플7</a></li>
                    <li><a href="/hiapt/views/user/sample/fullwidth.html">샘플8</a></li>                      
                  </ul>
                </li>
                <li><a href="#">관리비조회</a>
                   <ul class="dropdown">                    
                    <li><a href="/hiapt/views/user/maintenance/BillList.jsp">관리비조회</a></li>
                    <li><a href="/hiapt/views/user/maintenance/ReceiptList.jsp">납부내역조회</a></li>                   
                  </ul>
                </li>
                <li><a href="#">관리비결제</a></li>
                <li><a href="#">민원접수</a></li>
                <li><a href="#">공지사항</a></li>
                <li><a href="/hiapt/vo.list">주민투표</a></li>
                <li><a href="/hiapt/bo.list">자유게시판</a></li>
              </ul>
            </div>
          </div>
          <!-- nav -->
        </div>
        <!-- title area -->
      </div>
      <!-- site header -->
    </div>
    <!-- end container -->
  </header>
  <!-- end header -->
  <!-- 세대주 머리부분 공통부분 복사해서 쓰세요 끝 =============================================================================== -->
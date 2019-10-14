<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>관리비조회</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<!--  <link href="img/favicon.png" rel="icon"> -->

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Ruda:400,900,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="/hiapt/resources/css/bootstrap.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="/hiapt/resources/css/prettyphoto.css" rel="stylesheet">
<link href="/hiapt/resources/css/hoverex-all.css" rel="stylesheet">
<link href="/hiapt/resources/css/jetmenu.css" rel="stylesheet">
<link href="/hiapt/resources/css/owl-carousel.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="/hiapt/resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="/hiapt/resources/css/blue.css">

</head>

<body>
	<div class="topbar clearfix">
		<div class="container">
			<div class="col-lg-12 text-right">
				<div class="social_buttons">

					<a href="/hiapt/login.jsp" data-toggle="tooltip"
						data-placement="bottom"> *** 님 </a> <span class="at_bar">|</span><a
						href="/hiapt/login.jsp" data-toggle="tooltip"
						data-placement="bottom"> 로그아웃 </a>
					<!--span class="at_bar">|</span><a href="#" data-toggle="tooltip" data-placement="bottom" title="Dribbble"> 사이트맵 </a-->
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
							<h2>
								Hi<span>APT</span>
							</h2>
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
								<li><a href="#">관리비조회</a>
									<ul class="dropdown">
										<li><a href="/hiapt/views/user/maintenance/BillList.jsp">관리비조회</a></li>
										<li><a
											href="/hiapt/views/user/maintenance/ReceiptList.jsp">납부내역조회</a></li>
									</ul></li>
								<li><a href="/hiapt/views/user/maintenance">관리비결제</a></li>
								<li><a href="#">민원접수</a></li>
								<li><a href="#">공지사항</a></li>
								<li><a href="#">주민투표</a></li>
								<li><a href="#">자유게시판</a></li>
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
	<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 시작==================================================================================-->
	<section class="post-wrapper-top">
		<div class="container">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<ul class="breadcrumb">
					<li><a href="/hiapt/index2.jsp">Home</a></li>
					<li>관리비조회</li>
				</ul>
				<h2>관리비조회</h2>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<!-- search -->
				<div class="search-bar">
					<form action="" method="get">
						<fieldset>
							<input type="image" src="img/pixel.gif" class="searchsubmit"
								alt="" /> <input type="date" class="search_text showtextback"
								name="s" id="s" max="9999-12" value="" />
						</fieldset>
					</form>
				</div>
				<!-- / end div .search-bar -->
			</div>
		</div>
	</section>
	<!-- end post-wrapper-top -->
	<!-- 본문 타이틀 시작 구성 타이틀 부분 복사 끝==================================================================================-->
	<!--  -->
	<section class="section1">
		<div class="container clearfix">
			<div class="content col-xs-12 clearfix">

				<h4 class="title">
					<span>9월분</span>&nbsp <small>납부마감일</small>
				</h4>

				<div class="pull-right">
					<input type="submit" value="당월고지서인쇄" id="submit" class="button">
				</div>
				<div class="clearfix"></div>
				<hr>

				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>당월부과액</th>
							<th>미납액</th>
							<th>미납연체료</th>
							<th>납기내 금액</th>
							<th>납기후 연체료</th>
							<th>납기후 금액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>

					</tbody>
				</table>
				<div class=" text-center">
					<ul class="pagination">
						<li><a href="#">«</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
				<ul class="pager">
					<li class="previous"><a
						href="/hiapt/views/user/maintenance/ReceiptList.jsp">← 납부내역조회</a>
					</li>
					<li class="next"><a href="#">아파트관리비 납부하기 →</a></li>
				</ul>

			</div>
			<!-- end content -->


		</div>
		<!-- end container -->
	</section>
	<!-- end section -->

	<!-- 세대주 아래 공통부분 복사해서 쓰세요 시작 =============================================================================== -->
	<footer class="footer">
		<div class="container">
			<ul class="footer-menu">
				<li class="ma-1"><a href="#"> 회사소개 </a></li>
				<li><span class="at_bar">|</span><a href="#"> 이용약관 </a></li>
				<li><span class="at_bar">|</span><a href="#"> 개인정보처리방침 </a></li>
				<li><span class="at_bar">|</span> Copyright &copy; 2019 - All
					rights reserved.</li>
			</ul>
		</div>
		<!-- end container -->


	</footer>
	<!-- end footer -->
	<div class="dmtop">Scroll to Top</div>

	<!-- JavaScript Libraries -->
	<script src="/hiapt/resources/js/jquery.min.js"></script>
	<script src="/hiapt/resources/js/bootstrap.min.js"></script>
	<script src="/hiapt/resources/js/prettyphoto.js"></script>
	<script src="/hiapt/resources/js/hoverdir.js"></script>
	<script src="/hiapt/resources/js/jetmenu.js"></script>

	<!-- Template Main Javascript File -->
	<script src="/hiapt/resources/js/main.js"></script>
	<!-- 세대주 아래 공통부분 복사해서 쓰세요 끝 =============================================================================== -->
</body>
</html>

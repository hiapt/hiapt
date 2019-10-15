<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../userhead.html" %>

<%@ include file="../userheader.jsp" %>



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

 <!--  /// 본문 끝//////  -->

 <%@ include file="../userfooter.jsp" %>
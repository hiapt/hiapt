<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>로그인 페이지</title>
	<link rel="stylesheet" href="">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>	
	<link href="/hiapt/resources/css/login.css"
	rel="stylesheet">
	<script>
		window.console = window.console || function(t) {};
	</script>
	<script>
		if (document.location.search.match(/type=embed/gi)) {
			window.parent.postMessage("resize", "*");
		}
	</script>
	
</head>
<body>
	<div class="form">
		
		<ul class="tab-group">
			<li class="tab active"><a href="#login1">세대주</a></li>
			<li class="tab"><a href="#login2">관리자/직원</a></li>
		</ul>
		
		<div class="tab-content">
			<div id="login1">   
				
				<form action="/hiapt/index2.jsp" method="post">
					
					<div class="field-wrap">
						<label>
							아이디<span class="req">*</span>
						</label>
						<input type="text"/>
						<!-- <input type="text"required autocomplete="off"/> -->
					</div>
					
					<div class="field-wrap">
						<label>
							비밀번호<span class="req">*</span>
						</label>
						<input type="password"/>
						<!-- <input type="password"required autocomplete="off"/> -->
					</div>
					
					<p class="forgot"><a href="#">비밀번호찾기</a></p>
					
					<button class="button button-block"/>로그인</button>
					
				</form>

			</div>
			
			<div id="login2">   
				
				<form action="/hiapt/index.jsp" method="post">
					
					<div class="field-wrap">
						<label>
							아이디<span class="req">*</span>
						</label>
						<input type="text"/>
						<!-- <input type="text"required autocomplete="off"/> -->
					</div>
					
					<div class="field-wrap">
						<label>
							비밀번호<span class="req">*</span>
						</label>
						<input type="password"/>
						<!-- <input type="password"required autocomplete="off"/> -->
					</div>
					
					<p class="forgot"><a href="#">비밀번호찾기</a></p>
					
					<button class="button button-block"/>로그인</button>
					
				</form>

			</div>
			
		</div><!-- tab-content -->
		
	</div> <!-- /form -->
	<script id="rendered-js">
		$('.form').find('input, textarea').on('keyup blur focus', function (e) {

			var $this = $(this),
			label = $this.prev('label');

			if (e.type === 'keyup') {
				if ($this.val() === '') {
					label.removeClass('active highlight');
				} else {
					label.addClass('active highlight');
				}
			} else if (e.type === 'blur') {
				if ($this.val() === '') {
					label.removeClass('active highlight');
				} else {
					label.removeClass('highlight');
				}
			} else if (e.type === 'focus') {

				if ($this.val() === '') {
					label.removeClass('highlight');
				} else
				if ($this.val() !== '') {
					label.addClass('highlight');
				}
			}

		});

		$('.tab a').on('click', function (e) {

			e.preventDefault();

			$(this).parent().addClass('active');
			$(this).parent().siblings().removeClass('active');

			target = $(this).attr('href');

			$('.tab-content > div').not(target).hide();

			$(target).fadeIn(600);

		});
      //# sourceURL=pen.js
  </script>
</body>
</html>
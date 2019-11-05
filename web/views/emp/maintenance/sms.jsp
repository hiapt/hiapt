<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){
$("#sms").on('click', function(){
	
	
	var from = 01080016812;
	var options = {
			  headers: {

			    	 Authorization: 'HMAC-SHA256 apiKey=NCSAU7OPHLU57ZGV, date=2019-11-04 19:32:34, salt=7de4dfb0c188ede136d9d1025137f0072a9f5ccf113fc7556f21f33e0ae3aeeb, signature=40cbd47a1dd54522388f7d8a158b6ad87ff79567edc102fce0bea172393da5c7',
			    'Content-Type': 'application/json'
			  },
			  body: {
			    message: {
			      to: '01080016812',
			      from: from,
			      text: 'test message'
			    }
			  },
			  method: 'POST',
			  url: 'http://api.solapi.com/messages/v4/send'
			};
			
			$.ajax(options).done(function(response) {
			  console.log(response);
			});
	
});
});

</script>
</head>
<body>
<button id="sms" class="">전송</button>
</body>
</html>
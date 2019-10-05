<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message = (String)request.getAttribute("message"); /*set으로 저장한거 get으로 가져옴*/
	/*String 으로 다운캐스팅 하거나 toString 써서 변환하거나 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
<h1>에러 발생 : <%= message %></h1>
<h2><a href="/employee/index.jsp">홈으로 이동</a></h2>
</body>
</html>
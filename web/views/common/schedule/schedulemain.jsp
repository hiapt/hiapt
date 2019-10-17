<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Calendar"%>
  
<!--복사 시작 ////////////////////////////--------------------->
<!DOCTYPE html>
<html>
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
<script src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->
<style>
.check {

	    display: inline-block !important;
}
.intable{
height:700px;
border:1px;
cellspacing:0;
cellpadding:5;
width:100%;
align:center;
table-layout : fixed;
</style>
<script type="text/javascript" src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
<%
	Calendar tDay = Calendar.getInstance();//캘린더 객체 생성
	int cy = tDay.get(Calendar.YEAR);//객체에서 년도 변수에 저장 
	int cm = tDay.get(Calendar.MONTH);//객체에서 월 변수에 저장
	int cd = tDay.get(Calendar.DATE);//객체에서 일 변수에 저장
    String Year = request.getParameter("year");
	String Month = request.getParameter("month");

	int year, month;

	if(Year == null && Month == null){
		year = cy;
		month = cm;
	}else{
		year = Integer.parseInt(Year);
		month = Integer.parseInt(Month);
		if(month < 0){
			month = 11; 
			year = year-1;
		}			
		if(month >11){
			month = 0;
			year = year+1;
		}
	}
tDay.set(year, month, 1);//현재 년월 1일을 객체에 저장

int start = tDay.get(Calendar.DAY_OF_WEEK);//현재 년월 1일의 요일을 yo에 저장 일요일 : 1, 월요일:2, 화요일:3..
int lastday = tDay.getActualMaximum(Calendar.DAY_OF_MONTH);//매월이 가질 수 있는 값의 최대값을 마지막일자로 저장함



%>

var str="";
$(function(){
	$("td:nth-child(1)").css("color","red");
	$("td:nth-child(7)").css("color","blue");
	$(".intable").css("text-align","right").css("valign","top");
	
	
	var year = <%=year%>
	var mon = <%=month%>
	var month = Number(mon)+1;
	var day;
	
	$(".intable td").on("click", function(){
		
		day=$(this).text();		
		str = year+"-"+month+"-"+day;
		console.log(str);
		
		var url ="scheduleInsert.jsp?y="+year+"&m="+month+"&d="+day;
		var name = "schedule insert";
		var option = "width=500, height=500, top= 100, left = 200, location=no";
		window.open(url, name, option );
				
	})
	
	
	$.ajax({
		url : "/third/schlist?year="+year+"&month="+month,
		type : "get",
		dataType : "json",
		success : function(data){
			var jsonStr = JSON.stringify(data);
			var json = JSON.parse(jsonStr);
			var value = "";
			var sday = "";
			for(var i in json.list){
				value += 
				json.list[i].cnum+"<br>"+
				decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"<br>"+				
				decodeURIComponent(json.list[i].color).replace(/\+/gi," ")+"<br>"+
				decodeURIComponent(json.list[i].cwriter).replace(/\+/gi," ")+"<br>";
				sday += json.list[i].cstart.split("-")+"<br>"+
				json.list[i].cend.split("-")+"<br>"
				
			//////
			//var ss = "<div style='background-color:"
			//+decodeURIComponent(json.list[i].color).replace(/\+/gi," ")
			//+";'>"+decodeURIComponent(json.list[i].ctitle).replace(/\+/gi," ")+"</div>"
			//$("#4").html($("#4").html()+ss);
			//	
			}
			//value 를 달력에 선택자로 div 추가 태그를 함
			var ss ="<div style='background-color:#D25565;'>title</div>"
			//var ss = "<div style='background-color:"+#D25565+";'>"+title+"</div>"
			//$("#4").html($("#4").html()+ss+"<br>"+sday);
			
			
			
			$("#test").html(value+"<br>"+sday);
		},
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error : "+jqXHR+", "+textStatus+", "+errorThrown);
		}
		
	})
	//div추가되는거 연습
	
	

})


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


			
<!--///////본문 내용 시작 ///////-------->	
<h1 class="h3 mb-4 text-gray-800">Schedule</h1>
<div class="card shadow mb-4">
<div class="card-body">
<table width="100%"  border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td align="left"colspan="2">
				<button><a href="schedulemain.jsp?year=<%out.print(year-1);%>&month=<%out.print(month);%>">◀</a></button>
				<button><a href="schedulemain.jsp?year=<%out.print(year+1);%>&month=<%out.print(month);%>">▶</a></button>
			</td>
			<td align="center"colspan="3">
			<button><a href="schedulemain.jsp?year=<%out.print(year);%>&month=<%out.print(month-1);%>">◁</a></button>
			<span style="font-size:20pt;"><% out.print(year); %>년<% out.print(month+1); %>월</span>
			<button><a href="schedulemain.jsp?year=<%out.print(year);%>&month=<%out.print(month+1);%>">▷</a></button>
			</td>
			<td align=right colspan="2"><button id="schin">일정 등록</button></td>
		</tr>
	</table>
  	<table border=1 cellspacing=0 cellpadding="5" width="100%" align="center"> 
		<tr align="center">
    		<td>일</td> <!-- 일=1 -->
   		 	<td>월</td> <!-- 월=2 -->
    		<td>화</td> <!-- 화=3 -->
    		<td>수</td> <!-- 수=4 -->
   			<td>목</td> <!-- 목=5 -->
   			<td>금</td> <!-- 금=6 -->
   			<td>토</td> <!-- 토=7 -->
		</tr>
	</table>
  	<table class="intable" border="1" valign="top"> 
		<tr>
		<%
			int br = 0;
			for(int i = 0; i < (start-1); i++){
				out.println("<td>&nbsp;</td>");
				br++;
				if((br % 7) == 0){
					out.println("<br>");
				}
			}
			
			for(int i = 1; i <= lastday; i++){
				out.println("<td id='"+i+"'>"+i+"</td>");
				br++;
				if((br%7) == 0 && i != lastday){
					out.println("</tr><tr>");
				}
			}
			while((br++) % 7 != 0){
				out.println("<td>&nbsp;</td>");
			}			
			
		%>	
		</tr>

	</table>
	<div id="test"></div>


	</div>
	</div>	
</div><!-- /.container-fluid -->				
</div><!-- End of Main Content -->	
<!---//// 본문 내용 끝 ///////------------------->
<!-- footer 시작 -->
<%@ include file = "../../common/empfooter.html" %>
<!-- footer 시작 -->
</div>	<!-- End of Content Wrapper -->
</div>	<!-- End of Page Wrapper -->	
<!--========================================================================================== -->
<!-- top 버튼 -->
<%@ include file = "../../common/topbutton.html" %>
<!--========================================================================================== -->
</body>
</html>
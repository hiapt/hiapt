<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="draft.model.vo.Draft, java.util.ArrayList, formbox.model.vo.Formbox, employee.model.vo.Employee, 
		java.util.Date, java.text.SimpleDateFormat"%>
<%
	ArrayList<Formbox> flist = (ArrayList<Formbox>) request.getAttribute("list");
	ArrayList<Employee> elist =  (ArrayList<Employee>) request.getAttribute("list2");
	Date deadline = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	deadline.setTime(deadline.getTime() + (1000 * 60 * 60 * 24 * 10));
	String sysdate = sdf.format(deadline);
%>
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
	<link href="/hiapt/resources/css/select2.css" rel="stylesheet">
	<link href="/hiapt/resources/css/select2.min.css" rel="stylesheet">
	
	<!-- Bootstrap core JavaScript-->
	<script src="/hiapt/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/hiapt/resources/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/hiapt/resources/vendor/chart.js/Chart.min.js"></script>
<!-- 	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script> -->

<!--// css or jQuery or javaScript 삽입 부분    -->

<script type="text/javascript" src="/hiapt/resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript" src="/hiapt/resources/js/select2.full.js" charset="utf-8"></script>
<script type="text/javascript" src="/hiapt/resources/js/select2.full.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/hiapt/resources/js/select2.js" charset="utf-8"></script>
<script type="text/javascript" src="/hiapt/resources/js/select2.min.js" charset="utf-8"></script>


<script type="text/javascript">
$(function() {
	$("#displaysel").select2({
		placeholder: '공람자를 지정해 주십시오.',
		maximumSelectionLength: 5
	});
	var myno = $("input[name=empno]").val();
	$("#displaysel > option[value='admin']").remove();
	$("#displaysel > option[value="+myno+"]").remove();
	$("#linel > option[value=" + myno + "]").remove();
});
//전역변수선언

var editor_object = [];
$(function(){

    nhn.husky.EZCreator.createInIFrame({
        oAppRef: editor_object,
        elPlaceHolder: "smarteditor",
        sSkinURI: "/hiapt/resources/smarteditor/SmartEditor2Skin.html", 
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,             
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : false,     
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true, 
        }
    });
     
    //전송버튼 클릭이벤트
    $("#savebutton").click(function(){
    	
        if($("#formselect2 option:selected").val() == 'none'){
        	alert("양식을 선택하세요");
        	$("#formselect2").focus();
        	return;
        }
        
        if($("input[name=approver]").val() == ""){
        	alert("결재자를 선택하세요");
        	$("#appline").focus();
        	return;
        }
        
        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);


        // 이부분에 에디터 validation 검증
        var con = document.getElementById("smarteditor").value;
        var title = document.getElementById("title").value;
        if( title == ""  || title == null )  {
            alert("제목을 입력하세요.");
            $("#title").focus();
      return;
       }
        if(title.length > 50){
            alert("제목은 한글 50글자 이상 입력할 수 없습니다.");
            $("#title").focus();
            return;
        }
        if( con== ""  || con == null || con == '&nbsp;' || con == '<br>' || con == '<br />' ||  con == '<p>&nbsp;</p>')  {
             alert("내용을 입력하세요.");
             editor_object.getById["smarteditor"].exec("FOCUS"); 
             return;
        }
        //폼 submit
        var a = confirm("기안 하시겠습니까?");
        if(a) {
        
        	$("#frm").submit();
        }else {
        	
        }
    });
    
    //전송버튼 클릭이벤트
    $("#tempbutton").click(function(){
    	
        if($("#formselect2 option:selected").val() == 'none'){
        	alert("양식을 선택하세요");
        	$("#formselect2").focus();
        	return;
        }

        //id가 smarteditor인 textarea에 에디터에서 대입
        editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);


        // 이부분에 에디터 validation 검증
        var con = document.getElementById("smarteditor").value;
        var title = document.getElementById("title").value;
        if( title == ""  || title == null )  {
            alert("제목을 입력하세요.");
            $("#title").focus();
   		   return;
      	}
  
        if(title.length > 50){
            alert("제목은 한글 50글자 이상 입력할 수 없습니다.");
            $("#title").focus();
            return;
        }
        if( con== ""  || con == null || con == '&nbsp;' || con == '<br>' || con == '<br />' ||  con == '<p>&nbsp;</p>')  {
             alert("내용을 입력하세요.");
             editor_object.getById["smarteditor"].exec("FOCUS"); 
             return;
        }
        //폼 submit
        var a = confirm("임시저장 하시겠습니까?");
        if(a) {
        	$("input[name='docstatus']").val("5");
        	$("input[name='display']").val(null);
        	$("input[name='deadline']").val("2099-01-01");
        	if($("#approver").val() == ""){
        		alert("결재자 미지정시 관리자로 임시저장됩니다.");
        		$("#approver").val("admin"); 
        	}
        	  $("#frm").submit();
        }else {
        	
        }
    });
    $("#formselect2").change(function(){
	$.ajax({
	    url : "fselect",
	    type : "get",
	    dataType : "json",
	    data : { form : $("select[name='formcode']").val() },
	    success : function(data) {
	    	var data1 = decodeURIComponent( data.form ).replace(/\+/gi, " ");
	    	var data2 = data.no;
	    	console.log("data : " + data1);
	    	editor_object.getById["smarteditor"].exec("SET_IR", [""]);
	        editor_object.getById["smarteditor"].exec("PASTE_HTML", [data1]);
	        },
	        error : function(jqXHR, textStatus, errorThrown){
				console.log("error : " + textStatus + errorThrown + jqXHR);
			}
		});
	  
    });
  
});

function fpreview(data1, data2) {
	 editor_object.getById["smarteditor"].exec("SET_IR", [""]);
     editor_object.getById["smarteditor"].exec("PASTE_HTML", [data1]);
     $("#formselect2").val(data2).attr("selected", "selected");

}


function formview() {
	var width = '700';
	var height = '600';
	var left = Math.ceil((window.screen.width - width) / 2);
	var top = Math.ceil((window.screen.width - height) / 2);
	window.open('/hiapt/fview' , '문서보기', 'width=' + width + ', height=' + height + ', left=' + left + ', top' + top);
} 

$(function() {
	$("#appline").click(function() {
		$("#line").css("display", "block");
		$("#liner").append($("#linel > option[value='admin']"));
		$("#liner > option").prop("selected", false);
	});
	$("#cancel").click(function() {
		$("#line").css("display", "none");

	});
	$("#abtn").click(function() {
		var linelval = $("#linel option:selected");
		if($("#liner option").length > 4 || linelval.length > 4){
			alert("결재선은 5명까지 지정 가능합니다.");
		}else{
			$("#liner").append(linelval);
			$("#liner").append($("#liner > option[value='admin']"));
		}
		$("#liner > option").prop("selected", false);
	});
	$("#bbtn").click(function() {
		var linerval = $("#liner option:selected");
		$("#linel").prepend(linerval);
		$("#linel > option").prop("selected", false);
	});
	$("#sendbtn").click(function() {
		if($("#liner option:last").val() != "admin"){
			alert("최종 결재자는 관리자로 고정되어있습니다.");
			if($("#liner option").length > 4){
				$("#linel").prepend($("#liner option:last"));
				$("#liner").append($("#linel > option[value='admin']"));
			}else{
				$("#liner").append($("#linel > option[value='admin']"));
			}
			
		}else {
		
		$("#liner option").prop("selected", "selected");
		var linelt = $("#liner").text();
		var linelv = $("#liner").val().join(',');
		console.log(linelt);
		$("#td").html(linelt);
		$("input[name=approver]").val(linelv);
		console.log(linelv);
		$("#line").css("display", "none");
		}
	});
	$("#displaysel").change(function() {
	var disv  = $("#displaysel").val().join(',');
	console.log(disv);
	$("input[name=display]").val(disv);
	});
	
	$("#save").click(function() {
		$("#lineadd").css("display", "block");
	});
	
	$("#can").click(function() {
		$("#lineadd").css("display", "none");
	});
	
	$("#add").click(function() {
		$("#liner option").prop("selected", "selected");
		var linelv = $("#liner").val().join(',');
		var linelt = $("#liner").text();
		
		$.ajax({
		    url : "appsave",
		    type : "post",
 		    data : { empno : $("input[name=empno]").val(), 
		    		linename : $("input[name=linename]").val(), 
		    		linecontent : linelt, 
		    		linevalue : linelv },
		    success : function() {
		    	$("#lineadd").css("display", "none");
		    	alert("결재선이 저장되었습니다.");
		    },
		        error : function(jqXHR, textStatus, errorThrown){
					console.log("error : " + textStatus + errorThrown + jqXHR);
				}
			});
		  
	});
	
	
});

</script>

<style type="text/css">
body {
	color: #444;
}

fieldset {
	width: 900px;
}

th {
	border: solid 1.5px #777;
	border-collapse: collapse;
	padding: 15px;
	text-align: center;
	font-size: 11pt;
	height: 60px;
	background-color: white;
	color: #444;
}

td {
	border: solid 1.5px #777;
	border-collapse: collapse;
	padding-top: 15px;
	padding-bottom: 15px;
	text-align: center;
	font-size: 10.5pt;
	height: 60px;
	color: #222;
	font-weight: 600; 
	background-color: white;

}

select {
	border-radius: 4px;
	border: solid 0.5px #585b68;
	width: 205px;
	height: 28px;
	padding-left: 5px;
	color: #222;
}

#boxselect {
	border-radius: 4px;
	border: none;
	width: 175px;
	height: 28px;
	padding-left: 5px;
	color: #222;
}
legend {
	font-weight: bold;
	font-size: 13pt;
	color: #5a5c69;
	line-height: 40px;
	margin-bottom: 15px;
	border-bottom: solid 1px #777;
	text-align: left;
}

#tab th {
	background-color: #e9eaef;
	
}

</style>

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
					
<!--///////본문 내용 시작 ///////-------->
		


<div class="card shadow mb-4">
		<div class="card-body" align="center">
			<div id="line" style="position: absolute; display: none; width: 600px; height: 480px; background: #eaecf1; 
			left: 15%; top: 3%; border-radius: 5px; padding-top: 15px; z-index: 2; border: 1px solid #ccc">
			<div id="lineadd" style="position: absolute; width: 550px; height: 60px; background: #eaecf1; 
			left: 4%; top: 42%; border-radius: 5px; padding-top: 15px; display: none; border: 1px solid #ccc; z-index: 1">
			<input type="text" name="linename" style="width: 400px; height: 30px; border: 1px solid #ccc; border-radius: 3px;  padding-left: 15px;"
			placeholder="저장할 결재선명을 입력하세요.">&nbsp;&nbsp;
			<input type="submit" value=" 등 록 " id="add" class="btn btn-primary btn-icon-split btn-sm" style="padding: 4px; margin-bottom: 2px;"> &nbsp;
			<input type="button" value=" 취 소 " id="can" class="btn btn-secondary btn-icon-split btn-sm" style="padding: 4px; margin-bottom: 2px;"> 
			<input type="hidden" value="<%= emp.getEmpNo()%>" name="empno">
			</div>
			<div style="width: 250px; height: 375px; background: white; float: left; margin-left: 18px;">
			<table id="table">
			<tr>
			<th width="250" style="background: #585b68; color: white; border: none; height: 30px;">결재자를 선택하세요.</th>
			</tr>
			</table>
			<select multiple="multiple" style="height: 345px; width: 250px; border: none;" id="linel">
			<%for (Employee ee : elist){ %>
			<option style="padding: 5px; border-top: 1px solid #eee;" value="<%= ee.getEmpNo()%>" id="lineop">
			<%=ee.getEmpId()%> <%= ee.getEmpName() %> &nbsp;&nbsp;&nbsp;
			</option>
			<%} %>
			</select>
			</div>
			<div style="width: 248px; height: 375px; background: white; float: right; margin-right: 18px;" >
			<table style="border: none;" id="table">
			<tr>
			<th width="250" style="background: #585b68; color: white; border: none; height: 30px;">선택된 결재자</th>
			</tr>
			</table>
			<select multiple="multiple" style="height: 345px; width: 248px; border: none;" id="liner">
				
			</select>
			</div>
			<div style="position: absolute; left: 280px; top: 130px;">
			<input type="button" value="▶" class="btn btn-primary btn-icon-split btn-sm" style="padding: 10px; margin-bottom: 2px;" id="abtn">			
			<br><br><br><br><br>
			<input type="button" value="◀" class="btn btn-secondary btn-icon-split btn-sm" style="padding: 10px; margin-bottom: 2px;" id="bbtn"> 
			</div>
			<div style="margin-top: 447px;">
			<div style="position: absolute; left: 18px; top: 425px;">
			<input type="button" id="bring" value=" 결재선 불러오기 " class="btn btn-secondary btn-icon-split" style="padding: 7px; ">
			<input type="button" id="save" value=" 저장하기 " style="margin-left: 15px; padding: 7px;" class="btn btn-primary btn-icon-split" >
			</div>
			<div style="position: absolute; right: 70px; top: 425px;">
			<input type="button" value=" 선 택 " class="btn btn-primary btn-icon-split" style="padding: 7px; margin-right: 20px;" id="sendbtn">
			<input type="button" value=" 취 소 " id="cancel" class="btn btn-secondary btn-icon-split" style="padding: 7px; "> 
			</div>
			</div>
			</div>

		<!-- <div id="dp" style="position: absolute; display: block; width: 600px; height: 300px; background: #eaecf1; 
			left: 15%; top: 3%; border-radius: 5px; padding-top: 15px;  border: 1px solid #ddd;">
		
		
		</div>	 -->	
<form action="/hiapt/dsend" method="post" id="frm" enctype="multipart/form-data">

<div class="row" style="margin-left: 2px;">
		<input type="button" value=" 기안하기 " class="btn btn-primary btn-icon-split" id="savebutton"
		style="padding: 7px;">
		 
		<input type="button" value=" 임시저장 " class="btn btn-secondary btn-icon-split" id="tempbutton"
		style="padding: 7px; margin-left: 25px;">&nbsp;&nbsp;
</div>
<br>
<div id="form">

<input type="hidden" name="docstatus" value="0">
<input type="hidden" name="approver" id="approver" style="width: 600px;">

<fieldset style="border: none">
<legend>기본 설정<br></legend> 
<table style="width:900px; height: 50px;" id="tab">
<tr><th style=" width: 120px;">문서 종류</th>
<td width="415px;" style="padding-bottom: 8px;" colspan="3">
<select name="formtype" id="formselect">
<option>공용</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;
<select name="formcode" id="formselect2">
<option value="none" selected="selected">양식 선택</option>
<% for (int i = 0; i < flist.size(); i++) { 
	 Formbox f = flist.get(i); %>
<option value="<%= f.getFormcode() %>"><%= f.getFormname() %></option>
<% } %>

</select> 
&nbsp;&nbsp;&nbsp;
<input type="button" onclick="formview();" 
class="btn btn-secondary btn-icon-split btn-sm" style="padding: 4px; margin-bottom: 5px;" value="문서선택">
</td>
<th style="width: 120px;">작성자</th>
<td width="120px;" style="width: 120px;">
<input type="hidden" name="drafter" value="<%= emp.getEmpNo()%>" 
style = "width: 100px; border: none; background: none; text-align: center; margin-top: 1px;">
<%= emp.getEmpId() %>  <%= emp.getEmpName() %>
</td>
</tr>

<tr id="tab2">
<th style="padding: 1px;">
<input id="appline" type="button" value="결재선 지정" class="btn btn-primary btn-icon-split btn-sm" style="padding: 10px;">
</th>
<td colspan="5" id="td">
</td>
</tr>
<tr>
<th>공람자 지정</th>
<td colspan="5" id="td2">
<input type="hidden" name="display">
<select id="displaysel" multiple="multiple" style="width: 750px;">
<% for(Employee e : elist) {%>
<option value="<%= e.getEmpNo() %>"><%= e.getEmpId() %> <%= e.getEmpName() %></option>
<%} %>
</select>
</td>
</tr>
<tr><th>기한 설정</th>
<td colspan="5">
<input type="date" name="deadline" id="deadline" class="form-control form-control-sm"
style="width: 750px; border-radius: 3px; margin-left: 13px; border: solid 0.5px #444;"
value="<%= sysdate %>" >
</td>
</tr>
</table>
</fieldset>


<br>

<br>
<fieldset>
<legend>상세 설정</legend>
</fieldset>

<input type="text" id="title" placeholder="제목 입력" name= "drafttitle" 
style="width: 900px; height: 35px; border: solid 1px #afafaf; border-radius: 5px; padding-left: 10px;">

<div style="width:900px; height:750px; background-color: white; margin-top: 15px;">
<textarea name="doccontent" id="smarteditor" rows="10" cols="100" style="width:897px; height:700px;">
</textarea>
</div>
</div>
<fieldset style="margin-top: 20px;">
<legend>파일 첨부</legend> *파일은 20mb까지만 첨부 가능합니다.
<input type="file" style="float: left;" name="draftup" >
</fieldset><br>
</form>
</div></div>

<!---//// 본문 내용 끝 ///////------------------->
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

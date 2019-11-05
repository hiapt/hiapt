<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>HIAPTProject</title>

	<!-- Custom fonts for this template-->
	<link href="/hiapt/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">	
	<!-- Custom styles for this template-->
	<link href="/hiapt/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="/hiapt/resources/css/basic.css" rel="stylesheet">
	
	<script src="/hiapt/resources/js/jquery-3.4.1.min.js"></script>

<!--// css or jQuery or javaScript 삽입 부분    -->
<script type="text/javascript">
function validation(){
	return true;	
}

//당월부과액 합계 내는 함수
$(document).ready(function(){
	$("#button_sum").click(function(){
		var sum = 0;
		$(".price").each(function(){
			sum += Number($(this).val().replace(/[^\d]+/g,''));			
			console.log("sum : " + sum + ", type: " + typeof(sum));			
		});
		
		sum = String(sum);
		$(".amount").val(inputNumberWithComma(sum));	
		console.log(sum + typeof(sum));
	});
	
	
});
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
<h1 class="h3 mb-4 text-gray-800">관리비 등록</h1>			
<!--///////본문 내용 시작 ///////-------->	
<div class="card shadow mb-4">
<div class="card-body">		

<form action="/hiapt/imin" method="post" onclick="return validation();" id="form">
<div class="card-title" style="float:right;">							          
			<input type="submit" value="저장" class="btn btn-sm btn-danger shadow-sm">&nbsp;
			<input type="reset" value="취소" class="btn btn-sm btn-secondary shadow-sm" >&nbsp;
			<a href="javascript:history.go(-1);" class="btn btn-sm btn-primary shadow-sm" >이전페이지로 이동</a>&nbsp;
			<br>
		</div>
	
	<input type="file" id="my_file_input" />
    <div id='my_file_output'></div>


<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.10.3/xlsx.full.min.js"></script>
<!-- <script lang="javascript" src="dist/xlsx.full.min.js"></script> -->
<script>
 
var rABS = true; // T : 바이너리, F : 어레이 버퍼
 
// 어레이 버퍼를 처리한다 ( 오직 readAsArrayBuffer 데이터만 가능하다 )
function fixdata(data) {
    var o = "", l = 0, w = 10240;
    for(; l<data.byteLength/w; ++l) o+=String.fromCharCode.apply(null,new Uint8Array(data.slice(l*w,l*w+w)));
    o+=String.fromCharCode.apply(null, new Uint8Array(data.slice(l*w)));
    return o;
}
 
// 데이터를 바이너리 스트링으로 얻는다.
function getConvertDataToBin($data){
    var arraybuffer = $data;
    var data = new Uint8Array(arraybuffer);
    var arr = new Array();
    for(var i = 0; i != data.length; ++i) arr[i] = String.fromCharCode(data[i]);
    var bstr = arr.join("");
 
    return bstr;
}
function handleFile(e) {
    var files = e.target.files;
    var i,f;
    for (i = 0; i != files.length; ++i) {
        f = files[i];
        var reader = new FileReader();
        var name = f.name;
 
        reader.onload = function(e) {
            var data = e.target.result;
 
            var workbook;
 
            if(rABS) {
                /* if binary string, read with type 'binary' */
                workbook = XLSX.read(data, {type: 'binary'});
            } else {
                /* if array buffer, convert to base64 */
                var arr = fixdata(data);
                workbook = XLSX.read(btoa(arr), {type: 'base64'});
            }//end. if
 
            /* 워크북 처리 */
            workbook.SheetNames.forEach(function(item, index, array) {
 
                // CSV
                var csv = XLSX.utils.sheet_to_csv(workbook.Sheets[item]); // default : ","
                var csvToFS = XLSX.utils.sheet_to_csv(workbook.Sheets[item], {FS:"\t"} ); // "Field Separator" delimiter between fields
                var csvToFSRS = XLSX.utils.sheet_to_csv(workbook.Sheets[item], {FS:":",RS:"|"} ); // "\n" "Record Separator" delimiter between rows
 
                // html
                var html = XLSX.utils.sheet_to_html(workbook.Sheets[item]);
                var htmlHF = XLSX.utils.sheet_to_html(workbook.Sheets[item], {header:"<html><title='ImposeView'><body><table class='table table-bordered'>", footer:"</table><body></html>"});
                var htmlTable = XLSX.utils.sheet_to_html(workbook.Sheets[item], {header:"<table class='table table-bordered'>", footer:"</table>"});
 
                // json
                var json = XLSX.utils.sheet_to_json(workbook.Sheets[item]);
 
                //formulae
                var formulae = XLSX.utils.sheet_to_formulae(workbook.Sheets[item]);
                formulae.filter(function(v,i){return i%13 === 0;});
 
                console.group("CSV");
                    console.log(csv);
                    console.log(csvToFS);
                    console.log(csvToFSRS);
                console.groupEnd();
 
                console.group("html");
                    console.log(html);
                    console.log(htmlHF);
                    console.log(htmlTable);
                console.groupEnd();
 
                console.group("json");
                    console.log(json);
                console.groupEnd();
 
                console.group("formulae");
                    console.log(formulae);
                console.groupEnd();
 
                $("#my_file_output").html(htmlTable);
            });//end. forEach
        }; //end onload
 
        if(rABS) reader.readAsBinaryString(f);
        else reader.readAsArrayBuffer(f);
 
    }//end. for
}
 
var input_dom_element;
$(function() {
    input_dom_element = document.getElementById('my_file_input');
    if(input_dom_element.addEventListener) {
        input_dom_element.addEventListener('change', handleFile, false);
    }
});
 
//http://sheetjs.com/
//https://github.com/SheetJS/js-xls
</script>
 

</form>

</div></div>
      

<!---//// 본문 내용 끝 ///////------------------->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<!---//// 본문 내용 끝 ///////------------------->
			<!-- footer 시작 -->
			<%@ include file="../../common/empfooter.html"%>
			<!-- footer 시작 -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<!--========================================================================================== -->
	<!-- top 버튼 -->
	<%@ include file="../../common/topbutton.html"%>
	<!--========================================================================================== -->
	
	



</body>
</html>
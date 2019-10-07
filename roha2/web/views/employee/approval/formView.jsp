<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문서미리보기</title>

<style type="text/css">

body{
text-align: center;
background-color: #fbfbf0;
font-size: 12pt;
}

select, option{
font-size: 10pt;
width: 600px;
}

textarea {
	border-radius: 10px;
}

</style>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/css/select2.min.css" rel="stylesheet" />
</head>
<body>
<div align="center" id="title"><h2>문서양식 미리보기</h2></div>
<form>
<div>
<h3>문서양식 선택</h3>
<select class="form-control" >
<option>공용 - 일반 기안서</option>
<option>공용 - 휴가 신청서</option>
<option>업무일지 - 직원 업무 일지</option>
<option>업무일지 - 관리자 업무 일지</option>
<option>기타문서 - 기타1</option>
<option>기타문서 - 기타2</option>
<option>기타문서 - 기타3</option>
<option>기타문서 - 기타4</option>
<option>기타문서 - 기타5</option>
<option>기타문서 - 기타6</option>
<option>기타문서 - 기타7</option>
<option>기타문서 - 기타8</option>
<option>기타문서 - 기타9</option>
<option>기타문서 - 기타11</option>
<option>기타문서 - 기타12</option>
<option>기타문서 - 기타13</option>
<option>기타문서 - 기타14</option>
<option>기타문서 - 기타15</option>
</select>
</div>
<div>
<h3>미리보기</h3>
<textarea readonly="readonly" style="resize: none;" cols="88" rows="25">

</textarea>
</div>
<div>
<button>선택</button>
<button>취소</button>
</div>


</form>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- select2 javascript cdn -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.9/js/select2.min.js"></script>
<script>
// select2 초기화
$('select').select2();
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ******************************************************************************** -->
<script type="text/javascript">
   function Init()
   {
      
         <% for(Employee emp : list){ %>
         <% if(!loginEmp.getEmpId().equals(emp.getEmpId())){ %>
         document.form.allowList.options.add(new Option("<%= emp.getDeptName() %> <%= emp.getJobName() %>  <%= emp.getEmpName() %>" , "<%= emp.getEmpId() %>,<%= emp.getEmpName() %>, <%= emp.getJobName() %>"));
         <% } %>
         <% } %>
   }

   function Add(sel)
   {
         //복사
     var count = document.form.denyList.length;
        if(count <= 2){ /*  전자결재 인원추가 제한 설정 */ 
         var selectedItem = sel.options[sel.options.selectedIndex];
      document.form.denyList.options.add(new Option(selectedItem.text, selectedItem.value));
        
         //삭제
         sel.options.remove(sel.options.selectedIndex);
    } 
   }

 

   function Remove(sel)
   {
         var selectedItem = sel.options[sel.options.selectedIndex];
         document.form.allowList.options.add(new Option(selectedItem.text, selectedItem.value));
         //삭제
         sel.options.remove(sel.options.selectedIndex);
         
   }

   <script type="text/javascript">
   function selectAll()
   {
        var form = document.form;
        var count = form.denyList.length;
        var value = "";
        var option = "";
       /* 선택취소시 취소된것 초기화시키기 */
        document.getElementById("pInput0").innerHTML = "";
        document.getElementById("pInput3").innerHTML = "";
        document.getElementById("in0").value = "";
        document.getElementById("pInput1").innerHTML = "";
        document.getElementById("pInput4").innerHTML = "";
        document.getElementById("in1").value = "";
        document.getElementById("pInput2").innerHTML = "";
        document.getElementById("pInput5").innerHTML = "";
        document.getElementById("in2").value = "";
        /* 선택값을 넣어서 서블릿으로 보내주기 */
        for(var i=0; i < count; i++ ){
             value = form.denyList.options[i].value + " ";
             option = form.denyList.options[i].text + " ";
             data = value.split(",");
             
             if(i == 0){
             document.getElementById("pInput0").innerHTML = data[2];
            document.getElementById("pInput3").innerHTML = data[1];
            document.getElementById("in0").value = data[0];
             }
             if(i == 1){
             document.getElementById("pInput1").innerHTML = data[2];
             document.getElementById("pInput4").innerHTML = data[1];
             document.getElementById("in1").value = data[0];
             }
             if(i == 2){
             document.getElementById("pInput2").innerHTML = data[2];
            document.getElementById("pInput5").innerHTML = data[1];
            document.getElementById("in2").value = data[0];
             }
        }
        modal.style.display = "none";
   /*      alert("SelectBox value는:" + value);
        alert("SelectBox option은:" + option);
    */
   }
   </script>
   
   <body onload="Init();">

<form name="form">
             <table align="center" width="500">
             <thead>
              <tr>
               <td width="150"><h5>&nbsp;직원목록</h5></td>
               <td width="50">&nbsp;</td>
               <td width="150"><h5>&nbsp;선택목록&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <font color="blue">(최대3인)</font></h5></td>
              </tr>
                </thead>
                 <tbody id="myTable">
              <tr>
               <td><select id="allowList" size="10" ondblclick="Add(this)" style="width:200px; height:250px;"></select></td>
               <td>&nbsp;</td>
               <td><select id="denyList" size="10" ondblclick="Remove(this)" style="width:200px; height:250px;"></select></td>
              </tr>
              </tbody>
       </table>
  </form>
<!-- ******************************************************************************** -->
</body>
</html>
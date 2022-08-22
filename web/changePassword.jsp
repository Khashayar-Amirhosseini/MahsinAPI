<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 7/17/2022
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>تغییر رمز عبور</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<form id="form1" >
    <div class="col-3" style="margin: auto;text-align: center">
        <div class="mb-3" >
            <label for="Input1" class="form-label" >رمز عبور</label>
            <input id="Input1" type="password" name="pass1" class="form-control"  >
        </div>
        <div class="mb-3">
            <label for="Input2" class="form-label">تکرار رمز عبور</label>
            <input id="Input2" type="password" name="pass2" class="form-control"  >
        </div>
        <button type="button" style="margin: auto;" class="btn btn-primary" onclick="sendForm()">ثبت</button>
    </div>


</form>
</body>
</html>
<script>
    const sendForm=()=>{
        let securityKey=null;
        const params = new URLSearchParams(window.location.search);
         securityKey=params.get("securityKey");
         const pass1= document.getElementById('form1')[0].value;
         const pass2= document.getElementById('form1')[1].value;
         console.log(securityKey)
         if(pass1.length<6){
             alert("تعداد کاراکتر رمز عبور نباید کمتر از 6 باشد.");
             return
         }
         if(pass1===pass2){
             var data = new FormData();
             data.append('pass', pass1);
             data.append('key', securityKey);
             var xhr = new XMLHttpRequest();
             xhr.open('POST', "action/retrievePassword.do", true);
             xhr.onload = function () {
                 if (xhr.response==="password retrieved"){
                 alert("رمز عبور شما با موفقیت بازیابی شد.");}
                 else {
                     alert("تشخیص هویت ناموفق بود")
                 }
             };
             xhr.send(data);

         }
         else{
             alert("رمز عبور های وارد شده باهم انطباق ندارند.");
         }
    }
</script>
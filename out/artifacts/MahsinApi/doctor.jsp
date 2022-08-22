<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/14/2022
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doctor</title>

</head>
<body>
<h1>save doctor</h1>
<form action="/action/doctor/saveDoctor.do" method="post" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="family" placeholder="family">
    <input type="number" name="medicalId" placeholder="medicalId">
    <input type="text" name="about" placeholder="about">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form><br/>

<%--<form action="/action/admin/savefile" method="post" enctype="multipart/form-data">
    Select File: <input type="file" name="file"/>
    <input type="submit" value="Upload File"/>
</form>--%>

<h1>update doctor</h1>
<form action="/action/doctor/updateDoctor.do" method="post" enctype="multipart/form-data">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="family" placeholder="family">
    <input type="number" name="medicalId" placeholder="medicalId">
    <input type="text" name="about" placeholder="about">
    <input type="text" name="state" placeholder="state">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form><br/>
<h1>find one</h1>
<form action="/action/guest/findOnDoctor.do">
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form><br/>

<h1>find All</h1>
<form action="/action/guest/findAllDoctors.do" >
    <input type="text" name="accessToken" placeholder="accessToken">
    <button type="submit">submit</button>
</form><br/>
<h1>Show Doctor Picture</h1>
<form action="/action/guest/getDoctorPicture.do">
    <input type="number" name="doctorId" placeholder="doctorId">
    <input type="text" name="accessToken" placeholder="accessToken">
    <button type="submit">submit</button>
</form><br/>
<h1>Delete Doctor</h1>
<form action="/action/admin/deleteDoctor.do">
    <input type="number" name="doctorId" placeholder="doctorId">
    <button type="submit">submit</button>
</form><br/>


</body>




</html>

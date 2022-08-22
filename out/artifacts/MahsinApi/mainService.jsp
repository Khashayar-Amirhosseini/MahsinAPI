<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/16/2022
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainService</title>
</head>
<body>
<form action="/action/admin/saveMainService.do" method="post" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="description" placeholder="description">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updateMainService.do" method="post" enctype="multipart/form-data">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="description" placeholder="description">
    <input type="text" name="state" placeholder="state">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOneMainService.do" >
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllMainServices.do">
    <button type="submit">submit</button>
</form>
<h1>delete</h1>
<form action="/action//admin/deleteMainService.do">
    <input type="number" name="mainServiceId" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>getPicture</h1>
<form action="/action/guest/getMainServicPicture.do">
    <input type="number" name="mainServiceId" placeholder="id">
    <button type="submit">submit</button>
</form>

</body>
</html>

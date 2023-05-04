<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/16/2022
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service</title>
</head>
<body>
<h1>save</h1>
<form action="/action/admin/saveService.do">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="description" placeholder="description">
    <input type="number" name="mainServiceId" placeholder="mainServiceId">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updateService.do">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="description" placeholder="description">
    <input type="number" name="mainServiceId" placeholder="mainServiceId">
    <input type="text" name="state" placeholder="state">
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOneService.do">
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllServices.do">
    <button type="submit">submit</button>
</form>
<h1>delete </h1>
<form action="/action/admin/deleteService.do">
    <input type="number" name="serviceId" placeholder="id">
    <button type="submit">submit</button>
</form>
</body>
</html>

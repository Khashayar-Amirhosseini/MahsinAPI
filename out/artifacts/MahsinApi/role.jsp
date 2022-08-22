<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 7/5/2022
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Role</title>
</head>
<body>
<form action="/action/role/saveRole.do">
    <input type="text" name="roleName" placeholder="roleName">
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>

<h1>find one</h1>
<form action="/action/role/findAllRoles.do" >
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/role/findAllRoles.do">
    <button type="submit">submit</button>
</form>
<h1>delete</h1>
<form action="/action/role/deleteRole.do">
    <input type="number" name="roleId" placeholder="id">
    <button type="submit">submit</button>
</form>
</body>
</html>

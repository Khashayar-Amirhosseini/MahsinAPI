<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/14/2022
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>policy</title>
</head>
<body>
<h1>save</h1>
<form action="/action/admin/savePolicy.do">
    <input type="text" name="description" placeholder="description">
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updatePolicy.do">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="description" placeholder="description">
    <input type="text" name="state" placeholder="state">
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOnePolicy.do">
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllPolicies.do">
    <button type="submit">submit</button>
</form>
<h1>delete one</h1>
<form action="/action/admin/deletePolicy.do">
    <input type="number" name="policyId" placeholder="policyId">
    <button type="submit">submit</button>
</form>

</body>
</html>

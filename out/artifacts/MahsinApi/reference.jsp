<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/30/2022
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reference</title>
</head>
<body>
<form action="/action/admin/saveReference.do" method="post">
    <input type="text" name="value" placeholder="subtitle">
    <input type="text" name="postId" placeholder="postId">
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updateReference.do" method="post">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="value" placeholder="subtitle">
    <input type="text" name="postId" placeholder="postId">
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOneReference.do" >
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllReferences.do">
    <button type="submit">submit</button>
</form>
<h1>delete</h1>
<form action="/action/admin/deleteReference.do">
    <input type="number" name="referenceId" placeholder="id">
    <button type="submit">submit</button>
</form>

</body>
</html>

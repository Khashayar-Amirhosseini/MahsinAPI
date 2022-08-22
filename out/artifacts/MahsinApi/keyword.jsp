<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/30/2022
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>keyword</title>
</head>
<body>
<form action="/action/admin/saveKeyword.do" method="post" enctype="multipart/form-data">
    <input type="text" name="value" placeholder="subtitle">
    <input type="number" name="postId" placeholder="postId">
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updateKeyword.do" method="post" enctype="multipart/form-data">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="value" placeholder="subtitle">
    <input type="number" name="postId" placeholder="postId">
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOneKeyword.do" >
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action//guest/findAllKeywords.do">
    <button type="submit">submit</button>
</form>
<h1>delete</h1>
<form action="/action/admin/deleteKeyword.do">
    <input type="number" name="keywordId" placeholder="id">
    <button type="submit">submit</button>
</form>
</body>
</html>

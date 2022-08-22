<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/30/2022
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Paragraph Picture</title>
</head>
<body>
<form action="/action/admin/saveParaghraphPic.do" method="post" enctype="multipart/form-data">
    Select File: <input type="file" name="file"/>
    <input type="number" name="postId" placeholder="postId">>
    <button type="submit">submit</button>
</form>

<h1>find one</h1>
<form action="/action/guest/findOneParagraphPic.do" >
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllParagraphsPic.do">
    <button type="submit">submit</button>
</form>
<h1>delete</h1>
<form action="/action/admin/deleteParagraphPic.do">
    <input type="number" name="paragraphId" placeholder="id">
    <button type="submit">submit</button>
</form>

</body>
</html>

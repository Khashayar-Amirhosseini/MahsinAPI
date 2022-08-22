<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/25/2022
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Picture</title>
</head>
<body>
<h1>save</h1>
<form action="/action/admin/savePicture.do" method="post" enctype="multipart/form-data">
    Select File: <input type="file" name="file"/>
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>
<h1>update</h1>

<h1>find one</h1>
<form action="/action/guest/findOnePicture.do">
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllPictures.do">
    <button type="submit">submit</button>
</form>
<h1>delete one</h1>
<form action="/action/admin/deletePicture.do">
    <input type="number" name="pictureId" placeholder="policyId">
    <button type="submit">submit</button>
</form>

</body>
</html>

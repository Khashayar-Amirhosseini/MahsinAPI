<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/14/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>history</title>
</head>
<body>
<h1>save</h1>
<form action="/action/admin/historySave.do">
    <input type="text" name="description" placeholder="description">
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>
<br/>
<h1>delete</h1>
<form action="/action/admin/historyDelete.do">
    <button type="submit">submit</button>
</form>

<h1>findAll</h1>
<form action="/action/guest/findAllHistory.do">
    <button type="submit">submit</button>
</form>



</body>
</html>

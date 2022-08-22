<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/16/2022
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
</head>
<body>
<%--<h1>save</h1>
<form action="/action/admin/saveFooter.do">
    <input type="text" name="instagram" placeholder="instagram">
    <input type="text" name="telegram" placeholder="telegram">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="tel1" placeholder="tel1">
    <input type="text" name="tel2" placeholder="tel2">
    <input type="text" name="tel3" placeholder="tel3">
    <input type="text" name="address" placeholder="address">
    <input type="text" name="mapSRC" placeholder="mapSRC">
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>--%>
<h1>update</h1>
<form action="/action/admin/updateFooter.do">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="instagram" placeholder="instagram">
    <input type="text" name="telegram" placeholder="telegram">
    <input type="text" name="email" placeholder="email">
    <input type="text" name="tel1" placeholder="tel1">
    <input type="text" name="tel2" placeholder="tel2">
    <input type="text" name="tel3" placeholder="tel3">
    <input type="text" name="address" placeholder="address">
    <input type="text" name="mapSRC" placeholder="mapSRC">
    <input type="number" name="userId" placeholder="userId">
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOneFooter.do">
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllFooters.do">
    <button type="submit">submit</button>
</form>

</body>
</html>

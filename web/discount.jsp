<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 7/31/2022
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DISCOUNT</title>
</head>
<body>
<h1>save</h1>
<form action="/action/discount/saveDiscount.do" method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="description" placeholder="description">
    <input type="text" name="expiredDate" placeholder="expiredDate">
    <input type="number" name="customerId" placeholder="customerId">
    <input type="number" name="userId" placeholder="userId">
    <input type="text" name="code" placeholder="code">
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/discount/updateDiscount.do" method="post">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="description" placeholder="description">
    <input type="text" name="creationDate" placeholder="expiredDate">
    <input type="text" name="expiredDate" placeholder="expiredDate">
    <input type="number" name="userId" placeholder="userId">
    <input type="number" name="customerId" placeholder="customerId">
    <input type="text" name="state" placeholder="state">
    <input type="text" name="code" placeholder="code">
    <button type="submit">submit</button>
    <button type="submit">submit</button>
</form>
<h1>find all by user</h1>
<form action="/action/user/findAllDiscount.do">
    <input type="number" name="customerId" placeholder="customerId">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/discount/findAll.do">
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/discount/findDiscountByCode.do">
    <input type="text" name="code" placeholder="code">
    <button type="submit">submit</button>
</form>
<h1>delete one</h1>
<form action="/action/discount/deleteDiscount.do">
    <input type="text" name="code" placeholder="code">
    <button type="submit">submit</button>
</form>

</body>
</html>

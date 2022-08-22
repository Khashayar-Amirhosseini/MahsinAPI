<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 7/3/2022
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userControl</title>
</head>
<body>
<h1>signup</h1>
<form action="/action/userSignUp.do" method="post">
    <input type="email" name="userName" placeholder="userName">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="family" placeholder="family">
    <input type="tel" name="phoneNumber" placeholder="phoneNumber">
    <input type="password" name="providedPassword" placeholder="password">
    <input type="text" name="birthDay" placeholder="birthDay">
    <input type="text" name="inviterCode" placeholder="inviterCode">
    <button type="submit">submit</button>
</form><br/>

<h1>update</h1>
<form action="/action/user/userEdit.do" method="post">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="userName" placeholder="userName">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="family" placeholder="family">
    <input type="tel" name="phoneNumber" placeholder="phoneNumber">
    <input type="password" name="providedPassword" placeholder="password">
    <button type="submit">submit</button>
</form><br/>

<h1>changePassword</h1>
<form action="/action/user/changePassword.do" method="post">
    <input type="number" name="id" placeholder="id">
    <input type="password" name="oldPassword" placeholder="oldPassword">
    <input type="password" name="newPassword" placeholder="newPassword">
    <button type="submit">submit</button>
</form><br/>
<h1>forgotPassword</h1>
<form action="/action/forgotPassword.do" method="post" >
    <input type="text" name="userName" placeholder="userName">
    <button type="submit">submit</button>
</form><br/>

<h1>retrievePassword</h1>
<form action="/action/retrievePassword.do" method="post" >
    <input type="text" name="key" placeholder="key">
    <input type="text" name="pass" placeholder="pass">
    <button type="submit">submit</button>
</form><br/>

<h1>find All</h1>
<form action="/action/management/userFindAll.do" >
    <button type="submit">submit</button>
</form><br/>



</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/14/2022
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>like</title>

</head>
<body>
<h1>Doctor Action</h1>
<form action="/action/user/userLikes.do">
    <input type="number" name="userId" placeholder="userId">
    <input type="number" name="doctorId" placeholder="doctorId">
    <input type="text" name="actionName" placeholder="actionName">
    <button type="submit">action</button>
</form>
<h1>count of Post Action</h1>
<form action="/action/guest/findLik.do">
    <input type="number" name="doctorId" placeholder="doctorId">
    <input type="text" name="actionName" placeholder="actionName">
    <button type="submit">action</button>
</form>
<h1>Post Action</h1>
<form action="/action/user/userLikesPost.do">
    <input type="number" name="userId" placeholder="userId">
    <input type="number" name="postId" placeholder="postId">
    <input type="text" name="actionName">
    <button type="submit">action</button>
</form>
<h1>count of Post Action</h1>
<form action="/action/guest/findLikesByPost.do">
    <input type="number" name="postId" placeholder="postId">
    <input type="text" name="actionName" placeholder="actionName">
    <button type="submit">action</button>
</form>
<h1>Find All</h1>
</form>
<form action="/action/admin/findAllLikes">
    <button type="submit">submit</button>
</form>

</body>
</html>

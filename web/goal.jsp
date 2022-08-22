<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/15/2022
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Goal</title>
</head>
<body>
<h1>save</h1>
<form action="/action/goal/saveGoal.do" method="post" enctype="multipart/form-data">
    <input type="text" name="description"  placeholder="description">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updateGoal.do" method="post" enctype="multipart/form-data">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="description" placeholder="description">
    <input type="text" name="state" placeholder="state">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>delete</h1>
<form action="/action/admin/deleteGoal.do">
    <input type="number" name="goalId" placeholder="goalId">
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOneGoal.do">
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllGoals.do">
    <button type="submit">submit</button>
</form>
<h1>Show Goal Picture</h1>
<form action="/action/guest/getGoalPicture.do">
    <input type="number" name="goalId" placeholder="goalId">
    <button type="submit">submit</button>
</form><br/>

</body>
</html>

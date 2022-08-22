<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/15/2022
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Facility</title>
</head>
<body>
<h1>save</h1>
<form action="/action/admin/saveFacility.do" method="post" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="utility" placeholder="utility">
    <input type="text" name="description" placeholder="description">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updateFacility.do" method="post" enctype="multipart/form-data" >
    <input type="number" name="id" placeholder="id">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="utility" placeholder="utility">
    <input type="text" name="description" placeholder="description">
    <input type="text" name="state" placeholder="state">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOneFacility.do">
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllFacilities.do">
    <button type="submit">submit</button>
</form>
<h1>delete one</h1>
<form action="/action/admin/deleteFacility.do">
    <input type="number" name="facilityId" placeholder="id">
    <button type="submit">submit</button>
</form>

<h1>Show facility Picture</h1>
<form action="/action/guest/getFacilityPicture.do">
    <input type="number" name="facilityId" placeholder="id">
    <button type="submit">submit</button>
</form>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: My Dude
  Date: 4/30/2022
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>post</title>
</head>
<body>
<form action="/action/blogger/savePost.do" method="post" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="abstractParagraph" placeholder="abstract">
    <input type="text" name="paragraph" placeholder="paragraph">
    <input type="text" name="writer" placeholder="writer">
    <input type="number" name="userId" placeholder="userId">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>update</h1>
<form action="/action/admin/updatePost.do" method="post" enctype="multipart/form-data">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="abstractParagraph" placeholder="abstract">
    <input type="text" name="paragraphs" placeholder="paragraphs">
    <input type="text" name="writer" placeholder="writer">
    <input type="number" name="userId" placeholder="userId">
    <input type="text" name="state" placeholder="state">
    Select File: <input type="file" name="file"/>
    <button type="submit">submit</button>
</form>
<h1>find one</h1>
<form action="/action/guest/findOnePost.do" >
    <input type="number" name="id" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>find all</h1>
<form action="/action/guest/findAllPosts.do">
    <button type="submit">submit</button>
</form>
<h1>delete</h1>
<form action="/action//admin/deletePost.do">
    <input type="number" name="postId" placeholder="id">
    <button type="submit">submit</button>
</form>
<h1>getPicture</h1>
<form action="/action/guest/getPostPicture.do">
    <input type="number" name="postId" placeholder="id">
    <button type="submit">submit</button>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2/7/23
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Book</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">

</head>
<body style="background: #ad8a6c">
<div class="row">
    <div class="col-md-10 offset-1">
        <h1 class="text-center">Delete Book Page</h1>
        <form method="post" action="/book/delete/${book.getId()}">
            <input type="hidden" name="id" value="${book.getId()}">
            <div class="alert alert-danger">
                <p>Are you sure delete user <i>${book.getTitle()} ${book.getAuthor()}</i></p>
            </div>
            <a href="/book" class="btn btn-success">Back</a>
            <button type="submit" class="btn btn-primary">Yes</button>
        </form>
    </div>
</div>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
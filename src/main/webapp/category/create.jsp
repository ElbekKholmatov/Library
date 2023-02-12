<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2/8/23
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Category Adding</title>
    <jsp:include page="/fragments/css.jsp"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">

</head>
<body style="background: #ad8a6c">2
<div class="row">
    <div class="col-md-10 offset-1">
        <h1 class="text-center">Category Create Page</h1>
        <form method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <button type="submit" class="btn btn-primary">Save Category </button>
        </form>
    </div>
</div>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

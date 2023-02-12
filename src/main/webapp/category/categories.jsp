<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 09/02/23
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Categories</title>
    <jsp:include page="/fragments/css.jsp"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>
<div class="container">
    <div class="row">
        <a href="/category/add" class="btn btn-success">Add</a>
        <div class="books_list">
            <c:forEach items="${categories}" var="category">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${category.getName()}</h5>
                    </div>
                    <div class="card-body">
                        <a href="/category/update/${category.getId()}" class="card-link">Update</a>
                        <a href="/category/delete/${category.getId()}" class="card-link">Delete</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2/12/23
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<head>
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Home</h1>
    <p>Home page</p>
    <div class="search-bar">
        <input type="text" name="search" id="search" list="search_list" autocomplete="on">
        <datalist id="search_list">
            <c:forEach items="${books}" var="book">
                <option value="${book.getId()}">${book.getTitle()} by ${book.getAuthor()}</option>
            </c:forEach>
        </datalist>
    </div>
    <p><a href="/user/sign_up.jsp">Login</a></p>
</body>
</html>

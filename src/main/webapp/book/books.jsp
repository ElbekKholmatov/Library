
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 09/02/23
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
    <jsp:include page="/fragments/css.jsp"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>
<form method="post">
<div class="container">
    <div class="row">
        <a href="/book/add" class="btn btn-success">Add</a>
        <a href="/admin" class="btn btn-success">Main</a>
        <div class="books_list">
            <c:forEach items="${books}" var="book">
                <div class="card">
                    <img src="/download?filename=${book.getCoverGeneratedFileName()}" width="180px" height="280px" class="card-img-top" alt="${book.getCoverOriginalFileName()}" loading="lazy" />
                    <div class="card-body">
                        <h3 class="book_title">${book.getTitle()}</h3>
                        <h6 class="book_author">Author:${book.getAuthor()}</h6>

                        <p class="card-text">${book.getDescription()}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Published by ${book.getPublisher()}</li>
                        <li class="list-group-item">Published at ${book.getPublishedAt()}</li>
                        <li class="list-group-item">Page count${book.getPages()}</li>
                        <li class="list-group-item">📥${book.getDownloads()}</li>
                        <li class="list-group-item">👁️${book.getViews()}</li>
                        <li class="list-group-item">🖤${book.getLikes()}</li>
                        <li class="list-group-item">💔${book.getDislikes()}</li>
                    </ul>
                    <div class="card-body">
                        <a href="/book/update/${book.getId()}" class="card-link">Update</a>
                        <a href="/book/delete/${book.getId()}" class="card-link">Delete</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</form>

<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Update Category</title>
    <jsp:include page="/fragments/css.jsp"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<h1 class="text-center" style="margin-top: 30px; margin-bottom: 30px">Fill in the category form</h1>

<form class="row g-3" method="post">
    <input type="hidden" id="id" name="id" value="${category.getId()}">
    <div class="col-md-5 offset-1">
        <label for="validationServer01" class="form-label">Name</label>
        <input type="text" class="form-control" id="validationServer01" name="name"
               value="${category.getName()}">
    </div>
    <div class="col-12 offset-1">
        <button class="btn btn-primary" type="submit">Submit form</button>
    </div>
</form>
<jsp:include page="/fragments/css.jsp"/>
</body>
</html>
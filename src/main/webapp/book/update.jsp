
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Update Book</title>
    <jsp:include page="/fragments/css.jsp"/>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>

<h1 class="text-center" style="margin-top: 30px; margin-bottom: 30px">Fill in the book form</h1>

<form class="row g-3" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${book.getId()}">
    <input type="hidden" name="old_file_id" value="${book.getCoverId()}">
    <input type="hidden" name="old_image_id" value="${book.getDocumentId()}">
    <div class="col-md-5 offset-1">
        <label for="validationServer01" class="form-label">Title</label>
        <input type="text" class="form-control" id="validationServer01" name="title"
               value="${book.getTitle()}">

    </div>
    <div class="col-md-4 offset-1">
        <label for="validationServer02" class="form-label">Author(s)</label>
        <input type="text" class="form-control is-valid" id="validationServer02" name="author"
               value="${book.getAuthor()}" >
        <div class="valid-feedback">
            Looks good!
        </div>
    </div>

    <div class="col-md-5 offset-1">
        <label for="validationServer03" class="form-label">Publisher</label>
        <input type="text" class="form-control" id="validationServer03" name="publisher"
               aria-describedby="validationServer03Feedback"
               value="${book.getPublisher()}">
        <c:if test="${publisher_error != null}">
            <snap class="small text-danger"><c:out value="${publisher_error}"></c:out></snap>
        </c:if>
        <div id="validationServer03Feedback" class="invalid-feedback">
            Please provide a publisher's name.
        </div>
    </div>

    <div class="col-md-4 offset-1">
        <select class="form-select"   aria-label="select example" style="margin-top: 30px" id="category_id"
                name="category_id">
            <option value="${currentCategory.getId()}">${currentCategory.getName()}</option>
            <c:forEach items="${categories}" var="category">
                <option value="${category.getId()}">${category.getName()}</option>
            </c:forEach>
        </select>
        <div class="invalid-feedback">Example invalid select feedback</div>
    </div>

    <div class="col-md-10 offset-1" style="margin-bottom: 10px">
        <label for="validationTextarea1" class="form-label">Description</label>
        <textarea class="form-control " rows="3" id="validationTextarea1" name="description"
                  placeholder="Write the description of the book here">${book.getDescription()}</textarea>
        <div class="invalid-feedback">
            field
        </div>
    </div>

    <div class="col-sm-2 offset-1">
        <label for="date" class="form-label">Date of publication</label>
        <div class="input-group date" id="datepicker">
            <input type="date" class="form-control" id="date" name="publishedAt" value="${book.getPublishedAt()}" />
            <i class="fa fa-calendar"></i>
        </div>
    </div>

    <div class="col-md-3 offset-1">
        <label for="image" class="form-label">Upload the Image File</label>
        <input type="file" class="form-control" id="image" name="image" aria-label="file example"  >
        <div class="invalid-feedback">Example invalid form file feedback</div>
    </div>

    <div class="col-md-3 offset-1">
        <label for="file" class="form-label">Upload the PDF File</label>
        <input type="file" class="form-control" id="file" name="file" aria-label="file example"  >
        <div class="invalid-feedback">Example invalid form file feedback</div>
    </div>
    <div class="col-12 offset-1">
        <div class="form-check">
            <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3"
                   aria-describedby="invalidCheck3Feedback"  >
            <label class="form-check-label" for="invalidCheck3">
                <a href="">Agree to terms and conditions</a>
            </label>
            <div id="invalidCheck3Feedback" class="invalid-feedback">
                You must agree before submitting.
            </div>
        </div>
    </div>
    <div class="col-12 offset-1">
        <button class="btn btn-primary" type="submit">Submit form</button>
    </div>
</form>
<jsp:include page="/fragments/css.jsp"/>
</body>
</html>
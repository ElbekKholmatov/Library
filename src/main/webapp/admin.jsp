<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<%--    <jsp:include page="/fragments/css.jsp"/>--%>
    <style>

        @import url('https://fonts.googleapis.com/css2?family=Sriracha&display=swap');

        body {
            margin: 0;
            box-sizing: border-box;
        }

        .navbar {
            margin-right: 20px;
            overflow: hidden;
            background-color: #2f2c2c;
        }

        .navbar a {
            float: left;
            font-size: 10px;
            font-weight: bold;
            color: #6610f2;
            text-align: center;
            /*padding: 5px 5px;*/
            text-decoration: none;
        }

        .navbar a:hover{
            background-color: black;
        }

        .dropdown-content a {
            font-size: 17px;
            float: none;
            color: #ffffff;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: #052341;
        }


        /* CSS for header */
        .header {
            display: flex;
            justify-content: space-between;
            width: 100%;
            height: 7%;
            align-items: center;
            background-color: #1a1d20;
        }

        .header .logo {
            font-size: 20px;
            font-family: 'Sriracha', cursive;
            color: #000;
            text-decoration: none;
            margin-left: 30px;

        }


        .nav-items a {
            font-family: Garamond, serif;
            font-weight: bold;
            text-decoration: none;
            font-size: 30px;
            color: #1c1616;
            padding: 35px 20px;
        }

        /* CSS for main section */
        .intro {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 82%;
            background: linear-gradient(to bottom, rgba(0, 0, 0, 0.5) 0%, rgba(0, 0, 0, 0.5) 100%), url("/resources/img/main-bg.jpg");
            background-size: cover;


        }

        .intro h1 {
            font-family: sans-serif;
            font-size: 30px;
            color: #fff;
            font-weight: bold;
            text-transform: uppercase;
            margin: 0;
        }

        .intro p {
            font-size: 20px;
            color: #d1d1d1;
            text-transform: uppercase;
            margin: 20px 0;
        }

        .intro button {
            background-color: #5edaf0;
            color: #000;
            padding: 10px 25px;
            border: none;
            border-radius: 5px;
            font-size: 20px;
            font-weight: bold;
            cursor: pointer;
            box-shadow: 0px 0px 20px rgba(255, 255, 255, 0.4)
        }

        .achievements {
            display: flex;
            justify-content: space-around;
            align-items: center;
            padding: 40px 80px;
        }


        .achievements .work i {
            width: fit-content;
            font-size: 50px;
            color: #333333;
            border-radius: 50%;
            border: 2px solid #333333;
            padding: 12px;
        }

        .achievements .work .work-heading {
            font-size: 20px;
            color: #333333;
            text-transform: uppercase;
            margin: 10px 0;
        }

        .achievements .work .work-text {
            font-size: 15px;
            color: #585858;
            margin: 10px 0;
        }

        .about-me img {
            width: 500px;
            max-width: 100%;
            height: auto;
            border-radius: 10px;
        }

        .about-me-text h2 {
            font-size: 30px;
            color: #333333;
            text-transform: uppercase;
            margin: 0;
        }

        .about-me-text p {
            font-size: 15px;
            color: #585858;
            margin: 10px 0;
        }

        /* CSS for footer */
        .footer {
        / / footer display: flex;
            justify-content: space-around;
            align-items: center;
            display: flex;
            width: 100%;
            height: 5%;
            padding: 110px 0;
            background-color: #1a1d20;
        }

        .footer .copy {
            color: #fff;
        }

        .bottom-links {
            display: flex;
            justify-content: space-around;
            align-items: center;
            padding: 30px 0;
        }

        .bottom-links .links {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 0 30px;
        }

        .bottom-links .links span {
            font-size: 20px;
            color: #fff;
            text-transform: uppercase;
            margin: 40px 0;
        }

        .bottom-links .links a {
            text-decoration: none;
            color: #a1a1a1;
            padding: 5px 10px;
        }

        .black {
            background-color: #1a1d20;
        }

        .search-bar {
            width: 100px;
            height: 20px;
            border-radius: 20px;
            font-size: 8px;
            padding: 0 5px;
            background-color: white;
            border: none;
            outline: none;
            margin-right: 30px;


        }

        .trns-text {
            background: url("/resources/img/main-bg.jpg") -20px -20px no-repeat;
            -webkit-text-fill-color: transparent;
            -webkit-background-clip: text;
            /* Below is not needed */
            display: block;
            font-size: 20px;
            font-border: 2px solid #000;
            font-family: arial;
            text-align: center;
            margin-top: 10px;
            font-weight: bold;
            letter-spacing: 10px;
            background-size: cover;
        }

    </style>
    <header class="header">
        <div class="logo">
            <img src="/resources/img/logo.png" style="scale: initial; width: 100px; height: 50px;">
        </div>
        <div class="search-bar navbar">
            <input type="text" name="search" id="search" list="search_list" autocomplete="on">
            <datalist id="search_list">
                <c:forEach items="${books}" var="book">
                    <option value="${book.getId()}">${book.getTitle()} by ${book.getAuthor()}</option>
                </c:forEach>
            </datalist>
        </div>
        <div class="navbar">
            <a href="/login">Login</a>
        </div>
        <div class="navbar">
            <a href="/category">Categories</a>
        </div>
        <div class="navbar">
            <a href="/book">Books</a>
        </div>
    </header>
</head>
<body>
<main>
    <div class="intro">
        <h1 class="trns-text">Welcome to Admin Page</h1>

    </div>
</main>
<footer class="footer">
    <div class="bottom-links">
        <div class="links">
            <span>Follow us</span>
            <a href="#"><i class="fa fa-facebook">Facebook</i></a>
            <a href="#"><i class="fa fa-twitter">Twitter</i></a>
            <a href="#"><i class="fa fa-instagram">Instagram</i></a>
            <a href="#"><i class=71)
		at dev.sheengo.library.library.servlets.category.CategoryUpdateServlet.doGet(Cate"fa fa-telegram">Telegram</i></a>
        </div>
        <div class="links">
            <span>Support</span>
            <a href="#">FAQ</a>
            <a href="#">Help</a>
            <a href="#">Contact</a>
        </div>
        <div class="links">
            <span>Legal</span>
            <a href="#">Terms</a>
            <a href="#">Privacy</a>
        </div>
    </div>
</footer>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>
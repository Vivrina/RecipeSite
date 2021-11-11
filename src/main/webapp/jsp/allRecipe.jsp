<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.11.2021
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css.map">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css.map">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.css.map">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css.map">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-reboot.css.map">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-reboot.min.css.map">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-utilities.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-utilities.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-utilities.css.map">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-utilities.min.css.map">



    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/blog.css">
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/allRecipe"/>" method="post" class="form"></form>
<div class="container">
<header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
        <c:set var="isAuth"  value="${isAuth}"/>
        <c:choose>
            <c:when test="${isAuth=='true'}">
                <div class="col-4 pt-1">
                    <a class="link-secondary" href="<c:url value="/signOut"/>">Выйти</a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-4 pt-1">
                    <a class="link-secondary" href="<c:url value="/signIn"/>">Войти</a>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="<c:url value="/start"/>">RecipeSite</a>
        </div>
        <div class="col-4 d-flex justify-content-end align-items-center">
            <a class="link-secondary" href="#" aria-label="Search">
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>
            </a>

                <c:if test="${isAuth=='false'}">
                    <a class="btn btn-sm btn-outline-secondary" href="<c:url value="/signUp"/>">Зарегистрироваться</a>
                </c:if>

        </div>
    </div>
</header>
    <div class="row g-5">
        <div class="col-md-12">
            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-success">Соня</strong>
                    <h3 class="mb-0">Сочная курица с картошкой</h3>
                    <div class="mb-1 text-muted">11 Октября</div>
                    <p class="mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="#" class="stretched-link">Читать далее</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <%--<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>--%>
                    <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/1624487/pexels-photo-1624487.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                </div>
            </div>

            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-primary">Ира</strong>
                    <h3 class="mb-0">Шарлотка</h3>
                    <div class="mb-1 text-muted">12 Ноября</div>
                    <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="#" class="stretched-link">Читать далее</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <%--<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>--%>
                    <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/6069006/pexels-photo-6069006.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                </div>
            </div>

            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-primary">Ира</strong>
                    <h3 class="mb-0">Шарлотка</h3>
                    <div class="mb-1 text-muted">12 Ноября</div>
                    <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="#" class="stretched-link">Читать далее</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <%--<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>--%>
                    <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/6069006/pexels-photo-6069006.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                </div>
            </div>

            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-primary">Ира</strong>
                    <h3 class="mb-0">Шарлотка</h3>
                    <div class="mb-1 text-muted">12 Ноября</div>
                    <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="#" class="stretched-link">Читать далее</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <%--<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>--%>
                    <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/6069006/pexels-photo-6069006.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                </div>
            </div>

            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                <div class="col p-4 d-flex flex-column position-static">
                    <strong class="d-inline-block mb-2 text-primary">Ира</strong>
                    <h3 class="mb-0">Шарлотка</h3>
                    <div class="mb-1 text-muted">12 Ноября</div>
                    <p class="card-text mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>
                    <a href="#" class="stretched-link">Читать далее</a>
                </div>
                <div class="col-auto d-none d-lg-block">
                    <%--<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>--%>
                    <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/6069006/pexels-photo-6069006.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                </div>
            </div>

        </div>


    </div>

</div>
</body>
</html>

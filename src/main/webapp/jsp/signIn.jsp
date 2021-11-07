<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16.10.2021
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Signin Template · Bootstrap v5.1</title>

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


    <!-- Bootstrap core CSS -->

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


    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

    <title>Sign In</title>
</head>
<body class="text-center">
<main class="form-signin">
<form action="<c:url value="/signIn"/>" method="post" class="form">
    <%--<p>Sign In</p>
    <p>
        <label for="login">Login<input id="login" type="text" name="login"></label><br>
        <label for="password">Password<input id="password" type="password" name="password"></label><br>

    <p><button type="submit">Вход</button></p><br>
        <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
        <label for="name">Name<input id="name" type="text" name="name"></label><br>
        <label for="password">Password<input id="password" type="password" name="password"></label><br>
        <label for="email">Email<input id="email" type="email" name="email" value=""></label>--%>
        <h1 class="h3 mb-4 fw-normal">Пожалуйста, войдите</h1>
        <div class="form-floating">
            <input type="email" class="form-control" id="email" name="email">
            <label for="email">Email</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password">
            <label for="password">Пароль</label>
        </div>


        <p><font color="#dc3545">${signInStatus}</font> </p>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Войти</button>
        <p class="mt-3 mb-3 text-muted">&copy; 2021</p>
        <%--<div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>--%>
</form>
</main>
</body>
</html>

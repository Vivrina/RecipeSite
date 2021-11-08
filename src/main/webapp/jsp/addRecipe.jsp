<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.11.2021
  Time: 21:46
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
    <title>Checkout example · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/checkout/">
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
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form-validation.css">
    <title>Title</title>
</head>
<body class="bg-light">
<form action="${pageContext.request.contextPath}/addRecipe" method="post" class="form">
<div class="container">
    <main>
        <div class="py-5 text-center">
            <svg xmlns="http://www.w3.org/2000/svg" width="72" height="57" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16"><path d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
                <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/></svg>
            <h2>Добавление рецепта</h2>
            <p class="lead">Скорее добавляйте ваш рецепт!</p>
        </div>

        <div class="row g-3">
            <div class="col-md-6">
                <label for="inputEmail4" class="form-label">Название</label>
                <input type="email" class="form-control" id="inputEmail4">
            </div>
            <div class="col-md-6">
                <label for="formFile" class="form-label">Фото блюда</label>
                <input class="form-control" type="file" id="formFile">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Описание (рецепт)</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
            <div class="col-12">
                <label  class="form-label">Категория</label>
                <select class="form-select" aria-label="Default select example">
                    <option selected>Выберите категорию вашего рецепта</option>
                    <option value="1">Первые блюда</option>
                    <option value="2">Вторые блюда</option>
                    <option value="3">Закуски</option>
                </select>
            </div>
            <label for="button-addon2" class="form-label">Ингридиенты</label>
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Выберите ингридиенты блюда" aria-label="Recipient's username" aria-describedby="button-addon2">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Button</button>
            </div>




            <div class="col-12">
                <button type="submit" class="btn btn-primary">Добавить рецепт</button>
            </div>
        </div>
    </main>
</div>


<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="form-validation.js"></script>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16.10.2021
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/signUp" method="post" class="form">
    <p>Sign Up</p>
    <p>
        <label for="name">Name<input id="name" type="text" name="name"></label><br>
        <label for="password">Password<input id="password" type="password" name="password"></label><br>
        <label for="email">Email<input id="email" type="email" name="email" value=""></label>


    <%--        <p><input type="submit"></p>--%>
    <p><button type="submit">Зарегистрироваться!</button></p><br>
</form>

</body>
</html>

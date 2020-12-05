
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title> Registration new User </title>
    <style>
        form fieldset { width: 40%}
        form fieldset label { display: block}
        form fieldset input, form fieldset textarea {width: 100%}
    </style>
</head>
<body>
<h1>Registration</h1>
<form method="post">
    <fieldset>
        <div>
            <label> Логин: </label>
            <input type="text" name="username" value="${r.username}">
        </div>
        <div>
            <label> Пароль: </label>
            <input type="password" name="password">
        </div>
        <div>
             <label> Подтверждение: </label>
            <input type="password" name="confirm">
        </div>
        <div>
            <input type="submit" name="Регистрация">
        </div>
    </fieldset>
</form>
</body>
</html>

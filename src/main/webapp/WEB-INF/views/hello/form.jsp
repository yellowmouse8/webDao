<%--
  Created by IntelliJ IDEA.
  User: Zerg
  Date: 22.10.2020
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title there</title>
    <style>
        form fieldset {
            width: 40%;
        }
        form fieldset label{
            display: block;
        }
        form fieldset input, form fieldset textarea {
            width: 100%;
        }
    </style>
</head>
<body>
<h1>${user.hello}</h1>
<form method="post" action="/hello">
    <fieldset>
        <div>
        <label>Ваше имя: </label>
            <label>
                <input type="text" name="username" value="${user.userName}">
            </label>
        </div>
        <div>
            <input type="submit" value="Привет!">
        </div>
    </fieldset>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>

<html>
<head>
    <title>Start jsp webSite</title>
</head>
<body>
<h1>
    <%
        String result = "Hello";
        int r2 = 2+2;
        out.print(result);
        out.print(r2);
    %>
</h1>
<h2>
    <c:out value="16+12*2"/>
</h2>
<h2>
    <c:out value="${12+12*2}"/>
    <c:set var="salary" value="${32000*2}" scope="session"/>
</h2>
<h2>
    <c:if test="${salary < 100000}">
        <p> Salary = <c:out value="${salary}"/> </p>
    </c:if>
</h2>
</body>
</html>

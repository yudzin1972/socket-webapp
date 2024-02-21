<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <b>Список книг:</b>
    <br>
    <c:forEach items="${books}" var="book">
        <c:if test="${book.year > 1900}">
            ${book.title} ${book.author}
            <br>
        </c:if>
    </c:forEach>
</body>
</html>
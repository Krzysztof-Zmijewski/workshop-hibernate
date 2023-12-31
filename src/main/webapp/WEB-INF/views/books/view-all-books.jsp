<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <title>Book List</title>

</head>

<body>


<table>
    <thead>
    <tr>isbn </tr>
    <tr>title </tr>
    <tr>author </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

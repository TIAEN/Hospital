<%--
  Created by IntelliJ IDEA.
  User: FLY
  Date: 2024/7/3
  Time: 下午3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>
        Books show
    </h3>

    <table>
        <tr>
            <td>id</td>
            <td>Name</td>
            <td>Num</td>
            <td>price</td>
        </tr>
        <c:forEach items="${booksList}" var="book" varStatus="v">
        <tr>
            <td>${v.count}</td>
            <td>${book.bookName}</td>
            <td>${book.bookId}</td>
            <td>${book.bookNum}</td>
            <td>${book.price}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>

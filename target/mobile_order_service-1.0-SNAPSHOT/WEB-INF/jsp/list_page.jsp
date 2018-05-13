<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/3/19
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/list.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:forEach var="food" items="${foodlist}">
    <div class="item">
        <table>
            <tr>
                <td class="list_image"><img src="${food.imageUrl}"></td>
                <td class="list_name">${food.name}</td>
                <td class="list_subtract"><button class="subtract">-</button></td>
                <td class="list_number">${food.number}</td>
                <td class="list_plus"><button class="plus">+</button></td>
                <td class="list_reset"><button class="stock_reset" id="${food.id}">重置库存</button></td>
            </tr>
        </table>
    </div>
</c:forEach>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/3/20
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/grid.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:forEach var="deskno" items="${desknolist}">
    <div class="grid_item">
        <img src="/images/delete.png" class="deskno_delete">
        <p class="deskno">${deskno.no}</p>
        <a href="#" class="qr_code">二维码查看</a>
        <p>${deskno.capacity}人桌</p>
    </div>
</c:forEach>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/1/16
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr id="table_head">
        <th id="name">菜品名称</th>
        <th id="image">图片</th>
        <th id="practice">菜品可选做法</th>
        <th id="description">菜品介绍</th>
        <th id="price">菜品价格（元）</th>
        <th id="number">库存数量</th>
        <th id="operator">操作</th>
    </tr>
    <c:forEach var="food" items="${foodlist}">
        <tr id="${food.id}">
            <td>${food.name}</td>
            <td><img src="${food.imageUrl}"></td>
            <td>${food.practice}</td>
            <td>${food.description}</td>
            <td>${food.price}</td>
            <td>${food.number}</td>
            <td><a href="#" class="update">修改</a>|<a href="#" class="delete">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

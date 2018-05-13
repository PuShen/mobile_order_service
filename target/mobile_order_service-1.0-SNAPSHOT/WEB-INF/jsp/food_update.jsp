<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/3/17
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/update.css" rel="stylesheet" type="text/css">
</head>
<body>
<img src="/images/back.png" id="back"><h4>菜品修改</h4>
<hr/>
<form id="update_food" method="post" enctype="multipart/form-data">
    <table id="${food.id}">
        <tr>
            <td class="left">菜品名称：</td>
            <td class="right" id="name">${food.name}</td>
        </tr>
        <tr>
            <td class="left"><span>*</span>图片修改：</td>
            <td class="right">
                <img src="${food.imageUrl}">
                <br/>
                <input type="file" name="imageUrl" id="imageUrl"/>
            </td>
        </tr>
        <tr>
            <td class="left"><span>*</span>所属标签：</td>
            <td class="right">
                <select name="labelId" required="required" id="${food.labelId}">
                    <c:forEach var="label" items="${label}">
                        <option value="${label.id}">${label.labelName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td class="left">菜品做法：</td>
            <td class="right"><input type="text" name="practice" id="practice" value="${food.practice}"/></td>
        </tr>
        <tr>
            <td class="left">菜品详情：</td>
            <td class="right"><textarea name="description" id="description">${food.description}</textarea></td>
        </tr>
        <tr>
            <td class="left"><span>*</span>菜品价格（元）：</td>
            <td class="right"><input type="text" name="price" id="price" required="required" value="${food.price}"></td>
        </tr>
        <tr>
            <td class="left"></td>
            <td class="right"><input type="submit" value="提交" id="update"></td>
        </tr>
    </table>
</form>
</body>
</html>

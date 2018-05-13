<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/1/2
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/add.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
    <h4>菜品添加</h4>
    <hr/>
    <form id="add_food" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td class="left"><span>*</span>菜品名称：</td>
                <td class="right"><input type="text" name="name" id="name" required="required"/></td>
            </tr>
            <tr>
                <td class="left"><span>*</span>图片上传：</td>
                <td class="right"><input type="file" name="imageUrl" id="imageUrl" required="required"/></td>
            </tr>
            <tr>
                <td class="left"><span>*</span>所属标签：</td>
                <td class="right">
                    <select name="labelId" required="required">
                        <c:forEach var="label" items="${label}">
                            <option value="${label.id}">${label.labelName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="left">菜品做法：</td>
                <td class="right"><input type="text" name="practice" id="practice"/></td>
            </tr>
            <tr>
                <td class="left">菜品详情：</td>
                <td class="right"><textarea name="description" id="description"></textarea></td>
            </tr>
            <tr>
                <td class="left"><span>*</span>菜品价格（元）：</td>
                <td class="right"><input type="text" name="price" id="price" required="required"></td>
            </tr>
            <tr>
                <td class="left"></td>
                <td class="right"><input type="submit" value="提交" id="add"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

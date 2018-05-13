<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/3/22
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/deskno_add.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
    <h4>桌号添加</h4>
    <hr/>
    <form id="add_deskno" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td class="left"><span>*</span>桌号：</td>
                <td class="right"><input type="text" name="no" id="no" required="required"/></td>
            </tr>
            <tr>
                <td class="left"><span>*</span>可容纳人数：</td>
                <td class="right"><input type="text" name="capacity" id="capacity" required="required"/></td>
            </tr>
            <tr>
                <td class="left"><a href="#" id="qrcode_preview">二维码预览：</a></td>
                <td class="right" id="qrcode"></td>
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

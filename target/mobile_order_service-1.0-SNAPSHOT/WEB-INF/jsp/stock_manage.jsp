<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/3/19
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/show.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
    <h4>库存管理</h4>
    <hr/>
    <div id="contentOfPage"><jsp:include page="list_page.jsp" flush="true"/></div>
    <br/><p>共<span id="record_num">${recordNum}</span>条记录共<span id="page_num">${pageNum}</span>页&nbsp;&nbsp;当前第<span id="current_page">1</span>页&nbsp;&nbsp;
    <a href="#" id="start_page_stock">首页</a>&nbsp;&nbsp;
    <a href="#" id="previous_page_stock">上一页</a>&nbsp;&nbsp;
    <a href="#" id="next_page_stock">下一页</a>&nbsp;&nbsp;
    <a href="#" id="end_page_stock">尾页</a></p>
</div>
</body>
</html>

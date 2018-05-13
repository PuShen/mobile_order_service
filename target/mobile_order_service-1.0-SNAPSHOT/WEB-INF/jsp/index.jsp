<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/css/style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/webjars/jquery/2.1.3/jquery.js"></script>
    <script src="/js/action.js" type="module"></script>
    <title>移动点餐管理系统</title>
</head>
<body>
<div id="header">
    <img src="/images/logo.PNG" id="logo">
    <h1 id="title">移动点餐管理系统</h1>
    <p id="user">欢迎您&nbsp;${sessionScope.username}</p>
</div>
<div id="left_nav" class="middle">
    <div class="subnav">
        <div class="nav-title">菜单</div>
        <ul>
            <li id="foodlist" class="show">菜单查询</li>
            <li id="addfood" class="add">菜品添加</li>
            <li id="stock">库存管理</li>
        </ul>
    </div>
    <div class="subnav">
        <div class="nav-title">桌号</div>
        <ul>
            <li id="deskno">桌号查询</li>
            <li id="adddeskno">桌号添加</li>
        </ul>
    </div>
    <div class="subnav">
        <div class="nav-title">订单</div>
        <ul>
            <li id="order">订单查询</li>
        </ul>
    </div>
</div>
<div id="content" class="middle">
    <jsp:include page="${page}" flush="true"/>
</div>
<div id="footer"></div>
</body>
</html>

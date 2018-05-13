<%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/3/23
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>移动点餐管理系统</title>
    <link href="/css/login.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/webjars/jquery/2.1.3/jquery.js"></script>
    <script src="/js/login.js" type="module"></script>
</head>
<body>
    <form method="post" id="login">
        <div>
            <img src="/images/user.png" /><span>&nbsp;用户名：</span><input type="text" name="username" class="edit" required="required"/>
            <br/>
            <img src="/images/password.png" /><span>&nbsp;密&nbsp;&nbsp;&nbsp;码：</span><input type="password" name="password" class="edit" required="required"/>
            <br/>
            <input type="submit" value="登陆" id="button_login"/>
        </div>
    </form>
</body>
</html>

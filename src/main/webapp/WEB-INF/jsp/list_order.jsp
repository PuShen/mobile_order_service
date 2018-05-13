<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 王晓普
  Date: 2018/4/29
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
    <link href="/css/list_order.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:forEach var="order" items="${orderlist}">
    <div class="item">
        <table>
            <tr>
                <td class="list_time">${order.time}</td>
                <td class="list_no">${order.no}号</td>
                <td class="list_items">
                    <c:forEach var="item" items="${order.orderItems}">
                        <div>${item.name}&nbsp;&nbsp;×${item.num}&nbsp;&nbsp;${item.totalPrice}元</div>
                    </c:forEach>
                </td>
                <td class="list_total_price">${order.totalPrice}元</td>
            </tr>
        </table>
    </div>
</c:forEach>
</body>
</html>

</body>
</html>

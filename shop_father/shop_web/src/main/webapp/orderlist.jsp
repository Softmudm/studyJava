<%@ page import="com.sz.meituan.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>深圳外卖订单列表页面</title>
    <%--引用bootstrap框架； --%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style>
        td{
            vertical-align: middle !important;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>
                深圳外卖订单列表页面
                <span style="color:red;float:right;">
                    <%
                        User user = (User)request.getSession().getAttribute("user");
                    %>
                    <c:if test="${user!=null}" var="user">
                        <%=user.getUsername()%>
                    </c:if>
                </span>
            </h1>
        </div>
        <div class="panel-body">
            <table class="table table-hover table-bordered table-striped table-condensed text-center">
                <tr>
                    <td>订单号</td>
                    <td>总数量</td>
                    <td>总金额</td>
                    <td>用户名</td>
                    <td>电话</td>
                    <td>地址</td>
                    <td>订单状态</td>
                    <td>操作</td>
                </tr>

                <c:forEach items="${orderlist}" var="order">
                    <tr>
                        <td>${order.orderid}</td>
                        <td>${order.totalnum}</td>
                        <td>${order.totalmoney}</td>
                        <td>${order.username}</td>
                        <td>${order.usertel}</td>
                        <td>${order.useraddr}</td>
                        <td>${order.status}</td>
                        <td>
                            <c:choose>
                                <c:when test="${order.status =='待支付'}">
                                    <a href="/updateOrder?orderid=${order.orderid}&status=paid" class="btn btn-warning">去支付</a>
                                </c:when>
                                <c:when test="${order.status eq '待评价'}">
                                    <a href="/goappraise?orderid=${order.orderid}" class="btn btn-primary">去评价</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/goorder?orderid=${order.orderid}" class="btn btn-default">查看订单</a>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/food" class="btn btn-success btn-lg btn-block">继续去购物</a>
        </div>
        <div class="panel-footer text-right">
            深圳知领java44班开发。版权所有，复制必究！
        </div>
    </div>
</div>
</body>
</html>
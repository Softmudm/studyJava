<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sz.meituan.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评价页面</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>
                深圳外卖评价页面
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
            <table class="table table-striped table-hover text-center">
                <tr>
                    <td>订单号：</td>
                    <td>${order.orderid}</td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td>${order.username}</td>
                </tr>
                <tr>
                    <td>电话：</td>
                    <td>${order.usertel}</td>
                </tr>
                <tr>
                    <td>地址：</td>
                    <td>${order.useraddr}</td>
                </tr>
            </table>
            <table class="table table-striped table-hover text-center">
                <tr>
                    <td>菜品id</td>
                    <td>菜名</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>小计</td>
                </tr>
                <form id="appraise" action="/addAppraise" method="post">
                    <input type="hidden" name="orderid" value="${order.orderid}">
                    <c:forEach items="${list}" var="orderDetail">
                        <tr>
                            <td>${orderDetail.fid}</td>
                            <td>${orderDetail.fname}</td>
                            <td>${orderDetail.fprice}</td>
                            <td>${orderDetail.fnumber}</td>
                            <td>${orderDetail.fprice*orderDetail.fnumber}</td>
                        </tr>
                        <tr>
                            <td style="color:red;">评价：</td>
                            <td colspan="4"><textarea style="width: 100%;" name="${orderDetail.fid}"></textarea></td>
                        </tr>
                    </c:forEach>
                </form>
            </table>
            <h3 style="text-align: right">
                总数量：<span style="color: red">${order.totalnum}</span>
                总价格：<span style="color: red">${order.totalmoney}</span>
            </h3>
            <button onclick="s()" class="btn btn-success btn-lg btn-block">提交评价</button>
            <a href="/orderlist" class="btn btn-danger btn-lg btn-block">取消</a>
        </div>
        <div class="panel-footer text-right">
            深圳知领java44班开发。版权所有，复制必究！
        </div>
    </div>
</div>
</body>
<script>
    function s(){
        $("#appraise").submit();
    }
</script>
</html>
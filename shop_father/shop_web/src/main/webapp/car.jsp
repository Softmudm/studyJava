<%@ page import="com.sz.meituan.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>深圳美团外卖点餐页面</title>
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
                深圳美团外卖点餐页面
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
                    <td>编号</td>
                    <td>图片</td>
                    <td>名称</td>
                    <td>风味</td>
                    <td>饭店</td>
                    <td>价格</td>
                    <td>数量</td>
                    <td>小计</td>
                    <td>操作</td>
                </tr>

                <c:forEach items="${cart.map}" var="item">
                    <tr>
                        <td>${item.value.fid}</td>
                        <td><img width="100px" height="80px" src="imgs/${item.value.fimg}"></td>
                        <td>${item.value.fname}</td>
                        <td>${item.value.ftype}</td>
                        <td>${item.value.fshop}</td>
                        <td>${item.value.fprice}</td>
                        <td>
                            <a class="btn btn-default btn-sm" href="/UpdateShopServlet?fid=${item.value.fid}&opera=1">-</a>
                                ${item.value.num}
                            <a class="btn btn-default btn-sm" href="/UpdateShopServlet?fid=${item.value.fid}&opera=2">+</a>
                        </td>
                        <td>${item.value.xiaoji}</td>
                        <td>
                            <a href="/DelShopServlet?fid=${item.value.fid}" class="btn btn-warning">从购物车中移除</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="9">
                        共计：${cart.sum}件， 总金额是：${cart.total}元。
                    </td>
                </tr>
            </table>
            <a href="/food" class="btn btn-success btn-lg btn-block">继续去购物</a>
            <a href="/order" class="btn btn-danger btn-lg btn-block">提交订单</a>
        </div>
        <div class="panel-footer text-right">
                深圳知领java44班开发。版权所有，复制必究！
        </div>
    </div>
</div>
</body>
</html>

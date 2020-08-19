<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/layer/layer/theme/default/layer.css">
    <script type="text/javascript" src="/js/jquery.min-1.12.4.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/layer/layer/layer.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h3>用户列表</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-bordered table-hover table-condensed text-center">
                <tr>
                    <td>ID</td>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.uid}</td>
                        <td>${user.uname}</td>
                        <td>${user.upwd}</td>
                        <td>
                            <button class="btn btn-warning">修改</button>
                            <button class="btn btn-danger">删除</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="panel-footer text-right">
            ssm基本框架
        </div>
    </div>
</div>
</body>
</html>

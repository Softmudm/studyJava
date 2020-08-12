<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论列表</title>
    <link rel="stylesheet" href="/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/layer/layer/theme/default/layer.css">
    <script type="text/javascript" src="/bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="/layer/layer/layer.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2>SpringMVC考试:评论列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover table-bordered table-striped text-center">
                <tr>
                    <td>编号</td>
                    <td>评论主题</td>
                    <td>评论人</td>
                    <td>评论时间</td>
                    <td>查看回复</td>
                </tr>
                <c:forEach items="${remarkList}" var="remark">
                    <tr>
                        <td>${remark.kid}</td>
                        <td>${remark.kmsg}</td>
                        <td>${remark.uname}</td>
                        <td>${remark.kdate}</td>
                        <td><a href="/reply/getReplyList.do?kid=${remark.kid}" class="btn btn-danger">查看回复</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="panel-footer text-right">
            SpringMVC考试加载所有评论的列表页面
        </div>
    </div>
</div>
</body>
</html>

<%@ taglib prefix="c" uri="/WEB-INF/tld/c-1_0-rt.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp练习02(sevlet+jsp方法)</title>
</head>
<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
<body>
<%--注释--%>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>学生列表</h1>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-bordered table-hover text-center">
                <tr>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>操作</td>
                </tr>
                <%--嵌入java代码--%>
                <c:forEach items="${list}" var="student">
                    <tr>
                        <td>${student.stuid}</td>
                        <td>${student.stuname}</td>
                        <td>${student.age}</td>
                        <td>${student.stusex}</td>
                        <td>
                            <a class="btn btn-warning">修改</a>
                            <a class="btn btn-danger" href="/test01/deleteStudent?stuid=${student.stuid}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
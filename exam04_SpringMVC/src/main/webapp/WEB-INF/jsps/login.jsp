<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/12
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
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
            <h2>SpringMVC考试:登录页面</h2>
            <label class="pull-right" style="color: red;margin-top: -20px;font-size: 20px;">${msg}</label>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" action="/user/login.do" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-4">用户名：</label>
                    <div class="col-sm-4">
                        <input name="uname" type="text" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-4">密码：</label>
                    <div class="col-sm-4">
                        <input name="upwd" type="password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-4">
                        <button type="submit" class="btn btn-primary btn-block">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="panel-footer text-right">
            SpringMVC考试登录页面页面
        </div>
    </div>
</div>
</body>
</html>

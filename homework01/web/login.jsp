<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading text-center">
            用户管理登陆
        </div>
        <div class="panel-body">
            <form class="form-horizontal" action="/loginServlet" method="post">
                <div class="form-group">
                    <label class="col-sm-4 control-label">账号:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="account">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label">密码:</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" name="password">
                    </div>
                </div>
                <div class="form-group text-center">
                    <button class="btn btn-primary">登录</button>
                </div>
            </form>
        </div>
        <div class="panel-footer pull-right">
            (拦截器和监听器demo)严禁抄袭
        </div>
    </div>
</div>
</body>
</html>

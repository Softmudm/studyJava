<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>深圳外卖登录页面</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h1>
                    深圳外卖登录页面
                    <span style="color: red;float: right">${msg}</span>
                </h1>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="/login" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">用户名：</label>
                        <div class="col-sm-10">
                            <input  class="form-control" name="username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="userpwd">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary btn-block btn-lg">登录</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel-footer text-right">
                深圳知领java44班开发。版权所有，复制必究！
            </div>
        </div>
    </div>
</body>
</html>

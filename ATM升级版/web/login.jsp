<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ATM自动柜员机</title>
  </head>
  <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
  <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
  <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
  <body>
  <div class="container">
    <div class="panel" style="margin-top: 80px">
      <div class="panel-heading" style="text-align: center">
        <h3>ATM</h3>
        <label style="color: red">${msg}&nbsp;</label>
      </div>
      <div class="panel-body">
        <form id="loginform" class="form-horizontal" action="login" method="post">
          <div class="form-group">
            <label class="col-sm-4 control-label">卡号:</label>
            <div class="col-sm-4">
              <input class="form-control" placeholder="请输入卡号" name="cardid">
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-4 control-label">密码:</label>
            <div class="col-sm-4">
              <input class="form-control" placeholder="请输入密码" name="cardpwd">
            </div>
          </div>
          <div class="form-group" style="text-align: center">
            <button class="btn btn-success">登录</button>
            <button class="btn btn-default" style="margin-left: 100px">注册</button>
          </div>
        </form>
      </div>
    </div>
  </div>
  </body>
</html>

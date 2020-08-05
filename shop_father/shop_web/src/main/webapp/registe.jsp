<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>深圳外卖注册页面</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>
                深圳外卖注册页面
                <div id="msg" style="text-align: right"></div>
            </h1>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" action="/registe" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名：</label>
                    <div class="col-sm-10">
                        <input id="username" type="text" class="form-control" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-10">
                        <input id="pwd1" type="password" class="form-control" name="userpwd">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">确认密码：</label>
                    <div class="col-sm-10">
                        <input id="pwd2" type="password" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">电话：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="usertel">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">地址：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="useraddr">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary btn-block btn-lg">注册</button>
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
<script>
    $("#username").blur(function () {
        $.ajax({
            //请求路径
            url:"/registe",
            //请求方法
            method:"GET",
            //请求参数
            data:{username:$("#username").val()},
            //返回值类型，不符合格式就会进入error
            //dataType:"json",
            dataType:"text",
            //是否异步
            async:true,
            success:function (data) {
                //document.getElementById("msg").innerHTML=data.msg;
                $("#msg").html(data);
            },
            error:function (data) {
                alert("发生错误，返回值为："+data);
            }
        })
    })
    $("#pwd2").blur(function () {

    })
</script>
</html>
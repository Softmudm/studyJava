<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/28
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="icon" href="img/title-icon.jpg">
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
    <style type="text/css">
        .div1{
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div style="margin: 100px auto;max-width: 600px">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h3>登录页面</h3>
            </div>
            <div class="panel-body">
                <div class="col-sm-8 col-sm-offset-2 input-group div1">
                    <span class="input-group-addon">账号：</span>
                    <input id="username" class="form-control">
                </div>
                <div class="col-sm-8 col-sm-offset-2 input-group div1">
                    <span class="input-group-addon">密码：</span>
                    <input id="userpwd" type="password" class="form-control">
                </div>
                <div class="col-sm-8 col-sm-offset-2 input-group div1">
                    <button id="loginbtn" class="btn btn-block btn-primary">登录</button>
                </div>
            </div>
            <div class="panel-footer text-right">
                By Softmudm
            </div>
        </div>
    </div>
</body>
<script>
    $("#loginbtn").click(function () {
        $.ajax({
            //请求路径
            url:"/login",
            //请求方式
            method:"POST",
            //参数可以有三种
            //json还可以是数组或集合{[value1],[value2],[value3]}
            //1.json对象{"key":"value"}
            //2.json字符串'{"key":"value"}'
            //3.标准参数"key=value&key1=value1"
            //$(“#form1”).serialize() 就是把表单的数据拼成这个格式的字符串！
            data:{
                username:$("#username").val(),
                userpwd:$("#userpwd").val()
            },
            //规定返回值类型，符合进success回调方法，不符合就进error
            dataType:"json",
            //是否异步，true为异步false为同步(注意：在表单验证中必须使用同步请求)
            async:true,
            //回调函数
            success:function (data) {
                if(data.s){
                    //跳转页面
                    window.document.location.href="/success.jsp";
                }else{
                    alert("登录失败！");
                }
            },
            error:function (data) {
                alert("请求出错，请联系管理员！");
            }
        })
    })
//-------------------------------------------------------------------------------------------
    /*$("#loginbtn").click(function () {//原生js实现Ajax请求
        let xhr;
        //创建XMLHttpRequest请求对象
        if(window.XMLHttpRequest){
            xhr =new XMLHttpRequest();
        }else if(window.ActiveXObject){//IE6及以下的使用的这个对象
            xhr =new ActiveXObject("Microsoft.XMLHTTP");
        }else{
            alert("您的浏览器不支持Ajax请求！");
        }
        //注册回调函数
        xhr.onreadystatechange = function () {
            //readState是XMLHttpRequest对象的一个属性
            //0 － （未初始化）还没有调用send()方法
            //1 － （载入）已调用send()方法，正在发送请求
            //2 － （载入完成）send()方法执行完成，已经接收到全部响应内容
            //3 － （交互）正在解析响应内容
            //4 － （完成）响应内容解析完成，可以在客户端调用了
            if(xhr.readyState==4){
                //status响应包中响应行的http请求状态码，200表示正常完成
                if(xhr.status==200){
                    eval("var jsonObj = "+xhr.responseText);
                    if(jsonObj.s){
                        alert("登录成功！");
                    }else{
                        alert("登录失败！");
                    }
                }
            }
        }
        //初始化请求参数open(method, url, async)
        xhr.open("POST","/login",true);
        //POST请求特有的步骤,设置为表单提交并解决表单乱码
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8")
        //发送请求
        xhr.send("username="+$("#username").val()+"&userpwd="+$("#userpwd").val());
    })*/
//--------------------------------------------------------------------------------------
    /*$("#loginbtn").click(function () {//jQuery封装的get的ajax请求
        //$.get(url,data,callback,type)请求路径，请求参数，回调函数，返回值类型
        //请求参数可以使用标准参数或json对象
        //要发送post请求直接把get改为post就行
        $.get("/login",
              "username="+$("#username").val()+"&userpwd="+$("#userpwd").val(),
              function (data) {
                  if(data.s){
                      alert("登录成功！");
                  }else{
                      alert("登录失败！");
                  }
              },
              "json")
    })*/
</script>
</html>

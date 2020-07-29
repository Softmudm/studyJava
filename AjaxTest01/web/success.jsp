<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
    <link rel="icon" href="img/title-icon.jpg">
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
    <style type="text/css">
        .div1{
            margin-top: 20px;
        }
        .input-group-addon{
            width: 22%;
        }
    </style>
</head>
<body onload="load1()">
    <div style="margin: 100px auto;max-width: 600px">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h3>Ajax的联动下拉框和验证码</h3>
            </div>
            <div class="panel-body">
                <form id="crform">
                    <div class="col-sm-8 col-sm-offset-2 input-group div1">
                        <span class="input-group-addon">国家：</span>
                        <select name="countryId" id="country" class="form-control">
                        </select>
                    </div>
                    <div class="col-sm-8 col-sm-offset-2 input-group div1">
                        <span class="input-group-addon">角色：</span>
                        <select name="roleId" id="role" class="form-control">
                        </select>
                    </div>
                    <div class="col-sm-8 col-sm-offset-2 input-group div1">
                        <span class="input-group-addon">人物：</span>
                        <select name="personId" id="person" class="form-control">
                        </select>
                    </div>
                    <div class="col-sm-8 col-sm-offset-2 input-group div1">
                        <span class="input-group-addon">验证码：</span>
                        <input name="code" id="code" class="form-control" style="width: 120px;">
                        <img id="yzmimg" style="float: left;margin-left: 10px" src="/code">
                        <a href="javascript:nextp()" style="line-height: 34px;margin-left: 10px">换一张</a>
                    </div>
                    <div id="yzmmsg" style="float:right;margin-top: -25px"></div>
                </form>
            </div>
            <div class="panel-footer text-right">
                By Softmudm
            </div>
        </div>
    </div>
</body>
<script>
    function nextp() {
        //获取当前毫秒数
        let t =new Date().getTime();
        //给get请求加上时间戳防止浏览器使用缓存的数据
        $("#yzmimg").prop("src","/code?t="+t);
    }
    function load1() {
        $.ajax({
            url:"/success",
            method:"GET",
            dataType:"text",
            success:function (data) {
                eval("var jsonObj="+data);
                let cstr="<option value='0'>--请选择国家--</option>";
                $(jsonObj.countrylist).each(function (i,v) {
                    cstr=cstr+"<option value='"+v.countryId+"'>"+v.countryName+"</option>";
                })
                $("#country").html(cstr);
                let rstr="<option value='0'>--请选择类型--</option>";
                $(jsonObj.rolelist).each(function (i,v) {
                    rstr=rstr+"<option value='"+v.roleId+"'>"+v.roleName+"</option>";
                })
                $("#role").html(rstr);
            },
            error:function (data) {
                alert("Ajax请求出错，请联系管理员！"+data);
            }
        })
    }
    $("#crform select:lt(3)").change(function () {
        $.ajax({
            url:"/success",
            method:"POST",
            //使用serialize()序列化表单
            data:$("#crform").serialize(),
            dataType:"json",
            success:function (data) {
                let pstr="<option value='0'>--请选择人物--</option>";
                //i为循环的序列，v为循环的当前对象
                $(data).each(function (i,v) {
                    pstr=pstr+"<option value='"+v.userId+"'>"+v.userName+"</option>";
                })
                $("#person").html(pstr);
            },
            error:function (data) {
                alert("Ajax请求出错，请联系管理员！"+data);
            }
        })
    })
    $("#code").change(function () {
        $.post("/code",
            "code="+$("#code").val(),
            function (data) {
                if(data.msg){
                    $("#yzmmsg").html("<span style='color: green'>验证成功！</span>");
                }else{
                    $("#yzmmsg").html("<span style='color: red'>验证码错误！</span>");
                }
            },"json")
    })
</script>
</html>

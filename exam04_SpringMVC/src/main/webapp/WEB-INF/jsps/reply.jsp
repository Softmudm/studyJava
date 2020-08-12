<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回复列表</title>
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
            <h2>SpringMVC考试:回复列表</h2>
            <input type="hidden" id="msg" value="${m}">
        </div>
        <div class="panel-body">
            <table id="replytable" class="table table-hover table-bordered table-striped text-center">
                <tr>
                    <td>编号</td>
                    <td>回复内容</td>
                    <td>回复人</td>
                    <td>回复时间</td>
                    <td>添加回复</td>
                </tr>
                <c:forEach items="${replyList}" var="reply">
                    <tr>
                        <td>${reply.rid}</td>
                        <td>${reply.rmsg}</td>
                        <td>${reply.runame}</td>
                        <td>${reply.rdate}</td>
                        <td><button class="btn btn-success">我要回复</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="panel-footer text-right">
            SpringMVC考试加载所有回复的列表页面
        </div>
    </div>
</div>
<!-----------------------------------模态框开始------------------------------------->
<div class="modal fade" id="replyModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">新增回复</h4>
            </div>
            <div class="modal-body">
                <form id="replyform" class="form-horizontal" action="/reply/addReply.do" method="post">
                    <input id="kid" name="kid" type="hidden" value="${kid}"/>
                    <input id="ruid" name="ruid" type="hidden"/>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户名：</label>
                        <div class="col-sm-6">
                            <input id="uname" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">回复内容：</label>
                        <div class="col-sm-6">
                            <textarea rows="5" id="rmsg" name="rmsg" class="form-control"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-6">
                            <button type="submit" class="btn btn-primary btn-block">确认提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!----------------------------------模态框结束------------------------------------------>
</body>
<script>
    $(function () {
        let m = $("#msg").val();
        if(m){
            layer.alert(m);
        }
    })
    //我要回复按钮点击事件
    $("#replytable button").click(function () {
        $.ajax({
            url:"/user/verifyUser.do",
            method:"GET",
            dataType:"json",
            success:function (data) {
                if(data.m){
                    $("#rmsg").val("");
                    $("#ruid").val(data.uid);
                    $("#uname").val(data.uname);
                    $("#replyModal").modal("show");
                }else{
                   window.location.href="/user/gologin.do";
                }
            },
            error:function (data) {
                layer.msg("ajax请求出错！",{icon:2})
            }
        })
    })
</script>
</html>

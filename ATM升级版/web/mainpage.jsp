<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ATM功能列表</title>
</head>
<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
<body>
<div class="container" style="max-width: 750px;margin-top: 100px">
    <div class="panel panel-default">
        <div class="panel-heading" style="background-color: #337ab7;color: white">
            <h3 class="panel-title" style="text-align: center">
                <p style="font-size: 20px">功能列表</p>
                <input type="hidden" id="id" value="${bankCard.cardid}">
                <input type="hidden" id="pwd" value="${bankCard.cardpwd}">
                <p><label style="color: red;font-size: 18px">${bankCard.masterid}</label>${msg}</p>
            </h3>
        </div>
        <div class="panel-body">
            <div class="btn-group btn-group-justified" style="margin-top: 40px">
                <div class="btn-group">
                    <button id="select" type="button" class="btn btn-primary">查看余额</button>
                </div>
                <div class="btn-group">
                </div>
                <div class="btn-group">
                    <button id="turn" type="button" class="btn btn-primary">转账</button>
                </div>
            </div>
            <div class="btn-group btn-group-justified" style="margin-top: 40px">
                <div class="btn-group">
                    <button id="save" type="button" class="btn btn-primary">存款</button>
                </div>
                <div class="btn-group">
                </div>
                <div class="btn-group">
                    <button id="update" type="button" class="btn btn-primary">修改密码</button>
                </div>
            </div>
            <div class="btn-group btn-group-justified" style="margin-top: 40px;margin-bottom: 40px">
                <div class="btn-group">
                    <button id="take" type="button" class="btn btn-primary">取款</button>
                </div>
                <div class="btn-group">
                </div>
                <div class="btn-group">
                    <button id="logout" type="button" class="btn btn-primary">退出</button>
                </div>
            </div>
        </div>
    </div>
    <%--查询余额模态框--%>
    <div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="title">余额</h4>
                </div>
                <div class="modal-body" style="min-height: 60px;text-align: center">

                    <div id="ye">
                        余额：<label style="color:red;">${bankCard.balance}</label>
                    </div>

                    <div id="ck" class="list-inline">
                        <label>存款金额：</label>
                        <input id="savemoney" type="number">
                        <label id="e1" style="color:red;"></label>
                    </div>

                    <div id="qk" class="list-inline">
                        <label>取款金额：</label>
                        <input id="takemoney" type="number">
                        <label id="e2" style="color:red;"></label>
                    </div>

                    <form id="zz" class="list-inline" action="/turnServlet" method="post">
                        <div>
                            <label>转入卡号：</label>
                            <input type="text" name="cardid2">
                        </div>
                        <div style="margin-top: 10px">
                            <label>转账金额：</label>
                            <input type="number" name="turnmoney" id="turnmoney">
                            <label id="e3" style="color:red;"></label>
                        </div>
                    </form>

                    <form id="xgmm" class="list-inline" action="/updateServlet" method="post">
                        <div>
                            <label>原密码：</label>
                            <input id="oldpwd" type="password">
                            <label id="e4" style="color:red"></label>
                        </div>
                        <div style="margin-top: 10px">
                            <label>新密码：</label>
                            <input id="newpwd1" name="newpwd1" type="password">
                            <label id="e5" style="color:red;"></label>
                        </div>
                        <div style="margin-left: -14px;margin-top: 10px">
                            <label>确认密码：</label>
                            <input id="newpwd2" type="password">
                            <label id="e6" style="color:red;"></label>
                        </div>
                    </form>

                </div>
                <div class="modal-footer">
                    <button id="confirm" type="button" class="btn btn-primary">确认</button>
                    <button id="cancel" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
</div>
</body>
<script type="text/javascript">
    function hid(){
        $("#ye").prop("hidden","hidden");
        $("#ck").prop("hidden","hidden");
        $("#qk").prop("hidden","hidden");
        $("#zz").prop("hidden","hidden");
        $("#xgmm").prop("hidden","hidden");
        $("#confirm").show();
    }
    $("#select").click(function () {
        hid();
        $("#title").val("余额");
        $("#ye").prop("hidden","");
        $("#confirm").hide();
        $("#Modal").modal("show");
    })
    $("#save").click(function () {
        hid();
        $("#title").val("存款");
        $("#ck").prop("hidden","");
        $("#Modal").modal("show");
    })
    $("#take").click(function () {
        hid();
        $("#title").val("取款");
        $("#qk").prop("hidden","");
        $("#Modal").modal("show");
    })
    $("#turn").click(function () {
        hid();
        $("#title").val("转账");
        $("#zz").prop("hidden","");
        $("#Modal").modal("show");
    })
    $("#update").click(function () {
        hid();
        $("#title").val("修改密码");
        $("#xgmm").prop("hidden","");
        $("#Modal").modal("show");
    })
    $("#logout").click(function () {
       window.location.href="/login.jsp";
    })
    $("#confirm").click(function () {
        switch ($("#title").val()) {
            case "存款":
                if($("#savemoney").val()>0){
                    window.location.href="/saveServlet?savemoney="+$("#savemoney").val()+"&cardid="+$("#id").val();
                }else{
                    $("#e1").text("存款金额必须为正数");
                }
                break;
            case "取款":
                if($("#takemoney").val()>0){
                    window.location.href="/takeServlet?takemoney="+$("#takemoney").val()+"&cardid="+$("#id").val();
                }else{
                    $("#e2").text("取款金额必须为正数");
                }
                break;
            case "转账":
                if($("#turnmoney").val()>0){
                    $("#zz").submit();
                }else{
                    $("#e3").text("转账金额必须为正数");
                }
                break;
            case "修改密码":
                if($("#oldpwd").val()!=$("#pwd").val()){
                    $("#e4").text("原密码错误！");
                }else if($("#newpwd1").val()==""){
                    $("#e5").text("密码不能为空");
                }else if($("#newpwd1").val()!=$("#newpwd2").val()){
                    $("#e6").text("两次密码不一致");
                }else{
                    $("#xgmm").submit();
                }
                break;
        }
    })
</script>
</html>

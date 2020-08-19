<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/layer/layer/theme/default/layer.css">
    <script type="text/javascript" src="/js/jquery.min-1.12.4.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/layer/layer/layer.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h3>用户列表</h3>
            <input id="result" type="hidden" value='${result}'>
        </div>
        <div class="panel-body">
            <form id="searchForm" action="/user/searchUserList.do" method="post" class="form-inline" style="margin-bottom: 10px">
                <button type="button" class="btn btn-success" onclick="openAdd()">新增</button>
                <button type="button" class="btn btn-danger" onclick="del()">批量删除</button>
                <div class="pull-right">
                    <input type="hidden" name="pageIndex" id="pageIndex" value="${pageBean.pageIndex}">
                    <input type="hidden" name="pageSize" id="pageSize" value="${pageBean.pageSize}">
                    <input name="search" class="form-control" placeholder="用户名关键字查询" value="${search}">
                    <button type="submit" class="btn btn-primary">查询</button>
                </div>
            </form>
            <table class="table table-striped table-bordered table-hover table-condensed text-center">
                <tr>
                    <td><input id="checkAll" type="checkbox">全选</td>
                    <td>ID</td>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${pageBean.list}" var="user">
                    <tr>
                        <td><input type="checkbox" name="checkbox" value="${user.uid}"></td>
                        <td>${user.uid}</td>
                        <td>${user.uname}</td>
                        <td>${user.upwd}</td>
                        <td>
                            <button class="btn btn-sm btn-warning">修改</button>
                            <a href="/user/delUsers.do?uids=${user.uid}" class="btn btn-sm btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <ul class="pagination pull-right" style="margin: 0">
                <c:forEach begin="1" end="${pageBean.totalPage}" varStatus="v">
                    <li><a href="javascript:goIndex('${v.count}')">${v.count}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="panel-footer text-right">
            ssm基本框架+mybatis-generator自动生成代码
        </div>
    </div>
</div>
<!-----------------------------------模态框开始------------------------------------->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalTitle">添加</h4>
            </div>
            <div class="modal-body">
                <form id="myModalForm" action="/user/addUser.do" method="post" class="form-horizontal">
                    <input id="uid" name="uid" type="hidden"/>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">用户名：</label>
                        <div class="col-sm-6">
                            <input id="uname" name="uname" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">密码：</label>
                        <div class="col-sm-6">
                            <input id="upwd" name="upwd" type="password" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-6">
                            <button type="submit" class="btn btn-primary btn-block">提交</button>
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
    //操作结果
    $(function () {
        let r=$("#result").val();
        if(r){
            let jsonr=eval("("+r+")");
            layer.msg(jsonr.m,{icon:jsonr.i});
        }
    })
    //打开添加模态框
   function openAdd() {
       $("#myModal input").val("");
       $("#myModal").modal("show");
   }
   //翻页
    function goIndex(pageIndex) {
        $("#pageIndex").val(pageIndex);
        $("#searchForm").submit();
    }
    //全选
    $("#checkAll").click(function () {
        $("table input[name='checkbox']").prop("checked",$(this).is(":checked"));
    })
    //删除
    function del() {
        let uids="";
        $("table input[name='checkbox']:checked").each(function (i,v) {
            uids=uids+v.value+",";
        })
        uids=uids.substring(0,uids.length-1);
        window.location.href="/user/delUsers.do?uids="+uids;
    }
</script>
</html>

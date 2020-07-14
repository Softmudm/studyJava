<%@ taglib prefix="c" uri="/WEB-INF/tld/c-1_0-rt.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp练习02(sevlet+jsp方法)</title>
</head>
<link rel="stylesheet" href="bootstrap/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
<body>
<%--注释--%>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1 style="text-align: center">学生列表</h1>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-12" style="padding-right: 0;margin-bottom: 10px">
                    <div class="col-sm-4" style="float:right">
                        <div class="input-group">
                            <input id="keyword" type="text" class="form-control">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" onclick="selectStudent()">
                                查询
                            </button>
                        </span>
                        </div>
                    </div>
                    <a class="btn btn-primary col-sm-1" onclick="insert()">增加</a>
                </div><!-- /.col-lg-6 --><br>
            </div>
            <table class="table table-striped table-bordered table-hover text-center">
                <tr>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>年龄</td>
                    <td>性别</td>
                    <td>操作</td>
                </tr>
                <%--嵌入java代码--%>
                <c:forEach items="${list}" var="student">
                    <tr>
                        <td>${student.stuid}</td>
                        <td>${student.stuname}</td>
                        <td>${student.age}</td>
                        <td>${student.stusex}</td>
                        <td>
                            <a class="btn btn-warning" onclick="update('${student.stuid}','${student.stuname}','${student.age}','${student.stusex}')">修改</a>
                            <a class="btn btn-danger" onclick="del('${student.stuid}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <%--增加学生的模态框--%>
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="reset()">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">添加学生</h4>
                </div>
                <div class="modal-body">
                    <form id="add" class="form-horizontal" action="/test01/addStudent" method="post">
                        <div class="form-group">
                            <label class="col-sm-4 control-label">学生id：</label>
                            <div class="col-sm-4">
                                <input id="stuid" class="form-control" name="stuid">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">学生姓名：</label>
                            <div class="col-sm-4">
                                <input id="stuname" class="form-control" name="stuname">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">学生年龄：</label>
                            <div class="col-sm-4">
                                <input id="age" class="form-control" name="age">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label">学生性别：</label>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                    <input type="radio" name="stusex" id="man" value="男" checked>男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="stusex" id="woman"  value="女">女
                                </label>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="sub()">添加</button>
                    <button type="button" class="btn btn-default" onclick="reset()" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function sub(){
        $("#add").submit();
    }
    function reset(){
        $("#stuid").val("");
        $("#stuname").val("");
        $("#age").val("");
        $("#man").prop("checked","checked");
    }
    function insert(){
        $("#myModalLabel").text("添加学生");
        $("#add").prop("action","/test01/addStudent");
        $("#addModal").modal('show');
    }
    function del(id){
        if(window.confirm("确认删除吗？")){
            window.location.href="/test01/deleteStudent?stuid="+id;
        }
    }
    function update(id,name,age,sex){
        $("#myModalLabel").text("修改学生");
        $("#add").prop("action","/test01/updateStudent");
        $("#stuid").prop("readonly","readonly");
        $("#stuid").val(id);
        $("#stuname").val(name);
        $("#age").val(age);
        if(sex=='男'){
            $("#man").prop("checked","checked");
        }else{
            $("#woman").prop("checked","checked");
        }
        $("#addModal").modal('show');
    }
    function selectStudent(){
        window.location.href="/test01/studentList?keyword="+$("#keyword").val();
    }
</script>
</html>
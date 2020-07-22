<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP+Spring+Bootstrap考试：添加客户的回访记录</title>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>JSP+Spring+Bootstrap考试：添加客户的回访记录</h1>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" action="/AddVisitServlet" method="post">
                <input type="hidden" class="form-control" name="comid" value="<%=request.getParameter("comid")%>">
                <div class="form-group">
                    <label class="control-label col-sm-5">回访人姓名:</label>
                    <div class="col-sm-5">
                        <input class="form-control" name="vname">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">回访类型:</label>
                    <div class="col-sm-5">
                        <select name="vtype" class="form-control">
                            <option value="满意度回访" selected>满意度回访</option>
                            <option value="售后回访">售后回访</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">回访方式:</label>
                    <div class="col-sm-5">
                        <select name="vmethod" class="form-control">
                            <option value="满意度回访" selected>电话回访</option>
                            <option value="微信回访">微信回访</option>
                            <option value="QQ回访">QQ回访</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">回访时间:</label>
                    <div class="col-sm-5">
                        <input class="form-control" name="vdate">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5"></label>
                    <div class="col-sm-5">
                        日期格式:2019-9-1
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5">回访结果:</label>
                    <div class="col-sm-5">
                        <textarea name="vresult" class="form-control" rows="4"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5"></label>
                    <div class="col-sm-5">
                        <button class="btn btn-primary btn-block" type="submit">提交添加</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="panel-footer text-right">
            JSP+Spring+Bootstrap考试：添加客户的回访记录
        </div>
    </div>
</div>
</body>
</html>

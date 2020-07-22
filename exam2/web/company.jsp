<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP+Spring+Bootstrap考试：客户资料信息列表</title>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
    <div class="panel panel-primary">
      <div class="panel-heading">
        <h1>JSP+Spring+Bootstrap考试：客户资料信息列表</h1>
      </div>
      <div class="panel-body">
        <form class="form-horizontal" action="/SelComServlet" method="post">
          <div class="form-group col-sm-3">
            <label class="col-sm-5 control-label">公司名称:</label>
            <div class="col-sm-7">
              <input class="form-control" name="comname">
            </div>
          </div>
          <div class="form-group col-sm-3">
            <label class="col-sm-5 control-label">公司法人:</label>
            <div class="col-sm-7">
              <input class="form-control" name="mastername">
            </div>
          </div>
          <button class="btn btn-primary" type="submit">综合查询</button>
        </form>
        <table class="table table-striped table-bordered table-hover text-center">
          <tr style="background-color: green;color: white">
            <td>选择</td>
            <td>序号</td>
            <td>公司名称</td>
            <td>法人名称</td>
            <td>联系电话</td>
            <td style="max-width: 332px">公司简介</td>
            <td>操作</td>
          </tr>
          <c:forEach items="${comlist}" var="company">
            <tr>
              <td><input type="radio"></td>
              <td>${company.comid}</td>
              <td>${company.comname}</td>
              <td>${company.mastername}</td>
              <td>${company.mastertele}</td>
              <td style="max-width: 332px">${company.cominfo}</td>
              <td>
                <a class="btn btn-danger" href="/add.jsp?comid=${company.comid}">添加回访记录</a>
                <a class="btn btn-success" href="/SelVisitServlet?comid=${company.comid}">查看所有回访</a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
      <div class="panel-footer text-right">
        JSP+Spring+Bootstrap考试：客户资料信息列表
      </div>
    </div>
  </div>
  </body>
</html>

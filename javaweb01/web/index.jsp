<%--指令标签--%>
<%@ page import="com.sz.zhiling.entity.Student" %>
<%@ page import="com.sz.zhiling.dao.studentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--html标记语言--%>
<html>
  <head>
    <title>jsp练习01</title>
  </head>
  <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
  <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
  <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
  <body>
  <%--JSP动作标签--%><%--注释--%>
  <div class="container">
    <div class="panel panel-primary">
      <div class="page-header"><%@include file="header.jsp"%></div>
      <div class="panel-body">
        <table class="table table-striped table-bordered table-hover text-center">
          <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>操作</td>
          </tr>
          <%--嵌入java代码--%>
          <%
            for (Student student : new studentDao().selectAllStudent()) {
          %>
          <tr>
            <td><%=student.getStuid()%></td>
            <td><%=student.getStuname()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getStusex()%></td>
            <td>
              <a class="btn btn-warning">修改</a>
              <a class="btn btn-danger">删除</a>
            </td>
          </tr>
          <%
            }
          %>
        </table>
      </div>
    </div>
  </div>
  </body>
</html>

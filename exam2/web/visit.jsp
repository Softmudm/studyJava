<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP+Spring+Bootstrap考试：客户回访信息列表</title>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>JSP+Spring+Bootstrap考试：客户回访信息列表</h1>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-bordered table-hover text-center">
                <tr style="background-color: green;color: white">
                    <td>序号</td>
                    <td>回访姓名</td>
                    <td>回访类型</td>
                    <td>回访方式</td>
                    <td>回访结果</td>
                    <td>回访时间</td>
                </tr>
                <c:forEach items="${visitlist}" var="visit" >
                    <tr>
                        <td>${visit.vid}</td>
                        <td>${visit.vname}</td>
                        <td>${visit.vtype}</td>
                        <td>${visit.vmethod}</td>
                        <td>${visit.vresult}</td>
                        <%--<td>${visit.vdate}</td>--%>
                        <c:set var="date" value="${visit.vdate}"/>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${date}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="panel-footer text-right">
            JSP+Spring+Bootstrap考试：客户回访信息列表
        </div>
    </div>
</div>
</body>
</html>

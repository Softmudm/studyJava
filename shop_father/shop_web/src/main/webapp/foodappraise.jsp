<%@ page import="com.sz.meituan.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>深圳外卖商品评价页面</title>
    <%--引用bootstrap框架； --%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h1>
                深圳外卖商品评价页面
                <span style="color:red;float:right;">
                    <%
                        User user = (User)request.getSession().getAttribute("user");
                    %>
                    <c:if test="${user!=null}" var="user">
                        <%=user.getUsername()%>
                    </c:if>
                </span>
            </h1>
        </div>
        <div class="panel-body">
            <table class="table">
                <tr>
                    <td style="text-align: center;width: 50%;">
                        <img style="width: 200px;" src="imgs/${f.fimg}" alt="${f.fname}">
                    </td>
                    <td style="width: 50%;">
                        <h3 style="color:rgb(51,122,183);">相关信息</h3>
                        <ul class="list-unstyled">
                        <li>菜名：${f.fname}</li>
                        <li>口味：${f.ftype}</li>
                        <li>饭店：${f.fshop}</li>
                        <li>价格：${f.fprice}元</li>
                        </ul>
                    </ul>
                    </td>
                </tr>
                <c:forEach items="${list}" var="appraise">
                    <tr>
                        <td colspan="2">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    用户：${appraise.username}
                                    <span style="float: right;color: #999999">
                                        <fmt:formatDate value="${appraise.pdate}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate>
                                    </span>
                                </div>
                                <div class="panel-body">
                                        ${appraise.content}
                                    <a name="rbtn" class="pull-right">回复</a>
                                </div>
                                <div class="panel-footer">
                                    <c:forEach items="${appraise.replyList}" var="reply">
                                        <div class="panel panel-success">
                                            <div class="panel-heading">
                                                用户：${reply.username}
                                                <span style="float: right;color: #999999">
                                                    <fmt:formatDate value="${reply.rdate}" pattern="yyyy年MM月dd日 HH:mm:ss"></fmt:formatDate>
                                                </span>
                                            </div>
                                            <div class="panel-body">
                                                ${reply.content}
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <form name="replyform" action="/addreply" method="post">
                                        <div class="input-group col-sm-12">
                                            <input type="hidden" name="fid" value="${f.fid}">
                                            <input type="hidden" name="appraiseid" value="${appraise.appraiseid}">
                                            <input type="text" class="form-control" name="reply">
                                            <span class="input-group-btn">
                                                <button class="btn btn-success" type="submit">提交</button>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/food" class="btn btn-danger btn-lg btn-block">返回</a>
        </div>
        <div class="panel-footer text-right">
            深圳知领java44班开发。版权所有，复制必究！
        </div>
    </div>
</div>
</body>
<script>
    $(function () {
        //隐藏评论回复栏
        $("form[name='replyform']").hide();
        //点击回复时显示
        $("a[name='rbtn']").click(function () {
            debugger;
            $(this).parent().next().children().last().show();
        })
        }
    )
</script>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户列表</title>
    <%@include file="head.jsp"%>
  </head>
  <img>
  <div class="container">
    <div class="panel panel-primary">
      <div class="panel-heading text-center">
        用户列表
      </div>
      <div class="panel-body">
        <button id="addbtn" class="btn btn-default pull-left" onclick="add()">新增</button>
        <button id="delete" class="btn btn-danger pull-left" style="margin-left: 10px">批量删除</button>
        <form id="selform" action="/selectUserServlet" method="post">
          <div class="form-group pull-right">
            <div class="col-sm-9">
              <input type="hidden" id="pageno" name="pageno" value="${pageno}"/>
              <input type="hidden" id="pagesize" name="pagesize" value="${pagesize}"/>
              <input class="form-control" name="keyword" value="${keyword}"/>
            </div>
              <button id="sel1" class="btn btn-primary col-sm-3">查询</button>
          </div>
        </form>
        <table class="table table-hover table-bordered table-striped text-center">
          <tr>
            <td><input id="checkAll" type="checkbox"/></td>
            <td>用户id</td>
            <td>用户姓名</td>
            <td>角色</td>
            <td>爱好</td>
            <td>操作</td>
          </tr>
          <c:forEach items="${list}" var="user">
            <tr>
              <td><input type="checkbox" name="checkbox" value="${user.userid}"/></td>
              <td>${user.userid}</td>
              <td>${user.username}</td>
              <td>${user.rolename}</td>
              <td>
                <c:forEach items="${user.likeids}" var="likeid">
                  <c:forEach items="${likelist}" var="like">
                    <c:if test="${likeid==like.likeid}">
                      ${like.likename}&nbsp;
                    </c:if>
                  </c:forEach>
                </c:forEach>
              </td>
              <td>
                <button class="btn btn-success" onclick="update('${user.userid}','${user.username}','${user.rolename}','${user.likeids}')">修改</button>
                <button class="btn btn-warning" onclick="del(${user.userid})">删除</button>
              </td>
            </tr>
          </c:forEach>
        </table>
        <%------------页面条数按钮------------%>
        <div class="pull-left">
          <label class="control-label">页面大小</label>
          <select id="psSelect" class="btn" >
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="20">20</option>
          </select>
          <label class="control-label">条 (总条数:<label style="color:red;">${pgnm}</label>)</label>
        </div>
        <%-------------页面页数按钮------------%>
        <div id="pnSelect" style="float:right" class="pagination">
          <button class="btn" id="prePage" value="1">上一页</button>
          <button class="btn" id="btn1">1</button>
          <span id="prePoint">...</span>
          <button class="btn" id="btn2"></button>
          <button class="btn" id="btn3"></button>
          <button class="btn" id="btn4"></button>
          <button class="btn" id="btn5"></button>
          <button class="btn" id="btn6"></button>
          <span id="sufPoint">...</span>
          <button class="btn" id="btn7"></button>
          <button class="btn" id="sufPage">下一页</button>
        </div>
      </div>
      <div class="panel-footer text-right">
        严禁转载
      </div>
      </div>
    </div>
  </div>
  <%---------------------模态框---------------------%>
  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalTitle"></h4>
        </div>
        <div class="modal-body">
          <form id="modalform" class="form-horizontal" action="/" method="post">
            <input id="userid" name="userid" type="hidden"/>
            <div class="form-group">
              <label class="col-sm-4 control-label">用户姓名：</label>
              <div class="col-sm-4">
                <input id="username" name="username" class="form-control">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">用户角色：</label>
              <div class="col-sm-4">
                <select id="roleid" name="roleid" class="form-control">
                  <c:forEach items="${rolelist}" var="role">
                    <option value="${role.roleid}">${role.rolename}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">用户爱好：</label>
              <div id="like" class="col-sm-4">&nbsp;
                <c:forEach items="${likelist}" var="like">
                  <input class="checkbox-inline" type="checkbox" name="likeid" value="${like.likeid}">${like.likename}
                </c:forEach>
              </div>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button id="save" type="button" class="btn btn-primary">提交</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal -->
  </div>
  <img style='height: 700px;float: left' src='img/1.gif'><img style='height: 700px;float: right' src='img/2.gif'>
  </body>
  <script type="text/javascript" src="js/userslist.js"></script>
<script type="text/javascript">
  $(function(){
    var currentPage=${currentPage};//总页数
    var pageNum=${pageno};//当前页码
    //给每个button赋值（第一个默认为1）
    $("#btn2").text(pageNum-2);
    $("#btn3").text(pageNum-1);
    $("#btn4").text(pageNum);
    $("#btn5").text(pageNum+1);
    $("#btn6").text(pageNum+2);
    $("#btn7").text(currentPage);
    $("#btn7").val(currentPage);
    $("#prePage").val(pageNum-1);
    $("#sufPage").val(pageNum+1);
    for(i=2;i<=6;i++){
      $("#btn"+i).val(pageNum+-4+i);
    }
    //可改变当前页的button样式
    $("#btn4").css("background-color","#337AB7").css("color","white");
    $("#psSelect").val(${pagesize});
    //先处理"上一页"和"下一页"的情况
    if(pageNum==1)  //如果当前页为首页
    {
      $("#prePage").hide();
    }
    if(pageNum==currentPage)    //如果当前页为末页
    {
      $("#sufPage").hide();
    }
    //处理当前页小于等于3的特殊情况
    if(pageNum<=3){
      $("#prePoint").hide();
      $("#btn1").hide();
    }//当前页是4还需要hide掉第一个省略号按钮（！重要）
    else if(pageNum==4){
      $("#prePoint").hide();
    }
    //当前页是1还需要hide掉第二第三个按钮
    if(pageNum==1)
    {
      $("#btn2").hide();
      $("#btn3").hide();
    }
    //当前页是2则也需要hide掉第二个按钮（此时为-1）
    else if(pageNum==2)
    {
      $("#btn2").hide();
    }

    //最末端的特殊情况处理和最前端是一样的
    if(pageNum>=currentPage-2){
      $("#sufPoint").hide();
      $("#btn7").hide();
    }
    else if(pageNum==currentPage-3){
      $("#sufPoint").hide();
    }

    if(pageNum==currentPage)
    {
      $("#btn5").hide();
      $("#btn6").hide();
    }

    if(pageNum==currentPage-1)
    {
      $("#btn6").hide();
    }
  });
</script>
</html>

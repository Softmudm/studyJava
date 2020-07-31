<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP机试：会议室管理</title>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="layer/layer/theme/default/layer.css">
    <script type="text/javascript" src="bootstrap/jquery.min.js"></script>
    <script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer/layer.js"></script>
  </head>
  <body onload="sel(1)">
    <div class="container">
      <div class="panel panel-info">
        <div class="panel-heading text-center">
          <h3>会议室列表</h3>
        </div>
        <div class="panel-body">
          <input type="hidden" id="currentPage" name="totalPage">
          <input type="hidden" id="pageNum" name="pageNo" value="1">
          <input type="hidden" id="pageSize" name="pageSize" value="4">
          <button id="addbtn" class="btn btn-default pull-left" onclick="add()">新增</button>
          <table class="table table-hover table-bordered table-striped text-center">
            <tr>
              <td>序号</td>
              <td>会议室编号</td>
              <td>会议室名称</td>
              <td>会议室地址</td>
              <td>会议室容量</td>
              <td>操作</td>
            </tr>
            <tbody id="tblist">
            </tbody>
          </table>
          <%-------------页面页数按钮------------%>
          <div id="pnSelect" style="float:right" class="pagination">
            <button class="btn" id="prePage" value="1">上一页</button>
            <button class="btn" id="btn1">1</button>
            <span id="prePoint">...</span>
            <button class="btn" id="btn2"></button>
            <button class="btn" id="btn3"></button>
            <button class="btn" id="btn4"></button><%--当前页--%>
            <button class="btn" id="btn5"></button>
            <button class="btn" id="btn6"></button>
            <span id="sufPoint">...</span>
            <button class="btn" id="btn7"></button>
            <button class="btn" id="sufPage">下一页</button>
          </div>
        </div>
        <div class="panel-footer text-right">
          版权所有WX
        </div>
      </div>
    </div>
    <%-----------------------------------模态框开始-------------------------------------%>
    <div class="modal fade" id="conferenceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title" id="conferenceModalTitle">添加会议室</h4>
          </div>
          <div class="modal-body">
            <form id="conferenceModalform" class="form-horizontal">
              <input id="serialId" name="serialId" type="hidden"/>
              <div class="form-group">
                <label class="col-sm-4 control-label">会议室编号：</label>
                <div class="col-sm-4">
                  <input id="conferenceId" maxlength="10" name="conferenceId" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">会议室名称：</label>
                <div class="col-sm-4">
                  <input id="conferenceName" maxlength="10" name="conferenceName" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">会议室地址：</label>
                <div class="col-sm-4">
                  <input id="conferenceAddr" maxlength="10" name="conferenceAddr" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-4 control-label">会议室容量：</label>
                <div class="col-sm-4">
                  <input id="conferenceSize" type="number" name="conferenceSize" class="form-control">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-primary" onclick="sub()">提交</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal -->
    </div>
  <%----------------------------------模态框结束------------------------------------------%>
  </body>
  <script type="text/javascript" src="js/conferencelist.js"></script>
</html>

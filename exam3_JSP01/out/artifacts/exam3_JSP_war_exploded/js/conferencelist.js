//翻页按钮
$("#pnSelect button").click(function () {
    sel($(this).val());
})
//提交按钮
function sub() {
    if($("#serialId").val()!==""){//修改
        $.ajax({
            url:"/updateconference",
            method:"POST",
            //ajax提交表单并额外添加参数
            data:$.param({'pageNum':$('#pageNum').val()})+'&'+$("#conferenceModalform").serialize(),
            dataType:"json",
            success:function (data) {
                //隐藏模态框
                $("#conferenceModal").modal("hide");
                //请求数据刷新表格
                sel(Number(data.pageNo));
                if(data.s){
                    layer.msg("修改成功！",{icon:1,time:2000});
                }else{
                    layer.msg("修改失败！",{icon:2,time:2000});
                }
            },
            error:function (data) {
                layer.msg("Ajax请求出错，请联系管理员！",{icon:7,time:2000});
            }
        })
    }else{//添加
        $.ajax({
            url:"/addconference",
            method:"POST",
            data:$.param({'pageNum':$('#pageNum').val()})+'&'+$("#conferenceModalform").serialize(),
            dataType:"json",
            success:function (data) {
                $("#conferenceModal").modal("hide");
                sel(Number(data.pageNo));
                if(data.s){
                    layer.msg("添加成功！",{icon:1,time:2000});
                }else{
                    layer.msg("添加失败！",{icon:2,time:2000});
                }
            },
            error:function (data) {
                layer.msg("Ajax请求出错，请联系管理员！",{icon:7,time:2000});
            }
        })
    }
}
//打开增加模态框
function add() {
    //修改模态框标题，清空输入框的值
    $("#conferenceModalform input").val("");
    $("#conferenceModalTitle").text("添加会议室");
    $("#conferenceModal").modal("show");
}
//打开修改模态框
function update(serialId) {
    //修改模态框标题，清空输入框的值
    $("#conferenceModalTitle").text("修改会议室");
    //向后台请求修改的数据
    $.ajax({
        url:"/selconference",
        method:"POST",
        data:"serialId="+serialId,
        dataType:"json",
        success:function (data) {
            //向模态框填充数据
            $("#serialId").val(serialId);
            $("#conferenceId").val(data.conferenceId);
            $("#conferenceName").val(data.conferenceName);
            $("#conferenceAddr").val(data.conferenceAddr);
            $("#conferenceSize").val(data.conferenceSize);
        }
    })
    //显示模态框
    $("#conferenceModal").modal("show");
}

//请求会议列表
function sel(pageno) {
    $.get("/selconference",
        "pageno="+pageno,
        function (data) {
            $("#currentPage").val(data.totalpage);
            $("#pageNum").val(data.pageno);
            $("#pageSize").val(data.pagesize);
            var t = "";
            $(data.data).each(function (i,v) {
                t=t+"<tr><td>"+v.serialId+"</td>";
                t=t+"<td>"+v.conferenceId+"</td>";
                t=t+"<td>"+v.conferenceName+"</td>";
                t=t+"<td>"+v.conferenceAddr+"</td>";
                t=t+"<td>"+v.conferenceSize+"</td>";
                t=t+"<td><button class='btn btn-success' onclick=\"update('";
                t=t+v.serialId;
                t=t+"')\">修改</button><button class=\"btn btn-warning\" onclick=\"del("+v.serialId+")\">删除</button></td></tr>";
            })
            $("#tblist").html(t);
            $("#pnSelect button").show();
            page();
        },"json")
}
function del(serialId) {
    layer.confirm("确认删除吗？",{icon:3,title:"系统提醒："},function (index) {
        $.post("/delconference",
            "serialId="+serialId+"&pageno="+$("#pageNum").val(),
            function (data) {
                $("#currentPage").val(data.totalpage);
                $("#pageNum").val(data.pageno);
                $("#pageSize").val(data.pagesize);
                var t = "";
                $(data.data).each(function (i,v) {
                    t=t+"<tr><td>"+v.serialId+"</td>";
                    t=t+"<td>"+v.conferenceId+"</td>";
                    t=t+"<td>"+v.conferenceName+"</td>";
                    t=t+"<td>"+v.conferenceAddr+"</td>";
                    t=t+"<td>"+v.conferenceSize+"</td>";
                    t=t+"<td><button class='btn btn-success' onclick=\"update('";
                    t=t+v.serialId+"','"+v.conferenceId+"','"+v.conferenceName+"','"+v.conferenceAddr+"','"+v.conferenceSize;
                    t=t+"')\">修改</button><button class=\"btn btn-warning\" onclick=\"del("+v.serialId+")\">删除</button></td></tr>";
                })
                $("#tblist").html(t);
                $("#pnSelect button").show();
                page();
                if(data.s){
                    layer.msg("删除成功！",{icon:1,time:2000});
                }else{
                    layer.msg("删除失败！",{icon:2,time:2000});
                }
            },"json")
    })
}
//页码方法
function page(){
    var currentPage=$("#currentPage").val();//总页数
    var pageNum=Number($("#pageNum").val());//当前页码
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
    $("#psSelect").val($("#pageSize").val());
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
};

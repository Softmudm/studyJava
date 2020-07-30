//翻页按钮
$("#pnSelect button").click(function () {
    window.document.location.href="/selconference?pageno="+$(this).val();
})
function sub() {
    $("#conferenceModalform").submit();
}
//打开增加模态框
function add() {
    $("#conferenceModalform input").val("");
    $("#conferenceModalform").prop("action","/addconference");
    $("#conferenceModalTitle").val("添加会议室");
    $("#conferenceModal").modal("show");
}
//打开修改模态框
function update(serialId,conferenceId,conferenceName,conferenceAddr,conferenceSize) {
    $("#conferenceModalTitle").val("修改会议室");
    $("#conferenceModalform").prop("action","/updateconference");
    $("#serialId").val(serialId);
    $("#conferenceId").val(conferenceId);
    $("#conferenceName").val(conferenceName);
    $("#conferenceAddr").val(conferenceAddr);
    $("#conferenceSize").val(conferenceSize);
    $("#conferenceModal").modal("show");
}

/*
//优化前删除方法
function del(serialId) {
    $.post("/delconference",
        "serialId="+serialId+"&pageno="+$("#pageNum").val(),
        function (data) {
        $("#currentPage").val(data.totalpage);
        $("#pageNum").val(data.pageno);
        $("#pageSize").val(data.pagesize);
        var t = "";
        $(data.data).each(function (i,v) {
            t=t+"<tr><td>";
            t=t+v.serialId;
            t=t+"</td><td>";
            t=t+v.conferenceId;
            t=t+"</td><td>";
            t=t+v.conferenceName;
            t=t+"</td><td>";
            t=t+v.conferenceAddr;
            t=t+"</td><td>";
            t=t+v.conferenceSize;
            t=t+"</td><td><button class='btn btn-success' onclick=\"update('";
            t=t+v.serialId+"','"+v.conferenceId+"','"+v.conferenceName+"','"+v.conferenceAddr+"','"+v.conferenceSize;
            t=t+"')\">修改</button><button class=\"btn btn-warning\" onclick=\"del("+v.serialId+")\">删除</button></td></tr>";
        })
        $("#tblist").html(t);
        $("#pnSelect button").show();
        page();
        },"json")
}*/
//优化后删除
function del(serialId) {
    $.post("/delconference",
        "serialId="+serialId+"&pageno="+$("#pageNum").val(),
        function (data) {
        $("#tblist").html(data);
        $("#pnSelect button").show();
        page();
        },"html")
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

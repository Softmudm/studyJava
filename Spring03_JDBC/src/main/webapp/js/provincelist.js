//根据名称查询省列表
function initProvincelist() {
    $.ajax({
        url:"/province/getProvince.do",
        method:"POST",
        data:$("#findform").serialize(),
        dataType:"html",
        success:function (data) {
            $("#plist").html(data);
        },
        error:function (data) {
            layer.alert("Ajax请求错误，请联系管理员！",{icon:2})
        }
    })
}
//删除省市
function delProvince(pid){
    let m = "确认删除吗？";
    if(pid==0){
        m="删除省(省下所有的市也会被一起删除）确认删除吗？";
    }
    layer.confirm(m,{icon:3,title:"系统提示"},function (index) {
        layer.close(index);
        let l = layer.load(2,{time:10*1000})
        $.ajax({
            url:"/province/delProvince.do?pid="+pid,
            method:"GET",
            dataType:"json",
            success:function (data) {
                //eval()函数给data加上括号使javascript把data转为一个对象
                let datajson=eval("("+data+")");
                layer.close(l);
                layer.msg(datajson.message,{icon:datajson.i});
                initProvincelist();
            },
            error:function (data) {
                layer.alert("Ajax请求错误，请联系管理员！",{icon:2})
            }
        })
    })
}
//打开市列表
$("#ptbl").on("click",".btn-sm",function () {
    if ($(this).text()=="+"){
        $(this).text("-");
        $(this).parent().parent().next().show();
    }else{
        $(this).text("+");
        $(this).parent().parent().next().hide();
    }
})
//打开增加模态框
function add() {
    //修改模态框标题，清空输入框的值
    $("#provinceModal input").val("");
    $("#cname").prop("readonly","");
    $("#provinceModalTitle").text("添加省或市");
    //把省的下拉框查出来
    getDropDown();
    $("#provinceModal").modal("show");
}
//打开修改模态框
function update(pid) {
    //修改模态框标题，清空输入框的值
    $("#provinceModal input").val("");
    $("#cname").prop("readonly","");
    $("#provinceModalTitle").text("修改省或市");
    //向后台请求修改的数据
    $.ajax({
        url:"/updateProvince",
        method:"GET",
        data:"pid="+pid,
        dataType:"json",
        success:function (data) {
            //向模态框填充数据
            $("#pid").val(data.pid);
            $("#pname").val(data.pname);
            if(data.cid){
                //把省的下拉框查出来
                getDropDown();
                $("#cid").val(data.cid);
                $("#cname").val(data.cname);
            }else{
                $("#cname").prop("readonly","readonly");
            }
        }
    })
    //显示模态框
    $("#provinceModal").modal("show");
}
//打开模态框中下拉框中的省
function getDropDown() {
    $.ajax({
        url:"/province/getDropDown.do",
        method:"POST",
        dataType:"json",
        success:function (data) {
            let array = eval("("+data+")");
            let str = "";
            $(array).each(function (i,v) {
                str=str+"<li><a>"+v.pname+"</a></li>";
            })
            //向下拉框添加拼接好的html
            $("#dd").html(str);
        }
    })
}
//点击选择后把省填入输入框
$("#dd").on("click","li",function () {
    $("#pname").val($(this).text());
})
/*//没填入省时不能填入市
$("#pname").bind("input",function () {
    if($(this).val()){
        $("#cname").prop("readonly","");
    }else{
        $("#cname").prop("readonly","readonly");
    }
})*/
//模态框提交按钮
function sub() {
    if(!$("#pname").val()){
        layer.msg("省不能为空！",{icon:4,time:1000})
    }else{
        let index = layer.load(2,10*1000);
        let url="";
        if($("#pid").val()||$("#cid").val()){
            url="/province/updateProvince.do";
        }else{
            url="/province/addProvince.do";
        }
        $.ajax({
            url:url,
            method:"POST",
            data:$("#provinceModalform").serialize(),
            dataType:"json",
            async:false,
            success:function (data) {
                let d = eval("("+data+")");
                layer.close(index);
                layer.msg(d.msg,{icon:d.icon,time:1000});
            },
            error:function (data) {
                layer.msg("错误："+d+"\nAjax请求出错，请联系管理员！",{icon:7,time:2000});
            }
        })
    }
    initProvincelist();
    //隐藏模态框
    $("#provinceModal").modal("hide");
}

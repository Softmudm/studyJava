function hid() {
    $("#userid").val("");
    $("#username").val("");
    $("#like input[name='likeid']").prop("checked",false);
}
function add() {
    hid();
    $("#myModalTitle").text("添加用户");
    $("#myModal").modal("show");
}
function update(userid,username,rolename,likeids) {
    $("#myModalTitle").text("修改用户");
    $("#like input[name='likeid']").prop("checked",false);
    $("#userid").val(userid);
    $("#username").val(username);
    $("#roleid").find("option:contains("+rolename+")").attr("selected","selected");
    let ids = likeids.substring(1,likeids.length-1).replace(/\s*/g,"").split(",");
    let checkb = $("#like input[name='likeid']");
    for(i=0;i<ids.length;i++){
        for(j=0;j<checkb.length;j++)
            if(ids[i]==checkb[j].value){
                $(checkb[j]).prop("checked",true);
                break;
            }
    }
    $("#myModal").modal("show");
}
function del(id) {
    if(window.confirm("确认删除吗？")){
        window.location.href="/deleteUserServlet?userid="+id;
    }
}
$("#delete").click(function () {
    let ids = "";
    $("input:checkbox[name='checkbox']:checked").each(function () {
        ids=ids+","+$(this).val();
    })
    if(ids==""){
        alert("请最少选中一条！");
    }else{
        ids=ids.substring(1);
        if(window.confirm("确认删除"+ids+"吗？")){
            window.location.href="/deleteUserServlet?userids="+ids;
        }
    }
})
$("#save").click(function () {
    if($("#userid").val()){
        $("#modalform").prop("action","/updateUserServlet").submit();
    }else{
        $("#modalform").prop("action","/addUserServlet").submit();
    }
})
$("#checkAll").click(function () {
    $("input[name='checkbox']").prop("checked",$(this).is(":checked"));
})
$("#psSelect").change(function(){
    $("#pageno").val(1);
    $("#pagesize").val($("#psSelect").val());
    $("#selform").submit();
})
$("#sel1").click(function () {
    $("#pageno").val(1);
    $("#selform").submit();
})
$("#pnSelect button").click(function () {
    $("#pageno").val($(this).val());
    $("#selform").submit();
})
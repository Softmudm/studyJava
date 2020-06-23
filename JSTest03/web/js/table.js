$("#all").click(function(){
    var f = $("#all").prop("checked");
    /*var a = $("[id!='all'][type='checkbox']")
    //这里是使用dom对象来设置全选按钮
    for(var i = 0;i<a.length;i++){
    //注意：js中的增强循环是for(var i in a)而且里面不是":"而是"in"，i是下标
        a[i].checked = f;
    }*/
    $("[id!=all][type=checkbox]").prop("checked",f);
    //这里是用jquery对象设置全选按钮
})
/*$("[name=delete]").click(function(){
    $(this).parent().parent().parent().remove();
})*/
$(".tb1").on("click","[name=delete]",function(){
    //这么和上面的区别是使用的"on",因为这里还有可能是未来添加的元素，jquery1.7以前是"live"
    //注意，这里on要起作用的话，前面的".tb1"必须为静态的就是页面中本来就有的，后面第二个参数在写具体子对象
    if(window.confirm("确认删除吗？")){//确认框
        $(this).parent().parent().parent().remove();
    }
})
$(".tb1").on("click","[name=update]",function(){
    let f = $(this).prop("src").indexOf("ok") == -1;
    //判断是修改还是保存,true为修改，false为保存
    if(f){
        $(this).prop("src","img/ok.jpg");
        let eleTel = $(this).parent().parent().prev().prev().prev();
        let tele = eleTel.text();
        let d = Date.now();//获取毫秒数当做添加的input元素的id
        let updateInput = $('<td class="c2"><input id='+d+' style="width: 100px" type="tel" value="'+tele+'"></td>')
        eleTel.replaceWith(updateInput);
        $("#"+d+"").focus();
    }else{
        $(this).prop("src","img/update.jpg");
        let eleTel = $(this).parent().parent().prev().prev().prev();
        let tele = eleTel.children().val();
        let updateTd = $('<td class="c2">'+tele+'</td>')
        eleTel.replaceWith(updateTd)
    }
})
$($("#frame").css("display","none"))
//隐藏frame框
function show(){
    //显示frame框
    $("#frame").css("display","");
    //document.getElementById("frame").style.display = "";
}
function hid(){
    //隐藏frame框
    $("#frame").css("display","none");
}
function confirm1(){
    //新增页面的保存函数
    let newNode = $('<tr>' +
        '<td class="c1"><input type="checkbox"></td>' +
        '<td class="c1">'+$("#name").val()+'</td>' +
        '<td class="c1">'+$("#sex").val()+'</td>' +
        '<td class="c3">'+$("#cardNum").val()+'</td>' +
        '<td class="c1">'+$("#vipLevel").val()+'</td>' +
        '<td class="c2">'+$("#phoneNum").val()+'</td>' +
        '<td class="c2">'+$("#birthday").val()+'</td>' +
        '<td class="c2">'+$("#cost").val()+'</td>' +
        '<td class="c2"><a href="#"><img name="update" src="img/update.jpg"></a><a href="#"><img name="delete" src="img/del.jpg"></a></td>' +
        '</tr>');
    //要添加节点的html
    $(".t1>table").append(newNode);
    //向指定table添加节点
    hid();
    //隐藏添加框
    $("#frame input").prop("value","");
    //清空添加框的所有input
}
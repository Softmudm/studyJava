function change(){
    var id = event.target.id.substring(3,);//获取当前的选项   event.target获取调用这个方法的那个dom对象
    $("#main").css("background-image","url('img/"+id+".jpg')");//更换背景图
    $("#img"+id+"").css("background-color","#66ccff").siblings().css("background-color","#999999");//更换下面的颜色
}
function cut(){
    var n = $("#main").css("background-image").substring(45,46)//获得当前的图片id
    n = (parseInt(n)+1)%5;
    $("#main").css("background-image","url('img/"+n+".jpg')");
    $("#img"+n+"").css("background-color","#66ccff").siblings().css("background-color","#999999");
}
var s;
function f(){
    s = setInterval("cut()",2000);
}
$(f)
$("#main").mouseover(function(){//鼠标放上去时停止轮播
    clearInterval(s);
});
$("#main").mouseout(f);//鼠标移走开始轮播
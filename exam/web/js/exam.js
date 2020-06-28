$(".list1").hover(function () {
    $(this).css("background-image","url('img/bg.jpg')");
},function () {
    $(this).css("background-image","");
})
$(".list1").click(function () {
    debugger;
    let index = $(this).index()/2;
    $(".list2").eq(index).slideToggle();
    let src = $(this).children().prop("src");
    let i = src.substring(src.lastIndexOf("/")+1,src.lastIndexOf("/")+2);
    if(i == "+"){
        $(".list1 img").eq(index).prop("src","img/-.jpg");
    }else{
        $(".list1 img").eq(index).prop("src","img/+.jpg");
    }
})
$($(".list2").toggle())
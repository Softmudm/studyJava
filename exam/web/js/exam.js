$(".list1").hover(function () {
    $(this).css("background-image","url('img/bg.jpg')");
},function () {
    $(this).css("background-image","");
})
var i = 0;
$(".list1").click(function () {
    let index = $(this).index()/2;
    $(".list2").eq(index).slideToggle();
    if(i == 0){
        $(".list1 img").eq(index).prop("src","img/-.jpg");
        i = 1;
    }else{
        $(".list1 img").eq(index).prop("src","img/+.jpg");
        i = 0;
    }
})
$($(".list2").toggle())
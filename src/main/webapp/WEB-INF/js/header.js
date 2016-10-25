/**
 * Created by Oliver.Liu on 4/13/2016.
 */
$(function() {
    $(".searchmenu").hover(function() {
            $("#searchtab").show();
            $("#searchselect").addClass("searchopen");
        },
        function() {
            $("#searchtab").hide();
            $("#searchselect").romveClass("searchopen");
        });
    $("#searchtab li").click(function() {
        $("#searchselect").html($(this).html());
        $("#searchtab").hide();
        $("#searchselect").removeClass("searchopen");
    });
    //品牌资讯案例切换
    $(".brand-nav li").click(function() {
        var index = $(this).index();
        $(this).siblings().removeClass("selectd");
        $(this).addClass("selectd");
        $(".middleswitch div.switchitem").eq(index).siblings().css("display", "none");
        $(".middleswitch div.switchitem").eq(index).css("display", "block");
    });
});
function gopage() {
    var v = $("#hid1").val();
    var kw = $("#txtkeyword").val()
    if (kw == '' || kw == '请输入关键字') {
        return
    } else {
        if (v == 1)
            window.open("../mall.soo56.com/search-" + kw + "-0-0-0-0.html");
        //if (v == 2) window.open("../mall.soo56.com/news1/list.aspx@k
    }
}
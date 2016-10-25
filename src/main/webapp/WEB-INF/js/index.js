/**
 * Created by Oliver.Liu on 4/13/2016.
 */
$(".guding").capacityFixed();
$(document).ready(function() {
    $('.boxgrid.captionfull').hover(function() {
            $(".cover", this).stop().animate({
                    top: '0px'
                },
                {
                    queue: false,
                    duration: 300
                });
            /*$(".zw_box").hide();*/
        },
        function() {
            $(".cover", this).stop().animate({
                    top: '80px'
                },
                {
                    queue: false,
                    duration: 300
                });
            $(".zw_box").show(650);
        });
});
jQuery(".slideBox").slide({
    mainCell: ".bd ul",
    autoPlay: true
});
jQuery(".slideTxtBox").slide({
    autoPlay: false
});
jQuery(".switchlunbo-cnt").slide({
    mainCell: ".bd ul",
    autoPlay: true
});
$(document).ready(function() {
    jQuery.jqtab = function(tabtit, tab_conbox, shijian) {

        //$(tab_conbox).find("li").hide();
        $(tabtit).find("li:first").addClass("thistab").show();
        $(tab_conbox).find("li:first").show();

        $(tabtit).find("li").bind(shijian,
            function() {
                $(this).addClass("thistab").siblings("li").removeClass("thistab");
                var activeindex = $(tabtit).find("li").index(this);
                $(tab_conbox).children().eq(activeindex).show().siblings().hide();
                return false;
            });

    };
    /*调用方法如下：*/
    $.jqtab("#tabs", "#tab_conbox", "mouseenter");
    $.jqtab("#tabs1", "#tab_conbox1", "mouseenter");
    $.jqtab("#tabs2", "#tab_conbox2", "mouseenter");
    $.jqtab("#tabs3", "#tab_conbox3", "mouseenter");
    $.jqtab("#tabs4", "#tab_conbox4", "mouseenter");
    $.jqtab("#tabs5", "#tab_conbox5", "mouseenter");
});
$(document).ready(function() {

    $(".def-nav,.info-i").hover(function() {
            $(this).find(".pulldown-nav").addClass("hover");
            $(this).find(".pulldown").show();
            $(this).find(".nav-a").addClass("navmainhover");
        },
        function() {
            $(this).find(".pulldown").hide();
            $(this).find(".pulldown-nav").removeClass("hover");
            $(this).find(".nav-a").removeClass("navmainhover");
        });

});
$(document).ready(function() {
    var ali = $('#lunbonum li');
    var aPage = $('#lunhuanback p');
    var aslide_img = $('.lunhuancenter b');
    var iNow = 0;

    ali.each(function(index) {
        $(this).mouseover(function() {
            slide(index);
        })
    });
    function slide(index) {
        iNow = index;
        ali.eq(index).addClass('lunboone').siblings().removeClass();
        aPage.eq(index).siblings().stop().animate({
                opacity: 0
            },
            600);
        aPage.eq(index).stop().animate({
                opacity: 1
            },
            600);
        aslide_img.eq(index).stop().animate({
                opacity: 1,
                top: -10
            },
            600).siblings('b').stop().animate({
                opacity: 0,
                top: -40
            },
            600);

        aPage.eq(index).siblings().stop().animate({
                opacity: 0
            },
            600).css("z-index", 1);
        aPage.eq(index).stop().animate({
                opacity: 1
            },
            600).css("z-index", 2);
        aslide_img.eq(index).stop().animate({
                opacity: 1,
                top: -10
            },
            600).siblings('b').stop().animate({
                opacity: 0,
                top: -40
            },
            600);

    }

    function autoRun() {
        iNow++;
        if (iNow == ali.length) {
            iNow = 0;
        }
        slide(iNow);
    }

    var timer = setInterval(autoRun, 4000);

    ali.hover(function() {
            clearInterval(timer);
        },
        function() {
            timer = setInterval(autoRun, 4000);
        });
})
function getEnter(event) {
    if (event.keyCode == 13) {
        event.returnValue = false;
        document.getElementById('button1').click();
        return true;
    }
}
function jump() {
    var v = document.getElementById("txtval").value;
    if (v == "") {
        alert("请输入关键字！");
        return false;
    }
    window.open('../mall.soo56.com/search-' + v + '-0-0-0-0.html', "_blank");
}
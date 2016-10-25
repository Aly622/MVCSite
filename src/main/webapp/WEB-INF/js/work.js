/*
*author:Null
*DATE:2013.5.24
*/

$(function(){		   
//头页登录
$("#navul > li").not(".navhome").hover(function(){$(this).addClass("navmoon")},function(){$(this).removeClass("navmoon")})


var maxwidth = 580;
$(".news_text img").each(function(){
  if ($(this).width() > maxwidth) {
   $(this).width(maxwidth);}
   }); 
}); 
function $tomato(id) {
	return document.getElementById(id);
}
function runCode(obj) {
	var winname = window.open('', "_blank", '');
	winname.document.open('text/html', 'replace');
	winname.document.writeln(obj.value);
	winname.document.close();
}


(function($){
    $.fn.capacityFixed = function(options) {
        var opts = $.extend({},$.fn.capacityFixed.deflunt,options);
        var FixedFun = function(element) {
            var top = opts.top;
            element.css({
                "top":top,
				display:"none"
            });
            $(window).scroll(function() {
                var scrolls = $(this).scrollTop();
                if (scrolls > top) {

                    if (window.XMLHttpRequest) {
                        element.css({
                            position: "fixed",
                            top:0,
						display:""						
                        });
                    } else {
                        element.css({
                            top: scrolls,
						display:""
                        });
                    }
                }else {
                    element.css({
                        position: "absolute",
                        top: top,
						display:"none"
                    });
                }
            });
            element.find(".close-ico").click(function(event){
                element.remove();
                event.preventDefault();
            })
        };
        return $(this).each(function() {
            FixedFun($(this));
        });
    };
    $.fn.capacityFixed.deflunt={
		right : 0,//相对于页面宽度的右边定位
        top:644
	};
})(jQuery);





(function($){
    $.fn.capacityFixed1 = function(options) {
        var opts = $.extend({},$.fn.capacityFixed1.deflunt,options);
        var FixedFun = function(element) {
            var top = opts.top;
            element.css({
                "top":top,
				display:"none"
            });
            $(window).scroll(function() {
                var scrolls = $(this).scrollTop();
                if (scrolls > top) {

                    if (window.XMLHttpRequest) {
                        element.css({
                            position: "fixed",
                            top:50,
						display:""						
                        });
                    } else {
                        element.css({
                            top: scrolls,
						display:""
                        });
                    }
                }else {
                    element.css({
                        position: "absolute",
                        top: top,
						display:"none"
                    });
                }
            });
            element.find(".close-ico").click(function(event){
                element.remove();
                event.preventDefault();
            })
        };
        return $(this).each(function() {
            FixedFun($(this));
        });
    };
    $.fn.capacityFixed1.deflunt={
		right : 0,//相对于页面宽度的右边定位
        top:644
	};
})(jQuery);



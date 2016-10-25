<!--头部-->
<div class="hidden-l soo-common-topcnt">
    <div class="soo-common-container soo-common-top">
        <span class="soo-common-topleft">
            <a href="default.htm" target="_self">
                <img class="soo-common-homeicn" src="./images/tophome.png">
                &nbsp;Soo56首页
            </a>
            &nbsp;&nbsp;欢迎来到Soo56&nbsp;&nbsp;
            <a href="reg/login.html" target="_self">登陆</a>
            <a href="reg/reg.html" target="_self">注册</a>
        </span>
        <div class="soo-common-topright">
            <ul>
                <li>
                    <a class="">购物车</a>
                </li>
                <li>
                    <a href="../mall.soo56.com/user/orders.aspx">我的订单</a>
                </li>
                <li>
                    <a href="ruzhu/index.html">招商入驻</a>
                </li>
                <li>
                    <span class="soo-common-biaoti">客户服务</span>
                    <div class="soo-common-hidecnt">
                        <div class="soo-common-item">
                                <span class="">
                                    <a href="marking1/yhzc.html">
                                        帮助中心
                                    </a>
                                </span>
                                <span class="">
                                    <a href="marking1/shbz.html#a2">
                                        售后服务
                                    </a>
                                </span>
                            <i class=""></i>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="soo-common-head">
    <div class="soo-common-logo">
        <h1 class="float-left">
            <a href="default.htm">
                <img src="2014index/images/logo.jpg" />
            </a>
        </h1>
        &nbsp;&nbsp;
        <img src="shouye/images/beta.png" class="beta" />
    </div>
    <div class="soo-common-search">
        <div class="float-left">
            <div class="soo-common-searchmenu">
                <div class="soo-common-searchselect" id="soo-common-searchselect">
                    产品
                </div>
                <div class="soo-common-searchtab">
                    <ul>
                        <li onclick='$("#hid1").val(1);$("#soo-common-searchselect").html($(this).html());'
                            class="">
                            产品
                        </li>
                        <!--li onclick='$("#hid1").val(2);'>案例</li>
                        <li onclick='$("#hid1").val(3);$("#soo-common-searchselect").html($(this).html());'>
                            资讯
                        </li-->
                    </ul>
                </div>
            </div>
            <input type="hidden" value="1" id="hid1" />
            <div class="soo-common-searchcntbrt">
                <input type="text" class="soo-common-input" id="txtkeyword" value="请输入关键字"
                       onfocus="if (value =='请输入关键字'){value =''}" onblur="if (value ==''){value='请输入关键字'}"
                />
            </div>
        </div>
        <input type="button" class="soo-common-button" onclick="gopage()" id="button1"
        />
    </div>
    <div class="soo-common-login">
                <span class="soo-common-pic">
                </span>
        <a href="reg/login.html" rel="nofollow" target="_self">
            登录
        </a>
                <span>
                    |
                </span>
        <a href="reg/reg.html" rel="nofollow" target="_self">
            注册
        </a>
    </div>
</div>
<!--头部结束-->
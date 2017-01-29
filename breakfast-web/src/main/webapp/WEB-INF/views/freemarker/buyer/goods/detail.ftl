<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <p>商品详情</p>
    </header>

    <!-- details -->
    <main class="details">
        <div class="home-plusHint">加入成功</div>

        <div class="banner">
            <div class="img_gallery">
                <div class="main_imgDirect"><span id="main_imgCurrent">1</span>/<span id="main_imgTotal"></span></div>
                <div class="main_img">
                    <ul>
                        <li>
                            <img class="img-responsive" src="${var_domain_url}/file/img/~/${data.goods.mainImgPath!''}" alt=""/>
                        </li>
                    <#list data.goodsExtList as item>
                        <#if item.keyName?contains("img")></#if>
                    <li>
                            <img src="/file/img/~/${item.val!''}" style="width: 100%"/>
                    </li>
                    </#list>
                    </ul>
                    <a href="javascript:;" id="btn_prev"></a>
                    <a href="javascript:;" id="btn_next"></a>
                </div>
            </div>
        </div>

        <div class="details-main">
            <div class="details-main-info">
                <div class="details-main-name">
                    <p>${data.goods.name!''}</p>
                    <p class="red">￥${data.goods.price!''}</p>
                </div>
                <div class="clearfix"></div>
                <p>剩余<span>${data.goods.stock!''}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;已售<span>${data.goods.sales!''}</span></p>
                <#--<div class="details-main-detailsName">商品详情</div>-->
                <#--<div class="details-main-details">-->
                    <#--<p>文字描述：</p>-->
                    <#--<!--<img src="img/banner1.jpg" alt=""/>&ndash;&gt;-->
                <#--</div>-->
            </div>

            <div class="details-main-comment">
                <div class="details-main-commentTop">
                    <a href="comment.html">
                        <p>评价（5）</p>
                        <p>五星度：<span class="red">100%</span><i class="fa fa-chevron-right fa-1x"></i></p>
                    </a>
                </div>
                <div class="clearfix"></div>
                <div class="details-main-commentMain">
                    <div class="details-main-commentMain1">
                        <p>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                        </p>
                        <p>评价人</p>
                    </div>
                    <div class="clearfix"></div>
                    <p>评价内容：<span>太好吃了，不错！！</span></p>
                </div>
                <div class="details-main-commentMain">
                    <div class="details-main-commentMain1">
                        <p>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                        </p>
                        <p>评价人</p>
                    </div>
                    <div class="clearfix"></div>
                    <p>评价内容：<span>太好吃了，不错！！太好吃了，不错！！太好吃了，不错！！太好吃了，不错！！太好吃了，不错！！太好吃了，不错！！太好吃了，不错！！</span></p>
                </div>
                <div class="details-main-commentMain">
                    <div class="details-main-commentMain1">
                        <p>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                            <i class="fa fa-star fa-1x"></i>
                        </p>
                        <p>评价人</p>
                    </div>
                    <div class="clearfix"></div>
                    <p>评价内容：<span>太好吃了，不错！！</span></p>
                </div>
            </div>
        </div>

        <div class="details-foot">
            <div class="details-foot-carts">
                <i class="fa fa-shopping-cart fa-lg"></i>
                <p>购物车(0)</p>
            </div>
            <button type="button" value="">加入购物车</button>
        </div>
    </main>
    <!-- details -->
</section>

<!--鼠标手指左右滑动切换图片js插件-->
<script src="/js/~/base/slider.js"></script>
<script src="/js/lib/jquery/jquery.event.drag.js"></script>
<script src="/js/lib/jquery/jquery.touchSlider.js"></script>

<#include "freemarker/base/mallEnd.ftl">


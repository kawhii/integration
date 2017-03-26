<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <p>商品详情</p>
    </header>

    <!-- details -->
    <main class="details" id="ID_detailApp" v-cloak>

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
                            <img src="${var_domain_url}/file/img/~/${item.val!''}" style="width: 100%"/>
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
                <div class="details-main-detailsName">商品详情</div>
                <div class="details-main-details">
                    <p>${data.goods.note!''}</p>
                    <!--<img src="img/banner1.jpg" alt=""/>-->
                </div>
            </div>

            <#--<div class="details-main-comment">
                <div class="details-main-commentTop">
                    <a href="javascript:void()">
                        &lt;#&ndash;<p>评价（{{commentCount}}）</p>&ndash;&gt;
                        <p>&lt;#&ndash;五星度：<span class="red">100%</span><i class="fa fa-chevron-right fa-1x"></i>&ndash;&gt;</p>
                    </a>
                </div>
                <div class="clearfix"></div>
                <div class="details-main-commentMain" v-for="item in comment">
                    <div class="details-main-commentMain1">
                        <p class="comment-orders-goodsSubmitDetails">
                            <i v-if="item.grade>0" class="fa fa-star fa-1x select"></i>
                            <i v-else class="fa fa-star fa-1x unselect"></i>
                            <i v-if="item.grade>1" class="fa fa-star fa-1x select"></i>
                            <i v-else class="fa fa-star fa-1x unselect"></i>
                            <i v-if="item.grade>2" class="fa fa-star fa-1x select"></i>
                            <i v-else class="fa fa-star fa-1x unselect"></i>
                            <i v-if="item.grade>3" class="fa fa-star fa-1x select"></i>
                            <i v-else class="fa fa-star fa-1x unselect"></i>
                            <i v-if="item.grade>4" class="fa fa-star fa-1x select"></i>
                            <i v-else class="fa fa-star fa-1x unselect"></i>
                        </p>
                        <p>{{item.username}}</p>
                    </div>
                    <div class="clearfix"></div>
                    <p>评价内容：<span>{{item.content}}</span></p>
                </div>
            </div>
            <div class="loadmore" @click="loadMore">{{commentLoadTitle}}</div>-->
        </div>

        <div class="details-foot">
            <div class="details-foot-carts" @click="goCartPage()">
                <i class="fa fa-shopping-cart fa-lg"></i>
                <p v-cloak>购物车({{cartCount}})</p>
            </div>
            <input type="hidden" id="ID_goodsId" value="${data.goods.id}"/>
            <button type="button" value="" @click="addStopCart(${data.goods.id})">加入购物车</button>
        </div>
    </main>
    <!-- details -->
    <script src="/js/~/buyer/goods/detail.js"></script>
</section>

<!--鼠标手指左右滑动切换图片js插件-->
<script src="/js/~/base/slider.js"></script>
<script src="/js/lib/jquery/jquery.event.drag.js"></script>
<script src="/js/lib/jquery/jquery.touchSlider.js"></script>

<#include "freemarker/base/mallEnd.ftl">


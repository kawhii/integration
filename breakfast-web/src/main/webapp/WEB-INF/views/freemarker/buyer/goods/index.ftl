<#include "freemarker/base/mallBase.ftl">
<#--<script type="text/javascript" src="/js/~/admin/index.js"></script>-->
<section class="contain">
    <header class="header">
        <p>早餐供应平台</p>
    </header>

    <!-- home -->
    <main class="home">
        <div class="home-plusHint">添加成功</div>

        <div class="home-search">
            <div class="search">
                <i class="fa fa-search fa-1x"></i>
                <input type="text" placeholder="搜索" value=""/>
            </div>
        </div>
        <div class="home-main" id="ID_goodsApp">

            <div class="home-goods" v-for="item in items">
                <a href="details.html">
                    <div class="home-img">
                        <img v-bind:src="'/file/img/~/' + item.mainImgPath" alt=""/>
                    </div>
                    <div class="home-info">
                        <p class="home-goods-name">{{item.name}}</p>
                        <p class="home-goods-price">￥{{item.price}}</p>
                        <p class="home-goods-sales">销量：<span>{{item.sales}}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好评：<span>80%</span></p>
                    </div>
                </a>
                <div class="home-plus">
                    <i class="fa fa-plus-circle fa-lg"></i>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </main>
    <script src="/js/~/buyer/goods/list.js"></script>
    <!-- home -->
<#include "freemarker/base/mallFooter.ftl">
</section>

<#include "freemarker/base/mallEnd.ftl">


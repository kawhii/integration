<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <p>包将军&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金品质</p>
    </header>

    <!-- home -->
    <main class="home" id="ID_goodsApp" v-cloak>
        <div class="home-plusHint">添加成功</div>

        <div class="home-search">
            <div class="search">
                <i class="fa fa-search fa-1x"></i>
                <input type="search" autofocus x-webkit-speech v-on:keyup.enter="search" v-model="searchTx" placeholder="搜索（送餐时间：7:30-8:30）"/>
            </div>
        </div>
        <div class="home-main">

            <div class="home-goods" v-for="item in items">
                <a v-bind:href="'/goods/detail/' + item.id">
                    <div class="home-img">
                        <img v-bind:src="'${var_domain_url}/file/img/~/' + item.mainImgPath" alt=""/>
                    </div>
                    <div class="home-info">
                        <p class="home-goods-name">{{item.name}}</p>
                        <p class="home-goods-price">￥{{item.price}}</p>
                        <p class="home-goods-sales">销量：<span>{{item.sales}}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好评：<span>{{item.grade/100}}%</span></p>
                    </div>
                </a>
                <div class="home-plus" @click="addStopCart(item)">
                    <i class="fa fa-plus-circle fa-lg"></i>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="loadmore" @click="loadMore">{{loadMoreTitle}}</div>
        </div>
    </main>
    <script src="/js/~/buyer/goods/list.js"></script>
    <!-- home -->
<#include "freemarker/base/mallFooter.ftl">
</section>

<#include "freemarker/base/mallEnd.ftl">


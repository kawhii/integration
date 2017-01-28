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
    <!-- home -->

    <footer class="nav">
        <ul>
            <a href="home.html">
                <li><i class="fa fa-home fa-lg"></i><p>首页</p></li>
            </a>
            <a href="carts.html">
                <li><i class="fa fa-shopping-cart fa-lg"></i><p>购物车</p></li>
            </a>
            <a href="orders.html">
                <li><i class="fa fa-star fa-lg"></i><p>订单</p></li>
            </a>
            <a href="person.html">
                <li><i class="fa fa-user fa-lg"></i><p>我的</p></li>
            </a>
        </ul>
    </footer>
</section>
<script src="/js/~/buyer/goods/list.js"></script>
<#include "freemarker/base/mallEnd.ftl">


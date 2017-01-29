
<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <button type="button" value="" class="carts-edit">编辑</button>
        <p>购物车( <span class="cartsNum">0</span> )</p>
    </header>

    <!-- carts -->
    <main class="carts">
        <div class="home-plusHint">删除成功</div>
        <!--<div class="popupHint" id="cartsdeleteHint">
            <div class="popupHint-top">删除成功！</div>
            <div class="popupHintBtn"><button type="button">确定</button></div>
        </div>-->

        <div class="carts-main">
            <div class="carts-goods">
                <div class="carts-goodsLeft">
                    <div class="carts-choose">
                        <div class="carts-choosebox"></div>
                        <input type="checkbox" name="carts-choose[]"/>
                    </div>
                    <div class="carts-img">
                        <a href="#"><img src="img/goods.jpg" alt=""/></a>
                    </div>
                    <div class="carts-info">
                        <p class="carts-goods-name">双龙出火</p>
                        <p class="carts-goods-price">￥666</p>
                    </div>
                    <div class="carts-number">
                        <ul>
                            <li class="carts-minus"><i class="fa fa-minus fa-1x"></i></li>
                            <li class="singleNum">1</li>
                            <li class="carts-plus"><i class="fa fa-plus fa-1x"></i></li>
                        </ul>
                    </div>
                </div>
                <div class="carts-goodsRight">删除</div>
                <div class="clearfix"></div>
            </div>
            <div class="carts-goods">
                <div class="carts-goodsLeft">
                    <div class="carts-choose">
                        <div class="carts-choosebox"></div>
                        <input type="checkbox" name="carts-choose[]"/>
                    </div>
                    <div class="carts-img">
                        <a href="#"><img src="img/goods.jpg" alt=""/></a>
                    </div>
                    <div class="carts-info">
                        <p class="carts-goods-name">双龙出火</p>
                        <p class="carts-goods-price">￥666</p>
                    </div>
                    <div class="carts-number">
                        <ul>
                            <li class="carts-minus"><i class="fa fa-minus fa-1x"></i></li>
                            <li class="singleNum">1</li>
                            <li class="carts-plus"><i class="fa fa-plus fa-1x"></i></li>
                        </ul>
                    </div>
                </div>
                <div class="carts-goodsRight">删除</div>
                <div class="clearfix"></div>
            </div>
            <div class="carts-goods">
                <div class="carts-goodsLeft">
                    <div class="carts-choose">
                        <div class="carts-choosebox"></div>
                        <input type="checkbox" name="carts-choose[]"/>
                    </div>
                    <div class="carts-img">
                        <a href="#"><img src="img/goods.jpg" alt=""/></a>
                    </div>
                    <div class="carts-info">
                        <p class="carts-goods-name">双龙出火</p>
                        <p class="carts-goods-price">￥666</p>
                    </div>
                    <div class="carts-number">
                        <ul>
                            <li class="carts-minus"><i class="fa fa-minus fa-1x"></i></li>
                            <li class="singleNum">1</li>
                            <li class="carts-plus"><i class="fa fa-plus fa-1x"></i></li>
                        </ul>
                    </div>
                </div>
                <div class="carts-goodsRight">删除</div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="carts-foot">
            <div class="carts-chooseAll">
                <div class="carts-chooseAllbox"></div>
                <p class="carts-chooseAllbox_p">全选</p>
                <input type="checkbox" id="carts-chooseAll"/>
            </div>
            <div class="carts-price">
                <p><span>合计：</span><span class="priceTotal red">￥0.00</span><br/><span>不含运费</span></p>
                <a href="orders-fill.html"><div class="carts-count">结算( <span class="cartsNum">0</span> )</div></a>
            </div>
        </div>
    </main>
    <!-- carts -->
<#include "freemarker/base/mallFooter.ftl">
</section>

<!--鼠标手指左右滑动切换图片js插件-->
<script src="/js/~/base/slider.js"></script>
<script src="/js/lib/jquery/jquery.event.drag.js"></script>
<script src="/js/lib/jquery/jquery.touchSlider.js"></script>

<#include "freemarker/base/mallEnd.ftl">
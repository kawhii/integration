<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <button type="button" value="1" class="carts-edit">编辑</button>
        <p>购物车( <span class="cartsNum">0</span> )</p>
    </header>

    <!-- carts -->
    <main class="carts" id="ID_CartGoodsApp">
        <div class="home-plusHint">删除成功</div>
        <!--<div class="popupHint" id="cartsdeleteHint">
            <div class="popupHint-top">删除成功！</div>
            <div class="popupHintBtn"><button type="button">确定</button></div>
        </div>-->

        <div class="carts-main">
        <#list data.goods as item>
            <#if data.goodsRel[item.id + ""] gt 0>


                <div class="carts-goods">
                    <div class="carts-goodsLeft">
                        <div class="carts-choose">
                            <div class="carts-choosebox"></div>
                            <input type="checkbox" name="carts-choose[]" value="${item.id}"/>
                        </div>
                        <div class="carts-img">
                            <a href="#"><img src="${var_domain_url}/file/img/~/${item.mainImgPath!''}" alt=""/></a>
                        </div>
                        <div class="carts-info">
                            <p class="carts-goods-name">${item.name}</p>
                            <p class="carts-goods-price">￥${item.price}</p>
                        </div>
                        <div class="carts-number">
                            <ul>
                                <li class="carts-minus" @click="minus(${item.id},$event)">
                                    <i class="fa fa-minus fa-1x"></i></li>
                                <li class="singleNum">${data.goodsRel[item.id + ""]}</li>
                                <li class="carts-plus" @click="plus(${item.id},$event)"><i class="fa fa-plus fa-1x"></i>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="carts-goodsRight" @click="remove(${item.id},$event)">删除</div>
                    <div class="clearfix"></div>
                </div>
            </#if>
        </#list>
        </div>

        <div class="carts-foot">
            <div class="carts-chooseAll">
                <div class="carts-chooseAllbox"></div>
                <p class="carts-chooseAllbox_p">全选</p>
                <input type="checkbox" id="carts-chooseAll"/>
            </div>
            <div class="carts-price">
                <p><span>合计：</span><span class="priceTotal red">￥0.00</span><br/><span>不含运费</span></p>
                <a href="#">
                    <div class="carts-count" @click="editChoose()">结算( <span class="cartsNum">0</span> )</div>
                </a>
            </div>
        </div>
    </main>
    <script src="/js/~/buyer/cart/listGoods.js"></script>
    <!-- carts -->
<#include "freemarker/base/mallFooter.ftl">
</section>

<!--鼠标手指左右滑动切换图片js插件-->
<script src="/js/~/base/slider.js"></script>
<script src="/js/lib/jquery/jquery.event.drag.js"></script>
<script src="/js/lib/jquery/jquery.touchSlider.js"></script>

<#include "freemarker/base/mallEnd.ftl">
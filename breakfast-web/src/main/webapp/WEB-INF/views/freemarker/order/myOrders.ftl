<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <i class="fa fa-chevron-left fa-1x return" id="orders-fillReturn"></i>
        <p>${title!'我的订单'}</p>
    </header>
    <!-- orders -->
    <main class="orders" id="ID_myOrdersApp">
        <div class="popupHint" id="deleteHint">
            <div class="popupHint-top">确认删除此订单？</div>
            <ul>
                <li>取消</li>
                <a href="#"><li id="ordersDelete">删除</li></a>
            </ul>
        </div>

        <div class="orders-goods">
            <div class="orders-top">
                <p>订单号：20140111123456</p>
                <i class="fa fa-trash-o fa-lg ordersDeleteBtn"></i>
            </div>
            <div class="clearfix"></div>
            <div class="orders-info">
                <a href="orders-details.html">
                    <ul>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                    </ul>
                </a>
            </div>
            <div class="clearfix"></div>
            <div class="orders-foot">
                <div class="orders-foot1">
                    <p class="orders-foot1Left">状态：<span>已完成</span></p>
                    <p class="orders-foot1Right">共5件商品&nbsp;&nbsp;&nbsp;<span class="red">实付款：￥0.00</span></p>
                </div>
                <div class="clearfix"></div>
                <div class="orders-foot2">
                    <button type="button" value="" class="review">评价晒单</button>
                    <button type="button" value="" class="buyAgain">再次购买</button>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="orders-goods">
            <div class="orders-top">
                <p>订单号：20140111123456</p>
                <i class="fa fa-trash-o fa-lg ordersDeleteBtn"></i>
            </div>
            <div class="clearfix"></div>
            <div class="orders-info">
                <a href="orders-details.html">
                    <ul>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                    </ul>
                </a>
            </div>
            <div class="clearfix"></div>
            <div class="orders-foot">
                <div class="orders-foot1">
                    <p class="orders-foot1Left">状态：<span>已完成</span></p>
                    <p class="orders-foot1Right">共5件商品&nbsp;&nbsp;&nbsp;<span class="red">实付款：￥0.00</span></p>
                </div>
                <div class="clearfix"></div>
                <div class="orders-foot2">
                    <button type="button" value="" class="review">评价晒单</button>
                    <button type="button" value="" class="buyAgain">再次购买</button>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

        <div class="orders-goods">
            <div class="orders-top">
                <p>订单号：20140111123456</p>
                <i class="fa fa-trash-o fa-lg ordersDeleteBtn"></i>
            </div>
            <div class="clearfix"></div>
            <div class="orders-info">
                <a href="orders-details.html">
                    <ul>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                        <li><img src="img/goods.jpg" alt=""/></li>
                    </ul>
                </a>
            </div>
            <div class="clearfix"></div>
            <div class="orders-foot">
                <div class="orders-foot1">
                    <p class="orders-foot1Left">状态：<span>已完成</span></p>
                    <p class="orders-foot1Right">共5件商品&nbsp;&nbsp;&nbsp;<span class="red">实付款：￥0.00</span></p>
                </div>
                <div class="clearfix"></div>
                <div class="orders-foot2">
                    <button type="button" value="" class="review">评价晒单</button>
                    <button type="button" value="" class="buyAgain">再次购买</button>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </main>
    <!-- orders -->
<#include "freemarker/base/mallFooter.ftl">
</section>
<script>

</script>
<#include "freemarker/base/mallEnd.ftl">
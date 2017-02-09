<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <a href="javascript:history.go(-1);"><i class="fa fa-chevron-left fa-1x return"></i></a>
        <p>订单详情</p>
    </header>

    <!-- orders-details -->
    <main class="orders-details">
        <div class="popupHint" id="deleteHint">
            <div class="popupHint-top">确认删除此订单？</div>
            <ul>
                <li>取消</li>
                <a href="#">
                    <li id="ordersDelete">删除</li>
                </a>
            </ul>
        </div>

        <div class="orders-details-top">
            <p>订单号：${order.orderNo}</p>
            <div class="orders-detailsAddr">
                <p>
                    收货人：<span>${order.contactName}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话：<span>${order.contactPhone}</span>
                </p>
                <p>收货地址：<span>${order.address}</span></p>
            </div>
        </div>
        <div class="orders-details-main">
        <#list order.items as item>
            <div class="orders-details-goods">
                <div class="orders-details-img">
                    <a href="#"><img src="${var_domain_url}/file/img/~/${item.goodsImgPath}" alt=""/></a>
                </div>
                <div class="orders-details-info">
                    <p class="orders-details-goods-name">${item.goodsTitle}</p>
                    <p class="orders-details-goods-price">￥${item.unitPrice}</p>
                </div>
                <div class="carts-number">
                    <p>x<span>1</span></p>
                </div>
                <div class="clearfix"></div>
            </div>
        </#list>
            <div class="guestbook">
                <textarea placeholder="选填：给商家留言（45字以内）"></textarea>
            </div>

            <div class="orders-money">
                <p>商品金额</p>
                <p class="red">￥${order.price}</p>
                <div class="clearfix"></div>
            </div>

        </div>

        <div class="orders-details-foot">
            <div class="orders-details-footLeft ordersDeleteBtn">删除订单</div>
            <div class="orders-details-footRight">
                <a href="comment-orders.html">
                    <button type="button" value="" class="review">评论晒单</button>
                </a>
                <a href="carts.html">
                    <button type="button" value="" class="buyAgain">再次购买</button>
                </a>
            </div>
        </div>
    </main>
    <!-- orders-details -->

</section>
<#include "freemarker/base/mallEnd.ftl">
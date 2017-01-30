<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <i class="fa fa-chevron-left fa-1x return" id="orders-fillReturn"></i>
        <p>${title!'填写订单'}</p>
    </header>
    <!-- orders-fill -->
    <main class="orders-fill">

        <div class="popupHint" id="returnHint">
            <div class="popupHint-top">便宜不等人，请三思而行~</div>
            <ul>
                <li>我再想想</li>
                <a href="javascript:history.go(-1);">
                    <li>去意已决</li>
                </a>
            </ul>
        </div>

        <div class="orders-details-top">
            <a href="address.html"><i class="fa fa-chevron-right fa-2x goAddress"></i></a>
            <div class="orders-detailsAddr">
                <p>收货人 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系电话</p>
                <p>收货地址</p>
            </div>

        </div>
        <div class="orders-details-main">
        <#list data as item>
            <div class="orders-details-goods">
                <div class="orders-details-img">
                    <a href="#"><img src="${var_domain_url}/file/img/~/${item.goods.mainImgPath!''}"</a>
                </div>
                <div class="orders-details-info">
                    <p class="orders-details-goods-name">${item.goods.name}</p>
                    <p class="orders-details-goods-price">￥${item.goods.price}</p>
                </div>
                <div class="carts-number">
                    <p>x<span>${item.qat.quantity}</span></p>
                </div>
                <div class="clearfix"></div>
            </div>
        </#list>



            <div class="guestbook">
                <textarea placeholder="选填：给商家留言（45字以内）"></textarea>
            </div>

            <div class="orders-money">
                <p>商品金额</p>
                <p class="red">￥0.00</p>
                <div class="clearfix"></div>
            </div>

        </div>

        <div class="orders-fill-foot">
            <div class="orders-fill-choose">
                <div class="orders-fill-choosebox"></div>
                <p class="orders-fill-choosebox_p">加餐</p>
                <input type="checkbox" id="orders-fill-choose"/>
            </div>
            <div class="orders-fill-price">
                <p><span>实付款：</span><span class="priceTotal red">￥0.00</span><br/><span>不含运费</span></p>
                <a href="#">
                    <button type="button" value="" class="orders-submit">提交订单</button>
                </a>
            </div>
        </div>

    </main>
    <!-- orders-fill -->

</section>

<#include "freemarker/base/mallEnd.ftl">
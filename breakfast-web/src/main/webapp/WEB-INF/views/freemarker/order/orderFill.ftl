<#include "freemarker/base/mallBase.ftl">
<section class="contain">
    <header class="header">
        <i class="fa fa-chevron-left fa-1x return" id="orders-fillReturn"></i>
        <p>${title!'填写订单'}</p>
    </header>
    <!-- orders-fill -->
    <main class="orders-fill">
        <form name="createOrderForm">
            <div class="popupHint" id="returnHint">
                <div class="popupHint-top">便宜不等人，请三思而行~</div>
                <ul>
                    <li>我再想想</li>
                    <a href="<#if goCart??>/cart/listGoods.html<#else>javascript:history.go(-1);</#if>">
                        <li>去意已决</li>
                    </a>
                </ul>
            </div>
            </div>
            <div class="orders-details-top">
                <a href="/user/address.html"><i class="fa fa-chevron-right fa-2x goAddress"></i></a>
                <div class="orders-detailsAddr">
                    <p>收货人：${address.contactsName} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${address.contactsPhone}</p>
                    <p>收货地址：${address.detail}</p>
                    <input type="hidden" name="addressId" value="${address.id}"/>
                </div>

            </div>
            <div class="orders-details-main">
            <#list data as item>
                <div class="orders-details-goods">
                    <div class="orders-details-img">
                        <a href="javascript:void(0)"><img src="${var_domain_url}/file/img/~/${item.goods.mainImgPath!''}"</a>
                    </div>
                    <div class="orders-details-info">
                        <p class="orders-details-goods-name">${item.goods.name}</p>
                        <p class="orders-details-goods-price">￥${item.goods.price}</p>
                    </div>
                    <div class="carts-number">
                        <p>x<span>${item.qat.quantity}</span></p>
                    </div>
                    <div class="clearfix"></div>
                    <input type="hidden" name="goods" value="{id : ${item.goods.id}, qt: ${item.qat.quantity}}"/>
                </div>
            </#list>



                <div class="guestbook">
                    <textarea id="ID_message" placeholder="选填：给商家留言（45字以内）"></textarea>
                </div>

                <div class="orders-money">
                    <p>商品金额</p>
                    <p class="red">￥${totalPrice}</p>
                    <div class="clearfix"></div>
                </div>

            </div>

            <div class="orders-fill-foot">
                <div class="orders-fill-choose">
                    <div class="orders-fill-choosebox"></div>
                    <p class="orders-fill-choosebox_p">加急</p>
                    <input type="checkbox" name="fillChoose" id="orders-fill-choose"/>
                </div>
                <div class="orders-fill-price">
                    <p><span>实付款：</span><span class="red">￥${totalPrice}</span><br/><span>不含运费</span></p>
                    <a href="javascript:void(0)">
                        <button type="button" id="ID_submitBtn" value="" class="orders-submit">提交订单</button>
                    </a>
                </div>
            </div>
        </form>
    </main>
    <!-- orders-fill -->

</section>
<script src="//res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="/js/~/order/orderFill.js"></script>

<#include "freemarker/base/mallEnd.ftl">
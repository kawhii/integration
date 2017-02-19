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
                    <a href="javascript:history.go(-1);">
                        <li>去意已决</li>
                    </a>
                </ul>
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
                    <a href="#">
                        <button type="button" id="ID_submitBtn" value="" class="orders-submit">提交订单</button>
                    </a>
                </div>
            </div>
        </form>
    </main>
    <!-- orders-fill -->

</section>
<script src="//res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    (function () {
        //获取订单数据
        var orderData = $('form[name="createOrderForm"]').serializeArray();
        var orderJson = {};
        for (var i in orderData) {
            var obj = orderData[i];
            var val = null;
            try {
                val = eval('(' + obj.value + ')');
            } catch (e) {
                alert("请确认收货地址");
                return;
            }
            var cont = orderJson[obj.name];
            if (cont) {
                if (cont instanceof Array) {
                    cont.push(val);
                } else {
                    cont = [cont, val];
                }
            } else {
                if (obj.name == 'goods') {
                    cont = [val];
                } else {
                    cont = val;
                }
            }
            orderJson[obj.name] = cont;
        }

        $('#ID_submitBtn').click(function () {
            //是否有选加急
            orderJson.vexedly = $('#orders-fill-choose').parent().find('.orders-fill-choosebox').hasClass('carts-chooseboxBg')
            orderJson.message = $('#ID_message').val();
            //请求创建订单
            carl.request("/order/create.action", orderJson, function (data) {
                //配置
                wx.config({
                    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: data.body.app.appId, // 必填，公众号的唯一标识
                    timestamp:  data.body.payData.timestamp, // 必填，生成签名的时间戳
                    nonceStr: data.body.payData.noncestr, // 必填，生成签名的随机串
                    signature: data.body.payData.paySign,// 必填，签名，见附录1
                    jsApiList: ["chooseWXPay"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
                //支付
            }, {get: false});
        });
    })();

</script>
<#include "freemarker/base/mallEnd.ftl">
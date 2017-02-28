/**
 *
 * @author Carl
 * @date 2017/2/25
 * © 2017 - 2020 , all rights reserved .卡尔工作室
 */
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
            carl.toast("请确认收货地址");
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
        orderJson.vexedly = $('#orders-fill-choose').parent().find('.orders-fill-choosebox').hasClass('carts-chooseboxBg');
        orderJson.message = $('#ID_message').val();
        //请求创建订单
        if(!orderJson.goods || orderJson.goods.length <=0) {
            alert("还没有选购商品哦，是不是下架了？");
            return;
        }
        carl.request("/order/create.action", orderJson, function (data) {
            //配置
            wx.config({
//                    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: data.body.app.appid, // 必填，公众号的唯一标识
                timestamp: data.body.payData.timestamp, // 必填，生成签名的时间戳
                nonceStr: data.body.payData.noncestr, // 必填，生成签名的随机串
                signature: data.body.payData.paySign,// 必填，签名，见附录1
                jsApiList: ["chooseWXPay"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
            });

            wx.ready(function () {
                // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
                wx.chooseWXPay({
                    timestamp: data.body.app.timestamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
                    nonceStr: data.body.app.nonceStr, // 支付签名随机串，不长于 32 位
                    package: data.body.app.packageStr, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
                    signType: 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
                    paySign: data.body.app.paySign, // 支付签名
                    success: function (res) {
                        // 支付成功后的回调函数
//                            console.info(res);
                        //要求减库存
                        carl.request("/order/cart.action", orderJson, function (data) {
                            window.location.href = "/order/myOrders.html";
                        },{get: false});
                    }
                });
            });

            //支付
        }, {get: false});
    });
})();
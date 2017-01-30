/**
 * @date 2017/1/29
 *
 * @author Carl
 * @note
 * --------------------
 * @depend
 * @modify
 * 版权所有.(c)2008-2017.卡尔工作室
 */
!(function () {
    'use strict';
    var goodsId = $('#ID_goodsId').val();

    var app = new Vue({
        el: '#ID_detailApp',
        data: {
            //当前商品购物车数量
            cartCount: 2
        }, methods: {
            //添加到购物车
            addStopCart: function (id) {
                carl.request("/cart/addGoods", {quantity: 1, goodsId: id},
                    function (data) {
                        if (data.header.code == 0) {
                            app.cartCount++;
                            carl.toast("添加成功");
                        }
                    }, {get: false});
            }
        }
    });

    //加载购物车当前商品数量
    function loadCardGoodsCount(goodsId) {
        carl.request("/cart/queryGoodsCount", {goodsId: goodsId}, function (data) {
            if (data.header.code == 0) {
                app.cartCount = data.body;
            }
        }, {mask: false});
    }
    loadCardGoodsCount(goodsId);

}());

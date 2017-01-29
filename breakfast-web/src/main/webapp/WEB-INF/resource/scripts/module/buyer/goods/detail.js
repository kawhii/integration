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
    var app = new Vue({
        el: '#ID_detailApp',
        data: {
        }, methods: {
            //添加到购物车
            addStopCart: function (id) {
                carl.request("/cart/addGoods", {quantity: 1, goodsId: id},
                    function (data) {
                        if(data.header.code == 0) {
                            carl.toast("添加成功");
                        }
                    }, {get: false});
            }
        }
    });

}());

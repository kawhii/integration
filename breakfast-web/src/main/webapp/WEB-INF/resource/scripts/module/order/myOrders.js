/**
 *
 * @author Carl
 * @date 2017/2/9
 * © 2017 - 2020 , all rights reserved .卡尔工作室
 */

!(function () {
    'use strict';
    var app = new Vue({
        el: '#ID_myOrdersApp',
        data: {
            //订单数据
            orders: []
        }, methods: {
            //删除订单
            removeOrder: function (goods, index) {
                $(".carts-goodsRight").on("touchstart",function(event){
                    if(event.originalEvent.changedTouches.length == 1){
                        event.preventDefault();

                        $("#cartsdeleteHint").show(500);
                    }
                });

                $(".popupHintBtn button").on("touchstart",function(event){
                    if(event.originalEvent.changedTouches.length == 1){
                        event.preventDefault();

                        $("#cartsdeleteHint").hide(500);
                    }
                });
                this.orders.splice(index, 1)
            }
        }
    });

    var page = 1;

    //订单数据
    function loadOrders(page) {
        carl.request("/order/myOrders.json", {page: page}, function (data) {
            if (data.header.code == 0 && data.body.recordList.length > 0) {
                for (var i in data.body.recordList) {
                    app.orders.push(data.body.recordList[i]);
                }
                setTimeout(function () {
                    $(".contain").attr('style', '');
                }, 100);
            }
        });
    }

    loadOrders(page);

}());

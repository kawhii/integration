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
        }, methods: {}
    });

    var page = 1;

    //订单数据
    function loadOrders(page) {
        carl.request("/order/myOrders.json", {page: page}, function (data) {

            if (data.header.code == 0 && data.body.recordList.length > 0) {
                for (var i in data.body.recordList) {
                    app.orders.push(data.body.recordList[i]);
                }
            }
        });
    }

    loadOrders(page);


}());

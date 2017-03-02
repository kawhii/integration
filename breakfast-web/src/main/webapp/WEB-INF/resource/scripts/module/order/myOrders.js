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
            orders: [],
            //前端是否加载完成
            loaded: false,
            loadMoreTitle: '点击加载更多',
        }, methods: {
            //去评论
            goComment: function (orderId) {
                window.location.href = "/order/" + orderId + "/comment";
            },
            //删除订单
            removeOrder: function (goods, index) {
                var flag = window.confirm("确定删除该订单？");
                if (flag) {
                    carl.request("/order/" + goods.id + "/delete", {}, function (data) {
                        if (data.header.code == 0) {
                            app.orders.splice(index, 1);
                        }
                    });
                }
            },
            loadMore: function () {
                page++;
                loadOrders(page);
            }
        }
    });

    var page = 1, nextLoad = true;

    //订单数据
    function loadOrders(page) {
        if (nextLoad) {
            carl.request("/order/myOrders.json", {page: page}, function (data) {
                app.loaded = true;
                if (data.header.code == 0 && data.body.recordList.length > 0) {
                    if(page >= data.body.totalPage) {
                        nextLoad = false;
                        app.loadMoreTitle = "这是所有订单了呦~";
                    }
                    for (var i in data.body.recordList) {
                        app.orders.push(data.body.recordList[i]);
                    }
                    setTimeout(function () {
                        $(".contain").attr('style', '');
                    }, 100);
                }
            });
        } else {
            app.loadMoreTitle = "这是所有订单了呦~";
        }
    }

    loadOrders(page);

}());

/**
 * 商品列表
 * @date 2016/12/5
 *
 * @author Carl
 * @note
 * --------------------
 * @depend
 * @modify
 * 版权所有.(c)2008-2016.卡尔工作室
 */
!(function () {
    'use strict';
    var app = new Vue({
        el: '#ID_goodsApp',
        data: {
            items: []
        }
    });

    var $scope = {
        //当前页码
        page: 1
    };

    function BuyerGoodsListCtrl() {
        //所有数据
        //是否还有下一页
        $scope.haveNextPage = true;

        //加载数据
        function pullData() {
            carl.request("/goods/list.json", {
                page: $scope.page
            }, function (data) {
                $scope.haveNextPage = data.body.endPageIndex - data.body.currentPage >= 1;
                app.items = app.items.concat(data.body.recordList);
            });
        }

        //加载更多
        $scope.loadMore = function () {
            $scope.page++;
            pullData();
        };

        pullData();
    }

    BuyerGoodsListCtrl();
}());

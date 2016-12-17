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
    angular.module('BuyerGoods', ['App'])
        .controller("BuyerGoodsListCtrl", BuyerGoodsListCtrl);

    function BuyerGoodsListCtrl($scope, $request) {
        //当前页码
        var page = 1;
        //所有数据
        $scope.items = [];
        //是否还有下一页
        $scope.haveNextPage = true;

        //加载数据
        function pullData() {
            $request.get("/goods/list.json", {
                page: page
            }, function (data) {
                $scope.haveNextPage = data.body.endPageIndex - data.body.currentPage >= 1;
                $scope.items = $scope.items.concat(data.body.recordList);
            });
        }

        //加载更多
        $scope.loadMore = function () {
            page++;
            pullData();
        };

        pullData();
    }

    angular.bootstrap(document.getElementById("ID_BuyerGoods"),
        ['BuyerGoods']);
}());

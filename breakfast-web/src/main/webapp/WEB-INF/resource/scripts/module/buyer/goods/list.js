/**
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
        var page = 1;
        $scope.items = [];
        $scope.haveNextPage = true;

        //加载数据
        function pullData() {
            $request.get("/goods/list.json", {
                page: page,
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

        var imagePath = 'img/list/60.jpeg';
    }

    angular.bootstrap(document.getElementById("ID_BuyerGoods"),
        ['BuyerGoods']);
}());

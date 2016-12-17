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

        //添加到购物车
        $scope.addCart = function (id) {
            console.info(id);
            //获取商品id，获取数量，请求服务器，返回成功关闭
            /*$request.post("/cart/addGoods", {quantity: 1, goodsId: id},
                function (data) {
                    //添加成功
                    $toast.showActionToast("添加成功");
                }, {mask: true});*/
        };

        $scope.goDetail = function(url) {
            console.info(url);
        };

        pullData();
    }

    angular.bootstrap(document.getElementById("ID_BuyerGoods"),
        ['BuyerGoods']);
}());

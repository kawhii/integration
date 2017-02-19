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
            items: [],
            loadMoreTitle : ""
        }, methods: {
            //添加到购物车
            addStopCart: function (item) {
                carl.request("/cart/addGoods", {quantity: 1, goodsId: item.id},
                    function (data) {
                        if (data.header.code == 0) {
                            carl.toast("添加成功");
                        }
                    }, {get: false});
            },
            loadMore : function () {
                if($scope.haveNextPage) {
                    $scope.loadMore();
                } else {
                    app.loadMoreTitle = "已经看完所有商品啦~";
                }
            }
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
                page: $scope.page,
                pageSize : 15
            }, function (data) {
                $scope.haveNextPage = (data.body.endPageIndex - data.body.currentPage) >= 1;
                app.items = app.items.concat(data.body.recordList);
                app.loadMoreTitle = "点击加载更多...";
            });
        }

        //由于高度的问题重写设
        function setHeight() {
            var bodyHeight = $(document).height();
            $(".contain").height(bodyHeight);
            setTimeout(setHeight, 5000)
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

;(function () {
    angular.module('StopCart', ['ngMaterial', 'App'])

        .controller('ListCtrl', function ($scope, $toast, $request) {

            $scope.items = stopCart;
            $scope.goodsTotal = 0;

            $scope.priceTotal = 0;

            $scope.buyState = {};

            $scope.submitGoods = [];

            //计算价钱
            function priceReload() {
                $scope.priceTotal = 0;
                $scope.goodsTotal = 0;
                $scope.submitGoods = [];
                //若有勾选了，才计算
                if(!$scope.items.goods)
                    return;
                angular.forEach($scope.items.goods, function (item) {
                    if ($scope.buyState[item.id] === true) {
                        $scope.goodsTotal++;
                        $scope.priceTotal += (item.price * $scope.items.goodsRel[item.id]);
                        $scope.submitGoods.push({id:item.id, quantity : $scope.items.goodsRel[item.id]});
                    }
                });
            }

            //当购买状态改变时触发
            //计算总价
            $scope.$watchCollection("buyState", function () {
                priceReload();
            });

            //数量改变的时候
            $scope.$watchCollection("items.goodsRel", function () {
                priceReload();
            });

            //编辑模式
            $scope.edit = function (item) {
                if (!item.isEdit) {
                    item.isEdit = true;
                } else {
                    item.isEdit = false;
                }
            };

            //减
            $scope.minus = function (item) {
                if ($scope.items.goodsRel[item.id] == 1)
                    return;
                $request.post("/cart/operateGoods", {
                    goods: {
                        goodsId: item.id,
                        quantity: 1
                    }, type: 2
                }, function () {
                    $scope.items.goodsRel[item.id]--;
                });
            };
            //加
            $scope.plus = function (item) {
                $request.post("/cart/operateGoods", {
                    goods: {
                        goodsId: item.id,
                        quantity: 1
                    }, type: 1
                }, function () {
                    $scope.items.goodsRel[item.id]++;
                });
            };
            //删除
            $scope.delete = function (item, index) {
                var r = confirm("确定要删除【" + item.title + "】？");
                if(r) {
                    $request.post("/cart/operateGoods", {
                        goods: {
                            goodsId: item.id,
                            quantity: 1
                        }, type: 3
                    }, function () {
                        //移除
                        $scope.items.goods.splice(index, 1);
                        $scope.items.goodsRel[item.id] = 0;
                    });
                }
            };

            //创建订单
            $scope.createOrder = function () {
                if ($scope.priceTotal == 0) {
                    $toast.showActionToast("您还没有选择宝贝哦~");
                    return;
                }
                //TODO 提交订单
                console.info($scope.submitGoods);
                document.getElementById("ID_form").submit();
            }
        });
}());
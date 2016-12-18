;(function () {
    angular.module('StopCart', ['ngMaterial', 'App'])

        .controller('ListCtrl', function ($scope, $toast) {

            $scope.items = stopCart;
            $scope.goodsTotal = 0;

            $scope.priceTotal = 0;

            $scope.buyState = {};
            //当购买状态改变时触发
            //计算总价
            $scope.$watchCollection("buyState", function () {
                $scope.priceTotal = 0;
                $scope.goodsTotal = 0;
                //若有勾选了，才计算
                angular.forEach($scope.items.goods, function (item) {
                    if ($scope.buyState[item.id] === true) {
                        $scope.goodsTotal++;
                        $scope.priceTotal += (item.price * $scope.items.goodsRel[item.id]);
                    }
                });
            });

            $scope.createOrder = function () {
                if ($scope.priceTotal == 0) {
                    $toast.showActionToast("您还没有选择宝贝哦~");
                    return;
                }
                //TODO 提交订单
            }
        });
}());
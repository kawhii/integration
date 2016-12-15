/**
 *订单列表
 * @author Carl
 * @date 2016/12/12
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
;(function () {
    angular.module("OrderGoodsList", ["App"])
        .controller("ListCtrl", ["$scope",'$request', function ($scope, $request) {
            //orderData从界面生成进来的
            var data = orderData;
            $scope.items = data;

            //商品总数
            $scope.goodsTotal = 0;
            //总价
            $scope.priceTotal = 0;

            //重写计算总和
            function resetTotal() {
                $scope.goodsTotal = 0;
                $scope.priceTotal = 0;
                angular.forEach($scope.items.goodsItems, function (item, idx) {
                    $scope.goodsTotal += $scope.items.quantity[item.id];
                    $scope.priceTotal += $scope.items.quantity[item.id] * item.price;
                });
            }

            //当数量发生改变时，重写计算价钱
            $scope.$watchCollection("items.quantity", function () {
                resetTotal();
            });

            //当改变数量时触发
            $scope.onchangeAmount = function (item) {
                if (!$scope.items.quantity[item.id] || $scope.items.quantity[item.id] <= 0) {
                    alert("至少需要购买一件商品");
                    $scope.items.quantity[item.id] = 1;
                }
            };

            //购买数减
            $scope.minus = function (id) {
                var q = $scope.items.quantity[id];
                if (q <= 1)
                    return;
                $scope.items.quantity[id]--;
            };

            //购买数加
            $scope.plus = function (id) {
                $scope.items.quantity[id]++;
            };

            //订单创建
            $scope.createOrder = function () {
                if ($scope.goodsTotal > 0) {
                    var params = buildOrder();
                    if(params.length > 0) {
                        //请求创建订单
                        $request.post("/order/createOrder", params, function(data) {
                            console.info(data);
                        });
                    }
                }
            };

            //构建订单参数
            function buildOrder() {
                var items = [];
                angular.forEach($scope.items.goodsItems, function (item) {
                    var id = item.id;
                    var quantity = $scope.items.quantity[id];
                    if (quantity != undefined) {
                        items.push({goodsId: id, quantity: quantity});
                    }
                });
                return items;
            }

        }]);

})();
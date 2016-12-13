/**
 *订单列表
 * @author Carl
 * @date 2016/12/12
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
;(function(){
    angular.module("OrderGoodsList", ["App"])
        .controller("ListCtrl", ["$scope", function($scope) {
            //orderData从界面生成进来的
            $scope.items = orderData;

            //购买数减
            $scope.minus = function(id) {
                var q =  $scope.items.quantity[id];
                if(q <= 1)
                    return;
                $scope.items.quantity[id]--;
            };

            //购买数加
            $scope.plus = function(id) {
                $scope.items.quantity[id] ++;
            };
        }]);

})();
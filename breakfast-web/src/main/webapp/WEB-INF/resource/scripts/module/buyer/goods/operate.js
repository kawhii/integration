/**
 * 购买操作
 * @author Carl
 * @date 2016/12/7
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */

;(function() {
    angular.module("OperateApp", ["App", "BuyerApp"])
        .controller("OperateCtrl", OperateCtrl);

    function OperateCtrl($scope, $goodsSheetShower) {
        //前端初始化
        $scope.goodsId = '';

        //直接购买
        $scope.buy = function() {
            $goodsSheetShower.buy($scope.goodsId);
        };

        //前端点击购物车
        $scope.cart = function() {
            $goodsSheetShower.cart($scope.goodsId);
        };
    }

    angular.bootstrap(document.getElementById("footer"),
        ['OperateApp']);
})();

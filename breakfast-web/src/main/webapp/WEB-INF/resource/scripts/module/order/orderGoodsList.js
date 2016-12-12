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
        }]);

})();
/**
 * 购买操作
 * @author Carl
 * @date 2016/12/7
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */

;(function () {
    angular.module("BuyerApp", ["App"])
        .controller("BuyCtrl", BuyCtrl)
        .service("$goodsSheetShower", function ($mdDialog, $mdToast) {

            function show(goodsId, isCart) {
                console.info('/goods/detailToBuy/' + goodsId + "/" + (isCart ? 1 : 0));
                $mdDialog.show({
                    controller: 'BuyCtrl',
                    templateUrl: '/goods/detailToBuy/' + goodsId + "/" + (isCart ? 1 : 0),
                    parent: 'body',
                    openFrom : 'body',
                    clickOutsideToClose: true
                })
                    .then(function (answer) {
                        $scope.status = 'You said the information was "' + answer + '".';
                    }, function () {
                        $scope.status = 'You cancelled the dialog.';
                    });
            }

            return {
                /**
                 * 进行购买
                 * @param goodsId 商品id
                 */
                buy: function (goodsId) {
                    show(goodsId, false);
                },
                /**
                 * 购物车
                 * @param goodsId 商品id
                 */
                cart: function (goodsId) {
                    show(goodsId, true);
                }
            }
        });

    function BuyCtrl($scope) {
        $scope.name = 123;
    }
})();

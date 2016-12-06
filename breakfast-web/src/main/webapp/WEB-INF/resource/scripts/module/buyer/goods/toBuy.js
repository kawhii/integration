/**
 * 购买操作
 * @author Carl
 * @date 2016/12/7
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */

;(function () {
    angular.module("BuyerApp", ["App"])
        .controller("BuyCtrl", BuyCtrl)
        .service("$goodsSheetShower", function ($mdBottomSheet, $mdToast) {

            function show(goodsId, isCart) {
                console.info('/goods/detailToBuy/' + goodsId + "/" + (isCart ? 1 : 0));
                $mdBottomSheet.show({
                    templateUrl: '/goods/detailToBuy/' + goodsId + "/" + (isCart ? 1 : 0),
                    controller: 'BuyCtrl',
                    clickOutsideToClose: true
                }).then(function (clickedItem) {
                    $mdToast.show(
                        $mdToast.simple()
                            .textContent(clickedItem['name'] + ' clicked!')
                            .position('top right')
                            .hideDelay(1500)
                    );
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

    }
})();

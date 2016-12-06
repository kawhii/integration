/**
 * 购买操作
 * @author Carl
 * @date 2016/12/7
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */

;(function() {
    angular.module("BuyerApp", ["App"])
        .controller("BuyCtrl", BuyCtrl)
        .service("$goodsSheetShower", function($mdBottomSheet) {
            return {
                /**
                 * 进行购买
                 * @param goodsId 商品id
                 */
                buy: function(goodsId) {

                },
                /**
                 * 购物车
                 * @param goodsId 商品id
                 */
                cart: function(goodsId) {

                }
            }
        });

    function BuyCtrl($scope) {

    }
})();

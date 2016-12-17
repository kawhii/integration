/**
 * 购买操作
 * @author Carl
 * @date 2016/12/7
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */

;(function () {
    angular.module("BuyerApp", ["App"])
    // .controller("BuyCtrl", BuyCtrl)
        .service("$goodsSheetShower", function ($mdDialog, $toast) {

            function show(goodsId, isCart) {

                $mdDialog.show({
                    controller: createBuyCtrl(goodsId, isCart),
                    templateUrl: '/goods/detailToBuy/' + goodsId + "/" + (isCart ? 1 : 0),
                    parent: 'body',
                    openFrom: 'body',
                    focusOnOpen : true,
                    clickOutsideToClose: true
                })
                    .then(function (answer) {
                        //  $scope.status = 'You said the information was "' + answer + '".';
                    }, function () {
                        // $scope.status = 'You cancelled the dialog.';
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
                },
                //隐藏
                destroy: function () {
                    $mdDialog.hide();
                }
            }
        });


    /**
     * 购买的控制器
     * @param goodsId 商品id
     * @param isCart 是否为购物车
     * @returns {BuyCtrl}
     */
    function createBuyCtrl(goodsId, isCart) {
        return function BuyCtrl($request, $scope, $goodsSheetShower, $toast) {
            //数量
            $scope.quantity = 1;
            //减
            $scope.decrease = function () {
                if ($scope.quantity > 1)
                    $scope.quantity--;
            };

            //加
            $scope.increase = function () {
                $scope.quantity++;
            };

            //确定
            $scope.ok = function () {
                if (isCart) {
                    addCart();
                }
            };

            //添加到购物车
            function addCart() {
                //获取商品id，获取数量，请求服务器，返回成功关闭
                $request.post("/cart/addGoods", {quantity: $scope.quantity, goodsId: goodsId},
                    function (data) {
                        //添加成功
                       $goodsSheetShower.destroy();
                        $toast.showActionToast("添加成功");
                    }, {mask:false});
            }
        }
    }


})();

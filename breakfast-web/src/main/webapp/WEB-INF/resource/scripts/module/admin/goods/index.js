/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';
    angular.module('Goods', ['App', 'ngMaterial', 'ngMessages'])
        .controller('GoodsManagerCtrl', ['$scope', '$toast', '$http', '$rootScope', function ($scope, $toast, $http, $rootScope) {
            $scope.project = {};
            $scope.project.rate = 0;

            $scope.goodsInfo = {
                name: {
                    title: '商品名字',
                    val: null
                },
                title: {
                    title: '商品标题',
                    val: ''
                },
                stock: {
                    title: '库存',
                    val: ''
                },
                price: {
                    title: '单价',
                    val: ''
                },
                subTitle: {
                    title: '子标题',
                    val: ''
                },
                note: {
                    title: '描述',
                    val: ''
                }
            };


            //保存商品发布信息
            $scope.save = function () {
                var files = $rootScope.getSelectFileData();
                if (files.length == 0) {
                     $toast.showActionToast("至少选择一张主图");
                     return;
                 }
                 saveGoods(extractParams(files));
            };

            function extractParams(files) {
                //基础信息
                var info = {};
                angular.forEach($scope.goodsInfo, function (v, k) {
                    info[k] = v.val;
                });
                var goodsDetail = {images: []};

                //文件信息集成
                if (files.length > 0) {
                    info.mainImgId = files[0].id;
                    info.mainImgPath = files[0].visitPath;
                    if (files.length >= 1) {
                        for (var i = 1; i < files.length; i++) {
                            var f = files[i];
                            goodsDetail.images.push({id: f.id, path: f.visitPath});
                        }
                    }
                    info.goodsDetail = goodsDetail;
                }
                //文件信息
                return info;
            }


            function saveGoods(data) {
                $http.post("/admin/goods/addGoods", data)
                    .then(function (response) {
                        if (response.status == 200 && response.data.header.code == 0) {
                            $toast.showActionToast("商品保存成功");
                            setTimeout(function() {
                                location.reload();
                            }, 300);
                        } else {
                            $toast.showActionToast(response.data.header.message);
                        }
                    }, function (response) {
                        $toast.showActionToast(response.data);
                    });
            }
        }]).controller('FileChipCtrl', FileChipCtrl);




    angular.bootstrap(document.getElementById("ID_goods"),
        ['Goods']);
})();
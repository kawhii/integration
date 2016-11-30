/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';
    angular.module('Goods', ['App', 'ngMaterial', 'angularFileUpload', 'ngMessages'])
        .controller('GoodsManagerCtrl', ['$scope', 'FileUploader', '$toast', '$http', function ($scope, FileUploader, $toast, $http) {
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

            var uploader = $scope.uploader = new FileUploader({
                url: '/sys/file/upload'
            });

            // FILTERS

            uploader.filters.push({
                name: 'customFilter',
                fn: function (item /*{File|FileLikeObject}*/, options) {
                    return this.queue.length < 20;
                }
            });

            // CALLBACKS

            uploader.onWhenAddingFileFailed = function (item /*{File|FileLikeObject}*/, filter, options) {
                console.info('onWhenAddingFileFailed', item, filter, options);
            };
            uploader.onAfterAddingFile = function (fileItem) {
                if (fileItem.file.size >= 800 * 1024) {
                    $toast.showActionToast("文件过大");
                    fileItem.remove();
                }
                console.info('onAfterAddingFile', fileItem);
            };
            uploader.onAfterAddingAll = function (addedFileItems) {
                console.info('onAfterAddingAll', addedFileItems);
            };
            uploader.onBeforeUploadItem = function (item) {
                console.info('onBeforeUploadItem', item);
            };
            uploader.onProgressItem = function (fileItem, progress) {
                console.info('onProgressItem', fileItem, progress);
            };
            uploader.onProgressAll = function (progress) {
                console.info('onProgressAll', progress);
            };
            uploader.onSuccessItem = function (fileItem, response, status, headers) {
                fileItem['data'] = response.body;
                console.info('onSuccessItem', fileItem, response, status, headers);
            };
            uploader.onErrorItem = function (fileItem, response, status, headers) {
                console.info('onErrorItem', fileItem, response, status, headers);
            };
            uploader.onCancelItem = function (fileItem, response, status, headers) {
                console.info('onCancelItem', fileItem, response, status, headers);
            };
            uploader.onCompleteItem = function (fileItem, response, status, headers) {
                console.info(this.item);
                console.info('onCompleteItem', fileItem, response, status, headers);
            };
            uploader.onCompleteAll = function () {
                console.info('onCompleteAll');
            };

            //保存商品发布信息
            $scope.save = function () {
                //如果文件全部上传完才能发布
                if (uploader.progress != 100) {
                    $toast.showActionToast("请把文件上传完再进行保存");
                    return;
                }
                //todo 筛选商品保存
                saveGoods(extractParams());
            };

            function extractParams() {
                //基础信息
                var info = {};
                angular.forEach($scope.goodsInfo, function (v, k) {
                    info[k] = v.val;
                });
                var files = uploader.queue;
                var goodsDetail = {images : []};

                //文件信息集成
                if (files.length > 0) {
                    info.mainImgId = files[0].data.id;
                    info.mainImgPath = files[0].data.visitPath;
                    if(files.length >= 1) {
                        for(var i = 1; i < files.length; i ++) {
                            var f = files[i].data;
                            goodsDetail.images.push({id:f.id, path : f.visitPath});
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
                        console.info(response);
                    }, function (response) {
                        console.info(response);
                    });
            }
        }]);


    angular.bootstrap(document.getElementById("ID_goods"),
        ['Goods']);
})();
/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';
    angular.module('FileApp', ['App', 'ngMaterial', 'angularFileUpload', 'ngMessages'])
        .controller('FileManagerCtrl', ['$scope', 'FileUploader', '$toast', '$request', function ($scope, FileUploader, $toast, $request) {
            //是否上传页面
            $scope.isUpload = true;

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

            //删除文件
            $scope.delete = function (item, id) {
                //上传文件以及列表删除公用，上传文件前没有data,上传后有，列表没有item
                if ((item && item.data) || id) {
                    var recordId = item ? item.data.id : id;
                    $request.get("/sys/file/deleteById?id=" + recordId, function (d) {
                        if (item) {
                            item.remove();
                        } else {
                            $scope.search();
                        }
                    });
                } else {
                    item.remove();
                }
            };

            $scope.data = {
                recordList: []
            };
            $scope.name = '';
            //分页信息
            $scope.pageInfo = {
                curr: 1,
                haveNext: true,
                pageSize: 10
            };

            //渲染列表
            function renderList() {
                $request.get("/sys/file/list.json"
                    , {page: $scope.pageInfo.curr, pageSize: $scope.pageInfo.pageSize, name: $scope.name}
                    , function (data) {
                        if (data.header.code == 0) {
                            $scope.data = data.body;
                            //有数据才计算页码
                            if (data.body.recordList.length >= 0) {
                                countPager(data.body);
                            }
                        } else {
                            $toast.showActionToast(data.header.message);
                        }
                    });
            }

            renderList();

            $scope.next = function () {
                $scope.pageInfo.curr = $scope.pageInfo.curr + 1;
                renderList();
            };

            $scope.pre = function () {
                $scope.pageInfo.curr = $scope.pageInfo.curr - 1;
                renderList();
            };

            //计算页码
            function countPager(data) {
                $scope.pageInfo.curr = data.currentPage;
                $scope.pageInfo.haveNext = data.totalPage - $scope.pageInfo.curr > 0;
                $scope.pageInfo.havePre = $scope.pageInfo.curr - 1 > 0;
            }

            //重新查询
            $scope.search = function () {
                $scope.pageInfo.curr = 1;
                renderList();
            };
        }]);


    angular.bootstrap(document.getElementById("ID_file"),
        ['FileApp']);
})();
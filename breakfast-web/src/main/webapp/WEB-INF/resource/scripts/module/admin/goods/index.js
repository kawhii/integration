/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';
    angular.module('Goods', ['App', 'ngMaterial', 'ngMessages'])
        .controller('GoodsManagerCtrl', ['$scope', '$toast', '$http', function ($scope, $toast, $http) {
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
                //如果文件全部上传完才能发布
                if (uploader.progress != 100) {
                    $toast.showActionToast("请把文件上传完再进行保存");
                    return;
                }
                //todo 筛选商品保存
                //  saveGoods(extractParams());
            };

            /*function extractParams() {
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
             }*/


            function saveGoods(data) {
                $http.post("/admin/goods/addGoods", data)
                    .then(function (response) {
                        if (response.status == 200 && response.data.header.code == 0) {
                            alert("商品保存成功");
                            location.reload()
                        } else {
                            $toast.showActionToast(response.data.header.message);
                        }
                    }, function (response) {
                        $toast.showActionToast(response.data);
                    });
            }
        }]).controller('ContactChipCtrl', ContactChipCtrl);

    function ContactChipCtrl($q, $timeout, $request) {
        var self = this;
        var pendingSearch, cancelSearch = angular.noop;
        var cachedQuery = '', lastSearch;

        self.allContacts = [];
        self.asyncContacts = [];
        self.filterSelected = true;

        self.delayedQuerySearch = delayedQuerySearch;

        /**
         * Search for contacts; use a random delay to simulate a remote call
         */
        function querySearch(criteria) {
            cachedQuery = cachedQuery || criteria;
            return cachedQuery ? self.allContacts.filter(createFilterFor(cachedQuery)) : [];
        }

        /**
         * Async search for contacts
         * Also debounce the queries; since the md-contact-chips does not support this
         */
        function delayedQuerySearch(criteria) {
            cachedQuery = criteria;
            loadContacts();
            if (!pendingSearch || !debounceSearch()) {
                cancelSearch();

                return pendingSearch = $q(function (resolve, reject) {
                    // Simulate async search... (after debouncing)
                    cancelSearch = reject;
                    $timeout(function () {

                        resolve(querySearch());

                        refreshDebounce();
                    }, Math.random() * 200, true)
                });
            }

            return pendingSearch;
        }

        function refreshDebounce() {
            lastSearch = 0;
            pendingSearch = null;
            cancelSearch = angular.noop;
        }

        /**
         * Debounce if querying faster than 300ms
         */
        function debounceSearch() {
            var now = new Date().getMilliseconds();
            lastSearch = lastSearch || now;

            return ((now - lastSearch) < 300);
        }

        /**
         * Create filter function for a query string
         */
        function createFilterFor(query) {
            var lowercaseQuery = angular.lowercase(query);

            return function filterFn(contact) {
                return (contact.uploadName.indexOf(lowercaseQuery) != -1);
            };
        }

        function loadContacts() {
            //渲染列表
            $request.post("/sys/file/list.json"
                , {page: 1, pageSize: 15, name: cachedQuery}
                , function (data) {
                    if (data.header.code == 0) {
                        // self.asyncContacts = data.body.recordList;//recordList
                        self.allContacts = data.body.recordList;
                        angular.forEach(self.allContacts, function (item, index) {
                            item.visitPath = '/file/img/~/' + item.visitPath;
                        });
                    }
                });
        }

        loadContacts();
    }


    angular.bootstrap(document.getElementById("ID_goods"),
        ['Goods']);
})();
/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';
    angular.module('GoodsList', ['App', 'ngMaterial', 'ngMessages'])
        .controller('GoodsListCtrl', ['$scope', '$toast', '$http', '$request', '$mdDialog',
            function ($scope, $toast, $http, $request, $mdDialog) {
                $scope.data = {};
                $scope.name = '';
                //分页信息
                $scope.pageInfo = {
                    curr: 1,
                    haveNext: true,
                    pageSize: 10
                };

                //渲染列表
                function renderList() {
                    $http.get("/admin/goods/list.json?page=" + $scope.pageInfo.curr + "&pageSize=" + $scope.pageInfo.pageSize + "&name=" + $scope.name)
                        .then(function (response) {


                            if (response.status == 200 && response.data.header.code == 0) {
                                $scope.data = response.data.body;
                                //有数据才计算页码
                                if (response.data.body.recordList.length > 0) {
                                    countPager(response.data.body);
                                }
                            } else {
                                $toast.showActionToast(response.data.header.message);
                            }
                        }, function (response) {
                            $toast.showActionToast(response.data);
                        });
                }

                //计算页码
                function countPager(data) {
                    $scope.pageInfo.curr = data.currentPage;
                    $scope.pageInfo.haveNext = data.totalPage - $scope.pageInfo.curr > 0;
                    $scope.pageInfo.havePre = $scope.pageInfo.curr - 1 > 0;
                }

                //初始化渲染数据
                renderList();

                $scope.next = function () {
                    $scope.pageInfo.curr = $scope.pageInfo.curr + 1;
                    renderList();
                };

                $scope.pre = function () {
                    $scope.pageInfo.curr = $scope.pageInfo.curr - 1;
                    renderList();
                };

                //重新查询
                $scope.search = function () {
                    $scope.pageInfo.curr = 1;
                    renderList();
                };

                //下架
                $scope.updateStatus = function (id, status) {
                    $request.get("/admin/goods/updateState?state=" + status + "&goodsId=" + id, function (d) {
                        $toast.showActionToast((status == 0 ? '下' : '上') + '架成功');
                        $scope.search();
                    });
                };

                //修改信息
                $scope.updateData = {};
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

                //修改
                $scope.update = function (id) {
                    $scope.updateData = {};
                    $request.get("/admin/goods/goodsDetail?goodsId=" + +id, function (d) {
                        $scope.updateData = d.body;
                        $mdDialog.show({
                            contentElement: '#ID_editDialog',
                            parent: angular.element(document.body)
                        });
                    });
                };
            }])

        .controller('ContactChipDemoCtrl', DemoCtrl);

    function DemoCtrl($q, $timeout) {
        var self = this;
        var pendingSearch, cancelSearch = angular.noop;
        var cachedQuery, lastSearch;

        self.allContacts = loadContacts();
        self.contacts = [self.allContacts[0]];
        self.asyncContacts = [];
        self.filterSelected = true;

        self.querySearch = querySearch;
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
            if (!pendingSearch || !debounceSearch()) {
                cancelSearch();

                return pendingSearch = $q(function (resolve, reject) {
                    // Simulate async search... (after debouncing)
                    cancelSearch = reject;
                    $timeout(function () {

                        resolve(self.querySearch());

                        refreshDebounce();
                    }, Math.random() * 500, true)
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
                return (contact._lowername.indexOf(lowercaseQuery) != -1);
                ;
            };

        }

        function loadContacts() {
            var contacts = [
                'Marina Augustine',
                'Oddr Sarno',
                'Nick Giannopoulos',
                'Narayana Garner',
                'Anita Gros',
                'Megan Smith',
                'Tsvetko Metzger',
                'Hector Simek',
                'Some-guy withalongalastaname'
            ];

            return contacts.map(function (c, index) {
                var cParts = c.split(' ');
                var contact = {
                    name: c,
                    email: cParts[0][0].toLowerCase() + '.' + cParts[1].toLowerCase() + '@example.com',
                    image: 'http://lorempixel.com/50/50/people?' + index
                };
                contact._lowername = contact.name.toLowerCase();
                return contact;
            });
        }
    };


    angular.bootstrap(document.getElementById("ID_goodsList"),
        ['GoodsList']);
})();
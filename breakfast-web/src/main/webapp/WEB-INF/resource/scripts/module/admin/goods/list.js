/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';
    angular.module('GoodsList', ['App', 'ngMaterial'])
        .controller('GoodsListCtrl', ['$scope', '$toast', '$http', '$request', function ($scope, $toast, $http, $request) {
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
            $scope.down = function (id) {
                $request.get("/admin/goods/updateState?state=0&goodsId=" + id, function (d) {
                    $toast.showActionToast("下架成功");
                    $scope.search();
                });
            };

            //修改
            $scope.update = function (id) {
                console.info(id);
            };
        }]);


    angular.bootstrap(document.getElementById("ID_goodsList"),
        ['GoodsList']);
})();
/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';

    angular.module('App', ['ngMaterial'])
        .service('$toast', function ($mdToast) {
            var data = {
                bottom: true,
                top: false,
                left: false,
                right: true
            };

            //展示位置
            function getToastPosition() {
                return Object.keys(data)
                    .filter(function (pos) {
                        return data[pos];
                    })
                    .join(' ');
            };

            //展示吐丝
            function showActionToast(content) {
                var pinTo = getToastPosition();
                $mdToast.show(
                    $mdToast.simple()
                        .textContent(content)
                        .position(pinTo)
                        .hideDelay(3000)
                );
            };

            return {
                showActionToast: showActionToast
            }

        })
        .controller('AppCtrl', AppCtrl);

    function AppCtrl($scope) {
        $scope.currentNavItem = 'page1';
        var Item = function (url, name) {
            this.url = url;
            this.name = name;
        };

        $scope.items = [
            new Item("goods/index", "发布商品"),
            new Item("goods/index2", "发布商品2"),
        ];
    }
})();
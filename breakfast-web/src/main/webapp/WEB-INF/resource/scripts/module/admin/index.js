/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';

    angular.module('App', ['ngMaterial'])
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
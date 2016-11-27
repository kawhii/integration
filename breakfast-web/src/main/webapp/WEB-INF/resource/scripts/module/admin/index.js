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
        $scope.page = 'http://www.baidu.com'
        $scope.test = function () {
            $scope.page = '/u/test'
        }

        $scope.test2 = function () {
            $scope.page = '/index.html'
        }
    }
})();
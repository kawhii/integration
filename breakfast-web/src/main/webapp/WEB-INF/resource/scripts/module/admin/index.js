/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';

    angular.module('App', ['ngMaterial', 'toastr', 'ngAnimate'])
        .service('$toast', function (toastr, toastrConfig, $templateCache, $mdDialog) {
            angular.extend(toastrConfig, {
                extendedTimeOut: 0,
                timeOut: 3000,
                templates: {
                    toast: 'custom'
                }
            });
            $templateCache.put('custom',
                '<div class="{{toastClass}} {{toastType}}" ng-click="tapToast()">' +
                '<div ng-switch on="allowHtml">' +
                '<div ng-switch-default ng-if="title" class="{{titleClass}}" aria-label="{{title}}">{{title}}</div>' +
                '<div ng-switch-default class="{{messageClass}}" aria-label="{{message}}">{{message}}</div>' +
                '<div ng-switch-when="true" ng-if="title" class="{{titleClass}}" ng-bind-html="title"></div>' +
                '<div ng-switch-when="true" class="{{messageClass}}" ng-bind-html="message"></div>' +
                '</div>' +
                '<progress-bar ng-if="progressBar"></progress-bar>' +
                '</div>');

            //展示吐丝
            function showActionToast(content, opt) {
                return toastr.info(content, '温馨提示', opt);
            }

            return {
                showActionToast: showActionToast,
                remove: function (toastObj) {
                    if (toastObj) {
                        toastr.remove(toastObj.toastId);
                    }
                },
                loading: function () {
                    return $mdDialog.show(
                            {
                                clickOutsideToClose: false,
                                escapeToClose : false,
                                focusOnOpen : false,
                                disableParentScroll : false,
                                template: '<md-progress-circular style="align-self: center" md-mode="indeterminate"></md-progress-circular>'
                            }
                        );
                }
            }

        })
        .service('$request', function ($http, $toast, $mdDialog) {
            var defSetting = {filterError: false, mask: true};
            //队列
            var queue = [];
            var taskObj = null;

            //请求完成mask
            function completeMask(setting) {
                if (setting.mask) {
                    queue.splice(0, 1);
                    //取消遮罩层
                    if (queue.length == 0) {
                        setTimeout(function () {
                            $mdDialog.hide();
                        }, 1);
                    }
                }
            }

            function startMask(setting) {
                if (setting.mask) {
                    queue.push(1);
                }
                //mask
                if (queue.length == 1 && setting.mask) {
                    taskObj = $toast.loading();
                }
            }

            function request(url, method, data, callback, opt) {
                var setting = angular.extend({}, defSetting, opt);
                startMask(setting);

                $http({
                    method: method,
                    url: url,
                    data: method == 'POST' ? data : null,
                    params: method == 'GET' ? data : null
                })
                    .then(function (response) {
                        completeMask(setting);
                        if (response.status == 200) {
                            if (callback) {
                                //若不过滤错误，都给毁掉，否则，0才回调
                                if (!setting.filterError) {
                                    callback(response.data, response);
                                } else {
                                    if (response.data.header.code == 0) {
                                        callback(response.data, response);
                                    } else {
                                        $toast.showActionToast(response.data.header.message);
                                    }
                                }

                            }
                        }
                    }, function (response) {
                        completeMask(setting);
                        $toast.showActionToast(response.data);
                    });
            }

            return {
                get: function (url, params, callback, opt) {
                    request(url, "GET", params, callback, opt);
                },
                post: function (url, params, callback, opt) {
                    request(url, "POST", params, callback, opt);
                }
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
            new Item("goods/list", "当前商品"),
            new Item("sys/file", "图片管理"),
            new Item("statistics/index", "数据统计")
        ];
    }
})();
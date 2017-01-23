/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';

    angular.module('UserApp', ['App'])
        .controller('UserCtrl', ['$scope', '$toast', '$request', function ($scope, $toast, $request) {
            $scope.modifyPwd = {
                //旧密码
                oldPwd : '',
                //新密码
                newPwd : '',
                //确认密码
                confirmPwd : ''
            };

            //设置错误信息
            function setStateAndMsg(scope , state, msg) {
                $scope.modifyPwdStatus[scope].msg = msg;
                $scope.modifyPwdStatus[scope].state = state;
            }

            //0-正确
            $scope.modifyPwdStatus = {

                oldPwd :  {
                    //1-显示备注，2-为空
                    state : 1,
                    onbulr : function(val) {
                        var scope = "oldPwd";
                        if(val == '') {
                            setStateAndMsg(scope, 2, "请输入登录密码");
                            return 2;
                        } else if(val.length < 6) {
                            setStateAndMsg(scope, 3, "密码长度不正确，请重新设置");
                            return 3;
                        }
                        //TODO 其他错误信息
                    },
                    //显示信息
                    msg : ''
                },
                newPwd :  {
                    state : 1,
                    onbulr : function(val) {
                        var scope = "newPwd";
                        if(val == '') {
                            setStateAndMsg(scope, 2, "请输入新登录密码");
                            return 2;
                        } else if(val.length < 6) {
                            setStateAndMsg(scope, 3, "密码长度不正确，请重新设置");
                            return 3;
                        }
                        //TODO 其他错误信息
                    },
                    //显示信息
                    msg : ''
                }
            }
        }]);


    angular.bootstrap(document.getElementById("ID_userApp"),
        ['UserApp']);
})();
/**
 * 登陆脚本
 * @author Carl
 * @date 2016-11-26
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    angular.module('App', ['ngMaterial', 'ngMessages', 'ngMdIcons'])
        .controller('LoginCtrl', ['$scope','$q', '$http', function ($scope,$q,$http) {
            $scope.user = {
                username: '',
                password: '',
            };

            $scope.login = function() {
                var form = angular.element(document.querySelector("#loginForm"));
                form[0].submit()
               /* var deferred = $q.defer();
                $http({
                    method:"POST",
                    url: "/u/login",
                    params: $scope.user
                }).success(function(data, status) {
                    deferred.resolve(data);
                }).error(function(data, status) {
                    deferred.reject(null);
                });
                return deferred.promise;*/
            }
        }]);
})();

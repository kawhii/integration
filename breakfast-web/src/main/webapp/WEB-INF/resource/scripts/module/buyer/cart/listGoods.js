;(function(){
    angular.module('StopCart', ['ngMaterial'])

        .controller('ListCtrl', function($scope, $mdDialog) {
            $scope.items = stopCart;


        });
}());
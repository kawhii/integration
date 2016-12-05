/**
 * @date 2016/12/5
 *
 * @author Carl
 * @note
 * --------------------
 * @depend
 * @modify
 * 版权所有.(c)2008-2016.卡尔工作室
 */
!(function () {
    'use strict';
    angular.module('BuyerGoods', ['App'])
        .controller("BuyerGoodsListCtrl", BuyerGoodsListCtrl);

    function BuyerGoodsListCtrl($scope) {
        var imagePath = 'img/list/60.jpeg';

        $scope.phones = [
            {
                type: 'Home',
                number: '(555) 251-1234',
                options: {
                    icon: 'communication:phone'
                }
            },
            {
                type: 'Cell',
                number: '(555) 786-9841',
                options: {
                    icon: 'communication:phone',
                    avatarIcon: true
                }
            },
            {
                type: 'Office',
                number: '(555) 314-1592',
                options: {
                    face : imagePath
                }
            },
            {
                type: 'Offset',
                number: '(555) 192-2010',
                options: {
                    offset: true,
                    actionIcon: 'communication:phone'
                }
            }
        ];
        $scope.todos = [
            {
                face : imagePath,
                what: 'Brunch this weekend?',
                who: 'Min Li Chan',
                when: '3:08PM',
                notes: " I'll be in your neighborhood doing errands"
            },
            {
                face : imagePath,
                what: 'Brunch this weekend?',
                who: 'Min Li Chan',
                when: '3:08PM',
                notes: " I'll be in your neighborhood doing errands"
            },
            {
                face : imagePath,
                what: 'Brunch this weekend?',
                who: 'Min Li Chan',
                when: '3:08PM',
                notes: " I'll be in your neighborhood doing errands"
            },
            {
                face : imagePath,
                what: 'Brunch this weekend?',
                who: 'Min Li Chan',
                when: '3:08PM',
                notes: " I'll be in your neighborhood doing errands"
            },
            {
                face : imagePath,
                what: 'Brunch this weekend?',
                who: 'Min Li Chan',
                when: '3:08PM',
                notes: " I'll be in your neighborhood doing errands"
            },
        ];
    }

    angular.bootstrap(document.getElementById("ID_BuyerGoods"),
        ['BuyerGoods']);
}());

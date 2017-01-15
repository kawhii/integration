/**
 *管理端首页
 * @author Carl
 * @date 2016/11/28
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
(function () {
    'use strict';
    Date.prototype.format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1,                 //月份
            "d+": this.getDate(),                    //日
            "h+": this.getHours(),                   //小时
            "m+": this.getMinutes(),                 //分
            "s+": this.getSeconds(),                 //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds()             //毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };

    angular.module('StatisticsApp', ['App', 'ngMaterial', 'ngMessages'])
        .controller('StatisticsCtrl', ['$scope', '$toast', '$request', function ($scope, $toast, $request) {
            //标签页索引
            $scope.tabIndex = 1;//1-订单，2销售量


            $scope.data = {
                recordList: []
            };
            //时间
            $scope.createTime = '';
            //楼层编码
            $scope.unitCode = '';
            //分页信息
            $scope.pageInfo = {
                curr: 1,
                haveNext: true,
                pageSize: 10
            };

            //监听用于重写汇总数据
            $scope.$watchCollection("data.recordList", function (newObj, oObj) {
                //汇总数据
                resetCountData(newObj);
            });
            $scope.countImpatient = 0;
            $scope.countPrice = 0;
            function resetCountData(newObj) {
                $scope.countImpatient = 0;
                $scope.countPirce = 0;
                var price = 0;
                for (var i in newObj) {
                    var obj = newObj[i];
                    if (obj.impatient) {
                        $scope.countImpatient++;
                    }
                    if (obj.totalPrice){
                        price += obj.totalPrice;
                    }
                }
                $scope.countPrice = price;
            }


            //渲染列表
            function renderList() {
                $request.get("/admin/statistics/order.json"
                    , {unitCode: $scope.unitCode, createTime: $scope.createTime ? $scope.createTime.format("yyyy-MM-dd") : ''}
                    , function (data) {
                        if (data.header.code == 0) {

                            $scope.data = data.body;
                            //有数据才计算页码
                            if (data.body.length >= 0) {
                                $scope.data.recordList = data.body;
                            } else {
                                $scope.data.recordList = [];
                            }
                        } else {
                            $toast.showActionToast(data.header.message);
                        }
                    });
            }

            renderList();


            //重新查询
            $scope.search = function () {
                renderList();
            };
        }]);


    angular.bootstrap(document.getElementById("ID_statisticsApp"),
        ['StatisticsApp']);
})();
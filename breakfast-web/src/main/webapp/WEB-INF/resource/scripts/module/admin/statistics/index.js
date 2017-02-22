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

    angular.module('StatisticsApp', ['App', 'ngMaterial', 'ngMessages', 'ngMaterialDatePicker'])
        .controller('StatisticsCtrl', ['$scope', '$toast', '$request', function ($scope, $toast, $request) {
            //标签页索引
            $scope.tabIndex = 1;//1-订单，2销售量
            //楼栋查询地址
            $scope.searchText = '';
            //选择的上哦名字
            $scope.selectGoods = [];

            //自动完成控件查询
            $scope.querySearch = querySearch;
            $scope.queryGoods = queryGoods;


            var cachedQuery, lastSearch;

            function queryGoods(criteria) {
                cachedQuery = /*cachedQuery || */criteria;
                return cachedQuery ? $scope.data.goodsList.filter(createGoodsFilter(cachedQuery)) : [];
            }

            function createGoodsFilter(query) {
                var lowercaseQuery = angular.lowercase(query);

                return function filterFn(contact) {
                    return (contact.name.indexOf(lowercaseQuery) != -1);
                };

            }


            function querySearch(query) {
                var results = query ? $scope.unitCodeList.filter(createFilterFor(query)) : $scope.unitCodeList;
                return results;
            }

            function createFilterFor(query) {
                var lowercaseQuery = angular.lowercase(query);

                return function filterFn(state) {
                    return !query || (state.INFO.indexOf(lowercaseQuery) >= 0);
                };

            }

            $scope.unitCodeList =
                [
                    {
                        "ID": "my1d",
                        "INFO": "梅苑1栋",
                        "TYPE_ID": "D",
                        "SEQ": 1,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my2d",
                        "INFO": "梅苑2栋",
                        "TYPE_ID": "D",
                        "SEQ": 2,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my3d",
                        "INFO": "梅苑3栋",
                        "TYPE_ID": "D",
                        "SEQ": 3,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my4d",
                        "INFO": "梅苑4栋",
                        "TYPE_ID": "D",
                        "SEQ": 4,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my5d",
                        "INFO": "梅苑5栋",
                        "TYPE_ID": "D",
                        "SEQ": 5,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my6d",
                        "INFO": "梅苑6栋",
                        "TYPE_ID": "D",
                        "SEQ": 6,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my7d",
                        "INFO": "梅苑7栋",
                        "TYPE_ID": "D",
                        "SEQ": 7,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my8d",
                        "INFO": "梅苑8栋",
                        "TYPE_ID": "D",
                        "SEQ": 8,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my9d",
                        "INFO": "梅苑9栋",
                        "TYPE_ID": "D",
                        "SEQ": 9,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "my10d",
                        "INFO": "梅苑10栋",
                        "TYPE_ID": "D",
                        "SEQ": 10,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "zy1d",
                        "INFO": "竹苑1栋",
                        "TYPE_ID": "D",
                        "SEQ": 11,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "zy2d",
                        "INFO": "竹苑2栋",
                        "TYPE_ID": "D",
                        "SEQ": 12,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "zy3d",
                        "INFO": "竹苑3栋",
                        "TYPE_ID": "D",
                        "SEQ": 13,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "zy4d",
                        "INFO": "竹苑4栋",
                        "TYPE_ID": "D",
                        "SEQ": 14,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "zy5d",
                        "INFO": "竹苑5栋",
                        "TYPE_ID": "D",
                        "SEQ": 15,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "ly1d",
                        "INFO": "兰苑1栋",
                        "TYPE_ID": "D",
                        "SEQ": 21,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "ly2d",
                        "INFO": "兰苑2栋",
                        "TYPE_ID": "D",
                        "SEQ": 22,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "ly3d",
                        "INFO": "兰苑3栋",
                        "TYPE_ID": "D",
                        "SEQ": 23,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "ly4d",
                        "INFO": "兰苑4栋",
                        "TYPE_ID": "D",
                        "SEQ": 24,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "ly5d",
                        "INFO": "兰苑5栋",
                        "TYPE_ID": "D",
                        "SEQ": 25,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "jy1d",
                        "INFO": "菊苑1栋",
                        "TYPE_ID": "D",
                        "SEQ": 31,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "jy2d",
                        "INFO": "菊苑2栋",
                        "TYPE_ID": "D",
                        "SEQ": 32,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "jy3d",
                        "INFO": "菊苑3栋",
                        "TYPE_ID": "D",
                        "SEQ": 33,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "jy4d",
                        "INFO": "菊苑4栋",
                        "TYPE_ID": "D",
                        "SEQ": 34,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "jy5d",
                        "INFO": "菊苑5栋",
                        "TYPE_ID": "D",
                        "SEQ": 35,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx1d",
                        "INFO": "榕轩1栋",
                        "TYPE_ID": "D",
                        "SEQ": 41,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx2d",
                        "INFO": "榕轩2栋",
                        "TYPE_ID": "D",
                        "SEQ": 42,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx3d",
                        "INFO": "榕轩3栋",
                        "TYPE_ID": "D",
                        "SEQ": 43,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx4d",
                        "INFO": "榕轩4栋",
                        "TYPE_ID": "D",
                        "SEQ": 44,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx5d",
                        "INFO": "榕轩5栋",
                        "TYPE_ID": "D",
                        "SEQ": 45,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx6d",
                        "INFO": "榕轩6栋",
                        "TYPE_ID": "D",
                        "SEQ": 46,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx7d",
                        "INFO": "榕轩7栋",
                        "TYPE_ID": "D",
                        "SEQ": 47,
                        "PID": "",
                        "NOTE": null
                    },
                    {
                        "ID": "rx8d",
                        "INFO": "榕轩8栋",
                        "TYPE_ID": "D",
                        "SEQ": 48,
                        "PID": "",
                        "NOTE": null
                    }
                ];

            $scope.data = {
                recordList: [],
                //销售数据
                salesList: [],
                //商品数据
                goodsList: []
            };
            //时间
            $scope.createTime = new Date();
            $scope.startDate = new Date(new Date() - 24 * 60 * 60 * 1000);
            $scope.endDate = new Date();
            //楼层编码
            $scope.unitCode = '';
            //分页信息
            $scope.pageInfo = {
                curr: 1,
                haveNext: true,
                pageSize: 10
            };


            //导出当前数据
            $scope.orderExport = function () {
                window.open("/admin/statistics/exportOrder?unitCode=" + ($scope.unitCode ? $scope.unitCode.ID : '') + "&" +
                    "createTime=" + ($scope.createTime ? $scope.createTime.format("yyyy-MM-dd") : '') + "&" +
                    "unitName=" + ($scope.unitCode ? $scope.unitCode.INFO : '')
                )
            };

            //导出当前数据
            $scope.salesExport = function () {
                window.open("/admin/statistics/exportSales?unitCode=" + ($scope.unitCode ? $scope.unitCode.ID : '') + "&" +
                    "startTime=" + ($scope.startDate ? $scope.startDate.format("yyyy-MM-dd") : '') + "&" +
                    "endTime=" + ($scope.endDate ? $scope.endDate.format("yyyy-MM-dd") : '') + "&" +
                    "unitName=" + ($scope.unitCode ? $scope.unitCode.INFO : '') + "&" +
                    "codes=" + getGoodsId()
                )
            };

            //监听用于重写汇总数据
            $scope.$watchCollection("data.recordList", function (newObj, oObj) {
                //汇总数据
                resetCountData(newObj);
            });
            $scope.$watchCollection("data.salesList", function (newObj, oObj) {
                //汇总数据
                resetSalesData(newObj);
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
                    if (obj.totalPrice) {
                        price = (parseFloat(price) + parseFloat(obj.totalPrice)).toFixed(2);
                        // price = price.toFixed(4);
                    }
                }

                $scope.countPrice = price;
            }

            function resetSalesData(newObj) {
                $scope.salesCountPrice = 0;
                var price = 0;
                for (var i in newObj) {
                    var obj = newObj[i];
                    if (obj.totalPrice) {
                        price = (parseFloat(price) + parseFloat(obj.totalPrice)).toFixed(2);
                    }
                }
                $scope.salesCountPrice = price;
            }

            //加载商品
            function loadGoods() {
                $request.get("/admin/goods/list.json", {
                    page: 1, pageSize: 100
                }, function (data) {
                    if (data.header.code == 0) {
                        if (data.body.recordList.length >= 0) {
                            $scope.data.goodsList = data.body.recordList;
                        } else {
                            $scope.data.goodsList = [];
                        }
                    } else {
                        $toast.showActionToast(data.header.message);
                    }
                });
            }


            //渲染列表
            function renderList() {
                $request.get("/admin/statistics/order.json"
                    , {
                        unitCode: $scope.unitCode ? $scope.unitCode.ID : '',
                        createTime: $scope.createTime ? $scope.createTime.format("yyyy-MM-dd") : ''
                    }
                    , function (data) {
                        if (data.header.code == 0) {

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

            //获取选择的商品id
            function getGoodsId() {
                var ids = [];
                for (var i in $scope.selectGoods) {
                    ids.push($scope.selectGoods[i].id);
                }
                return ids.join();
            }

            function loadSalesList() {
                $request.get("/admin/statistics/sales.json"
                    , {
                        unitCode: $scope.unitCode ? $scope.unitCode.ID : '',
                        startTime: $scope.startDate ? $scope.startDate.format("yyyy-MM-dd") : '',
                        endTime: $scope.endDate ? $scope.endDate.format("yyyy-MM-dd") : '',
                        codes: getGoodsId()
                    }
                    , function (data) {
                        if (data.header.code == 0) {

                            //有数据才计算页码
                            if (data.body.length >= 0) {
                                $scope.data.salesList = data.body;
                            } else {
                                $scope.data.salesList = [];
                            }
                        } else {
                            $toast.showActionToast(data.header.message);
                        }
                    });
            }

            renderList();
            loadSalesList();
            loadGoods();


            //重新查询
            $scope.search = function () {
                renderList();
            };
            $scope.searchSales = function () {
                loadSalesList();
            };
        }]);


    angular.bootstrap(document.getElementById("ID_statisticsApp"),
        ['StatisticsApp']);
})();
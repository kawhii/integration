<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>

<div id="ID_statisticsApp" ng-app="StatisticsApp" ng-controller="StatisticsCtrl" ng-cloak>
    <div class="container">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="{{tabIndex == 1?'active':''}}" ng-click="tabIndex = 1"><a
                    href="javascript:void(0)">订单统计</a></li>
            <li role="presentation" class="{{tabIndex == 2?'active':''}}" ng-click="tabIndex = 2"><a
                    href="javascript:void(0)">销售统计</a></li>
        </ul>
    </div>

<#--上传表单 start-->
    <div class="container" ng-show="tabIndex == 1">
        <div class="md-toolbar-tools">
            <h2 class="md-flex">总记录数：{{data.recordList.length}}</h2>
        </div>
        <div>
            <div class="form-group form-inline">
                <div style="width: 200px">
                    <md-autocomplete
                            md-selected-item="unitCode"
                            md-search-text="searchText"
                            md-items="item in querySearch(searchText)"
                            md-item-text="item.INFO"
                            md-min-length="0"
                            placeholder="楼栋">
                        <md-item-template>
                            <span md-highlight-text="searchText" md-highlight-flags="^i">{{item.INFO}}</span>
                        </md-item-template>
                        <md-not-found>
                            找不到匹配 "{{ctrl.searchText}}" 的数据.
                        </md-not-found>
                    </md-autocomplete>
                </div>
            <#--<input type="text" class="form-control" ng-model="unitCode" placeholder="楼层">-->
                <md-datepicker ng-model="createTime" md-placeholder="日期"></md-datepicker>
                <button type="button" class="btn btn-default" ng-click="search()">查询</button>
                <button type="button" class="btn btn-default" ng-click="orderExport()">导出</button>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>序号</th>
                <th>楼栋</th>
                <th>楼层</th>
                <th>房号</th>
                <th>商品名称*数量</th>
                <th>是否加急</th>
                <th>总价（元）</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="item in data.recordList">
                <td>{{$index+1}}</td>
                <td>{{item.floorName}}</td>
                <td>{{item.unitName}}</td>
                <td>{{item.address}}</td>
                <td>{{item.goodsInfo}}</td>
                <td>{{item.impatient?'是':'否'}}</td>
                <td>{{item.totalPrice}}</td>
            </tr>
            <tr>
                <td></td>
                <td>合计</td>
                <td></td>
                <td></td>
                <td></td>
                <td>{{countImpatient}}</td>
                <td>{{countPrice}}</td>
            </tr>
            </tbody>
        </table>
    </div>

<#--上传表单 end-->

<#--文件列表 start-->
    <div class="container" ng-show="tabIndex == 2">

        <div class="md-toolbar-tools">
            <h2 class="md-flex">总记录数：{{data.salesList.length}}</h2>
        </div>
        <div>
        <div class="form-group form-inline">
            <md-contact-chips
                    ng-model="selectGoods"
                    md-contacts="queryGoods($query)"
                    md-contact-name="name"
                    md-contact-image="image"
                    md-contact-email="email"
                    md-require-match="true"
                    md-highlight-flags="i"
                    filter-selected="true"
                    placeholder="商品">
            </md-contact-chips>
                <div style="width: 200px">
                    <md-autocomplete
                            md-selected-item="unitCode"
                            md-search-text="searchText"
                            md-items="item in querySearch(searchText)"
                            md-item-text="item.INFO"
                            md-min-length="0"
                            placeholder="楼栋">
                        <md-item-template>
                            <span md-highlight-text="searchText" md-highlight-flags="^i">{{item.INFO}}</span>
                        </md-item-template>
                        <md-not-found>
                            找不到匹配 "{{ctrl.searchText}}" 的数据.
                        </md-not-found>
                    </md-autocomplete>
                </div>
                <md-datepicker ng-model="startDate" md-placeholder="开始日期"></md-datepicker>
                <md-datepicker ng-model="endDate" md-placeholder="结束"></md-datepicker>
                <button type="button" class="btn btn-default" ng-click="searchSales()">查询</button>
                <button type="button" class="btn btn-default" ng-click="salesExport()">导出</button>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>序号</th>
                <th></th>
                <th>楼栋</th>
                <th>单价（元）</th>
                <th>货存</th>
                <th>销量</th>
                <th>销售额（元）</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="item in data.salesList">
                <td>{{$index+1}}</td>
                <td>{{item.goodsName}}</td>
                <td>{{item.unitName}}</td>
                <td>{{item.unitPrice}}</td>
                <td>{{item.stock}}</td>
                <td>{{item.sales}}</td>
                <td>{{item.totalPrice}}</td>
            </tr>
            <tr>
                <td></td>
                <td>合计</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>{{salesCountPrice}}</td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
<#--文件列表 end-->
</div>
<script src="/js/~/admin/statistics/index.js"></script>


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
            <h2 class="md-flex">总记录数：{{pageInfo.dataLen}}，当前页：{{pageInfo.curr}}</h2>
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
                </br>
            <#--<input type="text" class="form-control" ng-model="unitCode" placeholder="楼层">-->
                <md-input-container flex-gt-md="30">
                    <label>开始日期</label>
                    <input mdc-datetime-picker="" date="true" format="YYYY-MM-DD HH:mm" time="true" type="text"
                           id="startDate"
                           placeholder="Date" show-todays-date="" min-date="date" ng-model="startDate" class=" md-input"
                           readonly="readonly">
                </md-input-container>
                <md-input-container flex-gt-md="30">
                    <label>开始日期</label>
                    <input mdc-datetime-picker="" date="true" format="YYYY-MM-DD HH:mm" time="true" type="text"
                           id="endDate"
                           placeholder="Date" show-todays-date="" min-date="date" ng-model="endDate" class=" md-input"
                           readonly="readonly">
                </md-input-container>
            <#--<md-datepicker ng-model="createTime" md-placeholder="日期"></md-datepicker>-->
                <button type="button" class="btn btn-default" ng-click="search()">查询</button>
                <button type="button" class="btn btn-default" ng-click="orderExport()">导出</button>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th style="width: 3%"></th>
                <th style="width: 7%">楼栋</th>
                <th style="width: 6%">楼层</th>
                <th style="width: 6%">房号</th>
                <th style="width: 35%">商品名称*数量</th>
                <th style="width: 5%">加急</th>
                <th style="width: 7%">总价(元)</th>
                <th style="width: 18%">备注</th>
                <th style="width: 6%">联系人</th>
                <th style="width: 6%">电话</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="item in data.recordList">
                <td>{{$index+1}}</td>
                <td>{{item.unitName}}</td>
                <td>{{item.floorName}}</td>
                <td>{{item.address}}</td>
                <td>{{item.goodsInfo}}</td>
                <td>{{item.impatient?'是':'否'}}</td>
                <td>{{item.totalPrice}}</td>
                <td>{{item.note}}</td>
                <td>{{item.contactName}}</td>
                <td>{{item.contactPhone}}</td>
            </tr>
            <tr>
                <td></td>
                <td>合计</td>
                <td></td>
                <td></td>
                <td></td>
                <td>{{countImpatient}}</td>
                <td>{{countPrice}}</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
        </table>
        <nav>
            <ul class="pager">
                <li ng-if="pageInfo.havePre"><a href="javascript:void(0)"
                                                ng-click="orderPre()">上一页({{pageInfo.curr-1}})</a>
                </li>
                <li ng-if="pageInfo.haveNext"><a href="javascript:void(0)"
                                                 ng-click="orderNext()">下一页({{pageInfo.curr+1}})</a>
                </li>
            </ul>
        </nav>

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
                </br>
                <md-input-container flex-gt-md="30">
                    <label>开始日期</label>
                    <input mdc-datetime-picker="" date="true" format="YYYY-MM-DD HH:mm" time="true" type="text"
                           id="startDate"
                           placeholder="Date" show-todays-date="" min-date="date" ng-model="startDate" class=" md-input"
                           readonly="readonly">
                </md-input-container>
                <md-input-container flex-gt-md="30">
                    <label>开始日期</label>
                    <input mdc-datetime-picker="" date="true" format="YYYY-MM-DD HH:mm" time="true" type="text"
                           id="endDate"
                           placeholder="Date" show-todays-date="" min-date="date" ng-model="endDate" class=" md-input"
                           readonly="readonly">
                </md-input-container>
            <#--<md-datepicker ng-model="startDate" md-placeholder="开始日期"></md-datepicker>-->
            <#--<md-datepicker ng-model="endDate" md-placeholder="结束"></md-datepicker>-->
                <button type="button" class="btn btn-default" ng-click="searchSales()">查询</button>
                <button type="button" class="btn btn-default" ng-click="salesExport()">导出</button>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>序号</th>
                <th>楼栋</th>
                <th>商品名称</th>
                <th>销量</th>
                <th>单价（元）</th>
                <th>销售额（元）</th>
                <th>货存</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="item in data.salesList">
                <td>{{$index+1}}</td>
                <td>{{item.unitName}}</td>
                <td>{{item.goodsName}}</td>
                <td>{{item.sales}}</td>
                <td>{{item.unitPrice}}</td>
                <td>{{item.totalPrice}}</td>
                <td>{{item.stock}}</td>
            </tr>
            <tr>
                <td></td>
                <td>合计</td>
                <td></td>
                <td></td>
                <td></td>
                <td>{{salesCountPrice}}</td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
<#--文件列表 end-->
</div>
<script src="/js/~/admin/statistics/index.js"></script>


<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>
<script src="/webjars/angular-file-upload/angular-file-upload.min.js"></script>

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
                <input type="text" class="form-control" ng-model="unitCode" placeholder="楼层">
                <#--<input type="text" class="form-control" ng-model="createTime" placeholder="日期">-->
                <md-datepicker ng-model="createTime" md-placeholder="日期"></md-datepicker>
                <button type="button" class="btn btn-default" ng-click="search()">查询</button>
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
    </div>
<#--上传表单 end-->

<#--文件列表 start-->
    <div class="container" ng-show="tabIndex == 2">
    <#-- <div>
            <div class="form-group form-inline">
                <input type="text" class="form-control" ng-model="floor" placeholder="文件名">
                <input type="text" class="form-control" ng-model="createDate" placeholder="日期">
                <button type="button" class="btn btn-default" ng-click="search()">查询</button>
            </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>操作</th>
                    <th>名称</th>
                    <th>大小</th>
                    <th>预览</th>
                    <th>上传用户</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in data.recordList">
                    <td>{{$index+1}}</td>
                    <td>
                        <button type="button" class="btn btn-link" ng-click="delete(null, item.id)">删除</button>
                    </td>
                    <td>{{item.uploadName}}</td>
                    <td>{{item.fileSize/1024 | number : 2}}KB</td>
                    <td><img ng-src="/file/img/~/{{item.visitPath}}" style="width: 45px;height: 45px"/></td>
                    <td>{{item.uploadUser}}</td>
                </tr>
                </tbody>
            </table>
            <nav>
                <ul class="pager">
                    <li ng-if="pageInfo.havePre"><a href="javascript:void(0)"
                                                    ng-click="pre()">上一页({{pageInfo.curr-1}})</a>
                    </li>
                    <li ng-if="pageInfo.haveNext"><a href="javascript:void(0)"
                                                     ng-click="next()">下一页({{pageInfo.curr+1}})</a>
                    </li>
                </ul>
            </nav>
        </div>-->
    </div>
<#--文件列表 end-->
</div>
<script src="/js/~/admin/statistics/index.js"></script>


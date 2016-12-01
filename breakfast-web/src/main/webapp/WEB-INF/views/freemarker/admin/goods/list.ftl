<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>

<div id="ID_goodsList" ng-app="GoodsList" ng-controller="GoodsListCtrl" ng-cloak>
    <div class="container">
    <md-content flex layout-padding>
        <md-toolbar class="md-info">
            <div class="md-toolbar-tools">
                <h2 class="md-flex">商品总数：{{data.totalCount}}，当前页：{{data.currentPage}}，总页数：{{data.totalPage}}</h2>
            </div>
        </md-toolbar>
        <#--列表开头-->
        <div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>名称</th>
                    <th>标题</th>
                    <th>子标题</th>
                    <th>库存</th>
                    <th>销售量</th>
                    <th>单价</th>
                    <th>上架时间</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in data.recordList">
                    <td>{{$index+1}}</td>
                    <td>{{item.name}}</td>
                    <td>{{item.title}}</td>
                    <td>{{item.subTitle}}</td>
                    <td>{{item.stocks}}</td>
                    <td>{{item.sales}}</td>
                    <td>{{item.price}}</td>
                    <td>{{item.onSaleTime}}</td>
                </tr>
                </tbody>
            </table>
            <nav>
                <ul class="pager">
                    <li ng-if="pageInfo.havePre"><a href="javascript:void(0)"  ng-click="pre()">上一页({{pageInfo.curr-1}})</a></li>
                    <li ng-if="pageInfo.haveNext"><a href="javascript:void(0)" ng-click="next()">下一页({{pageInfo.curr+1}})</a></li>
                </ul>
            </nav>
        </div>
        <#--列表结束-->

    </md-content>
    </div>
</div>
<script src="/js/~/admin/goods/list.js"></script>
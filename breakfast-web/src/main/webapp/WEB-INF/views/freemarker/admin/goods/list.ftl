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
                <div class="form-group form-inline">
                    <input type="text" class="form-control" id="ID_goodsName" ng-model="name" placeholder="商品名称">
                    <button type="button" class="btn btn-default" ng-click="search()">查询</button>
                </div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>操作</th>
                        <th>名称</th>
                        <th>主图</th>
                        <th>标题</th>
                        <th>子标题</th>
                        <th>库存</th>
                        <th>销售量</th>
                        <th>单价</th>
                        <th>上架时间</th>
                        <th>状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="item in data.recordList">
                        <td>{{$index+1}}</td>
                        <td>
                            <button type="button" class="btn btn-link" ng-if="item.status==1" ng-click="updateStatus(item.id, 2)">下架</button>
                            <button type="button" class="btn btn-link" ng-if="item.status==2" ng-click="updateStatus(item.id, 1)">上架</button>
                            <button type="button" class="btn btn-link" ng-click="update(item.id)">修改</button>
                        </td>
                        <td>{{item.name}}</td>
                        <td><img ng-src="/file/img/~/{{item.mainImgPath}}" style="width: 45px;height: 45px"/></td>
                        <td>{{item.title}}</td>
                        <td>{{item.subTitle}}</td>
                        <td>{{item.stock}}</td>
                        <td>{{item.sales}}</td>
                        <td>{{item.price}}</td>
                        <td>{{item.onSaleTime}}</td>
                        <td>{{item.status==2?'已下架':'正在销售'}}</td>
                    </tr>
                    </tbody>
                </table>
                <nav>
                    <ul class="pager">
                        <li ng-if="pageInfo.havePre"><a href="javascript:void(0)" ng-click="pre()">上一页({{pageInfo.curr-1}})</a>
                        </li>
                        <li ng-if="pageInfo.haveNext"><a href="javascript:void(0)" ng-click="next()">下一页({{pageInfo.curr+1}})</a>
                        </li>
                    </ul>
                </nav>
            </div>
        <#--列表结束-->

        </md-content>
    </div>

<#--修改弹出框 start-->
<#include "freemarker/admin/goods/editor.ftl">
<#--修改弹出框 end-->
</div>


<script src="/js/~/admin/goods/list.js"></script>
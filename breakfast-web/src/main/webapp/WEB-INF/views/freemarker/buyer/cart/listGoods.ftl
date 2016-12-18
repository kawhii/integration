<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">

    <title>购物车</title>
<#include "freemarker/base/base.ftl">
    <link rel="stylesheet" href="/styles/~/buyer/cart/listGoods.css"/>
</head>
<body>
<#include "freemarker/base/nav.ftl">
<script type="text/javascript" src="/js/~/admin/index.js"></script>
<script>
    var stopCart = ${data!"null"};
</script>
<link rel="stylesheet" href="/styles/~/order/orderGoodsList.css"/>
<div ng-app="StopCart" ng-controller="ListCtrl" ng-cloak>
    <div class="list" ng-if="items">
        <md-list>

            <div ng-repeat="item in items.goods">
                <div ng-if="items.goodsRel[item.id]>0">
                    <md-subheader class="md-no-sticky"></md-subheader>
                    <p ng-if="$index==0"></p>
                    <div class="edit">
                        <span ng-click="delete(item, $index)">删除 </span>
                        <span ng-click="edit(item)">{{item.isEdit?'完成':'编辑'}}</span>
                    </div>
                <#--正常模式开始-->
                    <md-list-item ng-if="!item.isEdit" class="md-3-line md-long-text">
                        <img ng-src="/file/img/~/{{item.mainImgPath}}" <#--class="md-avatar"-->/>
                        <div class="md-list-item-text">
                            <h3>{{ item.title }}</h3>
                            <p>{{ item.subTitle }}</p>
                            <p>
                                <span class="price">{{ item.price | currency :'￥' : 2 }}</span>
                                <span class="quantity">x{{items.goodsRel[item.id]}}</span>
                            </p>
                        </div>
                        <md-checkbox class="md-primary" ng-model="buyState[item.id]"></md-checkbox>
                    </md-list-item>
                <#--正常模式结束-->
                <#--编辑模式开始-->
                    <md-list-item ng-if="item.isEdit" class="md-3-line md-long-text">
                        <link rel="stylesheet" href="/styles/~/order/orderGoodsList.css"/>
                        <img ng-src="/file/img/~/{{item.mainImgPath}}" <#--class="md-avatar"-->/>
                        <div class="md-list-item-text">
                            <div class="order-quantity">
                                <div class="buy-single-row mui-flex align-center">
                                    <div class="title cell fixed">购买数量</div>
                                    <div class="content cell">
                                        <a class="btn minus {{items.goodsRel[item.id]>1?'':'off'}}"
                                           ng-click="minus(item)"></a>
                                        <input class="amount ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-pattern"
                                               type="number" ng-model="items.goodsRel[item.id]"
                                               ng-change="onchangeAmount(item)" pattern="[0-9]*"
                                               aria-invalid="false">
                                        <a class="btn plus" ng-click="plus(item)"></a>
                                    </div>
                                </div>
                                <div class="seperator-wrap">
                                    <hr class="seperator">
                                </div>
                            </div>
                        </div>
                    </md-list-item>
                <#--编辑模式结束-->
                </div>
            </div>
        </md-list>

        <div>
            <form method="post" action="/order/cartConfirmOrder.html" id="ID_form">
                <input name="goods" type="hidden" ng-repeat="item in submitGoods" value="{{item.id}};{{item.quantity}}"/>
            </form>
        </div>

        <div ng-if="items && items.goods.length>0">
            <#include "freemarker/order/orderSubmitButton.ftl"/>
        </div>
    </div>
    <div class="nolist" ng-if="!items || items.goods.length==0">
        <a href="/goods/index.html"><h4>购物车还没有商品哟，赶快订购吧~</h4></a>
    </div>
</div>
</body>
<script type="text/javascript" src="/js/~/buyer/cart/listGoods.js"></script>
</html>

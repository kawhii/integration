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
<script>
    var stopCart = ${data!''};
</script>
<link rel="stylesheet" href="/styles/~/order/orderGoodsList.css"/>
<div ng-app="StopCart" ng-controller="ListCtrl" ng-cloak>
    <div class="list" ng-if="items">
        <md-list>
            <md-subheader class="md-no-sticky"></md-subheader>
            <md-list-item ng-repeat="item in items.goods" class="md-3-line md-long-text">
                <img ng-src="/file/img/~/{{item.mainImgPath}}" <#--class="md-avatar"-->/>
                <div class="md-list-item-text">
                    <h3>{{ item.title }}</h3>
                    <p>{{ item.subTitle }}</p>
                    <p>
                        <span class="price">{{ item.price | currency :'￥' : 2 }}</span>
                        <span class="quantity">x{{items.goodsRel[item.id]}}</span>
                    </p>
                </div>

                <md-checkbox class="md-primary"></md-checkbox>
            </md-list-item>
        </md-list>

        <#include "freemarker/order/orderSubmitButton.ftl">
    </div>
    <div class="nolist" ng-if="!items">
        <a href="/goods/index.html"><h4>购物车还没有商品哟，赶快订购吧~</h4></a>
    </div>
</div>
</body>
<script type="text/javascript" src="/js/~/buyer/cart/listGoods.js"></script>
</html>

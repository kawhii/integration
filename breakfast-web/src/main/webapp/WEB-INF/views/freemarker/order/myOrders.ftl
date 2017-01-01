<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">

    <title>订单管理</title>
<#include "freemarker/base/base.ftl">
    <link rel="stylesheet" href="/styles/~/user/myOrders.css"/>
</head>
<body>
<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>
<#include "freemarker/base/nav.ftl">
<div class="orders order-manage">
    <div class="orders-nav">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#">全部</a></li>
            <li role="presentation"><a href="#">待付款</a></li>
            <li role="presentation"><a href="#">待发货</a></li>
            <li role="presentation"><a href="#">待收货</a></li>
            <li role="presentation"><a href="#">待评价</a></li>
        </ul>
    </div>
</div>

</body>
</html>
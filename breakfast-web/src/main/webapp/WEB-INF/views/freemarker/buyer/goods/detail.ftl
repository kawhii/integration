<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${data.goods.title!''}</title>
<#include "freemarker/base/base.ftl">
    <script type="text/javascript" src="/js/~/admin/index.js"></script>
    <link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>
</head>
<body>
<style type="text/css">
    .baseInfo div {
        float: left;
        width: 33.33%;
        text-align: center;
        color: #c4c4c4;
    }
</style>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-5">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Q外卖</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
            <p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>
        </div>
    </div>
</nav>
<md-content class="md-padding" layout-xs="column" layout="row">
    <div flex-xs flex-gt-xs="50" layout="column">
        <div>
            <img src="/file/img/~/${data.goods.mainImgPath!''}" class="md-card-image" style="width: 100%">
        </div>
        <h5>${data.goods.title!''} ${data.goods.subTitle!''}</div>

    <div style="color: orangered;font-size: 20px">￥${data.goods.price?string('#.##')}</div>

    <small class="baseInfo">
        <div style="text-align: left">运费:0.00</div>
        <div>剩余:${data.goods.stock!''}</div>
        <div style="text-align: right"> 销量:${data.goods.sales!''}</div>
    </small>
    <hr>
    <p class="lead">
    ${data.goods.note!''}
    </p>
<#list data.goodsExtList as item>
    <#if item.keyName?contains("img")></#if>
    <p>
        <img src="/file/img/~/${item.val!''}" style="width: 100%"/>
    </p>
</#list>
    </div>
<#assign goodsId=data.goods.id>
<#include "freemarker/buyer/goods/operate.ftl">
</md-content>
</body>
</html>
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
    }

    .spilt-line {
        height: 1px;
        width: 100%;
        background: rgba(18, 67, 255, 0.2)
        overflow: hidden;
    }
</style>
<md-content class="md-padding" layout-xs="column" layout="row">
    <div flex-xs flex-gt-xs="50" layout="column">
        <md-card>
            <img src="/file/img/~/${data.goods.mainImgPath!''}" class="md-card-image" alt="Washed Out">
            <md-card-title>
                <md-card-title-text>
                    <span class="md-subhead">
                    ${data.goods.title!''} ${data.goods.subTitle!''}
                        <br><span style="color: orangered;font-size: 20px">￥${data.goods.price?string('#.##')}</span>
                        <div class="spilt-line"></div>

                        <small class="baseInfo">
                            <div style="text-align: left">运费:0.00</div><div>剩余:${data.goods.stock!''}</div>
                            <div style="text-align: right"> 销量:${data.goods.sales!''}</div>
                        </small>

                    </span>

                </md-card-title-text>
            </md-card-title>
            <md-card-content>
                <small>
                ${data.goods.note!''}
                </small>
            <#list data.goodsExtList as item>
                <#if item.keyName?contains("img")></#if>
                <p>
                    <img src="/file/img/~/${item.val!''}"/>
                </p>
            </#list>
            </md-card-content>
        </md-card>
    </div>
    <div id="footer" class="container">
        <nav class="navbar navbar-default navbar-fixed-bottom">
            <div class="navbar-inner navbar-content-center">
                <p class="text-muted credit" style="padding: 10px;">
                    ....
                </p>
            </div>
        </nav>
    </div>
</md-content>
</body>
</html>
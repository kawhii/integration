<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>包将军-管理平台</title>
<#include "freemarker/base/base.ftl">

</head>
<body>
<#include "freemarker/admin/welcome.ftl">
<div ng-app="App" ng-cloak ng-controller="AppCtrl" ng-cloak>
    <md-content class="md-padding" ng-init="currentNavItem='${url}'">
        <md-nav-bar md-selected-nav-item="currentNavItem" nav-bar-aria-label="navigation links">
            <md-nav-item ng-repeat="item in items" md-nav-href="${parentUrl}?p={{item.url}}" name="{{item.url}}">
                {{item.name}}
            </md-nav-item>
        </md-nav-bar>
        <script type="text/javascript" src="/js/~/admin/index.js"></script>

    </md-content>
</div>
<md-content class="md-padding">
<#include "freemarker/admin/" + url + ".ftl"/>
</md-content>
</body>

</html>

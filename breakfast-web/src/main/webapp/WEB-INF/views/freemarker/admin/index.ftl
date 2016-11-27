<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>早餐供应管理平台</title>
<#include "freemarker/base/base.ftl">
</head>

<body ng-app="App" ng-cloak>
<div ng-controller="AppCtrl" ng-cloak>
    <md-content class="md-padding">
        <md-nav-bar md-selected-nav-item="currentNavItem" nav-bar-aria-label="navigation links">
            <md-nav-item md-nav-click="goto('page1')" name="page1">Page One</md-nav-item>
            <md-nav-item md-nav-click="test()"  name="page2">Page tow</md-nav-item>
            <md-nav-item md-nav-click="test2()" name="page3">Page Three</md-nav-item>
            <!-- these require actual routing with ui-router or ng-route, so they won't work in the demo
            <md-nav-item md-nav-sref="app.page4" name="page4">Page Four</md-nav-item>
            <md-nav-item md-nav-href="#page5" name="page5">Page Five</md-nav-item>
            -->
        </md-nav-bar>
        <div class="ext-content">
            External content for `<span>{{currentNavItem}}</span>`{{page}}
            <div ng-include="page"></div>

        </div>
    </md-content>
</body>
<script type="text/javascript" src="/js/~/admin/index.js"></script>
</html>

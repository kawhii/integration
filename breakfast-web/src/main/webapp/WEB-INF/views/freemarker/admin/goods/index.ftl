<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>
<div id="ID_goods" ng-app="Goods" ng-controller="GoodsManagerCtrl" nv-file-drop="" uploader="uploader"
     filters="queueLimit, customFilter" ng-cloak>
<#--基本信息 start-->
    <#include "freemarker/admin/goods/baseInfo.ftl">
<#--基本信息 end-->
    <#--选择文件 start-->
    <#include "freemarker/admin/goods/selectFile.ftl">
<#--选择文件 end-->
</div>
<script src="/js/~/admin/goods/index.js"></script>


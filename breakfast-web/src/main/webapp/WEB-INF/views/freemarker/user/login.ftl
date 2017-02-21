<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>欢迎登录包将军金品质</title>
<#include "freemarker/base/base.ftl">
</head>

<body ng-app="App" ng-cloak>
<div ng-controller="LoginCtrl" layout="column" layout-padding ng-cloak>
    <form name="loginForm" method="POST" id="loginForm" action="/u/login">
        <md-content class="md-no-momentum">
            <md-input-container md-no-float class="md-block">
                <ng-md-icon icon="person" size="36"></ng-md-icon>
                <input ng-model="user.username" name="username"
                       required
                       type="text" oninput="if(value.length>50)value=value.slice(0,50)"
                       placeholder="手机号码">
            </md-input-container>

            <md-input-container md-no-float class="md-block">
                <ng-md-icon icon="lock" size="36"></ng-md-icon>
                <input ng-model="user.password" name="password" required type="password" placeholder="登陆密码">
            </md-input-container>
            <md-input-container md-no-float class="md-block">
                <md-checkbox name="rememberMe" aria-label="Checkbox 1">
                    记住我
                </md-checkbox>
            <#if shiroLoginFailure??><span style="color: red">用户名或密码错误</span></#if>
            </md-input-container>
            <md-input-container md-no-float class="md-block">
                <md-button class="md-raised md-primary" type="submit" ng-click="login()">登陆</md-button>
                <md-button class="md-raised" onclick="javascript:window.location.href='/u/reg.html'">注册</md-button>
            </md-input-container>
        </md-content>
    </form>
</div>
</body>
<script type="text/javascript" src="/js/~/user/login.js"></script>
</html>

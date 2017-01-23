<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>

<div id="ID_userApp" ng-app="UserApp" ng-controller="UserCtrl" ng-cloak>
    <div class="container">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a
                    href="javascript:void(0)">个人设置</a></li>
        </ul>
    </div>

<#--上传表单 start-->
    <div class="container">
        <div class="md-toolbar-tools">
            <h2 class="md-flex">修改密码</h2>
        </div>

        <div>
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">旧密码</label>
                    <input name="oldPwd" class="form-control" type="password" autocomplete="off"
                           ng-focus="modifyPwdStatus.oldPwd.state = 1"
                           ng-blur="modifyPwdStatus.oldPwd.onbulr(modifyPwd.oldPwd)"
                           ng-model="modifyPwd.oldPwd" placeholder="旧密码">
                    <div class="msg-text" ng-show="modifyPwdStatus.oldPwd.state == 1" style="color: #999">由字母加数字或符号至少两种以上字符组成的6-20位半角字符，区分大小写</div>
                    <div class="msg-error" ng-show="modifyPwdStatus.oldPwd.state > 1" style="color: red">{{modifyPwdStatus.oldPwd.msg}}</div>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">新密码</label>
                    <input name="newPwd"
                           ng-blur="modifyPwdStatus.newPwd.onbulr(modifyPwd.newPwd)"
                           type="password" class="form-control" autocomplete="off" ng-model="modifyPwd.newPwd" placeholder="新密码">
                    <#--<div class="msg-error" style="color: red">两次输入的密码不一致，请重试</div>-->
                    <div class="msg-error" ng-show="modifyPwdStatus.newPwd.state > 1" style="color: red">{{modifyPwdStatus.newPwd.msg}}</div>

                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">确认新密码</label>
                    <input name="confirmPwd" type="password" class="form-control" autocomplete="off" ng-model="modifyPwd.confirmPwd" placeholder="确认新密码">
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>

<#--上传表单 end-->
</div>
<#--文件列表 end-->
</div>
<script src="/js/~/admin/user/index.js"></script>


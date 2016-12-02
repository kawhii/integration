<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>
<script src="/webjars/angular-file-upload/angular-file-upload.min.js"></script>

<div id="ID_file" ng-app="FileApp" ng-controller="FileManagerCtrl" nv-file-drop="" uploader="uploader"
     filters="queueLimit, customFilter" ng-cloak>
    <div class="container">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="{{isUpload?'active':''}}" ng-click="isUpload = true"><a href="javascript:void(0)">文件上传区</a></li>
            <li role="presentation" class="{{isUpload?'':'active'}}" ng-click="isUpload = false"><a href="javascript:void(0)">文件信息</a></li>
        </ul>
    </div>

<#--上传表单 start-->
    <div class="container" ng-show="isUpload">
        <div class="row">
            <div class="col-md-3">
                <h3>请选择图片</h3>
                <div ng-show="uploader.isHTML5">
                </div>
                <input type="file" accept="image/gif, image/jpeg" nv-file-select="" uploader="uploader"
                       multiple/><br/>
            </div>

            <div class="col-md-9" style="margin-bottom: 40px">

                <h3>上传队列</h3>
                <p>待上传数: {{ uploader.queue.length }}</p>

                <table class="table">
                    <thead>
                    <tr>
                        <th width="40%">文件名</th>
                        <th ng-show="uploader.isHTML5">文件大小</th>
                        <th ng-show="uploader.isHTML5">上传进度</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="item in uploader.queue">
                        <td><strong>{{ item.file.name }}</strong></td>
                        <td ng-show="uploader.isHTML5" nowrap>{{ item.file.size/1024/1024|number:2 }} MB</td>
                        <td ng-show="uploader.isHTML5">
                            <div class="progress" style="margin-bottom: 0;">
                                <div class="progress-bar" role="progressbar"
                                     ng-style="{ 'width': item.progress + '%' }"></div>
                            </div>
                        </td>
                        <td class="text-center">
                            <span ng-show="item.isSuccess"><i class="glyphicon glyphicon-ok"></i></span>
                            <span ng-show="item.isCancel"><i class="glyphicon glyphicon-ban-circle"></i></span>
                            <span ng-show="item.isError"><i class="glyphicon glyphicon-remove"></i></span>
                        </td>
                        <td nowrap>
                            <button type="button" class="btn btn-success btn-xs" ng-click="item.upload()"
                                    ng-disabled="item.isReady || item.isUploading || item.isSuccess">
                                <span class="glyphicon glyphicon-upload"></span> 上传
                            </button>
                            <button type="button" class="btn btn-warning btn-xs" ng-click="item.cancel()"
                                    ng-disabled="!item.isUploading">
                                <span class="glyphicon glyphicon-ban-circle"></span> 取消
                            </button>
                            <button type="button" class="btn btn-danger btn-xs" ng-click="delete(item)">
                                <span class="glyphicon glyphicon-trash"></span> 删除
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <div>
                    <div>
                        上传进度:
                        <div class="progress" style="">
                            <div class="progress-bar" role="progressbar"
                                 ng-style="{ 'width': uploader.progress + '%' }"></div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-success btn-s" ng-click="uploader.uploadAll()"
                            ng-disabled="!uploader.getNotUploadedItems().length">
                        <span class="glyphicon glyphicon-upload"></span> 全部上传
                    </button>
                    <button type="button" class="btn btn-warning btn-s" ng-click="uploader.cancelAll()"
                            ng-disabled="!uploader.isUploading">
                        <span class="glyphicon glyphicon-ban-circle"></span> 全部取消
                    </button>
                    <#--<button type="button" class="btn btn-danger btn-s" ng-click="uploader.clearQueue()"
                            ng-disabled="!uploader.queue.length">
                        <span class="glyphicon glyphicon-trash"></span> 全部移除
                    </button>-->
                </div>

            </div>

        </div>
    </div>
<#--上传表单 end-->

<#--文件列表 start-->
    <div class="container" ng-show="!isUpload">
        <div class="md-toolbar-tools">
            <h2 class="md-flex">文件总数：{{data.totalCount}}，当前页：{{data.currentPage}}，总页数：{{data.totalPage}}</h2>
        </div>
        <div>
            <div class="form-group form-inline">
                <input type="text" class="form-control" ng-model="name" placeholder="文件名">
                <button type="button" class="btn btn-default" ng-click="search()">查询</button>
            </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>操作</th>
                    <th>名称</th>
                    <th>大小</th>
                    <th>上传用户</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="item in data.recordList">
                    <td>{{$index+1}}</td>
                    <td>
                        <button type="button" class="btn btn-link" ng-click="delete(null, item.id)">删除</button>
                    </td>
                    <td>{{item.uploadName}}</td>
                    <td><img ng-src="/file/img/~/{{item.visitPath}}" style="width: 45px;height: 45px"/></td>
                    <td>{{item.fileSize/1024 | number : 2}}KB</td>
                    <td>{{item.uploadUser}}</td>
                </tr>
                </tbody>
            </table>
            <nav>
                <ul class="pager">
                    <li ng-if="pageInfo.havePre"><a href="javascript:void(0)"
                                                    ng-click="pre()">上一页({{pageInfo.curr-1}})</a>
                    </li>
                    <li ng-if="pageInfo.haveNext"><a href="javascript:void(0)"
                                                     ng-click="next()">下一页({{pageInfo.curr+1}})</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
<#--文件列表 end-->
</div>
<script src="/js/~/admin/sys/file.js"></script>


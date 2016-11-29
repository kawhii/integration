<link rel="stylesheet" href="/styles/common/bootstrap.min.css"/>
<script src="/webjars/angular-file-upload/angular-file-upload.min.js"></script>

<div id="ID_goods" ng-app="Goods" ng-controller="GoodsManagerCtrl" nv-file-drop="" uploader="uploader"
     filters="queueLimit, customFilter" ng-cloak>

    <div class="container">

        <div class="navbar navbar-default">
            <div class="navbar-header">
                <a class="navbar-brand" href="https://github.com/nervgh/angular-file-upload">文件上传区</a>
            </div>

        </div>
        <div class="row">
            <div class="col-md-3">
                <h3>请选择图片</h3>
                <div ng-show="uploader.isHTML5">
                </div>

                <!-- Example: nv-file-select="" uploader="{Object}" options="{Object}" filters="{String}" -->
                选择图片
                <input type="file" accept="image/gif, image/jpeg" nv-file-select="" uploader="uploader" multiple/><br/>

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
                        <td><strong>{{ item.file.name }}<span ng-if="$index==0" style="color: red">（主展示图）</span></strong></td>
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
                            <button type="button" class="btn btn-danger btn-xs" ng-click="item.remove()">
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
                    <button type="button" class="btn btn-danger btn-s" ng-click="uploader.clearQueue()"
                            ng-disabled="!uploader.queue.length">
                        <span class="glyphicon glyphicon-trash"></span> 全部移除
                    </button>
                </div>

            </div>

        </div>

    </div>
</div>
<script src="/js/~/admin/goods/index.js"></script>


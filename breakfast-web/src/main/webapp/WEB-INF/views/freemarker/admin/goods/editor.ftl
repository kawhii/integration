<div style="visibility: hidden">
    <div class="md-dialog-container" id="ID_editDialog">
        <md-dialog>
            <div class="navbar navbar-default">
                <div class="navbar-header">
                    <a class="navbar-brand" href="javascript:void(0)">[{{updateData.goods.name}}]正在修改</a>
                </div>
            </div>
            <md-content md-theme="docs-dark" layout-gt-sm="row" layout-padding>
                <div>
                    <form name="goodsBaseForm">
                        <md-input-container>
                            <label>{{goodsInfo.title.title}}</label>
                            <input ng-model="updateData.goods.title" name="title" required md-maxlength="25">

                            <div ng-messages="goodsBaseForm.title.$error" multiple md-auto-hide="false">
                                <div ng-message="required">{{goodsInfo.title.title}}必填</div>

                                <div ng-message="md-maxlength">标题过长了亲</div>
                            </div>
                        </md-input-container>

                        <md-input-container>
                            <label>{{goodsInfo.stock.title}}</label>
                            <input type="number" min="0" max="9999" step="1" name="stock"
                                   ng-model="updateData.goods.stock"
                                   onkeyup="value=value.replace(/[^\d]/g,'')" required>

                            <div ng-messages="goodsBaseForm.stock.$error" multiple md-auto-hide="false">
                                <div ng-message="required">{{goodsInfo.stock.title}}必填</div>
                            </div>
                        </md-input-container>

                        <md-input-container>
                            <label>{{goodsInfo.price.title}}</label>
                            <input type="number" min="0" max="9999" name="price" ng-model="updateData.goods.price"
                                   required>
                            <div ng-messages="goodsBaseForm.price.$error" multiple md-auto-hide="false">
                                <div ng-message="required">{{goodsInfo.price.title}}必填</div>
                            </div>
                        </md-input-container>


                        <md-input-container class="md-block">
                            <label>{{goodsInfo.subTitle.title}}</label>
                            <input ng-model="updateData.goods.subTitle">
                        </md-input-container>

                        <md-input-container class="md-block">
                            <label>{{goodsInfo.note.title}}</label>
                            <textarea ng-model="updateData.goods.note" md-maxlength="150" name="note" rows="5"
                                      md-select-on-focus></textarea>

                            <div ng-messages="goodsBaseForm.note.$error" multiple md-auto-hide="false">
                                <div ng-message="md-maxlength">{{goodsInfo.note.title}}过长了</div>
                            </div>
                        </md-input-container>
                </div>
            </md-content>
            </form>
            <md-dialog-actions layout="row">
                <md-button ng-click="cancelUpdate()">
                    取消
                </md-button>
                <md-button ng-click="saveUpdate()">
                    保存
                </md-button>
            </md-dialog-actions>
        </md-dialog>

    </div>
</div>
<script src="/js/~/admin/goods/fileChipCtrl.js"></script>



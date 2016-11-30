<#--商品基本信息-->
<div class="container">
    <div class="navbar navbar-default">
        <div class="navbar-header">
            <a class="navbar-brand" href="javascript:void(0)">商品基本信息区</a>
        </div>
    </div>
    <div class="row">
        <md-content md-theme="docs-dark" layout-gt-sm="row" layout-padding>
            <div>
                <form name="goodsBaseForm">
                    <md-input-container>
                        <label>{{goodsInfo.name.title}}</label>
                        <input md-maxlength="10" ng-model="goodsInfo.name.val" name="name" required/>
                        <div ng-messages="goodsBaseForm.name.$error" multiple md-auto-hide="false">
                            <div ng-message="required">{{goodsInfo.name.title}}必填</div>

                            <div ng-message="md-maxlength">名字过长了亲</div>
                        </div>
                    </md-input-container>

                    <md-input-container>
                        <label>{{goodsInfo.title.title}}</label>
                        <input ng-model="goodsInfo.title.val" name="title" required md-maxlength="25">

                        <div ng-messages="goodsBaseForm.title.$error" multiple md-auto-hide="false">
                            <div ng-message="required">{{goodsInfo.title.title}}必填</div>

                            <div ng-message="md-maxlength">标题过长了亲</div>
                        </div>
                    </md-input-container>

                    <md-input-container>
                        <label>{{goodsInfo.stock.title}}</label>
                        <input type="number" min="0" max="9999" step="1" name="stock" ng-model="goodsInfo.stock.val"
                               onkeyup="value=value.replace(/[^\d]/g,'')" required>

                        <div ng-messages="goodsBaseForm.stock.$error" multiple md-auto-hide="false">
                            <div ng-message="required">{{goodsInfo.stock.title}}必填</div>
                        </div>
                    </md-input-container>

                    <md-input-container>
                        <label>{{goodsInfo.price.title}}</label>
                        <input type="number" min="0" max="9999" name="price" ng-model="goodsInfo.price.val" required>
                        <div ng-messages="goodsBaseForm.price.$error" multiple md-auto-hide="false">
                            <div ng-message="required">{{goodsInfo.price.title}}必填</div>
                        </div>
                    </md-input-container>


                    <md-input-container class="md-block">
                        <label>{{goodsInfo.subTitle.title}}</label>
                        <input ng-model="goodsInfo.subTitle.val">
                    </md-input-container>

                    <md-input-container class="md-block">
                        <label>{{goodsInfo.note.title}}</label>
                        <textarea ng-model="goodsInfo.note.val" md-maxlength="150" name="note" rows="5" md-select-on-focus></textarea>

                        <div ng-messages="goodsBaseForm.note.$error" multiple md-auto-hide="false">
                            <div ng-message="md-maxlength">{{goodsInfo.note.title}}过长了</div>
                        </div>
                    </md-input-container>
            </div>
        </md-content>
        </form>
    </div>
</div>
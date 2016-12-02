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

            <div ng-controller="ContactChipDemoCtrl as ctrl" layout="column" ng-cloak>

                <md-content class="md-padding autocomplete" layout="column">
                    <md-contact-chips
                            ng-model="ctrl.contacts"
                            md-contacts="ctrl.querySearch($query)"
                            md-contact-name="name"
                            md-contact-image="image"
                            md-contact-email="email"
                            md-require-match="true"
                            md-highlight-flags="i"
                            filter-selected="ctrl.filterSelected"
                            placeholder="To">
                    </md-contact-chips>

                    <md-list class="fixedRows">
                        <md-subheader class="md-no-sticky">Contacts</md-subheader>
                        <md-list-item class="md-2-line contact-item" ng-repeat="(index, contact) in ctrl.allContacts"
                                      ng-if="ctrl.contacts.indexOf(contact) < 0">
                            <img ng-src="{{contact.image}}" class="md-avatar" alt="{{contact.name}}" />
                            <div class="md-list-item-text compact">
                                <h3>{{contact.name}}</h3>
                                <p>{{contact.email}}</p>
                            </div>
                        </md-list-item>
                        <md-list-item class="md-2-line contact-item selected" ng-repeat="(index, contact) in ctrl.contacts">
                            <img ng-src="{{contact.image}}" class="md-avatar" alt="{{contact.name}}" />
                            <div class="md-list-item-text compact">
                                <h3>{{contact.name}}</h3>
                                <p>{{contact.email}}</p>
                            </div>
                        </md-list-item>
                    </md-list>

                    <br>
                    <h2 class="md-title">Searching asynchronously.</h2>
                    <md-contact-chips
                            ng-model="ctrl.asyncContacts"
                            md-contacts="ctrl.delayedQuerySearch($query)"
                            md-contact-name="name"
                            md-contact-image="image"
                            md-contact-email="email"
                            md-require-match="true"
                            md-highlight-flags="i"
                            filter-selected="ctrl.filterSelected"
                            placeholder="To">
                    </md-contact-chips>
                </md-content>
            </div>
        </md-dialog>

    </div>
</div>



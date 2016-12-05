<script type="text/javascript" src="/js/~/buyer/goods/list.js"></script>
<div ng-app="BuyerGoods" ng-controller="BuyerGoodsListCtrl" id="ID_BuyerGoods" ng-cloak style="background-color: honeydew">
    <div flex-gt-sm="50" flex>

        <md-toolbar layout="row" class="md-hue-3">
            <div class="md-toolbar-tools">
                <span>最新商品</span>
            </div>
        </md-toolbar>

        <md-content>
            <md-list flex>
                <md-list-item class="md-3-line md-long-text" ng-repeat="item in items" ng-click="null"
                              style="background-color:white;border: 1px solid #e5e5e5;margin-left: 10px;margin-right: 10px">
                    <img ng-src="/file/img/~/{{item.mainImgPath}}" style="width: 125px;height: 125px;padding: 5px"/>
                    <div class="md-list-item-text" style="padding-left: 10px" layout="column">
                        <h3>{{ item.title }}</h3>
                        <h4>{{ item.subTitle }}</h4>
                        <p style="color:red;">{{item.price| currency : '￥' : 2}}</p>

                    </div>

                    <div class="md-secondary-container">
                        <ng-md-icon icon="add_shopping_cart" size="36">
                            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="36" height="36">
                                <path d="M11 9h2V6h3V4h-3V1h-2v3H8v2h3v3z"></path>
                                <path d="M7 18c-1.1 0-1.99.9-1.99 2S5.9 22 7 22s2-.9 2-2-.9-2-2-2z"></path>
                                <path d="M17 18c-1.1 0-1.99.9-1.99 2s.89 2 1.99 2 2-.9 2-2-.9-2-2-2z"></path>
                                <path d="M7.17 14.75l.03-.12.9-1.63h7.45c.75 0 1.41-.41 1.75-1.03l3.86-7.01L19.42 4h-.01l-1.1 2-2.76 5H8.53l-.13-.27L6.16 6l-.95-2-.94-2H1v2h2l3.6 7.59-1.35 2.45c-.16.28-.25.61-.25.96 0 1.1.9 2 2 2h12v-2H7.42c-.13 0-.25-.11-.25-.25z"></path>
                            </svg>
                        </ng-md-icon>
                    </div>
                </md-list-item>
                <md-divider></md-divider>
                <md-menu-item ng-if="haveNextPage" ng-click="loadMore()">
                    <md-button style="text-align: center">
                        查找更多
                    </md-button>
                </md-menu-item>
            </md-list>
        </md-content>
    </div>
</div>

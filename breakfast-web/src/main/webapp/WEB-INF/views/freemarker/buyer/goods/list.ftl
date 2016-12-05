<script type="text/javascript" src="/js/~/buyer/goods/list.js"></script>
<div ng-app="BuyerGoods" ng-controller="BuyerGoodsListCtrl" id="ID_BuyerGoods" ng-cloak>
    <div flex-gt-sm="50" flex>

        <md-toolbar layout="row" class="md-hue-3">
            <div class="md-toolbar-tools">
                <span>最新商品</span>
            </div>
        </md-toolbar>

        <md-content>
            <md-list flex>
                <md-list-item class="md-3-line" ng-repeat="item in items" ng-click="null">
                    <img ng-src="/file/img/~/{{item.mainImgPath}}" class="md-avatar"/>
                    <div class="md-list-item-text" layout="column">
                        <h3>{{ item.title }}</h3>
                        <h4>{{ item.subTitle }}</h4>
                        <p style="color:red;">{{item.price| currency : '￥' : 2}}</p>

                    </div>

                    <div class="md-secondary-container">
                        加入购物车
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

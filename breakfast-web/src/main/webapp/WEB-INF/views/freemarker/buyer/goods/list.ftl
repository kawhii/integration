<script type="text/javascript" src="/js/~/buyer/goods/list.js"></script>
<div ng-app="BuyerGoods" ng-controller="BuyerGoodsListCtrl" id="ID_BuyerGoods" ng-cloak>
    <div flex-gt-sm="50" flex>

        <md-toolbar layout="row" class="md-hue-3">
            <div class="md-toolbar-tools">
                <span>Normal</span>
            </div>
        </md-toolbar>

        <md-content>
            <md-list flex>
                <md-subheader class="md-no-sticky">3 line item (with hover)</md-subheader>
                <md-list-item class="md-3-line" ng-repeat="item in todos" ng-click="null">
                    <img ng-src="{{item.face}}?{{$index}}" class="md-avatar" alt="{{item.who}}" />
                    <div class="md-list-item-text" layout="column">
                        <h3>{{ item.who }}</h3>
                        <h4>{{ item.what }}</h4>
                        <p>{{ item.notes }}</p>
                    </div>
                </md-list-item>
                <md-divider ></md-divider>
                <md-subheader class="md-no-sticky">2 line item</md-subheader>
                <md-list-item class="md-2-line">
                    <img ng-src="{{todos[0].face}}?20" class="md-avatar" alt="{{todos[0].who}}" />
                    <div class="md-list-item-text">
                        <h3>{{ todos[0].who }}</h3>
                        <p>Secondary text</p>
                    </div>
                </md-list-item>
                <md-divider ></md-divider>
                <md-subheader class="md-no-sticky">3 line item, long paragraph (see on mobile)</md-subheader>
                <md-list-item class="md-3-line md-long-text">
                    <img ng-src="{{todos[0].face}}?25" class="md-avatar" alt="{{todos[0].who}}" />
                    <div class="md-list-item-text">
                        <h3>{{ todos[0].who }}</h3>
                        <p>
                            Secondary line text Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam massa quam.
                            Nulla metus metus, ullamcorper vel, tincidunt sed, euismod in, nibh. Quisque volutpat condimentum
                            velit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.
                        </p>
                    </div>
                </md-list-item>
</div>

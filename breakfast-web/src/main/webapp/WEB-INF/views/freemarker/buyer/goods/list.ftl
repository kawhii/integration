<script type="text/javascript" src="/js/~/buyer/goods/list.js"></script>
<link rel="stylesheet" , href="/styles/~/buyer/goods/list.css"/>
<div ng-app="BuyerGoods" ng-controller="BuyerGoodsListCtrl" id="ID_BuyerGoods" ng-cloak
     style="background-color: honeydew">
    <div flex-gt-sm="50" flex>

        <md-toolbar layout="row" class="md-hue-3" style="background-color: coral">
            <div class="md-toolbar-tools">
                <span>最新商品</span>
            </div>
        </md-toolbar>

        <md-content>
            <ul class="searchlist-long-pic">
                <li class="big-pic-list" ng-repeat="item in items">
                    <a class="card-border J_ping"
                       ng-href="detail/{{item.id}}">
                        <!-- 用js根据下面这个div的宽算出高并赋值height=width -->
                        <div class="square-pic-list-div">
                            <img width="100%"
                                 style="height: 264.103px; opacity: 1; transition: opacity 0.5s ease-in;"
                                 ng-src="/file/img/~/{{item.mainImgPath}}"></div>
                        <div class="product-content-box">
                            <div class="square-pic-list-name">
                                <span>{{ item.title }} {{item.subTitle}}</span>
                            </div>
                            <div class="price-auther-sam">
                                <div class="product-book-author-big"></div>
                                <div class="square-pic-list-price">
                                    <span class="product-price1">¥ <span class="big-price">{{item.price| currency :'' : 2}}</span></span>
                                    <#--<span class="little-icon">满减</span>-->
                                </div>
                            </div>
                            <#--<div class="evaluate-self"><span class="evaluate">81682条评价</span></div>-->
                        </div>
                    </a>
                </li>

            </ul>
        </md-content>
        <md-menu-item ng-if="haveNextPage" ng-click="loadMore()">
            <md-button style="text-align: center">
                查找更多
            </md-button>
        </md-menu-item>
    </div>
</div>

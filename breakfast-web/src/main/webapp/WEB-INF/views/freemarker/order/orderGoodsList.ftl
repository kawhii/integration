<link rel="stylesheet" href="/styles/~/order/orderGoodsList.css"/>
<div ng-app="OrderGoodsList" ng-controller="ListCtrl" ng-cloak>

    <div class="panel panel-default order-order" ng-repeat="item in items.goodsItems">
        <!-- Default panel contents -->
        <div class="panel-heading">{{item.title}}</div>
        <div class="order-item">
            <div class="order-itemInfo mui-flex">
                <div class="cell fixed item-pic">
                    <div class="img">
                        <img class="img-cell" ng-src="/file/img/~/{{item.mainImgPath}}" style="width: 92px;height: 92px">
                    </div>
                </div>
                <div class="content cell">
                    <div class="title">{{item.subTitle}}</div>
                    <div class="sku-info">
                        <span><#--颜色分类--></span>
                    </div>
                    <div class="icon-main mui-flex align-center">
                        <div class="item-icon-tip"><#--七天包换--></div>
                    </div>
                </div>
                <div class="ext cell fixed item-pay">
                    <div class="price">{{item.price| currency : '￥' : 2}}</div>
                    <div class="quantity">X{{items['quantity'][item.id]}}</div>
                </div>
            </div>
        </div>

        <div class="order-quantity">
            <div class="buy-single-row mui-flex align-center">
                <div class="title cell fixed">购买数量</div>
                <div class="content cell">
                    <a class="btn minus off" ></a>
                    <input class="amount" type="number" value="1" pattern="[0-9]*" >
                    <a class="btn plus"></a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/~/order/orderGoodsList.js"></script>
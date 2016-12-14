<div class="order-submitOrder">
    <div class="mui-flex align-center">
        <div class="cell realPay">
            <div class="realPay-wrapper">
                <span>共</span>
                <span class="count">{{goodsTotal}}</span>
                <span>件，</span>
                <span></span>
                <span>总金额</span>
                <span class="price">
                    <span class="main-price">{{priceTotal| currency : '￥' : 2}}</span>
                </span>
            </div>
        </div>
        <div class="cell fixed action" ng-click="createOrder()">
            <div class="mui-flex align-center">
                <span title="提交订单">提交订单</span>
            </div>
        </div>
    </div>
</div>
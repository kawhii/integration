<div class="order-submitOrder">
    <div class="mui-flex align-center">
        <div class="cell realPay">
            <div class="realPay-wrapper">
                <span>共</span>
                <span class="count">{{goodsTotal?goodsTotal:0}}</span>
                <span>件，</span>
                <span></span>
                <span>总金额</span>
                <span class="price">
                    <span class="main-price">{{priceTotal?priceTotal:0| currency : '￥' : 2}}</span>
                </span>
            </div>
        </div>
        <div class="cell fixed action" ng-click="createOrder()">
            <div class="mui-flex align-center">
                <span title="提交订单">${submitTitle!'提交订单'}</span>
            </div>
        </div>
    </div>
</div>
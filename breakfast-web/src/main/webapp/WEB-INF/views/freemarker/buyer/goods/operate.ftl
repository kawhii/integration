<style>
    #footer button {
        border: none;
        height: 49px;
        color: whitesmoke;
        font-size: 15px;
        text-align: center;
        width: 49%;
    }
    #footer .cart {
        background-color: #FF9500;
        float: left;
    }
    #footer .buy {
        background-color: #DD2727;
        float: right;
    }
</style>
<div id="footer" class="container" ng-controller="OperateCtrl" ng-init="goodsId=${goodsId}">
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div id="s-actionbar" class="action-bar mui-flex align-center">
            <button class="cart cell" ng-click="cart()">加入购物车</button>
            <button class="buy cell" ng-click="buy()">立即购买</button>
        </div>
    </nav>
</div>
<script type="text/javascript" src="/js/~/buyer/goods/toBuy.js"></script>
<script type="text/javascript" src="/js/~/buyer/goods/operate.js"></script>
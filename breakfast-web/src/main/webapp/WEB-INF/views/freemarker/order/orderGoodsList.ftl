<div ng-app="OrderGoodsList" ng-controller="ListCtrl" ng-cloak>
    <table class="table">
        <tbody>
        <tr ng-repeat="item in items.goodsItems">
            <td>
                <div>

                    <div>
                        <img ng-src="/file/img/~/{{item.mainImgPath}}" style="width: 80px;height: 80px">
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<script src="/js/~/order/orderGoodsList.js"></script>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<link rel="stylesheet" , href="/styles/~/buyer/goods/detailToBuy.css"/>

<div style="max-width:800px;max-height:810px;height: 200px;width: 300px" ng-cloak="">
    <div class="mui-cover show" id="s-decision-wrapper" style="display: block;">
        <div class="summary">
            <div class="img">
                <img style="width: 100px;height: 100px;"
                     src="/file/img/~/${data.goods.mainImgPath!''}"
                     alt="">
            </div>
            <div class="main">
                <div class="priceContainer"><span class="price">¥${data.goods.price!''}</span></div>
                <div class="stock-control"><span class="stock"><label
                        class="stock_label">库存</label>${data.goods.stock!''}件</span><span
                        class="limitTip"></span></div>
            </div>
            <a class="sback"></a>
        </div>
        <div class="body" style="overflow: hidden;">
            <section id="s-decision"
                     style="transition-property: -webkit-transform; transform-origin: 0px 0px 0px; transform: translate3d(0px, 0px, 0px);">
                <div class="number">
                    <h2>数量</h2>
                    <div class="content">
                        <div class="number-control">
                            <div class="mui-number">
                                <button type="button" class="decrease disabled">-</button>
                                <input type="number" class="num" value="1" min="1" max="405" step="" name="quantity">
                                <button type="button" class="increase">+</button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <div class="option mui-flex">
            <button class="ok cell">确定</button>
        </div>
    </div>
</div>
</body>
</html>
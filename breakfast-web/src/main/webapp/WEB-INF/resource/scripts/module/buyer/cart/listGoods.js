/**
 * @date 2017/1/29
 *
 * @author Carl
 * @note
 * --------------------
 * @depend
 * @modify
 * 版权所有.(c)2008-2017.卡尔工作室
 */
!(function () {
    'use strict';

    var app = new Vue({
        el: '#ID_CartGoodsApp',
        data: {}, methods: {
            //编辑选中的，1-提交，0-删除
            editChoose: function () {
                var type = $('.carts-edit').val();
                var chooseId = [];
                //获取全部选中的id
                $('.carts-choose :checkbox:checked').each(function () {
                    chooseId.push($(this).val());
                });
                if (type == 0) {
                    //移除选中的
                    removeChoose(chooseId, $('.carts-choose :checkbox:checked'));
                } else {
                    //填写订单
                    fillOrder(chooseId);
                }
            },
            //删除
            remove: function (id, event) {
                carl.request("/cart/operateGoods", {type: 3, goods: {goodsId: id}},
                    function (data) {
                        if (data.header.code == 0) {
                            $(event.target).parent().remove()
                        }
                    }, {get: false});
            },
            //减法
            minus: function (id, event) {
                var singleNum = parseInt($(event.target).parent().parent().find(".singleNum").html());
                if (singleNum <= 1) {
                    return;
                }
                carl.request("/cart/operateGoods", {type: 2, goods: {quantity: 1, goodsId: id}},
                    function (data) {
                        if (data.header.code == 0) {
                            if (singleNum > 1) {
                                $(event.target).parent().parent().find(".singleNum").html(singleNum - 1);
                            } else {
                                $(event.target).parent().parent().find(".singleNum").html(1);
                            }
                            cartsNum();
                        }
                    }, {get: false});
            },
            //加
            plus: function (id, event) {
                carl.request("/cart/operateGoods", {type: 1, goods: {quantity: 1, goodsId: id}},
                    function (data) {
                        if (data.header.code == 0) {
                            var singleNum = parseInt($(event.target).parent().parent().find(".singleNum").html());
                            if (singleNum <= 10000) {
                                $(event.target).parent().parent().find(".singleNum").html(singleNum + 1);
                            } else {
                                $(event.target).parent().parent().find(".singleNum").html(10000);
                            }
                            cartsNum();
                        }
                    }, {get: false});
            }
        }
    });

    //删除被移除的
    function removeChoose(ids, targets) {
        if (ids.length == 0) {
            carl.toast("还没有选中哦~");
            return;
        }

        carl.request("/cart/removeGoods", ids,
            function (data) {
                if (data.header.code == 0) {
                    targets.parent().parent().parent().remove();
                    cartsNum();
                }
            }, {get: false});
    }

    //提交确认订单
    function fillOrder(ids) {
        if (ids.length == 0) {
            carl.toast("还没有选中哦~");
            return;
        }
        $('#ID_submitFill').submit();
    }

    //计算购物车选中商品数量和总价格
    function cartsNum() {
        var cartsNum = $(".carts-main input:checked").length;
        $(".cartsNum").text(cartsNum);

        //计算商品总数量
        var divNum = $(".carts-main>div").size();

        //计算被选中商品总价格
        var priceTotal = 0;
        for (var i = 0; i < divNum; i++) {
            var choosediv = $(".carts-main>div:eq(" + i + ")");
            if (choosediv.find(".carts-choosebox").hasClass("carts-chooseboxBg")) {
                var price = choosediv.find(".carts-goods-price").html().substring(1);
                var singleNum = choosediv.find(".singleNum").html();
                priceTotal += parseInt(price) * parseInt(singleNum);
                $(".priceTotal").html("￥" + priceTotal.toFixed(2));
            }
        }

        //当选中商品为0时，总价格为0
        if (cartsNum == 0) {
            $(".priceTotal").html("￥0.00");
        }
    }

}());

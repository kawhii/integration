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
    var goodsId = $('#ID_goodsId').val();

    var app = new Vue({
        el: '#ID_detailApp',
        data: {
            //当前商品购物车数量
            cartCount: 0,
            commentNext: true,
            //评论总数
            commentCount: '',
            commentLoadTitle: '',
            page: 1,
            //评论
            comment: []
        }, methods: {
            //添加到购物车
            addStopCart: function (id) {
                carl.request("/cart/addGoods", {quantity: 1, goodsId: id},
                    function (data) {
                        if (data.header.code == 0) {
                            app.cartCount++;
                            carl.toast("添加成功");
                        }
                    }, {get: false});
            },
            goCartPage: function () {
                window.location.href = "/cart/listGoods.html"
            },
            loadMore: loadComment
        }
    });

    //加载购物车当前商品数量
    function loadCardGoodsCount(goodsId) {
        carl.request("/cart/queryGoodsCount", {goodsId: goodsId}, function (data) {
            if (data.header.code == 0) {
                app.cartCount = data.body;
            }
        }, {mask: false});


    }

    //评论
    var comments = [];
    //加载评论
    function loadComment() {
        if (app.commentNext) {
            carl.request("/comment/goods/" + goodsId, {page: app.page}, function (data) {
                if (data.header.code == 0) {
                    comments = comments.concat(data.body.recordList);
                    app.comment = comments;
                    app.commentLoadTitle = "点击查看更多评论";
                    app.commentCount = data.body.totalCount;
                    app.page++;
                    if (data.body.endPageIndex == 0) {
                        app.commentNext = false;
                        app.commentLoadTitle = "";
                        return;
                    }
                    if (data.body.currentPage == data.body.endPageIndex) {
                        app.commentNext = false;
                        app.commentLoadTitle = "已经看完所有评论啦~";
                    }

                }
            }, {mask: false});
        }
    }


    loadCardGoodsCount(goodsId);
    loadComment();

    //由于高度的问题重写设
    function setHeight() {
        var bodyHeight = $(document).height();
        $(".contain").height(bodyHeight);
        setTimeout(setHeight, 5000)
    }

}());

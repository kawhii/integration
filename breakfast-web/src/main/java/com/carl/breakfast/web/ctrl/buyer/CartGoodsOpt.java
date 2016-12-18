package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.dao.pojo.cart.CartGoods;

/**
 * 购物车操作
 * @author Carl
 * @date 2016/12/18
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class CartGoodsOpt {
    private CartGoods goods;
    //1，加，2-减，3，删除
    private int type;

    public CartGoods getGoods() {
        return goods;
    }

    public CartGoodsOpt setGoods(CartGoods goods) {
        this.goods = goods;
        return this;
    }

    public int getType() {
        return type;
    }

    public CartGoodsOpt setType(int type) {
        this.type = type;
        return this;
    }
}

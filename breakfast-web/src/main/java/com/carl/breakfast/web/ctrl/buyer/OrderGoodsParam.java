package com.carl.breakfast.web.ctrl.buyer;

/**
 * 商品参数
 * @author Carl
 * @date 2016/12/16
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class OrderGoodsParam {
    private int goodsId;
    private int quantity;


    public int getGoodsId() {
        return goodsId;
    }

    public OrderGoodsParam setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderGoodsParam setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}

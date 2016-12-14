package com.carl.breakfast.web.ctrl.buyer;

/**
 * 订单创建参数
 * @author Carl
 * @date 2016/12/14
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class OrderParam {
    private int goodsId;
    private int quantity;


    public int getGoodsId() {
        return goodsId;
    }

    public OrderParam setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderParam setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}

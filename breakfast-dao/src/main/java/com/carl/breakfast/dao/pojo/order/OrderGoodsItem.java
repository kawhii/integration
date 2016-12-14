package com.carl.breakfast.dao.pojo.order;

import com.carl.framework.core.entity.BaseEntity;

/**
 * 订单商品信息
 *
 * @author Carl
 * @date 2016/12/15
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class OrderGoodsItem extends BaseEntity {
    //ORDER_ID
    private String orderId;
    //GOODS_ID
    private int goodsId;
    //QUANTITY
    private int quantity = 0;
    //UNIT_PRICE
    private float unitPrice = 0;
    //GOODS_TITLE
    private String goodsTitle;
    //GOODS_IMG_PATH
    private String goodsImgPath;
    //GOODS_IMG_ID
    private int goodsImgId;

    //获取总价
    public float getTotalPrice() {
        return getUnitPrice() * getQuantity();
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderGoodsItem setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public OrderGoodsItem setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
        return this;
    }

    public String getGoodsImgPath() {
        return goodsImgPath;
    }

    public OrderGoodsItem setGoodsImgPath(String goodsImgPath) {
        this.goodsImgPath = goodsImgPath;
        return this;
    }

    public int getGoodsImgId() {
        return goodsImgId;
    }

    public OrderGoodsItem setGoodsImgId(int goodsImgId) {
        this.goodsImgId = goodsImgId;
        return this;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public OrderGoodsItem setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderGoodsItem setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public OrderGoodsItem setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }
}

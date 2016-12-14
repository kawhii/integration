package com.carl.breakfast.dao.pojo.order;

/**
 * 订单商品信息
 *
 * @author Carl
 * @date 2016/12/15
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class OrderGoodsItem {
    private int goodsId;
    private int quantity = 0;
    private float unitPrice = 0;
    private String goodsTitle;
    private String goodsImgPath;
    private String goodsImgId;

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

    public String getGoodsImgId() {
        return goodsImgId;
    }

    public OrderGoodsItem setGoodsImgId(String goodsImgId) {
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

    //获取总价
    public float getTotalPrice() {
        return getUnitPrice() * getQuantity();
    }
}

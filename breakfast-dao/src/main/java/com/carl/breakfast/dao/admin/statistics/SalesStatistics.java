package com.carl.breakfast.dao.admin.statistics;

import com.carl.framework.core.entity.BaseEntity;


/**
 * 销售量
 * @author Carl
 * @date 2017/1/17
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class SalesStatistics extends BaseEntity {
    private String goodsId;

    //商品名字
    private String goodsName;
    //栋
    private String unitCode;
    //栋
    private String unitName;

    //单价
    private float unitPrice;
    //总销售额
    private float totalPrice;

    //库存
    private int stock;

    //销售量
    private int sales;

    public String getGoodsId() {
        return goodsId;
    }

    public SalesStatistics setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public SalesStatistics setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public SalesStatistics setUnitCode(String unitCode) {
        this.unitCode = unitCode;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public SalesStatistics setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public SalesStatistics setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public SalesStatistics setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public SalesStatistics setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public int getSales() {
        return sales;
    }

    public SalesStatistics setSales(int sales) {
        this.sales = sales;
        return this;
    }
}

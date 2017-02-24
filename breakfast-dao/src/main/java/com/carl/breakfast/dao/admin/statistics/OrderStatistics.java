package com.carl.breakfast.dao.admin.statistics;

import com.carl.framework.core.entity.BaseEntity;


/**
 * 订单分析数据bean
 * @author Carl
 * @date 2017/1/10
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class OrderStatistics extends BaseEntity {
    private String orderId;
    //订单编号
    private String orderNo;
    //备注
    private String note;
    //楼层
    private String floorCode;
    //栋
    private String unitCode;
    private String floorName;
    //栋
    private String unitName;

    private String address;
    //商品信息
    private String goodsInfo;
    //是否加急
    private boolean isImpatient;
    //总价
    private float totalPrice;
    //联系人
    private String contactName;
    //联系电话
    private String contactPhone;

    public String getContactName() {
        return contactName;
    }

    public OrderStatistics setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public OrderStatistics setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatistics setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public OrderStatistics setFloorCode(String floorCode) {
        this.floorCode = floorCode;
        return this;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public OrderStatistics setUnitCode(String unitCode) {
        this.unitCode = unitCode;
        return this;
    }

    public String getFloorName() {
        return floorName;
    }

    public OrderStatistics setFloorName(String floorName) {
        this.floorName = floorName;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public OrderStatistics setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderStatistics setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public OrderStatistics setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
        return this;
    }

    public boolean isImpatient() {
        return isImpatient;
    }

    public OrderStatistics setImpatient(boolean impatient) {
        isImpatient = impatient;
        return this;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public OrderStatistics setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public OrderStatistics setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String getNote() {
        return note;
    }

    public OrderStatistics setNote(String note) {
        this.note = note;
        return this;
    }
}

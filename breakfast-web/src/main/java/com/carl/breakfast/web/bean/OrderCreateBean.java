package com.carl.breakfast.web.bean;

import com.carl.breakfast.dao.pojo.order.OrderGoodsItem;

import java.util.List;

/**
 * 订单创建时的bean
 * @author Carl
 * @date 2016/12/15
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class OrderCreateBean {
    //ID
    private String id;
    //USERNAME
    private String username;
    //CONTACT_NAME
    private String contactName;
    //CONTACT_NUMBER
    private String contactNumber;
    //PRICE
    private float price;
    //ADDRESS
    private String address;

    private List<OrderGoodsItem> items;
    //IS_IMPATIENT 是否加急
    private boolean impatient;

    public boolean isImpatient() {
        return impatient;
    }

    public OrderCreateBean setImpatient(boolean impatient) {
        this.impatient = impatient;
        return this;
    }

    public String getId() {
        return id;
    }

    public OrderCreateBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public OrderCreateBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public OrderCreateBean setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public OrderCreateBean setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public OrderCreateBean setPrice(float price) {
        this.price = price;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OrderCreateBean setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<OrderGoodsItem> getItems() {
        return items;
    }

    public OrderCreateBean setItems(List<OrderGoodsItem> items) {
        this.items = items;
        return this;
    }
}

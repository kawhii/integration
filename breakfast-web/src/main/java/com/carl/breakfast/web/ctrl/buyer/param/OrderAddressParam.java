package com.carl.breakfast.web.ctrl.buyer.param;

import java.io.Serializable;

/**
 * 地址
 * @author Carl
 * @date 2016/12/16
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class OrderAddressParam implements Serializable {
    private String addressDetail;

    public String getAddressDetail() {
        return addressDetail;
    }

    public OrderAddressParam setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
        return this;
    }
}

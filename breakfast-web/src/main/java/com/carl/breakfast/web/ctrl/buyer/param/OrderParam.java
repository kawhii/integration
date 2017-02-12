package com.carl.breakfast.web.ctrl.buyer.param;

import java.io.Serializable;
import java.util.List;

/**
 * 订单创建参数
 * @author Carl
 * @date 2016/12/14
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class OrderParam implements Serializable {
    private List<OrderGoodsParam> goods;
    private OrderAddressParam address;

    public List<OrderGoodsParam> getGoods() {
        return goods;
    }

    public OrderParam setGoods(List<OrderGoodsParam> goods) {
        this.goods = goods;
        return this;
    }

    public OrderAddressParam getAddress() {
        return address;
    }

    public OrderParam setAddress(OrderAddressParam address) {
        this.address = address;
        return this;
    }
}

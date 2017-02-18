package com.carl.breakfast.web.ctrl.buyer.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carl
 * @date 2017/2/7
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class OrderCreateParam implements Serializable {
    //地址编码
    private int addressId;
    private List<OrderGoodsParam> goods;
    //加急
    private boolean vexedly;
    //留言
    private String message;

    public boolean isVexedly() {
        return vexedly;
    }

    public OrderCreateParam setVexedly(boolean vexedly) {
        this.vexedly = vexedly;
        return this;
    }

    public int getAddressId() {
        return addressId;
    }

    public OrderCreateParam setAddressId(int addressId) {
        this.addressId = addressId;
        return this;
    }

    public List<OrderGoodsParam> getGoods() {
        return goods;
    }

    public OrderCreateParam setGoods(List<OrderGoodsParam> goods) {
        this.goods = goods;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public OrderCreateParam setMessage(String message) {
        this.message = message;
        return this;
    }

    public static class OrderGoodsParam implements Serializable {
        //商品id
        private int id;
        //数量
        private int qt;

        public int getId() {
            return id;
        }

        public OrderGoodsParam setId(int id) {
            this.id = id;
            return this;
        }

        public int getQt() {
            return qt;
        }

        public OrderGoodsParam setQt(int qt) {
            this.qt = qt;
            return this;
        }
    }

    /**
     * 获取所有商品的id
     * @return
     */
    public Integer[] getGoodsIds() {
        List<Integer> id = new ArrayList<>(goods.size());
        for (OrderGoodsParam param : goods) {
            id.add(param.id);
        }
        return id.toArray(new Integer[]{});
    }
}

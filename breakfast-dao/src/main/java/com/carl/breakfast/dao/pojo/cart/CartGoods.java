package com.carl.breakfast.dao.pojo.cart;

import com.carl.framework.core.execption.BizException;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 购物车的商品
 *
 * @author Carl
 * @date 2016/12/10
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class CartGoods {
    @NotNull
    private int goodsId;
    @NotNull
    @Min(0)
    private int quantity;

    public int getGoodsId() {
        return goodsId;
    }

    public CartGoods setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartGoods setQuantity(int quantity) {
        if (quantity < 0) {
            throw new BizException("商品数不能小于0");
        }
        this.quantity = quantity;
        return this;
    }

    public CartGoods(int goodsId, int quantity) {
        setGoodsId(goodsId);
        setQuantity(quantity);
    }

    public CartGoods() {
    }

    @Override
    public int hashCode() {
        return goodsId;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CartGoods && ((CartGoods) obj).getGoodsId() == getGoodsId();
    }
}

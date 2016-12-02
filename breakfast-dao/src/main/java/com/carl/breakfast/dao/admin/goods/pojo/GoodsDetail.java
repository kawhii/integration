package com.carl.breakfast.dao.admin.goods.pojo;

import java.util.List;

/**
 * 商品详细信息
 *
 * @author Carl
 * @date 2016/12/2
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public class GoodsDetail {
    //商品原来信息
    private GoodsPojo goods;
    //商品扩展信息
    private List<GoodsExt> goodsExtList;

    public GoodsPojo getGoods() {
        return goods;
    }

    public GoodsDetail setGoods(GoodsPojo goods) {
        this.goods = goods;
        return this;
    }

    public List<GoodsExt> getGoodsExtList() {
        return goodsExtList;
    }

    public GoodsDetail setGoodsExtList(List<GoodsExt> goodsExtList) {
        this.goodsExtList = goodsExtList;
        return this;
    }
}

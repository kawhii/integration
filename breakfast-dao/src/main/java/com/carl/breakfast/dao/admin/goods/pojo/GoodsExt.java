package com.carl.breakfast.dao.admin.goods.pojo;

/**
 * 商品扩展表信息
 * @author Carl
 * @date 2016/12/2
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public class GoodsExt {
    //ID
    private int id;
    //GOODS_ID
    private int goodsId;
    //KEY_NAME
    private String keyName;
    //KEY_AS
    private String keyAs;
    //VAL
    private String val;

    public int getId() {
        return id;
    }

    public GoodsExt setId(int id) {
        this.id = id;
        return this;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public GoodsExt setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getKeyName() {
        return keyName;
    }

    public GoodsExt setKeyName(String keyName) {
        this.keyName = keyName;
        return this;
    }

    public String getKeyAs() {
        return keyAs;
    }

    public GoodsExt setKeyAs(String keyAs) {
        this.keyAs = keyAs;
        return this;
    }

    public String getVal() {
        return val;
    }

    public GoodsExt setVal(String val) {
        this.val = val;
        return this;
    }
}

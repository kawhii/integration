package com.carl.breakfast.web.ctrl.admin;


/**
 * 前端接收参数
 * @author Carl
 * @date 2016/12/1
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public class GoodsModel {
    private String name;
    private String title;
    private String subTitle;
    private String createUser;
    //库存
    private int stock;
    private float price;
    //商家推荐
    private boolean recommend;
    //主页图片
    private int mainImgId;
    //图片路径
    private String mainImgPath;
    //备注
    private String note;

    private GoodsDetail goodsDetail;

    public String getCreateUser() {
        return createUser;
    }

    public GoodsModel setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GoodsModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public GoodsModel setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public GoodsModel setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public GoodsModel setPrice(float price) {
        this.price = price;
        return this;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public GoodsModel setRecommend(boolean recommend) {
        this.recommend = recommend;
        return this;
    }

    public int getMainImgId() {
        return mainImgId;
    }

    public GoodsModel setMainImgId(int mainImgId) {
        this.mainImgId = mainImgId;
        return this;
    }

    public String getMainImgPath() {
        return mainImgPath;
    }

    public GoodsModel setMainImgPath(String mainImgPath) {
        this.mainImgPath = mainImgPath;
        return this;
    }

    public String getNote() {
        return note;
    }

    public GoodsModel setNote(String note) {
        this.note = note;
        return this;
    }

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }

    public GoodsModel setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
        return this;
    }
}

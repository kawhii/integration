package com.carl.breakfast.dao.admin.goods.pojo;

import com.carl.framework.core.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 商品信息
 * @author Carl
 * @date 2016/11/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class GoodsPojo extends BaseEntity {
    private int id;
    private String name;
    private String title;
    private String subTitle;
    private int status;
    //热销级别
    private int hotRank;
    //库存
    private int stock;
    //销售量
    private int sales;
    //上架时间
    private Date onSaleTime;
    private String createUser;
    private float price;
    //商家推荐
    private boolean recommend;
    //商品类型
    private int goodsType;
    //主页图片
    private int mainImgId;
    //图片路径
    private String mainImgPath;
    //备注
    private String note;
    //使用时间
    private Date useDate;

    public int getId() {
        return id;
    }

    public GoodsPojo setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoodsPojo setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GoodsPojo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public GoodsPojo setSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public GoodsPojo setStatus(int status) {
        this.status = status;
        return this;
    }

    public int getHotRank() {
        return hotRank;
    }

    public GoodsPojo setHotRank(int hotRank) {
        this.hotRank = hotRank;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public GoodsPojo setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public int getSales() {
        return sales;
    }

    public GoodsPojo setSales(int sales) {
        this.sales = sales;
        return this;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getOnSaleTime() {
        return onSaleTime;
    }

    public GoodsPojo setOnSaleTime(Date onSaleTime) {
        this.onSaleTime = onSaleTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public GoodsPojo setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public GoodsPojo setPrice(float price) {
        this.price = price;
        return this;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public GoodsPojo setRecommend(boolean recommend) {
        this.recommend = recommend;
        return this;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public GoodsPojo setGoodsType(int goodsType) {
        this.goodsType = goodsType;
        return this;
    }

    public int getMainImgId() {
        return mainImgId;
    }

    public GoodsPojo setMainImgId(int mainImgId) {
        this.mainImgId = mainImgId;
        return this;
    }

    public String getMainImgPath() {
        return mainImgPath;
    }

    public GoodsPojo setMainImgPath(String mainImgPath) {
        this.mainImgPath = mainImgPath;
        return this;
    }

    public String getNote() {
        return note;
    }

    public GoodsPojo setNote(String note) {
        this.note = note;
        return this;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUseDate() {
        return useDate;
    }

    public GoodsPojo setUseDate(Date useDate) {
        this.useDate = useDate;
        return this;
    }
}

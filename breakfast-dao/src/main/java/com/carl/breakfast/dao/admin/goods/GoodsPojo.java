package com.carl.breakfast.dao.admin.goods;

import java.util.Date;

/**
 * 商品信息
 * @author Carl
 * @date 2016/11/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class GoodsPojo {
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

}

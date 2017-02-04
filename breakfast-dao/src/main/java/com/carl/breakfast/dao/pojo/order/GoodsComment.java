package com.carl.breakfast.dao.pojo.order;

import com.carl.framework.core.entity.BaseEntity;

/**
 * @author Carl
 * @date 2017/2/4
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public class GoodsComment extends BaseEntity {
    //ID
    private int id;
    //GOODS_ID
    private int goodsId;
    //ORDER_ID
    private String orderId;
    //USERNAME
    private String username;
    //GRADE,分数
    private int grade;
    //CONTENT,评论内容
    private String content;

    public int getId() {
        return id;
    }

    public GoodsComment setId(int id) {
        this.id = id;
        return this;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public GoodsComment setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public GoodsComment setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public GoodsComment setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public GoodsComment setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public String getContent() {
        return content;
    }

    public GoodsComment setContent(String content) {
        this.content = content;
        return this;
    }
}

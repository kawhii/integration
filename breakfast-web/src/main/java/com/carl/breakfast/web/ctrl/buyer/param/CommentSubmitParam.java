package com.carl.breakfast.web.ctrl.buyer.param;

import java.io.Serializable;

/**
 * 评论提交
 * @author Carl
 * @date 2017/2/12
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class CommentSubmitParam implements Serializable {
    private String orderId;
    private int goodsId;
    //评论内容
    private String content;
    //分数
    private int grade;

    public String getOrderId() {
        return orderId;
    }

    public CommentSubmitParam setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public CommentSubmitParam setGoodsId(int goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentSubmitParam setContent(String content) {
        this.content = content;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public CommentSubmitParam setGrade(int grade) {
        this.grade = grade;
        return this;
    }
}

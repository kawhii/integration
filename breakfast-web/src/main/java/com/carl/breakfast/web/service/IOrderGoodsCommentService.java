package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.pojo.order.GoodsComment;

/**
 * @author Carl
 * @date 2017/2/13
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public interface IOrderGoodsCommentService {
    /**
     * 保存评论
     *
     * @param comment
     * @return
     */
    boolean saveComment(GoodsComment comment);
}
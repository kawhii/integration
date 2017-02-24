package com.carl.breakfast.dao.order;

import com.carl.breakfast.dao.pojo.order.GoodsComment;
import com.carl.framework.core.dao.BaseDao;

import java.util.Map;

/**
 * 评论操作数据源
 *
 * @author Carl
 * @date 2017/2/11
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface IGoodsCommentDao extends BaseDao<GoodsComment> {
    /**
     * 计算分数
     * @param param
     * @return
     */
    int updateCommentGrade(Map<String, Object> param);
}

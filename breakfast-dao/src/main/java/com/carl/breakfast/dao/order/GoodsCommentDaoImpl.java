package com.carl.breakfast.dao.order;

import com.carl.breakfast.dao.pojo.order.GoodsComment;
import com.carl.framework.core.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * 商品数据源操作
 *
 * @author Carl
 * @date 2017/2/11
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Repository("goodsCommentDao")
public class GoodsCommentDaoImpl extends BaseDaoImpl<GoodsComment> implements IGoodsCommentDao {
}

package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.order.IGoodsCommentDao;
import com.carl.breakfast.dao.order.IOrderItemDao;
import com.carl.breakfast.dao.pojo.order.GoodsComment;
import com.carl.breakfast.web.service.IOrderGoodsCommentService;
import com.carl.breakfast.web.service.IOrderService;
import com.carl.framework.core.execption.BizException;
import com.carl.framework.util.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Carl
 * @date 2017/2/13
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.广州市森锐科技股份有限公司
 */
@Service("orderGoodsCommentService")
@Transactional
public class OrderGoodsCommentServiceImpl implements IOrderGoodsCommentService {
    @Autowired
    private IGoodsCommentDao goodsCommentDao;
    @Autowired
    private IOrderItemDao orderItemDao;
    @Autowired
    private IOrderService orderService;

    @Override
    public boolean saveComment(GoodsComment comment) {
        int count = goodsCommentDao.insert(comment);
        if (count != 1)
            return false;
        Object res = orderService.findByIdAndOthers(comment.getOrderId(), MapBuilder.<String, Object>build().p("username", comment.getUsername()));
        if (res == null)
            throw new BizException("请求错误，数据不是该用户的");
        int updated = orderItemDao.update(MapBuilder.<String, Object>build().p("orderId", comment.getOrderId()).p("goodsId", comment.getGoodsId()));
        if(updated != 1) {
            throw new BizException("请求错误，没有数据需要更新");
        }
        return true;
    }
}

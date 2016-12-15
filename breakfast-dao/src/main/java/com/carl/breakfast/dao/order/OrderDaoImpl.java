package com.carl.breakfast.dao.order;

import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.framework.core.dao.BaseDaoImpl;
import com.carl.framework.core.execption.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单数据源实现
 *
 * @author Carl
 * @date 2016/12/15
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@Repository
public class OrderDaoImpl extends BaseDaoImpl<OrderPojo> implements IOrderDao {
    @Autowired
    private IOrderItemDao orderItemDao;

    /**
     * 单条插入数据.
     */
    @Transactional
    public int insert(OrderPojo entity) {
        int result = getSessionTemplate().insert(getStatement(SQL_INSERT), entity);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
        }
        //插入订单条目
        orderItemDao.insert(entity.getItems());
        return result;
    }
}
package com.carl.breakfast.dao.order;

import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.framework.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 订单操作
 *
 * @author Carl
 * @date 2016/12/15
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public interface IOrderDao extends BaseDao<OrderPojo> {
    /**
     * 查询由开始日期到结束日期的交易数量
     *
     * @param startDate
     * @param endDate
     * @return
     */
    List<Map<String, Object>> exchangeSuccess(String startDate, String endDate);

    /**
     * 根据id以及用户名移除订单
     * @param id
     * @param username
     * @return
     */
    int removeOrder(String id, String username);
}

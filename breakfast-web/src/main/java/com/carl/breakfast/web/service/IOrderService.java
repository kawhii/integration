package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.order.IOrderDao;
import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.breakfast.web.bean.OrderCreateBean;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;

import java.util.Map;

/**
 * 订单服务
 *
 * @author Carl
 * @date 2016/12/15
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
public interface IOrderService extends IService<IOrderDao> {
    /**
     * 创建订单
     * @param createBean
     * @return
     */
    OrderPojo createOrder(OrderCreateBean createBean);


    /**
     * 根据用户名查询订单，按创建时间倒序
     * @param username
     * @param pageParam
     * @return
     */
    PageBean<OrderPojo> queryOrderByUsername(String username, PageParam pageParam);

    /**
     * 根据id以及用户名移除订单
     * @param id
     * @param username
     * @return
     */
    boolean removeOrder(String id, String username);

    /**
     * 根据id查找
     * @param id
     * @param params 其他参数
     * @return
     */
    OrderPojo findByIdAndOthers(String id, Map<String, Object> params);

    /**
     * 更新订单
     * @param params
     * @return
     */
    int updateOrder(Map<String, Object> params);
}

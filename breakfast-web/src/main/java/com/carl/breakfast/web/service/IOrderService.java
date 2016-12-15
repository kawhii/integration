package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.order.IOrderDao;
import com.carl.breakfast.web.bean.OrderCreateBean;

/**
 * 订单服务
 *
 * @author Carl
 * @date 2016/12/15
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public interface IOrderService extends IService<IOrderDao> {
    /**
     * 创建订单
     * @param createBean
     * @return
     */
    OrderCreateBean createOrder(OrderCreateBean createBean);
}

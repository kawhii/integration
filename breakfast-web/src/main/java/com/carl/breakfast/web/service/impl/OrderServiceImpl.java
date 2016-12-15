package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.order.IOrderDao;
import com.carl.breakfast.dao.pojo.order.OrderGoodsItem;
import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.breakfast.web.bean.OrderCreateBean;
import com.carl.breakfast.web.service.IOrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carl
 * @date 2016/12/15
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2016.卡尔工作室
 */
@Service
public class OrderServiceImpl implements IOrderService {
    protected static final Log LOG = LogFactory.getLog(OrderServiceImpl.class);
    @Autowired
    private IOrderDao orderDao;

    @Override
    public IOrderDao getDao() {
        return orderDao;
    }

    @Override
    public OrderCreateBean createOrder(OrderCreateBean createBean) {
        OrderPojo orderPojo = new OrderPojo();
        float price = getTotalPrice(createBean);
        orderPojo.setAddress(createBean.getAddress())
                .setItems(createBean.getItems())
                .setContactName(createBean.getContactName())
                .setContactNumber(createBean.getContactNumber())
                .setUsername(createBean.getUsername())
                .setPrice(price);
        LOG.debug("准备创建订单，user:[" + createBean.getUsername() +"]，总价:[" + price + "]");
        getDao().insert(orderPojo);
        createBean.setId(orderPojo.getId());
        LOG.debug("创建订单成功，user:[" + createBean.getUsername() +"]，id:[" + orderPojo.getId() + "]");
        return createBean;
    }

    //获取订单总价
    private float getTotalPrice(OrderCreateBean createBean) {
        float price = 0f;
        for(OrderGoodsItem item : createBean.getItems()) {
            price += item.getTotalPrice();
        }
        return price;
    }
}

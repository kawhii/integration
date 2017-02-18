package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.order.IOrderDao;
import com.carl.breakfast.dao.pojo.order.OrderGoodsItem;
import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.breakfast.web.bean.OrderCreateBean;
import com.carl.breakfast.web.service.IOrderIdGenerator;
import com.carl.breakfast.web.service.IOrderService;
import com.carl.framework.core.page.PageBean;
import com.carl.framework.core.page.PageParam;
import com.carl.framework.util.MapBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


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

    @Autowired
    private IOrderIdGenerator idGenerator;

    @Override
    public OrderCreateBean createOrder(OrderCreateBean createBean) {
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setOrderNo(idGenerator.create());
        float price = getTotalPrice(createBean);
        orderPojo.setAddress(createBean.getAddress())
                .setItems(createBean.getItems())
                .setContactName(createBean.getContactName())
                .setContactNumber(createBean.getContactNumber())
                .setUsername(createBean.getUsername())
                .setPrice(price)
                .setMessage(createBean.getMessage())
                .setImpatient(createBean.isImpatient());
        LOG.debug("准备创建订单，user:[" + createBean.getUsername() + "]，总价:[" + price + "]");
        getDao().insert(orderPojo);
        createBean.setId(orderPojo.getId());
        LOG.debug("创建订单成功，user:[" + createBean.getUsername() + "]，id:[" + orderPojo.getId() + "]");
        return createBean;
    }

    //获取订单总价
    private float getTotalPrice(OrderCreateBean createBean) {
        float price = 0f;
        for (OrderGoodsItem item : createBean.getItems()) {
            price += item.getTotalPrice();
        }
        return price;
    }

    @Override
    public PageBean<OrderPojo> queryOrderByUsername(String username, PageParam pageParam) {
        return getDao().listPage(pageParam, MapBuilder.<String, Object>build().p("username", username));
    }

    @Override
    public boolean removeOrder(String id, String username) {
        return getDao().removeOrder(id, username) == 1;
    }

    @Override
    public OrderPojo findByIdAndOthers(String id, Map<String, Object> params){
        return getDao().getBy(MapBuilder.<String, Object>build().p("orderId", id).pAll(params));
    }
}

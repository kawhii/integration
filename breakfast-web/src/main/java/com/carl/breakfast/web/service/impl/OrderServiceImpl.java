package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.order.IOrderDao;
import com.carl.breakfast.dao.pojo.order.OrderGoodsItem;
import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.breakfast.web.bean.AddressDetailBean;
import com.carl.breakfast.web.bean.OrderCreateBean;
import com.carl.breakfast.web.service.IAddressService;
import com.carl.breakfast.web.service.ICommonAddressService;
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
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICommonAddressService commonAddressService;

    @Override
    public IOrderDao getDao() {
        return orderDao;
    }

    @Autowired
    private IOrderIdGenerator idGenerator;

    @Override
    public OrderPojo createOrder(OrderCreateBean createBean) {
        OrderPojo orderPojo = new OrderPojo();
        orderPojo.setOrderNo(idGenerator.create());
        float price = getTotalPrice(createBean);
        //查询地址
        AddressDetailBean addressDetailBean = addressService.queryAddressById(createBean.getAddressId());
        if (addressDetailBean != null) {
            try {
                orderPojo.setAddCode1(addressDetailBean.getBuild().getVal())
                        .setAddCode2(addressDetailBean.getFlow().getVal())
                        .setAddName1(commonAddressService.findById(addressDetailBean.getBuild().getVal()).getInfo())
                        .setAddName2(commonAddressService.findById(addressDetailBean.getFlow().getVal()).getInfo());
            } catch (Exception e) {
                LOG.warn("创建订单设置地址异常");
                LOG.warn(e);
            }
        }
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
        return orderPojo;
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
    public OrderPojo findByIdAndOthers(String id, Map<String, Object> params) {
        return getDao().getBy(MapBuilder.<String, Object>build().p("orderId", id).pAll(params));
    }

    @Override
    public int updateOrder(Map<String, Object> params) {
        params.put("payState", 0);
        return getDao().updateStatePay(params);
    }
}

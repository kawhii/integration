package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.order.IOrderDao;
import com.carl.breakfast.dao.sys.BaseTest;
import com.carl.breakfast.web.service.IOrderService;
import com.carl.framework.core.page.PageParam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/9.
 */
public class OrderServiceImplTest extends BaseTest {
    @Autowired
    private IOrderService orderService;

    @Test
    public void queryOrderByUsername() throws Exception {
        PageParam pageParam = new PageParam(1, 15);
        Object obj = orderService.queryOrderByUsername("admin", pageParam);
        System.out.println(obj);
    }

}
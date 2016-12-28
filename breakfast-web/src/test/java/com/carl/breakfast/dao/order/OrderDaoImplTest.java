package com.carl.breakfast.dao.order;

import com.carl.breakfast.dao.sys.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/24.
 */
public class OrderDaoImplTest extends BaseTest {
    @Autowired
    private IOrderDao orderDao;

    @Test
    public void exchangeSuccess() throws Exception {
        List<Map<String, Object>> res = orderDao.exchangeSuccess(null, null);
        System.out.println(res);
    }

}
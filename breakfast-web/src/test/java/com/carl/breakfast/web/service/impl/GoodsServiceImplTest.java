package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.admin.goods.pojo.GoodsDetail;
import com.carl.breakfast.dao.sys.BaseTest;
import com.carl.breakfast.web.service.IGoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Create by Administrator on 2016/12/2.
 */
public class GoodsServiceImplTest extends BaseTest {
    @Autowired()
    private IGoodsService goodsService;

    @Test
    public void queryDetailById() throws Exception {
        GoodsDetail gd = goodsService.queryDetailById(1);
        System.out.println(gd);
    }

}
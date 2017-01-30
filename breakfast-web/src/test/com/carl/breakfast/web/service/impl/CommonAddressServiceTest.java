package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.sys.BaseTest;
import com.carl.breakfast.web.service.ICommonAddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Create by Administrator on 2017/1/30.
 */
public class CommonAddressServiceTest extends BaseTest {
    @Autowired
    private ICommonAddressService commonAddressService;
    @Test
    public void listByType() throws Exception {
        Object res = commonAddressService.listByType(ICommonAddressService.Type.FLOW);
        System.out.println(res);
    }

}
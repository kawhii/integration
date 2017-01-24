package com.carl.breakfast.web.utils;

import com.carl.breakfast.dao.sys.BaseTest;
import com.carl.breakfast.web.service.IGoodsService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Create by Carl on 2017/1/24.
 */
public class BkPasswordUtilTest extends BaseTest {
    @Autowired
    private BkPasswordUtil passwordUtil;
    @Test
    public void encodePassword() throws Exception {
        String eRes = "8f1b1c6f06a2fa2f9d44f17e16cda261";
        String salt = "carls";
        String res = passwordUtil.encodePassword("123456", salt);
        Assert.assertEquals(eRes, res);
    }

}
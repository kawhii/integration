package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.sys.BaseTest;
import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.service.IGoodsService;
import com.carl.breakfast.web.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/22.
 */
public class UserServiceImplTest extends BaseTest {
    @Autowired()
    private IUserService userService;

    @Test
    public void findByUsername() throws Exception {
        UserInfo userInfo = userService.findByUsername("carl");
        Assert.assertNotNull(userInfo);
        System.out.println(userInfo.getName() + ",salt:" + userInfo.getPasswordSalt());

        UserInfo nullUser = userService.findByUsername("Abc-carl1");
        Assert.assertNull(nullUser);
    }
}
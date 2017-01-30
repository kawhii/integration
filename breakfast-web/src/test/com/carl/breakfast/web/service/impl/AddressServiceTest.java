package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.pojo.user.SendAddress;
import com.carl.breakfast.dao.sys.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by Administrator on 2017/1/30.
 */
public class AddressServiceTest extends BaseTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void addAddress() throws Exception {
        SendAddress address = new SendAddress();
        address.setUsername("admin");
        address.setContactsName("我是联系人");
        address.setDetail("详细地址1");
        address.setDefault(true);
        address.setContactsPhone("13712312312");
        addressService.addAddress(address);
    }

    @Test
    public void setDefaultAddress() throws Exception {
        addressService.setDefaultAddress("admin", 2);
    }

    @Test
    public void queryAddressByUsername() throws Exception {
        List<SendAddress> addresses = addressService.queryAddressByUsername("admin");
        System.out.println(addresses);
    }

}
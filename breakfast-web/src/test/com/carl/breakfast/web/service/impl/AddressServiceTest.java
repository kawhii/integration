package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.pojo.user.AddressExt;
import com.carl.breakfast.dao.pojo.user.SendAddress;
import com.carl.breakfast.dao.sys.BaseTest;
import com.carl.breakfast.web.bean.AddressDetailBean;
import com.carl.breakfast.web.service.IAddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Create by Administrator on 2017/1/30.
 */
public class AddressServiceTest extends BaseTest {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addAddress() throws Exception {
        AddressDetailBean address = new AddressDetailBean();
        address.setUsername("admin");
        address.setContactsName("我是联系人");
        address.setDetailAddress("详细地址1");
        address.setDefault(true);
        address.setContactsPhone("13712312312");
        address.setSchool(new AddressExt().setKeyAs("school").setKeyName("学校").setVal("广州大学"));
        address.setFlow(new AddressExt().setKeyAs("flow").setKeyName("楼层").setVal("flow2"));
        address.setBuild(new AddressExt().setKeyAs("build").setKeyName("楼栋").setVal("jy2d"));
        address.setHouseNumber(new AddressExt().setKeyAs("houseNum").setKeyName("门牌号").setVal("606"));
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
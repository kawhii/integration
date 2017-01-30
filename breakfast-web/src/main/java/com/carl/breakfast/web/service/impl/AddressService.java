package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.pojo.user.SendAddress;
import com.carl.breakfast.dao.user.ISendAddressDao;
import com.carl.breakfast.web.service.IAddressService;
import com.carl.framework.util.MapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地址服务类
 *
 * @author Carl
 * @date 2017/1/30
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
@Service
public class AddressService implements IAddressService {
    @Autowired
    private ISendAddressDao addressDao;

    @Override
    public SendAddress addAddress(SendAddress address) {
        addressDao.insert(address);
        return address;
    }

    @Override
    public void setDefaultAddress(String username, int id) {
        addressDao.setDefault(username, id);
    }

    @Override
    public List<SendAddress> queryAddressByUsername(String username) {
        return addressDao.listBy(MapBuilder.<String, Object>build().p("username", username));
    }

    @Override
    public boolean removeAddressById(int id) {
        return 1 == addressDao.delete(id + "");
    }
}

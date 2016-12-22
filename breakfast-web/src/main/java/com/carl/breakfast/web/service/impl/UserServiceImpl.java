package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.sys.UserDao;
import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carl
 * @date 2016/12/22
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userDao.getById(username);
    }
}

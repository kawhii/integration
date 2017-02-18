package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.sys.UserDao;
import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.service.IUserService;
import com.carl.breakfast.web.service.UsesModifyFlag;
import com.carl.breakfast.web.utils.BkPasswordUtil;
import com.carl.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
    @Autowired
    @Qualifier("passwordUtil")
    private BkPasswordUtil passwordUtil;

    @Value("${wx.salt}")
    private String salt;
    //默认密码
    @Value("${wx.password}")
    private String password;

    @Override
    public UserInfo findByUsername(String username) {
        return userDao.getById(username);
    }

    @Override
    public UsesModifyFlag modifyPassword(String username, String oldPwd, String newPwd) {
        UserInfo userInfo = userDao.getById(username);
        if (userInfo == null)
            return UsesModifyFlag.NO_USER;
        String salt = userInfo.getPasswordSalt();
        String targetOldPwd = passwordUtil.encodePassword(oldPwd, salt);
        String targetNewPwd = passwordUtil.encodePassword(newPwd, salt);
        if (!targetOldPwd.equals(userInfo.getPassword()))
            return UsesModifyFlag.PASSWORD_ERROR;

        //数据源修改密码
        int res = userDao.modifyPassword(username, targetOldPwd, targetNewPwd);
        return res == 1 ? UsesModifyFlag.SUCCESS : UsesModifyFlag.RESULT_ERROR;
    }

    @Override
    public void registerOpenId(UserInfo userInfo) {
        if (!StringUtil.isNull(userInfo.getPassword())) {
            userInfo.setPassword(passwordUtil.encodePassword(userInfo.getPassword(), userInfo.getPasswordSalt()));
        } else {
            userInfo.setPassword(passwordUtil.encodePassword(password, salt)).setPasswordSalt(salt);
        }
        userInfo.setName(passwordUtil.encodePassword(userInfo.getUsername(), salt).substring(0, 6));
        userDao.insert(userInfo);
    }
}

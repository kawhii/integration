package com.carl.breakfast.dao.sys;

import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.framework.core.dao.BaseDao;

/**
 * 用户查询
 *
 * @author Carl
 * @date 2016/12/22
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface UserDao extends BaseDao<UserInfo> {
    /**
     * 修改用户密码
     *
     * @param username 用户名
     * @param oldPwd   旧密码
     * @param newPwd   新密码
     * @return
     */
    int modifyPassword(String username, String oldPwd, String newPwd);
}

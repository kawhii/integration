package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.sys.pojo.UserInfo;

/**
 * 用户服务
 *
 * @author Carl
 * @date 2016/12/22
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface IUserService {
    /**
     * 根据用户名查找唯一的用户数据
     *
     * @param username
     * @return
     */
    UserInfo findByUsername(String username);

    /**
     * 修改密码
     * @param username  用户名
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return
     */
    UsesModifyFlag modifyPassword(String username, String oldPwd, String newPwd);
}

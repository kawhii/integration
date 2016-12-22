package com.carl.breakfast.web.utils;

import com.carl.breakfast.dao.sys.pojo.UserInfo;
import com.carl.breakfast.web.filter.UserInfoAuthenticationFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;


/**
 * 用户工具
 *
 * @author Carl
 * @date 2016/12/22
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public abstract class UserUtils {
    /**
     * 获取当前用户信息
     * @return
     * @throws AuthenticationException
     */
    public static UserInfo currUser() throws AuthenticationException {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            UserInfo userInfo = (UserInfo) subject.getSession().getAttribute(UserInfoAuthenticationFilter.USER_INFO_ATTR_KEY);
            return userInfo;
        }
        throw new AuthenticationException("当前用户未认证");
    }
}

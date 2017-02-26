package com.carl.breakfast.web.filter;

import com.carl.breakfast.web.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 把用户信息设到session中
 *
 * @author Carl
 * @date 2016/12/22
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class UserInfoAuthenticationFilter extends FormAuthenticationFilter {
    //当前用户的用户信息
    public static final String USER_INFO_ATTR_KEY = "UserInfo";
    @Autowired
    private IUserService userService;

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String username = (String)subject.getPrincipal();
        subject.getSession().setAttribute(USER_INFO_ATTR_KEY, userService.findByUsername(username));
        return super.onLoginSuccess(token, subject, request, response);
    }
}

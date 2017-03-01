package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.web.service.IUserService;
import com.carl.framework.core.third.wx.auth.IWXAuthService;
import com.carl.framework.core.third.wx.auth.WXAuthenticationToken;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carl
 * @date 2017/3/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.广州市森锐科技股份有限公司
 */
@Service("bkWXAuthService")
public class BKWXAuthService implements IWXAuthService {
    @Autowired
    private IUserService userService;

    @Override
    public void doAuth(WXAuthenticationToken token) throws AuthenticationException {
        Object user = userService.findByUsername(token.getOpenId());
        if (user == null) {
            throw new AuthenticationException(String.format("微信【%s】不存在", token.getOpenId()));
        }
    }
}

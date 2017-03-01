package com.carl.framework.core.third.wx.auth;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class WXAuthorizingRealm extends JdbcRealm implements InitializingBean {
    private IWXAuthService iwxAuthService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        WXAuthenticationToken wxAuthenticationToken = (WXAuthenticationToken) token;
        iwxAuthService.doAuth(wxAuthenticationToken);
        return new WXAuthenticationInfo(wxAuthenticationToken);
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token != null && WXAuthenticationToken.class.isAssignableFrom(token.getClass());
    }

    public IWXAuthService getIwxAuthService() {
        return iwxAuthService;
    }

    public WXAuthorizingRealm setIwxAuthService(IWXAuthService iwxAuthService) {
        this.iwxAuthService = iwxAuthService;
        return this;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(iwxAuthService == null) {
            throw new IllegalStateException("iwxAuthService需要配置");
        }
    }
}

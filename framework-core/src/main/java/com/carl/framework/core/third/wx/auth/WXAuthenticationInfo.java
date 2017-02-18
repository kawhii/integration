package com.carl.framework.core.third.wx.auth;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class WXAuthenticationInfo implements AuthenticationInfo {
    private WXAuthenticationToken wxAuthenticationToken;

    public WXAuthenticationInfo(WXAuthenticationToken wxAuthenticationToken) {
        this.wxAuthenticationToken = wxAuthenticationToken;
    }

    @Override
    public PrincipalCollection getPrincipals() {
        return new SimplePrincipalCollection(wxAuthenticationToken, "wx");
    }

    @Override
    public Object getCredentials() {
        return wxAuthenticationToken;
    }

    public String getOpenId() {
        return wxAuthenticationToken.getOpenId();
    }
}

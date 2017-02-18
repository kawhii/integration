package com.carl.framework.core.third.wx.auth;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class WXCredentialsMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        if (token instanceof WXAuthenticationToken && info instanceof WXAuthenticationInfo) {
            return ((WXAuthenticationToken) token).getOpenId().equals(((WXAuthenticationInfo) info).getOpenId());
        }
        return false;
    }
}

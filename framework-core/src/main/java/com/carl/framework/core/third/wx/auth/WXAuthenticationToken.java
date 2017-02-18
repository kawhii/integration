package com.carl.framework.core.third.wx.auth;

import com.carl.framework.core.third.wx.token.AccessTokenResult;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 微信认证
 *
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class WXAuthenticationToken implements AuthenticationToken {
    private AccessTokenResult accessTokenResult;

    public WXAuthenticationToken(AccessTokenResult accessTokenResult) {
        this.accessTokenResult = accessTokenResult;
    }

    @Override
    public Object getPrincipal() {
        return accessTokenResult.getOpenid();
    }

    @Override
    public Object getCredentials() {
        return accessTokenResult;
    }

    public String getOpenId() {
        return accessTokenResult.getOpenid();
    }

}

package com.carl.framework.core.third.wx.auth;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 微信认证
 *
 * @author Carl
 * @date 2017/3/1
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.广州市森锐科技股份有限公司
 */
public interface IWXAuthService {
    /**
     * 认证微信，不存在抛出异常
     * @param token
     * @throws AuthenticationException
     */
    void doAuth(WXAuthenticationToken token) throws AuthenticationException;
}

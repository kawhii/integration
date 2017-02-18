package com.carl.framework.core.third.wx.token;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface ITokenProvider {

    /**
     * 当前token
     * @return
     */
    AccessTokenResult token();

    /**
     * 刷新token
     * @throws TokenRefreshException
     */
    void refresh() throws TokenRefreshException;

    /**
     * 是否已过期
     * @return
     */
    boolean isExpires();
}

package com.carl.framework.core.third.wx.pay.js;


/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface IJSTicketProvider {
    /**
     * 当前token
     * @return
     */
    JSTicketResult ticket();

    /**
     * 刷新ticket
     * @throws TicketRefreshException
     */
    void refresh(String accessToken) throws TicketRefreshException;

    /**
     * 是否已过期
     * @return
     */
    boolean isExpires();
}

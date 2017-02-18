package com.carl.framework.core.third.wx.pay.js;

import com.alibaba.fastjson.annotation.JSONField;
import com.carl.framework.core.third.wx.token.BaseResult;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class JSTicketResult extends BaseResult {
    private String ticket;

    @JSONField(name = "expires_in")
    private String expiresIn;

    public String getTicket() {
        return ticket;
    }

    public JSTicketResult setTicket(String ticket) {
        this.ticket = ticket;
        return this;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public JSTicketResult setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
}

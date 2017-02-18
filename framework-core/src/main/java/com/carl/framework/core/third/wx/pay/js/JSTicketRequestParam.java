package com.carl.framework.core.third.wx.pay.js;

import com.carl.framework.core.pay.AbsRequestParam;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class JSTicketRequestParam extends AbsRequestParam {
    public static final String URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
    private String accessToken;

    {
        setUrl(URL);
    }

    public JSTicketRequestParam(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String getUrl() {
        return new StringBuilder(super.getUrl())
                .append("?access_token=")
                .append(getAccessToken())
                .append("&type=jsapi").toString();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public JSTicketRequestParam setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }
}
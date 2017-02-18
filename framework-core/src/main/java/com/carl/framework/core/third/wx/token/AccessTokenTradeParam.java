package com.carl.framework.core.third.wx.token;

import com.carl.framework.core.pay.AbsRequestParam;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class AccessTokenTradeParam extends AbsRequestParam {
    public static final String URL = "https://api.weixin.qq.com/cgi-bin/token";
    private String appid;
    //秘钥
    private String secret;

    {
        setUrl(URL);
    }

    public AccessTokenTradeParam(String appid, String secret) {
        this.appid = appid;
        this.secret = secret;
    }

    @Override
    public String getUrl() {
        return new StringBuilder(super.getUrl())
                .append("?appid=")
                .append(getAppid())
                .append("&secret=")
                .append(getSecret())
                .append("&grant_type=client_credential").toString();
    }

    public String getAppid() {
        return appid;
    }

    public AccessTokenTradeParam setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public AccessTokenTradeParam setSecret(String secret) {
        this.secret = secret;
        return this;
    }
}
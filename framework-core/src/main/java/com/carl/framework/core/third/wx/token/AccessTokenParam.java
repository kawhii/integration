package com.carl.framework.core.third.wx.token;

import com.carl.framework.core.pay.AbsRequestParam;

/**
 * 获取appid的请求
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class AccessTokenParam extends AbsRequestParam {
    public static final String URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private String appid;
    //秘钥
    private String secret;
    private String code;

    {
        setUrl(URL);
    }

    public AccessTokenParam(String appid, String secret, String code) {
        this.appid = appid;
        this.secret = secret;
        this.code = code;
    }

    @Override
    public String getUrl() {
        return new StringBuilder(super.getUrl())
                .append("?appid=")
                .append(getAppid())
                .append("&secret=")
                .append(getSecret())
                .append("&code=")
                .append(getCode())
                .append("&grant_type=authorization_code").toString();
    }

    public String getAppid() {
        return appid;
    }

    public AccessTokenParam setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public AccessTokenParam setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getCode() {
        return code;
    }

    public AccessTokenParam setCode(String code) {
        this.code = code;
        return this;
    }
}

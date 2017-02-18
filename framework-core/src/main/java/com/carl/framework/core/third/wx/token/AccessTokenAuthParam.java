package com.carl.framework.core.third.wx.token;

import com.carl.framework.core.pay.AbsRequestParam;

/**
 * access_token是否有效期 返回BaseResult
 *
 *
 * 正确的Json返回结果：

 { "errcode":0,"errmsg":"ok"}
 错误时的Json返回示例：

 { "errcode":40003,"errmsg":"invalid openid"}
 *
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class AccessTokenAuthParam extends AbsRequestParam {
    public static final String URL = "https://api.weixin.qq.com/sns/auth";
    private String accessToken;
    private String openid;

    {
        setUrl(URL);
    }

    public AccessTokenAuthParam(String accessToken, String openid) {
        this.accessToken = accessToken;
        this.openid = openid;
    }

    @Override
    public String getUrl() {
        return new StringBuilder(super.getUrl())
                .append("?access_token=")
                .append(getAccessToken())
                .append("&openid=").append(getOpenid()).toString();
    }

    public static String getURL() {
        return URL;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public AccessTokenAuthParam setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public AccessTokenAuthParam setOpenid(String openid) {
        this.openid = openid;
        return this;
    }
}
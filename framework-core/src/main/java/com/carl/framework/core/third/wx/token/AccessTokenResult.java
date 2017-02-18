package com.carl.framework.core.third.wx.token;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * token请求结果
 *
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class AccessTokenResult extends BaseResult {
    @JSONField(name = "access_token")
    private String accessToken;

    @JSONField(name = "expires_in")
    private int expiresIn;


    @JSONField(name = "refreshToken")
    private String refresh_token;

    @JSONField(name = "openid")
    private String openid;

    @JSONField(name = "scope")
    private String scope;

    @JSONField(name = "unionid")
    private String unionid;



    public String getAccessToken() {
        return accessToken;
    }

    public AccessTokenResult setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public AccessTokenResult setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public AccessTokenResult setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public AccessTokenResult setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public AccessTokenResult setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getUnionid() {
        return unionid;
    }

    public AccessTokenResult setUnionid(String unionid) {
        this.unionid = unionid;
        return this;
    }
}

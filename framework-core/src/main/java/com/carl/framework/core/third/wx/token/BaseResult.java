package com.carl.framework.core.third.wx.token;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class BaseResult implements Serializable {
    @JSONField(name = "errcode")
    private int errcode;

    @JSONField(name = "errmsg")
    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public BaseResult setErrcode(int errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public BaseResult setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }
}

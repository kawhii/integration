package com.carl.framework.core.third.wx.pay.js;

import org.apache.shiro.crypto.hash.Sha1Hash;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class JSSha1TicketCrypto extends JSTicketCrypto {
    @Override
    public String name() {
        return "js-sha1";
    }

    @Override
    protected Method signType() {
        return Method.SHA1;
    }

    @Override
    protected String fromHexString(String str) {
        return new Sha1Hash(str).toString();
    }
}

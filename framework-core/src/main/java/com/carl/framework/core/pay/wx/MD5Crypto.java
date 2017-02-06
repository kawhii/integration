package com.carl.framework.core.pay.wx;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * MD5 sign加密
 *
 * @author Carl
 * @date 2017/2/6
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public class MD5Crypto extends WXBaseCrypto {
    @Override
    public String name() {
        return "MD5";
    }

    @Override
    protected String fromHexString(String str) {
        return new Md5Hash(str).toString();
    }
}

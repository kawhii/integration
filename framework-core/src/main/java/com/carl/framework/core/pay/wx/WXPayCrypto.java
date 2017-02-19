package com.carl.framework.core.pay.wx;

/**
 * 微信支付支付加密
 * @author Carl
 * @date 2017/2/7
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class WXPayCrypto extends WXBaseCrypto {
    @Override
    protected String appendKeyName() {
        return "key";
    }
}

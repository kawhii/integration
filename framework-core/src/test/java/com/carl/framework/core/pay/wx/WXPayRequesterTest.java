package com.carl.framework.core.pay.wx;

import com.carl.framework.util.UUID;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Create by Administrator on 2017/2/5.
 */
public class WXPayRequesterTest {
    private String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    @Test
    public void request() throws Exception {
        WXPayRequester wxPayRequester = new WXPayRequester();
        DefaultWXPayParam payParam = new DefaultWXPayParam();
        payParam.setAppid("wx6d72707ef14de6c0");
        payParam.setBody("TEST");
        payParam.setMchId("1425675902");
        payParam.setNotifyUrl("http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php");
        payParam.setOutTradeNo("1415659990");
        payParam.setTotalFee(1);
        payParam.setNonceStr("A7B53A81C2C84EC69B8D5CBC3FB93FAB");
        payParam.setTradeType("JSAPI");
        payParam.setSpbillCreateIp("123.12.12.123");
        WXRequestParam requestParam = new WXRequestParam(payParam, url);
        requestParam.setSecKey("1425675902");
        DefaultWXPayResult result = wxPayRequester.request(requestParam, DefaultWXPayResult.class);
        System.out.println(result);
    }
}
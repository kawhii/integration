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
        payParam.setOpenid("o71CQwOCjLONHssbX3zsfJ413FJ4");
        payParam.setAppid("wx6d72707ef14de6c0");
        payParam.setBody("test-t");
        payParam.setMchId("1425675902");
        payParam.setNotifyUrl("http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php");
        payParam.setOutTradeNo("141523659990");
        payParam.setTotalFee(1);
        payParam.setNonceStr(UUID.get());
        payParam.setTradeType("JSAPI");
        payParam.setSignType("MD5");
        payParam.setSpbillCreateIp("123.12.12.1");
        WXRequestParam requestParam = new WXRequestParam(payParam, url);
        requestParam.setSecKey("");
        DefaultWXPayResult result = wxPayRequester.request(requestParam, DefaultWXPayResult.class);
        System.out.println(result);
    }
}
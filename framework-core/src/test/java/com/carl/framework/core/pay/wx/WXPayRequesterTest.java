package com.carl.framework.core.pay.wx;

import com.carl.framework.util.UUID;
import org.junit.Test;
import org.springframework.util.StringUtils;

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
//        payParam.setAttach("支付测试");
        payParam.setBody("TEST");
        payParam.setMchId("1425675902");
//        payParam.setDetail("{ \"goods_detail\":[ { \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, { \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }");
        payParam.setNonceStr("1add1a30ac87aa2db72f57a2375d8fec");
//        payParam.setNotifyUrl("http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php");
        payParam.setSpbillCreateIp("14.23.150.211");
        payParam.setOutTradeNo("1415659990");
        payParam.setTotalFee(1);
        payParam.setNonceStr(UUID.get());
        payParam.setTradeType("JSAPI");
//        payParam.setSign("0CB01533B8C1EF103065174F50BCA001");
        WXRequestParam requestParam = new WXRequestParam(payParam, url);
        requestParam.setSecKey("dd13b7258174e973e2eaa4275d9f2cdd");
        DefaultWXPayResult result = wxPayRequester.request(requestParam, DefaultWXPayResult.class);
        System.out.println(result);
    }
}
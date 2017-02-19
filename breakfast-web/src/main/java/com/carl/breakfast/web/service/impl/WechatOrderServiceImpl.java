package com.carl.breakfast.web.service.impl;

import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.breakfast.web.service.IWechatOrderService;
import com.carl.breakfast.web.utils.UserUtils;
import com.carl.framework.core.execption.BizException;
import com.carl.framework.core.pay.RequestException;
import com.carl.framework.core.pay.crypto.CryptoException;
import com.carl.framework.core.pay.wx.DefaultWXPayParam;
import com.carl.framework.core.pay.wx.DefaultWXPayResult;
import com.carl.framework.core.pay.wx.WXPayRequester;
import com.carl.framework.core.pay.wx.WXRequestParam;
import com.carl.framework.core.third.wx.pay.js.JSChooseWXPay;
import com.carl.framework.core.third.wx.pay.js.JSTicketRequestParam;
import com.carl.framework.core.third.wx.pay.js.JSTicketResult;
import com.carl.framework.core.third.wx.token.AccessTokenResult;
import com.carl.framework.core.third.wx.token.ITokenProvider;
import com.carl.framework.util.UUID;
import com.carl.framework.util.request.IRequester;
import com.carl.framework.util.request.JsonUrlRequester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Service("wechatOrderService")
public class WechatOrderServiceImpl implements IWechatOrderService {

    protected static final Log logger = LogFactory.getLog(WechatOrderServiceImpl.class);

    private WXPayRequester wxPayRequester = new WXPayRequester();

    public static final String ORDER_CREATE_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    //微信appid
    @Value("${wx.appid}")
    private String appId;

    @Value("${wx.mchId}")
    private String mchId;
    @Value("${wx.pay.secret}")
    private String secret;

    @Value("${wx.pay.url}")
    private String payUrl;

    @Value("${wx.pay.orderCreateNotifyUrl}")
    private String orderCreateNotifyUrl;

    @Autowired
    private ITokenProvider tokenProvider;

    @Override
    public DefaultWXPayResult createOrder(OrderPojo param) throws BizException {
        logger.debug("开始调用统一下单接口：" + param.getOrderNo());
        DefaultWXPayParam payParam = new DefaultWXPayParam();
        payParam.setOpenid(UserUtils.currUser().getUsername());
        payParam.setAppid(appId);
        payParam.setBody(getOrderBody(param));
        payParam.setMchId(mchId);
        payParam.setNotifyUrl(orderCreateNotifyUrl);
        payParam.setOutTradeNo(param.getOrderNo());
        payParam.setTotalFee((int) (param.getPrice() * 100));
        payParam.setNonceStr(UUID.get());
        payParam.setTradeType("JSAPI");
        payParam.setSignType("MD5");
        payParam.setSpbillCreateIp("123.12.12.1");
        WXRequestParam requestParam = new WXRequestParam(payParam, ORDER_CREATE_URL);
        requestParam.setSecKey(secret);
        logger.debug("订单【" + param.getOrderNo() + "】需要支付" + (int) (param.getPrice() * 100));
        try {
            DefaultWXPayResult result = wxPayRequester.request(requestParam, DefaultWXPayResult.class);
            return result;
        } catch (RequestException e) {
            logger.error("调用统一下单接口失败：" + param.getOrderNo(), e);
            throw new BizException(e);
        }
    }

    @Override
    public JSChooseWXPay createJSPayParam(DefaultWXPayResult wxPayResult) throws BizException {
        AccessTokenResult tokenResult = tokenProvider.token();

        IRequester<JSTicketRequestParam> jsonUrlRequester = new JsonUrlRequester();
        JSTicketRequestParam jsTicketRequestParam = new JSTicketRequestParam(tokenResult.getAccessToken());
        JSTicketResult jsTicketResult;
        try {
            jsTicketResult = jsonUrlRequester.request(jsTicketRequestParam, JSTicketResult.class);
        } catch (RequestException e) {
            logger.error(e);
            throw new BizException(e);
        }

        JSChooseWXPay.Builder builder = new JSChooseWXPay.Builder()
                .setPackageSrt("prepay_id=" + wxPayResult.getPrepayId())
                .setJsapiTicket(jsTicketResult.getTicket())
                .setTimestamp(Math.toIntExact(new Date().getTime() / 1000))
                .setUrl(payUrl);
        try {
            return builder.build();
        } catch (CryptoException e) {
            logger.error(e);
            throw new BizException(e);
        }
    }

    private String getOrderBody(OrderPojo param) {
        return "包将军早餐";
    }
}

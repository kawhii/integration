package com.carl.breakfast.web.service;

import com.carl.breakfast.dao.pojo.order.OrderPojo;
import com.carl.framework.core.execption.BizException;
import com.carl.framework.core.pay.wx.DefaultWXPayResult;
import com.carl.framework.core.third.wx.pay.js.JSChooseWXPay;

/**
 * 微信订单处理
 *
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public interface IWechatOrderService {

    /**
     * 微信统一下单接口
     *
     * @param param
     * @return
     * @throws BizException
     */
    DefaultWXPayResult createOrder(OrderPojo param) throws BizException;


    /**
     * 创建jspay参数
     * @param wxPayResult
     * @return
     * @throws BizException
     */
    JSChooseWXPay createJSPayParam(DefaultWXPayResult wxPayResult) throws BizException;
}

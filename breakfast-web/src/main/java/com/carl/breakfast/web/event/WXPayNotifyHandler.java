package com.carl.breakfast.web.event;

import com.carl.breakfast.web.service.IOrderService;
import com.carl.framework.core.pay.wx.PayEventName;
import com.carl.framework.core.pay.wx.PayNotifyEvent;
import com.carl.framework.core.pay.wx.PayNotifyParam;
import com.carl.framework.util.EventUtil;
import com.carl.framework.util.MapBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 微信支付回调处理器
 *
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Component
public class WXPayNotifyHandler {
    protected static final Log logger = LogFactory.getLog(WXPayNotifyHandler.class);
    @Autowired
    private IOrderService orderService;

    //事件发布工具
    @Autowired
    private EventUtil eventUtil;

    @EventListener(condition = "#payNotifyEvent.name == '" + PayEventName.ON_PAY_SUCCESS + "'")
    @Async
    public void onWxPaySuccess(PayNotifyEvent payNotifyEvent) {
        logger.debug("微信支付成功，事件机制收到通知，准备处理订单状态。");
        PayNotifyParam notifyParam = payNotifyEvent.getPayNotifyParam();
        //修改支付状态为1
        Map<String, Object> params = MapBuilder.<String, Object>build().p("orderNo", notifyParam.getOutTradeNo())
                .p("username", notifyParam.getOpenid());
        if (orderService.updateOrder(params) == 1) {
            logger.debug("微信支付订单【" + notifyParam.getOutTradeNo() + "】状态处理完成");

            eventUtil.publisherEvent(new PayNotifyEvent("onOrderHandleSuccess", this, payNotifyEvent.getPayNotifyParam()));
        } else {
            logger.warn(String.format("修改订单失败，订单号：%s，用户：%s", notifyParam.getOutTradeNo(), notifyParam.getOpenid()));
        }
    }

    @EventListener(condition = "#payNotifyEvent.name == 'onOrderHandleSuccess'")
    @Async
    public void sendMessageToUser(PayNotifyEvent payNotifyEvent) {
        //TODO 发送消息，支付成功
    }
}

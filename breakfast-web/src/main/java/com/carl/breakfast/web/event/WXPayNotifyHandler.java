package com.carl.breakfast.web.event;

import com.carl.framework.core.pay.wx.PayEventName;
import com.carl.framework.core.pay.wx.PayNotifyEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

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

    @EventListener(condition = "#payNotifyEvent.name == '" + PayEventName.ON_PAY_SUCCESS + "'")
    @Async
    public void onWxPaySuccess(PayNotifyEvent payNotifyEvent) {
        logger.debug("微信支付成功，事件机制收到通知，准备处理订单状态。");
    }
}

package com.carl.breakfast.web.ctrl.buyer;

import com.carl.framework.core.pay.wx.*;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 微信控制器
 *
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Controller
@RequestMapping("/wx")
public class WechatCtrl extends BaseCtrl {
    protected static final Log logger = LogFactory.getLog(WechatCtrl.class);

    @Value("${wx.appid}")
    private String appId;

    @Override
    protected String getModuleName() {
        return "wechart";
    }

    //支付完成回调
    @RequestMapping("/payNotify")
    @ResponseBody
    public WXPayBaseResult payNotify(@RequestBody PayNotifyParam payNotifyParam) {
        PayNotifyEvent event;
        if ("SUCCESS".equals(payNotifyParam.getReturnCode())) {
            logger.info("微信支付回调，用户【" + payNotifyParam.getOpenid() + "】完成对订单【" + payNotifyParam.getOutTradeNo() + "】的支付。");

            if (isWechat(payNotifyParam)) {
                event = new PayNotifyEvent(PayEventName.ON_PAY_SUCCESS, this, payNotifyParam);
                publisherEvent(event);
                return new PayNotifyResult().setReturnCode("SUCCESS").setReturnMsg("OK");
            }
            event = new PayNotifyEvent(PayEventName.ON_PAY_ILLEGAL, this, payNotifyParam);
            logger.warn("非法请求微信回调");
        } else {
            event = new PayNotifyEvent(PayEventName.ON_PAY_FAIL, this, payNotifyParam);
            logger.debug("微信支付回调【" + payNotifyParam.getReturnMsg() + "】");
        }
        publisherEvent(event);
        return null;
    }

    /**
     * 校验是否是微信回调的
     *
     * @param payNotifyParam
     * @return
     */
    private boolean isWechat(PayNotifyParam payNotifyParam) {
        //TODO 安全问题，需要校验是否为微信回调，时间关系先不做
        return payNotifyParam.getAppid().equals(appId);
    }


}

package com.carl.breakfast.web.ctrl.buyer;

import com.carl.breakfast.web.service.IOrderService;
import com.carl.framework.core.pay.wx.*;
import com.carl.framework.ui.ctrl.BaseCtrl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IOrderService orderService;



    @Override
    protected String getModuleName() {
        return "wechart";
    }

    //支付完成回调
    @RequestMapping("/payNotify")
    @ResponseBody
    public WXPayBaseResult payNotify(@RequestBody PayNotifyParam payNotifyParam) {
        PayNotifyEvent event = new PayNotifyEvent(this, payNotifyParam);
        if ("SUCCESS".equals(payNotifyParam.getReturnCode())) {
            logger.info("微信支付回调，用户【" + payNotifyParam.getOpenid() + "】完成对订单【" + payNotifyParam.getOutTradeNo() + "】的支付。");

            if(isWechat(payNotifyParam)) {
                event.setName(PayEventName.ON_PAY_SUCCESS);
                publisherEvent(event);
                return new PayNotifyResult().setResultCode("SUCCESS").setReturnMsg("OK");
            }
            event.setName(PayEventName.ON_PAY_ILLEGAL);
            logger.warn("非法请求微信回调");
        } else {
            event.setName(PayEventName.ON_PAY_FAIL);
            logger.debug("微信支付回调【" + payNotifyParam.getReturnMsg() + "】");
        }
        publisherEvent(event);
        return null;
    }

    /**
     * 校验是否是微信回调的
     * @param payNotifyParam
     * @return
     */
    private boolean isWechat(PayNotifyParam payNotifyParam) {
        //TODO 安全问题，需要校验是否为微信回调，时间关系先不做
        return true;
    }


}

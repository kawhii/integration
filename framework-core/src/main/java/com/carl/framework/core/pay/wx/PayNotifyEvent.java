package com.carl.framework.core.pay.wx;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class PayNotifyEvent extends PayEvent {
    private PayNotifyParam payNotifyParam;

    public PayNotifyEvent(Object source, PayNotifyParam payNotifyParam) {
        super(source);
        this.payNotifyParam = payNotifyParam;
    }

    public PayNotifyEvent(String name, Object source, PayNotifyParam payNotifyParam) {
        super(name, source);
        this.payNotifyParam = payNotifyParam;
    }

    public PayNotifyEvent setPayNotifyParam(PayNotifyParam payNotifyParam) {
        this.payNotifyParam = payNotifyParam;
        return this;
    }
}

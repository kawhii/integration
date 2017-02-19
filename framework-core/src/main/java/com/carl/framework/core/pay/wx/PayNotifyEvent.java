package com.carl.framework.core.pay.wx;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class PayNotifyEvent extends PayEvent {
    private PayNotifyParam payNotifyParam;
    private String name;

    public PayNotifyEvent(String name, Object source, PayNotifyParam payNotifyParam) {
        super(source);
        this.payNotifyParam = payNotifyParam;
        this.name = name;
    }

    public PayNotifyEvent setPayNotifyParam(PayNotifyParam payNotifyParam) {
        this.payNotifyParam = payNotifyParam;
        return this;
    }

    public PayNotifyParam getPayNotifyParam() {
        return payNotifyParam;
    }

    public String getName() {
        return name;
    }

    public PayNotifyEvent setName(String name) {
        this.name = name;
        return this;
    }
}

package com.carl.framework.core.pay.wx;

import com.carl.framework.core.entity.NameEvent;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class PayEvent extends NameEvent {
    private String name;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public PayEvent(String name, Object source) {
        super(source);
        this.name = name;
    }

    public PayEvent(Object source) {
        super(source);
    }

    @Override
    protected String getName() {
        return name;
    }

    public PayEvent setName(String name) {
        this.name = name;
        return this;
    }
}

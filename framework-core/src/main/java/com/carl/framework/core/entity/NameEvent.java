package com.carl.framework.core.entity;

import org.springframework.context.ApplicationEvent;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public abstract class NameEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public NameEvent(Object source) {
        super(source);
    }

    /**
     * 事件名称
     * @return
     */
    protected abstract String getName();
}

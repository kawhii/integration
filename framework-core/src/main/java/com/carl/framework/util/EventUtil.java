package com.carl.framework.util;

import com.carl.framework.core.entity.NameEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Component
public class EventUtil implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }


    public ApplicationEventPublisher getPublisher() {
        return publisher;
    }

    /**
     * 发布广播事件
     * @param event
     */
    public void publisherEvent(NameEvent event) {
        publisher.publishEvent(event);
    }
}

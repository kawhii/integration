package com.carl.breakfast.web.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */

@Component
public class LoadWxAccessTokenTask {
    @Scheduled(cron = "*/5 * * * * *")
    public void loadToken() {
        System.out.println("我要加载token啦...");
        // task execution logic
    }
}

package com.carl.breakfast.web.task;

import com.carl.framework.core.third.wx.pay.js.IJSTicketProvider;
import com.carl.framework.core.third.wx.token.ITokenProvider;
import com.carl.framework.core.third.wx.token.TokenRefreshException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */

@Component
public class LoadWxAccessTokenTask implements ApplicationListener<ContextRefreshedEvent> {
    protected final Log logger = LogFactory.getLog(LoadWxAccessTokenTask.class);


    @Autowired
    private ITokenProvider tokenProvider;
    @Autowired
    private IJSTicketProvider ticketProvider;

    //每1小时执行一次
    @Scheduled(cron = "0 0 */1 * * ?")
    public void loadToken() {
        // task execution logic
        logger.debug("任务执行，刷新access_token");

        try {
            tokenProvider.refresh();
            logger.debug("刷新access_token成功");
            refreshJSTicket(tokenProvider.token().getAccessToken());
        } catch (Exception e) {
            logger.error("执行刷新access_token出错");
            logger.error(e);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            //root application context 没有parent，他就是老大.
            //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            logger.debug("启动完成。");
            loadToken();
        }
    }

    private void refreshJSTicket(String accessToken) throws Exception {
        logger.debug("任务执行，刷新jsticket");
        ticketProvider.refresh(accessToken);
        logger.debug("刷新jsticket成功");
    }
}

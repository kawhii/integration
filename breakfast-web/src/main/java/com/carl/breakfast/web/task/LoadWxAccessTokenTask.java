package com.carl.breakfast.web.task;

import com.carl.framework.core.third.wx.token.ITokenProvider;
import com.carl.framework.core.third.wx.token.TokenRefreshException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */

@Component
public class LoadWxAccessTokenTask {
    protected final Log logger = LogFactory.getLog(LoadWxAccessTokenTask.class);


    @Autowired
    private ITokenProvider tokenProvider;

    @Scheduled(cron = "*/30 * * * * *")
    public void loadToken() {
        // task execution logic
        logger.debug("任务执行，刷新access_token");

        try {
            tokenProvider.refresh();
            logger.debug("刷新access_token成功");
        } catch (TokenRefreshException e) {
            logger.error("执行刷新access_token出错");
            logger.error(e);
        }
    }
}

package com.carl.breakfast.web.config.wx;

import com.carl.framework.core.third.wx.token.AccessTokenTradeParam;
import com.carl.framework.core.third.wx.token.DefaultTokenProvider;
import com.carl.framework.core.third.wx.token.ITokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
@Configuration
public class WXConfig {
    /**
     * access 提供者
     *
     * @param appId
     * @param secret
     * @return
     */
    @Bean
    public ITokenProvider tokenProvider(@Value("${wx.appid}") String appId, @Value("${wx.secret}") String secret) {
        AccessTokenTradeParam param = new AccessTokenTradeParam(appId, secret);
        return new DefaultTokenProvider().setParam(param);
    }
}

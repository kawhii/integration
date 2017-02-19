package com.carl.framework.core.third.wx.token;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/2/19.
 */
public class DefaultTokenProviderTest {

    @Test
    public void refresh() throws Exception {
        DefaultTokenProvider provider = new DefaultTokenProvider();
        //需要秘钥
        AccessTokenTradeParam param = new AccessTokenTradeParam("wx6d72707ef14de6c0", "");
        provider.setParam(param);

//        provider.refresh();
        System.out.println(provider.token());
    }
}
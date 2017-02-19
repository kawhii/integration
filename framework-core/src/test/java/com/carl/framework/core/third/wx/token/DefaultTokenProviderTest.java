package com.carl.framework.core.third.wx.token;

import com.carl.framework.core.third.wx.pay.js.JSTicketRequestParam;
import com.carl.framework.core.third.wx.pay.js.JSTicketResult;
import com.carl.framework.util.request.IRequester;
import com.carl.framework.util.request.JsonUrlRequester;
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
        AccessTokenResult tokenResult = provider.token();
//        AccessTokenResult tokenResult = new AccessTokenResult().setAccessToken("123123");
        /*IRequester<JSTicketRequestParam> jsonUrlRequester = new JsonUrlRequester();
        JSTicketRequestParam jsTicketRequestParam = new JSTicketRequestParam(tokenResult.getAccessToken());
        JSTicketResult jsTicketResult = jsonUrlRequester.request(jsTicketRequestParam, JSTicketResult.class);
        System.out.println(jsTicketResult);*/
    }
}
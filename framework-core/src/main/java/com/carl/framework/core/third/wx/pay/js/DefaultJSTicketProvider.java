package com.carl.framework.core.third.wx.pay.js;

import com.carl.framework.core.pay.RequestException;
import com.carl.framework.util.request.IRequester;
import com.carl.framework.util.request.JsonUrlRequester;

/**
 * @author Carl
 * @date 2017/2/19
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class DefaultJSTicketProvider implements IJSTicketProvider {
    private IRequester<JSTicketRequestParam> jsonUrlRequester = new JsonUrlRequester();
    private JSTicketResult result;

    @Override
    public JSTicketResult ticket() {
        return result;
    }

    @Override
    public void refresh(String accessToken) throws TicketRefreshException {

        JSTicketRequestParam jsTicketRequestParam = new JSTicketRequestParam(accessToken);
        try {
            result = jsonUrlRequester.request(jsTicketRequestParam, JSTicketResult.class);
        } catch (RequestException e) {
            throw new TicketRefreshException(e);
        }
    }

    @Override
    public boolean isExpires() {
        return false;
    }
}

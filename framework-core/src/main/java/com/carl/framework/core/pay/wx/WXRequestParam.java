package com.carl.framework.core.pay.wx;

import com.carl.framework.core.pay.AbsRequestParam;

/**
 * 微信接口请求参数
 *
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class WXRequestParam extends AbsRequestParam {
    private boolean sync = true;
    private WXPayBaseParam body;

    public WXRequestParam(WXPayBaseParam body, String url) {
        this.body = body;
        setUrl(url);
    }

    public boolean isSync() {
        return sync;
    }

    public WXRequestParam setSync(boolean sync) {
        this.sync = sync;
        return this;
    }

    public WXPayBaseParam getBody() {
        return body;
    }

    public WXRequestParam setBody(WXPayBaseParam body) {
        this.body = body;
        return this;
    }
}

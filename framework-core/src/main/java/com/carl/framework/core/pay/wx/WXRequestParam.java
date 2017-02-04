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
    private String url;
    private boolean sync = true;
    private Object body;

    public String getUrl() {
        return url;
    }

    public WXRequestParam setUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isSync() {
        return sync;
    }

    public WXRequestParam setSync(boolean sync) {
        this.sync = sync;
        return this;
    }

    public Object getBody() {
        return body;
    }

    public WXRequestParam setBody(Object body) {
        this.body = body;
        return this;
    }
}

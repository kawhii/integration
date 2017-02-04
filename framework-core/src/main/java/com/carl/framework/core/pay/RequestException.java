package com.carl.framework.core.pay;

/**
 * 请求一次
 * @author Carl
 * @date 2017/2/5
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class RequestException extends Exception {
    private AbsRequestParam param;

    public AbsRequestParam getParam() {
        return param;
    }

    public RequestException setParam(AbsRequestParam param) {
        this.param = param;
        return this;
    }

    public RequestException() {
    }

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }

    public RequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

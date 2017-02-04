package com.carl.framework.core.pay;

/**
 * 支付异常
 * @author Carl
 * @date 2017/2/4
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class PayException extends Exception {

    private String payCode;

    public String getPayCode() {
        return payCode;
    }

    public PayException setPayCode(String payCode) {
        this.payCode = payCode;
        return this;
    }

    public PayException(String message) {
        super(message);
    }

    public PayException(String message, Throwable cause) {
        super(message, cause);
    }

    public PayException(Throwable cause) {
        super(cause);
    }

    public PayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.carl.framework.core.third.wx.pay.js;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class TicketRefreshException extends Exception {
    public TicketRefreshException() {
    }

    public TicketRefreshException(String message) {
        super(message);
    }

    public TicketRefreshException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketRefreshException(Throwable cause) {
        super(cause);
    }

    public TicketRefreshException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

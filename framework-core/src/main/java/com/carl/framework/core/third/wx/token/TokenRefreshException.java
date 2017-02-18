package com.carl.framework.core.third.wx.token;

/**
 * @author Carl
 * @date 2017/2/18
 * 版权所有.(c)2017 - 2020. 卡尔工作室
 */
public class TokenRefreshException extends Exception {
    public TokenRefreshException() {
    }

    public TokenRefreshException(String message) {
        super(message);
    }

    public TokenRefreshException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenRefreshException(Throwable cause) {
        super(cause);
    }

    public TokenRefreshException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

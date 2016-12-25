package com.carl.framework.core.functional;

/**
 * @author Carl
 * @date 2016/12/26
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class WriterException extends Exception {
    public WriterException() {
    }

    public WriterException(String message) {
        super(message);
    }

    public WriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WriterException(Throwable cause) {
        super(cause);
    }

    public WriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

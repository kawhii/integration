package com.carl.framework.core.pio;

/**
 * @author Carl
 * @date 2016/12/24
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class ExportRealInfoException extends Exception {
    public ExportRealInfoException() {
    }

    public ExportRealInfoException(String message) {
        super(message);
    }

    public ExportRealInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExportRealInfoException(Throwable cause) {
        super(cause);
    }

    public ExportRealInfoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

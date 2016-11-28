package com.carl.framework.core.file;

/**
 * 文件保存一次
 * @author Carl
 * @date 2016/11/29
 * © 2016 - 2020 , all rights reserved .卡尔工作室
 */
public class FileSaveException extends Exception {
    public FileSaveException() {
    }

    public FileSaveException(String message) {
        super(message);
    }

    public FileSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSaveException(Throwable cause) {
        super(cause);
    }

    public FileSaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

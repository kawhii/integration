package com.carl.framework.core.functional;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出接口
 *
 * @author Carl
 * @date 2016/12/26
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface IWriter {
    /**
     * 写出目的地
     * @param outputStream
     * @throws IOException
     */
    void write(OutputStream outputStream) throws WriterException;
}

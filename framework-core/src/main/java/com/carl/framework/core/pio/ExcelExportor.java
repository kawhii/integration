package com.carl.framework.core.pio;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * excel 导出
 *
 * @author Carl
 * @date 2016/12/24
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface ExcelExportor {

    /**
     * 导出
     * @param data 数据
     * @param mapper 数据以及头部的映射关系
     * @param output 输出目的地
     * @throws IOException
     */
    void export(List<Map<String, Object>> data, ExportRealInfo mapper, OutputStream output) throws IOException;
}

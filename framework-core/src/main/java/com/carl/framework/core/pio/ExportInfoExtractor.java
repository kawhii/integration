package com.carl.framework.core.pio;

/**
 * 导出信息提取者
 *
 * @author Carl
 * @date 2016/12/24
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public interface ExportInfoExtractor {
    /**
     * 执行id
     * @param id 源id
     * @return
     */
    ExportRealInfo extract(String id) throws ExportRealInfoException;
}

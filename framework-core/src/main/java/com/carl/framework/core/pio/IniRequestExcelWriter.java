package com.carl.framework.core.pio;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * ini请求的excel输出
 *
 * @author Carl
 * @date 2016/12/26
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class IniRequestExcelWriter extends RequestExcelWriter {
    public static final String DEF_INI_FILE = "classpath:config/excel-export.ini";

    /**
     * ini请求
     *
     * @param data        数据
     * @param selectionId ini选项
     * @param file        ini文件
     */
    public IniRequestExcelWriter(List<Map<String, Object>> data, String selectionId, File file) throws FileNotFoundException {
        super(data);
        setSelectionId(selectionId);
        setInfoExtractor(new IniExportInfoExtractor(new FileInputStream(file)));
    }

    /**
     * ini请求
     *
     * @param data        数据
     * @param selectionId ini选项
     */
    public IniRequestExcelWriter(List<Map<String, Object>> data, String selectionId, String filePath) throws FileNotFoundException {
        this(data, selectionId, ResourceUtils.getFile(filePath));
    }

    /**
     * ini请求
     *
     * @param data        数据
     * @param selectionId ini选项
     */
    public IniRequestExcelWriter(List<Map<String, Object>> data, String selectionId) throws FileNotFoundException {
        this(data, selectionId, DEF_INI_FILE);
    }

}

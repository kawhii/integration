package com.carl.framework.util;

import com.carl.framework.core.functional.IWriter;
import com.carl.framework.core.pio.ExportRealInfo;
import com.carl.framework.core.pio.ExportRealInfoException;
import com.carl.framework.core.pio.IniExportInfoExtractor;
import com.carl.framework.core.pio.RequestExcelWriter;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * excel 操作
 *
 * @author Carl
 * @date 2016/12/28
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public abstract class Excel {
    /**
     * 使用ini配置文件到处excel
     *
     * @param data
     * @param iniPath
     * @param iniSelectionId
     * @param response
     * @throws Exception
     */
    public static void export2Response4Ini(List<Map<String, Object>> data, String iniPath,
                                           String iniSelectionId, HttpServletResponse response) throws Exception {
        IniExportInfoExtractor infoExtractor = new IniExportInfoExtractor(iniPath);
        ExportRealInfo realInfo = infoExtractor.extract(iniSelectionId);
        String name = realInfo.getFileName();
        // 生成提示信息，
        response.setContentType("application/vnd.ms-excel");
        // 进行转码，使其支持中文文件名
        String codedFileName = java.net.URLEncoder.encode(name, "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");

        //获取配置文件
        IWriter writer = new RequestExcelWriter(data, realInfo);
        writer.write(response.getOutputStream());
    }
}

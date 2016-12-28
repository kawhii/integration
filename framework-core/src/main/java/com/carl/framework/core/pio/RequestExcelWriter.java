package com.carl.framework.core.pio;

import com.carl.framework.core.functional.IWriter;
import com.carl.framework.core.functional.WriterException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 输出excel
 *
 * @author Carl
 * @date 2016/12/26
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public class RequestExcelWriter implements IWriter {
    private List<Map<String, Object>> data;
    private ExcelExportor excelExportor = new DefaultExcelExportor();//导出执行者

    private ExportRealInfo exportRealInfo;

    /**
     * @param data 数据
     */
    public RequestExcelWriter(List<Map<String, Object>> data, ExportRealInfo exportRealInfo) {

        this.data = data;
        this.exportRealInfo = exportRealInfo;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public RequestExcelWriter setData(List<Map<String, Object>> data) {
        this.data = data;
        return this;
    }

    public ExcelExportor getExcelExportor() {
        return excelExportor;
    }

    public RequestExcelWriter setExcelExportor(ExcelExportor excelExportor) {
        this.excelExportor = excelExportor == null ? excelExportor : new DefaultExcelExportor();
        return this;
    }

    @Override
    public void write(OutputStream outputStream) throws WriterException {
        try {
            check();
            getExcelExportor().export(getData(), exportRealInfo, outputStream);
        } catch (Exception ex) {
            throw new WriterException(ex);
        }
    }

    private void check() throws Exception {
        if (this.getExcelExportor() == null) {
            throw new WriterException("导出选项");
        }
        if (this.exportRealInfo == null) {
            throw new WriterException("关系数据异常");
        }
    }
}

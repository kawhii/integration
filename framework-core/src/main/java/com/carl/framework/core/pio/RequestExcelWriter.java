package com.carl.framework.core.pio;

import com.carl.framework.core.functional.IWriter;
import com.carl.framework.core.functional.WriterException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;
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
    private ExportInfoExtractor infoExtractor;//导出信息提取
    private ExcelExportor excelExportor = new DefaultExcelExportor();//导出执行者
    private String selectionId;//导出信息提取选项


    /**
     * @param data        数据
     */
    public RequestExcelWriter(List<Map<String, Object>> data) {

        this.data = data;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public RequestExcelWriter setData(List<Map<String, Object>> data) {
        this.data = data;
        return this;
    }

    public ExportInfoExtractor getInfoExtractor() {
        return infoExtractor;
    }

    public RequestExcelWriter setInfoExtractor(ExportInfoExtractor infoExtractor) {
        this.infoExtractor = infoExtractor;
        return this;
    }

    public ExcelExportor getExcelExportor() {
        return excelExportor;
    }

    public RequestExcelWriter setExcelExportor(ExcelExportor excelExportor) {
        this.excelExportor = excelExportor == null ? excelExportor : new DefaultExcelExportor();
        return this;
    }

    public String getSelectionId() {
        return selectionId;
    }

    public RequestExcelWriter setSelectionId(String selectionId) {
        this.selectionId = selectionId;
        return this;
    }

    @Override
    public void write(OutputStream outputStream) throws WriterException {
        try {
            check();
            HttpServletResponse response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();

            ExportRealInfo exportRealInfo = getInfoExtractor().extract(getSelectionId());

            String name = exportRealInfo.getFileName();
            // 生成提示信息，
            response.setContentType("application/vnd.ms-excel");
            // 进行转码，使其支持中文文件名
            String codedFileName = java.net.URLEncoder.encode(name, "UTF-8");
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");

            getExcelExportor().export(getData(), exportRealInfo, outputStream);
        } catch (Exception ex) {
            throw new WriterException(ex);
        }
    }

    private void check() throws Exception {
        if(this.getExcelExportor() == null) {
            throw new WriterException("导出执行者为空");
        }

        if(this.getSelectionId() == null) {
            throw new WriterException("导出选项");
        }

        if(getInfoExtractor() == null) {
            throw new WriterException("导出信息提取");
        }
    }
}

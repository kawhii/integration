package com.carl.framework.core.pio;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 从基础的excel输出，主要写了头部的输出
 *
 * @author Carl
 * @date 2016/12/25
 * 版权所有.(c)2016 - 2020. 卡尔工作室
 */
public abstract class AbstractExcelWriter implements ExcelExportor {
    //是否写头部
    private boolean writeHeader = true;

    public AbstractExcelWriter(boolean writeHeader) {
        this.writeHeader = writeHeader;
    }

    /**
     * 写header
     *
     * @param sheet
     * @param names
     */
    protected void writeHeaderRow(Sheet sheet, String[] names) {
        Row row = sheet.createRow(0);
        for (int i = 0, l = names.length; i < l; i++) {
            row.createCell(i).setCellValue(names[i]);
        }
    }

    @Override
    public void export(List<Map<String, Object>> data, ExportRealInfo mapper, OutputStream output) throws IOException {
        //是否写头
        int startIndex = isWriteHeader() ? 1 : 0;

        Workbook wb = new HSSFWorkbook();
        //Workbook wb = new XSSFWorkbook();

        Sheet sheet = wb.createSheet();
        if (isWriteHeader()) {
            writeHeaderRow(sheet, mapper.getHeaderName());
        }

        int index = startIndex;
        //写数据
        for (Map<String, Object> item : data) {
            //创建行
            Row row = sheet.createRow(index);
            //列
            int cellIndex = 0;
            for (String key : mapper.getColumnName()) {
                Cell cell = row.createCell(cellIndex);
                Object val = item.get(key);
                //写列，如果为null设为空
                cell.setCellValue(val == null ? "" : val.toString());
                cellIndex++;
            }
            index++;
        }
        wb.write(output);
    }

    protected boolean isWriteHeader() {
        return this.writeHeader;
    }
}
